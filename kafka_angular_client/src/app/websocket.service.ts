import { Injectable } from '@angular/core';
//import * as Stomp from 'stompjs';
import SockJs from 'sockjs-client';
import Stomp from 'stompjs';
//var SockJs = require("sockjs-client");
//var Stomp = require("stompjs");

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {
 // Open connection with the back-end socket
 public connect() {
  let socket = new SockJs(`http://localhost:7071/websocketdemo`);

  let stompClient = Stomp.over(socket);

  return stompClient;
}
  
}
