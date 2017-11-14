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
/* 011 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 012 */   private agg_FastHashMap agg_fastHashMap;
/* 013 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 014 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 015 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 016 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 019 */   private scala.collection.Iterator scan_input;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 022 */   private long scan_scanTime1;
/* 023 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 024 */   private int scan_batchIdx;
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 026 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 028 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 030 */   private UnsafeRow scan_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 034 */   private UnsafeRow filter_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 037 */   private UnsafeRow project_result;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 040 */   private UnsafeRow agg_result1;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 043 */   private int agg_value4;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 045 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 046 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 047 */
/* 048 */   public GeneratedIterator(Object[] references) {
/* 049 */     this.references = references;
/* 050 */   }
/* 051 */
/* 052 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 053 */     partitionIndex = index;
/* 054 */     this.inputs = inputs;
/* 055 */     wholestagecodegen_init_0();
/* 056 */     wholestagecodegen_init_1();
/* 057 */
/* 058 */   }
/* 059 */
/* 060 */   private void wholestagecodegen_init_0() {
/* 061 */     agg_initAgg = false;
/* 062 */
/* 063 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 064 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 065 */
/* 066 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 067 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 068 */     scan_input = inputs[0];
/* 069 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 070 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 071 */     scan_scanTime1 = 0;
/* 072 */     scan_batch = null;
/* 073 */     scan_batchIdx = 0;
/* 074 */     scan_colInstance0 = null;
/* 075 */     scan_colInstance1 = null;
/* 076 */     scan_colInstance2 = null;
/* 077 */     scan_colInstance3 = null;
/* 078 */     scan_colInstance4 = null;
/* 079 */     scan_result = new UnsafeRow(5);
/* 080 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 160);
/* 081 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 5);
/* 082 */
/* 083 */   }
/* 084 */
/* 085 */   private void scan_nextBatch() throws java.io.IOException {
/* 086 */     long getBatchStart = System.nanoTime();
/* 087 */     if (scan_input.hasNext()) {
/* 088 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 089 */       scan_numOutputRows.add(scan_batch.numRows());
/* 090 */       scan_batchIdx = 0;
/* 091 */       scan_colInstance0 = scan_batch.column(0);
/* 092 */       scan_colInstance1 = scan_batch.column(1);
/* 093 */       scan_colInstance2 = scan_batch.column(2);
/* 094 */       scan_colInstance3 = scan_batch.column(3);
/* 095 */       scan_colInstance4 = scan_batch.column(4);
/* 096 */
/* 097 */     }
/* 098 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 099 */   }
/* 100 */
/* 101 */   public class agg_FastHashMap {
/* 102 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 103 */     private int[] buckets;
/* 104 */     private int capacity = 1 << 16;
/* 105 */     private double loadFactor = 0.5;
/* 106 */     private int numBuckets = (int) (capacity / loadFactor);
/* 107 */     private int maxSteps = 2;
/* 108 */     private int numRows = 0;
/* 109 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType);
/* 110 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.LongType);
/* 111 */     private Object emptyVBase;
/* 112 */     private long emptyVOff;
/* 113 */     private int emptyVLen;
/* 114 */     private boolean isBatchFull = false;
/* 115 */
/* 116 */     public agg_FastHashMap(
/* 117 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 118 */       InternalRow emptyAggregationBuffer) {
/* 119 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 120 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 121 */
/* 122 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 123 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 124 */
/* 125 */       emptyVBase = emptyBuffer;
/* 126 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 127 */       emptyVLen = emptyBuffer.length;
/* 128 */
/* 129 */       buckets = new int[numBuckets];
/* 130 */       java.util.Arrays.fill(buckets, -1);
/* 131 */     }
/* 132 */
/* 133 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key) {
/* 134 */       long h = hash(agg_key);
/* 135 */       int step = 0;
/* 136 */       int idx = (int) h & (numBuckets - 1);
/* 137 */       while (step < maxSteps) {
/* 138 */         // Return bucket index if it's either an empty slot or already contains the key
/* 139 */         if (buckets[idx] == -1) {
/* 140 */           if (numRows < capacity && !isBatchFull) {
/* 141 */             // creating the unsafe for new entry
/* 142 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 143 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 144 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 145 */               32);
/* 146 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 147 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 148 */               agg_holder,
/* 149 */               1);
/* 150 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 151 */             agg_rowWriter.zeroOutNullBytes();
/* 152 */             agg_rowWriter.write(0, agg_key);
/* 153 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 154 */             Object kbase = agg_result.getBaseObject();
/* 155 */             long koff = agg_result.getBaseOffset();
/* 156 */             int klen = agg_result.getSizeInBytes();
/* 157 */
/* 158 */             UnsafeRow vRow
/* 159 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 160 */             if (vRow == null) {
/* 161 */               isBatchFull = true;
/* 162 */             } else {
/* 163 */               buckets[idx] = numRows++;
/* 164 */             }
/* 165 */             return vRow;
/* 166 */           } else {
/* 167 */             // No more space
/* 168 */             return null;
/* 169 */           }
/* 170 */         } else if (equals(idx, agg_key)) {
/* 171 */           return batch.getValueRow(buckets[idx]);
/* 172 */         }
/* 173 */         idx = (idx + 1) & (numBuckets - 1);
/* 174 */         step++;
/* 175 */       }
/* 176 */       // Didn't find it
/* 177 */       return null;
/* 178 */     }
/* 179 */
/* 180 */     private boolean equals(int idx, UTF8String agg_key) {
/* 181 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 182 */       return (row.getUTF8String(0).equals(agg_key));
/* 183 */     }
/* 184 */
/* 185 */     private long hash(UTF8String agg_key) {
/* 186 */       long agg_hash = 0;
/* 187 */
/* 188 */       int agg_result = 0;
/* 189 */       byte[] agg_bytes = agg_key.getBytes();
/* 190 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 191 */         int agg_hash1 = agg_bytes[i];
/* 192 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 193 */       }
/* 194 */
/* 195 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 196 */
/* 197 */       return agg_hash;
/* 198 */     }
/* 199 */
/* 200 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 201 */       return batch.rowIterator();
/* 202 */     }
/* 203 */
/* 204 */     public void close() {
/* 205 */       batch.close();
/* 206 */     }
/* 207 */
/* 208 */   }
/* 209 */
/* 210 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 211 */     agg_hashMap = agg_plan.createHashMap();
/* 212 */
/* 213 */     if (scan_batch == null) {
/* 214 */       scan_nextBatch();
/* 215 */     }
/* 216 */     while (scan_batch != null) {
/* 217 */       int scan_numRows = scan_batch.numRows();
/* 218 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 219 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 220 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 221 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 222 */         UTF8String scan_value = scan_isNull ? null : (scan_colInstance0.getUTF8String(scan_rowIdx));
/* 223 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 224 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 225 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 226 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 227 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 228 */         UTF8String scan_value4 = scan_isNull4 ? null : (scan_colInstance4.getUTF8String(scan_rowIdx));
/* 229 */
/* 230 */         boolean filter_isNull3 = true;
/* 231 */         boolean filter_value3 = false;
/* 232 */
/* 233 */         if (!scan_isNull) {
/* 234 */           filter_isNull3 = false; // resultCode could change nullability.
/* 235 */           filter_value3 = scan_value.equals(((UTF8String) references[8]));
/* 236 */
/* 237 */         }
/* 238 */         boolean filter_isNull2 = false;
/* 239 */         boolean filter_value2 = false;
/* 240 */
/* 241 */         if (!filter_isNull3 && !filter_value3) {
/* 242 */         } else {
/* 243 */           boolean filter_isNull10 = true;
/* 244 */           boolean filter_value10 = false;
/* 245 */
/* 246 */           if (!scan_isNull3) {
/* 247 */             filter_isNull10 = false; // resultCode could change nullability.
/* 248 */             filter_value10 = scan_value3.equals(((UTF8String) references[9]));
/* 249 */
/* 250 */           }
/* 251 */           boolean filter_isNull9 = false;
/* 252 */           boolean filter_value9 = true;
/* 253 */
/* 254 */           if (!filter_isNull10 && filter_value10) {
/* 255 */           } else {
/* 256 */             boolean filter_isNull13 = true;
/* 257 */             boolean filter_value13 = false;
/* 258 */
/* 259 */             if (!scan_isNull3) {
/* 260 */               filter_isNull13 = false; // resultCode could change nullability.
/* 261 */               filter_value13 = scan_value3.equals(((UTF8String) references[10]));
/* 262 */
/* 263 */             }
/* 264 */             if (!filter_isNull13 && filter_value13) {
/* 265 */             } else if (!filter_isNull10 && !filter_isNull13) {
/* 266 */               filter_value9 = false;
/* 267 */             } else {
/* 268 */               filter_isNull9 = true;
/* 269 */             }
/* 270 */           }
/* 271 */           boolean filter_isNull8 = false;
/* 272 */           boolean filter_value8 = false;
/* 273 */
/* 274 */           if (!filter_isNull9 && !filter_value9) {
/* 275 */           } else {
/* 276 */             boolean filter_isNull17 = true;
/* 277 */             boolean filter_value17 = false;
/* 278 */
/* 279 */             if (!scan_isNull4) {
/* 280 */               filter_isNull17 = false; // resultCode could change nullability.
/* 281 */               filter_value17 = scan_value4.equals(((UTF8String) references[11]));
/* 282 */
/* 283 */             }
/* 284 */             boolean filter_isNull16 = false;
/* 285 */             boolean filter_value16 = true;
/* 286 */
/* 287 */             if (!filter_isNull17 && filter_value17) {
/* 288 */             } else {
/* 289 */               boolean filter_isNull20 = true;
/* 290 */               boolean filter_value20 = false;
/* 291 */
/* 292 */               if (!scan_isNull4) {
/* 293 */                 filter_isNull20 = false; // resultCode could change nullability.
/* 294 */                 filter_value20 = scan_value4.equals(((UTF8String) references[12]));
/* 295 */
/* 296 */               }
/* 297 */               if (!filter_isNull20 && filter_value20) {
/* 298 */               } else if (!filter_isNull17 && !filter_isNull20) {
/* 299 */                 filter_value16 = false;
/* 300 */               } else {
/* 301 */                 filter_isNull16 = true;
/* 302 */               }
/* 303 */             }
/* 304 */             if (!filter_isNull16 && !filter_value16) {
/* 305 */             } else if (!filter_isNull9 && !filter_isNull16) {
/* 306 */               filter_value8 = true;
/* 307 */             } else {
/* 308 */               filter_isNull8 = true;
/* 309 */             }
/* 310 */           }
/* 311 */           boolean filter_isNull7 = false;
/* 312 */           boolean filter_value7 = false;
/* 313 */
/* 314 */           if (!filter_isNull8 && !filter_value8) {
/* 315 */           } else {
/* 316 */             boolean filter_isNull24 = true;
/* 317 */             boolean filter_value24 = false;
/* 318 */
/* 319 */             if (!scan_isNull2) {
/* 320 */               filter_isNull24 = false; // resultCode could change nullability.
/* 321 */               filter_value24 = scan_value2.equals(((UTF8String) references[13]));
/* 322 */
/* 323 */             }
/* 324 */             boolean filter_isNull23 = false;
/* 325 */             boolean filter_value23 = true;
/* 326 */
/* 327 */             if (!filter_isNull24 && filter_value24) {
/* 328 */             } else {
/* 329 */               boolean filter_isNull27 = true;
/* 330 */               boolean filter_value27 = false;
/* 331 */
/* 332 */               if (!scan_isNull2) {
/* 333 */                 filter_isNull27 = false; // resultCode could change nullability.
/* 334 */                 filter_value27 = scan_value2.equals(((UTF8String) references[14]));
/* 335 */
/* 336 */               }
/* 337 */               if (!filter_isNull27 && filter_value27) {
/* 338 */               } else if (!filter_isNull24 && !filter_isNull27) {
/* 339 */                 filter_value23 = false;
/* 340 */               } else {
/* 341 */                 filter_isNull23 = true;
/* 342 */               }
/* 343 */             }
/* 344 */             if (!filter_isNull23 && !filter_value23) {
/* 345 */             } else if (!filter_isNull8 && !filter_isNull23) {
/* 346 */               filter_value7 = true;
/* 347 */             } else {
/* 348 */               filter_isNull7 = true;
/* 349 */             }
/* 350 */           }
/* 351 */           boolean filter_isNull6 = false;
/* 352 */           boolean filter_value6 = true;
/* 353 */
/* 354 */           if (!filter_isNull7 && filter_value7) {
/* 355 */           } else {
/* 356 */             boolean filter_isNull33 = true;
/* 357 */             boolean filter_value33 = false;
/* 358 */
/* 359 */             if (!scan_isNull3) {
/* 360 */               filter_isNull33 = false; // resultCode could change nullability.
/* 361 */               filter_value33 = scan_value3.equals(((UTF8String) references[15]));
/* 362 */
/* 363 */             }
/* 364 */             boolean filter_isNull32 = false;
/* 365 */             boolean filter_value32 = true;
/* 366 */
/* 367 */             if (!filter_isNull33 && filter_value33) {
/* 368 */             } else {
/* 369 */               boolean filter_isNull36 = true;
/* 370 */               boolean filter_value36 = false;
/* 371 */
/* 372 */               if (!scan_isNull3) {
/* 373 */                 filter_isNull36 = false; // resultCode could change nullability.
/* 374 */                 filter_value36 = scan_value3.equals(((UTF8String) references[16]));
/* 375 */
/* 376 */               }
/* 377 */               if (!filter_isNull36 && filter_value36) {
/* 378 */               } else if (!filter_isNull33 && !filter_isNull36) {
/* 379 */                 filter_value32 = false;
/* 380 */               } else {
/* 381 */                 filter_isNull32 = true;
/* 382 */               }
/* 383 */             }
/* 384 */             boolean filter_isNull31 = false;
/* 385 */             boolean filter_value31 = false;
/* 386 */
/* 387 */             if (!filter_isNull32 && !filter_value32) {
/* 388 */             } else {
/* 389 */               boolean filter_isNull40 = true;
/* 390 */               boolean filter_value40 = false;
/* 391 */
/* 392 */               if (!scan_isNull4) {
/* 393 */                 filter_isNull40 = false; // resultCode could change nullability.
/* 394 */                 filter_value40 = scan_value4.equals(((UTF8String) references[17]));
/* 395 */
/* 396 */               }
/* 397 */               boolean filter_isNull39 = false;
/* 398 */               boolean filter_value39 = true;
/* 399 */
/* 400 */               if (!filter_isNull40 && filter_value40) {
/* 401 */               } else {
/* 402 */                 boolean filter_isNull43 = true;
/* 403 */                 boolean filter_value43 = false;
/* 404 */
/* 405 */                 if (!scan_isNull4) {
/* 406 */                   filter_isNull43 = false; // resultCode could change nullability.
/* 407 */                   filter_value43 = scan_value4.equals(((UTF8String) references[18]));
/* 408 */
/* 409 */                 }
/* 410 */                 if (!filter_isNull43 && filter_value43) {
/* 411 */                 } else if (!filter_isNull40 && !filter_isNull43) {
/* 412 */                   filter_value39 = false;
/* 413 */                 } else {
/* 414 */                   filter_isNull39 = true;
/* 415 */                 }
/* 416 */               }
/* 417 */               if (!filter_isNull39 && !filter_value39) {
/* 418 */               } else if (!filter_isNull32 && !filter_isNull39) {
/* 419 */                 filter_value31 = true;
/* 420 */               } else {
/* 421 */                 filter_isNull31 = true;
/* 422 */               }
/* 423 */             }
/* 424 */             boolean filter_isNull30 = false;
/* 425 */             boolean filter_value30 = false;
/* 426 */
/* 427 */             if (!filter_isNull31 && !filter_value31) {
/* 428 */             } else {
/* 429 */               boolean filter_isNull47 = true;
/* 430 */               boolean filter_value47 = false;
/* 431 */
/* 432 */               if (!scan_isNull2) {
/* 433 */                 filter_isNull47 = false; // resultCode could change nullability.
/* 434 */                 filter_value47 = scan_value2.equals(((UTF8String) references[19]));
/* 435 */
/* 436 */               }
/* 437 */               boolean filter_isNull46 = false;
/* 438 */               boolean filter_value46 = true;
/* 439 */
/* 440 */               if (!filter_isNull47 && filter_value47) {
/* 441 */               } else {
/* 442 */                 boolean filter_isNull50 = true;
/* 443 */                 boolean filter_value50 = false;
/* 444 */
/* 445 */                 if (!scan_isNull2) {
/* 446 */                   filter_isNull50 = false; // resultCode could change nullability.
/* 447 */                   filter_value50 = scan_value2.equals(((UTF8String) references[20]));
/* 448 */
/* 449 */                 }
/* 450 */                 if (!filter_isNull50 && filter_value50) {
/* 451 */                 } else if (!filter_isNull47 && !filter_isNull50) {
/* 452 */                   filter_value46 = false;
/* 453 */                 } else {
/* 454 */                   filter_isNull46 = true;
/* 455 */                 }
/* 456 */               }
/* 457 */               if (!filter_isNull46 && !filter_value46) {
/* 458 */               } else if (!filter_isNull31 && !filter_isNull46) {
/* 459 */                 filter_value30 = true;
/* 460 */               } else {
/* 461 */                 filter_isNull30 = true;
/* 462 */               }
/* 463 */             }
/* 464 */             if (!filter_isNull30 && filter_value30) {
/* 465 */             } else if (!filter_isNull7 && !filter_isNull30) {
/* 466 */               filter_value6 = false;
/* 467 */             } else {
/* 468 */               filter_isNull6 = true;
/* 469 */             }
/* 470 */           }
/* 471 */           if (!filter_isNull6 && !filter_value6) {
/* 472 */           } else if (!filter_isNull3 && !filter_isNull6) {
/* 473 */             filter_value2 = true;
/* 474 */           } else {
/* 475 */             filter_isNull2 = true;
/* 476 */           }
/* 477 */         }
/* 478 */         boolean filter_isNull1 = false;
/* 479 */         boolean filter_value1 = true;
/* 480 */
/* 481 */         if (!filter_isNull2 && filter_value2) {
/* 482 */         } else {
/* 483 */           boolean filter_isNull54 = true;
/* 484 */           boolean filter_value54 = false;
/* 485 */
/* 486 */           if (!scan_isNull) {
/* 487 */             filter_isNull54 = false; // resultCode could change nullability.
/* 488 */             filter_value54 = scan_value.equals(((UTF8String) references[21]));
/* 489 */
/* 490 */           }
/* 491 */           boolean filter_isNull53 = false;
/* 492 */           boolean filter_value53 = false;
/* 493 */
/* 494 */           if (!filter_isNull54 && !filter_value54) {
/* 495 */           } else {
/* 496 */             boolean filter_isNull61 = true;
/* 497 */             boolean filter_value61 = false;
/* 498 */
/* 499 */             if (!scan_isNull3) {
/* 500 */               filter_isNull61 = false; // resultCode could change nullability.
/* 501 */               filter_value61 = scan_value3.equals(((UTF8String) references[22]));
/* 502 */
/* 503 */             }
/* 504 */             boolean filter_isNull60 = false;
/* 505 */             boolean filter_value60 = true;
/* 506 */
/* 507 */             if (!filter_isNull61 && filter_value61) {
/* 508 */             } else {
/* 509 */               boolean filter_isNull64 = true;
/* 510 */               boolean filter_value64 = false;
/* 511 */
/* 512 */               if (!scan_isNull3) {
/* 513 */                 filter_isNull64 = false; // resultCode could change nullability.
/* 514 */                 filter_value64 = scan_value3.equals(((UTF8String) references[23]));
/* 515 */
/* 516 */               }
/* 517 */               if (!filter_isNull64 && filter_value64) {
/* 518 */               } else if (!filter_isNull61 && !filter_isNull64) {
/* 519 */                 filter_value60 = false;
/* 520 */               } else {
/* 521 */                 filter_isNull60 = true;
/* 522 */               }
/* 523 */             }
/* 524 */             boolean filter_isNull59 = false;
/* 525 */             boolean filter_value59 = false;
/* 526 */
/* 527 */             if (!filter_isNull60 && !filter_value60) {
/* 528 */             } else {
/* 529 */               boolean filter_isNull68 = true;
/* 530 */               boolean filter_value68 = false;
/* 531 */
/* 532 */               if (!scan_isNull4) {
/* 533 */                 filter_isNull68 = false; // resultCode could change nullability.
/* 534 */                 filter_value68 = scan_value4.equals(((UTF8String) references[24]));
/* 535 */
/* 536 */               }
/* 537 */               boolean filter_isNull67 = false;
/* 538 */               boolean filter_value67 = true;
/* 539 */
/* 540 */               if (!filter_isNull68 && filter_value68) {
/* 541 */               } else {
/* 542 */                 boolean filter_isNull71 = true;
/* 543 */                 boolean filter_value71 = false;
/* 544 */
/* 545 */                 if (!scan_isNull4) {
/* 546 */                   filter_isNull71 = false; // resultCode could change nullability.
/* 547 */                   filter_value71 = scan_value4.equals(((UTF8String) references[25]));
/* 548 */
/* 549 */                 }
/* 550 */                 if (!filter_isNull71 && filter_value71) {
/* 551 */                 } else if (!filter_isNull68 && !filter_isNull71) {
/* 552 */                   filter_value67 = false;
/* 553 */                 } else {
/* 554 */                   filter_isNull67 = true;
/* 555 */                 }
/* 556 */               }
/* 557 */               if (!filter_isNull67 && !filter_value67) {
/* 558 */               } else if (!filter_isNull60 && !filter_isNull67) {
/* 559 */                 filter_value59 = true;
/* 560 */               } else {
/* 561 */                 filter_isNull59 = true;
/* 562 */               }
/* 563 */             }
/* 564 */             boolean filter_isNull58 = false;
/* 565 */             boolean filter_value58 = false;
/* 566 */
/* 567 */             if (!filter_isNull59 && !filter_value59) {
/* 568 */             } else {
/* 569 */               boolean filter_isNull75 = true;
/* 570 */               boolean filter_value75 = false;
/* 571 */
/* 572 */               if (!scan_isNull2) {
/* 573 */                 filter_isNull75 = false; // resultCode could change nullability.
/* 574 */                 filter_value75 = scan_value2.equals(((UTF8String) references[26]));
/* 575 */
/* 576 */               }
/* 577 */               boolean filter_isNull74 = false;
/* 578 */               boolean filter_value74 = true;
/* 579 */
/* 580 */               if (!filter_isNull75 && filter_value75) {
/* 581 */               } else {
/* 582 */                 boolean filter_isNull78 = true;
/* 583 */                 boolean filter_value78 = false;
/* 584 */
/* 585 */                 if (!scan_isNull2) {
/* 586 */                   filter_isNull78 = false; // resultCode could change nullability.
/* 587 */                   filter_value78 = scan_value2.equals(((UTF8String) references[27]));
/* 588 */
/* 589 */                 }
/* 590 */                 if (!filter_isNull78 && filter_value78) {
/* 591 */                 } else if (!filter_isNull75 && !filter_isNull78) {
/* 592 */                   filter_value74 = false;
/* 593 */                 } else {
/* 594 */                   filter_isNull74 = true;
/* 595 */                 }
/* 596 */               }
/* 597 */               if (!filter_isNull74 && !filter_value74) {
/* 598 */               } else if (!filter_isNull59 && !filter_isNull74) {
/* 599 */                 filter_value58 = true;
/* 600 */               } else {
/* 601 */                 filter_isNull58 = true;
/* 602 */               }
/* 603 */             }
/* 604 */             boolean filter_isNull57 = false;
/* 605 */             boolean filter_value57 = true;
/* 606 */
/* 607 */             if (!filter_isNull58 && filter_value58) {
/* 608 */             } else {
/* 609 */               boolean filter_isNull84 = true;
/* 610 */               boolean filter_value84 = false;
/* 611 */
/* 612 */               if (!scan_isNull3) {
/* 613 */                 filter_isNull84 = false; // resultCode could change nullability.
/* 614 */                 filter_value84 = scan_value3.equals(((UTF8String) references[28]));
/* 615 */
/* 616 */               }
/* 617 */               boolean filter_isNull83 = false;
/* 618 */               boolean filter_value83 = true;
/* 619 */
/* 620 */               if (!filter_isNull84 && filter_value84) {
/* 621 */               } else {
/* 622 */                 boolean filter_isNull87 = true;
/* 623 */                 boolean filter_value87 = false;
/* 624 */
/* 625 */                 if (!scan_isNull3) {
/* 626 */                   filter_isNull87 = false; // resultCode could change nullability.
/* 627 */                   filter_value87 = scan_value3.equals(((UTF8String) references[29]));
/* 628 */
/* 629 */                 }
/* 630 */                 if (!filter_isNull87 && filter_value87) {
/* 631 */                 } else if (!filter_isNull84 && !filter_isNull87) {
/* 632 */                   filter_value83 = false;
/* 633 */                 } else {
/* 634 */                   filter_isNull83 = true;
/* 635 */                 }
/* 636 */               }
/* 637 */               boolean filter_isNull82 = false;
/* 638 */               boolean filter_value82 = false;
/* 639 */
/* 640 */               if (!filter_isNull83 && !filter_value83) {
/* 641 */               } else {
/* 642 */                 boolean filter_isNull91 = true;
/* 643 */                 boolean filter_value91 = false;
/* 644 */
/* 645 */                 if (!scan_isNull4) {
/* 646 */                   filter_isNull91 = false; // resultCode could change nullability.
/* 647 */                   filter_value91 = scan_value4.equals(((UTF8String) references[30]));
/* 648 */
/* 649 */                 }
/* 650 */                 boolean filter_isNull90 = false;
/* 651 */                 boolean filter_value90 = true;
/* 652 */
/* 653 */                 if (!filter_isNull91 && filter_value91) {
/* 654 */                 } else {
/* 655 */                   boolean filter_isNull94 = true;
/* 656 */                   boolean filter_value94 = false;
/* 657 */
/* 658 */                   if (!scan_isNull4) {
/* 659 */                     filter_isNull94 = false; // resultCode could change nullability.
/* 660 */                     filter_value94 = scan_value4.equals(((UTF8String) references[31]));
/* 661 */
/* 662 */                   }
/* 663 */                   if (!filter_isNull94 && filter_value94) {
/* 664 */                   } else if (!filter_isNull91 && !filter_isNull94) {
/* 665 */                     filter_value90 = false;
/* 666 */                   } else {
/* 667 */                     filter_isNull90 = true;
/* 668 */                   }
/* 669 */                 }
/* 670 */                 if (!filter_isNull90 && !filter_value90) {
/* 671 */                 } else if (!filter_isNull83 && !filter_isNull90) {
/* 672 */                   filter_value82 = true;
/* 673 */                 } else {
/* 674 */                   filter_isNull82 = true;
/* 675 */                 }
/* 676 */               }
/* 677 */               boolean filter_isNull81 = false;
/* 678 */               boolean filter_value81 = false;
/* 679 */
/* 680 */               if (!filter_isNull82 && !filter_value82) {
/* 681 */               } else {
/* 682 */                 boolean filter_isNull98 = true;
/* 683 */                 boolean filter_value98 = false;
/* 684 */
/* 685 */                 if (!scan_isNull2) {
/* 686 */                   filter_isNull98 = false; // resultCode could change nullability.
/* 687 */                   filter_value98 = scan_value2.equals(((UTF8String) references[32]));
/* 688 */
/* 689 */                 }
/* 690 */                 boolean filter_isNull97 = false;
/* 691 */                 boolean filter_value97 = true;
/* 692 */
/* 693 */                 if (!filter_isNull98 && filter_value98) {
/* 694 */                 } else {
/* 695 */                   boolean filter_isNull101 = true;
/* 696 */                   boolean filter_value101 = false;
/* 697 */
/* 698 */                   if (!scan_isNull2) {
/* 699 */                     filter_isNull101 = false; // resultCode could change nullability.
/* 700 */                     filter_value101 = scan_value2.equals(((UTF8String) references[33]));
/* 701 */
/* 702 */                   }
/* 703 */                   if (!filter_isNull101 && filter_value101) {
/* 704 */                   } else if (!filter_isNull98 && !filter_isNull101) {
/* 705 */                     filter_value97 = false;
/* 706 */                   } else {
/* 707 */                     filter_isNull97 = true;
/* 708 */                   }
/* 709 */                 }
/* 710 */                 if (!filter_isNull97 && !filter_value97) {
/* 711 */                 } else if (!filter_isNull82 && !filter_isNull97) {
/* 712 */                   filter_value81 = true;
/* 713 */                 } else {
/* 714 */                   filter_isNull81 = true;
/* 715 */                 }
/* 716 */               }
/* 717 */               if (!filter_isNull81 && filter_value81) {
/* 718 */               } else if (!filter_isNull58 && !filter_isNull81) {
/* 719 */                 filter_value57 = false;
/* 720 */               } else {
/* 721 */                 filter_isNull57 = true;
/* 722 */               }
/* 723 */             }
/* 724 */             if (!filter_isNull57 && !filter_value57) {
/* 725 */             } else if (!filter_isNull54 && !filter_isNull57) {
/* 726 */               filter_value53 = true;
/* 727 */             } else {
/* 728 */               filter_isNull53 = true;
/* 729 */             }
/* 730 */           }
/* 731 */           if (!filter_isNull53 && filter_value53) {
/* 732 */           } else if (!filter_isNull2 && !filter_isNull53) {
/* 733 */             filter_value1 = false;
/* 734 */           } else {
/* 735 */             filter_isNull1 = true;
/* 736 */           }
/* 737 */         }
/* 738 */         boolean filter_isNull = false;
/* 739 */         boolean filter_value = true;
/* 740 */
/* 741 */         if (!filter_isNull1 && filter_value1) {
/* 742 */         } else {
/* 743 */           boolean filter_isNull106 = true;
/* 744 */           boolean filter_value106 = false;
/* 745 */
/* 746 */           if (!scan_isNull) {
/* 747 */             filter_isNull106 = false; // resultCode could change nullability.
/* 748 */             filter_value106 = scan_value.equals(((UTF8String) references[34]));
/* 749 */
/* 750 */           }
/* 751 */           boolean filter_isNull105 = false;
/* 752 */           boolean filter_value105 = false;
/* 753 */
/* 754 */           if (!filter_isNull106 && !filter_value106) {
/* 755 */           } else {
/* 756 */             boolean filter_isNull113 = true;
/* 757 */             boolean filter_value113 = false;
/* 758 */
/* 759 */             if (!scan_isNull3) {
/* 760 */               filter_isNull113 = false; // resultCode could change nullability.
/* 761 */               filter_value113 = scan_value3.equals(((UTF8String) references[35]));
/* 762 */
/* 763 */             }
/* 764 */             boolean filter_isNull112 = false;
/* 765 */             boolean filter_value112 = true;
/* 766 */
/* 767 */             if (!filter_isNull113 && filter_value113) {
/* 768 */             } else {
/* 769 */               boolean filter_isNull116 = true;
/* 770 */               boolean filter_value116 = false;
/* 771 */
/* 772 */               if (!scan_isNull3) {
/* 773 */                 filter_isNull116 = false; // resultCode could change nullability.
/* 774 */                 filter_value116 = scan_value3.equals(((UTF8String) references[36]));
/* 775 */
/* 776 */               }
/* 777 */               if (!filter_isNull116 && filter_value116) {
/* 778 */               } else if (!filter_isNull113 && !filter_isNull116) {
/* 779 */                 filter_value112 = false;
/* 780 */               } else {
/* 781 */                 filter_isNull112 = true;
/* 782 */               }
/* 783 */             }
/* 784 */             boolean filter_isNull111 = false;
/* 785 */             boolean filter_value111 = false;
/* 786 */
/* 787 */             if (!filter_isNull112 && !filter_value112) {
/* 788 */             } else {
/* 789 */               boolean filter_isNull120 = true;
/* 790 */               boolean filter_value120 = false;
/* 791 */
/* 792 */               if (!scan_isNull4) {
/* 793 */                 filter_isNull120 = false; // resultCode could change nullability.
/* 794 */                 filter_value120 = scan_value4.equals(((UTF8String) references[37]));
/* 795 */
/* 796 */               }
/* 797 */               boolean filter_isNull119 = false;
/* 798 */               boolean filter_value119 = true;
/* 799 */
/* 800 */               if (!filter_isNull120 && filter_value120) {
/* 801 */               } else {
/* 802 */                 boolean filter_isNull123 = true;
/* 803 */                 boolean filter_value123 = false;
/* 804 */
/* 805 */                 if (!scan_isNull4) {
/* 806 */                   filter_isNull123 = false; // resultCode could change nullability.
/* 807 */                   filter_value123 = scan_value4.equals(((UTF8String) references[38]));
/* 808 */
/* 809 */                 }
/* 810 */                 if (!filter_isNull123 && filter_value123) {
/* 811 */                 } else if (!filter_isNull120 && !filter_isNull123) {
/* 812 */                   filter_value119 = false;
/* 813 */                 } else {
/* 814 */                   filter_isNull119 = true;
/* 815 */                 }
/* 816 */               }
/* 817 */               if (!filter_isNull119 && !filter_value119) {
/* 818 */               } else if (!filter_isNull112 && !filter_isNull119) {
/* 819 */                 filter_value111 = true;
/* 820 */               } else {
/* 821 */                 filter_isNull111 = true;
/* 822 */               }
/* 823 */             }
/* 824 */             boolean filter_isNull110 = false;
/* 825 */             boolean filter_value110 = false;
/* 826 */
/* 827 */             if (!filter_isNull111 && !filter_value111) {
/* 828 */             } else {
/* 829 */               boolean filter_isNull127 = true;
/* 830 */               boolean filter_value127 = false;
/* 831 */
/* 832 */               if (!scan_isNull2) {
/* 833 */                 filter_isNull127 = false; // resultCode could change nullability.
/* 834 */                 filter_value127 = scan_value2.equals(((UTF8String) references[39]));
/* 835 */
/* 836 */               }
/* 837 */               boolean filter_isNull126 = false;
/* 838 */               boolean filter_value126 = true;
/* 839 */
/* 840 */               if (!filter_isNull127 && filter_value127) {
/* 841 */               } else {
/* 842 */                 boolean filter_isNull130 = true;
/* 843 */                 boolean filter_value130 = false;
/* 844 */
/* 845 */                 if (!scan_isNull2) {
/* 846 */                   filter_isNull130 = false; // resultCode could change nullability.
/* 847 */                   filter_value130 = scan_value2.equals(((UTF8String) references[40]));
/* 848 */
/* 849 */                 }
/* 850 */                 if (!filter_isNull130 && filter_value130) {
/* 851 */                 } else if (!filter_isNull127 && !filter_isNull130) {
/* 852 */                   filter_value126 = false;
/* 853 */                 } else {
/* 854 */                   filter_isNull126 = true;
/* 855 */                 }
/* 856 */               }
/* 857 */               if (!filter_isNull126 && !filter_value126) {
/* 858 */               } else if (!filter_isNull111 && !filter_isNull126) {
/* 859 */                 filter_value110 = true;
/* 860 */               } else {
/* 861 */                 filter_isNull110 = true;
/* 862 */               }
/* 863 */             }
/* 864 */             boolean filter_isNull109 = false;
/* 865 */             boolean filter_value109 = true;
/* 866 */
/* 867 */             if (!filter_isNull110 && filter_value110) {
/* 868 */             } else {
/* 869 */               boolean filter_isNull136 = true;
/* 870 */               boolean filter_value136 = false;
/* 871 */
/* 872 */               if (!scan_isNull3) {
/* 873 */                 filter_isNull136 = false; // resultCode could change nullability.
/* 874 */                 filter_value136 = scan_value3.equals(((UTF8String) references[41]));
/* 875 */
/* 876 */               }
/* 877 */               boolean filter_isNull135 = false;
/* 878 */               boolean filter_value135 = true;
/* 879 */
/* 880 */               if (!filter_isNull136 && filter_value136) {
/* 881 */               } else {
/* 882 */                 boolean filter_isNull139 = true;
/* 883 */                 boolean filter_value139 = false;
/* 884 */
/* 885 */                 if (!scan_isNull3) {
/* 886 */                   filter_isNull139 = false; // resultCode could change nullability.
/* 887 */                   filter_value139 = scan_value3.equals(((UTF8String) references[42]));
/* 888 */
/* 889 */                 }
/* 890 */                 if (!filter_isNull139 && filter_value139) {
/* 891 */                 } else if (!filter_isNull136 && !filter_isNull139) {
/* 892 */                   filter_value135 = false;
/* 893 */                 } else {
/* 894 */                   filter_isNull135 = true;
/* 895 */                 }
/* 896 */               }
/* 897 */               boolean filter_isNull134 = false;
/* 898 */               boolean filter_value134 = false;
/* 899 */
/* 900 */               if (!filter_isNull135 && !filter_value135) {
/* 901 */               } else {
/* 902 */                 boolean filter_isNull143 = true;
/* 903 */                 boolean filter_value143 = false;
/* 904 */
/* 905 */                 if (!scan_isNull4) {
/* 906 */                   filter_isNull143 = false; // resultCode could change nullability.
/* 907 */                   filter_value143 = scan_value4.equals(((UTF8String) references[43]));
/* 908 */
/* 909 */                 }
/* 910 */                 boolean filter_isNull142 = false;
/* 911 */                 boolean filter_value142 = true;
/* 912 */
/* 913 */                 if (!filter_isNull143 && filter_value143) {
/* 914 */                 } else {
/* 915 */                   boolean filter_isNull146 = true;
/* 916 */                   boolean filter_value146 = false;
/* 917 */
/* 918 */                   if (!scan_isNull4) {
/* 919 */                     filter_isNull146 = false; // resultCode could change nullability.
/* 920 */                     filter_value146 = scan_value4.equals(((UTF8String) references[44]));
/* 921 */
/* 922 */                   }
/* 923 */                   if (!filter_isNull146 && filter_value146) {
/* 924 */                   } else if (!filter_isNull143 && !filter_isNull146) {
/* 925 */                     filter_value142 = false;
/* 926 */                   } else {
/* 927 */                     filter_isNull142 = true;
/* 928 */                   }
/* 929 */                 }
/* 930 */                 if (!filter_isNull142 && !filter_value142) {
/* 931 */                 } else if (!filter_isNull135 && !filter_isNull142) {
/* 932 */                   filter_value134 = true;
/* 933 */                 } else {
/* 934 */                   filter_isNull134 = true;
/* 935 */                 }
/* 936 */               }
/* 937 */               boolean filter_isNull133 = false;
/* 938 */               boolean filter_value133 = false;
/* 939 */
/* 940 */               if (!filter_isNull134 && !filter_value134) {
/* 941 */               } else {
/* 942 */                 boolean filter_isNull150 = true;
/* 943 */                 boolean filter_value150 = false;
/* 944 */
/* 945 */                 if (!scan_isNull2) {
/* 946 */                   filter_isNull150 = false; // resultCode could change nullability.
/* 947 */                   filter_value150 = scan_value2.equals(((UTF8String) references[45]));
/* 948 */
/* 949 */                 }
/* 950 */                 boolean filter_isNull149 = false;
/* 951 */                 boolean filter_value149 = true;
/* 952 */
/* 953 */                 if (!filter_isNull150 && filter_value150) {
/* 954 */                 } else {
/* 955 */                   boolean filter_isNull153 = true;
/* 956 */                   boolean filter_value153 = false;
/* 957 */
/* 958 */                   if (!scan_isNull2) {
/* 959 */                     filter_isNull153 = false; // resultCode could change nullability.
/* 960 */                     filter_value153 = scan_value2.equals(((UTF8String) references[46]));
/* 961 */
/* 962 */                   }
/* 963 */                   if (!filter_isNull153 && filter_value153) {
/* 964 */                   } else if (!filter_isNull150 && !filter_isNull153) {
/* 965 */                     filter_value149 = false;
/* 966 */                   } else {
/* 967 */                     filter_isNull149 = true;
/* 968 */                   }
/* 969 */                 }
/* 970 */                 if (!filter_isNull149 && !filter_value149) {
/* 971 */                 } else if (!filter_isNull134 && !filter_isNull149) {
/* 972 */                   filter_value133 = true;
/* 973 */                 } else {
/* 974 */                   filter_isNull133 = true;
/* 975 */                 }
/* 976 */               }
/* 977 */               if (!filter_isNull133 && filter_value133) {
/* 978 */               } else if (!filter_isNull110 && !filter_isNull133) {
/* 979 */                 filter_value109 = false;
/* 980 */               } else {
/* 981 */                 filter_isNull109 = true;
/* 982 */               }
/* 983 */             }
/* 984 */             if (!filter_isNull109 && !filter_value109) {
/* 985 */             } else if (!filter_isNull106 && !filter_isNull109) {
/* 986 */               filter_value105 = true;
/* 987 */             } else {
/* 988 */               filter_isNull105 = true;
/* 989 */             }
/* 990 */           }
/* 991 */           boolean filter_isNull104 = false;
/* 992 */           boolean filter_value104 = true;
/* 993 */
/* 994 */           if (!filter_isNull105 && filter_value105) {
/* 995 */           } else {
/* 996 */             boolean filter_isNull157 = true;
/* 997 */             boolean filter_value157 = false;
/* 998 */
/* 999 */             if (!scan_isNull) {
/* 1000 */               filter_isNull157 = false; // resultCode could change nullability.
/* 1001 */               filter_value157 = scan_value.equals(((UTF8String) references[47]));
/* 1002 */
/* 1003 */             }
/* 1004 */             boolean filter_isNull156 = false;
/* 1005 */             boolean filter_value156 = false;
/* 1006 */
/* 1007 */             if (!filter_isNull157 && !filter_value157) {
/* 1008 */             } else {
/* 1009 */               boolean filter_isNull164 = true;
/* 1010 */               boolean filter_value164 = false;
/* 1011 */
/* 1012 */               if (!scan_isNull3) {
/* 1013 */                 filter_isNull164 = false; // resultCode could change nullability.
/* 1014 */                 filter_value164 = scan_value3.equals(((UTF8String) references[48]));
/* 1015 */
/* 1016 */               }
/* 1017 */               boolean filter_isNull163 = false;
/* 1018 */               boolean filter_value163 = true;
/* 1019 */
/* 1020 */               if (!filter_isNull164 && filter_value164) {
/* 1021 */               } else {
/* 1022 */                 boolean filter_isNull167 = true;
/* 1023 */                 boolean filter_value167 = false;
/* 1024 */
/* 1025 */                 if (!scan_isNull3) {
/* 1026 */                   filter_isNull167 = false; // resultCode could change nullability.
/* 1027 */                   filter_value167 = scan_value3.equals(((UTF8String) references[49]));
/* 1028 */
/* 1029 */                 }
/* 1030 */                 if (!filter_isNull167 && filter_value167) {
/* 1031 */                 } else if (!filter_isNull164 && !filter_isNull167) {
/* 1032 */                   filter_value163 = false;
/* 1033 */                 } else {
/* 1034 */                   filter_isNull163 = true;
/* 1035 */                 }
/* 1036 */               }
/* 1037 */               boolean filter_isNull162 = false;
/* 1038 */               boolean filter_value162 = false;
/* 1039 */
/* 1040 */               if (!filter_isNull163 && !filter_value163) {
/* 1041 */               } else {
/* 1042 */                 boolean filter_isNull171 = true;
/* 1043 */                 boolean filter_value171 = false;
/* 1044 */
/* 1045 */                 if (!scan_isNull4) {
/* 1046 */                   filter_isNull171 = false; // resultCode could change nullability.
/* 1047 */                   filter_value171 = scan_value4.equals(((UTF8String) references[50]));
/* 1048 */
/* 1049 */                 }
/* 1050 */                 boolean filter_isNull170 = false;
/* 1051 */                 boolean filter_value170 = true;
/* 1052 */
/* 1053 */                 if (!filter_isNull171 && filter_value171) {
/* 1054 */                 } else {
/* 1055 */                   boolean filter_isNull174 = true;
/* 1056 */                   boolean filter_value174 = false;
/* 1057 */
/* 1058 */                   if (!scan_isNull4) {
/* 1059 */                     filter_isNull174 = false; // resultCode could change nullability.
/* 1060 */                     filter_value174 = scan_value4.equals(((UTF8String) references[51]));
/* 1061 */
/* 1062 */                   }
/* 1063 */                   if (!filter_isNull174 && filter_value174) {
/* 1064 */                   } else if (!filter_isNull171 && !filter_isNull174) {
/* 1065 */                     filter_value170 = false;
/* 1066 */                   } else {
/* 1067 */                     filter_isNull170 = true;
/* 1068 */                   }
/* 1069 */                 }
/* 1070 */                 if (!filter_isNull170 && !filter_value170) {
/* 1071 */                 } else if (!filter_isNull163 && !filter_isNull170) {
/* 1072 */                   filter_value162 = true;
/* 1073 */                 } else {
/* 1074 */                   filter_isNull162 = true;
/* 1075 */                 }
/* 1076 */               }
/* 1077 */               boolean filter_isNull161 = false;
/* 1078 */               boolean filter_value161 = false;
/* 1079 */
/* 1080 */               if (!filter_isNull162 && !filter_value162) {
/* 1081 */               } else {
/* 1082 */                 boolean filter_isNull178 = true;
/* 1083 */                 boolean filter_value178 = false;
/* 1084 */
/* 1085 */                 if (!scan_isNull2) {
/* 1086 */                   filter_isNull178 = false; // resultCode could change nullability.
/* 1087 */                   filter_value178 = scan_value2.equals(((UTF8String) references[52]));
/* 1088 */
/* 1089 */                 }
/* 1090 */                 boolean filter_isNull177 = false;
/* 1091 */                 boolean filter_value177 = true;
/* 1092 */
/* 1093 */                 if (!filter_isNull178 && filter_value178) {
/* 1094 */                 } else {
/* 1095 */                   boolean filter_isNull181 = true;
/* 1096 */                   boolean filter_value181 = false;
/* 1097 */
/* 1098 */                   if (!scan_isNull2) {
/* 1099 */                     filter_isNull181 = false; // resultCode could change nullability.
/* 1100 */                     filter_value181 = scan_value2.equals(((UTF8String) references[53]));
/* 1101 */
/* 1102 */                   }
/* 1103 */                   if (!filter_isNull181 && filter_value181) {
/* 1104 */                   } else if (!filter_isNull178 && !filter_isNull181) {
/* 1105 */                     filter_value177 = false;
/* 1106 */                   } else {
/* 1107 */                     filter_isNull177 = true;
/* 1108 */                   }
/* 1109 */                 }
/* 1110 */                 if (!filter_isNull177 && !filter_value177) {
/* 1111 */                 } else if (!filter_isNull162 && !filter_isNull177) {
/* 1112 */                   filter_value161 = true;
/* 1113 */                 } else {
/* 1114 */                   filter_isNull161 = true;
/* 1115 */                 }
/* 1116 */               }
/* 1117 */               boolean filter_isNull160 = false;
/* 1118 */               boolean filter_value160 = true;
/* 1119 */
/* 1120 */               if (!filter_isNull161 && filter_value161) {
/* 1121 */               } else {
/* 1122 */                 boolean filter_isNull187 = true;
/* 1123 */                 boolean filter_value187 = false;
/* 1124 */
/* 1125 */                 if (!scan_isNull3) {
/* 1126 */                   filter_isNull187 = false; // resultCode could change nullability.
/* 1127 */                   filter_value187 = scan_value3.equals(((UTF8String) references[54]));
/* 1128 */
/* 1129 */                 }
/* 1130 */                 boolean filter_isNull186 = false;
/* 1131 */                 boolean filter_value186 = true;
/* 1132 */
/* 1133 */                 if (!filter_isNull187 && filter_value187) {
/* 1134 */                 } else {
/* 1135 */                   boolean filter_isNull190 = true;
/* 1136 */                   boolean filter_value190 = false;
/* 1137 */
/* 1138 */                   if (!scan_isNull3) {
/* 1139 */                     filter_isNull190 = false; // resultCode could change nullability.
/* 1140 */                     filter_value190 = scan_value3.equals(((UTF8String) references[55]));
/* 1141 */
/* 1142 */                   }
/* 1143 */                   if (!filter_isNull190 && filter_value190) {
/* 1144 */                   } else if (!filter_isNull187 && !filter_isNull190) {
/* 1145 */                     filter_value186 = false;
/* 1146 */                   } else {
/* 1147 */                     filter_isNull186 = true;
/* 1148 */                   }
/* 1149 */                 }
/* 1150 */                 boolean filter_isNull185 = false;
/* 1151 */                 boolean filter_value185 = false;
/* 1152 */
/* 1153 */                 if (!filter_isNull186 && !filter_value186) {
/* 1154 */                 } else {
/* 1155 */                   boolean filter_isNull194 = true;
/* 1156 */                   boolean filter_value194 = false;
/* 1157 */
/* 1158 */                   if (!scan_isNull4) {
/* 1159 */                     filter_isNull194 = false; // resultCode could change nullability.
/* 1160 */                     filter_value194 = scan_value4.equals(((UTF8String) references[56]));
/* 1161 */
/* 1162 */                   }
/* 1163 */                   boolean filter_isNull193 = false;
/* 1164 */                   boolean filter_value193 = true;
/* 1165 */
/* 1166 */                   if (!filter_isNull194 && filter_value194) {
/* 1167 */                   } else {
/* 1168 */                     boolean filter_isNull197 = true;
/* 1169 */                     boolean filter_value197 = false;
/* 1170 */
/* 1171 */                     if (!scan_isNull4) {
/* 1172 */                       filter_isNull197 = false; // resultCode could change nullability.
/* 1173 */                       filter_value197 = scan_value4.equals(((UTF8String) references[57]));
/* 1174 */
/* 1175 */                     }
/* 1176 */                     if (!filter_isNull197 && filter_value197) {
/* 1177 */                     } else if (!filter_isNull194 && !filter_isNull197) {
/* 1178 */                       filter_value193 = false;
/* 1179 */                     } else {
/* 1180 */                       filter_isNull193 = true;
/* 1181 */                     }
/* 1182 */                   }
/* 1183 */                   if (!filter_isNull193 && !filter_value193) {
/* 1184 */                   } else if (!filter_isNull186 && !filter_isNull193) {
/* 1185 */                     filter_value185 = true;
/* 1186 */                   } else {
/* 1187 */                     filter_isNull185 = true;
/* 1188 */                   }
/* 1189 */                 }
/* 1190 */                 boolean filter_isNull184 = false;
/* 1191 */                 boolean filter_value184 = false;
/* 1192 */
/* 1193 */                 if (!filter_isNull185 && !filter_value185) {
/* 1194 */                 } else {
/* 1195 */                   boolean filter_isNull201 = true;
/* 1196 */                   boolean filter_value201 = false;
/* 1197 */
/* 1198 */                   if (!scan_isNull2) {
/* 1199 */                     filter_isNull201 = false; // resultCode could change nullability.
/* 1200 */                     filter_value201 = scan_value2.equals(((UTF8String) references[58]));
/* 1201 */
/* 1202 */                   }
/* 1203 */                   boolean filter_isNull200 = false;
/* 1204 */                   boolean filter_value200 = true;
/* 1205 */
/* 1206 */                   if (!filter_isNull201 && filter_value201) {
/* 1207 */                   } else {
/* 1208 */                     boolean filter_isNull204 = true;
/* 1209 */                     boolean filter_value204 = false;
/* 1210 */
/* 1211 */                     if (!scan_isNull2) {
/* 1212 */                       filter_isNull204 = false; // resultCode could change nullability.
/* 1213 */                       filter_value204 = scan_value2.equals(((UTF8String) references[59]));
/* 1214 */
/* 1215 */                     }
/* 1216 */                     if (!filter_isNull204 && filter_value204) {
/* 1217 */                     } else if (!filter_isNull201 && !filter_isNull204) {
/* 1218 */                       filter_value200 = false;
/* 1219 */                     } else {
/* 1220 */                       filter_isNull200 = true;
/* 1221 */                     }
/* 1222 */                   }
/* 1223 */                   if (!filter_isNull200 && !filter_value200) {
/* 1224 */                   } else if (!filter_isNull185 && !filter_isNull200) {
/* 1225 */                     filter_value184 = true;
/* 1226 */                   } else {
/* 1227 */                     filter_isNull184 = true;
/* 1228 */                   }
/* 1229 */                 }
/* 1230 */                 if (!filter_isNull184 && filter_value184) {
/* 1231 */                 } else if (!filter_isNull161 && !filter_isNull184) {
/* 1232 */                   filter_value160 = false;
/* 1233 */                 } else {
/* 1234 */                   filter_isNull160 = true;
/* 1235 */                 }
/* 1236 */               }
/* 1237 */               if (!filter_isNull160 && !filter_value160) {
/* 1238 */               } else if (!filter_isNull157 && !filter_isNull160) {
/* 1239 */                 filter_value156 = true;
/* 1240 */               } else {
/* 1241 */                 filter_isNull156 = true;
/* 1242 */               }
/* 1243 */             }
/* 1244 */             if (!filter_isNull156 && filter_value156) {
/* 1245 */             } else if (!filter_isNull105 && !filter_isNull156) {
/* 1246 */               filter_value104 = false;
/* 1247 */             } else {
/* 1248 */               filter_isNull104 = true;
/* 1249 */             }
/* 1250 */           }
/* 1251 */           if (!filter_isNull104 && filter_value104) {
/* 1252 */           } else if (!filter_isNull1 && !filter_isNull104) {
/* 1253 */             filter_value = false;
/* 1254 */           } else {
/* 1255 */             filter_isNull = true;
/* 1256 */           }
/* 1257 */         }
/* 1258 */         if (filter_isNull || !filter_value) continue;
/* 1259 */
/* 1260 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 1261 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 1262 */
/* 1263 */         if (!(!(scan_isNull1))) continue;
/* 1264 */
/* 1265 */         filter_numOutputRows.add(1);
/* 1266 */
/* 1267 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 1268 */
/* 1269 */         UnsafeRow agg_fastAggBuffer = null;
/* 1270 */
/* 1271 */         if (true) {
/* 1272 */           if (!false) {
/* 1273 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 1274 */               scan_value1);
/* 1275 */           }
/* 1276 */         }
/* 1277 */
/* 1278 */         if (agg_fastAggBuffer == null) {
/* 1279 */           // generate grouping key
/* 1280 */           agg_holder.reset();
/* 1281 */
/* 1282 */           agg_rowWriter.write(0, scan_value1);
/* 1283 */           agg_result1.setTotalSize(agg_holder.totalSize());
/* 1284 */           agg_value4 = 42;
/* 1285 */
/* 1286 */           if (!false) {
/* 1287 */             agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value1.getBaseObject(), scan_value1.getBaseOffset(), scan_value1.numBytes(), agg_value4);
/* 1288 */           }
/* 1289 */           if (true) {
/* 1290 */             // try to get the buffer from hash map
/* 1291 */             agg_unsafeRowAggBuffer =
/* 1292 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 1293 */           }
/* 1294 */           if (agg_unsafeRowAggBuffer == null) {
/* 1295 */             if (agg_sorter == null) {
/* 1296 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 1297 */             } else {
/* 1298 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 1299 */             }
/* 1300 */
/* 1301 */             // the hash map had be spilled, it should have enough memory now,
/* 1302 */             // try  to allocate buffer again.
/* 1303 */             agg_unsafeRowAggBuffer =
/* 1304 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 1305 */             if (agg_unsafeRowAggBuffer == null) {
/* 1306 */               // failed to allocate the first page
/* 1307 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 1308 */             }
/* 1309 */           }
/* 1310 */         }
/* 1311 */
/* 1312 */         if (agg_fastAggBuffer != null) {
/* 1313 */           // update fast row
/* 1314 */
/* 1315 */           // common sub-expressions
/* 1316 */
/* 1317 */           // evaluate aggregate function
/* 1318 */           boolean agg_isNull8 = false;
/* 1319 */
/* 1320 */           long agg_value10 = agg_fastAggBuffer.getLong(0);
/* 1321 */
/* 1322 */           long agg_value9 = -1L;
/* 1323 */           agg_value9 = agg_value10 + 1L;
/* 1324 */           // update fast row
/* 1325 */           agg_fastAggBuffer.setLong(0, agg_value9);
/* 1326 */
/* 1327 */         } else {
/* 1328 */           // update unsafe row
/* 1329 */
/* 1330 */           // common sub-expressions
/* 1331 */
/* 1332 */           // evaluate aggregate function
/* 1333 */           boolean agg_isNull5 = false;
/* 1334 */
/* 1335 */           long agg_value7 = agg_unsafeRowAggBuffer.getLong(0);
/* 1336 */
/* 1337 */           long agg_value6 = -1L;
/* 1338 */           agg_value6 = agg_value7 + 1L;
/* 1339 */           // update unsafe row buffer
/* 1340 */           agg_unsafeRowAggBuffer.setLong(0, agg_value6);
/* 1341 */
/* 1342 */         }
/* 1343 */         // shouldStop check is eliminated
/* 1344 */       }
/* 1345 */       scan_batchIdx = scan_numRows;
/* 1346 */       scan_batch = null;
/* 1347 */       scan_nextBatch();
/* 1348 */     }
/* 1349 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 1350 */     scan_scanTime1 = 0;
/* 1351 */
/* 1352 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 1353 */
/* 1354 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1355 */   }
/* 1356 */
/* 1357 */   private void wholestagecodegen_init_1() {
/* 1358 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 1359 */     filter_result = new UnsafeRow(5);
/* 1360 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 160);
/* 1361 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 1362 */     project_result = new UnsafeRow(1);
/* 1363 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 1364 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 1365 */     agg_result1 = new UnsafeRow(1);
/* 1366 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 1367 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 1368 */
/* 1369 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 1370 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[60];
/* 1371 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[61];
/* 1372 */
/* 1373 */   }
/* 1374 */
/* 1375 */   protected void processNext() throws java.io.IOException {
/* 1376 */     if (!agg_initAgg) {
/* 1377 */       agg_initAgg = true;
/* 1378 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1379 */       agg_doAggregateWithKeys();
/* 1380 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1381 */     }
/* 1382 */
/* 1383 */     // output the result
/* 1384 */
/* 1385 */     while (agg_fastHashMapIter.next()) {
/* 1386 */       wholestagecodegen_numOutputRows.add(1);
/* 1387 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 1388 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 1389 */
/* 1390 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1391 */
/* 1392 */       append(agg_resultRow);
/* 1393 */
/* 1394 */       if (shouldStop()) return;
/* 1395 */     }
/* 1396 */     agg_fastHashMap.close();
/* 1397 */
/* 1398 */     while (agg_mapIter.next()) {
/* 1399 */       wholestagecodegen_numOutputRows.add(1);
/* 1400 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1401 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1402 */
/* 1403 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1404 */
/* 1405 */       append(agg_resultRow);
/* 1406 */
/* 1407 */       if (shouldStop()) return;
/* 1408 */     }
/* 1409 */
/* 1410 */     agg_mapIter.close();
/* 1411 */     if (agg_sorter == null) {
/* 1412 */       agg_hashMap.free();
/* 1413 */     }
/* 1414 */   }
/* 1415 */ }
