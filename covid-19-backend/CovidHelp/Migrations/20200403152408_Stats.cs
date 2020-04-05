using Microsoft.EntityFrameworkCore.Migrations;
using NetTopologySuite.Geometries;

namespace CovidHelp.Migrations
{
    public partial class Stats : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "Country",
                table: "InfectedStatistics");

            migrationBuilder.DropColumn(
                name: "Location",
                table: "InfectedStatistics");

            migrationBuilder.AddColumn<long>(
                name: "DoctorId",
                table: "Users",
                nullable: true);

            migrationBuilder.AddColumn<string>(
                name: "UserImage",
                table: "Users",
                nullable: true);

            migrationBuilder.AddColumn<long>(
                name: "CityId",
                table: "UserLocations",
                nullable: true);

            migrationBuilder.AddColumn<long>(
                name: "CountryId",
                table: "UserLocations",
                nullable: true);

            migrationBuilder.AddColumn<long>(
                name: "CountryId",
                table: "InfectedStatistics",
                nullable: false,
                defaultValue: 0L);

            migrationBuilder.CreateIndex(
                name: "IX_Users_DoctorId",
                table: "Users",
                column: "DoctorId");

            migrationBuilder.CreateIndex(
                name: "IX_UserLocations_CityId",
                table: "UserLocations",
                column: "CityId");

            migrationBuilder.CreateIndex(
                name: "IX_UserLocations_CountryId",
                table: "UserLocations",
                column: "CountryId");

            migrationBuilder.CreateIndex(
                name: "IX_InfectedStatistics_CountryId",
                table: "InfectedStatistics",
                column: "CountryId");

            migrationBuilder.AddForeignKey(
                name: "FK_InfectedStatistics_Countries_CountryId",
                table: "InfectedStatistics",
                column: "CountryId",
                principalTable: "Countries",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_UserLocations_Cities_CityId",
                table: "UserLocations",
                column: "CityId",
                principalTable: "Cities",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);

            migrationBuilder.AddForeignKey(
                name: "FK_UserLocations_Countries_CountryId",
                table: "UserLocations",
                column: "CountryId",
                principalTable: "Countries",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);

            migrationBuilder.AddForeignKey(
                name: "FK_Users_Users_DoctorId",
                table: "Users",
                column: "DoctorId",
                principalTable: "Users",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_InfectedStatistics_Countries_CountryId",
                table: "InfectedStatistics");

            migrationBuilder.DropForeignKey(
                name: "FK_UserLocations_Cities_CityId",
                table: "UserLocations");

            migrationBuilder.DropForeignKey(
                name: "FK_UserLocations_Countries_CountryId",
                table: "UserLocations");

            migrationBuilder.DropForeignKey(
                name: "FK_Users_Users_DoctorId",
                table: "Users");

            migrationBuilder.DropIndex(
                name: "IX_Users_DoctorId",
                table: "Users");

            migrationBuilder.DropIndex(
                name: "IX_UserLocations_CityId",
                table: "UserLocations");

            migrationBuilder.DropIndex(
                name: "IX_UserLocations_CountryId",
                table: "UserLocations");

            migrationBuilder.DropIndex(
                name: "IX_InfectedStatistics_CountryId",
                table: "InfectedStatistics");

            migrationBuilder.DropColumn(
                name: "DoctorId",
                table: "Users");

            migrationBuilder.DropColumn(
                name: "UserImage",
                table: "Users");

            migrationBuilder.DropColumn(
                name: "CityId",
                table: "UserLocations");

            migrationBuilder.DropColumn(
                name: "CountryId",
                table: "UserLocations");

            migrationBuilder.DropColumn(
                name: "CountryId",
                table: "InfectedStatistics");

            migrationBuilder.AddColumn<string>(
                name: "Country",
                table: "InfectedStatistics",
                type: "nvarchar(max)",
                nullable: true);

            migrationBuilder.AddColumn<Point>(
                name: "Location",
                table: "InfectedStatistics",
                type: "geography",
                nullable: true);
        }
    }
}
