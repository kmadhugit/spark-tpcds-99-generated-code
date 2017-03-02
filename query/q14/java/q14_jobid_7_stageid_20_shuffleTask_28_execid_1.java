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
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 016 */   private agg_FastHashMap agg_fastHashMap;
/* 017 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 018 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 019 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 020 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 023 */   private scala.collection.Iterator inputadapter_input;
/* 024 */   private UnsafeRow project_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 027 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 028 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 030 */   private UnsafeRow bhj_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 033 */   private UnsafeRow project_result1;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 036 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 037 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 039 */   private UnsafeRow bhj_result1;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 042 */   private UnsafeRow project_result2;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 045 */   private UnsafeRow agg_result3;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 048 */   private int agg_value12;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 050 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 051 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 052 */
/* 053 */   public GeneratedIterator(Object[] references) {
/* 054 */     this.references = references;
/* 055 */   }
/* 056 */
/* 057 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 058 */     partitionIndex = index;
/* 059 */     this.inputs = inputs;
/* 060 */     wholestagecodegen_init_0();
/* 061 */     wholestagecodegen_init_1();
/* 062 */     wholestagecodegen_init_2();
/* 063 */
/* 064 */   }
/* 065 */
/* 066 */   private void wholestagecodegen_init_0() {
/* 067 */     agg_initAgg = false;
/* 068 */
/* 069 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 070 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 071 */
/* 072 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 073 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 074 */     inputadapter_input = inputs[0];
/* 075 */     project_result = new UnsafeRow(4);
/* 076 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 077 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 078 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 079 */
/* 080 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 081 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 082 */
/* 083 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 084 */
/* 085 */   }
/* 086 */
/* 087 */   public class agg_FastHashMap {
/* 088 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 089 */     private int[] buckets;
/* 090 */     private int capacity = 1 << 16;
/* 091 */     private double loadFactor = 0.5;
/* 092 */     private int numBuckets = (int) (capacity / loadFactor);
/* 093 */     private int maxSteps = 2;
/* 094 */     private int numRows = 0;
/* 095 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("i_brand_id", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 096 */     .add("i_class_id", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 097 */     .add("i_category_id", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 098 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 099 */     .add("count", org.apache.spark.sql.types.DataTypes.LongType)
/* 100 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 101 */     private Object emptyVBase;
/* 102 */     private long emptyVOff;
/* 103 */     private int emptyVLen;
/* 104 */     private boolean isBatchFull = false;
/* 105 */
/* 106 */     public agg_FastHashMap(
/* 107 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 108 */       InternalRow emptyAggregationBuffer) {
/* 109 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 110 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 111 */
/* 112 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 113 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 114 */
/* 115 */       emptyVBase = emptyBuffer;
/* 116 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 117 */       emptyVLen = emptyBuffer.length;
/* 118 */
/* 119 */       buckets = new int[numBuckets];
/* 120 */       java.util.Arrays.fill(buckets, -1);
/* 121 */     }
/* 122 */
/* 123 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key, int agg_key1, int agg_key2) {
/* 124 */       long h = hash(agg_key, agg_key1, agg_key2);
/* 125 */       int step = 0;
/* 126 */       int idx = (int) h & (numBuckets - 1);
/* 127 */       while (step < maxSteps) {
/* 128 */         // Return bucket index if it's either an empty slot or already contains the key
/* 129 */         if (buckets[idx] == -1) {
/* 130 */           if (numRows < capacity && !isBatchFull) {
/* 131 */             // creating the unsafe for new entry
/* 132 */             UnsafeRow agg_result = new UnsafeRow(3);
/* 133 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 134 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 135 */               0);
/* 136 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 137 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 138 */               agg_holder,
/* 139 */               3);
/* 140 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 141 */             agg_rowWriter.zeroOutNullBytes();
/* 142 */             agg_rowWriter.write(0, agg_key);
/* 143 */             agg_rowWriter.write(1, agg_key1);
/* 144 */             agg_rowWriter.write(2, agg_key2);
/* 145 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 146 */             Object kbase = agg_result.getBaseObject();
/* 147 */             long koff = agg_result.getBaseOffset();
/* 148 */             int klen = agg_result.getSizeInBytes();
/* 149 */
/* 150 */             UnsafeRow vRow
/* 151 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 152 */             if (vRow == null) {
/* 153 */               isBatchFull = true;
/* 154 */             } else {
/* 155 */               buckets[idx] = numRows++;
/* 156 */             }
/* 157 */             return vRow;
/* 158 */           } else {
/* 159 */             // No more space
/* 160 */             return null;
/* 161 */           }
/* 162 */         } else if (equals(idx, agg_key, agg_key1, agg_key2)) {
/* 163 */           return batch.getValueRow(buckets[idx]);
/* 164 */         }
/* 165 */         idx = (idx + 1) & (numBuckets - 1);
/* 166 */         step++;
/* 167 */       }
/* 168 */       // Didn't find it
/* 169 */       return null;
/* 170 */     }
/* 171 */
/* 172 */     private boolean equals(int idx, int agg_key, int agg_key1, int agg_key2) {
/* 173 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 174 */       return (row.getInt(0) == agg_key) && (row.getInt(1) == agg_key1) && (row.getInt(2) == agg_key2);
/* 175 */     }
/* 176 */
/* 177 */     private long hash(int agg_key, int agg_key1, int agg_key2) {
/* 178 */       long agg_hash = 0;
/* 179 */
/* 180 */       int agg_result = agg_key;
/* 181 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 182 */
/* 183 */       int agg_result1 = agg_key1;
/* 184 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 185 */
/* 186 */       int agg_result2 = agg_key2;
/* 187 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 188 */
/* 189 */       return agg_hash;
/* 190 */     }
/* 191 */
/* 192 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 193 */       return batch.rowIterator();
/* 194 */     }
/* 195 */
/* 196 */     public void close() {
/* 197 */       batch.close();
/* 198 */     }
/* 199 */
/* 200 */   }
/* 201 */
/* 202 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 203 */     agg_hashMap = agg_plan.createHashMap();
/* 204 */
/* 205 */     while (inputadapter_input.hasNext()) {
/* 206 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 207 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 208 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 209 */
/* 210 */       // generate join key for stream side
/* 211 */
/* 212 */       boolean bhj_isNull = inputadapter_isNull1;
/* 213 */       long bhj_value = -1L;
/* 214 */       if (!inputadapter_isNull1) {
/* 215 */         bhj_value = (long) inputadapter_value1;
/* 216 */       }
/* 217 */       // find matches from HashedRelation
/* 218 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 219 */       if (bhj_matched == null) continue;
/* 220 */
/* 221 */       bhj_numOutputRows.add(1);
/* 222 */
/* 223 */       boolean inputadapter_isNull22 = inputadapter_row.isNullAt(22);
/* 224 */       int inputadapter_value22 = inputadapter_isNull22 ? -1 : (inputadapter_row.getInt(22));
/* 225 */
/* 226 */       // generate join key for stream side
/* 227 */
/* 228 */       boolean bhj_isNull14 = inputadapter_isNull22;
/* 229 */       long bhj_value14 = -1L;
/* 230 */       if (!inputadapter_isNull22) {
/* 231 */         bhj_value14 = (long) inputadapter_value22;
/* 232 */       }
/* 233 */       // find matches from HashedRelation
/* 234 */       UnsafeRow bhj_matched1 = bhj_isNull14 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value14);
/* 235 */       if (bhj_matched1 == null) continue;
/* 236 */
/* 237 */       bhj_numOutputRows1.add(1);
/* 238 */
/* 239 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 240 */       int inputadapter_value9 = inputadapter_isNull9 ? -1 : (inputadapter_row.getInt(9));
/* 241 */       boolean inputadapter_isNull11 = inputadapter_row.isNullAt(11);
/* 242 */       double inputadapter_value11 = inputadapter_isNull11 ? -1.0 : (inputadapter_row.getDouble(11));
/* 243 */       boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 244 */       int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 245 */       boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 246 */       int bhj_value4 = bhj_isNull4 ? -1 : (bhj_matched.getInt(2));
/* 247 */       boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 248 */       int bhj_value5 = bhj_isNull5 ? -1 : (bhj_matched.getInt(3));
/* 249 */
/* 250 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 251 */
/* 252 */       UnsafeRow agg_fastAggBuffer = null;
/* 253 */
/* 254 */       if (true) {
/* 255 */         if (!bhj_isNull3 && !bhj_isNull4 && !bhj_isNull5) {
/* 256 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 257 */             bhj_value3, bhj_value4, bhj_value5);
/* 258 */         }
/* 259 */       }
/* 260 */
/* 261 */       if (agg_fastAggBuffer == null) {
/* 262 */         // generate grouping key
/* 263 */         agg_rowWriter.zeroOutNullBytes();
/* 264 */
/* 265 */         if (bhj_isNull3) {
/* 266 */           agg_rowWriter.setNullAt(0);
/* 267 */         } else {
/* 268 */           agg_rowWriter.write(0, bhj_value3);
/* 269 */         }
/* 270 */
/* 271 */         if (bhj_isNull4) {
/* 272 */           agg_rowWriter.setNullAt(1);
/* 273 */         } else {
/* 274 */           agg_rowWriter.write(1, bhj_value4);
/* 275 */         }
/* 276 */
/* 277 */         if (bhj_isNull5) {
/* 278 */           agg_rowWriter.setNullAt(2);
/* 279 */         } else {
/* 280 */           agg_rowWriter.write(2, bhj_value5);
/* 281 */         }
/* 282 */         agg_value12 = 42;
/* 283 */
/* 284 */         if (!bhj_isNull3) {
/* 285 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value3, agg_value12);
/* 286 */         }
/* 287 */
/* 288 */         if (!bhj_isNull4) {
/* 289 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value4, agg_value12);
/* 290 */         }
/* 291 */
/* 292 */         if (!bhj_isNull5) {
/* 293 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value5, agg_value12);
/* 294 */         }
/* 295 */         if (true) {
/* 296 */           // try to get the buffer from hash map
/* 297 */           agg_unsafeRowAggBuffer =
/* 298 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value12);
/* 299 */         }
/* 300 */         if (agg_unsafeRowAggBuffer == null) {
/* 301 */           if (agg_sorter == null) {
/* 302 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 303 */           } else {
/* 304 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 305 */           }
/* 306 */
/* 307 */           // the hash map had be spilled, it should have enough memory now,
/* 308 */           // try  to allocate buffer again.
/* 309 */           agg_unsafeRowAggBuffer =
/* 310 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value12);
/* 311 */           if (agg_unsafeRowAggBuffer == null) {
/* 312 */             // failed to allocate the first page
/* 313 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 314 */           }
/* 315 */         }
/* 316 */       }
/* 317 */
/* 318 */       if (agg_fastAggBuffer != null) {
/* 319 */         // update fast row
/* 320 */
/* 321 */         // common sub-expressions
/* 322 */         boolean agg_isNull33 = false;
/* 323 */         double agg_value36 = -1.0;
/* 324 */         if (!false) {
/* 325 */           agg_value36 = (double) 0;
/* 326 */         }
/* 327 */         boolean agg_isNull36 = true;
/* 328 */         double agg_value39 = -1.0;
/* 329 */
/* 330 */         boolean agg_isNull37 = inputadapter_isNull9;
/* 331 */         double agg_value40 = -1.0;
/* 332 */         if (!inputadapter_isNull9) {
/* 333 */           agg_value40 = (double) inputadapter_value9;
/* 334 */         }
/* 335 */         if (!agg_isNull37) {
/* 336 */           if (!inputadapter_isNull11) {
/* 337 */             agg_isNull36 = false; // resultCode could change nullability.
/* 338 */             agg_value39 = agg_value40 * inputadapter_value11;
/* 339 */
/* 340 */           }
/* 341 */
/* 342 */         }
/* 343 */         boolean agg_isNull35 = agg_isNull36;
/* 344 */         double agg_value38 = -1.0;
/* 345 */         if (!agg_isNull36) {
/* 346 */           agg_value38 = agg_value39;
/* 347 */         }
/* 348 */         // evaluate aggregate function
/* 349 */         boolean agg_isNull41 = true;
/* 350 */         double agg_value44 = -1.0;
/* 351 */
/* 352 */         boolean agg_isNull43 = agg_fastAggBuffer.isNullAt(0);
/* 353 */         double agg_value46 = agg_isNull43 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 354 */         boolean agg_isNull42 = agg_isNull43;
/* 355 */         double agg_value45 = agg_value46;
/* 356 */         if (agg_isNull42) {
/* 357 */           if (!agg_isNull33) {
/* 358 */             agg_isNull42 = false;
/* 359 */             agg_value45 = agg_value36;
/* 360 */           }
/* 361 */         }
/* 362 */
/* 363 */         if (!agg_isNull35) {
/* 364 */           agg_isNull41 = false; // resultCode could change nullability.
/* 365 */           agg_value44 = agg_value45 + agg_value38;
/* 366 */
/* 367 */         }
/* 368 */         boolean agg_isNull40 = agg_isNull41;
/* 369 */         double agg_value43 = agg_value44;
/* 370 */         if (agg_isNull40) {
/* 371 */           boolean agg_isNull44 = agg_fastAggBuffer.isNullAt(0);
/* 372 */           double agg_value47 = agg_isNull44 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 373 */           if (!agg_isNull44) {
/* 374 */             agg_isNull40 = false;
/* 375 */             agg_value43 = agg_value47;
/* 376 */           }
/* 377 */         }
/* 378 */         boolean agg_isNull45 = false;
/* 379 */
/* 380 */         long agg_value49 = agg_fastAggBuffer.getLong(1);
/* 381 */
/* 382 */         long agg_value48 = -1L;
/* 383 */         agg_value48 = agg_value49 + 1L;
/* 384 */         boolean agg_isNull49 = true;
/* 385 */         double agg_value52 = -1.0;
/* 386 */
/* 387 */         boolean agg_isNull51 = agg_fastAggBuffer.isNullAt(2);
/* 388 */         double agg_value54 = agg_isNull51 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 389 */         boolean agg_isNull50 = agg_isNull51;
/* 390 */         double agg_value53 = agg_value54;
/* 391 */         if (agg_isNull50) {
/* 392 */           if (!agg_isNull33) {
/* 393 */             agg_isNull50 = false;
/* 394 */             agg_value53 = agg_value36;
/* 395 */           }
/* 396 */         }
/* 397 */
/* 398 */         if (!agg_isNull35) {
/* 399 */           agg_isNull49 = false; // resultCode could change nullability.
/* 400 */           agg_value52 = agg_value53 + agg_value38;
/* 401 */
/* 402 */         }
/* 403 */         boolean agg_isNull48 = agg_isNull49;
/* 404 */         double agg_value51 = agg_value52;
/* 405 */         if (agg_isNull48) {
/* 406 */           boolean agg_isNull52 = agg_fastAggBuffer.isNullAt(2);
/* 407 */           double agg_value55 = agg_isNull52 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 408 */           if (!agg_isNull52) {
/* 409 */             agg_isNull48 = false;
/* 410 */             agg_value51 = agg_value55;
/* 411 */           }
/* 412 */         }
/* 413 */         // update fast row
/* 414 */         if (!agg_isNull40) {
/* 415 */           agg_fastAggBuffer.setDouble(0, agg_value43);
/* 416 */         } else {
/* 417 */           agg_fastAggBuffer.setNullAt(0);
/* 418 */         }
/* 419 */
/* 420 */         agg_fastAggBuffer.setLong(1, agg_value48);
/* 421 */
/* 422 */         if (!agg_isNull48) {
/* 423 */           agg_fastAggBuffer.setDouble(2, agg_value51);
/* 424 */         } else {
/* 425 */           agg_fastAggBuffer.setNullAt(2);
/* 426 */         }
/* 427 */
/* 428 */       } else {
/* 429 */         // update unsafe row
/* 430 */
/* 431 */         // common sub-expressions
/* 432 */         boolean agg_isNull13 = false;
/* 433 */         double agg_value16 = -1.0;
/* 434 */         if (!false) {
/* 435 */           agg_value16 = (double) 0;
/* 436 */         }
/* 437 */         boolean agg_isNull16 = true;
/* 438 */         double agg_value19 = -1.0;
/* 439 */
/* 440 */         boolean agg_isNull17 = inputadapter_isNull9;
/* 441 */         double agg_value20 = -1.0;
/* 442 */         if (!inputadapter_isNull9) {
/* 443 */           agg_value20 = (double) inputadapter_value9;
/* 444 */         }
/* 445 */         if (!agg_isNull17) {
/* 446 */           if (!inputadapter_isNull11) {
/* 447 */             agg_isNull16 = false; // resultCode could change nullability.
/* 448 */             agg_value19 = agg_value20 * inputadapter_value11;
/* 449 */
/* 450 */           }
/* 451 */
/* 452 */         }
/* 453 */         boolean agg_isNull15 = agg_isNull16;
/* 454 */         double agg_value18 = -1.0;
/* 455 */         if (!agg_isNull16) {
/* 456 */           agg_value18 = agg_value19;
/* 457 */         }
/* 458 */         // evaluate aggregate function
/* 459 */         boolean agg_isNull21 = true;
/* 460 */         double agg_value24 = -1.0;
/* 461 */
/* 462 */         boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 463 */         double agg_value26 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 464 */         boolean agg_isNull22 = agg_isNull23;
/* 465 */         double agg_value25 = agg_value26;
/* 466 */         if (agg_isNull22) {
/* 467 */           if (!agg_isNull13) {
/* 468 */             agg_isNull22 = false;
/* 469 */             agg_value25 = agg_value16;
/* 470 */           }
/* 471 */         }
/* 472 */
/* 473 */         if (!agg_isNull15) {
/* 474 */           agg_isNull21 = false; // resultCode could change nullability.
/* 475 */           agg_value24 = agg_value25 + agg_value18;
/* 476 */
/* 477 */         }
/* 478 */         boolean agg_isNull20 = agg_isNull21;
/* 479 */         double agg_value23 = agg_value24;
/* 480 */         if (agg_isNull20) {
/* 481 */           boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 482 */           double agg_value27 = agg_isNull24 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 483 */           if (!agg_isNull24) {
/* 484 */             agg_isNull20 = false;
/* 485 */             agg_value23 = agg_value27;
/* 486 */           }
/* 487 */         }
/* 488 */         boolean agg_isNull25 = false;
/* 489 */
/* 490 */         long agg_value29 = agg_unsafeRowAggBuffer.getLong(1);
/* 491 */
/* 492 */         long agg_value28 = -1L;
/* 493 */         agg_value28 = agg_value29 + 1L;
/* 494 */         boolean agg_isNull29 = true;
/* 495 */         double agg_value32 = -1.0;
/* 496 */
/* 497 */         boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 498 */         double agg_value34 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 499 */         boolean agg_isNull30 = agg_isNull31;
/* 500 */         double agg_value33 = agg_value34;
/* 501 */         if (agg_isNull30) {
/* 502 */           if (!agg_isNull13) {
/* 503 */             agg_isNull30 = false;
/* 504 */             agg_value33 = agg_value16;
/* 505 */           }
/* 506 */         }
/* 507 */
/* 508 */         if (!agg_isNull15) {
/* 509 */           agg_isNull29 = false; // resultCode could change nullability.
/* 510 */           agg_value32 = agg_value33 + agg_value18;
/* 511 */
/* 512 */         }
/* 513 */         boolean agg_isNull28 = agg_isNull29;
/* 514 */         double agg_value31 = agg_value32;
/* 515 */         if (agg_isNull28) {
/* 516 */           boolean agg_isNull32 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 517 */           double agg_value35 = agg_isNull32 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 518 */           if (!agg_isNull32) {
/* 519 */             agg_isNull28 = false;
/* 520 */             agg_value31 = agg_value35;
/* 521 */           }
/* 522 */         }
/* 523 */         // update unsafe row buffer
/* 524 */         if (!agg_isNull20) {
/* 525 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value23);
/* 526 */         } else {
/* 527 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 528 */         }
/* 529 */
/* 530 */         agg_unsafeRowAggBuffer.setLong(1, agg_value28);
/* 531 */
/* 532 */         if (!agg_isNull28) {
/* 533 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value31);
/* 534 */         } else {
/* 535 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 536 */         }
/* 537 */
/* 538 */       }
/* 539 */       if (shouldStop()) return;
/* 540 */     }
/* 541 */
/* 542 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 543 */
/* 544 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 545 */   }
/* 546 */
/* 547 */   private void wholestagecodegen_init_2() {
/* 548 */     project_result2 = new UnsafeRow(5);
/* 549 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 550 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 5);
/* 551 */     agg_result3 = new UnsafeRow(3);
/* 552 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 0);
/* 553 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 554 */
/* 555 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 556 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 557 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 558 */
/* 559 */   }
/* 560 */
/* 561 */   private void wholestagecodegen_init_1() {
/* 562 */     bhj_result = new UnsafeRow(8);
/* 563 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 564 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 8);
/* 565 */     project_result1 = new UnsafeRow(6);
/* 566 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 567 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 6);
/* 568 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 569 */
/* 570 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 571 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 572 */
/* 573 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 574 */     bhj_result1 = new UnsafeRow(7);
/* 575 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 576 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 7);
/* 577 */
/* 578 */   }
/* 579 */
/* 580 */   protected void processNext() throws java.io.IOException {
/* 581 */     if (!agg_initAgg) {
/* 582 */       agg_initAgg = true;
/* 583 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 584 */       agg_doAggregateWithKeys();
/* 585 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 586 */     }
/* 587 */
/* 588 */     // output the result
/* 589 */
/* 590 */     while (agg_fastHashMapIter.next()) {
/* 591 */       wholestagecodegen_numOutputRows.add(1);
/* 592 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 593 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 594 */
/* 595 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 596 */
/* 597 */       append(agg_resultRow);
/* 598 */
/* 599 */       if (shouldStop()) return;
/* 600 */     }
/* 601 */     agg_fastHashMap.close();
/* 602 */
/* 603 */     while (agg_mapIter.next()) {
/* 604 */       wholestagecodegen_numOutputRows.add(1);
/* 605 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 606 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 607 */
/* 608 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 609 */
/* 610 */       append(agg_resultRow);
/* 611 */
/* 612 */       if (shouldStop()) return;
/* 613 */     }
/* 614 */
/* 615 */     agg_mapIter.close();
/* 616 */     if (agg_sorter == null) {
/* 617 */       agg_hashMap.free();
/* 618 */     }
/* 619 */   }
/* 620 */ }
