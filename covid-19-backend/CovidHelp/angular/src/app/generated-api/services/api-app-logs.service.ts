/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { AppLogViewModelApiResponse } from '../models/app-log-view-model-api-response';
import { AppLogViewModel } from '../models/app-log-view-model';
import { AppLogViewModelIEnumerableApiResponse } from '../models/app-log-view-model-ienumerable-api-response';
import { Int64AppLogViewModelBulkUpdateParams } from '../models/int-64app-log-view-model-bulk-update-params';
import { AppLogViewModelFormModelApiResponse } from '../models/app-log-view-model-form-model-api-response';
import { FilterRule } from '../models/filter-rule';
import { AppLogViewModelPagedListApiResponse } from '../models/app-log-view-model-paged-list-api-response';
import { GetPagingWithFitlerParams } from '../models/get-paging-with-fitler-params';
import { OptionsFieldDefinitionViewModelIEnumerableApiResponse } from '../models/options-field-definition-view-model-ienumerable-api-response';
import { AppLogViewModelListWithOptionsResponseApiResponse } from '../models/app-log-view-model-list-with-options-response-api-response';
import { AppLogViewModelPagedListWithOptionsResponseApiResponse } from '../models/app-log-view-model-paged-list-with-options-response-api-response';
import { DocumentViewModelApiResponse } from '../models/document-view-model-api-response';
import { ExportDataModel } from '../models/export-data-model';
@Injectable({
  providedIn: 'root',
})
class ApiAppLogsService extends __BaseService {
  static readonly PostPath = '/api/ApiAppLogs';
  static readonly PutPath = '/api/ApiAppLogs';
  static readonly DeletePath = '/api/ApiAppLogs';
  static readonly GetPath = '/api/ApiAppLogs';
  static readonly BulkCreatePath = '/api/ApiAppLogs/BulkCreate';
  static readonly AddOrUpdatePath = '/api/ApiAppLogs/AddOrUpdate';
  static readonly BulkUpdatePath = '/api/ApiAppLogs/BulkUpdate';
  static readonly BulkAddOrUpdatePath = '/api/ApiAppLogs/BulkAddOrUpdate';
  static readonly Delete_1Path = '/api/ApiAppLogs/{id}';
  static readonly DeleteByIdPath = '/api/ApiAppLogs/DeleteById';
  static readonly BulkDeletePath = '/api/ApiAppLogs/BulkDelete';
  static readonly GetWithEditDataPath = '/api/ApiAppLogs/GetWithEditData';
  static readonly GetWithFilterPath = '/api/ApiAppLogs/GetWithFilter';
  static readonly GetPagedPath = '/api/ApiAppLogs/GetPaged';
  static readonly GetPagedWithFilterPath = '/api/ApiAppLogs/GetPagedWithFilter';
  static readonly GetOptionsPath = '/api/ApiAppLogs/GetOptions';
  static readonly GetWithOptionsPath = '/api/ApiAppLogs/GetWithOptions';
  static readonly GetWithOptionsAndFilterPath = '/api/ApiAppLogs/GetWithOptionsAndFilter';
  static readonly GetPagedWithOptionsPath = '/api/ApiAppLogs/GetPagedWithOptions';
  static readonly GetPagedWithOptionsAndFilterPath = '/api/ApiAppLogs/GetPagedWithOptionsAndFilter';
  static readonly ExportPath = '/api/ApiAppLogs/Export';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @param body undefined
   * @return Success
   */
  PostResponse(body?: AppLogViewModel): __Observable<__StrictHttpResponse<AppLogViewModelApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/ApiAppLogs`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<AppLogViewModelApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  Post(body?: AppLogViewModel): __Observable<AppLogViewModelApiResponse> {
    return this.PostResponse(body).pipe(
      __map(_r => _r.body as AppLogViewModelApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  PutResponse(body?: AppLogViewModel): __Observable<__StrictHttpResponse<AppLogViewModelApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'PUT',
      this.rootUrl + `/api/ApiAppLogs`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<AppLogViewModelApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  Put(body?: AppLogViewModel): __Observable<AppLogViewModelApiResponse> {
    return this.PutResponse(body).pipe(
      __map(_r => _r.body as AppLogViewModelApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  DeleteResponse(body?: AppLogViewModel): __Observable<__StrictHttpResponse<AppLogViewModelApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api/ApiAppLogs`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<AppLogViewModelApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  Delete(body?: AppLogViewModel): __Observable<AppLogViewModelApiResponse> {
    return this.DeleteResponse(body).pipe(
      __map(_r => _r.body as AppLogViewModelApiResponse)
    );
  }

  /**
   * @return Success
   */
  GetResponse(): __Observable<__StrictHttpResponse<AppLogViewModelIEnumerableApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/ApiAppLogs`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<AppLogViewModelIEnumerableApiResponse>;
      })
    );
  }
  /**
   * @return Success
   */
  Get(): __Observable<AppLogViewModelIEnumerableApiResponse> {
    return this.GetResponse().pipe(
      __map(_r => _r.body as AppLogViewModelIEnumerableApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  BulkCreateResponse(body?: Array<AppLogViewModel>): __Observable<__StrictHttpResponse<AppLogViewModelIEnumerableApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/ApiAppLogs/BulkCreate`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<AppLogViewModelIEnumerableApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  BulkCreate(body?: Array<AppLogViewModel>): __Observable<AppLogViewModelIEnumerableApiResponse> {
    return this.BulkCreateResponse(body).pipe(
      __map(_r => _r.body as AppLogViewModelIEnumerableApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  AddOrUpdateResponse(body?: AppLogViewModel): __Observable<__StrictHttpResponse<AppLogViewModelApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/ApiAppLogs/AddOrUpdate`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<AppLogViewModelApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  AddOrUpdate(body?: AppLogViewModel): __Observable<AppLogViewModelApiResponse> {
    return this.AddOrUpdateResponse(body).pipe(
      __map(_r => _r.body as AppLogViewModelApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  BulkUpdateResponse(body?: Int64AppLogViewModelBulkUpdateParams): __Observable<__StrictHttpResponse<AppLogViewModelIEnumerableApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'PUT',
      this.rootUrl + `/api/ApiAppLogs/BulkUpdate`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<AppLogViewModelIEnumerableApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  BulkUpdate(body?: Int64AppLogViewModelBulkUpdateParams): __Observable<AppLogViewModelIEnumerableApiResponse> {
    return this.BulkUpdateResponse(body).pipe(
      __map(_r => _r.body as AppLogViewModelIEnumerableApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  BulkAddOrUpdateResponse(body?: Array<AppLogViewModel>): __Observable<__StrictHttpResponse<AppLogViewModelIEnumerableApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'PUT',
      this.rootUrl + `/api/ApiAppLogs/BulkAddOrUpdate`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<AppLogViewModelIEnumerableApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  BulkAddOrUpdate(body?: Array<AppLogViewModel>): __Observable<AppLogViewModelIEnumerableApiResponse> {
    return this.BulkAddOrUpdateResponse(body).pipe(
      __map(_r => _r.body as AppLogViewModelIEnumerableApiResponse)
    );
  }

  /**
   * @param id undefined
   * @return Success
   */
  Delete_1Response(id: number): __Observable<__StrictHttpResponse<AppLogViewModelApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api/ApiAppLogs/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<AppLogViewModelApiResponse>;
      })
    );
  }
  /**
   * @param id undefined
   * @return Success
   */
  Delete_1(id: number): __Observable<AppLogViewModelApiResponse> {
    return this.Delete_1Response(id).pipe(
      __map(_r => _r.body as AppLogViewModelApiResponse)
    );
  }

  /**
   * @param id undefined
   * @return Success
   */
  DeleteByIdResponse(id?: number): __Observable<__StrictHttpResponse<AppLogViewModelApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    if (id != null) __params = __params.set('id', id.toString());
    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api/ApiAppLogs/DeleteById`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<AppLogViewModelApiResponse>;
      })
    );
  }
  /**
   * @param id undefined
   * @return Success
   */
  DeleteById(id?: number): __Observable<AppLogViewModelApiResponse> {
    return this.DeleteByIdResponse(id).pipe(
      __map(_r => _r.body as AppLogViewModelApiResponse)
    );
  }

  /**
   * @param elementsToDeleteIds undefined
   * @return Success
   */
  BulkDeleteResponse(elementsToDeleteIds?: Array<number>): __Observable<__StrictHttpResponse<AppLogViewModelIEnumerableApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    (elementsToDeleteIds || []).forEach(val => {if (val != null) __params = __params.append('elementsToDeleteIds', val.toString())});
    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api/ApiAppLogs/BulkDelete`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<AppLogViewModelIEnumerableApiResponse>;
      })
    );
  }
  /**
   * @param elementsToDeleteIds undefined
   * @return Success
   */
  BulkDelete(elementsToDeleteIds?: Array<number>): __Observable<AppLogViewModelIEnumerableApiResponse> {
    return this.BulkDeleteResponse(elementsToDeleteIds).pipe(
      __map(_r => _r.body as AppLogViewModelIEnumerableApiResponse)
    );
  }

  /**
   * @param params The `ApiAppLogsService.GetWithEditDataParams` containing the following parameters:
   *
   * - `id`:
   *
   * - `additionalParamValue`:
   *
   * - `additionalParamName`:
   *
   * @return Success
   */
  GetWithEditDataResponse(params: ApiAppLogsService.GetWithEditDataParams): __Observable<__StrictHttpResponse<AppLogViewModelFormModelApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    if (params.id != null) __params = __params.set('id', params.id.toString());
    if (params.additionalParamValue != null) __params = __params.set('additionalParamValue', params.additionalParamValue.toString());
    if (params.additionalParamName != null) __params = __params.set('additionalParamName', params.additionalParamName.toString());
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/ApiAppLogs/GetWithEditData`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<AppLogViewModelFormModelApiResponse>;
      })
    );
  }
  /**
   * @param params The `ApiAppLogsService.GetWithEditDataParams` containing the following parameters:
   *
   * - `id`:
   *
   * - `additionalParamValue`:
   *
   * - `additionalParamName`:
   *
   * @return Success
   */
  GetWithEditData(params: ApiAppLogsService.GetWithEditDataParams): __Observable<AppLogViewModelFormModelApiResponse> {
    return this.GetWithEditDataResponse(params).pipe(
      __map(_r => _r.body as AppLogViewModelFormModelApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  GetWithFilterResponse(body?: FilterRule): __Observable<__StrictHttpResponse<AppLogViewModelIEnumerableApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/ApiAppLogs/GetWithFilter`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<AppLogViewModelIEnumerableApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  GetWithFilter(body?: FilterRule): __Observable<AppLogViewModelIEnumerableApiResponse> {
    return this.GetWithFilterResponse(body).pipe(
      __map(_r => _r.body as AppLogViewModelIEnumerableApiResponse)
    );
  }

  /**
   * @param params The `ApiAppLogsService.GetPagedParams` containing the following parameters:
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
  GetPagedResponse(params: ApiAppLogsService.GetPagedParams): __Observable<__StrictHttpResponse<AppLogViewModelPagedListApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    if (params.pageSize != null) __params = __params.set('page.Size', params.pageSize.toString());
    if (params.pageIndex != null) __params = __params.set('page.Index', params.pageIndex.toString());
    if (params.orderProperty != null) __params = __params.set('order.Property', params.orderProperty.toString());
    if (params.orderIsAscending != null) __params = __params.set('order.IsAscending', params.orderIsAscending.toString());
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/ApiAppLogs/GetPaged`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<AppLogViewModelPagedListApiResponse>;
      })
    );
  }
  /**
   * @param params The `ApiAppLogsService.GetPagedParams` containing the following parameters:
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
  GetPaged(params: ApiAppLogsService.GetPagedParams): __Observable<AppLogViewModelPagedListApiResponse> {
    return this.GetPagedResponse(params).pipe(
      __map(_r => _r.body as AppLogViewModelPagedListApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  GetPagedWithFilterResponse(body?: GetPagingWithFitlerParams): __Observable<__StrictHttpResponse<AppLogViewModelPagedListApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/ApiAppLogs/GetPagedWithFilter`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<AppLogViewModelPagedListApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  GetPagedWithFilter(body?: GetPagingWithFitlerParams): __Observable<AppLogViewModelPagedListApiResponse> {
    return this.GetPagedWithFilterResponse(body).pipe(
      __map(_r => _r.body as AppLogViewModelPagedListApiResponse)
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
      this.rootUrl + `/api/ApiAppLogs/GetOptions`,
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
  GetWithOptionsResponse(): __Observable<__StrictHttpResponse<AppLogViewModelListWithOptionsResponseApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/ApiAppLogs/GetWithOptions`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<AppLogViewModelListWithOptionsResponseApiResponse>;
      })
    );
  }
  /**
   * @return Success
   */
  GetWithOptions(): __Observable<AppLogViewModelListWithOptionsResponseApiResponse> {
    return this.GetWithOptionsResponse().pipe(
      __map(_r => _r.body as AppLogViewModelListWithOptionsResponseApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  GetWithOptionsAndFilterResponse(body?: FilterRule): __Observable<__StrictHttpResponse<AppLogViewModelListWithOptionsResponseApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/ApiAppLogs/GetWithOptionsAndFilter`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<AppLogViewModelListWithOptionsResponseApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  GetWithOptionsAndFilter(body?: FilterRule): __Observable<AppLogViewModelListWithOptionsResponseApiResponse> {
    return this.GetWithOptionsAndFilterResponse(body).pipe(
      __map(_r => _r.body as AppLogViewModelListWithOptionsResponseApiResponse)
    );
  }

  /**
   * @param params The `ApiAppLogsService.GetPagedWithOptionsParams` containing the following parameters:
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
  GetPagedWithOptionsResponse(params: ApiAppLogsService.GetPagedWithOptionsParams): __Observable<__StrictHttpResponse<AppLogViewModelPagedListWithOptionsResponseApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    if (params.pageSize != null) __params = __params.set('page.Size', params.pageSize.toString());
    if (params.pageIndex != null) __params = __params.set('page.Index', params.pageIndex.toString());
    if (params.orderProperty != null) __params = __params.set('order.Property', params.orderProperty.toString());
    if (params.orderIsAscending != null) __params = __params.set('order.IsAscending', params.orderIsAscending.toString());
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/ApiAppLogs/GetPagedWithOptions`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<AppLogViewModelPagedListWithOptionsResponseApiResponse>;
      })
    );
  }
  /**
   * @param params The `ApiAppLogsService.GetPagedWithOptionsParams` containing the following parameters:
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
  GetPagedWithOptions(params: ApiAppLogsService.GetPagedWithOptionsParams): __Observable<AppLogViewModelPagedListWithOptionsResponseApiResponse> {
    return this.GetPagedWithOptionsResponse(params).pipe(
      __map(_r => _r.body as AppLogViewModelPagedListWithOptionsResponseApiResponse)
    );
  }

  /**
   * @param body undefined
   * @return Success
   */
  GetPagedWithOptionsAndFilterResponse(body?: GetPagingWithFitlerParams): __Observable<__StrictHttpResponse<AppLogViewModelPagedListWithOptionsResponseApiResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/ApiAppLogs/GetPagedWithOptionsAndFilter`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<AppLogViewModelPagedListWithOptionsResponseApiResponse>;
      })
    );
  }
  /**
   * @param body undefined
   * @return Success
   */
  GetPagedWithOptionsAndFilter(body?: GetPagingWithFitlerParams): __Observable<AppLogViewModelPagedListWithOptionsResponseApiResponse> {
    return this.GetPagedWithOptionsAndFilterResponse(body).pipe(
      __map(_r => _r.body as AppLogViewModelPagedListWithOptionsResponseApiResponse)
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
      this.rootUrl + `/api/ApiAppLogs/Export`,
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

module ApiAppLogsService {

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

export { ApiAppLogsService }
