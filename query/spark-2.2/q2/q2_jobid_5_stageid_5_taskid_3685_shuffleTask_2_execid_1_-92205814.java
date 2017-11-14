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
/* 012 */   private double agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private double agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private double agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private double agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private double agg_bufValue6;
/* 023 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 024 */   private agg_FastHashMap agg_fastHashMap;
/* 025 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 026 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 027 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 028 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 031 */   private scala.collection.Iterator inputadapter_input;
/* 032 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 033 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 035 */   private UnsafeRow bhj_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 038 */   private UnsafeRow project_result;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 041 */   private UnsafeRow agg_result1;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 044 */   private int agg_value16;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 046 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 047 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 048 */
/* 049 */   public GeneratedIterator(Object[] references) {
/* 050 */     this.references = references;
/* 051 */   }
/* 052 */
/* 053 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 054 */     partitionIndex = index;
/* 055 */     this.inputs = inputs;
/* 056 */     wholestagecodegen_init_0();
/* 057 */     wholestagecodegen_init_1();
/* 058 */
/* 059 */   }
/* 060 */
/* 061 */   private void wholestagecodegen_init_0() {
/* 062 */     agg_initAgg = false;
/* 063 */
/* 064 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 065 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 066 */
/* 067 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 068 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 069 */     inputadapter_input = inputs[0];
/* 070 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[11];
/* 071 */
/* 072 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 073 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 074 */
/* 075 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 076 */     bhj_result = new UnsafeRow(5);
/* 077 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 078 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 079 */
/* 080 */   }
/* 081 */
/* 082 */   public class agg_FastHashMap {
/* 083 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 084 */     private int[] buckets;
/* 085 */     private int capacity = 1 << 16;
/* 086 */     private double loadFactor = 0.5;
/* 087 */     private int numBuckets = (int) (capacity / loadFactor);
/* 088 */     private int maxSteps = 2;
/* 089 */     private int numRows = 0;
/* 090 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 091 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 092 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 093 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 094 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 095 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 096 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 097 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 098 */     private Object emptyVBase;
/* 099 */     private long emptyVOff;
/* 100 */     private int emptyVLen;
/* 101 */     private boolean isBatchFull = false;
/* 102 */
/* 103 */     public agg_FastHashMap(
/* 104 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 105 */       InternalRow emptyAggregationBuffer) {
/* 106 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 107 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 108 */
/* 109 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 110 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 111 */
/* 112 */       emptyVBase = emptyBuffer;
/* 113 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 114 */       emptyVLen = emptyBuffer.length;
/* 115 */
/* 116 */       buckets = new int[numBuckets];
/* 117 */       java.util.Arrays.fill(buckets, -1);
/* 118 */     }
/* 119 */
/* 120 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 121 */       long h = hash(agg_key);
/* 122 */       int step = 0;
/* 123 */       int idx = (int) h & (numBuckets - 1);
/* 124 */       while (step < maxSteps) {
/* 125 */         // Return bucket index if it's either an empty slot or already contains the key
/* 126 */         if (buckets[idx] == -1) {
/* 127 */           if (numRows < capacity && !isBatchFull) {
/* 128 */             // creating the unsafe for new entry
/* 129 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 130 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 131 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 132 */               0);
/* 133 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 134 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 135 */               agg_holder,
/* 136 */               1);
/* 137 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 138 */             agg_rowWriter.zeroOutNullBytes();
/* 139 */             agg_rowWriter.write(0, agg_key);
/* 140 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 141 */             Object kbase = agg_result.getBaseObject();
/* 142 */             long koff = agg_result.getBaseOffset();
/* 143 */             int klen = agg_result.getSizeInBytes();
/* 144 */
/* 145 */             UnsafeRow vRow
/* 146 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 147 */             if (vRow == null) {
/* 148 */               isBatchFull = true;
/* 149 */             } else {
/* 150 */               buckets[idx] = numRows++;
/* 151 */             }
/* 152 */             return vRow;
/* 153 */           } else {
/* 154 */             // No more space
/* 155 */             return null;
/* 156 */           }
/* 157 */         } else if (equals(idx, agg_key)) {
/* 158 */           return batch.getValueRow(buckets[idx]);
/* 159 */         }
/* 160 */         idx = (idx + 1) & (numBuckets - 1);
/* 161 */         step++;
/* 162 */       }
/* 163 */       // Didn't find it
/* 164 */       return null;
/* 165 */     }
/* 166 */
/* 167 */     private boolean equals(int idx, int agg_key) {
/* 168 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 169 */       return (row.getInt(0) == agg_key);
/* 170 */     }
/* 171 */
/* 172 */     private long hash(int agg_key) {
/* 173 */       long agg_hash = 0;
/* 174 */
/* 175 */       int agg_result = agg_key;
/* 176 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
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
/* 196 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 197 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 198 */
/* 199 */       // generate join key for stream side
/* 200 */
/* 201 */       boolean bhj_isNull = inputadapter_isNull;
/* 202 */       long bhj_value = -1L;
/* 203 */       if (!inputadapter_isNull) {
/* 204 */         bhj_value = (long) inputadapter_value;
/* 205 */       }
/* 206 */       // find matches from HashedRelation
/* 207 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 208 */       if (bhj_matched == null) continue;
/* 209 */
/* 210 */       bhj_numOutputRows.add(1);
/* 211 */
/* 212 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 213 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 214 */       boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 215 */       int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 216 */       boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 217 */       UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 218 */
/* 219 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 220 */
/* 221 */       UnsafeRow agg_fastAggBuffer = null;
/* 222 */
/* 223 */       if (true) {
/* 224 */         if (!bhj_isNull3) {
/* 225 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 226 */             bhj_value3);
/* 227 */         }
/* 228 */       }
/* 229 */
/* 230 */       if (agg_fastAggBuffer == null) {
/* 231 */         // generate grouping key
/* 232 */         agg_rowWriter.zeroOutNullBytes();
/* 233 */
/* 234 */         if (bhj_isNull3) {
/* 235 */           agg_rowWriter.setNullAt(0);
/* 236 */         } else {
/* 237 */           agg_rowWriter.write(0, bhj_value3);
/* 238 */         }
/* 239 */         agg_value16 = 42;
/* 240 */
/* 241 */         if (!bhj_isNull3) {
/* 242 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value3, agg_value16);
/* 243 */         }
/* 244 */         if (true) {
/* 245 */           // try to get the buffer from hash map
/* 246 */           agg_unsafeRowAggBuffer =
/* 247 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value16);
/* 248 */         }
/* 249 */         if (agg_unsafeRowAggBuffer == null) {
/* 250 */           if (agg_sorter == null) {
/* 251 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 252 */           } else {
/* 253 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 254 */           }
/* 255 */
/* 256 */           // the hash map had be spilled, it should have enough memory now,
/* 257 */           // try  to allocate buffer again.
/* 258 */           agg_unsafeRowAggBuffer =
/* 259 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value16);
/* 260 */           if (agg_unsafeRowAggBuffer == null) {
/* 261 */             // failed to allocate the first page
/* 262 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 263 */           }
/* 264 */         }
/* 265 */       }
/* 266 */
/* 267 */       if (agg_fastAggBuffer != null) {
/* 268 */         // update fast row
/* 269 */
/* 270 */         // common sub-expressions
/* 271 */
/* 272 */         // evaluate aggregate function
/* 273 */         boolean agg_isNull103 = true;
/* 274 */         double agg_value110 = -1.0;
/* 275 */
/* 276 */         boolean agg_isNull105 = agg_fastAggBuffer.isNullAt(0);
/* 277 */         double agg_value112 = agg_isNull105 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 278 */         boolean agg_isNull104 = agg_isNull105;
/* 279 */         double agg_value111 = agg_value112;
/* 280 */         if (agg_isNull104) {
/* 281 */           boolean agg_isNull106 = false;
/* 282 */           double agg_value113 = -1.0;
/* 283 */           if (!false) {
/* 284 */             agg_value113 = (double) 0;
/* 285 */           }
/* 286 */           if (!agg_isNull106) {
/* 287 */             agg_isNull104 = false;
/* 288 */             agg_value111 = agg_value113;
/* 289 */           }
/* 290 */         }
/* 291 */
/* 292 */         boolean agg_isNull108 = true;
/* 293 */         double agg_value115 = -1.0;
/* 294 */
/* 295 */         boolean agg_isNull109 = true;
/* 296 */         boolean agg_value116 = false;
/* 297 */
/* 298 */         if (!bhj_isNull4) {
/* 299 */           agg_isNull109 = false; // resultCode could change nullability.
/* 300 */           agg_value116 = bhj_value4.equals(((UTF8String) references[20]));
/* 301 */
/* 302 */         }
/* 303 */         if (!agg_isNull109 && agg_value116) {
/* 304 */           agg_isNull108 = inputadapter_isNull1;
/* 305 */           agg_value115 = inputadapter_value1;
/* 306 */         }
/* 307 */
/* 308 */         else {
/* 309 */           final double agg_value120 = -1.0;
/* 310 */           agg_isNull108 = true;
/* 311 */           agg_value115 = agg_value120;
/* 312 */         }
/* 313 */         if (!agg_isNull108) {
/* 314 */           agg_isNull103 = false; // resultCode could change nullability.
/* 315 */           agg_value110 = agg_value111 + agg_value115;
/* 316 */
/* 317 */         }
/* 318 */         boolean agg_isNull102 = agg_isNull103;
/* 319 */         double agg_value109 = agg_value110;
/* 320 */         if (agg_isNull102) {
/* 321 */           boolean agg_isNull114 = agg_fastAggBuffer.isNullAt(0);
/* 322 */           double agg_value121 = agg_isNull114 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 323 */           if (!agg_isNull114) {
/* 324 */             agg_isNull102 = false;
/* 325 */             agg_value109 = agg_value121;
/* 326 */           }
/* 327 */         }
/* 328 */         boolean agg_isNull116 = true;
/* 329 */         double agg_value123 = -1.0;
/* 330 */
/* 331 */         boolean agg_isNull118 = agg_fastAggBuffer.isNullAt(1);
/* 332 */         double agg_value125 = agg_isNull118 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 333 */         boolean agg_isNull117 = agg_isNull118;
/* 334 */         double agg_value124 = agg_value125;
/* 335 */         if (agg_isNull117) {
/* 336 */           boolean agg_isNull119 = false;
/* 337 */           double agg_value126 = -1.0;
/* 338 */           if (!false) {
/* 339 */             agg_value126 = (double) 0;
/* 340 */           }
/* 341 */           if (!agg_isNull119) {
/* 342 */             agg_isNull117 = false;
/* 343 */             agg_value124 = agg_value126;
/* 344 */           }
/* 345 */         }
/* 346 */
/* 347 */         boolean agg_isNull121 = true;
/* 348 */         double agg_value128 = -1.0;
/* 349 */
/* 350 */         boolean agg_isNull122 = true;
/* 351 */         boolean agg_value129 = false;
/* 352 */
/* 353 */         if (!bhj_isNull4) {
/* 354 */           agg_isNull122 = false; // resultCode could change nullability.
/* 355 */           agg_value129 = bhj_value4.equals(((UTF8String) references[21]));
/* 356 */
/* 357 */         }
/* 358 */         if (!agg_isNull122 && agg_value129) {
/* 359 */           agg_isNull121 = inputadapter_isNull1;
/* 360 */           agg_value128 = inputadapter_value1;
/* 361 */         }
/* 362 */
/* 363 */         else {
/* 364 */           final double agg_value133 = -1.0;
/* 365 */           agg_isNull121 = true;
/* 366 */           agg_value128 = agg_value133;
/* 367 */         }
/* 368 */         if (!agg_isNull121) {
/* 369 */           agg_isNull116 = false; // resultCode could change nullability.
/* 370 */           agg_value123 = agg_value124 + agg_value128;
/* 371 */
/* 372 */         }
/* 373 */         boolean agg_isNull115 = agg_isNull116;
/* 374 */         double agg_value122 = agg_value123;
/* 375 */         if (agg_isNull115) {
/* 376 */           boolean agg_isNull127 = agg_fastAggBuffer.isNullAt(1);
/* 377 */           double agg_value134 = agg_isNull127 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 378 */           if (!agg_isNull127) {
/* 379 */             agg_isNull115 = false;
/* 380 */             agg_value122 = agg_value134;
/* 381 */           }
/* 382 */         }
/* 383 */         boolean agg_isNull129 = true;
/* 384 */         double agg_value136 = -1.0;
/* 385 */
/* 386 */         boolean agg_isNull131 = agg_fastAggBuffer.isNullAt(2);
/* 387 */         double agg_value138 = agg_isNull131 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 388 */         boolean agg_isNull130 = agg_isNull131;
/* 389 */         double agg_value137 = agg_value138;
/* 390 */         if (agg_isNull130) {
/* 391 */           boolean agg_isNull132 = false;
/* 392 */           double agg_value139 = -1.0;
/* 393 */           if (!false) {
/* 394 */             agg_value139 = (double) 0;
/* 395 */           }
/* 396 */           if (!agg_isNull132) {
/* 397 */             agg_isNull130 = false;
/* 398 */             agg_value137 = agg_value139;
/* 399 */           }
/* 400 */         }
/* 401 */
/* 402 */         boolean agg_isNull134 = true;
/* 403 */         double agg_value141 = -1.0;
/* 404 */
/* 405 */         boolean agg_isNull135 = true;
/* 406 */         boolean agg_value142 = false;
/* 407 */
/* 408 */         if (!bhj_isNull4) {
/* 409 */           agg_isNull135 = false; // resultCode could change nullability.
/* 410 */           agg_value142 = bhj_value4.equals(((UTF8String) references[22]));
/* 411 */
/* 412 */         }
/* 413 */         if (!agg_isNull135 && agg_value142) {
/* 414 */           agg_isNull134 = inputadapter_isNull1;
/* 415 */           agg_value141 = inputadapter_value1;
/* 416 */         }
/* 417 */
/* 418 */         else {
/* 419 */           final double agg_value146 = -1.0;
/* 420 */           agg_isNull134 = true;
/* 421 */           agg_value141 = agg_value146;
/* 422 */         }
/* 423 */         if (!agg_isNull134) {
/* 424 */           agg_isNull129 = false; // resultCode could change nullability.
/* 425 */           agg_value136 = agg_value137 + agg_value141;
/* 426 */
/* 427 */         }
/* 428 */         boolean agg_isNull128 = agg_isNull129;
/* 429 */         double agg_value135 = agg_value136;
/* 430 */         if (agg_isNull128) {
/* 431 */           boolean agg_isNull140 = agg_fastAggBuffer.isNullAt(2);
/* 432 */           double agg_value147 = agg_isNull140 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 433 */           if (!agg_isNull140) {
/* 434 */             agg_isNull128 = false;
/* 435 */             agg_value135 = agg_value147;
/* 436 */           }
/* 437 */         }
/* 438 */         boolean agg_isNull142 = true;
/* 439 */         double agg_value149 = -1.0;
/* 440 */
/* 441 */         boolean agg_isNull144 = agg_fastAggBuffer.isNullAt(3);
/* 442 */         double agg_value151 = agg_isNull144 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 443 */         boolean agg_isNull143 = agg_isNull144;
/* 444 */         double agg_value150 = agg_value151;
/* 445 */         if (agg_isNull143) {
/* 446 */           boolean agg_isNull145 = false;
/* 447 */           double agg_value152 = -1.0;
/* 448 */           if (!false) {
/* 449 */             agg_value152 = (double) 0;
/* 450 */           }
/* 451 */           if (!agg_isNull145) {
/* 452 */             agg_isNull143 = false;
/* 453 */             agg_value150 = agg_value152;
/* 454 */           }
/* 455 */         }
/* 456 */
/* 457 */         boolean agg_isNull147 = true;
/* 458 */         double agg_value154 = -1.0;
/* 459 */
/* 460 */         boolean agg_isNull148 = true;
/* 461 */         boolean agg_value155 = false;
/* 462 */
/* 463 */         if (!bhj_isNull4) {
/* 464 */           agg_isNull148 = false; // resultCode could change nullability.
/* 465 */           agg_value155 = bhj_value4.equals(((UTF8String) references[23]));
/* 466 */
/* 467 */         }
/* 468 */         if (!agg_isNull148 && agg_value155) {
/* 469 */           agg_isNull147 = inputadapter_isNull1;
/* 470 */           agg_value154 = inputadapter_value1;
/* 471 */         }
/* 472 */
/* 473 */         else {
/* 474 */           final double agg_value159 = -1.0;
/* 475 */           agg_isNull147 = true;
/* 476 */           agg_value154 = agg_value159;
/* 477 */         }
/* 478 */         if (!agg_isNull147) {
/* 479 */           agg_isNull142 = false; // resultCode could change nullability.
/* 480 */           agg_value149 = agg_value150 + agg_value154;
/* 481 */
/* 482 */         }
/* 483 */         boolean agg_isNull141 = agg_isNull142;
/* 484 */         double agg_value148 = agg_value149;
/* 485 */         if (agg_isNull141) {
/* 486 */           boolean agg_isNull153 = agg_fastAggBuffer.isNullAt(3);
/* 487 */           double agg_value160 = agg_isNull153 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 488 */           if (!agg_isNull153) {
/* 489 */             agg_isNull141 = false;
/* 490 */             agg_value148 = agg_value160;
/* 491 */           }
/* 492 */         }
/* 493 */         boolean agg_isNull155 = true;
/* 494 */         double agg_value162 = -1.0;
/* 495 */
/* 496 */         boolean agg_isNull157 = agg_fastAggBuffer.isNullAt(4);
/* 497 */         double agg_value164 = agg_isNull157 ? -1.0 : (agg_fastAggBuffer.getDouble(4));
/* 498 */         boolean agg_isNull156 = agg_isNull157;
/* 499 */         double agg_value163 = agg_value164;
/* 500 */         if (agg_isNull156) {
/* 501 */           boolean agg_isNull158 = false;
/* 502 */           double agg_value165 = -1.0;
/* 503 */           if (!false) {
/* 504 */             agg_value165 = (double) 0;
/* 505 */           }
/* 506 */           if (!agg_isNull158) {
/* 507 */             agg_isNull156 = false;
/* 508 */             agg_value163 = agg_value165;
/* 509 */           }
/* 510 */         }
/* 511 */
/* 512 */         boolean agg_isNull160 = true;
/* 513 */         double agg_value167 = -1.0;
/* 514 */
/* 515 */         boolean agg_isNull161 = true;
/* 516 */         boolean agg_value168 = false;
/* 517 */
/* 518 */         if (!bhj_isNull4) {
/* 519 */           agg_isNull161 = false; // resultCode could change nullability.
/* 520 */           agg_value168 = bhj_value4.equals(((UTF8String) references[24]));
/* 521 */
/* 522 */         }
/* 523 */         if (!agg_isNull161 && agg_value168) {
/* 524 */           agg_isNull160 = inputadapter_isNull1;
/* 525 */           agg_value167 = inputadapter_value1;
/* 526 */         }
/* 527 */
/* 528 */         else {
/* 529 */           final double agg_value172 = -1.0;
/* 530 */           agg_isNull160 = true;
/* 531 */           agg_value167 = agg_value172;
/* 532 */         }
/* 533 */         if (!agg_isNull160) {
/* 534 */           agg_isNull155 = false; // resultCode could change nullability.
/* 535 */           agg_value162 = agg_value163 + agg_value167;
/* 536 */
/* 537 */         }
/* 538 */         boolean agg_isNull154 = agg_isNull155;
/* 539 */         double agg_value161 = agg_value162;
/* 540 */         if (agg_isNull154) {
/* 541 */           boolean agg_isNull166 = agg_fastAggBuffer.isNullAt(4);
/* 542 */           double agg_value173 = agg_isNull166 ? -1.0 : (agg_fastAggBuffer.getDouble(4));
/* 543 */           if (!agg_isNull166) {
/* 544 */             agg_isNull154 = false;
/* 545 */             agg_value161 = agg_value173;
/* 546 */           }
/* 547 */         }
/* 548 */         boolean agg_isNull168 = true;
/* 549 */         double agg_value175 = -1.0;
/* 550 */
/* 551 */         boolean agg_isNull170 = agg_fastAggBuffer.isNullAt(5);
/* 552 */         double agg_value177 = agg_isNull170 ? -1.0 : (agg_fastAggBuffer.getDouble(5));
/* 553 */         boolean agg_isNull169 = agg_isNull170;
/* 554 */         double agg_value176 = agg_value177;
/* 555 */         if (agg_isNull169) {
/* 556 */           boolean agg_isNull171 = false;
/* 557 */           double agg_value178 = -1.0;
/* 558 */           if (!false) {
/* 559 */             agg_value178 = (double) 0;
/* 560 */           }
/* 561 */           if (!agg_isNull171) {
/* 562 */             agg_isNull169 = false;
/* 563 */             agg_value176 = agg_value178;
/* 564 */           }
/* 565 */         }
/* 566 */
/* 567 */         boolean agg_isNull173 = true;
/* 568 */         double agg_value180 = -1.0;
/* 569 */
/* 570 */         boolean agg_isNull174 = true;
/* 571 */         boolean agg_value181 = false;
/* 572 */
/* 573 */         if (!bhj_isNull4) {
/* 574 */           agg_isNull174 = false; // resultCode could change nullability.
/* 575 */           agg_value181 = bhj_value4.equals(((UTF8String) references[25]));
/* 576 */
/* 577 */         }
/* 578 */         if (!agg_isNull174 && agg_value181) {
/* 579 */           agg_isNull173 = inputadapter_isNull1;
/* 580 */           agg_value180 = inputadapter_value1;
/* 581 */         }
/* 582 */
/* 583 */         else {
/* 584 */           final double agg_value185 = -1.0;
/* 585 */           agg_isNull173 = true;
/* 586 */           agg_value180 = agg_value185;
/* 587 */         }
/* 588 */         if (!agg_isNull173) {
/* 589 */           agg_isNull168 = false; // resultCode could change nullability.
/* 590 */           agg_value175 = agg_value176 + agg_value180;
/* 591 */
/* 592 */         }
/* 593 */         boolean agg_isNull167 = agg_isNull168;
/* 594 */         double agg_value174 = agg_value175;
/* 595 */         if (agg_isNull167) {
/* 596 */           boolean agg_isNull179 = agg_fastAggBuffer.isNullAt(5);
/* 597 */           double agg_value186 = agg_isNull179 ? -1.0 : (agg_fastAggBuffer.getDouble(5));
/* 598 */           if (!agg_isNull179) {
/* 599 */             agg_isNull167 = false;
/* 600 */             agg_value174 = agg_value186;
/* 601 */           }
/* 602 */         }
/* 603 */         boolean agg_isNull181 = true;
/* 604 */         double agg_value188 = -1.0;
/* 605 */
/* 606 */         boolean agg_isNull183 = agg_fastAggBuffer.isNullAt(6);
/* 607 */         double agg_value190 = agg_isNull183 ? -1.0 : (agg_fastAggBuffer.getDouble(6));
/* 608 */         boolean agg_isNull182 = agg_isNull183;
/* 609 */         double agg_value189 = agg_value190;
/* 610 */         if (agg_isNull182) {
/* 611 */           boolean agg_isNull184 = false;
/* 612 */           double agg_value191 = -1.0;
/* 613 */           if (!false) {
/* 614 */             agg_value191 = (double) 0;
/* 615 */           }
/* 616 */           if (!agg_isNull184) {
/* 617 */             agg_isNull182 = false;
/* 618 */             agg_value189 = agg_value191;
/* 619 */           }
/* 620 */         }
/* 621 */
/* 622 */         boolean agg_isNull186 = true;
/* 623 */         double agg_value193 = -1.0;
/* 624 */
/* 625 */         boolean agg_isNull187 = true;
/* 626 */         boolean agg_value194 = false;
/* 627 */
/* 628 */         if (!bhj_isNull4) {
/* 629 */           agg_isNull187 = false; // resultCode could change nullability.
/* 630 */           agg_value194 = bhj_value4.equals(((UTF8String) references[26]));
/* 631 */
/* 632 */         }
/* 633 */         if (!agg_isNull187 && agg_value194) {
/* 634 */           agg_isNull186 = inputadapter_isNull1;
/* 635 */           agg_value193 = inputadapter_value1;
/* 636 */         }
/* 637 */
/* 638 */         else {
/* 639 */           final double agg_value198 = -1.0;
/* 640 */           agg_isNull186 = true;
/* 641 */           agg_value193 = agg_value198;
/* 642 */         }
/* 643 */         if (!agg_isNull186) {
/* 644 */           agg_isNull181 = false; // resultCode could change nullability.
/* 645 */           agg_value188 = agg_value189 + agg_value193;
/* 646 */
/* 647 */         }
/* 648 */         boolean agg_isNull180 = agg_isNull181;
/* 649 */         double agg_value187 = agg_value188;
/* 650 */         if (agg_isNull180) {
/* 651 */           boolean agg_isNull192 = agg_fastAggBuffer.isNullAt(6);
/* 652 */           double agg_value199 = agg_isNull192 ? -1.0 : (agg_fastAggBuffer.getDouble(6));
/* 653 */           if (!agg_isNull192) {
/* 654 */             agg_isNull180 = false;
/* 655 */             agg_value187 = agg_value199;
/* 656 */           }
/* 657 */         }
/* 658 */         // update fast row
/* 659 */         if (!agg_isNull102) {
/* 660 */           agg_fastAggBuffer.setDouble(0, agg_value109);
/* 661 */         } else {
/* 662 */           agg_fastAggBuffer.setNullAt(0);
/* 663 */         }
/* 664 */
/* 665 */         if (!agg_isNull115) {
/* 666 */           agg_fastAggBuffer.setDouble(1, agg_value122);
/* 667 */         } else {
/* 668 */           agg_fastAggBuffer.setNullAt(1);
/* 669 */         }
/* 670 */
/* 671 */         if (!agg_isNull128) {
/* 672 */           agg_fastAggBuffer.setDouble(2, agg_value135);
/* 673 */         } else {
/* 674 */           agg_fastAggBuffer.setNullAt(2);
/* 675 */         }
/* 676 */
/* 677 */         if (!agg_isNull141) {
/* 678 */           agg_fastAggBuffer.setDouble(3, agg_value148);
/* 679 */         } else {
/* 680 */           agg_fastAggBuffer.setNullAt(3);
/* 681 */         }
/* 682 */
/* 683 */         if (!agg_isNull154) {
/* 684 */           agg_fastAggBuffer.setDouble(4, agg_value161);
/* 685 */         } else {
/* 686 */           agg_fastAggBuffer.setNullAt(4);
/* 687 */         }
/* 688 */
/* 689 */         if (!agg_isNull167) {
/* 690 */           agg_fastAggBuffer.setDouble(5, agg_value174);
/* 691 */         } else {
/* 692 */           agg_fastAggBuffer.setNullAt(5);
/* 693 */         }
/* 694 */
/* 695 */         if (!agg_isNull180) {
/* 696 */           agg_fastAggBuffer.setDouble(6, agg_value187);
/* 697 */         } else {
/* 698 */           agg_fastAggBuffer.setNullAt(6);
/* 699 */         }
/* 700 */
/* 701 */       } else {
/* 702 */         // update unsafe row
/* 703 */
/* 704 */         // common sub-expressions
/* 705 */
/* 706 */         // evaluate aggregate function
/* 707 */         boolean agg_isNull12 = true;
/* 708 */         double agg_value19 = -1.0;
/* 709 */
/* 710 */         boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 711 */         double agg_value21 = agg_isNull14 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 712 */         boolean agg_isNull13 = agg_isNull14;
/* 713 */         double agg_value20 = agg_value21;
/* 714 */         if (agg_isNull13) {
/* 715 */           boolean agg_isNull15 = false;
/* 716 */           double agg_value22 = -1.0;
/* 717 */           if (!false) {
/* 718 */             agg_value22 = (double) 0;
/* 719 */           }
/* 720 */           if (!agg_isNull15) {
/* 721 */             agg_isNull13 = false;
/* 722 */             agg_value20 = agg_value22;
/* 723 */           }
/* 724 */         }
/* 725 */
/* 726 */         boolean agg_isNull17 = true;
/* 727 */         double agg_value24 = -1.0;
/* 728 */
/* 729 */         boolean agg_isNull18 = true;
/* 730 */         boolean agg_value25 = false;
/* 731 */
/* 732 */         if (!bhj_isNull4) {
/* 733 */           agg_isNull18 = false; // resultCode could change nullability.
/* 734 */           agg_value25 = bhj_value4.equals(((UTF8String) references[13]));
/* 735 */
/* 736 */         }
/* 737 */         if (!agg_isNull18 && agg_value25) {
/* 738 */           agg_isNull17 = inputadapter_isNull1;
/* 739 */           agg_value24 = inputadapter_value1;
/* 740 */         }
/* 741 */
/* 742 */         else {
/* 743 */           final double agg_value29 = -1.0;
/* 744 */           agg_isNull17 = true;
/* 745 */           agg_value24 = agg_value29;
/* 746 */         }
/* 747 */         if (!agg_isNull17) {
/* 748 */           agg_isNull12 = false; // resultCode could change nullability.
/* 749 */           agg_value19 = agg_value20 + agg_value24;
/* 750 */
/* 751 */         }
/* 752 */         boolean agg_isNull11 = agg_isNull12;
/* 753 */         double agg_value18 = agg_value19;
/* 754 */         if (agg_isNull11) {
/* 755 */           boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 756 */           double agg_value30 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 757 */           if (!agg_isNull23) {
/* 758 */             agg_isNull11 = false;
/* 759 */             agg_value18 = agg_value30;
/* 760 */           }
/* 761 */         }
/* 762 */         boolean agg_isNull25 = true;
/* 763 */         double agg_value32 = -1.0;
/* 764 */
/* 765 */         boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 766 */         double agg_value34 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 767 */         boolean agg_isNull26 = agg_isNull27;
/* 768 */         double agg_value33 = agg_value34;
/* 769 */         if (agg_isNull26) {
/* 770 */           boolean agg_isNull28 = false;
/* 771 */           double agg_value35 = -1.0;
/* 772 */           if (!false) {
/* 773 */             agg_value35 = (double) 0;
/* 774 */           }
/* 775 */           if (!agg_isNull28) {
/* 776 */             agg_isNull26 = false;
/* 777 */             agg_value33 = agg_value35;
/* 778 */           }
/* 779 */         }
/* 780 */
/* 781 */         boolean agg_isNull30 = true;
/* 782 */         double agg_value37 = -1.0;
/* 783 */
/* 784 */         boolean agg_isNull31 = true;
/* 785 */         boolean agg_value38 = false;
/* 786 */
/* 787 */         if (!bhj_isNull4) {
/* 788 */           agg_isNull31 = false; // resultCode could change nullability.
/* 789 */           agg_value38 = bhj_value4.equals(((UTF8String) references[14]));
/* 790 */
/* 791 */         }
/* 792 */         if (!agg_isNull31 && agg_value38) {
/* 793 */           agg_isNull30 = inputadapter_isNull1;
/* 794 */           agg_value37 = inputadapter_value1;
/* 795 */         }
/* 796 */
/* 797 */         else {
/* 798 */           final double agg_value42 = -1.0;
/* 799 */           agg_isNull30 = true;
/* 800 */           agg_value37 = agg_value42;
/* 801 */         }
/* 802 */         if (!agg_isNull30) {
/* 803 */           agg_isNull25 = false; // resultCode could change nullability.
/* 804 */           agg_value32 = agg_value33 + agg_value37;
/* 805 */
/* 806 */         }
/* 807 */         boolean agg_isNull24 = agg_isNull25;
/* 808 */         double agg_value31 = agg_value32;
/* 809 */         if (agg_isNull24) {
/* 810 */           boolean agg_isNull36 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 811 */           double agg_value43 = agg_isNull36 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 812 */           if (!agg_isNull36) {
/* 813 */             agg_isNull24 = false;
/* 814 */             agg_value31 = agg_value43;
/* 815 */           }
/* 816 */         }
/* 817 */         boolean agg_isNull38 = true;
/* 818 */         double agg_value45 = -1.0;
/* 819 */
/* 820 */         boolean agg_isNull40 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 821 */         double agg_value47 = agg_isNull40 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 822 */         boolean agg_isNull39 = agg_isNull40;
/* 823 */         double agg_value46 = agg_value47;
/* 824 */         if (agg_isNull39) {
/* 825 */           boolean agg_isNull41 = false;
/* 826 */           double agg_value48 = -1.0;
/* 827 */           if (!false) {
/* 828 */             agg_value48 = (double) 0;
/* 829 */           }
/* 830 */           if (!agg_isNull41) {
/* 831 */             agg_isNull39 = false;
/* 832 */             agg_value46 = agg_value48;
/* 833 */           }
/* 834 */         }
/* 835 */
/* 836 */         boolean agg_isNull43 = true;
/* 837 */         double agg_value50 = -1.0;
/* 838 */
/* 839 */         boolean agg_isNull44 = true;
/* 840 */         boolean agg_value51 = false;
/* 841 */
/* 842 */         if (!bhj_isNull4) {
/* 843 */           agg_isNull44 = false; // resultCode could change nullability.
/* 844 */           agg_value51 = bhj_value4.equals(((UTF8String) references[15]));
/* 845 */
/* 846 */         }
/* 847 */         if (!agg_isNull44 && agg_value51) {
/* 848 */           agg_isNull43 = inputadapter_isNull1;
/* 849 */           agg_value50 = inputadapter_value1;
/* 850 */         }
/* 851 */
/* 852 */         else {
/* 853 */           final double agg_value55 = -1.0;
/* 854 */           agg_isNull43 = true;
/* 855 */           agg_value50 = agg_value55;
/* 856 */         }
/* 857 */         if (!agg_isNull43) {
/* 858 */           agg_isNull38 = false; // resultCode could change nullability.
/* 859 */           agg_value45 = agg_value46 + agg_value50;
/* 860 */
/* 861 */         }
/* 862 */         boolean agg_isNull37 = agg_isNull38;
/* 863 */         double agg_value44 = agg_value45;
/* 864 */         if (agg_isNull37) {
/* 865 */           boolean agg_isNull49 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 866 */           double agg_value56 = agg_isNull49 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 867 */           if (!agg_isNull49) {
/* 868 */             agg_isNull37 = false;
/* 869 */             agg_value44 = agg_value56;
/* 870 */           }
/* 871 */         }
/* 872 */         boolean agg_isNull51 = true;
/* 873 */         double agg_value58 = -1.0;
/* 874 */
/* 875 */         boolean agg_isNull53 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 876 */         double agg_value60 = agg_isNull53 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 877 */         boolean agg_isNull52 = agg_isNull53;
/* 878 */         double agg_value59 = agg_value60;
/* 879 */         if (agg_isNull52) {
/* 880 */           boolean agg_isNull54 = false;
/* 881 */           double agg_value61 = -1.0;
/* 882 */           if (!false) {
/* 883 */             agg_value61 = (double) 0;
/* 884 */           }
/* 885 */           if (!agg_isNull54) {
/* 886 */             agg_isNull52 = false;
/* 887 */             agg_value59 = agg_value61;
/* 888 */           }
/* 889 */         }
/* 890 */
/* 891 */         boolean agg_isNull56 = true;
/* 892 */         double agg_value63 = -1.0;
/* 893 */
/* 894 */         boolean agg_isNull57 = true;
/* 895 */         boolean agg_value64 = false;
/* 896 */
/* 897 */         if (!bhj_isNull4) {
/* 898 */           agg_isNull57 = false; // resultCode could change nullability.
/* 899 */           agg_value64 = bhj_value4.equals(((UTF8String) references[16]));
/* 900 */
/* 901 */         }
/* 902 */         if (!agg_isNull57 && agg_value64) {
/* 903 */           agg_isNull56 = inputadapter_isNull1;
/* 904 */           agg_value63 = inputadapter_value1;
/* 905 */         }
/* 906 */
/* 907 */         else {
/* 908 */           final double agg_value68 = -1.0;
/* 909 */           agg_isNull56 = true;
/* 910 */           agg_value63 = agg_value68;
/* 911 */         }
/* 912 */         if (!agg_isNull56) {
/* 913 */           agg_isNull51 = false; // resultCode could change nullability.
/* 914 */           agg_value58 = agg_value59 + agg_value63;
/* 915 */
/* 916 */         }
/* 917 */         boolean agg_isNull50 = agg_isNull51;
/* 918 */         double agg_value57 = agg_value58;
/* 919 */         if (agg_isNull50) {
/* 920 */           boolean agg_isNull62 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 921 */           double agg_value69 = agg_isNull62 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 922 */           if (!agg_isNull62) {
/* 923 */             agg_isNull50 = false;
/* 924 */             agg_value57 = agg_value69;
/* 925 */           }
/* 926 */         }
/* 927 */         boolean agg_isNull64 = true;
/* 928 */         double agg_value71 = -1.0;
/* 929 */
/* 930 */         boolean agg_isNull66 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 931 */         double agg_value73 = agg_isNull66 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 932 */         boolean agg_isNull65 = agg_isNull66;
/* 933 */         double agg_value72 = agg_value73;
/* 934 */         if (agg_isNull65) {
/* 935 */           boolean agg_isNull67 = false;
/* 936 */           double agg_value74 = -1.0;
/* 937 */           if (!false) {
/* 938 */             agg_value74 = (double) 0;
/* 939 */           }
/* 940 */           if (!agg_isNull67) {
/* 941 */             agg_isNull65 = false;
/* 942 */             agg_value72 = agg_value74;
/* 943 */           }
/* 944 */         }
/* 945 */
/* 946 */         boolean agg_isNull69 = true;
/* 947 */         double agg_value76 = -1.0;
/* 948 */
/* 949 */         boolean agg_isNull70 = true;
/* 950 */         boolean agg_value77 = false;
/* 951 */
/* 952 */         if (!bhj_isNull4) {
/* 953 */           agg_isNull70 = false; // resultCode could change nullability.
/* 954 */           agg_value77 = bhj_value4.equals(((UTF8String) references[17]));
/* 955 */
/* 956 */         }
/* 957 */         if (!agg_isNull70 && agg_value77) {
/* 958 */           agg_isNull69 = inputadapter_isNull1;
/* 959 */           agg_value76 = inputadapter_value1;
/* 960 */         }
/* 961 */
/* 962 */         else {
/* 963 */           final double agg_value81 = -1.0;
/* 964 */           agg_isNull69 = true;
/* 965 */           agg_value76 = agg_value81;
/* 966 */         }
/* 967 */         if (!agg_isNull69) {
/* 968 */           agg_isNull64 = false; // resultCode could change nullability.
/* 969 */           agg_value71 = agg_value72 + agg_value76;
/* 970 */
/* 971 */         }
/* 972 */         boolean agg_isNull63 = agg_isNull64;
/* 973 */         double agg_value70 = agg_value71;
/* 974 */         if (agg_isNull63) {
/* 975 */           boolean agg_isNull75 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 976 */           double agg_value82 = agg_isNull75 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 977 */           if (!agg_isNull75) {
/* 978 */             agg_isNull63 = false;
/* 979 */             agg_value70 = agg_value82;
/* 980 */           }
/* 981 */         }
/* 982 */         boolean agg_isNull77 = true;
/* 983 */         double agg_value84 = -1.0;
/* 984 */
/* 985 */         boolean agg_isNull79 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 986 */         double agg_value86 = agg_isNull79 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 987 */         boolean agg_isNull78 = agg_isNull79;
/* 988 */         double agg_value85 = agg_value86;
/* 989 */         if (agg_isNull78) {
/* 990 */           boolean agg_isNull80 = false;
/* 991 */           double agg_value87 = -1.0;
/* 992 */           if (!false) {
/* 993 */             agg_value87 = (double) 0;
/* 994 */           }
/* 995 */           if (!agg_isNull80) {
/* 996 */             agg_isNull78 = false;
/* 997 */             agg_value85 = agg_value87;
/* 998 */           }
/* 999 */         }
/* 1000 */
/* 1001 */         boolean agg_isNull82 = true;
/* 1002 */         double agg_value89 = -1.0;
/* 1003 */
/* 1004 */         boolean agg_isNull83 = true;
/* 1005 */         boolean agg_value90 = false;
/* 1006 */
/* 1007 */         if (!bhj_isNull4) {
/* 1008 */           agg_isNull83 = false; // resultCode could change nullability.
/* 1009 */           agg_value90 = bhj_value4.equals(((UTF8String) references[18]));
/* 1010 */
/* 1011 */         }
/* 1012 */         if (!agg_isNull83 && agg_value90) {
/* 1013 */           agg_isNull82 = inputadapter_isNull1;
/* 1014 */           agg_value89 = inputadapter_value1;
/* 1015 */         }
/* 1016 */
/* 1017 */         else {
/* 1018 */           final double agg_value94 = -1.0;
/* 1019 */           agg_isNull82 = true;
/* 1020 */           agg_value89 = agg_value94;
/* 1021 */         }
/* 1022 */         if (!agg_isNull82) {
/* 1023 */           agg_isNull77 = false; // resultCode could change nullability.
/* 1024 */           agg_value84 = agg_value85 + agg_value89;
/* 1025 */
/* 1026 */         }
/* 1027 */         boolean agg_isNull76 = agg_isNull77;
/* 1028 */         double agg_value83 = agg_value84;
/* 1029 */         if (agg_isNull76) {
/* 1030 */           boolean agg_isNull88 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 1031 */           double agg_value95 = agg_isNull88 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 1032 */           if (!agg_isNull88) {
/* 1033 */             agg_isNull76 = false;
/* 1034 */             agg_value83 = agg_value95;
/* 1035 */           }
/* 1036 */         }
/* 1037 */         boolean agg_isNull90 = true;
/* 1038 */         double agg_value97 = -1.0;
/* 1039 */
/* 1040 */         boolean agg_isNull92 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 1041 */         double agg_value99 = agg_isNull92 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 1042 */         boolean agg_isNull91 = agg_isNull92;
/* 1043 */         double agg_value98 = agg_value99;
/* 1044 */         if (agg_isNull91) {
/* 1045 */           boolean agg_isNull93 = false;
/* 1046 */           double agg_value100 = -1.0;
/* 1047 */           if (!false) {
/* 1048 */             agg_value100 = (double) 0;
/* 1049 */           }
/* 1050 */           if (!agg_isNull93) {
/* 1051 */             agg_isNull91 = false;
/* 1052 */             agg_value98 = agg_value100;
/* 1053 */           }
/* 1054 */         }
/* 1055 */
/* 1056 */         boolean agg_isNull95 = true;
/* 1057 */         double agg_value102 = -1.0;
/* 1058 */
/* 1059 */         boolean agg_isNull96 = true;
/* 1060 */         boolean agg_value103 = false;
/* 1061 */
/* 1062 */         if (!bhj_isNull4) {
/* 1063 */           agg_isNull96 = false; // resultCode could change nullability.
/* 1064 */           agg_value103 = bhj_value4.equals(((UTF8String) references[19]));
/* 1065 */
/* 1066 */         }
/* 1067 */         if (!agg_isNull96 && agg_value103) {
/* 1068 */           agg_isNull95 = inputadapter_isNull1;
/* 1069 */           agg_value102 = inputadapter_value1;
/* 1070 */         }
/* 1071 */
/* 1072 */         else {
/* 1073 */           final double agg_value107 = -1.0;
/* 1074 */           agg_isNull95 = true;
/* 1075 */           agg_value102 = agg_value107;
/* 1076 */         }
/* 1077 */         if (!agg_isNull95) {
/* 1078 */           agg_isNull90 = false; // resultCode could change nullability.
/* 1079 */           agg_value97 = agg_value98 + agg_value102;
/* 1080 */
/* 1081 */         }
/* 1082 */         boolean agg_isNull89 = agg_isNull90;
/* 1083 */         double agg_value96 = agg_value97;
/* 1084 */         if (agg_isNull89) {
/* 1085 */           boolean agg_isNull101 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 1086 */           double agg_value108 = agg_isNull101 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 1087 */           if (!agg_isNull101) {
/* 1088 */             agg_isNull89 = false;
/* 1089 */             agg_value96 = agg_value108;
/* 1090 */           }
/* 1091 */         }
/* 1092 */         // update unsafe row buffer
/* 1093 */         if (!agg_isNull11) {
/* 1094 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value18);
/* 1095 */         } else {
/* 1096 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 1097 */         }
/* 1098 */
/* 1099 */         if (!agg_isNull24) {
/* 1100 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value31);
/* 1101 */         } else {
/* 1102 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 1103 */         }
/* 1104 */
/* 1105 */         if (!agg_isNull37) {
/* 1106 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value44);
/* 1107 */         } else {
/* 1108 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 1109 */         }
/* 1110 */
/* 1111 */         if (!agg_isNull50) {
/* 1112 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value57);
/* 1113 */         } else {
/* 1114 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 1115 */         }
/* 1116 */
/* 1117 */         if (!agg_isNull63) {
/* 1118 */           agg_unsafeRowAggBuffer.setDouble(4, agg_value70);
/* 1119 */         } else {
/* 1120 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 1121 */         }
/* 1122 */
/* 1123 */         if (!agg_isNull76) {
/* 1124 */           agg_unsafeRowAggBuffer.setDouble(5, agg_value83);
/* 1125 */         } else {
/* 1126 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 1127 */         }
/* 1128 */
/* 1129 */         if (!agg_isNull89) {
/* 1130 */           agg_unsafeRowAggBuffer.setDouble(6, agg_value96);
/* 1131 */         } else {
/* 1132 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 1133 */         }
/* 1134 */
/* 1135 */       }
/* 1136 */       if (shouldStop()) return;
/* 1137 */     }
/* 1138 */
/* 1139 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 1140 */
/* 1141 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1142 */   }
/* 1143 */
/* 1144 */   private void wholestagecodegen_init_1() {
/* 1145 */     project_result = new UnsafeRow(3);
/* 1146 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 1147 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 1148 */     agg_result1 = new UnsafeRow(1);
/* 1149 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 1150 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 1151 */
/* 1152 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 1153 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[27];
/* 1154 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[28];
/* 1155 */
/* 1156 */   }
/* 1157 */
/* 1158 */   protected void processNext() throws java.io.IOException {
/* 1159 */     if (!agg_initAgg) {
/* 1160 */       agg_initAgg = true;
/* 1161 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1162 */       agg_doAggregateWithKeys();
/* 1163 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1164 */     }
/* 1165 */
/* 1166 */     // output the result
/* 1167 */
/* 1168 */     while (agg_fastHashMapIter.next()) {
/* 1169 */       wholestagecodegen_numOutputRows.add(1);
/* 1170 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 1171 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 1172 */
/* 1173 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1174 */
/* 1175 */       append(agg_resultRow);
/* 1176 */
/* 1177 */       if (shouldStop()) return;
/* 1178 */     }
/* 1179 */     agg_fastHashMap.close();
/* 1180 */
/* 1181 */     while (agg_mapIter.next()) {
/* 1182 */       wholestagecodegen_numOutputRows.add(1);
/* 1183 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1184 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1185 */
/* 1186 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1187 */
/* 1188 */       append(agg_resultRow);
/* 1189 */
/* 1190 */       if (shouldStop()) return;
/* 1191 */     }
/* 1192 */
/* 1193 */     agg_mapIter.close();
/* 1194 */     if (agg_sorter == null) {
/* 1195 */       agg_hashMap.free();
/* 1196 */     }
/* 1197 */   }
/* 1198 */ }
