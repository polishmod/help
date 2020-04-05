using CovidHelp.Models.ViewModels;
using FirebaseAdmin;
using FirebaseAdmin.Messaging;
using Google.Apis.Auth.OAuth2;
using NetCoreCommons.Database.Services.CrudService;
using NetCoreCommons.DI.Services;
using NetCoreCommons.Security.Models.Auth;
using NetCoreCommons.Shared.Services;
using System;
using System.Collections.Generic;
using System.Linq;

namespace CovidHelp.Services.Integrations
{
  public static class FirebaseService
  {
    public static FirebaseApp DEFAULT_APP { get; }
    private static string ACCESS_JSON = @"{
  'type': 'service_account',
  'project_id': 'help-b26ff',
  'private_key_id': 'f4777d6721a3bd23ad2f20aa513b8ef7244162d3',
  'private_key': '-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCkodOLSYwma5RE\nubnVMkiv3hCgMXW1oVWX24D2n16/3fzmJME6vIZOmhrlrz9af0mq/tG+oO5Eybyr\nCLfBupQIasDP2/czrJXB+KdiEAkA4YsIqa+kN1GL/V90XQJwE0EQNsLRH6WPQVOY\nT2zR0mr1wX5D4Qx9PqEeLz7Dti6Cw1NDyDgzGSfZGtunMj3oQ54SJoPhJwhsnJI+\ndgWVf5Nsbl3MEsEsDlx4R98JvSCALWwp0I/wA2TfW/d5Dxlj4TH+CY6PnJKs4IuA\nNyF1G0AxoHLMXYCHtUkAebPzzGUvBcfORfdwY+xiXOJtRsnFqEsykGN7dyNecwvq\nC+CgOwBnAgMBAAECggEARpt/GnhvKtUt0HHlURoRUZgIgmPkC4OHrar/OwasANcI\nzX3K/9F2OsTeL08DeWEpK7TBKSRlPExXZfVFtkk6jweV7S/2bAujaP8nbqfY7K9O\nzWbVRTVSfJss8r+nOYEQgQ8za7RKcc+/Ng4uaij4JbGYYS1miVqwiD0UCqUaeory\nAQbP/qHn5zutdhiJwUHrHEpvdCPRBUZSddz0qU1EJoyqCMEN9meOnUEZsaLjpJUC\ntkgYRcLBHKHEHjDitiMIjCxNTQoLkO6zd+tCY+PcBwiTLIb+YbEQ/E8pKdeU64bn\nki9amF1KQA62B/s7Z69BOo3diMQVkDOEJqsMDivv2QKBgQDTgBkpPqclV6IdESlI\nSE3k4cuhnIt0zb4tcPBL9MWXMvr2Li6O4ipnjY7ryqaJdCQ441I+RsL1eSJmFEld\nVp1w4NZDQT7cG5/uP2lkUNfVpKJTgDXJzGb+GrvquPDeQ9N5OdfLuL+c4DFuMGjU\npZeUlk2BNCYgLtL/9+6MU+1cGQKBgQDHRUuZnlFHv0lCO8tF6anzljZyDbZGY6/l\nVhK6inQtourTnm2OGws5prroqlw2dnEnslLQjba4cOoCHP9lw3KSYAM9vcnw9VF/\nJDBsr411pSerqaxk0ElMwa6P/clyCt7sX4hMeyJ2gVrdRvzwZPu07oXaeM/sX2sJ\nGQ21DJbQfwKBgH7oxbBPDQLGQ9uHOatK35qwtnzCL5gmALDJrRcWyB3DFH32Fi/c\nnC9I7PKlxiqCi12rYeVGlqOvTSnNkHw2hgB+mXL/ypVO6jeOy1HLhMeIo3LRYvU0\n9rQRHKNq1/W240VBpTB0Kl4a1O5WlADNYFhjnBwkS6BSGIBJqFWB4tK5AoGBAKGh\nnW6fMcKGb7+fjIPKwiVoRAVDBgQWO8hDhrF0OEQED4FS0f4gBXzftl+eP2mVrLbM\nN8weBoWYYNcR+j7qx3XfFwHvfWtLMK12BylBQ/aW3ZSp7cFgCPSPbS4yZkFwe90y\np/WRMyT4S2GMgQHkhx39EulgcRaDVuhsP+gIrBO1AoGAZVOjCS0dO4CLrS2zs9QE\nDvg40dKp6ZI1mYx/QSNfchjPohHc8td6K3LYAVfcLDLc3BGYLk8f9tIH4ySRaGTp\njDY0TojFvxuK3NKnpB/w3sz5VHbuG4UhhXsOy9rzjf3fvM3mte6giBoVopwMV31D\nSa5zhuAmjO3vdFbV0a6gagc=\n-----END PRIVATE KEY-----\n',
  'client_email': 'firebase-adminsdk-nkzu5@help-b26ff.iam.gserviceaccount.com',
  'client_id': '102086997077175457506',
  'auth_uri': 'https://accounts.google.com/o/oauth2/auth',
  'token_uri': 'https://oauth2.googleapis.com/token',
  'auth_provider_x509_cert_url': 'https://www.googleapis.com/oauth2/v1/certs',
  'client_x509_cert_url': 'https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-nkzu5%40help-b26ff.iam.gserviceaccount.com'
}";



    static FirebaseService()
    {
      DEFAULT_APP = FirebaseApp.Create(new AppOptions()
      {
        Credential = GoogleCredential.FromJson(ACCESS_JSON)
      });
    }
    public static bool SendNotifiction(FirebaseNotificationViewModel notification, AuthenticatedUserViewModel authenticatedUser)
    {
      var user = DependencyInjector.GetService<IUsersService<AppUserViewModel>>().GetById(notification.ToUserId, authenticatedUser);
      if (user.FcmTokens.Any())
      {
        SendNotifiction(user.FcmTokens, new Dictionary<string, string>() {
                        {"title", notification.Title},
                        {"body",  notification.Message },
                        {  "type",notification.Type.ToString().ToUpper()},
                        {  "sound","default"},
                        {  "click_action","FCM_PLUGIN_ACTIVITY"},
                        {  "icon","fcm_push_icon"},
                     }, authenticatedUser);
        return true;
      }
      else
      {
        ApplicationLogger.LogDebug(typeof(FirebaseService), $"Cant send notification to user {user.Email} {user.Id} because doesnt have fcm tokens");
        return false;
      }

    }
    public static bool SendTestToUser(string fcmToken, string token, AuthenticatedUserViewModel authenticatedUser)
    {

      SendNotifiction(new string[] { fcmToken }, new Dictionary<string, string>() {
                        {"title", "etes title" },
                        {"body",  $"TEst dsada s" },

                        {  "sound","default"},
                        {  "click_action","FCM_PLUGIN_ACTIVITY"},
                        {  "icon","fcm_push_icon"},
                     }, authenticatedUser);
      return true;
    }

    public static async void SendNotifiction(IEnumerable<string> registrationTokens, Dictionary<string, string> data, AuthenticatedUserViewModel authenticatedUser)
    {
      try
      {
        if (registrationTokens != null && registrationTokens.Any())
        {
          var message = new MulticastMessage()
          {

            Tokens = registrationTokens.ToList(),
            Data = data,
            Android = new AndroidConfig()
            {
              Notification = new AndroidNotification()
              {
                ClickAction = "FCM_PLUGIN_ACTIVITY"
              }
            },
            Notification = new Notification()
            {
              Title = data["title"],
              Body = data["body"],

            }
          };

          var response = await FirebaseMessaging.GetMessaging(DEFAULT_APP).SendMulticastAsync(message);
          // See the BatchResponse reference documentation
          // for the contents of response.
          Console.WriteLine($"{response.SuccessCount} messages were sent successfully");
        }
      }
      catch (Exception ex)
      {
        ApplicationLogger.LogError(typeof(FirebaseService), "Error with sending notification", ex);
        throw ex;
      }



    }
  }
}
