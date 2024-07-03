import { Injectable } from "@angular/core";
import CryptoJS from "crypto-js";

@Injectable({
    providedIn: 'root'
  })
export class Crypto {
    encryptData(data: string, secretKey: string, ivString: string):string{
        const key = CryptoJS.enc.Utf8.parse(secretKey);
        const iv = CryptoJS.enc.Utf8.parse(ivString);
        const encrypted = CryptoJS.AES.encrypt(CryptoJS.enc.Utf8.parse(data),key,{
            keySize: 128/8,
            iv: iv,
            mode: CryptoJS.mode.CBC,
            padding: CryptoJS.pad.Pkcs7
        });

        return encrypted.toString();
    }
}