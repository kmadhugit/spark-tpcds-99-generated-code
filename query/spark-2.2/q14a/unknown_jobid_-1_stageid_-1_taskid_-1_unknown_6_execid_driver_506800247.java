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
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
/* 013 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 014 */   private agg_FastHashMap agg_fastHashMap;
/* 015 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 016 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 017 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 018 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 021 */   private scala.collection.Iterator inputadapter_input;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric expand_numOutputRows;
/* 023 */   private UnsafeRow expand_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder expand_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter expand_rowWriter;
/* 026 */   private UnsafeRow agg_result5;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 029 */   private int agg_value14;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 033 */
/* 034 */   public GeneratedIterator(Object[] references) {
/* 035 */     this.references = references;
/* 036 */   }
/* 037 */
/* 038 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 039 */     partitionIndex = index;
/* 040 */     this.inputs = inputs;
/* 041 */     wholestagecodegen_init_0();
/* 042 */     wholestagecodegen_init_1();
/* 043 */
/* 044 */   }
/* 045 */
/* 046 */   private void wholestagecodegen_init_0() {
/* 047 */     agg_initAgg = false;
/* 048 */
/* 049 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 050 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 051 */
/* 052 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 053 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 054 */     inputadapter_input = inputs[0];
/* 055 */     this.expand_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 056 */     expand_result = new UnsafeRow(7);
/* 057 */     this.expand_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(expand_result, 32);
/* 058 */     this.expand_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(expand_holder, 7);
/* 059 */     agg_result5 = new UnsafeRow(5);
/* 060 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result5, 32);
/* 061 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */   public class agg_FastHashMap {
/* 066 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 067 */     private int[] buckets;
/* 068 */     private int capacity = 1 << 16;
/* 069 */     private double loadFactor = 0.5;
/* 070 */     private int numBuckets = (int) (capacity / loadFactor);
/* 071 */     private int maxSteps = 2;
/* 072 */     private int numRows = 0;
/* 073 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 074 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 075 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 076 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 077 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 078 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 079 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.LongType);
/* 080 */     private Object emptyVBase;
/* 081 */     private long emptyVOff;
/* 082 */     private int emptyVLen;
/* 083 */     private boolean isBatchFull = false;
/* 084 */
/* 085 */     public agg_FastHashMap(
/* 086 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 087 */       InternalRow emptyAggregationBuffer) {
/* 088 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 089 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 090 */
/* 091 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 092 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 093 */
/* 094 */       emptyVBase = emptyBuffer;
/* 095 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 096 */       emptyVLen = emptyBuffer.length;
/* 097 */
/* 098 */       buckets = new int[numBuckets];
/* 099 */       java.util.Arrays.fill(buckets, -1);
/* 100 */     }
/* 101 */
/* 102 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, int agg_key1, int agg_key2, int agg_key3, int agg_key4) {
/* 103 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4);
/* 104 */       int step = 0;
/* 105 */       int idx = (int) h & (numBuckets - 1);
/* 106 */       while (step < maxSteps) {
/* 107 */         // Return bucket index if it's either an empty slot or already contains the key
/* 108 */         if (buckets[idx] == -1) {
/* 109 */           if (numRows < capacity && !isBatchFull) {
/* 110 */             // creating the unsafe for new entry
/* 111 */             UnsafeRow agg_result = new UnsafeRow(5);
/* 112 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 113 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 114 */               32);
/* 115 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 116 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 117 */               agg_holder,
/* 118 */               5);
/* 119 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 120 */             agg_rowWriter.zeroOutNullBytes();
/* 121 */             agg_rowWriter.write(0, agg_key);
/* 122 */             agg_rowWriter.write(1, agg_key1);
/* 123 */             agg_rowWriter.write(2, agg_key2);
/* 124 */             agg_rowWriter.write(3, agg_key3);
/* 125 */             agg_rowWriter.write(4, agg_key4);
/* 126 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 127 */             Object kbase = agg_result.getBaseObject();
/* 128 */             long koff = agg_result.getBaseOffset();
/* 129 */             int klen = agg_result.getSizeInBytes();
/* 130 */
/* 131 */             UnsafeRow vRow
/* 132 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 133 */             if (vRow == null) {
/* 134 */               isBatchFull = true;
/* 135 */             } else {
/* 136 */               buckets[idx] = numRows++;
/* 137 */             }
/* 138 */             return vRow;
/* 139 */           } else {
/* 140 */             // No more space
/* 141 */             return null;
/* 142 */           }
/* 143 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4)) {
/* 144 */           return batch.getValueRow(buckets[idx]);
/* 145 */         }
/* 146 */         idx = (idx + 1) & (numBuckets - 1);
/* 147 */         step++;
/* 148 */       }
/* 149 */       // Didn't find it
/* 150 */       return null;
/* 151 */     }
/* 152 */
/* 153 */     private boolean equals(int idx, UTF8String agg_key, int agg_key1, int agg_key2, int agg_key3, int agg_key4) {
/* 154 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 155 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getInt(1) == agg_key1) && (row.getInt(2) == agg_key2) && (row.getInt(3) == agg_key3) && (row.getInt(4) == agg_key4);
/* 156 */     }
/* 157 */
/* 158 */     private long hash(UTF8String agg_key, int agg_key1, int agg_key2, int agg_key3, int agg_key4) {
/* 159 */       long agg_hash = 0;
/* 160 */
/* 161 */       int agg_result = 0;
/* 162 */       byte[] agg_bytes = agg_key.getBytes();
/* 163 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 164 */         int agg_hash1 = agg_bytes[i];
/* 165 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 166 */       }
/* 167 */
/* 168 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 169 */
/* 170 */       int agg_result1 = agg_key1;
/* 171 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 172 */
/* 173 */       int agg_result2 = agg_key2;
/* 174 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 175 */
/* 176 */       int agg_result3 = agg_key3;
/* 177 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 178 */
/* 179 */       int agg_result4 = agg_key4;
/* 180 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 181 */
/* 182 */       return agg_hash;
/* 183 */     }
/* 184 */
/* 185 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 186 */       return batch.rowIterator();
/* 187 */     }
/* 188 */
/* 189 */     public void close() {
/* 190 */       batch.close();
/* 191 */     }
/* 192 */
/* 193 */   }
/* 194 */
/* 195 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 196 */     agg_hashMap = agg_plan.createHashMap();
/* 197 */
/* 198 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 199 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 200 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 201 */       double inputadapter_value = inputadapter_isNull ? -1.0 : (inputadapter_row.getDouble(0));
/* 202 */       long inputadapter_value1 = inputadapter_row.getLong(1);
/* 203 */       UTF8String inputadapter_value2 = inputadapter_row.getUTF8String(2);
/* 204 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 205 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 206 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 207 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 208 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 209 */       int inputadapter_value5 = inputadapter_isNull5 ? -1 : (inputadapter_row.getInt(5));
/* 210 */
/* 211 */       boolean expand_isNull2 = true;
/* 212 */       UTF8String expand_value2 = null;
/* 213 */       boolean expand_isNull3 = true;
/* 214 */       int expand_value3 = -1;
/* 215 */       boolean expand_isNull4 = true;
/* 216 */       int expand_value4 = -1;
/* 217 */       boolean expand_isNull5 = true;
/* 218 */       int expand_value5 = -1;
/* 219 */       boolean expand_isNull6 = true;
/* 220 */       int expand_value6 = -1;
/* 221 */       for (int expand_i = 0; expand_i < 5; expand_i ++) {
/* 222 */         switch (expand_i) {
/* 223 */         case 0:
/* 224 */           expand_isNull2 = false;
/* 225 */           expand_value2 = inputadapter_value2;
/* 226 */
/* 227 */           expand_isNull3 = inputadapter_isNull3;
/* 228 */           expand_value3 = inputadapter_value3;
/* 229 */
/* 230 */           expand_isNull4 = inputadapter_isNull4;
/* 231 */           expand_value4 = inputadapter_value4;
/* 232 */
/* 233 */           expand_isNull5 = inputadapter_isNull5;
/* 234 */           expand_value5 = inputadapter_value5;
/* 235 */
/* 236 */           expand_isNull6 = false;
/* 237 */           expand_value6 = 0;
/* 238 */           break;
/* 239 */
/* 240 */         case 1:
/* 241 */           expand_isNull2 = false;
/* 242 */           expand_value2 = inputadapter_value2;
/* 243 */
/* 244 */           expand_isNull3 = inputadapter_isNull3;
/* 245 */           expand_value3 = inputadapter_value3;
/* 246 */
/* 247 */           expand_isNull4 = inputadapter_isNull4;
/* 248 */           expand_value4 = inputadapter_value4;
/* 249 */
/* 250 */           final int expand_value15 = -1;
/* 251 */           expand_isNull5 = true;
/* 252 */           expand_value5 = expand_value15;
/* 253 */
/* 254 */           expand_isNull6 = false;
/* 255 */           expand_value6 = 1;
/* 256 */           break;
/* 257 */
/* 258 */         case 2:
/* 259 */           expand_isNull2 = false;
/* 260 */           expand_value2 = inputadapter_value2;
/* 261 */
/* 262 */           expand_isNull3 = inputadapter_isNull3;
/* 263 */           expand_value3 = inputadapter_value3;
/* 264 */
/* 265 */           final int expand_value19 = -1;
/* 266 */           expand_isNull4 = true;
/* 267 */           expand_value4 = expand_value19;
/* 268 */
/* 269 */           final int expand_value20 = -1;
/* 270 */           expand_isNull5 = true;
/* 271 */           expand_value5 = expand_value20;
/* 272 */
/* 273 */           expand_isNull6 = false;
/* 274 */           expand_value6 = 3;
/* 275 */           break;
/* 276 */
/* 277 */         case 3:
/* 278 */           expand_isNull2 = false;
/* 279 */           expand_value2 = inputadapter_value2;
/* 280 */
/* 281 */           final int expand_value23 = -1;
/* 282 */           expand_isNull3 = true;
/* 283 */           expand_value3 = expand_value23;
/* 284 */
/* 285 */           final int expand_value24 = -1;
/* 286 */           expand_isNull4 = true;
/* 287 */           expand_value4 = expand_value24;
/* 288 */
/* 289 */           final int expand_value25 = -1;
/* 290 */           expand_isNull5 = true;
/* 291 */           expand_value5 = expand_value25;
/* 292 */
/* 293 */           expand_isNull6 = false;
/* 294 */           expand_value6 = 7;
/* 295 */           break;
/* 296 */
/* 297 */         case 4:
/* 298 */           final UTF8String expand_value27 = null;
/* 299 */           expand_isNull2 = true;
/* 300 */           expand_value2 = expand_value27;
/* 301 */
/* 302 */           final int expand_value28 = -1;
/* 303 */           expand_isNull3 = true;
/* 304 */           expand_value3 = expand_value28;
/* 305 */
/* 306 */           final int expand_value29 = -1;
/* 307 */           expand_isNull4 = true;
/* 308 */           expand_value4 = expand_value29;
/* 309 */
/* 310 */           final int expand_value30 = -1;
/* 311 */           expand_isNull5 = true;
/* 312 */           expand_value5 = expand_value30;
/* 313 */
/* 314 */           expand_isNull6 = false;
/* 315 */           expand_value6 = 15;
/* 316 */           break;
/* 317 */         }
/* 318 */         expand_numOutputRows.add(1);
/* 319 */
/* 320 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 321 */
/* 322 */         UnsafeRow agg_fastAggBuffer = null;
/* 323 */
/* 324 */         if (true) {
/* 325 */           if (!expand_isNull2 && !expand_isNull3 && !expand_isNull4 && !expand_isNull5 && !expand_isNull6) {
/* 326 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 327 */               expand_value2, expand_value3, expand_value4, expand_value5, expand_value6);
/* 328 */           }
/* 329 */         }
/* 330 */
/* 331 */         if (agg_fastAggBuffer == null) {
/* 332 */           // generate grouping key
/* 333 */           agg_holder.reset();
/* 334 */
/* 335 */           agg_rowWriter.zeroOutNullBytes();
/* 336 */
/* 337 */           if (expand_isNull2) {
/* 338 */             agg_rowWriter.setNullAt(0);
/* 339 */           } else {
/* 340 */             agg_rowWriter.write(0, expand_value2);
/* 341 */           }
/* 342 */
/* 343 */           if (expand_isNull3) {
/* 344 */             agg_rowWriter.setNullAt(1);
/* 345 */           } else {
/* 346 */             agg_rowWriter.write(1, expand_value3);
/* 347 */           }
/* 348 */
/* 349 */           if (expand_isNull4) {
/* 350 */             agg_rowWriter.setNullAt(2);
/* 351 */           } else {
/* 352 */             agg_rowWriter.write(2, expand_value4);
/* 353 */           }
/* 354 */
/* 355 */           if (expand_isNull5) {
/* 356 */             agg_rowWriter.setNullAt(3);
/* 357 */           } else {
/* 358 */             agg_rowWriter.write(3, expand_value5);
/* 359 */           }
/* 360 */
/* 361 */           if (expand_isNull6) {
/* 362 */             agg_rowWriter.setNullAt(4);
/* 363 */           } else {
/* 364 */             agg_rowWriter.write(4, expand_value6);
/* 365 */           }
/* 366 */           agg_result5.setTotalSize(agg_holder.totalSize());
/* 367 */           agg_value14 = 42;
/* 368 */
/* 369 */           if (!expand_isNull2) {
/* 370 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value2.getBaseObject(), expand_value2.getBaseOffset(), expand_value2.numBytes(), agg_value14);
/* 371 */           }
/* 372 */
/* 373 */           if (!expand_isNull3) {
/* 374 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(expand_value3, agg_value14);
/* 375 */           }
/* 376 */
/* 377 */           if (!expand_isNull4) {
/* 378 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(expand_value4, agg_value14);
/* 379 */           }
/* 380 */
/* 381 */           if (!expand_isNull5) {
/* 382 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(expand_value5, agg_value14);
/* 383 */           }
/* 384 */
/* 385 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(expand_value6, agg_value14);
/* 386 */           if (true) {
/* 387 */             // try to get the buffer from hash map
/* 388 */             agg_unsafeRowAggBuffer =
/* 389 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value14);
/* 390 */           }
/* 391 */           if (agg_unsafeRowAggBuffer == null) {
/* 392 */             if (agg_sorter == null) {
/* 393 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 394 */             } else {
/* 395 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 396 */             }
/* 397 */
/* 398 */             // the hash map had be spilled, it should have enough memory now,
/* 399 */             // try  to allocate buffer again.
/* 400 */             agg_unsafeRowAggBuffer =
/* 401 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value14);
/* 402 */             if (agg_unsafeRowAggBuffer == null) {
/* 403 */               // failed to allocate the first page
/* 404 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 405 */             }
/* 406 */           }
/* 407 */         }
/* 408 */
/* 409 */         if (agg_fastAggBuffer != null) {
/* 410 */           // update fast row
/* 411 */
/* 412 */           // common sub-expressions
/* 413 */
/* 414 */           // evaluate aggregate function
/* 415 */           boolean agg_isNull33 = true;
/* 416 */           double agg_value35 = -1.0;
/* 417 */
/* 418 */           boolean agg_isNull35 = agg_fastAggBuffer.isNullAt(0);
/* 419 */           double agg_value37 = agg_isNull35 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 420 */           boolean agg_isNull34 = agg_isNull35;
/* 421 */           double agg_value36 = agg_value37;
/* 422 */           if (agg_isNull34) {
/* 423 */             boolean agg_isNull36 = false;
/* 424 */             double agg_value38 = -1.0;
/* 425 */             if (!false) {
/* 426 */               agg_value38 = (double) 0;
/* 427 */             }
/* 428 */             if (!agg_isNull36) {
/* 429 */               agg_isNull34 = false;
/* 430 */               agg_value36 = agg_value38;
/* 431 */             }
/* 432 */           }
/* 433 */
/* 434 */           if (!inputadapter_isNull) {
/* 435 */             agg_isNull33 = false; // resultCode could change nullability.
/* 436 */             agg_value35 = agg_value36 + inputadapter_value;
/* 437 */
/* 438 */           }
/* 439 */           boolean agg_isNull32 = agg_isNull33;
/* 440 */           double agg_value34 = agg_value35;
/* 441 */           if (agg_isNull32) {
/* 442 */             boolean agg_isNull39 = agg_fastAggBuffer.isNullAt(0);
/* 443 */             double agg_value41 = agg_isNull39 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 444 */             if (!agg_isNull39) {
/* 445 */               agg_isNull32 = false;
/* 446 */               agg_value34 = agg_value41;
/* 447 */             }
/* 448 */           }
/* 449 */           boolean agg_isNull40 = false;
/* 450 */
/* 451 */           boolean agg_isNull42 = agg_fastAggBuffer.isNullAt(1);
/* 452 */           long agg_value44 = agg_isNull42 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 453 */           boolean agg_isNull41 = agg_isNull42;
/* 454 */           long agg_value43 = agg_value44;
/* 455 */           if (agg_isNull41) {
/* 456 */             boolean agg_isNull43 = false;
/* 457 */             long agg_value45 = -1L;
/* 458 */             if (!false) {
/* 459 */               agg_value45 = (long) 0;
/* 460 */             }
/* 461 */             if (!agg_isNull43) {
/* 462 */               agg_isNull41 = false;
/* 463 */               agg_value43 = agg_value45;
/* 464 */             }
/* 465 */           }
/* 466 */
/* 467 */           long agg_value42 = -1L;
/* 468 */           agg_value42 = agg_value43 + inputadapter_value1;
/* 469 */           // update fast row
/* 470 */           if (!agg_isNull32) {
/* 471 */             agg_fastAggBuffer.setDouble(0, agg_value34);
/* 472 */           } else {
/* 473 */             agg_fastAggBuffer.setNullAt(0);
/* 474 */           }
/* 475 */
/* 476 */           agg_fastAggBuffer.setLong(1, agg_value42);
/* 477 */
/* 478 */         } else {
/* 479 */           // update unsafe row
/* 480 */
/* 481 */           // common sub-expressions
/* 482 */
/* 483 */           // evaluate aggregate function
/* 484 */           boolean agg_isNull19 = true;
/* 485 */           double agg_value21 = -1.0;
/* 486 */
/* 487 */           boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 488 */           double agg_value23 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 489 */           boolean agg_isNull20 = agg_isNull21;
/* 490 */           double agg_value22 = agg_value23;
/* 491 */           if (agg_isNull20) {
/* 492 */             boolean agg_isNull22 = false;
/* 493 */             double agg_value24 = -1.0;
/* 494 */             if (!false) {
/* 495 */               agg_value24 = (double) 0;
/* 496 */             }
/* 497 */             if (!agg_isNull22) {
/* 498 */               agg_isNull20 = false;
/* 499 */               agg_value22 = agg_value24;
/* 500 */             }
/* 501 */           }
/* 502 */
/* 503 */           if (!inputadapter_isNull) {
/* 504 */             agg_isNull19 = false; // resultCode could change nullability.
/* 505 */             agg_value21 = agg_value22 + inputadapter_value;
/* 506 */
/* 507 */           }
/* 508 */           boolean agg_isNull18 = agg_isNull19;
/* 509 */           double agg_value20 = agg_value21;
/* 510 */           if (agg_isNull18) {
/* 511 */             boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 512 */             double agg_value27 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 513 */             if (!agg_isNull25) {
/* 514 */               agg_isNull18 = false;
/* 515 */               agg_value20 = agg_value27;
/* 516 */             }
/* 517 */           }
/* 518 */           boolean agg_isNull26 = false;
/* 519 */
/* 520 */           boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 521 */           long agg_value30 = agg_isNull28 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 522 */           boolean agg_isNull27 = agg_isNull28;
/* 523 */           long agg_value29 = agg_value30;
/* 524 */           if (agg_isNull27) {
/* 525 */             boolean agg_isNull29 = false;
/* 526 */             long agg_value31 = -1L;
/* 527 */             if (!false) {
/* 528 */               agg_value31 = (long) 0;
/* 529 */             }
/* 530 */             if (!agg_isNull29) {
/* 531 */               agg_isNull27 = false;
/* 532 */               agg_value29 = agg_value31;
/* 533 */             }
/* 534 */           }
/* 535 */
/* 536 */           long agg_value28 = -1L;
/* 537 */           agg_value28 = agg_value29 + inputadapter_value1;
/* 538 */           // update unsafe row buffer
/* 539 */           if (!agg_isNull18) {
/* 540 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value20);
/* 541 */           } else {
/* 542 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 543 */           }
/* 544 */
/* 545 */           agg_unsafeRowAggBuffer.setLong(1, agg_value28);
/* 546 */
/* 547 */         }
/* 548 */
/* 549 */       }
/* 550 */       if (shouldStop()) return;
/* 551 */     }
/* 552 */
/* 553 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 554 */
/* 555 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 556 */   }
/* 557 */
/* 558 */   private void wholestagecodegen_init_1() {
/* 559 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 560 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 561 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 562 */
/* 563 */   }
/* 564 */
/* 565 */   protected void processNext() throws java.io.IOException {
/* 566 */     if (!agg_initAgg) {
/* 567 */       agg_initAgg = true;
/* 568 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 569 */       agg_doAggregateWithKeys();
/* 570 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 571 */     }
/* 572 */
/* 573 */     // output the result
/* 574 */
/* 575 */     while (agg_fastHashMapIter.next()) {
/* 576 */       wholestagecodegen_numOutputRows.add(1);
/* 577 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 578 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 579 */
/* 580 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 581 */
/* 582 */       append(agg_resultRow.copy());
/* 583 */
/* 584 */       if (shouldStop()) return;
/* 585 */     }
/* 586 */     agg_fastHashMap.close();
/* 587 */
/* 588 */     while (agg_mapIter.next()) {
/* 589 */       wholestagecodegen_numOutputRows.add(1);
/* 590 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 591 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 592 */
/* 593 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 594 */
/* 595 */       append(agg_resultRow.copy());
/* 596 */
/* 597 */       if (shouldStop()) return;
/* 598 */     }
/* 599 */
/* 600 */     agg_mapIter.close();
/* 601 */     if (agg_sorter == null) {
/* 602 */       agg_hashMap.free();
/* 603 */     }
/* 604 */   }
/* 605 */ }
