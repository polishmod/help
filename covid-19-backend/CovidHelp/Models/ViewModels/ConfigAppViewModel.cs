using NetCoreCommons.DynamicForms.Models;
using CovidHelp.Models.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CovidHelp.Models.ViewModels
{
    public class ConfigAppViewModel
    {
        public string Version { get; set; }
        public IEnumerable<ModelTypes> AllModelTypes { get; set; }
        public IEnumerable<ModelFieldDefinitionViewModel> Models { get; set; }
    }
}
