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
/* 013 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 014 */   private agg_FastHashMap agg_fastHashMap;
/* 015 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 016 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 017 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 018 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 021 */   private scala.collection.Iterator inputadapter_input;
/* 022 */   private UnsafeRow project_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 025 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 026 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 028 */   private UnsafeRow bhj_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 031 */   private UnsafeRow project_result1;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 034 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 035 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 036 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 037 */   private UnsafeRow bhj_result1;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 040 */   private UnsafeRow project_result2;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 043 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 044 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 045 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 046 */   private UnsafeRow bhj_result2;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 049 */   private UnsafeRow project_result3;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 052 */   private UnsafeRow agg_result2;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 055 */   private int agg_value8;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 057 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 058 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 059 */
/* 060 */   public GeneratedIterator(Object[] references) {
/* 061 */     this.references = references;
/* 062 */   }
/* 063 */
/* 064 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 065 */     partitionIndex = index;
/* 066 */     this.inputs = inputs;
/* 067 */     wholestagecodegen_init_0();
/* 068 */     wholestagecodegen_init_1();
/* 069 */     wholestagecodegen_init_2();
/* 070 */     wholestagecodegen_init_3();
/* 071 */
/* 072 */   }
/* 073 */
/* 074 */   private void wholestagecodegen_init_0() {
/* 075 */     agg_initAgg = false;
/* 076 */
/* 077 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 078 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 079 */
/* 080 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 081 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 082 */     inputadapter_input = inputs[0];
/* 083 */     project_result = new UnsafeRow(5);
/* 084 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 085 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 086 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 087 */
/* 088 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 089 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 090 */
/* 091 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 092 */
/* 093 */   }
/* 094 */
/* 095 */   private void wholestagecodegen_init_3() {
/* 096 */     agg_result2 = new UnsafeRow(2);
/* 097 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 64);
/* 098 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 099 */
/* 100 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 101 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 102 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 103 */
/* 104 */   }
/* 105 */
/* 106 */   public class agg_FastHashMap {
/* 107 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 108 */     private int[] buckets;
/* 109 */     private int capacity = 1 << 16;
/* 110 */     private double loadFactor = 0.5;
/* 111 */     private int numBuckets = (int) (capacity / loadFactor);
/* 112 */     private int maxSteps = 2;
/* 113 */     private int numRows = 0;
/* 114 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("w_state", org.apache.spark.sql.types.DataTypes.StringType)
/* 115 */     .add("i_item_id", org.apache.spark.sql.types.DataTypes.StringType);
/* 116 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 117 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 118 */     private Object emptyVBase;
/* 119 */     private long emptyVOff;
/* 120 */     private int emptyVLen;
/* 121 */     private boolean isBatchFull = false;
/* 122 */
/* 123 */     public agg_FastHashMap(
/* 124 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 125 */       InternalRow emptyAggregationBuffer) {
/* 126 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 127 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 128 */
/* 129 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 130 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 131 */
/* 132 */       emptyVBase = emptyBuffer;
/* 133 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 134 */       emptyVLen = emptyBuffer.length;
/* 135 */
/* 136 */       buckets = new int[numBuckets];
/* 137 */       java.util.Arrays.fill(buckets, -1);
/* 138 */     }
/* 139 */
/* 140 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1) {
/* 141 */       long h = hash(agg_key, agg_key1);
/* 142 */       int step = 0;
/* 143 */       int idx = (int) h & (numBuckets - 1);
/* 144 */       while (step < maxSteps) {
/* 145 */         // Return bucket index if it's either an empty slot or already contains the key
/* 146 */         if (buckets[idx] == -1) {
/* 147 */           if (numRows < capacity && !isBatchFull) {
/* 148 */             // creating the unsafe for new entry
/* 149 */             UnsafeRow agg_result = new UnsafeRow(2);
/* 150 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 151 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 152 */               64);
/* 153 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 154 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 155 */               agg_holder,
/* 156 */               2);
/* 157 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 158 */             agg_rowWriter.zeroOutNullBytes();
/* 159 */             agg_rowWriter.write(0, agg_key);
/* 160 */             agg_rowWriter.write(1, agg_key1);
/* 161 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 162 */             Object kbase = agg_result.getBaseObject();
/* 163 */             long koff = agg_result.getBaseOffset();
/* 164 */             int klen = agg_result.getSizeInBytes();
/* 165 */
/* 166 */             UnsafeRow vRow
/* 167 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 168 */             if (vRow == null) {
/* 169 */               isBatchFull = true;
/* 170 */             } else {
/* 171 */               buckets[idx] = numRows++;
/* 172 */             }
/* 173 */             return vRow;
/* 174 */           } else {
/* 175 */             // No more space
/* 176 */             return null;
/* 177 */           }
/* 178 */         } else if (equals(idx, agg_key, agg_key1)) {
/* 179 */           return batch.getValueRow(buckets[idx]);
/* 180 */         }
/* 181 */         idx = (idx + 1) & (numBuckets - 1);
/* 182 */         step++;
/* 183 */       }
/* 184 */       // Didn't find it
/* 185 */       return null;
/* 186 */     }
/* 187 */
/* 188 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1) {
/* 189 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 190 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1));
/* 191 */     }
/* 192 */
/* 193 */     private long hash(UTF8String agg_key, UTF8String agg_key1) {
/* 194 */       long agg_hash = 0;
/* 195 */
/* 196 */       int agg_result = 0;
/* 197 */       byte[] agg_bytes = agg_key.getBytes();
/* 198 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 199 */         int agg_hash1 = agg_bytes[i];
/* 200 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 201 */       }
/* 202 */
/* 203 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 204 */
/* 205 */       int agg_result1 = 0;
/* 206 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 207 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 208 */         int agg_hash2 = agg_bytes1[i];
/* 209 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 210 */       }
/* 211 */
/* 212 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 213 */
/* 214 */       return agg_hash;
/* 215 */     }
/* 216 */
/* 217 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 218 */       return batch.rowIterator();
/* 219 */     }
/* 220 */
/* 221 */     public void close() {
/* 222 */       batch.close();
/* 223 */     }
/* 224 */
/* 225 */   }
/* 226 */
/* 227 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 228 */     agg_hashMap = agg_plan.createHashMap();
/* 229 */
/* 230 */     while (inputadapter_input.hasNext()) {
/* 231 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 232 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 233 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 234 */
/* 235 */       // generate join key for stream side
/* 236 */
/* 237 */       boolean bhj_isNull = inputadapter_isNull;
/* 238 */       long bhj_value = -1L;
/* 239 */       if (!inputadapter_isNull) {
/* 240 */         bhj_value = (long) inputadapter_value;
/* 241 */       }
/* 242 */       // find matches from HashedRelation
/* 243 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 244 */       if (bhj_matched == null) continue;
/* 245 */
/* 246 */       bhj_numOutputRows.add(1);
/* 247 */
/* 248 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 249 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 250 */
/* 251 */       // generate join key for stream side
/* 252 */
/* 253 */       boolean bhj_isNull11 = inputadapter_isNull1;
/* 254 */       long bhj_value11 = -1L;
/* 255 */       if (!inputadapter_isNull1) {
/* 256 */         bhj_value11 = (long) inputadapter_value1;
/* 257 */       }
/* 258 */       // find matches from HashedRelation
/* 259 */       UnsafeRow bhj_matched1 = bhj_isNull11 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value11);
/* 260 */       if (bhj_matched1 == null) continue;
/* 261 */
/* 262 */       bhj_numOutputRows1.add(1);
/* 263 */
/* 264 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 265 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 266 */
/* 267 */       // generate join key for stream side
/* 268 */
/* 269 */       boolean bhj_isNull22 = inputadapter_isNull4;
/* 270 */       long bhj_value22 = -1L;
/* 271 */       if (!inputadapter_isNull4) {
/* 272 */         bhj_value22 = (long) inputadapter_value4;
/* 273 */       }
/* 274 */       // find matches from HashedRelation
/* 275 */       UnsafeRow bhj_matched2 = bhj_isNull22 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value22);
/* 276 */       if (bhj_matched2 == null) continue;
/* 277 */
/* 278 */       bhj_numOutputRows2.add(1);
/* 279 */
/* 280 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 281 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 282 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 283 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
/* 284 */       boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 285 */       UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 286 */       boolean bhj_isNull14 = bhj_matched1.isNullAt(1);
/* 287 */       UTF8String bhj_value14 = bhj_isNull14 ? null : (bhj_matched1.getUTF8String(1));
/* 288 */       boolean bhj_isNull25 = bhj_matched2.isNullAt(1);
/* 289 */       UTF8String bhj_value25 = bhj_isNull25 ? null : (bhj_matched2.getUTF8String(1));
/* 290 */
/* 291 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 292 */
/* 293 */       UnsafeRow agg_fastAggBuffer = null;
/* 294 */
/* 295 */       if (true) {
/* 296 */         if (!bhj_isNull3 && !bhj_isNull14) {
/* 297 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 298 */             bhj_value3, bhj_value14);
/* 299 */         }
/* 300 */       }
/* 301 */
/* 302 */       if (agg_fastAggBuffer == null) {
/* 303 */         // generate grouping key
/* 304 */         agg_holder.reset();
/* 305 */
/* 306 */         agg_rowWriter.zeroOutNullBytes();
/* 307 */
/* 308 */         if (bhj_isNull3) {
/* 309 */           agg_rowWriter.setNullAt(0);
/* 310 */         } else {
/* 311 */           agg_rowWriter.write(0, bhj_value3);
/* 312 */         }
/* 313 */
/* 314 */         if (bhj_isNull14) {
/* 315 */           agg_rowWriter.setNullAt(1);
/* 316 */         } else {
/* 317 */           agg_rowWriter.write(1, bhj_value14);
/* 318 */         }
/* 319 */         agg_result2.setTotalSize(agg_holder.totalSize());
/* 320 */         agg_value8 = 42;
/* 321 */
/* 322 */         if (!bhj_isNull3) {
/* 323 */           agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value3.getBaseObject(), bhj_value3.getBaseOffset(), bhj_value3.numBytes(), agg_value8);
/* 324 */         }
/* 325 */
/* 326 */         if (!bhj_isNull14) {
/* 327 */           agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value14.getBaseObject(), bhj_value14.getBaseOffset(), bhj_value14.numBytes(), agg_value8);
/* 328 */         }
/* 329 */         if (true) {
/* 330 */           // try to get the buffer from hash map
/* 331 */           agg_unsafeRowAggBuffer =
/* 332 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value8);
/* 333 */         }
/* 334 */         if (agg_unsafeRowAggBuffer == null) {
/* 335 */           if (agg_sorter == null) {
/* 336 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 337 */           } else {
/* 338 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 339 */           }
/* 340 */
/* 341 */           // the hash map had be spilled, it should have enough memory now,
/* 342 */           // try  to allocate buffer again.
/* 343 */           agg_unsafeRowAggBuffer =
/* 344 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value8);
/* 345 */           if (agg_unsafeRowAggBuffer == null) {
/* 346 */             // failed to allocate the first page
/* 347 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 348 */           }
/* 349 */         }
/* 350 */       }
/* 351 */
/* 352 */       if (agg_fastAggBuffer != null) {
/* 353 */         // update fast row
/* 354 */
/* 355 */         // common sub-expressions
/* 356 */         boolean agg_isNull38 = true;
/* 357 */         double agg_value40 = -1.0;
/* 358 */
/* 359 */         if (!inputadapter_isNull3) {
/* 360 */           boolean agg_isNull40 = inputadapter_isNull7;
/* 361 */           double agg_value42 = inputadapter_value7;
/* 362 */           if (agg_isNull40) {
/* 363 */             if (!false) {
/* 364 */               agg_isNull40 = false;
/* 365 */               agg_value42 = 0.0D;
/* 366 */             }
/* 367 */           }
/* 368 */
/* 369 */           agg_isNull38 = false; // resultCode could change nullability.
/* 370 */           agg_value40 = inputadapter_value3 - agg_value42;
/* 371 */
/* 372 */         }
/* 373 */         boolean agg_isNull43 = false;
/* 374 */         double agg_value45 = -1.0;
/* 375 */         if (!false) {
/* 376 */           agg_value45 = (double) 0;
/* 377 */         }
/* 378 */         boolean agg_isNull45 = bhj_isNull25;
/* 379 */         int agg_value47 = -1;
/* 380 */         if (!bhj_isNull25) {
/* 381 */           scala.Option<Integer> agg_intOpt1 =
/* 382 */           org.apache.spark.sql.catalyst.util.DateTimeUtils.stringToDate(bhj_value25);
/* 383 */           if (agg_intOpt1.isDefined()) {
/* 384 */             agg_value47 = ((Integer) agg_intOpt1.get()).intValue();
/* 385 */           } else {
/* 386 */             agg_isNull45 = true;
/* 387 */           }
/* 388 */
/* 389 */         }
/* 390 */         // evaluate aggregate function
/* 391 */         boolean agg_isNull48 = true;
/* 392 */         double agg_value50 = -1.0;
/* 393 */
/* 394 */         boolean agg_isNull50 = agg_fastAggBuffer.isNullAt(0);
/* 395 */         double agg_value52 = agg_isNull50 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 396 */         boolean agg_isNull49 = agg_isNull50;
/* 397 */         double agg_value51 = agg_value52;
/* 398 */         if (agg_isNull49) {
/* 399 */           if (!agg_isNull43) {
/* 400 */             agg_isNull49 = false;
/* 401 */             agg_value51 = agg_value45;
/* 402 */           }
/* 403 */         }
/* 404 */
/* 405 */         boolean agg_isNull52 = true;
/* 406 */         double agg_value54 = -1.0;
/* 407 */
/* 408 */         boolean agg_isNull53 = true;
/* 409 */         boolean agg_value55 = false;
/* 410 */
/* 411 */         if (!agg_isNull45) {
/* 412 */           agg_isNull53 = false; // resultCode could change nullability.
/* 413 */           agg_value55 = agg_value47 < 11027;
/* 414 */
/* 415 */         }
/* 416 */         if (!agg_isNull53 && agg_value55) {
/* 417 */           agg_isNull52 = agg_isNull38;
/* 418 */           agg_value54 = agg_value40;
/* 419 */         }
/* 420 */
/* 421 */         else {
/* 422 */           agg_isNull52 = false;
/* 423 */           agg_value54 = 0.0D;
/* 424 */         }
/* 425 */         boolean agg_isNull51 = agg_isNull52;
/* 426 */         double agg_value53 = -1.0;
/* 427 */         if (!agg_isNull52) {
/* 428 */           agg_value53 = agg_value54;
/* 429 */         }
/* 430 */         if (!agg_isNull51) {
/* 431 */           agg_isNull48 = false; // resultCode could change nullability.
/* 432 */           agg_value50 = agg_value51 + agg_value53;
/* 433 */
/* 434 */         }
/* 435 */         boolean agg_isNull47 = agg_isNull48;
/* 436 */         double agg_value49 = agg_value50;
/* 437 */         if (agg_isNull47) {
/* 438 */           boolean agg_isNull56 = agg_fastAggBuffer.isNullAt(0);
/* 439 */           double agg_value58 = agg_isNull56 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 440 */           if (!agg_isNull56) {
/* 441 */             agg_isNull47 = false;
/* 442 */             agg_value49 = agg_value58;
/* 443 */           }
/* 444 */         }
/* 445 */         boolean agg_isNull58 = true;
/* 446 */         double agg_value60 = -1.0;
/* 447 */
/* 448 */         boolean agg_isNull60 = agg_fastAggBuffer.isNullAt(1);
/* 449 */         double agg_value62 = agg_isNull60 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 450 */         boolean agg_isNull59 = agg_isNull60;
/* 451 */         double agg_value61 = agg_value62;
/* 452 */         if (agg_isNull59) {
/* 453 */           if (!agg_isNull43) {
/* 454 */             agg_isNull59 = false;
/* 455 */             agg_value61 = agg_value45;
/* 456 */           }
/* 457 */         }
/* 458 */
/* 459 */         boolean agg_isNull62 = true;
/* 460 */         double agg_value64 = -1.0;
/* 461 */
/* 462 */         boolean agg_isNull63 = true;
/* 463 */         boolean agg_value65 = false;
/* 464 */
/* 465 */         if (!agg_isNull45) {
/* 466 */           agg_isNull63 = false; // resultCode could change nullability.
/* 467 */           agg_value65 = agg_value47 >= 11027;
/* 468 */
/* 469 */         }
/* 470 */         if (!agg_isNull63 && agg_value65) {
/* 471 */           agg_isNull62 = agg_isNull38;
/* 472 */           agg_value64 = agg_value40;
/* 473 */         }
/* 474 */
/* 475 */         else {
/* 476 */           agg_isNull62 = false;
/* 477 */           agg_value64 = 0.0D;
/* 478 */         }
/* 479 */         boolean agg_isNull61 = agg_isNull62;
/* 480 */         double agg_value63 = -1.0;
/* 481 */         if (!agg_isNull62) {
/* 482 */           agg_value63 = agg_value64;
/* 483 */         }
/* 484 */         if (!agg_isNull61) {
/* 485 */           agg_isNull58 = false; // resultCode could change nullability.
/* 486 */           agg_value60 = agg_value61 + agg_value63;
/* 487 */
/* 488 */         }
/* 489 */         boolean agg_isNull57 = agg_isNull58;
/* 490 */         double agg_value59 = agg_value60;
/* 491 */         if (agg_isNull57) {
/* 492 */           boolean agg_isNull66 = agg_fastAggBuffer.isNullAt(1);
/* 493 */           double agg_value68 = agg_isNull66 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 494 */           if (!agg_isNull66) {
/* 495 */             agg_isNull57 = false;
/* 496 */             agg_value59 = agg_value68;
/* 497 */           }
/* 498 */         }
/* 499 */         // update fast row
/* 500 */         if (!agg_isNull47) {
/* 501 */           agg_fastAggBuffer.setDouble(0, agg_value49);
/* 502 */         } else {
/* 503 */           agg_fastAggBuffer.setNullAt(0);
/* 504 */         }
/* 505 */
/* 506 */         if (!agg_isNull57) {
/* 507 */           agg_fastAggBuffer.setDouble(1, agg_value59);
/* 508 */         } else {
/* 509 */           agg_fastAggBuffer.setNullAt(1);
/* 510 */         }
/* 511 */
/* 512 */       } else {
/* 513 */         // update unsafe row
/* 514 */
/* 515 */         // common sub-expressions
/* 516 */         boolean agg_isNull9 = true;
/* 517 */         double agg_value11 = -1.0;
/* 518 */
/* 519 */         if (!inputadapter_isNull3) {
/* 520 */           boolean agg_isNull11 = inputadapter_isNull7;
/* 521 */           double agg_value13 = inputadapter_value7;
/* 522 */           if (agg_isNull11) {
/* 523 */             if (!false) {
/* 524 */               agg_isNull11 = false;
/* 525 */               agg_value13 = 0.0D;
/* 526 */             }
/* 527 */           }
/* 528 */
/* 529 */           agg_isNull9 = false; // resultCode could change nullability.
/* 530 */           agg_value11 = inputadapter_value3 - agg_value13;
/* 531 */
/* 532 */         }
/* 533 */         boolean agg_isNull14 = false;
/* 534 */         double agg_value16 = -1.0;
/* 535 */         if (!false) {
/* 536 */           agg_value16 = (double) 0;
/* 537 */         }
/* 538 */         boolean agg_isNull16 = bhj_isNull25;
/* 539 */         int agg_value18 = -1;
/* 540 */         if (!bhj_isNull25) {
/* 541 */           scala.Option<Integer> agg_intOpt =
/* 542 */           org.apache.spark.sql.catalyst.util.DateTimeUtils.stringToDate(bhj_value25);
/* 543 */           if (agg_intOpt.isDefined()) {
/* 544 */             agg_value18 = ((Integer) agg_intOpt.get()).intValue();
/* 545 */           } else {
/* 546 */             agg_isNull16 = true;
/* 547 */           }
/* 548 */
/* 549 */         }
/* 550 */         // evaluate aggregate function
/* 551 */         boolean agg_isNull19 = true;
/* 552 */         double agg_value21 = -1.0;
/* 553 */
/* 554 */         boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 555 */         double agg_value23 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 556 */         boolean agg_isNull20 = agg_isNull21;
/* 557 */         double agg_value22 = agg_value23;
/* 558 */         if (agg_isNull20) {
/* 559 */           if (!agg_isNull14) {
/* 560 */             agg_isNull20 = false;
/* 561 */             agg_value22 = agg_value16;
/* 562 */           }
/* 563 */         }
/* 564 */
/* 565 */         boolean agg_isNull23 = true;
/* 566 */         double agg_value25 = -1.0;
/* 567 */
/* 568 */         boolean agg_isNull24 = true;
/* 569 */         boolean agg_value26 = false;
/* 570 */
/* 571 */         if (!agg_isNull16) {
/* 572 */           agg_isNull24 = false; // resultCode could change nullability.
/* 573 */           agg_value26 = agg_value18 < 11027;
/* 574 */
/* 575 */         }
/* 576 */         if (!agg_isNull24 && agg_value26) {
/* 577 */           agg_isNull23 = agg_isNull9;
/* 578 */           agg_value25 = agg_value11;
/* 579 */         }
/* 580 */
/* 581 */         else {
/* 582 */           agg_isNull23 = false;
/* 583 */           agg_value25 = 0.0D;
/* 584 */         }
/* 585 */         boolean agg_isNull22 = agg_isNull23;
/* 586 */         double agg_value24 = -1.0;
/* 587 */         if (!agg_isNull23) {
/* 588 */           agg_value24 = agg_value25;
/* 589 */         }
/* 590 */         if (!agg_isNull22) {
/* 591 */           agg_isNull19 = false; // resultCode could change nullability.
/* 592 */           agg_value21 = agg_value22 + agg_value24;
/* 593 */
/* 594 */         }
/* 595 */         boolean agg_isNull18 = agg_isNull19;
/* 596 */         double agg_value20 = agg_value21;
/* 597 */         if (agg_isNull18) {
/* 598 */           boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 599 */           double agg_value29 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 600 */           if (!agg_isNull27) {
/* 601 */             agg_isNull18 = false;
/* 602 */             agg_value20 = agg_value29;
/* 603 */           }
/* 604 */         }
/* 605 */         boolean agg_isNull29 = true;
/* 606 */         double agg_value31 = -1.0;
/* 607 */
/* 608 */         boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 609 */         double agg_value33 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 610 */         boolean agg_isNull30 = agg_isNull31;
/* 611 */         double agg_value32 = agg_value33;
/* 612 */         if (agg_isNull30) {
/* 613 */           if (!agg_isNull14) {
/* 614 */             agg_isNull30 = false;
/* 615 */             agg_value32 = agg_value16;
/* 616 */           }
/* 617 */         }
/* 618 */
/* 619 */         boolean agg_isNull33 = true;
/* 620 */         double agg_value35 = -1.0;
/* 621 */
/* 622 */         boolean agg_isNull34 = true;
/* 623 */         boolean agg_value36 = false;
/* 624 */
/* 625 */         if (!agg_isNull16) {
/* 626 */           agg_isNull34 = false; // resultCode could change nullability.
/* 627 */           agg_value36 = agg_value18 >= 11027;
/* 628 */
/* 629 */         }
/* 630 */         if (!agg_isNull34 && agg_value36) {
/* 631 */           agg_isNull33 = agg_isNull9;
/* 632 */           agg_value35 = agg_value11;
/* 633 */         }
/* 634 */
/* 635 */         else {
/* 636 */           agg_isNull33 = false;
/* 637 */           agg_value35 = 0.0D;
/* 638 */         }
/* 639 */         boolean agg_isNull32 = agg_isNull33;
/* 640 */         double agg_value34 = -1.0;
/* 641 */         if (!agg_isNull33) {
/* 642 */           agg_value34 = agg_value35;
/* 643 */         }
/* 644 */         if (!agg_isNull32) {
/* 645 */           agg_isNull29 = false; // resultCode could change nullability.
/* 646 */           agg_value31 = agg_value32 + agg_value34;
/* 647 */
/* 648 */         }
/* 649 */         boolean agg_isNull28 = agg_isNull29;
/* 650 */         double agg_value30 = agg_value31;
/* 651 */         if (agg_isNull28) {
/* 652 */           boolean agg_isNull37 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 653 */           double agg_value39 = agg_isNull37 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 654 */           if (!agg_isNull37) {
/* 655 */             agg_isNull28 = false;
/* 656 */             agg_value30 = agg_value39;
/* 657 */           }
/* 658 */         }
/* 659 */         // update unsafe row buffer
/* 660 */         if (!agg_isNull18) {
/* 661 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value20);
/* 662 */         } else {
/* 663 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 664 */         }
/* 665 */
/* 666 */         if (!agg_isNull28) {
/* 667 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value30);
/* 668 */         } else {
/* 669 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 670 */         }
/* 671 */
/* 672 */       }
/* 673 */       if (shouldStop()) return;
/* 674 */     }
/* 675 */
/* 676 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 677 */
/* 678 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 679 */   }
/* 680 */
/* 681 */   private void wholestagecodegen_init_2() {
/* 682 */     project_result2 = new UnsafeRow(5);
/* 683 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 684 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 5);
/* 685 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[7];
/* 686 */
/* 687 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 688 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 689 */
/* 690 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 691 */     bhj_result2 = new UnsafeRow(7);
/* 692 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 96);
/* 693 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 7);
/* 694 */     project_result3 = new UnsafeRow(5);
/* 695 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 96);
/* 696 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 5);
/* 697 */
/* 698 */   }
/* 699 */
/* 700 */   private void wholestagecodegen_init_1() {
/* 701 */     bhj_result = new UnsafeRow(7);
/* 702 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 703 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 704 */     project_result1 = new UnsafeRow(5);
/* 705 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 706 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 707 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 708 */
/* 709 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 710 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 711 */
/* 712 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 713 */     bhj_result1 = new UnsafeRow(7);
/* 714 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 715 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 7);
/* 716 */
/* 717 */   }
/* 718 */
/* 719 */   protected void processNext() throws java.io.IOException {
/* 720 */     if (!agg_initAgg) {
/* 721 */       agg_initAgg = true;
/* 722 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 723 */       agg_doAggregateWithKeys();
/* 724 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 725 */     }
/* 726 */
/* 727 */     // output the result
/* 728 */
/* 729 */     while (agg_fastHashMapIter.next()) {
/* 730 */       wholestagecodegen_numOutputRows.add(1);
/* 731 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 732 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 733 */
/* 734 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 735 */
/* 736 */       append(agg_resultRow);
/* 737 */
/* 738 */       if (shouldStop()) return;
/* 739 */     }
/* 740 */     agg_fastHashMap.close();
/* 741 */
/* 742 */     while (agg_mapIter.next()) {
/* 743 */       wholestagecodegen_numOutputRows.add(1);
/* 744 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 745 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 746 */
/* 747 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 748 */
/* 749 */       append(agg_resultRow);
/* 750 */
/* 751 */       if (shouldStop()) return;
/* 752 */     }
/* 753 */
/* 754 */     agg_mapIter.close();
/* 755 */     if (agg_sorter == null) {
/* 756 */       agg_hashMap.free();
/* 757 */     }
/* 758 */   }
/* 759 */ }
