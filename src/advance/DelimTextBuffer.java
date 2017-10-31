/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advance;

/**
 *
 * @author JEAN WAHLUNG
 */
public class DelimTextBuffer {

    char Delim = '|';
    int Maxbytes = 1000;
    char[] Buffer;
    int Buffersize;
    int NextByte;
    char[] DelimStr = new char[8];

    int DelimTextBuffer(char delim, int maxBytes) {
        Delim = delim;
        DelimStr[0] = Delim;
        DelimStr[1] = 0;

        if (maxBytes < 0) {
            maxBytes = 0;
        }

        Maxbytes = maxBytes;
        Buffer = new char[Maxbytes];
        Buffersize = 0;
        return 1;
    }

    int Unpack(char str) {
        int len = -1;
        int start = NextByte;

        for (int i = start; i < Buffersize; i++) {
            if (Buffer[i] == Delim) {
                len = i - start;
                break;
            }

        }

        if (len == -1) {
            return 1;
        }

        NextByte += len + 1;

        if (NextByte > Buffersize) {
            return 1;
        }

        char[] copia = new char[len + str];
        for (int i = 0; i < Buffer.length; i++) {
            copia[i] = Buffer[i];
            copia[i] = Buffer[str];

        }

        str = 0;

        return 0;
    }

    int Pack(char str, int size) {
        int len = 0;
        int lens = 0;
        if (size >= 0) {
            len = size;
        } else {
            lens = str + len;
        }
        
        if (len > lens) {
            return 1;
        }
        
        int start = NextByte;
        NextByte += len + 1;
        
        if (NextByte > Maxbytes) {
            return 1;
        }

        System.arraycopy(Buffer, str, Buffer, len, Buffer.length);
        Buffer[start + len] = Delim;
        Buffersize = NextByte;

        return 0;
    }
}
