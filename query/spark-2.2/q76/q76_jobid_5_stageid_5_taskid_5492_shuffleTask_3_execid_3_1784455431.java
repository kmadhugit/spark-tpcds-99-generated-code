/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private long agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private double agg_bufValue1;
/* 013 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 014 */   private agg_FastHashMap agg_fastHashMap;
/* 015 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 016 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 017 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 018 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 021 */   private scala.collection.Iterator inputadapter_input;
/* 022 */   private UnsafeRow agg_result5;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 025 */   private int agg_value14;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 029 */
/* 030 */   public GeneratedIterator(Object[] references) {
/* 031 */     this.references = references;
/* 032 */   }
/* 033 */
/* 034 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 035 */     partitionIndex = index;
/* 036 */     this.inputs = inputs;
/* 037 */     agg_initAgg = false;
/* 038 */
/* 039 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 040 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 041 */
/* 042 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 043 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 044 */     inputadapter_input = inputs[0];
/* 045 */     agg_result5 = new UnsafeRow(5);
/* 046 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result5, 64);
/* 047 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 048 */
/* 049 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 050 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 051 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 052 */
/* 053 */   }
/* 054 */
/* 055 */   public class agg_FastHashMap {
/* 056 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 057 */     private int[] buckets;
/* 058 */     private int capacity = 1 << 16;
/* 059 */     private double loadFactor = 0.5;
/* 060 */     private int numBuckets = (int) (capacity / loadFactor);
/* 061 */     private int maxSteps = 2;
/* 062 */     private int numRows = 0;
/* 063 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 064 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 065 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 066 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 067 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.StringType);
/* 068 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.LongType)
/* 069 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.DoubleType);
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
/* 092 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, int agg_key1, int agg_key2, int agg_key3, UTF8String agg_key4) {
/* 093 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4);
/* 094 */       int step = 0;
/* 095 */       int idx = (int) h & (numBuckets - 1);
/* 096 */       while (step < maxSteps) {
/* 097 */         // Return bucket index if it's either an empty slot or already contains the key
/* 098 */         if (buckets[idx] == -1) {
/* 099 */           if (numRows < capacity && !isBatchFull) {
/* 100 */             // creating the unsafe for new entry
/* 101 */             UnsafeRow agg_result = new UnsafeRow(5);
/* 102 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 103 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 104 */               64);
/* 105 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 106 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 107 */               agg_holder,
/* 108 */               5);
/* 109 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 110 */             agg_rowWriter.zeroOutNullBytes();
/* 111 */             agg_rowWriter.write(0, agg_key);
/* 112 */             agg_rowWriter.write(1, agg_key1);
/* 113 */             agg_rowWriter.write(2, agg_key2);
/* 114 */             agg_rowWriter.write(3, agg_key3);
/* 115 */             agg_rowWriter.write(4, agg_key4);
/* 116 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 117 */             Object kbase = agg_result.getBaseObject();
/* 118 */             long koff = agg_result.getBaseOffset();
/* 119 */             int klen = agg_result.getSizeInBytes();
/* 120 */
/* 121 */             UnsafeRow vRow
/* 122 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 123 */             if (vRow == null) {
/* 124 */               isBatchFull = true;
/* 125 */             } else {
/* 126 */               buckets[idx] = numRows++;
/* 127 */             }
/* 128 */             return vRow;
/* 129 */           } else {
/* 130 */             // No more space
/* 131 */             return null;
/* 132 */           }
/* 133 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4)) {
/* 134 */           return batch.getValueRow(buckets[idx]);
/* 135 */         }
/* 136 */         idx = (idx + 1) & (numBuckets - 1);
/* 137 */         step++;
/* 138 */       }
/* 139 */       // Didn't find it
/* 140 */       return null;
/* 141 */     }
/* 142 */
/* 143 */     private boolean equals(int idx, UTF8String agg_key, int agg_key1, int agg_key2, int agg_key3, UTF8String agg_key4) {
/* 144 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 145 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getInt(1) == agg_key1) && (row.getInt(2) == agg_key2) && (row.getInt(3) == agg_key3) && (row.getUTF8String(4).equals(agg_key4));
/* 146 */     }
/* 147 */
/* 148 */     private long hash(UTF8String agg_key, int agg_key1, int agg_key2, int agg_key3, UTF8String agg_key4) {
/* 149 */       long agg_hash = 0;
/* 150 */
/* 151 */       int agg_result = 0;
/* 152 */       byte[] agg_bytes = agg_key.getBytes();
/* 153 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 154 */         int agg_hash1 = agg_bytes[i];
/* 155 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 156 */       }
/* 157 */
/* 158 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 159 */
/* 160 */       int agg_result1 = agg_key1;
/* 161 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 162 */
/* 163 */       int agg_result2 = agg_key2;
/* 164 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 165 */
/* 166 */       int agg_result3 = agg_key3;
/* 167 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 168 */
/* 169 */       int agg_result4 = 0;
/* 170 */       byte[] agg_bytes1 = agg_key4.getBytes();
/* 171 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 172 */         int agg_hash2 = agg_bytes1[i];
/* 173 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash2 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 174 */       }
/* 175 */
/* 176 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 177 */
/* 178 */       return agg_hash;
/* 179 */     }
/* 180 */
/* 181 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 182 */       return batch.rowIterator();
/* 183 */     }
/* 184 */
/* 185 */     public void close() {
/* 186 */       batch.close();
/* 187 */     }
/* 188 */
/* 189 */   }
/* 190 */
/* 191 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 192 */     agg_hashMap = agg_plan.createHashMap();
/* 193 */
/* 194 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 195 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 196 */       UTF8String inputadapter_value = inputadapter_row.getUTF8String(0);
/* 197 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 198 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 199 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 200 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 201 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 202 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 203 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 204 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 205 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 206 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 207 */
/* 208 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 209 */
/* 210 */       UnsafeRow agg_fastAggBuffer = null;
/* 211 */
/* 212 */       if (true) {
/* 213 */         if (!false && !inputadapter_isNull1 && !inputadapter_isNull2 && !inputadapter_isNull3 && !inputadapter_isNull4) {
/* 214 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 215 */             inputadapter_value, inputadapter_value1, inputadapter_value2, inputadapter_value3, inputadapter_value4);
/* 216 */         }
/* 217 */       }
/* 218 */
/* 219 */       if (agg_fastAggBuffer == null) {
/* 220 */         // generate grouping key
/* 221 */         agg_holder.reset();
/* 222 */
/* 223 */         agg_rowWriter.zeroOutNullBytes();
/* 224 */
/* 225 */         agg_rowWriter.write(0, inputadapter_value);
/* 226 */
/* 227 */         if (inputadapter_isNull1) {
/* 228 */           agg_rowWriter.setNullAt(1);
/* 229 */         } else {
/* 230 */           agg_rowWriter.write(1, inputadapter_value1);
/* 231 */         }
/* 232 */
/* 233 */         if (inputadapter_isNull2) {
/* 234 */           agg_rowWriter.setNullAt(2);
/* 235 */         } else {
/* 236 */           agg_rowWriter.write(2, inputadapter_value2);
/* 237 */         }
/* 238 */
/* 239 */         if (inputadapter_isNull3) {
/* 240 */           agg_rowWriter.setNullAt(3);
/* 241 */         } else {
/* 242 */           agg_rowWriter.write(3, inputadapter_value3);
/* 243 */         }
/* 244 */
/* 245 */         if (inputadapter_isNull4) {
/* 246 */           agg_rowWriter.setNullAt(4);
/* 247 */         } else {
/* 248 */           agg_rowWriter.write(4, inputadapter_value4);
/* 249 */         }
/* 250 */         agg_result5.setTotalSize(agg_holder.totalSize());
/* 251 */         agg_value14 = 42;
/* 252 */
/* 253 */         agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value14);
/* 254 */
/* 255 */         if (!inputadapter_isNull1) {
/* 256 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value14);
/* 257 */         }
/* 258 */
/* 259 */         if (!inputadapter_isNull2) {
/* 260 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value14);
/* 261 */         }
/* 262 */
/* 263 */         if (!inputadapter_isNull3) {
/* 264 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value3, agg_value14);
/* 265 */         }
/* 266 */
/* 267 */         if (!inputadapter_isNull4) {
/* 268 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value4.getBaseObject(), inputadapter_value4.getBaseOffset(), inputadapter_value4.numBytes(), agg_value14);
/* 269 */         }
/* 270 */         if (true) {
/* 271 */           // try to get the buffer from hash map
/* 272 */           agg_unsafeRowAggBuffer =
/* 273 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value14);
/* 274 */         }
/* 275 */         if (agg_unsafeRowAggBuffer == null) {
/* 276 */           if (agg_sorter == null) {
/* 277 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 278 */           } else {
/* 279 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 280 */           }
/* 281 */
/* 282 */           // the hash map had be spilled, it should have enough memory now,
/* 283 */           // try  to allocate buffer again.
/* 284 */           agg_unsafeRowAggBuffer =
/* 285 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value14);
/* 286 */           if (agg_unsafeRowAggBuffer == null) {
/* 287 */             // failed to allocate the first page
/* 288 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 289 */           }
/* 290 */         }
/* 291 */       }
/* 292 */
/* 293 */       if (agg_fastAggBuffer != null) {
/* 294 */         // update fast row
/* 295 */
/* 296 */         // common sub-expressions
/* 297 */
/* 298 */         // evaluate aggregate function
/* 299 */         boolean agg_isNull29 = false;
/* 300 */
/* 301 */         long agg_value32 = agg_fastAggBuffer.getLong(0);
/* 302 */
/* 303 */         long agg_value31 = -1L;
/* 304 */         agg_value31 = agg_value32 + 1L;
/* 305 */         boolean agg_isNull33 = true;
/* 306 */         double agg_value35 = -1.0;
/* 307 */
/* 308 */         boolean agg_isNull35 = agg_fastAggBuffer.isNullAt(1);
/* 309 */         double agg_value37 = agg_isNull35 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 310 */         boolean agg_isNull34 = agg_isNull35;
/* 311 */         double agg_value36 = agg_value37;
/* 312 */         if (agg_isNull34) {
/* 313 */           boolean agg_isNull36 = false;
/* 314 */           double agg_value38 = -1.0;
/* 315 */           if (!false) {
/* 316 */             agg_value38 = (double) 0;
/* 317 */           }
/* 318 */           if (!agg_isNull36) {
/* 319 */             agg_isNull34 = false;
/* 320 */             agg_value36 = agg_value38;
/* 321 */           }
/* 322 */         }
/* 323 */
/* 324 */         if (!inputadapter_isNull5) {
/* 325 */           agg_isNull33 = false; // resultCode could change nullability.
/* 326 */           agg_value35 = agg_value36 + inputadapter_value5;
/* 327 */
/* 328 */         }
/* 329 */         boolean agg_isNull32 = agg_isNull33;
/* 330 */         double agg_value34 = agg_value35;
/* 331 */         if (agg_isNull32) {
/* 332 */           boolean agg_isNull39 = agg_fastAggBuffer.isNullAt(1);
/* 333 */           double agg_value41 = agg_isNull39 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 334 */           if (!agg_isNull39) {
/* 335 */             agg_isNull32 = false;
/* 336 */             agg_value34 = agg_value41;
/* 337 */           }
/* 338 */         }
/* 339 */         // update fast row
/* 340 */         agg_fastAggBuffer.setLong(0, agg_value31);
/* 341 */
/* 342 */         if (!agg_isNull32) {
/* 343 */           agg_fastAggBuffer.setDouble(1, agg_value34);
/* 344 */         } else {
/* 345 */           agg_fastAggBuffer.setNullAt(1);
/* 346 */         }
/* 347 */
/* 348 */       } else {
/* 349 */         // update unsafe row
/* 350 */
/* 351 */         // common sub-expressions
/* 352 */
/* 353 */         // evaluate aggregate function
/* 354 */         boolean agg_isNull18 = false;
/* 355 */
/* 356 */         long agg_value21 = agg_unsafeRowAggBuffer.getLong(0);
/* 357 */
/* 358 */         long agg_value20 = -1L;
/* 359 */         agg_value20 = agg_value21 + 1L;
/* 360 */         boolean agg_isNull22 = true;
/* 361 */         double agg_value24 = -1.0;
/* 362 */
/* 363 */         boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 364 */         double agg_value26 = agg_isNull24 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 365 */         boolean agg_isNull23 = agg_isNull24;
/* 366 */         double agg_value25 = agg_value26;
/* 367 */         if (agg_isNull23) {
/* 368 */           boolean agg_isNull25 = false;
/* 369 */           double agg_value27 = -1.0;
/* 370 */           if (!false) {
/* 371 */             agg_value27 = (double) 0;
/* 372 */           }
/* 373 */           if (!agg_isNull25) {
/* 374 */             agg_isNull23 = false;
/* 375 */             agg_value25 = agg_value27;
/* 376 */           }
/* 377 */         }
/* 378 */
/* 379 */         if (!inputadapter_isNull5) {
/* 380 */           agg_isNull22 = false; // resultCode could change nullability.
/* 381 */           agg_value24 = agg_value25 + inputadapter_value5;
/* 382 */
/* 383 */         }
/* 384 */         boolean agg_isNull21 = agg_isNull22;
/* 385 */         double agg_value23 = agg_value24;
/* 386 */         if (agg_isNull21) {
/* 387 */           boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 388 */           double agg_value30 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 389 */           if (!agg_isNull28) {
/* 390 */             agg_isNull21 = false;
/* 391 */             agg_value23 = agg_value30;
/* 392 */           }
/* 393 */         }
/* 394 */         // update unsafe row buffer
/* 395 */         agg_unsafeRowAggBuffer.setLong(0, agg_value20);
/* 396 */
/* 397 */         if (!agg_isNull21) {
/* 398 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value23);
/* 399 */         } else {
/* 400 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 401 */         }
/* 402 */
/* 403 */       }
/* 404 */       if (shouldStop()) return;
/* 405 */     }
/* 406 */
/* 407 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 408 */
/* 409 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 410 */   }
/* 411 */
/* 412 */   protected void processNext() throws java.io.IOException {
/* 413 */     if (!agg_initAgg) {
/* 414 */       agg_initAgg = true;
/* 415 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 416 */       agg_doAggregateWithKeys();
/* 417 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 418 */     }
/* 419 */
/* 420 */     // output the result
/* 421 */
/* 422 */     while (agg_fastHashMapIter.next()) {
/* 423 */       wholestagecodegen_numOutputRows.add(1);
/* 424 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 425 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 426 */
/* 427 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 428 */
/* 429 */       append(agg_resultRow);
/* 430 */
/* 431 */       if (shouldStop()) return;
/* 432 */     }
/* 433 */     agg_fastHashMap.close();
/* 434 */
/* 435 */     while (agg_mapIter.next()) {
/* 436 */       wholestagecodegen_numOutputRows.add(1);
/* 437 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 438 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 439 */
/* 440 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 441 */
/* 442 */       append(agg_resultRow);
/* 443 */
/* 444 */       if (shouldStop()) return;
/* 445 */     }
/* 446 */
/* 447 */     agg_mapIter.close();
/* 448 */     if (agg_sorter == null) {
/* 449 */       agg_hashMap.free();
/* 450 */     }
/* 451 */   }
/* 452 */ }
