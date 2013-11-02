package edu.berkeley.lipstick.util.serializer;


import edu.berkeley.lipstick.util.DataWrapper;

public class GzipCustomDWSerializer implements IDWSerializer {

    private CustomDWSerializer pdw = new CustomDWSerializer();

    public byte[] toByteArray(DataWrapper input) throws Exception {
        return GzipCompressor.compress(pdw.toByteArray(input));
    }

    public DataWrapper fromByteArray(String key, byte[] input) throws Exception {
        return pdw.fromByteArray(key, GzipCompressor.decompress(input));
   }
}