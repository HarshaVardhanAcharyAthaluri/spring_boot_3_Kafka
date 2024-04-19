import { Injectable } from '@angular/core';
var SockJs = require("sockjs-client");
var Stomp = require("stompjs");


export interface Message {
  source: string;
  content: string;
}
@Injectable({
  providedIn: 'root'
})
export class WebsocketService {
  public connect() {
    let socket = new SockJs(`http://localhost:7071/websocketdemo`);
    let stompClient = Stomp.over(socket);
    return stompClient;
}
  
}
