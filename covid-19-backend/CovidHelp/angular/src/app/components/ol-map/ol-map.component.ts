import {Component, OnInit} from '@angular/core';

import Map from 'ol/Map';
import View from 'ol/View';
import TileLayer from 'ol/layer/Tile';

import XYZ from 'ol/source/XYZ';
import {Vector} from "ol/source";
import Heatmap from "ol/layer/Heatmap";
import {fromLonLat} from "ol/proj";
import {Feature} from "ol";
import Point from "ol/geom/Point";
import {defaults as defaultControls} from 'ol/control';
import OverviewMap from "ol/control/OverviewMap";
import ScaleLine from "ol/control/ScaleLine";
import Stamen from "ol/source/Stamen";
import FullScreen from "ol/control/FullScreen";
import Fill from "ol/style/Fill";
import Stroke from "ol/style/Stroke";
import Style from "ol/style/Style";
import VectorSource from "ol/source/Vector";
import VectorLayer from "ol/layer/Vector";
import GeoJSON from "ol/format/GeoJSON";

@Component({
  selector: 'ngx-ol-map',
  templateUrl: './ol-map.component.html',
  styleUrls: ['./ol-map.component.scss']
})
export class OlMapComponent implements OnInit {
  public map: Map;
  private initialized: boolean;

  private heatLayer: Heatmap;

  constructor() {
  }


  addHeatmapPoint(lat: number, lon: number, weight: number) {
    const feature = new Feature({
      geometry: new Point(fromLonLat([lon, lat]), weight)
    });
    this.heatLayer.getSource().addFeature(feature);
  }


  ngOnInit() {
    if (!this.initialized) {
      this.initialized = true;

      this.heatLayer = new Heatmap({
        source: new Vector(),
      });

      const overviewMapControl = new OverviewMap({
        layers: [
          new TileLayer({
            source: new XYZ({
              url: 'https://{a-c}.tile.openstreetmap.org/{z}/{x}/{y}.png'
            })
          }),
        ],
      });
      this.map = new Map({
        target: 'map',
        controls: defaultControls().extend([
          overviewMapControl,
          new ScaleLine(),
          new FullScreen(),

        ]),
        layers: [
          new TileLayer({
            source: new Stamen({
              layer: 'terrain-labels'
            }),
          }),
          new TileLayer({
            source: new XYZ({
              url: 'https://{a-c}.tile.openstreetmap.org/{z}/{x}/{y}.png'
            }),
          }),
          this.createCountriesLayer(),
          this.heatLayer,
        ],
        view: new View({
          center: fromLonLat([21, 52]),
          zoom: 10
        })
      });

    }


  }


  createCountriesLayer() {
    const style = new Style({
      fill: new Fill({
        color: 'rgba(255, 255, 255, 0.6)'
      }),
      stroke: new Stroke({
        color: '#319FD3',
        width: 1
      }),
      text: new Text({
        font: '12px Calibri,sans-serif',
        fill: new Fill({
          color: '#000'
        }),
        stroke: new Stroke({
          color: '#fff',
          width: 3
        })
      })
    });
    return new VectorLayer({
      source: new VectorSource({
        url: 'assets/data/world.json',
        format: new GeoJSON()
      }),

    });
  }
}
