import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AutorizacionService {

  private isLogged: boolean;

  constructor() { 
    console.trace('AutorizacionService canActivate');
    this.isLogged = false;
  }


  /**
   * Nos dice si el usuario ha hecho login o no
   */
  estaLogeado(): boolean{
    return this.isLogged;
  }

  /**
   * metodo para llamar al servicio rest del backoffice
   * @param placa 
   * @param password 
   */
  loggin(placa: string, password: string): any{

      //TODO llamar Servicio Rest
      if ( placa === '123456' && password === '123456'){
        this.isLogged = true;
      }else{
        this.isLogged = false;
      }
  }

  /**
   * Cierra la session del usuario llamando al backoffice
   */
  logout(){
    //TODO llamar Servicio Rest
    this.isLogged = false;
  }


}