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
/* 069 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 070 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
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
/* 109 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("i_manufact", org.apache.spark.sql.types.DataTypes.StringType);
/* 110 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("count", org.apache.spark.sql.types.DataTypes.LongType);
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
/* 217 */       int numRows = scan_batch.numRows();
/* 218 */       while (scan_batchIdx < numRows) {
/* 219 */         int scan_rowIdx = scan_batchIdx++;
/* 220 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 221 */         UTF8String scan_value = scan_isNull ? null : (scan_colInstance0.getUTF8String(scan_rowIdx));
/* 222 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 223 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 224 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 225 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 226 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 227 */         UTF8String scan_value4 = scan_isNull4 ? null : (scan_colInstance4.getUTF8String(scan_rowIdx));
/* 228 */
/* 229 */         boolean filter_isNull3 = true;
/* 230 */         boolean filter_value3 = false;
/* 231 */
/* 232 */         if (!scan_isNull) {
/* 233 */           Object filter_obj = ((Expression) references[6]).eval(null);
/* 234 */           UTF8String filter_value5 = (UTF8String) filter_obj;
/* 235 */
/* 236 */           filter_isNull3 = false; // resultCode could change nullability.
/* 237 */           filter_value3 = scan_value.equals(filter_value5);
/* 238 */
/* 239 */         }
/* 240 */         boolean filter_isNull2 = false;
/* 241 */         boolean filter_value2 = false;
/* 242 */
/* 243 */         if (!filter_isNull3 && !filter_value3) {
/* 244 */         } else {
/* 245 */           boolean filter_isNull10 = true;
/* 246 */           boolean filter_value10 = false;
/* 247 */
/* 248 */           if (!scan_isNull3) {
/* 249 */             Object filter_obj1 = ((Expression) references[7]).eval(null);
/* 250 */             UTF8String filter_value12 = (UTF8String) filter_obj1;
/* 251 */
/* 252 */             filter_isNull10 = false; // resultCode could change nullability.
/* 253 */             filter_value10 = scan_value3.equals(filter_value12);
/* 254 */
/* 255 */           }
/* 256 */           boolean filter_isNull9 = false;
/* 257 */           boolean filter_value9 = true;
/* 258 */
/* 259 */           if (!filter_isNull10 && filter_value10) {
/* 260 */           } else {
/* 261 */             boolean filter_isNull13 = true;
/* 262 */             boolean filter_value13 = false;
/* 263 */
/* 264 */             if (!scan_isNull3) {
/* 265 */               Object filter_obj2 = ((Expression) references[8]).eval(null);
/* 266 */               UTF8String filter_value15 = (UTF8String) filter_obj2;
/* 267 */
/* 268 */               filter_isNull13 = false; // resultCode could change nullability.
/* 269 */               filter_value13 = scan_value3.equals(filter_value15);
/* 270 */
/* 271 */             }
/* 272 */             if (!filter_isNull13 && filter_value13) {
/* 273 */             } else if (!filter_isNull10 && !filter_isNull13) {
/* 274 */               filter_value9 = false;
/* 275 */             } else {
/* 276 */               filter_isNull9 = true;
/* 277 */             }
/* 278 */           }
/* 279 */           boolean filter_isNull8 = false;
/* 280 */           boolean filter_value8 = false;
/* 281 */
/* 282 */           if (!filter_isNull9 && !filter_value9) {
/* 283 */           } else {
/* 284 */             boolean filter_isNull17 = true;
/* 285 */             boolean filter_value17 = false;
/* 286 */
/* 287 */             if (!scan_isNull4) {
/* 288 */               Object filter_obj3 = ((Expression) references[9]).eval(null);
/* 289 */               UTF8String filter_value19 = (UTF8String) filter_obj3;
/* 290 */
/* 291 */               filter_isNull17 = false; // resultCode could change nullability.
/* 292 */               filter_value17 = scan_value4.equals(filter_value19);
/* 293 */
/* 294 */             }
/* 295 */             boolean filter_isNull16 = false;
/* 296 */             boolean filter_value16 = true;
/* 297 */
/* 298 */             if (!filter_isNull17 && filter_value17) {
/* 299 */             } else {
/* 300 */               boolean filter_isNull20 = true;
/* 301 */               boolean filter_value20 = false;
/* 302 */
/* 303 */               if (!scan_isNull4) {
/* 304 */                 Object filter_obj4 = ((Expression) references[10]).eval(null);
/* 305 */                 UTF8String filter_value22 = (UTF8String) filter_obj4;
/* 306 */
/* 307 */                 filter_isNull20 = false; // resultCode could change nullability.
/* 308 */                 filter_value20 = scan_value4.equals(filter_value22);
/* 309 */
/* 310 */               }
/* 311 */               if (!filter_isNull20 && filter_value20) {
/* 312 */               } else if (!filter_isNull17 && !filter_isNull20) {
/* 313 */                 filter_value16 = false;
/* 314 */               } else {
/* 315 */                 filter_isNull16 = true;
/* 316 */               }
/* 317 */             }
/* 318 */             if (!filter_isNull16 && !filter_value16) {
/* 319 */             } else if (!filter_isNull9 && !filter_isNull16) {
/* 320 */               filter_value8 = true;
/* 321 */             } else {
/* 322 */               filter_isNull8 = true;
/* 323 */             }
/* 324 */           }
/* 325 */           boolean filter_isNull7 = false;
/* 326 */           boolean filter_value7 = false;
/* 327 */
/* 328 */           if (!filter_isNull8 && !filter_value8) {
/* 329 */           } else {
/* 330 */             boolean filter_isNull24 = true;
/* 331 */             boolean filter_value24 = false;
/* 332 */
/* 333 */             if (!scan_isNull2) {
/* 334 */               Object filter_obj5 = ((Expression) references[11]).eval(null);
/* 335 */               UTF8String filter_value26 = (UTF8String) filter_obj5;
/* 336 */
/* 337 */               filter_isNull24 = false; // resultCode could change nullability.
/* 338 */               filter_value24 = scan_value2.equals(filter_value26);
/* 339 */
/* 340 */             }
/* 341 */             boolean filter_isNull23 = false;
/* 342 */             boolean filter_value23 = true;
/* 343 */
/* 344 */             if (!filter_isNull24 && filter_value24) {
/* 345 */             } else {
/* 346 */               boolean filter_isNull27 = true;
/* 347 */               boolean filter_value27 = false;
/* 348 */
/* 349 */               if (!scan_isNull2) {
/* 350 */                 Object filter_obj6 = ((Expression) references[12]).eval(null);
/* 351 */                 UTF8String filter_value29 = (UTF8String) filter_obj6;
/* 352 */
/* 353 */                 filter_isNull27 = false; // resultCode could change nullability.
/* 354 */                 filter_value27 = scan_value2.equals(filter_value29);
/* 355 */
/* 356 */               }
/* 357 */               if (!filter_isNull27 && filter_value27) {
/* 358 */               } else if (!filter_isNull24 && !filter_isNull27) {
/* 359 */                 filter_value23 = false;
/* 360 */               } else {
/* 361 */                 filter_isNull23 = true;
/* 362 */               }
/* 363 */             }
/* 364 */             if (!filter_isNull23 && !filter_value23) {
/* 365 */             } else if (!filter_isNull8 && !filter_isNull23) {
/* 366 */               filter_value7 = true;
/* 367 */             } else {
/* 368 */               filter_isNull7 = true;
/* 369 */             }
/* 370 */           }
/* 371 */           boolean filter_isNull6 = false;
/* 372 */           boolean filter_value6 = true;
/* 373 */
/* 374 */           if (!filter_isNull7 && filter_value7) {
/* 375 */           } else {
/* 376 */             boolean filter_isNull33 = true;
/* 377 */             boolean filter_value33 = false;
/* 378 */
/* 379 */             if (!scan_isNull3) {
/* 380 */               Object filter_obj7 = ((Expression) references[13]).eval(null);
/* 381 */               UTF8String filter_value35 = (UTF8String) filter_obj7;
/* 382 */
/* 383 */               filter_isNull33 = false; // resultCode could change nullability.
/* 384 */               filter_value33 = scan_value3.equals(filter_value35);
/* 385 */
/* 386 */             }
/* 387 */             boolean filter_isNull32 = false;
/* 388 */             boolean filter_value32 = true;
/* 389 */
/* 390 */             if (!filter_isNull33 && filter_value33) {
/* 391 */             } else {
/* 392 */               boolean filter_isNull36 = true;
/* 393 */               boolean filter_value36 = false;
/* 394 */
/* 395 */               if (!scan_isNull3) {
/* 396 */                 Object filter_obj8 = ((Expression) references[14]).eval(null);
/* 397 */                 UTF8String filter_value38 = (UTF8String) filter_obj8;
/* 398 */
/* 399 */                 filter_isNull36 = false; // resultCode could change nullability.
/* 400 */                 filter_value36 = scan_value3.equals(filter_value38);
/* 401 */
/* 402 */               }
/* 403 */               if (!filter_isNull36 && filter_value36) {
/* 404 */               } else if (!filter_isNull33 && !filter_isNull36) {
/* 405 */                 filter_value32 = false;
/* 406 */               } else {
/* 407 */                 filter_isNull32 = true;
/* 408 */               }
/* 409 */             }
/* 410 */             boolean filter_isNull31 = false;
/* 411 */             boolean filter_value31 = false;
/* 412 */
/* 413 */             if (!filter_isNull32 && !filter_value32) {
/* 414 */             } else {
/* 415 */               boolean filter_isNull40 = true;
/* 416 */               boolean filter_value40 = false;
/* 417 */
/* 418 */               if (!scan_isNull4) {
/* 419 */                 Object filter_obj9 = ((Expression) references[15]).eval(null);
/* 420 */                 UTF8String filter_value42 = (UTF8String) filter_obj9;
/* 421 */
/* 422 */                 filter_isNull40 = false; // resultCode could change nullability.
/* 423 */                 filter_value40 = scan_value4.equals(filter_value42);
/* 424 */
/* 425 */               }
/* 426 */               boolean filter_isNull39 = false;
/* 427 */               boolean filter_value39 = true;
/* 428 */
/* 429 */               if (!filter_isNull40 && filter_value40) {
/* 430 */               } else {
/* 431 */                 boolean filter_isNull43 = true;
/* 432 */                 boolean filter_value43 = false;
/* 433 */
/* 434 */                 if (!scan_isNull4) {
/* 435 */                   Object filter_obj10 = ((Expression) references[16]).eval(null);
/* 436 */                   UTF8String filter_value45 = (UTF8String) filter_obj10;
/* 437 */
/* 438 */                   filter_isNull43 = false; // resultCode could change nullability.
/* 439 */                   filter_value43 = scan_value4.equals(filter_value45);
/* 440 */
/* 441 */                 }
/* 442 */                 if (!filter_isNull43 && filter_value43) {
/* 443 */                 } else if (!filter_isNull40 && !filter_isNull43) {
/* 444 */                   filter_value39 = false;
/* 445 */                 } else {
/* 446 */                   filter_isNull39 = true;
/* 447 */                 }
/* 448 */               }
/* 449 */               if (!filter_isNull39 && !filter_value39) {
/* 450 */               } else if (!filter_isNull32 && !filter_isNull39) {
/* 451 */                 filter_value31 = true;
/* 452 */               } else {
/* 453 */                 filter_isNull31 = true;
/* 454 */               }
/* 455 */             }
/* 456 */             boolean filter_isNull30 = false;
/* 457 */             boolean filter_value30 = false;
/* 458 */
/* 459 */             if (!filter_isNull31 && !filter_value31) {
/* 460 */             } else {
/* 461 */               boolean filter_isNull47 = true;
/* 462 */               boolean filter_value47 = false;
/* 463 */
/* 464 */               if (!scan_isNull2) {
/* 465 */                 Object filter_obj11 = ((Expression) references[17]).eval(null);
/* 466 */                 UTF8String filter_value49 = (UTF8String) filter_obj11;
/* 467 */
/* 468 */                 filter_isNull47 = false; // resultCode could change nullability.
/* 469 */                 filter_value47 = scan_value2.equals(filter_value49);
/* 470 */
/* 471 */               }
/* 472 */               boolean filter_isNull46 = false;
/* 473 */               boolean filter_value46 = true;
/* 474 */
/* 475 */               if (!filter_isNull47 && filter_value47) {
/* 476 */               } else {
/* 477 */                 boolean filter_isNull50 = true;
/* 478 */                 boolean filter_value50 = false;
/* 479 */
/* 480 */                 if (!scan_isNull2) {
/* 481 */                   Object filter_obj12 = ((Expression) references[18]).eval(null);
/* 482 */                   UTF8String filter_value52 = (UTF8String) filter_obj12;
/* 483 */
/* 484 */                   filter_isNull50 = false; // resultCode could change nullability.
/* 485 */                   filter_value50 = scan_value2.equals(filter_value52);
/* 486 */
/* 487 */                 }
/* 488 */                 if (!filter_isNull50 && filter_value50) {
/* 489 */                 } else if (!filter_isNull47 && !filter_isNull50) {
/* 490 */                   filter_value46 = false;
/* 491 */                 } else {
/* 492 */                   filter_isNull46 = true;
/* 493 */                 }
/* 494 */               }
/* 495 */               if (!filter_isNull46 && !filter_value46) {
/* 496 */               } else if (!filter_isNull31 && !filter_isNull46) {
/* 497 */                 filter_value30 = true;
/* 498 */               } else {
/* 499 */                 filter_isNull30 = true;
/* 500 */               }
/* 501 */             }
/* 502 */             if (!filter_isNull30 && filter_value30) {
/* 503 */             } else if (!filter_isNull7 && !filter_isNull30) {
/* 504 */               filter_value6 = false;
/* 505 */             } else {
/* 506 */               filter_isNull6 = true;
/* 507 */             }
/* 508 */           }
/* 509 */           if (!filter_isNull6 && !filter_value6) {
/* 510 */           } else if (!filter_isNull3 && !filter_isNull6) {
/* 511 */             filter_value2 = true;
/* 512 */           } else {
/* 513 */             filter_isNull2 = true;
/* 514 */           }
/* 515 */         }
/* 516 */         boolean filter_isNull1 = false;
/* 517 */         boolean filter_value1 = true;
/* 518 */
/* 519 */         if (!filter_isNull2 && filter_value2) {
/* 520 */         } else {
/* 521 */           boolean filter_isNull54 = true;
/* 522 */           boolean filter_value54 = false;
/* 523 */
/* 524 */           if (!scan_isNull) {
/* 525 */             Object filter_obj13 = ((Expression) references[19]).eval(null);
/* 526 */             UTF8String filter_value56 = (UTF8String) filter_obj13;
/* 527 */
/* 528 */             filter_isNull54 = false; // resultCode could change nullability.
/* 529 */             filter_value54 = scan_value.equals(filter_value56);
/* 530 */
/* 531 */           }
/* 532 */           boolean filter_isNull53 = false;
/* 533 */           boolean filter_value53 = false;
/* 534 */
/* 535 */           if (!filter_isNull54 && !filter_value54) {
/* 536 */           } else {
/* 537 */             boolean filter_isNull61 = true;
/* 538 */             boolean filter_value61 = false;
/* 539 */
/* 540 */             if (!scan_isNull3) {
/* 541 */               Object filter_obj14 = ((Expression) references[20]).eval(null);
/* 542 */               UTF8String filter_value63 = (UTF8String) filter_obj14;
/* 543 */
/* 544 */               filter_isNull61 = false; // resultCode could change nullability.
/* 545 */               filter_value61 = scan_value3.equals(filter_value63);
/* 546 */
/* 547 */             }
/* 548 */             boolean filter_isNull60 = false;
/* 549 */             boolean filter_value60 = true;
/* 550 */
/* 551 */             if (!filter_isNull61 && filter_value61) {
/* 552 */             } else {
/* 553 */               boolean filter_isNull64 = true;
/* 554 */               boolean filter_value64 = false;
/* 555 */
/* 556 */               if (!scan_isNull3) {
/* 557 */                 Object filter_obj15 = ((Expression) references[21]).eval(null);
/* 558 */                 UTF8String filter_value66 = (UTF8String) filter_obj15;
/* 559 */
/* 560 */                 filter_isNull64 = false; // resultCode could change nullability.
/* 561 */                 filter_value64 = scan_value3.equals(filter_value66);
/* 562 */
/* 563 */               }
/* 564 */               if (!filter_isNull64 && filter_value64) {
/* 565 */               } else if (!filter_isNull61 && !filter_isNull64) {
/* 566 */                 filter_value60 = false;
/* 567 */               } else {
/* 568 */                 filter_isNull60 = true;
/* 569 */               }
/* 570 */             }
/* 571 */             boolean filter_isNull59 = false;
/* 572 */             boolean filter_value59 = false;
/* 573 */
/* 574 */             if (!filter_isNull60 && !filter_value60) {
/* 575 */             } else {
/* 576 */               boolean filter_isNull68 = true;
/* 577 */               boolean filter_value68 = false;
/* 578 */
/* 579 */               if (!scan_isNull4) {
/* 580 */                 Object filter_obj16 = ((Expression) references[22]).eval(null);
/* 581 */                 UTF8String filter_value70 = (UTF8String) filter_obj16;
/* 582 */
/* 583 */                 filter_isNull68 = false; // resultCode could change nullability.
/* 584 */                 filter_value68 = scan_value4.equals(filter_value70);
/* 585 */
/* 586 */               }
/* 587 */               boolean filter_isNull67 = false;
/* 588 */               boolean filter_value67 = true;
/* 589 */
/* 590 */               if (!filter_isNull68 && filter_value68) {
/* 591 */               } else {
/* 592 */                 boolean filter_isNull71 = true;
/* 593 */                 boolean filter_value71 = false;
/* 594 */
/* 595 */                 if (!scan_isNull4) {
/* 596 */                   Object filter_obj17 = ((Expression) references[23]).eval(null);
/* 597 */                   UTF8String filter_value73 = (UTF8String) filter_obj17;
/* 598 */
/* 599 */                   filter_isNull71 = false; // resultCode could change nullability.
/* 600 */                   filter_value71 = scan_value4.equals(filter_value73);
/* 601 */
/* 602 */                 }
/* 603 */                 if (!filter_isNull71 && filter_value71) {
/* 604 */                 } else if (!filter_isNull68 && !filter_isNull71) {
/* 605 */                   filter_value67 = false;
/* 606 */                 } else {
/* 607 */                   filter_isNull67 = true;
/* 608 */                 }
/* 609 */               }
/* 610 */               if (!filter_isNull67 && !filter_value67) {
/* 611 */               } else if (!filter_isNull60 && !filter_isNull67) {
/* 612 */                 filter_value59 = true;
/* 613 */               } else {
/* 614 */                 filter_isNull59 = true;
/* 615 */               }
/* 616 */             }
/* 617 */             boolean filter_isNull58 = false;
/* 618 */             boolean filter_value58 = false;
/* 619 */
/* 620 */             if (!filter_isNull59 && !filter_value59) {
/* 621 */             } else {
/* 622 */               boolean filter_isNull75 = true;
/* 623 */               boolean filter_value75 = false;
/* 624 */
/* 625 */               if (!scan_isNull2) {
/* 626 */                 Object filter_obj18 = ((Expression) references[24]).eval(null);
/* 627 */                 UTF8String filter_value77 = (UTF8String) filter_obj18;
/* 628 */
/* 629 */                 filter_isNull75 = false; // resultCode could change nullability.
/* 630 */                 filter_value75 = scan_value2.equals(filter_value77);
/* 631 */
/* 632 */               }
/* 633 */               boolean filter_isNull74 = false;
/* 634 */               boolean filter_value74 = true;
/* 635 */
/* 636 */               if (!filter_isNull75 && filter_value75) {
/* 637 */               } else {
/* 638 */                 boolean filter_isNull78 = true;
/* 639 */                 boolean filter_value78 = false;
/* 640 */
/* 641 */                 if (!scan_isNull2) {
/* 642 */                   Object filter_obj19 = ((Expression) references[25]).eval(null);
/* 643 */                   UTF8String filter_value80 = (UTF8String) filter_obj19;
/* 644 */
/* 645 */                   filter_isNull78 = false; // resultCode could change nullability.
/* 646 */                   filter_value78 = scan_value2.equals(filter_value80);
/* 647 */
/* 648 */                 }
/* 649 */                 if (!filter_isNull78 && filter_value78) {
/* 650 */                 } else if (!filter_isNull75 && !filter_isNull78) {
/* 651 */                   filter_value74 = false;
/* 652 */                 } else {
/* 653 */                   filter_isNull74 = true;
/* 654 */                 }
/* 655 */               }
/* 656 */               if (!filter_isNull74 && !filter_value74) {
/* 657 */               } else if (!filter_isNull59 && !filter_isNull74) {
/* 658 */                 filter_value58 = true;
/* 659 */               } else {
/* 660 */                 filter_isNull58 = true;
/* 661 */               }
/* 662 */             }
/* 663 */             boolean filter_isNull57 = false;
/* 664 */             boolean filter_value57 = true;
/* 665 */
/* 666 */             if (!filter_isNull58 && filter_value58) {
/* 667 */             } else {
/* 668 */               boolean filter_isNull84 = true;
/* 669 */               boolean filter_value84 = false;
/* 670 */
/* 671 */               if (!scan_isNull3) {
/* 672 */                 Object filter_obj20 = ((Expression) references[26]).eval(null);
/* 673 */                 UTF8String filter_value86 = (UTF8String) filter_obj20;
/* 674 */
/* 675 */                 filter_isNull84 = false; // resultCode could change nullability.
/* 676 */                 filter_value84 = scan_value3.equals(filter_value86);
/* 677 */
/* 678 */               }
/* 679 */               boolean filter_isNull83 = false;
/* 680 */               boolean filter_value83 = true;
/* 681 */
/* 682 */               if (!filter_isNull84 && filter_value84) {
/* 683 */               } else {
/* 684 */                 boolean filter_isNull87 = true;
/* 685 */                 boolean filter_value87 = false;
/* 686 */
/* 687 */                 if (!scan_isNull3) {
/* 688 */                   Object filter_obj21 = ((Expression) references[27]).eval(null);
/* 689 */                   UTF8String filter_value89 = (UTF8String) filter_obj21;
/* 690 */
/* 691 */                   filter_isNull87 = false; // resultCode could change nullability.
/* 692 */                   filter_value87 = scan_value3.equals(filter_value89);
/* 693 */
/* 694 */                 }
/* 695 */                 if (!filter_isNull87 && filter_value87) {
/* 696 */                 } else if (!filter_isNull84 && !filter_isNull87) {
/* 697 */                   filter_value83 = false;
/* 698 */                 } else {
/* 699 */                   filter_isNull83 = true;
/* 700 */                 }
/* 701 */               }
/* 702 */               boolean filter_isNull82 = false;
/* 703 */               boolean filter_value82 = false;
/* 704 */
/* 705 */               if (!filter_isNull83 && !filter_value83) {
/* 706 */               } else {
/* 707 */                 boolean filter_isNull91 = true;
/* 708 */                 boolean filter_value91 = false;
/* 709 */
/* 710 */                 if (!scan_isNull4) {
/* 711 */                   Object filter_obj22 = ((Expression) references[28]).eval(null);
/* 712 */                   UTF8String filter_value93 = (UTF8String) filter_obj22;
/* 713 */
/* 714 */                   filter_isNull91 = false; // resultCode could change nullability.
/* 715 */                   filter_value91 = scan_value4.equals(filter_value93);
/* 716 */
/* 717 */                 }
/* 718 */                 boolean filter_isNull90 = false;
/* 719 */                 boolean filter_value90 = true;
/* 720 */
/* 721 */                 if (!filter_isNull91 && filter_value91) {
/* 722 */                 } else {
/* 723 */                   boolean filter_isNull94 = true;
/* 724 */                   boolean filter_value94 = false;
/* 725 */
/* 726 */                   if (!scan_isNull4) {
/* 727 */                     Object filter_obj23 = ((Expression) references[29]).eval(null);
/* 728 */                     UTF8String filter_value96 = (UTF8String) filter_obj23;
/* 729 */
/* 730 */                     filter_isNull94 = false; // resultCode could change nullability.
/* 731 */                     filter_value94 = scan_value4.equals(filter_value96);
/* 732 */
/* 733 */                   }
/* 734 */                   if (!filter_isNull94 && filter_value94) {
/* 735 */                   } else if (!filter_isNull91 && !filter_isNull94) {
/* 736 */                     filter_value90 = false;
/* 737 */                   } else {
/* 738 */                     filter_isNull90 = true;
/* 739 */                   }
/* 740 */                 }
/* 741 */                 if (!filter_isNull90 && !filter_value90) {
/* 742 */                 } else if (!filter_isNull83 && !filter_isNull90) {
/* 743 */                   filter_value82 = true;
/* 744 */                 } else {
/* 745 */                   filter_isNull82 = true;
/* 746 */                 }
/* 747 */               }
/* 748 */               boolean filter_isNull81 = false;
/* 749 */               boolean filter_value81 = false;
/* 750 */
/* 751 */               if (!filter_isNull82 && !filter_value82) {
/* 752 */               } else {
/* 753 */                 boolean filter_isNull98 = true;
/* 754 */                 boolean filter_value98 = false;
/* 755 */
/* 756 */                 if (!scan_isNull2) {
/* 757 */                   Object filter_obj24 = ((Expression) references[30]).eval(null);
/* 758 */                   UTF8String filter_value100 = (UTF8String) filter_obj24;
/* 759 */
/* 760 */                   filter_isNull98 = false; // resultCode could change nullability.
/* 761 */                   filter_value98 = scan_value2.equals(filter_value100);
/* 762 */
/* 763 */                 }
/* 764 */                 boolean filter_isNull97 = false;
/* 765 */                 boolean filter_value97 = true;
/* 766 */
/* 767 */                 if (!filter_isNull98 && filter_value98) {
/* 768 */                 } else {
/* 769 */                   boolean filter_isNull101 = true;
/* 770 */                   boolean filter_value101 = false;
/* 771 */
/* 772 */                   if (!scan_isNull2) {
/* 773 */                     Object filter_obj25 = ((Expression) references[31]).eval(null);
/* 774 */                     UTF8String filter_value103 = (UTF8String) filter_obj25;
/* 775 */
/* 776 */                     filter_isNull101 = false; // resultCode could change nullability.
/* 777 */                     filter_value101 = scan_value2.equals(filter_value103);
/* 778 */
/* 779 */                   }
/* 780 */                   if (!filter_isNull101 && filter_value101) {
/* 781 */                   } else if (!filter_isNull98 && !filter_isNull101) {
/* 782 */                     filter_value97 = false;
/* 783 */                   } else {
/* 784 */                     filter_isNull97 = true;
/* 785 */                   }
/* 786 */                 }
/* 787 */                 if (!filter_isNull97 && !filter_value97) {
/* 788 */                 } else if (!filter_isNull82 && !filter_isNull97) {
/* 789 */                   filter_value81 = true;
/* 790 */                 } else {
/* 791 */                   filter_isNull81 = true;
/* 792 */                 }
/* 793 */               }
/* 794 */               if (!filter_isNull81 && filter_value81) {
/* 795 */               } else if (!filter_isNull58 && !filter_isNull81) {
/* 796 */                 filter_value57 = false;
/* 797 */               } else {
/* 798 */                 filter_isNull57 = true;
/* 799 */               }
/* 800 */             }
/* 801 */             if (!filter_isNull57 && !filter_value57) {
/* 802 */             } else if (!filter_isNull54 && !filter_isNull57) {
/* 803 */               filter_value53 = true;
/* 804 */             } else {
/* 805 */               filter_isNull53 = true;
/* 806 */             }
/* 807 */           }
/* 808 */           if (!filter_isNull53 && filter_value53) {
/* 809 */           } else if (!filter_isNull2 && !filter_isNull53) {
/* 810 */             filter_value1 = false;
/* 811 */           } else {
/* 812 */             filter_isNull1 = true;
/* 813 */           }
/* 814 */         }
/* 815 */         boolean filter_isNull = false;
/* 816 */         boolean filter_value = true;
/* 817 */
/* 818 */         if (!filter_isNull1 && filter_value1) {
/* 819 */         } else {
/* 820 */           boolean filter_isNull106 = true;
/* 821 */           boolean filter_value106 = false;
/* 822 */
/* 823 */           if (!scan_isNull) {
/* 824 */             Object filter_obj26 = ((Expression) references[32]).eval(null);
/* 825 */             UTF8String filter_value108 = (UTF8String) filter_obj26;
/* 826 */
/* 827 */             filter_isNull106 = false; // resultCode could change nullability.
/* 828 */             filter_value106 = scan_value.equals(filter_value108);
/* 829 */
/* 830 */           }
/* 831 */           boolean filter_isNull105 = false;
/* 832 */           boolean filter_value105 = false;
/* 833 */
/* 834 */           if (!filter_isNull106 && !filter_value106) {
/* 835 */           } else {
/* 836 */             boolean filter_isNull113 = true;
/* 837 */             boolean filter_value113 = false;
/* 838 */
/* 839 */             if (!scan_isNull3) {
/* 840 */               Object filter_obj27 = ((Expression) references[33]).eval(null);
/* 841 */               UTF8String filter_value115 = (UTF8String) filter_obj27;
/* 842 */
/* 843 */               filter_isNull113 = false; // resultCode could change nullability.
/* 844 */               filter_value113 = scan_value3.equals(filter_value115);
/* 845 */
/* 846 */             }
/* 847 */             boolean filter_isNull112 = false;
/* 848 */             boolean filter_value112 = true;
/* 849 */
/* 850 */             if (!filter_isNull113 && filter_value113) {
/* 851 */             } else {
/* 852 */               boolean filter_isNull116 = true;
/* 853 */               boolean filter_value116 = false;
/* 854 */
/* 855 */               if (!scan_isNull3) {
/* 856 */                 Object filter_obj28 = ((Expression) references[34]).eval(null);
/* 857 */                 UTF8String filter_value118 = (UTF8String) filter_obj28;
/* 858 */
/* 859 */                 filter_isNull116 = false; // resultCode could change nullability.
/* 860 */                 filter_value116 = scan_value3.equals(filter_value118);
/* 861 */
/* 862 */               }
/* 863 */               if (!filter_isNull116 && filter_value116) {
/* 864 */               } else if (!filter_isNull113 && !filter_isNull116) {
/* 865 */                 filter_value112 = false;
/* 866 */               } else {
/* 867 */                 filter_isNull112 = true;
/* 868 */               }
/* 869 */             }
/* 870 */             boolean filter_isNull111 = false;
/* 871 */             boolean filter_value111 = false;
/* 872 */
/* 873 */             if (!filter_isNull112 && !filter_value112) {
/* 874 */             } else {
/* 875 */               boolean filter_isNull120 = true;
/* 876 */               boolean filter_value120 = false;
/* 877 */
/* 878 */               if (!scan_isNull4) {
/* 879 */                 Object filter_obj29 = ((Expression) references[35]).eval(null);
/* 880 */                 UTF8String filter_value122 = (UTF8String) filter_obj29;
/* 881 */
/* 882 */                 filter_isNull120 = false; // resultCode could change nullability.
/* 883 */                 filter_value120 = scan_value4.equals(filter_value122);
/* 884 */
/* 885 */               }
/* 886 */               boolean filter_isNull119 = false;
/* 887 */               boolean filter_value119 = true;
/* 888 */
/* 889 */               if (!filter_isNull120 && filter_value120) {
/* 890 */               } else {
/* 891 */                 boolean filter_isNull123 = true;
/* 892 */                 boolean filter_value123 = false;
/* 893 */
/* 894 */                 if (!scan_isNull4) {
/* 895 */                   Object filter_obj30 = ((Expression) references[36]).eval(null);
/* 896 */                   UTF8String filter_value125 = (UTF8String) filter_obj30;
/* 897 */
/* 898 */                   filter_isNull123 = false; // resultCode could change nullability.
/* 899 */                   filter_value123 = scan_value4.equals(filter_value125);
/* 900 */
/* 901 */                 }
/* 902 */                 if (!filter_isNull123 && filter_value123) {
/* 903 */                 } else if (!filter_isNull120 && !filter_isNull123) {
/* 904 */                   filter_value119 = false;
/* 905 */                 } else {
/* 906 */                   filter_isNull119 = true;
/* 907 */                 }
/* 908 */               }
/* 909 */               if (!filter_isNull119 && !filter_value119) {
/* 910 */               } else if (!filter_isNull112 && !filter_isNull119) {
/* 911 */                 filter_value111 = true;
/* 912 */               } else {
/* 913 */                 filter_isNull111 = true;
/* 914 */               }
/* 915 */             }
/* 916 */             boolean filter_isNull110 = false;
/* 917 */             boolean filter_value110 = false;
/* 918 */
/* 919 */             if (!filter_isNull111 && !filter_value111) {
/* 920 */             } else {
/* 921 */               boolean filter_isNull127 = true;
/* 922 */               boolean filter_value127 = false;
/* 923 */
/* 924 */               if (!scan_isNull2) {
/* 925 */                 Object filter_obj31 = ((Expression) references[37]).eval(null);
/* 926 */                 UTF8String filter_value129 = (UTF8String) filter_obj31;
/* 927 */
/* 928 */                 filter_isNull127 = false; // resultCode could change nullability.
/* 929 */                 filter_value127 = scan_value2.equals(filter_value129);
/* 930 */
/* 931 */               }
/* 932 */               boolean filter_isNull126 = false;
/* 933 */               boolean filter_value126 = true;
/* 934 */
/* 935 */               if (!filter_isNull127 && filter_value127) {
/* 936 */               } else {
/* 937 */                 boolean filter_isNull130 = true;
/* 938 */                 boolean filter_value130 = false;
/* 939 */
/* 940 */                 if (!scan_isNull2) {
/* 941 */                   Object filter_obj32 = ((Expression) references[38]).eval(null);
/* 942 */                   UTF8String filter_value132 = (UTF8String) filter_obj32;
/* 943 */
/* 944 */                   filter_isNull130 = false; // resultCode could change nullability.
/* 945 */                   filter_value130 = scan_value2.equals(filter_value132);
/* 946 */
/* 947 */                 }
/* 948 */                 if (!filter_isNull130 && filter_value130) {
/* 949 */                 } else if (!filter_isNull127 && !filter_isNull130) {
/* 950 */                   filter_value126 = false;
/* 951 */                 } else {
/* 952 */                   filter_isNull126 = true;
/* 953 */                 }
/* 954 */               }
/* 955 */               if (!filter_isNull126 && !filter_value126) {
/* 956 */               } else if (!filter_isNull111 && !filter_isNull126) {
/* 957 */                 filter_value110 = true;
/* 958 */               } else {
/* 959 */                 filter_isNull110 = true;
/* 960 */               }
/* 961 */             }
/* 962 */             boolean filter_isNull109 = false;
/* 963 */             boolean filter_value109 = true;
/* 964 */
/* 965 */             if (!filter_isNull110 && filter_value110) {
/* 966 */             } else {
/* 967 */               boolean filter_isNull136 = true;
/* 968 */               boolean filter_value136 = false;
/* 969 */
/* 970 */               if (!scan_isNull3) {
/* 971 */                 Object filter_obj33 = ((Expression) references[39]).eval(null);
/* 972 */                 UTF8String filter_value138 = (UTF8String) filter_obj33;
/* 973 */
/* 974 */                 filter_isNull136 = false; // resultCode could change nullability.
/* 975 */                 filter_value136 = scan_value3.equals(filter_value138);
/* 976 */
/* 977 */               }
/* 978 */               boolean filter_isNull135 = false;
/* 979 */               boolean filter_value135 = true;
/* 980 */
/* 981 */               if (!filter_isNull136 && filter_value136) {
/* 982 */               } else {
/* 983 */                 boolean filter_isNull139 = true;
/* 984 */                 boolean filter_value139 = false;
/* 985 */
/* 986 */                 if (!scan_isNull3) {
/* 987 */                   Object filter_obj34 = ((Expression) references[40]).eval(null);
/* 988 */                   UTF8String filter_value141 = (UTF8String) filter_obj34;
/* 989 */
/* 990 */                   filter_isNull139 = false; // resultCode could change nullability.
/* 991 */                   filter_value139 = scan_value3.equals(filter_value141);
/* 992 */
/* 993 */                 }
/* 994 */                 if (!filter_isNull139 && filter_value139) {
/* 995 */                 } else if (!filter_isNull136 && !filter_isNull139) {
/* 996 */                   filter_value135 = false;
/* 997 */                 } else {
/* 998 */                   filter_isNull135 = true;
/* 999 */                 }
/* 1000 */               }
/* 1001 */               boolean filter_isNull134 = false;
/* 1002 */               boolean filter_value134 = false;
/* 1003 */
/* 1004 */               if (!filter_isNull135 && !filter_value135) {
/* 1005 */               } else {
/* 1006 */                 boolean filter_isNull143 = true;
/* 1007 */                 boolean filter_value143 = false;
/* 1008 */
/* 1009 */                 if (!scan_isNull4) {
/* 1010 */                   Object filter_obj35 = ((Expression) references[41]).eval(null);
/* 1011 */                   UTF8String filter_value145 = (UTF8String) filter_obj35;
/* 1012 */
/* 1013 */                   filter_isNull143 = false; // resultCode could change nullability.
/* 1014 */                   filter_value143 = scan_value4.equals(filter_value145);
/* 1015 */
/* 1016 */                 }
/* 1017 */                 boolean filter_isNull142 = false;
/* 1018 */                 boolean filter_value142 = true;
/* 1019 */
/* 1020 */                 if (!filter_isNull143 && filter_value143) {
/* 1021 */                 } else {
/* 1022 */                   boolean filter_isNull146 = true;
/* 1023 */                   boolean filter_value146 = false;
/* 1024 */
/* 1025 */                   if (!scan_isNull4) {
/* 1026 */                     Object filter_obj36 = ((Expression) references[42]).eval(null);
/* 1027 */                     UTF8String filter_value148 = (UTF8String) filter_obj36;
/* 1028 */
/* 1029 */                     filter_isNull146 = false; // resultCode could change nullability.
/* 1030 */                     filter_value146 = scan_value4.equals(filter_value148);
/* 1031 */
/* 1032 */                   }
/* 1033 */                   if (!filter_isNull146 && filter_value146) {
/* 1034 */                   } else if (!filter_isNull143 && !filter_isNull146) {
/* 1035 */                     filter_value142 = false;
/* 1036 */                   } else {
/* 1037 */                     filter_isNull142 = true;
/* 1038 */                   }
/* 1039 */                 }
/* 1040 */                 if (!filter_isNull142 && !filter_value142) {
/* 1041 */                 } else if (!filter_isNull135 && !filter_isNull142) {
/* 1042 */                   filter_value134 = true;
/* 1043 */                 } else {
/* 1044 */                   filter_isNull134 = true;
/* 1045 */                 }
/* 1046 */               }
/* 1047 */               boolean filter_isNull133 = false;
/* 1048 */               boolean filter_value133 = false;
/* 1049 */
/* 1050 */               if (!filter_isNull134 && !filter_value134) {
/* 1051 */               } else {
/* 1052 */                 boolean filter_isNull150 = true;
/* 1053 */                 boolean filter_value150 = false;
/* 1054 */
/* 1055 */                 if (!scan_isNull2) {
/* 1056 */                   Object filter_obj37 = ((Expression) references[43]).eval(null);
/* 1057 */                   UTF8String filter_value152 = (UTF8String) filter_obj37;
/* 1058 */
/* 1059 */                   filter_isNull150 = false; // resultCode could change nullability.
/* 1060 */                   filter_value150 = scan_value2.equals(filter_value152);
/* 1061 */
/* 1062 */                 }
/* 1063 */                 boolean filter_isNull149 = false;
/* 1064 */                 boolean filter_value149 = true;
/* 1065 */
/* 1066 */                 if (!filter_isNull150 && filter_value150) {
/* 1067 */                 } else {
/* 1068 */                   boolean filter_isNull153 = true;
/* 1069 */                   boolean filter_value153 = false;
/* 1070 */
/* 1071 */                   if (!scan_isNull2) {
/* 1072 */                     Object filter_obj38 = ((Expression) references[44]).eval(null);
/* 1073 */                     UTF8String filter_value155 = (UTF8String) filter_obj38;
/* 1074 */
/* 1075 */                     filter_isNull153 = false; // resultCode could change nullability.
/* 1076 */                     filter_value153 = scan_value2.equals(filter_value155);
/* 1077 */
/* 1078 */                   }
/* 1079 */                   if (!filter_isNull153 && filter_value153) {
/* 1080 */                   } else if (!filter_isNull150 && !filter_isNull153) {
/* 1081 */                     filter_value149 = false;
/* 1082 */                   } else {
/* 1083 */                     filter_isNull149 = true;
/* 1084 */                   }
/* 1085 */                 }
/* 1086 */                 if (!filter_isNull149 && !filter_value149) {
/* 1087 */                 } else if (!filter_isNull134 && !filter_isNull149) {
/* 1088 */                   filter_value133 = true;
/* 1089 */                 } else {
/* 1090 */                   filter_isNull133 = true;
/* 1091 */                 }
/* 1092 */               }
/* 1093 */               if (!filter_isNull133 && filter_value133) {
/* 1094 */               } else if (!filter_isNull110 && !filter_isNull133) {
/* 1095 */                 filter_value109 = false;
/* 1096 */               } else {
/* 1097 */                 filter_isNull109 = true;
/* 1098 */               }
/* 1099 */             }
/* 1100 */             if (!filter_isNull109 && !filter_value109) {
/* 1101 */             } else if (!filter_isNull106 && !filter_isNull109) {
/* 1102 */               filter_value105 = true;
/* 1103 */             } else {
/* 1104 */               filter_isNull105 = true;
/* 1105 */             }
/* 1106 */           }
/* 1107 */           boolean filter_isNull104 = false;
/* 1108 */           boolean filter_value104 = true;
/* 1109 */
/* 1110 */           if (!filter_isNull105 && filter_value105) {
/* 1111 */           } else {
/* 1112 */             boolean filter_isNull157 = true;
/* 1113 */             boolean filter_value157 = false;
/* 1114 */
/* 1115 */             if (!scan_isNull) {
/* 1116 */               Object filter_obj39 = ((Expression) references[45]).eval(null);
/* 1117 */               UTF8String filter_value159 = (UTF8String) filter_obj39;
/* 1118 */
/* 1119 */               filter_isNull157 = false; // resultCode could change nullability.
/* 1120 */               filter_value157 = scan_value.equals(filter_value159);
/* 1121 */
/* 1122 */             }
/* 1123 */             boolean filter_isNull156 = false;
/* 1124 */             boolean filter_value156 = false;
/* 1125 */
/* 1126 */             if (!filter_isNull157 && !filter_value157) {
/* 1127 */             } else {
/* 1128 */               boolean filter_isNull164 = true;
/* 1129 */               boolean filter_value164 = false;
/* 1130 */
/* 1131 */               if (!scan_isNull3) {
/* 1132 */                 Object filter_obj40 = ((Expression) references[46]).eval(null);
/* 1133 */                 UTF8String filter_value166 = (UTF8String) filter_obj40;
/* 1134 */
/* 1135 */                 filter_isNull164 = false; // resultCode could change nullability.
/* 1136 */                 filter_value164 = scan_value3.equals(filter_value166);
/* 1137 */
/* 1138 */               }
/* 1139 */               boolean filter_isNull163 = false;
/* 1140 */               boolean filter_value163 = true;
/* 1141 */
/* 1142 */               if (!filter_isNull164 && filter_value164) {
/* 1143 */               } else {
/* 1144 */                 boolean filter_isNull167 = true;
/* 1145 */                 boolean filter_value167 = false;
/* 1146 */
/* 1147 */                 if (!scan_isNull3) {
/* 1148 */                   Object filter_obj41 = ((Expression) references[47]).eval(null);
/* 1149 */                   UTF8String filter_value169 = (UTF8String) filter_obj41;
/* 1150 */
/* 1151 */                   filter_isNull167 = false; // resultCode could change nullability.
/* 1152 */                   filter_value167 = scan_value3.equals(filter_value169);
/* 1153 */
/* 1154 */                 }
/* 1155 */                 if (!filter_isNull167 && filter_value167) {
/* 1156 */                 } else if (!filter_isNull164 && !filter_isNull167) {
/* 1157 */                   filter_value163 = false;
/* 1158 */                 } else {
/* 1159 */                   filter_isNull163 = true;
/* 1160 */                 }
/* 1161 */               }
/* 1162 */               boolean filter_isNull162 = false;
/* 1163 */               boolean filter_value162 = false;
/* 1164 */
/* 1165 */               if (!filter_isNull163 && !filter_value163) {
/* 1166 */               } else {
/* 1167 */                 boolean filter_isNull171 = true;
/* 1168 */                 boolean filter_value171 = false;
/* 1169 */
/* 1170 */                 if (!scan_isNull4) {
/* 1171 */                   Object filter_obj42 = ((Expression) references[48]).eval(null);
/* 1172 */                   UTF8String filter_value173 = (UTF8String) filter_obj42;
/* 1173 */
/* 1174 */                   filter_isNull171 = false; // resultCode could change nullability.
/* 1175 */                   filter_value171 = scan_value4.equals(filter_value173);
/* 1176 */
/* 1177 */                 }
/* 1178 */                 boolean filter_isNull170 = false;
/* 1179 */                 boolean filter_value170 = true;
/* 1180 */
/* 1181 */                 if (!filter_isNull171 && filter_value171) {
/* 1182 */                 } else {
/* 1183 */                   boolean filter_isNull174 = true;
/* 1184 */                   boolean filter_value174 = false;
/* 1185 */
/* 1186 */                   if (!scan_isNull4) {
/* 1187 */                     Object filter_obj43 = ((Expression) references[49]).eval(null);
/* 1188 */                     UTF8String filter_value176 = (UTF8String) filter_obj43;
/* 1189 */
/* 1190 */                     filter_isNull174 = false; // resultCode could change nullability.
/* 1191 */                     filter_value174 = scan_value4.equals(filter_value176);
/* 1192 */
/* 1193 */                   }
/* 1194 */                   if (!filter_isNull174 && filter_value174) {
/* 1195 */                   } else if (!filter_isNull171 && !filter_isNull174) {
/* 1196 */                     filter_value170 = false;
/* 1197 */                   } else {
/* 1198 */                     filter_isNull170 = true;
/* 1199 */                   }
/* 1200 */                 }
/* 1201 */                 if (!filter_isNull170 && !filter_value170) {
/* 1202 */                 } else if (!filter_isNull163 && !filter_isNull170) {
/* 1203 */                   filter_value162 = true;
/* 1204 */                 } else {
/* 1205 */                   filter_isNull162 = true;
/* 1206 */                 }
/* 1207 */               }
/* 1208 */               boolean filter_isNull161 = false;
/* 1209 */               boolean filter_value161 = false;
/* 1210 */
/* 1211 */               if (!filter_isNull162 && !filter_value162) {
/* 1212 */               } else {
/* 1213 */                 boolean filter_isNull178 = true;
/* 1214 */                 boolean filter_value178 = false;
/* 1215 */
/* 1216 */                 if (!scan_isNull2) {
/* 1217 */                   Object filter_obj44 = ((Expression) references[50]).eval(null);
/* 1218 */                   UTF8String filter_value180 = (UTF8String) filter_obj44;
/* 1219 */
/* 1220 */                   filter_isNull178 = false; // resultCode could change nullability.
/* 1221 */                   filter_value178 = scan_value2.equals(filter_value180);
/* 1222 */
/* 1223 */                 }
/* 1224 */                 boolean filter_isNull177 = false;
/* 1225 */                 boolean filter_value177 = true;
/* 1226 */
/* 1227 */                 if (!filter_isNull178 && filter_value178) {
/* 1228 */                 } else {
/* 1229 */                   boolean filter_isNull181 = true;
/* 1230 */                   boolean filter_value181 = false;
/* 1231 */
/* 1232 */                   if (!scan_isNull2) {
/* 1233 */                     Object filter_obj45 = ((Expression) references[51]).eval(null);
/* 1234 */                     UTF8String filter_value183 = (UTF8String) filter_obj45;
/* 1235 */
/* 1236 */                     filter_isNull181 = false; // resultCode could change nullability.
/* 1237 */                     filter_value181 = scan_value2.equals(filter_value183);
/* 1238 */
/* 1239 */                   }
/* 1240 */                   if (!filter_isNull181 && filter_value181) {
/* 1241 */                   } else if (!filter_isNull178 && !filter_isNull181) {
/* 1242 */                     filter_value177 = false;
/* 1243 */                   } else {
/* 1244 */                     filter_isNull177 = true;
/* 1245 */                   }
/* 1246 */                 }
/* 1247 */                 if (!filter_isNull177 && !filter_value177) {
/* 1248 */                 } else if (!filter_isNull162 && !filter_isNull177) {
/* 1249 */                   filter_value161 = true;
/* 1250 */                 } else {
/* 1251 */                   filter_isNull161 = true;
/* 1252 */                 }
/* 1253 */               }
/* 1254 */               boolean filter_isNull160 = false;
/* 1255 */               boolean filter_value160 = true;
/* 1256 */
/* 1257 */               if (!filter_isNull161 && filter_value161) {
/* 1258 */               } else {
/* 1259 */                 boolean filter_isNull187 = true;
/* 1260 */                 boolean filter_value187 = false;
/* 1261 */
/* 1262 */                 if (!scan_isNull3) {
/* 1263 */                   Object filter_obj46 = ((Expression) references[52]).eval(null);
/* 1264 */                   UTF8String filter_value189 = (UTF8String) filter_obj46;
/* 1265 */
/* 1266 */                   filter_isNull187 = false; // resultCode could change nullability.
/* 1267 */                   filter_value187 = scan_value3.equals(filter_value189);
/* 1268 */
/* 1269 */                 }
/* 1270 */                 boolean filter_isNull186 = false;
/* 1271 */                 boolean filter_value186 = true;
/* 1272 */
/* 1273 */                 if (!filter_isNull187 && filter_value187) {
/* 1274 */                 } else {
/* 1275 */                   boolean filter_isNull190 = true;
/* 1276 */                   boolean filter_value190 = false;
/* 1277 */
/* 1278 */                   if (!scan_isNull3) {
/* 1279 */                     Object filter_obj47 = ((Expression) references[53]).eval(null);
/* 1280 */                     UTF8String filter_value192 = (UTF8String) filter_obj47;
/* 1281 */
/* 1282 */                     filter_isNull190 = false; // resultCode could change nullability.
/* 1283 */                     filter_value190 = scan_value3.equals(filter_value192);
/* 1284 */
/* 1285 */                   }
/* 1286 */                   if (!filter_isNull190 && filter_value190) {
/* 1287 */                   } else if (!filter_isNull187 && !filter_isNull190) {
/* 1288 */                     filter_value186 = false;
/* 1289 */                   } else {
/* 1290 */                     filter_isNull186 = true;
/* 1291 */                   }
/* 1292 */                 }
/* 1293 */                 boolean filter_isNull185 = false;
/* 1294 */                 boolean filter_value185 = false;
/* 1295 */
/* 1296 */                 if (!filter_isNull186 && !filter_value186) {
/* 1297 */                 } else {
/* 1298 */                   boolean filter_isNull194 = true;
/* 1299 */                   boolean filter_value194 = false;
/* 1300 */
/* 1301 */                   if (!scan_isNull4) {
/* 1302 */                     Object filter_obj48 = ((Expression) references[54]).eval(null);
/* 1303 */                     UTF8String filter_value196 = (UTF8String) filter_obj48;
/* 1304 */
/* 1305 */                     filter_isNull194 = false; // resultCode could change nullability.
/* 1306 */                     filter_value194 = scan_value4.equals(filter_value196);
/* 1307 */
/* 1308 */                   }
/* 1309 */                   boolean filter_isNull193 = false;
/* 1310 */                   boolean filter_value193 = true;
/* 1311 */
/* 1312 */                   if (!filter_isNull194 && filter_value194) {
/* 1313 */                   } else {
/* 1314 */                     boolean filter_isNull197 = true;
/* 1315 */                     boolean filter_value197 = false;
/* 1316 */
/* 1317 */                     if (!scan_isNull4) {
/* 1318 */                       Object filter_obj49 = ((Expression) references[55]).eval(null);
/* 1319 */                       UTF8String filter_value199 = (UTF8String) filter_obj49;
/* 1320 */
/* 1321 */                       filter_isNull197 = false; // resultCode could change nullability.
/* 1322 */                       filter_value197 = scan_value4.equals(filter_value199);
/* 1323 */
/* 1324 */                     }
/* 1325 */                     if (!filter_isNull197 && filter_value197) {
/* 1326 */                     } else if (!filter_isNull194 && !filter_isNull197) {
/* 1327 */                       filter_value193 = false;
/* 1328 */                     } else {
/* 1329 */                       filter_isNull193 = true;
/* 1330 */                     }
/* 1331 */                   }
/* 1332 */                   if (!filter_isNull193 && !filter_value193) {
/* 1333 */                   } else if (!filter_isNull186 && !filter_isNull193) {
/* 1334 */                     filter_value185 = true;
/* 1335 */                   } else {
/* 1336 */                     filter_isNull185 = true;
/* 1337 */                   }
/* 1338 */                 }
/* 1339 */                 boolean filter_isNull184 = false;
/* 1340 */                 boolean filter_value184 = false;
/* 1341 */
/* 1342 */                 if (!filter_isNull185 && !filter_value185) {
/* 1343 */                 } else {
/* 1344 */                   boolean filter_isNull201 = true;
/* 1345 */                   boolean filter_value201 = false;
/* 1346 */
/* 1347 */                   if (!scan_isNull2) {
/* 1348 */                     Object filter_obj50 = ((Expression) references[56]).eval(null);
/* 1349 */                     UTF8String filter_value203 = (UTF8String) filter_obj50;
/* 1350 */
/* 1351 */                     filter_isNull201 = false; // resultCode could change nullability.
/* 1352 */                     filter_value201 = scan_value2.equals(filter_value203);
/* 1353 */
/* 1354 */                   }
/* 1355 */                   boolean filter_isNull200 = false;
/* 1356 */                   boolean filter_value200 = true;
/* 1357 */
/* 1358 */                   if (!filter_isNull201 && filter_value201) {
/* 1359 */                   } else {
/* 1360 */                     boolean filter_isNull204 = true;
/* 1361 */                     boolean filter_value204 = false;
/* 1362 */
/* 1363 */                     if (!scan_isNull2) {
/* 1364 */                       Object filter_obj51 = ((Expression) references[57]).eval(null);
/* 1365 */                       UTF8String filter_value206 = (UTF8String) filter_obj51;
/* 1366 */
/* 1367 */                       filter_isNull204 = false; // resultCode could change nullability.
/* 1368 */                       filter_value204 = scan_value2.equals(filter_value206);
/* 1369 */
/* 1370 */                     }
/* 1371 */                     if (!filter_isNull204 && filter_value204) {
/* 1372 */                     } else if (!filter_isNull201 && !filter_isNull204) {
/* 1373 */                       filter_value200 = false;
/* 1374 */                     } else {
/* 1375 */                       filter_isNull200 = true;
/* 1376 */                     }
/* 1377 */                   }
/* 1378 */                   if (!filter_isNull200 && !filter_value200) {
/* 1379 */                   } else if (!filter_isNull185 && !filter_isNull200) {
/* 1380 */                     filter_value184 = true;
/* 1381 */                   } else {
/* 1382 */                     filter_isNull184 = true;
/* 1383 */                   }
/* 1384 */                 }
/* 1385 */                 if (!filter_isNull184 && filter_value184) {
/* 1386 */                 } else if (!filter_isNull161 && !filter_isNull184) {
/* 1387 */                   filter_value160 = false;
/* 1388 */                 } else {
/* 1389 */                   filter_isNull160 = true;
/* 1390 */                 }
/* 1391 */               }
/* 1392 */               if (!filter_isNull160 && !filter_value160) {
/* 1393 */               } else if (!filter_isNull157 && !filter_isNull160) {
/* 1394 */                 filter_value156 = true;
/* 1395 */               } else {
/* 1396 */                 filter_isNull156 = true;
/* 1397 */               }
/* 1398 */             }
/* 1399 */             if (!filter_isNull156 && filter_value156) {
/* 1400 */             } else if (!filter_isNull105 && !filter_isNull156) {
/* 1401 */               filter_value104 = false;
/* 1402 */             } else {
/* 1403 */               filter_isNull104 = true;
/* 1404 */             }
/* 1405 */           }
/* 1406 */           if (!filter_isNull104 && filter_value104) {
/* 1407 */           } else if (!filter_isNull1 && !filter_isNull104) {
/* 1408 */             filter_value = false;
/* 1409 */           } else {
/* 1410 */             filter_isNull = true;
/* 1411 */           }
/* 1412 */         }
/* 1413 */         if (filter_isNull || !filter_value) continue;
/* 1414 */
/* 1415 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 1416 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 1417 */
/* 1418 */         if (!(!(scan_isNull1))) continue;
/* 1419 */
/* 1420 */         filter_numOutputRows.add(1);
/* 1421 */
/* 1422 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 1423 */
/* 1424 */         UnsafeRow agg_fastAggBuffer = null;
/* 1425 */
/* 1426 */         if (true) {
/* 1427 */           if (!false) {
/* 1428 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 1429 */               scan_value1);
/* 1430 */           }
/* 1431 */         }
/* 1432 */
/* 1433 */         if (agg_fastAggBuffer == null) {
/* 1434 */           // generate grouping key
/* 1435 */           agg_holder.reset();
/* 1436 */
/* 1437 */           agg_rowWriter.write(0, scan_value1);
/* 1438 */           agg_result1.setTotalSize(agg_holder.totalSize());
/* 1439 */           agg_value4 = 42;
/* 1440 */
/* 1441 */           if (!false) {
/* 1442 */             agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value1.getBaseObject(), scan_value1.getBaseOffset(), scan_value1.numBytes(), agg_value4);
/* 1443 */           }
/* 1444 */           if (true) {
/* 1445 */             // try to get the buffer from hash map
/* 1446 */             agg_unsafeRowAggBuffer =
/* 1447 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 1448 */           }
/* 1449 */           if (agg_unsafeRowAggBuffer == null) {
/* 1450 */             if (agg_sorter == null) {
/* 1451 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 1452 */             } else {
/* 1453 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 1454 */             }
/* 1455 */
/* 1456 */             // the hash map had be spilled, it should have enough memory now,
/* 1457 */             // try  to allocate buffer again.
/* 1458 */             agg_unsafeRowAggBuffer =
/* 1459 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 1460 */             if (agg_unsafeRowAggBuffer == null) {
/* 1461 */               // failed to allocate the first page
/* 1462 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 1463 */             }
/* 1464 */           }
/* 1465 */         }
/* 1466 */
/* 1467 */         if (agg_fastAggBuffer != null) {
/* 1468 */           // update fast row
/* 1469 */
/* 1470 */           // common sub-expressions
/* 1471 */
/* 1472 */           // evaluate aggregate function
/* 1473 */           boolean agg_isNull8 = false;
/* 1474 */
/* 1475 */           long agg_value10 = agg_fastAggBuffer.getLong(0);
/* 1476 */
/* 1477 */           long agg_value9 = -1L;
/* 1478 */           agg_value9 = agg_value10 + 1L;
/* 1479 */           // update fast row
/* 1480 */           agg_fastAggBuffer.setLong(0, agg_value9);
/* 1481 */
/* 1482 */         } else {
/* 1483 */           // update unsafe row
/* 1484 */
/* 1485 */           // common sub-expressions
/* 1486 */
/* 1487 */           // evaluate aggregate function
/* 1488 */           boolean agg_isNull5 = false;
/* 1489 */
/* 1490 */           long agg_value7 = agg_unsafeRowAggBuffer.getLong(0);
/* 1491 */
/* 1492 */           long agg_value6 = -1L;
/* 1493 */           agg_value6 = agg_value7 + 1L;
/* 1494 */           // update unsafe row buffer
/* 1495 */           agg_unsafeRowAggBuffer.setLong(0, agg_value6);
/* 1496 */
/* 1497 */         }
/* 1498 */         if (shouldStop()) return;
/* 1499 */       }
/* 1500 */       scan_batch = null;
/* 1501 */       scan_nextBatch();
/* 1502 */     }
/* 1503 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 1504 */     scan_scanTime1 = 0;
/* 1505 */
/* 1506 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 1507 */
/* 1508 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1509 */   }
/* 1510 */
/* 1511 */   private void wholestagecodegen_init_1() {
/* 1512 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 1513 */     filter_result = new UnsafeRow(5);
/* 1514 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 160);
/* 1515 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 1516 */     project_result = new UnsafeRow(1);
/* 1517 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 1518 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 1519 */     agg_result1 = new UnsafeRow(1);
/* 1520 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 1521 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 1522 */
/* 1523 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 1524 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[58];
/* 1525 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[59];
/* 1526 */
/* 1527 */   }
/* 1528 */
/* 1529 */   protected void processNext() throws java.io.IOException {
/* 1530 */     if (!agg_initAgg) {
/* 1531 */       agg_initAgg = true;
/* 1532 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1533 */       agg_doAggregateWithKeys();
/* 1534 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1535 */     }
/* 1536 */
/* 1537 */     // output the result
/* 1538 */
/* 1539 */     while (agg_fastHashMapIter.next()) {
/* 1540 */       wholestagecodegen_numOutputRows.add(1);
/* 1541 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 1542 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 1543 */
/* 1544 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1545 */
/* 1546 */       append(agg_resultRow);
/* 1547 */
/* 1548 */       if (shouldStop()) return;
/* 1549 */     }
/* 1550 */     agg_fastHashMap.close();
/* 1551 */
/* 1552 */     while (agg_mapIter.next()) {
/* 1553 */       wholestagecodegen_numOutputRows.add(1);
/* 1554 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1555 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1556 */
/* 1557 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1558 */
/* 1559 */       append(agg_resultRow);
/* 1560 */
/* 1561 */       if (shouldStop()) return;
/* 1562 */     }
/* 1563 */
/* 1564 */     agg_mapIter.close();
/* 1565 */     if (agg_sorter == null) {
/* 1566 */       agg_hashMap.free();
/* 1567 */     }
/* 1568 */   }
/* 1569 */ }
