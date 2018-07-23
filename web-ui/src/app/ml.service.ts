import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import {
  HttpClient, HttpHeaders, HttpEvent, HttpEventType, HttpProgressEvent,
  HttpRequest, HttpResponse, HttpErrorResponse
} from '@angular/common/http';
//import { Headers, RequestOptions,Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap, last } from 'rxjs/operators';
import { PredictPara } from './PredictPara';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class MlService {

  //private heroesUrl = 'api/heroes';
  private localUrl = 'http://localhost:9000/callpy';
  //private localPredictUlr = 'http://localhost:9000/callpredict';
  private localPredictUlr = 'http://localhost:9000/predict';
  private localTrainingUlr = 'http://localhost:9000/traininginfo';
  constructor(private http: HttpClient
    //,private messageService: MessageService
  ) { }

  // getPredict(desc: string): Observable<string> {
  //   let url = this.localPredictUlr + "/?desc=" + desc;
  //   return this.http.get(url, { responseType: 'text' }, ).pipe(
  //     tap(_ => console.info("test1")),
  //     catchError(this.handleError<string>("test error")))
  //     ;
  // }

  startPredict(para: PredictPara): Observable<PredictPara> {
    //startPredict(para: PredictPara): Promise<PredictPara> {
    console.info(para);
    let url = this.localPredictUlr + '/predict';
    //let options = new RequestOptions({ headers: headers });

    // return this.http.post(this.url, para, httpOptions)
    // .map(this.extractData)
    // .catch(this.handleErrorhandleError);
    //     catchError(this.handleError<PredictPara>("predict encountered error!"))
    // );
    return this.http.post<PredictPara>(url, para, httpOptions)
      .pipe(
      catchError(this.handleError<PredictPara>('predict encounted error', para))
      );
  }

  private extractData(res: Response) {
    let body = res.json();
    return body || {};
  }

  startTraining(file: File) {
    if (!file) { return; }

    console.log(file);

    let url = this.localTrainingUlr + '/training';
    console.log(url);

    const fd = new FormData();
    fd.append('file', file, file.name);
    fd.append('method', 'default');
    this.http.post(url, fd, {
      reportProgress: true,
      observe: 'events'
    }).subscribe(event => {
      console.log(event);
    })
  }

  /** Return distinct message for sent, upload progress, & response events */
  private getEventMessage(event: HttpEvent<any>, file: File) {
    switch (event.type) {
      case HttpEventType.Sent:
        return `Uploading file "${file.name}" of size ${file.size}.`;

      case HttpEventType.UploadProgress:
        // Compute and show the % done:
        const percentDone = Math.round(100 * event.loaded / event.total);
        return `File "${file.name}" is ${percentDone}% uploaded.`;

      case HttpEventType.Response:
        return `File "${file.name}" was completely uploaded!`;

      default:
        return `File "${file.name}" surprising upload event: ${event.type}.`;
    }
  }


  // private showProgress(message: string) {
  //   this.messenger.add(message);
  // }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.info("1");
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      //this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }


}
