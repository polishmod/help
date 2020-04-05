#See https://aka.ms/containerfastmode to understand how Visual Studio uses this Dockerfile to build your images for faster debugging.

FROM mcr.microsoft.com/dotnet/core/aspnet:3.1-bionic AS base
WORKDIR /app
EXPOSE 80
EXPOSE 443

LABEL VERSION="1.0"
FROM mcr.microsoft.com/dotnet/core/sdk:3.1-bionic AS build
RUN dotnet tool install --global dotnet-ef --version 3.1.0


WORKDIR /src
COPY ["Glukotrend/Glukotrend.csproj", "Glukotrend/"]
COPY ./nuget.config .
RUN dotnet restore "Glukotrend/Glukotrend.csproj"
COPY . .
WORKDIR "/src/Glukotrend"
RUN dotnet build "Glukotrend.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "Glukotrend.csproj" -c Release -o /app/publish

FROM base AS final
WORKDIR /app/uploads
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "Glukotrend.dll"]
