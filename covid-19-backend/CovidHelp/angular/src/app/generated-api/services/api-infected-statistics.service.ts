/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { InfectedStatisticsViewModelIEnumerableApiResponse } from '../models/infected-statistics-view-model-ienumerable-api-response';
import { InfectedStatisticsViewModelApiResponse } from '../models/infected-statistics-view-model-api-response';
import { InfectedStatisticsViewModel } from '../models/infected-statistics-view-model';
import { Int64InfectedStatisticsViewModelBulkUpdateParams } from '../models/int-64infected-statistics-view-model-bulk-update-params';
import { InfectedStatisticsViewModelFormModelApiResponse } from '../models/infected-statistics-view-model-form-model-api-response';
import { FilterRule } from '../models/filter-rule';
import { InfectedStatisticsViewModelPagedListApiResponse } from '../models/infected-statistics-view-model-paged-list-api-response';
import { GetPagingWithFitlerParams } from '../models/get-paging-with-fitler-params';
import { OptionsFieldDefinitionViewModelIEnumerableApiResponse } from '../models/options-field-definition-view-model-ienumerable-api-response';
import { InfectedStatisticsViewModelListWithOptionsResponseApiResponse } from '../models/infected-statistics-view-model-list-with-options-response-api-response';
import { InfectedStatisticsViewModelPagedListWithOptionsResponseApiResponse } from '../models/infected-statistics-view-model-paged-list-with-options-response-api-response';
import { DocumentViewModelApiResponse } from '../models/document-view-model-api-response';
import { ExportDataModel } from '../models/export-data-model';
@Injectable({
  providedIn: 'root',
})
class ApiInfectedStatisticsService extends __BaseService {
  static readonly GetForDatePath = '/api/ApiInfectedStatistics/GetForDate';
  static readonly PostPath = '/api/ApiInfectedStatistics';
  static readonly PutPath = '/api/ApiInfectedStatistics';
  static readonly DeletePath = '/api/ApiInfectedStatistics';
  static readonly GetPath = '/api/ApiInfectedStatistics';
  static readonly BulkCreatePath = '/api/ApiInfectedStatistics/BulkCreate';
  static readonly AddOrUpdatePath = '/api/ApiInfectedStatistics/AddOrUpdate';
  static readonly BulkUpdatePath = '/api/ApiInfectedStatistics/BulkUpdate';
  static readonly BulkAddOrUpdatePath = '/api/ApiInfectedStatistics/BulkAddOrUpdate';
  static readonly Delete_1Path = '/api/ApiInfectedStatistics/{id}';
  static readonly DeleteByIdPath = '/api/ApiInfectedStatistics/DeleteById';
  static readonly BulkDeletePath = '/api/ApiInfectedStatistics/BulkDelete';
  static readonly GetWithEditDataPath = '/api/ApiInfectedStatistics/GetWithEditData';
  static readonly GetWithFilterPath = '/api/ApiInfectedStatistics/GetWithFilter';
  static readonly GetPagedPath = '/api/ApiInfectedStatistics/GetPaged';
  static readonly GetPagedWithFilterPath = '/api/ApiInfectedStatistics/GetPagedWithFilter';
  static readonly GetOptionsPath = '/api/ApiInfectedStatistics/GetOptions';
  static readonly GetWithOptionsPath = '/api/ApiInfectedStatistics/GetWithOptions';
  static readonly GetWithOptionsAndFilterPath = '/api/ApiInfectedStatistics/GetWithOptionsAndFilter';
  static readonly GetPagedWithOptionsPath = '/api/ApiInfectedStatistics/GetPagedWithOptions';
  static readonly GetPagedWithOptionsAndFilterPath = '/api/ApiInfectedStatistics/GetPagedWithOptionsAndFilter';
  static readonly ExportPath = '/api/ApiInfectedStatistics/Export';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @param date undefined
   * @return Success
   */
  GetForDateResponse(date?: string): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelIEnumerableApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    if (date != null) __params = __params.set('date', date.toString());
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/ApiInfectedStatistics/GetForDate`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelIEnumerableApiResponse>;
      })
    );
  }
  /**
   * @param date undefined
   * @return Success
   */
  GetForDate(date?: string): __Observable<InfectedStatisticsViewModelIEnumerableApiResponse> {
    return this.GetForDateResponse(date).pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelIEnumerableApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  PostResponse(body?: InfectedStatisticsViewModel): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/ApiInfectedStatistics`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  Post(body?: InfectedStatisticsViewModel): __Observable<InfectedStatisticsViewModelApiResponse> {
    return this.PostResponse(body).pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  PutResponse(body?: InfectedStatisticsViewModel): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'PUT',
      this.rootUrl + `/api/ApiInfectedStatistics`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  Put(body?: InfectedStatisticsViewModel): __Observable<InfectedStatisticsViewModelApiResponse> {
    return this.PutResponse(body).pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  DeleteResponse(body?: InfectedStatisticsViewModel): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api/ApiInfectedStatistics`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  Delete(body?: InfectedStatisticsViewModel): __Observable<InfectedStatisticsViewModelApiResponse> {
    return this.DeleteResponse(body).pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelApiResponse)
    );
  }

  /**
   * @return Success
   */
  GetResponse(): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelIEnumerableApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/ApiInfectedStatistics`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelIEnumerableApiResponse>;
      })
    );
  }
  /**
   * @return Success
   */
  Get(): __Observable<InfectedStatisticsViewModelIEnumerableApiResponse> {
    return this.GetResponse().pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelIEnumerableApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  BulkCreateResponse(body?: Array<InfectedStatisticsViewModel>): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelIEnumerableApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/ApiInfectedStatistics/BulkCreate`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelIEnumerableApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  BulkCreate(body?: Array<InfectedStatisticsViewModel>): __Observable<InfectedStatisticsViewModelIEnumerableApiResponse> {
    return this.BulkCreateResponse(body).pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelIEnumerableApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  AddOrUpdateResponse(body?: InfectedStatisticsViewModel): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/ApiInfectedStatistics/AddOrUpdate`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  AddOrUpdate(body?: InfectedStatisticsViewModel): __Observable<InfectedStatisticsViewModelApiResponse> {
    return this.AddOrUpdateResponse(body).pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  BulkUpdateResponse(body?: Int64InfectedStatisticsViewModelBulkUpdateParams): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelIEnumerableApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'PUT',
      this.rootUrl + `/api/ApiInfectedStatistics/BulkUpdate`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelIEnumerableApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  BulkUpdate(body?: Int64InfectedStatisticsViewModelBulkUpdateParams): __Observable<InfectedStatisticsViewModelIEnumerableApiResponse> {
    return this.BulkUpdateResponse(body).pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelIEnumerableApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  BulkAddOrUpdateResponse(body?: Array<InfectedStatisticsViewModel>): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelIEnumerableApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'PUT',
      this.rootUrl + `/api/ApiInfectedStatistics/BulkAddOrUpdate`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelIEnumerableApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  BulkAddOrUpdate(body?: Array<InfectedStatisticsViewModel>): __Observable<InfectedStatisticsViewModelIEnumerableApiResponse> {
    return this.BulkAddOrUpdateResponse(body).pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelIEnumerableApiResponse)
    );
  }

  /**
   * @param id undefined
   * @return Success
   */
  Delete_1Response(id: number): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api/ApiInfectedStatistics/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelApiResponse>;
      })
    );
  }
  /**
   * @param id undefined
   * @return Success
   */
  Delete_1(id: number): __Observable<InfectedStatisticsViewModelApiResponse> {
    return this.Delete_1Response(id).pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelApiResponse)
    );
  }

  /**
   * @param id undefined
   * @return Success
   */
  DeleteByIdResponse(id?: number): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    if (id != null) __params = __params.set('id', id.toString());
    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api/ApiInfectedStatistics/DeleteById`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelApiResponse>;
      })
    );
  }
  /**
   * @param id undefined
   * @return Success
   */
  DeleteById(id?: number): __Observable<InfectedStatisticsViewModelApiResponse> {
    return this.DeleteByIdResponse(id).pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelApiResponse)
    );
  }

  /**
   * @param elementsToDeleteIds undefined
   * @return Success
   */
  BulkDeleteResponse(elementsToDeleteIds?: Array<number>): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelIEnumerableApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    (elementsToDeleteIds || []).forEach(val => {if (val != null) __params = __params.append('elementsToDeleteIds', val.toString())});
    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api/ApiInfectedStatistics/BulkDelete`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelIEnumerableApiResponse>;
      })
    );
  }
  /**
   * @param elementsToDeleteIds undefined
   * @return Success
   */
  BulkDelete(elementsToDeleteIds?: Array<number>): __Observable<InfectedStatisticsViewModelIEnumerableApiResponse> {
    return this.BulkDeleteResponse(elementsToDeleteIds).pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelIEnumerableApiResponse)
    );
  }

  /**
   * @param params The `ApiInfectedStatisticsService.GetWithEditDataParams` containing the following parameters:
   *
   * - `id`:
   *
   * - `additionalParamValue`:
   *
   * - `additionalParamName`:
   *
   * @return Success
   */
  GetWithEditDataResponse(params: ApiInfectedStatisticsService.GetWithEditDataParams): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelFormModelApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    if (params.id != null) __params = __params.set('id', params.id.toString());
    if (params.additionalParamValue != null) __params = __params.set('additionalParamValue', params.additionalParamValue.toString());
    if (params.additionalParamName != null) __params = __params.set('additionalParamName', params.additionalParamName.toString());
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/ApiInfectedStatistics/GetWithEditData`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelFormModelApiResponse>;
      })
    );
  }
  /**
   * @param params The `ApiInfectedStatisticsService.GetWithEditDataParams` containing the following parameters:
   *
   * - `id`:
   *
   * - `additionalParamValue`:
   *
   * - `additionalParamName`:
   *
   * @return Success
   */
  GetWithEditData(params: ApiInfectedStatisticsService.GetWithEditDataParams): __Observable<InfectedStatisticsViewModelFormModelApiResponse> {
    return this.GetWithEditDataResponse(params).pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelFormModelApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  GetWithFilterResponse(body?: FilterRule): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelIEnumerableApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/ApiInfectedStatistics/GetWithFilter`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelIEnumerableApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  GetWithFilter(body?: FilterRule): __Observable<InfectedStatisticsViewModelIEnumerableApiResponse> {
    return this.GetWithFilterResponse(body).pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelIEnumerableApiResponse)
    );
  }

  /**
   * @param params The `ApiInfectedStatisticsService.GetPagedParams` containing the following parameters:
   *
   * - `page.Size`:
   *
   * - `page.Index`:
   *
   * - `order.Property`:
   *
   * - `order.IsAscending`:
   *
   * @return Success
   */
  GetPagedResponse(params: ApiInfectedStatisticsService.GetPagedParams): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelPagedListApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    if (params.pageSize != null) __params = __params.set('page.Size', params.pageSize.toString());
    if (params.pageIndex != null) __params = __params.set('page.Index', params.pageIndex.toString());
    if (params.orderProperty != null) __params = __params.set('order.Property', params.orderProperty.toString());
    if (params.orderIsAscending != null) __params = __params.set('order.IsAscending', params.orderIsAscending.toString());
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/ApiInfectedStatistics/GetPaged`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelPagedListApiResponse>;
      })
    );
  }
  /**
   * @param params The `ApiInfectedStatisticsService.GetPagedParams` containing the following parameters:
   *
   * - `page.Size`:
   *
   * - `page.Index`:
   *
   * - `order.Property`:
   *
   * - `order.IsAscending`:
   *
   * @return Success
   */
  GetPaged(params: ApiInfectedStatisticsService.GetPagedParams): __Observable<InfectedStatisticsViewModelPagedListApiResponse> {
    return this.GetPagedResponse(params).pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelPagedListApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  GetPagedWithFilterResponse(body?: GetPagingWithFitlerParams): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelPagedListApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/ApiInfectedStatistics/GetPagedWithFilter`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelPagedListApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  GetPagedWithFilter(body?: GetPagingWithFitlerParams): __Observable<InfectedStatisticsViewModelPagedListApiResponse> {
    return this.GetPagedWithFilterResponse(body).pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelPagedListApiResponse)
    );
  }

  /**
   * @return Success
   */
  GetOptionsResponse(): __Observable<__StrictHttpResponse<OptionsFieldDefinitionViewModelIEnumerableApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/ApiInfectedStatistics/GetOptions`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<OptionsFieldDefinitionViewModelIEnumerableApiResponse>;
      })
    );
  }
  /**
   * @return Success
   */
  GetOptions(): __Observable<OptionsFieldDefinitionViewModelIEnumerableApiResponse> {
    return this.GetOptionsResponse().pipe(
      __map(_r => _r.body as OptionsFieldDefinitionViewModelIEnumerableApiResponse)
    );
  }

  /**
   * @return Success
   */
  GetWithOptionsResponse(): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelListWithOptionsResponseApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/ApiInfectedStatistics/GetWithOptions`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelListWithOptionsResponseApiResponse>;
      })
    );
  }
  /**
   * @return Success
   */
  GetWithOptions(): __Observable<InfectedStatisticsViewModelListWithOptionsResponseApiResponse> {
    return this.GetWithOptionsResponse().pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelListWithOptionsResponseApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  GetWithOptionsAndFilterResponse(body?: FilterRule): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelListWithOptionsResponseApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/ApiInfectedStatistics/GetWithOptionsAndFilter`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelListWithOptionsResponseApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  GetWithOptionsAndFilter(body?: FilterRule): __Observable<InfectedStatisticsViewModelListWithOptionsResponseApiResponse> {
    return this.GetWithOptionsAndFilterResponse(body).pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelListWithOptionsResponseApiResponse)
    );
  }

  /**
   * @param params The `ApiInfectedStatisticsService.GetPagedWithOptionsParams` containing the following parameters:
   *
   * - `page.Size`:
   *
   * - `page.Index`:
   *
   * - `order.Property`:
   *
   * - `order.IsAscending`:
   *
   * @return Success
   */
  GetPagedWithOptionsResponse(params: ApiInfectedStatisticsService.GetPagedWithOptionsParams): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelPagedListWithOptionsResponseApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    if (params.pageSize != null) __params = __params.set('page.Size', params.pageSize.toString());
    if (params.pageIndex != null) __params = __params.set('page.Index', params.pageIndex.toString());
    if (params.orderProperty != null) __params = __params.set('order.Property', params.orderProperty.toString());
    if (params.orderIsAscending != null) __params = __params.set('order.IsAscending', params.orderIsAscending.toString());
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/ApiInfectedStatistics/GetPagedWithOptions`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelPagedListWithOptionsResponseApiResponse>;
      })
    );
  }
  /**
   * @param params The `ApiInfectedStatisticsService.GetPagedWithOptionsParams` containing the following parameters:
   *
   * - `page.Size`:
   *
   * - `page.Index`:
   *
   * - `order.Property`:
   *
   * - `order.IsAscending`:
   *
   * @return Success
   */
  GetPagedWithOptions(params: ApiInfectedStatisticsService.GetPagedWithOptionsParams): __Observable<InfectedStatisticsViewModelPagedListWithOptionsResponseApiResponse> {
    return this.GetPagedWithOptionsResponse(params).pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelPagedListWithOptionsResponseApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  GetPagedWithOptionsAndFilterResponse(body?: GetPagingWithFitlerParams): __Observable<__StrictHttpResponse<InfectedStatisticsViewModelPagedListWithOptionsResponseApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/ApiInfectedStatistics/GetPagedWithOptionsAndFilter`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<InfectedStatisticsViewModelPagedListWithOptionsResponseApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  GetPagedWithOptionsAndFilter(body?: GetPagingWithFitlerParams): __Observable<InfectedStatisticsViewModelPagedListWithOptionsResponseApiResponse> {
    return this.GetPagedWithOptionsAndFilterResponse(body).pipe(
      __map(_r => _r.body as InfectedStatisticsViewModelPagedListWithOptionsResponseApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  ExportResponse(body?: ExportDataModel): __Observable<__StrictHttpResponse<DocumentViewModelApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/ApiInfectedStatistics/Export`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<DocumentViewModelApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  Export(body?: ExportDataModel): __Observable<DocumentViewModelApiResponse> {
    return this.ExportResponse(body).pipe(
      __map(_r => _r.body as DocumentViewModelApiResponse)
    );
  }
}

module ApiInfectedStatisticsService {

  /**
   * Parameters for GetWithEditData
   */
  export interface GetWithEditDataParams {
    id?: number;
    additionalParamValue?: string;
    additionalParamName?: string;
  }

  /**
   * Parameters for GetPaged
   */
  export interface GetPagedParams {
    pageSize?: number;
    pageIndex?: number;
    orderProperty?: string;
    orderIsAscending?: boolean;
  }

  /**
   * Parameters for GetPagedWithOptions
   */
  export interface GetPagedWithOptionsParams {
    pageSize?: number;
    pageIndex?: number;
    orderProperty?: string;
    orderIsAscending?: boolean;
  }
}

export { ApiInfectedStatisticsService }
