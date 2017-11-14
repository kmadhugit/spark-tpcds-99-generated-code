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
/* 020 */   private UnsafeRow agg_result4;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 023 */   private int agg_value10;
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
/* 043 */     agg_result4 = new UnsafeRow(4);
/* 044 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result4, 96);
/* 045 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
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
/* 064 */     .add("d_year", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 065 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 066 */     private Object emptyVBase;
/* 067 */     private long emptyVOff;
/* 068 */     private int emptyVLen;
/* 069 */     private boolean isBatchFull = false;
/* 070 */
/* 071 */     public agg_FastHashMap(
/* 072 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 073 */       InternalRow emptyAggregationBuffer) {
/* 074 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 075 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 076 */
/* 077 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 078 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 079 */
/* 080 */       emptyVBase = emptyBuffer;
/* 081 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 082 */       emptyVLen = emptyBuffer.length;
/* 083 */
/* 084 */       buckets = new int[numBuckets];
/* 085 */       java.util.Arrays.fill(buckets, -1);
/* 086 */     }
/* 087 */
/* 088 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3) {
/* 089 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3);
/* 090 */       int step = 0;
/* 091 */       int idx = (int) h & (numBuckets - 1);
/* 092 */       while (step < maxSteps) {
/* 093 */         // Return bucket index if it's either an empty slot or already contains the key
/* 094 */         if (buckets[idx] == -1) {
/* 095 */           if (numRows < capacity && !isBatchFull) {
/* 096 */             // creating the unsafe for new entry
/* 097 */             UnsafeRow agg_result = new UnsafeRow(4);
/* 098 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 099 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 100 */               96);
/* 101 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 102 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 103 */               agg_holder,
/* 104 */               4);
/* 105 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 106 */             agg_rowWriter.zeroOutNullBytes();
/* 107 */             agg_rowWriter.write(0, agg_key);
/* 108 */             agg_rowWriter.write(1, agg_key1);
/* 109 */             agg_rowWriter.write(2, agg_key2);
/* 110 */             agg_rowWriter.write(3, agg_key3);
/* 111 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 112 */             Object kbase = agg_result.getBaseObject();
/* 113 */             long koff = agg_result.getBaseOffset();
/* 114 */             int klen = agg_result.getSizeInBytes();
/* 115 */
/* 116 */             UnsafeRow vRow
/* 117 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 118 */             if (vRow == null) {
/* 119 */               isBatchFull = true;
/* 120 */             } else {
/* 121 */               buckets[idx] = numRows++;
/* 122 */             }
/* 123 */             return vRow;
/* 124 */           } else {
/* 125 */             // No more space
/* 126 */             return null;
/* 127 */           }
/* 128 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3)) {
/* 129 */           return batch.getValueRow(buckets[idx]);
/* 130 */         }
/* 131 */         idx = (idx + 1) & (numBuckets - 1);
/* 132 */         step++;
/* 133 */       }
/* 134 */       // Didn't find it
/* 135 */       return null;
/* 136 */     }
/* 137 */
/* 138 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3) {
/* 139 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 140 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getInt(3) == agg_key3);
/* 141 */     }
/* 142 */
/* 143 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3) {
/* 144 */       long agg_hash = 0;
/* 145 */
/* 146 */       int agg_result = 0;
/* 147 */       byte[] agg_bytes = agg_key.getBytes();
/* 148 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 149 */         int agg_hash1 = agg_bytes[i];
/* 150 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 151 */       }
/* 152 */
/* 153 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 154 */
/* 155 */       int agg_result1 = 0;
/* 156 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 157 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 158 */         int agg_hash2 = agg_bytes1[i];
/* 159 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 160 */       }
/* 161 */
/* 162 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 163 */
/* 164 */       int agg_result2 = 0;
/* 165 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 166 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 167 */         int agg_hash3 = agg_bytes2[i];
/* 168 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 169 */       }
/* 170 */
/* 171 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 172 */
/* 173 */       int agg_result3 = agg_key3;
/* 174 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 175 */
/* 176 */       return agg_hash;
/* 177 */     }
/* 178 */
/* 179 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 180 */       return batch.rowIterator();
/* 181 */     }
/* 182 */
/* 183 */     public void close() {
/* 184 */       batch.close();
/* 185 */     }
/* 186 */
/* 187 */   }
/* 188 */
/* 189 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 190 */     agg_hashMap = agg_plan.createHashMap();
/* 191 */
/* 192 */     while (inputadapter_input.hasNext()) {
/* 193 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 194 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 195 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 196 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 197 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 198 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 199 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 200 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 201 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 202 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 203 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 204 */
/* 205 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 206 */
/* 207 */       UnsafeRow agg_fastAggBuffer = null;
/* 208 */
/* 209 */       if (true) {
/* 210 */         if (!inputadapter_isNull && !inputadapter_isNull1 && !inputadapter_isNull2 && !inputadapter_isNull4) {
/* 211 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 212 */             inputadapter_value, inputadapter_value1, inputadapter_value2, inputadapter_value4);
/* 213 */         }
/* 214 */       }
/* 215 */
/* 216 */       if (agg_fastAggBuffer == null) {
/* 217 */         // generate grouping key
/* 218 */         agg_holder.reset();
/* 219 */
/* 220 */         agg_rowWriter.zeroOutNullBytes();
/* 221 */
/* 222 */         if (inputadapter_isNull) {
/* 223 */           agg_rowWriter.setNullAt(0);
/* 224 */         } else {
/* 225 */           agg_rowWriter.write(0, inputadapter_value);
/* 226 */         }
/* 227 */
/* 228 */         if (inputadapter_isNull1) {
/* 229 */           agg_rowWriter.setNullAt(1);
/* 230 */         } else {
/* 231 */           agg_rowWriter.write(1, inputadapter_value1);
/* 232 */         }
/* 233 */
/* 234 */         if (inputadapter_isNull2) {
/* 235 */           agg_rowWriter.setNullAt(2);
/* 236 */         } else {
/* 237 */           agg_rowWriter.write(2, inputadapter_value2);
/* 238 */         }
/* 239 */
/* 240 */         if (inputadapter_isNull4) {
/* 241 */           agg_rowWriter.setNullAt(3);
/* 242 */         } else {
/* 243 */           agg_rowWriter.write(3, inputadapter_value4);
/* 244 */         }
/* 245 */         agg_result4.setTotalSize(agg_holder.totalSize());
/* 246 */         agg_value10 = 42;
/* 247 */
/* 248 */         if (!inputadapter_isNull) {
/* 249 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value10);
/* 250 */         }
/* 251 */
/* 252 */         if (!inputadapter_isNull1) {
/* 253 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value10);
/* 254 */         }
/* 255 */
/* 256 */         if (!inputadapter_isNull2) {
/* 257 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value10);
/* 258 */         }
/* 259 */
/* 260 */         if (!inputadapter_isNull4) {
/* 261 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value4, agg_value10);
/* 262 */         }
/* 263 */         if (true) {
/* 264 */           // try to get the buffer from hash map
/* 265 */           agg_unsafeRowAggBuffer =
/* 266 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value10);
/* 267 */         }
/* 268 */         if (agg_unsafeRowAggBuffer == null) {
/* 269 */           if (agg_sorter == null) {
/* 270 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 271 */           } else {
/* 272 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 273 */           }
/* 274 */
/* 275 */           // the hash map had be spilled, it should have enough memory now,
/* 276 */           // try  to allocate buffer again.
/* 277 */           agg_unsafeRowAggBuffer =
/* 278 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value10);
/* 279 */           if (agg_unsafeRowAggBuffer == null) {
/* 280 */             // failed to allocate the first page
/* 281 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 282 */           }
/* 283 */         }
/* 284 */       }
/* 285 */
/* 286 */       if (agg_fastAggBuffer != null) {
/* 287 */         // update fast row
/* 288 */
/* 289 */         // common sub-expressions
/* 290 */
/* 291 */         // evaluate aggregate function
/* 292 */         boolean agg_isNull24 = true;
/* 293 */         double agg_value25 = -1.0;
/* 294 */
/* 295 */         boolean agg_isNull26 = agg_fastAggBuffer.isNullAt(0);
/* 296 */         double agg_value27 = agg_isNull26 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 297 */         boolean agg_isNull25 = agg_isNull26;
/* 298 */         double agg_value26 = agg_value27;
/* 299 */         if (agg_isNull25) {
/* 300 */           boolean agg_isNull27 = false;
/* 301 */           double agg_value28 = -1.0;
/* 302 */           if (!false) {
/* 303 */             agg_value28 = (double) 0;
/* 304 */           }
/* 305 */           if (!agg_isNull27) {
/* 306 */             agg_isNull25 = false;
/* 307 */             agg_value26 = agg_value28;
/* 308 */           }
/* 309 */         }
/* 310 */
/* 311 */         boolean agg_isNull29 = inputadapter_isNull3;
/* 312 */         double agg_value30 = -1.0;
/* 313 */         if (!inputadapter_isNull3) {
/* 314 */           agg_value30 = inputadapter_value3;
/* 315 */         }
/* 316 */         if (!agg_isNull29) {
/* 317 */           agg_isNull24 = false; // resultCode could change nullability.
/* 318 */           agg_value25 = agg_value26 + agg_value30;
/* 319 */
/* 320 */         }
/* 321 */         boolean agg_isNull23 = agg_isNull24;
/* 322 */         double agg_value24 = agg_value25;
/* 323 */         if (agg_isNull23) {
/* 324 */           boolean agg_isNull31 = agg_fastAggBuffer.isNullAt(0);
/* 325 */           double agg_value32 = agg_isNull31 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 326 */           if (!agg_isNull31) {
/* 327 */             agg_isNull23 = false;
/* 328 */             agg_value24 = agg_value32;
/* 329 */           }
/* 330 */         }
/* 331 */         // update fast row
/* 332 */         if (!agg_isNull23) {
/* 333 */           agg_fastAggBuffer.setDouble(0, agg_value24);
/* 334 */         } else {
/* 335 */           agg_fastAggBuffer.setNullAt(0);
/* 336 */         }
/* 337 */
/* 338 */       } else {
/* 339 */         // update unsafe row
/* 340 */
/* 341 */         // common sub-expressions
/* 342 */
/* 343 */         // evaluate aggregate function
/* 344 */         boolean agg_isNull15 = true;
/* 345 */         double agg_value16 = -1.0;
/* 346 */
/* 347 */         boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 348 */         double agg_value18 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 349 */         boolean agg_isNull16 = agg_isNull17;
/* 350 */         double agg_value17 = agg_value18;
/* 351 */         if (agg_isNull16) {
/* 352 */           boolean agg_isNull18 = false;
/* 353 */           double agg_value19 = -1.0;
/* 354 */           if (!false) {
/* 355 */             agg_value19 = (double) 0;
/* 356 */           }
/* 357 */           if (!agg_isNull18) {
/* 358 */             agg_isNull16 = false;
/* 359 */             agg_value17 = agg_value19;
/* 360 */           }
/* 361 */         }
/* 362 */
/* 363 */         boolean agg_isNull20 = inputadapter_isNull3;
/* 364 */         double agg_value21 = -1.0;
/* 365 */         if (!inputadapter_isNull3) {
/* 366 */           agg_value21 = inputadapter_value3;
/* 367 */         }
/* 368 */         if (!agg_isNull20) {
/* 369 */           agg_isNull15 = false; // resultCode could change nullability.
/* 370 */           agg_value16 = agg_value17 + agg_value21;
/* 371 */
/* 372 */         }
/* 373 */         boolean agg_isNull14 = agg_isNull15;
/* 374 */         double agg_value15 = agg_value16;
/* 375 */         if (agg_isNull14) {
/* 376 */           boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 377 */           double agg_value23 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 378 */           if (!agg_isNull22) {
/* 379 */             agg_isNull14 = false;
/* 380 */             agg_value15 = agg_value23;
/* 381 */           }
/* 382 */         }
/* 383 */         // update unsafe row buffer
/* 384 */         if (!agg_isNull14) {
/* 385 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value15);
/* 386 */         } else {
/* 387 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 388 */         }
/* 389 */
/* 390 */       }
/* 391 */       if (shouldStop()) return;
/* 392 */     }
/* 393 */
/* 394 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 395 */
/* 396 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 397 */   }
/* 398 */
/* 399 */   protected void processNext() throws java.io.IOException {
/* 400 */     if (!agg_initAgg) {
/* 401 */       agg_initAgg = true;
/* 402 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 403 */       agg_doAggregateWithKeys();
/* 404 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 405 */     }
/* 406 */
/* 407 */     // output the result
/* 408 */
/* 409 */     while (agg_fastHashMapIter.next()) {
/* 410 */       wholestagecodegen_numOutputRows.add(1);
/* 411 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 412 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 413 */
/* 414 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 415 */
/* 416 */       append(agg_resultRow);
/* 417 */
/* 418 */       if (shouldStop()) return;
/* 419 */     }
/* 420 */     agg_fastHashMap.close();
/* 421 */
/* 422 */     while (agg_mapIter.next()) {
/* 423 */       wholestagecodegen_numOutputRows.add(1);
/* 424 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 425 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 426 */
/* 427 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 428 */
/* 429 */       append(agg_resultRow);
/* 430 */
/* 431 */       if (shouldStop()) return;
/* 432 */     }
/* 433 */
/* 434 */     agg_mapIter.close();
/* 435 */     if (agg_sorter == null) {
/* 436 */       agg_hashMap.free();
/* 437 */     }
/* 438 */   }
/* 439 */ }
