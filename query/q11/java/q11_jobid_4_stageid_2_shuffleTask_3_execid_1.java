/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private double agg_bufValue;
/* 011 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 012 */   private agg_FastHashMap agg_fastHashMap;
/* 013 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 014 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 015 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 016 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 019 */   private scala.collection.Iterator inputadapter_input;
/* 020 */   private UnsafeRow agg_result8;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 023 */   private int agg_value18;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     agg_initAgg = false;
/* 036 */
/* 037 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 038 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 039 */
/* 040 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 041 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 042 */     inputadapter_input = inputs[0];
/* 043 */     agg_result8 = new UnsafeRow(8);
/* 044 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result8, 224);
/* 045 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 8);
/* 046 */
/* 047 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 048 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 049 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 050 */
/* 051 */   }
/* 052 */
/* 053 */   public class agg_FastHashMap {
/* 054 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 055 */     private int[] buckets;
/* 056 */     private int capacity = 1 << 16;
/* 057 */     private double loadFactor = 0.5;
/* 058 */     private int numBuckets = (int) (capacity / loadFactor);
/* 059 */     private int maxSteps = 2;
/* 060 */     private int numRows = 0;
/* 061 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("c_customer_id", org.apache.spark.sql.types.DataTypes.StringType)
/* 062 */     .add("c_first_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 063 */     .add("c_last_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 064 */     .add("c_preferred_cust_flag", org.apache.spark.sql.types.DataTypes.StringType)
/* 065 */     .add("c_birth_country", org.apache.spark.sql.types.DataTypes.StringType)
/* 066 */     .add("c_login", org.apache.spark.sql.types.DataTypes.StringType)
/* 067 */     .add("c_email_address", org.apache.spark.sql.types.DataTypes.StringType)
/* 068 */     .add("d_year", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 069 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 070 */     private Object emptyVBase;
/* 071 */     private long emptyVOff;
/* 072 */     private int emptyVLen;
/* 073 */     private boolean isBatchFull = false;
/* 074 */
/* 075 */     public agg_FastHashMap(
/* 076 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 077 */       InternalRow emptyAggregationBuffer) {
/* 078 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 079 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 080 */
/* 081 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 082 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 083 */
/* 084 */       emptyVBase = emptyBuffer;
/* 085 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 086 */       emptyVLen = emptyBuffer.length;
/* 087 */
/* 088 */       buckets = new int[numBuckets];
/* 089 */       java.util.Arrays.fill(buckets, -1);
/* 090 */     }
/* 091 */
/* 092 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, int agg_key7) {
/* 093 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7);
/* 094 */       int step = 0;
/* 095 */       int idx = (int) h & (numBuckets - 1);
/* 096 */       while (step < maxSteps) {
/* 097 */         // Return bucket index if it's either an empty slot or already contains the key
/* 098 */         if (buckets[idx] == -1) {
/* 099 */           if (numRows < capacity && !isBatchFull) {
/* 100 */             // creating the unsafe for new entry
/* 101 */             UnsafeRow agg_result = new UnsafeRow(8);
/* 102 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 103 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 104 */               224);
/* 105 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 106 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 107 */               agg_holder,
/* 108 */               8);
/* 109 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 110 */             agg_rowWriter.zeroOutNullBytes();
/* 111 */             agg_rowWriter.write(0, agg_key);
/* 112 */             agg_rowWriter.write(1, agg_key1);
/* 113 */             agg_rowWriter.write(2, agg_key2);
/* 114 */             agg_rowWriter.write(3, agg_key3);
/* 115 */             agg_rowWriter.write(4, agg_key4);
/* 116 */             agg_rowWriter.write(5, agg_key5);
/* 117 */             agg_rowWriter.write(6, agg_key6);
/* 118 */             agg_rowWriter.write(7, agg_key7);
/* 119 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 120 */             Object kbase = agg_result.getBaseObject();
/* 121 */             long koff = agg_result.getBaseOffset();
/* 122 */             int klen = agg_result.getSizeInBytes();
/* 123 */
/* 124 */             UnsafeRow vRow
/* 125 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 126 */             if (vRow == null) {
/* 127 */               isBatchFull = true;
/* 128 */             } else {
/* 129 */               buckets[idx] = numRows++;
/* 130 */             }
/* 131 */             return vRow;
/* 132 */           } else {
/* 133 */             // No more space
/* 134 */             return null;
/* 135 */           }
/* 136 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7)) {
/* 137 */           return batch.getValueRow(buckets[idx]);
/* 138 */         }
/* 139 */         idx = (idx + 1) & (numBuckets - 1);
/* 140 */         step++;
/* 141 */       }
/* 142 */       // Didn't find it
/* 143 */       return null;
/* 144 */     }
/* 145 */
/* 146 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, int agg_key7) {
/* 147 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 148 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getUTF8String(4).equals(agg_key4)) && (row.getUTF8String(5).equals(agg_key5)) && (row.getUTF8String(6).equals(agg_key6)) && (row.getInt(7) == agg_key7);
/* 149 */     }
/* 150 */
/* 151 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, int agg_key7) {
/* 152 */       long agg_hash = 0;
/* 153 */
/* 154 */       int agg_result = 0;
/* 155 */       byte[] agg_bytes = agg_key.getBytes();
/* 156 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 157 */         int agg_hash1 = agg_bytes[i];
/* 158 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 159 */       }
/* 160 */
/* 161 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 162 */
/* 163 */       int agg_result1 = 0;
/* 164 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 165 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 166 */         int agg_hash2 = agg_bytes1[i];
/* 167 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 168 */       }
/* 169 */
/* 170 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 171 */
/* 172 */       int agg_result2 = 0;
/* 173 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 174 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 175 */         int agg_hash3 = agg_bytes2[i];
/* 176 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 177 */       }
/* 178 */
/* 179 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 180 */
/* 181 */       int agg_result3 = 0;
/* 182 */       byte[] agg_bytes3 = agg_key3.getBytes();
/* 183 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 184 */         int agg_hash4 = agg_bytes3[i];
/* 185 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash4 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 186 */       }
/* 187 */
/* 188 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 189 */
/* 190 */       int agg_result4 = 0;
/* 191 */       byte[] agg_bytes4 = agg_key4.getBytes();
/* 192 */       for (int i = 0; i < agg_bytes4.length; i++) {
/* 193 */         int agg_hash5 = agg_bytes4[i];
/* 194 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash5 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 195 */       }
/* 196 */
/* 197 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 198 */
/* 199 */       int agg_result5 = 0;
/* 200 */       byte[] agg_bytes5 = agg_key5.getBytes();
/* 201 */       for (int i = 0; i < agg_bytes5.length; i++) {
/* 202 */         int agg_hash6 = agg_bytes5[i];
/* 203 */         agg_result5 = (agg_result5 ^ (0x9e3779b9)) + agg_hash6 + (agg_result5 << 6) + (agg_result5 >>> 2);
/* 204 */       }
/* 205 */
/* 206 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 207 */
/* 208 */       int agg_result6 = 0;
/* 209 */       byte[] agg_bytes6 = agg_key6.getBytes();
/* 210 */       for (int i = 0; i < agg_bytes6.length; i++) {
/* 211 */         int agg_hash7 = agg_bytes6[i];
/* 212 */         agg_result6 = (agg_result6 ^ (0x9e3779b9)) + agg_hash7 + (agg_result6 << 6) + (agg_result6 >>> 2);
/* 213 */       }
/* 214 */
/* 215 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result6 + (agg_hash << 6) + (agg_hash >>> 2);
/* 216 */
/* 217 */       int agg_result7 = agg_key7;
/* 218 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result7 + (agg_hash << 6) + (agg_hash >>> 2);
/* 219 */
/* 220 */       return agg_hash;
/* 221 */     }
/* 222 */
/* 223 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 224 */       return batch.rowIterator();
/* 225 */     }
/* 226 */
/* 227 */     public void close() {
/* 228 */       batch.close();
/* 229 */     }
/* 230 */
/* 231 */   }
/* 232 */
/* 233 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 234 */     agg_hashMap = agg_plan.createHashMap();
/* 235 */
/* 236 */     while (inputadapter_input.hasNext()) {
/* 237 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 238 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 239 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 240 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 241 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 242 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 243 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 244 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 245 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 246 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 247 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 248 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 249 */       UTF8String inputadapter_value5 = inputadapter_isNull5 ? null : (inputadapter_row.getUTF8String(5));
/* 250 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 251 */       UTF8String inputadapter_value6 = inputadapter_isNull6 ? null : (inputadapter_row.getUTF8String(6));
/* 252 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 253 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
/* 254 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 255 */       double inputadapter_value8 = inputadapter_isNull8 ? -1.0 : (inputadapter_row.getDouble(8));
/* 256 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 257 */       int inputadapter_value9 = inputadapter_isNull9 ? -1 : (inputadapter_row.getInt(9));
/* 258 */
/* 259 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 260 */
/* 261 */       UnsafeRow agg_fastAggBuffer = null;
/* 262 */
/* 263 */       if (true) {
/* 264 */         if (!inputadapter_isNull && !inputadapter_isNull1 && !inputadapter_isNull2 && !inputadapter_isNull3 && !inputadapter_isNull4 && !inputadapter_isNull5 && !inputadapter_isNull6 && !inputadapter_isNull9) {
/* 265 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 266 */             inputadapter_value, inputadapter_value1, inputadapter_value2, inputadapter_value3, inputadapter_value4, inputadapter_value5, inputadapter_value6, inputadapter_value9);
/* 267 */         }
/* 268 */       }
/* 269 */
/* 270 */       if (agg_fastAggBuffer == null) {
/* 271 */         // generate grouping key
/* 272 */         agg_holder.reset();
/* 273 */
/* 274 */         agg_rowWriter.zeroOutNullBytes();
/* 275 */
/* 276 */         if (inputadapter_isNull) {
/* 277 */           agg_rowWriter.setNullAt(0);
/* 278 */         } else {
/* 279 */           agg_rowWriter.write(0, inputadapter_value);
/* 280 */         }
/* 281 */
/* 282 */         if (inputadapter_isNull1) {
/* 283 */           agg_rowWriter.setNullAt(1);
/* 284 */         } else {
/* 285 */           agg_rowWriter.write(1, inputadapter_value1);
/* 286 */         }
/* 287 */
/* 288 */         if (inputadapter_isNull2) {
/* 289 */           agg_rowWriter.setNullAt(2);
/* 290 */         } else {
/* 291 */           agg_rowWriter.write(2, inputadapter_value2);
/* 292 */         }
/* 293 */
/* 294 */         if (inputadapter_isNull3) {
/* 295 */           agg_rowWriter.setNullAt(3);
/* 296 */         } else {
/* 297 */           agg_rowWriter.write(3, inputadapter_value3);
/* 298 */         }
/* 299 */
/* 300 */         if (inputadapter_isNull4) {
/* 301 */           agg_rowWriter.setNullAt(4);
/* 302 */         } else {
/* 303 */           agg_rowWriter.write(4, inputadapter_value4);
/* 304 */         }
/* 305 */
/* 306 */         if (inputadapter_isNull5) {
/* 307 */           agg_rowWriter.setNullAt(5);
/* 308 */         } else {
/* 309 */           agg_rowWriter.write(5, inputadapter_value5);
/* 310 */         }
/* 311 */
/* 312 */         if (inputadapter_isNull6) {
/* 313 */           agg_rowWriter.setNullAt(6);
/* 314 */         } else {
/* 315 */           agg_rowWriter.write(6, inputadapter_value6);
/* 316 */         }
/* 317 */
/* 318 */         if (inputadapter_isNull9) {
/* 319 */           agg_rowWriter.setNullAt(7);
/* 320 */         } else {
/* 321 */           agg_rowWriter.write(7, inputadapter_value9);
/* 322 */         }
/* 323 */         agg_result8.setTotalSize(agg_holder.totalSize());
/* 324 */         agg_value18 = 42;
/* 325 */
/* 326 */         if (!inputadapter_isNull) {
/* 327 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value18);
/* 328 */         }
/* 329 */
/* 330 */         if (!inputadapter_isNull1) {
/* 331 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value18);
/* 332 */         }
/* 333 */
/* 334 */         if (!inputadapter_isNull2) {
/* 335 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value18);
/* 336 */         }
/* 337 */
/* 338 */         if (!inputadapter_isNull3) {
/* 339 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value18);
/* 340 */         }
/* 341 */
/* 342 */         if (!inputadapter_isNull4) {
/* 343 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value4.getBaseObject(), inputadapter_value4.getBaseOffset(), inputadapter_value4.numBytes(), agg_value18);
/* 344 */         }
/* 345 */
/* 346 */         if (!inputadapter_isNull5) {
/* 347 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value5.getBaseObject(), inputadapter_value5.getBaseOffset(), inputadapter_value5.numBytes(), agg_value18);
/* 348 */         }
/* 349 */
/* 350 */         if (!inputadapter_isNull6) {
/* 351 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value6.getBaseObject(), inputadapter_value6.getBaseOffset(), inputadapter_value6.numBytes(), agg_value18);
/* 352 */         }
/* 353 */
/* 354 */         if (!inputadapter_isNull9) {
/* 355 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value9, agg_value18);
/* 356 */         }
/* 357 */         if (true) {
/* 358 */           // try to get the buffer from hash map
/* 359 */           agg_unsafeRowAggBuffer =
/* 360 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result8, agg_value18);
/* 361 */         }
/* 362 */         if (agg_unsafeRowAggBuffer == null) {
/* 363 */           if (agg_sorter == null) {
/* 364 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 365 */           } else {
/* 366 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 367 */           }
/* 368 */
/* 369 */           // the hash map had be spilled, it should have enough memory now,
/* 370 */           // try  to allocate buffer again.
/* 371 */           agg_unsafeRowAggBuffer =
/* 372 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result8, agg_value18);
/* 373 */           if (agg_unsafeRowAggBuffer == null) {
/* 374 */             // failed to allocate the first page
/* 375 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 376 */           }
/* 377 */         }
/* 378 */       }
/* 379 */
/* 380 */       if (agg_fastAggBuffer != null) {
/* 381 */         // update fast row
/* 382 */
/* 383 */         // common sub-expressions
/* 384 */
/* 385 */         // evaluate aggregate function
/* 386 */         boolean agg_isNull38 = true;
/* 387 */         double agg_value39 = -1.0;
/* 388 */
/* 389 */         boolean agg_isNull40 = agg_fastAggBuffer.isNullAt(0);
/* 390 */         double agg_value41 = agg_isNull40 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 391 */         boolean agg_isNull39 = agg_isNull40;
/* 392 */         double agg_value40 = agg_value41;
/* 393 */         if (agg_isNull39) {
/* 394 */           boolean agg_isNull41 = false;
/* 395 */           double agg_value42 = -1.0;
/* 396 */           if (!false) {
/* 397 */             agg_value42 = (double) 0;
/* 398 */           }
/* 399 */           if (!agg_isNull41) {
/* 400 */             agg_isNull39 = false;
/* 401 */             agg_value40 = agg_value42;
/* 402 */           }
/* 403 */         }
/* 404 */
/* 405 */         boolean agg_isNull44 = true;
/* 406 */         double agg_value45 = -1.0;
/* 407 */
/* 408 */         if (!inputadapter_isNull8) {
/* 409 */           if (!inputadapter_isNull7) {
/* 410 */             agg_isNull44 = false; // resultCode could change nullability.
/* 411 */             agg_value45 = inputadapter_value8 - inputadapter_value7;
/* 412 */
/* 413 */           }
/* 414 */
/* 415 */         }
/* 416 */         boolean agg_isNull43 = agg_isNull44;
/* 417 */         double agg_value44 = -1.0;
/* 418 */         if (!agg_isNull44) {
/* 419 */           agg_value44 = agg_value45;
/* 420 */         }
/* 421 */         if (!agg_isNull43) {
/* 422 */           agg_isNull38 = false; // resultCode could change nullability.
/* 423 */           agg_value39 = agg_value40 + agg_value44;
/* 424 */
/* 425 */         }
/* 426 */         boolean agg_isNull37 = agg_isNull38;
/* 427 */         double agg_value38 = agg_value39;
/* 428 */         if (agg_isNull37) {
/* 429 */           boolean agg_isNull47 = agg_fastAggBuffer.isNullAt(0);
/* 430 */           double agg_value48 = agg_isNull47 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 431 */           if (!agg_isNull47) {
/* 432 */             agg_isNull37 = false;
/* 433 */             agg_value38 = agg_value48;
/* 434 */           }
/* 435 */         }
/* 436 */         // update fast row
/* 437 */         if (!agg_isNull37) {
/* 438 */           agg_fastAggBuffer.setDouble(0, agg_value38);
/* 439 */         } else {
/* 440 */           agg_fastAggBuffer.setNullAt(0);
/* 441 */         }
/* 442 */
/* 443 */       } else {
/* 444 */         // update unsafe row
/* 445 */
/* 446 */         // common sub-expressions
/* 447 */
/* 448 */         // evaluate aggregate function
/* 449 */         boolean agg_isNull27 = true;
/* 450 */         double agg_value28 = -1.0;
/* 451 */
/* 452 */         boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 453 */         double agg_value30 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 454 */         boolean agg_isNull28 = agg_isNull29;
/* 455 */         double agg_value29 = agg_value30;
/* 456 */         if (agg_isNull28) {
/* 457 */           boolean agg_isNull30 = false;
/* 458 */           double agg_value31 = -1.0;
/* 459 */           if (!false) {
/* 460 */             agg_value31 = (double) 0;
/* 461 */           }
/* 462 */           if (!agg_isNull30) {
/* 463 */             agg_isNull28 = false;
/* 464 */             agg_value29 = agg_value31;
/* 465 */           }
/* 466 */         }
/* 467 */
/* 468 */         boolean agg_isNull33 = true;
/* 469 */         double agg_value34 = -1.0;
/* 470 */
/* 471 */         if (!inputadapter_isNull8) {
/* 472 */           if (!inputadapter_isNull7) {
/* 473 */             agg_isNull33 = false; // resultCode could change nullability.
/* 474 */             agg_value34 = inputadapter_value8 - inputadapter_value7;
/* 475 */
/* 476 */           }
/* 477 */
/* 478 */         }
/* 479 */         boolean agg_isNull32 = agg_isNull33;
/* 480 */         double agg_value33 = -1.0;
/* 481 */         if (!agg_isNull33) {
/* 482 */           agg_value33 = agg_value34;
/* 483 */         }
/* 484 */         if (!agg_isNull32) {
/* 485 */           agg_isNull27 = false; // resultCode could change nullability.
/* 486 */           agg_value28 = agg_value29 + agg_value33;
/* 487 */
/* 488 */         }
/* 489 */         boolean agg_isNull26 = agg_isNull27;
/* 490 */         double agg_value27 = agg_value28;
/* 491 */         if (agg_isNull26) {
/* 492 */           boolean agg_isNull36 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 493 */           double agg_value37 = agg_isNull36 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 494 */           if (!agg_isNull36) {
/* 495 */             agg_isNull26 = false;
/* 496 */             agg_value27 = agg_value37;
/* 497 */           }
/* 498 */         }
/* 499 */         // update unsafe row buffer
/* 500 */         if (!agg_isNull26) {
/* 501 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value27);
/* 502 */         } else {
/* 503 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 504 */         }
/* 505 */
/* 506 */       }
/* 507 */       if (shouldStop()) return;
/* 508 */     }
/* 509 */
/* 510 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 511 */
/* 512 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 513 */   }
/* 514 */
/* 515 */   protected void processNext() throws java.io.IOException {
/* 516 */     if (!agg_initAgg) {
/* 517 */       agg_initAgg = true;
/* 518 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 519 */       agg_doAggregateWithKeys();
/* 520 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 521 */     }
/* 522 */
/* 523 */     // output the result
/* 524 */
/* 525 */     while (agg_fastHashMapIter.next()) {
/* 526 */       wholestagecodegen_numOutputRows.add(1);
/* 527 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 528 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 529 */
/* 530 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 531 */
/* 532 */       append(agg_resultRow);
/* 533 */
/* 534 */       if (shouldStop()) return;
/* 535 */     }
/* 536 */     agg_fastHashMap.close();
/* 537 */
/* 538 */     while (agg_mapIter.next()) {
/* 539 */       wholestagecodegen_numOutputRows.add(1);
/* 540 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 541 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 542 */
/* 543 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 544 */
/* 545 */       append(agg_resultRow);
/* 546 */
/* 547 */       if (shouldStop()) return;
/* 548 */     }
/* 549 */
/* 550 */     agg_mapIter.close();
/* 551 */     if (agg_sorter == null) {
/* 552 */       agg_hashMap.free();
/* 553 */     }
/* 554 */   }
/* 555 */ }
