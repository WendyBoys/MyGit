  


  //MurmurHash�㷨 
    HashFunction function= Hashing.murmur3_32();
    HashCode hashCode = function.hashString(longUrl, Charset.forName("utf-8"));
    //iΪ��url��murmurֵ
    int i = Math.abs(hashCode.asInt());