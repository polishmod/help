#See https://aka.ms/containerfastmode to understand how Visual Studio uses this Dockerfile to build your images for faster debugging.

FROM mcr.microsoft.com/dotnet/core/aspnet:3.1 as base
WORKDIR /app
EXPOSE 80
EXPOSE 443

LABEL VERSION="1.0"
FROM mcr.microsoft.com/dotnet/core/sdk:3.1 AS build



WORKDIR /src
RUN sed -i 's/DEFAULT@SECLEVEL=2/DEFAULT@SECLEVEL=1/g' /etc/ssl/openssl.cnf
RUN sed -i 's/DEFAULT@SECLEVEL=2/DEFAULT@SECLEVEL=1/g' /usr/lib/ssl/openssl.cnf

COPY ["CovidHelp/CovidHelp.csproj", "CovidHelp/"]
COPY ./nuget.config .
RUN dotnet restore "CovidHelp/CovidHelp.csproj"
COPY . .
WORKDIR "/src/CovidHelp"
RUN dotnet build "CovidHelp.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "CovidHelp.csproj" -c Release -o /app/publish


FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "CovidHelp.dll"]