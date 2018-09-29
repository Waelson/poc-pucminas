import { ErrorHandler, Injectable } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { HttpErrorResponse } from '@angular/common/http';

@Injectable()
export class ErrorsHandler implements ErrorHandler {

    constructor(private spinner: NgxSpinnerService) {}

    handleError(error: Error | HttpErrorResponse) {
        if ( error instanceof HttpErrorResponse) {
            if ( !navigator.onLine ) {
                // console.log('Você parece está offline.', error);
            }

            if ( error.status === 400 ) { // Nao encontrado
                console.log(400);
            } else if ( error.status === 401 ) { // Sem autorizacao
                console.log(401);
            } else if ( error.status === 404 ) { // Sem autorizacao
                console.log(404);
            } else if (error.status === 500) { // Error interno
                console.log(500);
            }

        } else {
           //  console.log(error.name + ' => ' + error.message);
        }


        this.spinner.hide();
        // console.error(error);
    }

}
