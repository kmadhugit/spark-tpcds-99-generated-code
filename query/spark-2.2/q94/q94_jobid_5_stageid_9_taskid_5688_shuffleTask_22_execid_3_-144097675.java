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
/* 052 */   private UnsafeRow agg_result1;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 055 */   private int agg_value6;
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
/* 083 */     project_result = new UnsafeRow(6);
/* 084 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 085 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 6);
/* 086 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 087 */
/* 088 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 089 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 090 */
/* 091 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 092 */
/* 093 */   }
/* 094 */
/* 095 */   private void wholestagecodegen_init_3() {
/* 096 */     agg_result1 = new UnsafeRow(1);
/* 097 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 098 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 099 */
/* 100 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 101 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 102 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
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
/* 114 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 115 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 116 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 117 */     private Object emptyVBase;
/* 118 */     private long emptyVOff;
/* 119 */     private int emptyVLen;
/* 120 */     private boolean isBatchFull = false;
/* 121 */
/* 122 */     public agg_FastHashMap(
/* 123 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 124 */       InternalRow emptyAggregationBuffer) {
/* 125 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 126 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 127 */
/* 128 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 129 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 130 */
/* 131 */       emptyVBase = emptyBuffer;
/* 132 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 133 */       emptyVLen = emptyBuffer.length;
/* 134 */
/* 135 */       buckets = new int[numBuckets];
/* 136 */       java.util.Arrays.fill(buckets, -1);
/* 137 */     }
/* 138 */
/* 139 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 140 */       long h = hash(agg_key);
/* 141 */       int step = 0;
/* 142 */       int idx = (int) h & (numBuckets - 1);
/* 143 */       while (step < maxSteps) {
/* 144 */         // Return bucket index if it's either an empty slot or already contains the key
/* 145 */         if (buckets[idx] == -1) {
/* 146 */           if (numRows < capacity && !isBatchFull) {
/* 147 */             // creating the unsafe for new entry
/* 148 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 149 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 150 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 151 */               0);
/* 152 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 153 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 154 */               agg_holder,
/* 155 */               1);
/* 156 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 157 */             agg_rowWriter.zeroOutNullBytes();
/* 158 */             agg_rowWriter.write(0, agg_key);
/* 159 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 160 */             Object kbase = agg_result.getBaseObject();
/* 161 */             long koff = agg_result.getBaseOffset();
/* 162 */             int klen = agg_result.getSizeInBytes();
/* 163 */
/* 164 */             UnsafeRow vRow
/* 165 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 166 */             if (vRow == null) {
/* 167 */               isBatchFull = true;
/* 168 */             } else {
/* 169 */               buckets[idx] = numRows++;
/* 170 */             }
/* 171 */             return vRow;
/* 172 */           } else {
/* 173 */             // No more space
/* 174 */             return null;
/* 175 */           }
/* 176 */         } else if (equals(idx, agg_key)) {
/* 177 */           return batch.getValueRow(buckets[idx]);
/* 178 */         }
/* 179 */         idx = (idx + 1) & (numBuckets - 1);
/* 180 */         step++;
/* 181 */       }
/* 182 */       // Didn't find it
/* 183 */       return null;
/* 184 */     }
/* 185 */
/* 186 */     private boolean equals(int idx, int agg_key) {
/* 187 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 188 */       return (row.getInt(0) == agg_key);
/* 189 */     }
/* 190 */
/* 191 */     private long hash(int agg_key) {
/* 192 */       long agg_hash = 0;
/* 193 */
/* 194 */       int agg_result = agg_key;
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
/* 213 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 214 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 215 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 216 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 217 */
/* 218 */       // generate join key for stream side
/* 219 */
/* 220 */       boolean bhj_isNull = inputadapter_isNull1;
/* 221 */       long bhj_value = -1L;
/* 222 */       if (!inputadapter_isNull1) {
/* 223 */         bhj_value = (long) inputadapter_value1;
/* 224 */       }
/* 225 */       // find matches from HashedRelation
/* 226 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 227 */       if (bhj_matched == null) continue;
/* 228 */
/* 229 */       bhj_numOutputRows.add(1);
/* 230 */
/* 231 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 232 */       int inputadapter_value10 = inputadapter_isNull10 ? -1 : (inputadapter_row.getInt(10));
/* 233 */
/* 234 */       // generate join key for stream side
/* 235 */
/* 236 */       boolean bhj_isNull10 = inputadapter_isNull10;
/* 237 */       long bhj_value10 = -1L;
/* 238 */       if (!inputadapter_isNull10) {
/* 239 */         bhj_value10 = (long) inputadapter_value10;
/* 240 */       }
/* 241 */       // find matches from HashedRelation
/* 242 */       UnsafeRow bhj_matched1 = bhj_isNull10 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value10);
/* 243 */       if (bhj_matched1 == null) continue;
/* 244 */
/* 245 */       bhj_numOutputRows1.add(1);
/* 246 */
/* 247 */       boolean inputadapter_isNull12 = inputadapter_row.isNullAt(12);
/* 248 */       int inputadapter_value12 = inputadapter_isNull12 ? -1 : (inputadapter_row.getInt(12));
/* 249 */
/* 250 */       // generate join key for stream side
/* 251 */
/* 252 */       boolean bhj_isNull19 = inputadapter_isNull12;
/* 253 */       long bhj_value19 = -1L;
/* 254 */       if (!inputadapter_isNull12) {
/* 255 */         bhj_value19 = (long) inputadapter_value12;
/* 256 */       }
/* 257 */       // find matches from HashedRelation
/* 258 */       UnsafeRow bhj_matched2 = bhj_isNull19 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value19);
/* 259 */       if (bhj_matched2 == null) continue;
/* 260 */
/* 261 */       bhj_numOutputRows2.add(1);
/* 262 */
/* 263 */       boolean inputadapter_isNull16 = inputadapter_row.isNullAt(16);
/* 264 */       int inputadapter_value16 = inputadapter_isNull16 ? -1 : (inputadapter_row.getInt(16));
/* 265 */       boolean inputadapter_isNull27 = inputadapter_row.isNullAt(27);
/* 266 */       double inputadapter_value27 = inputadapter_isNull27 ? -1.0 : (inputadapter_row.getDouble(27));
/* 267 */       boolean inputadapter_isNull32 = inputadapter_row.isNullAt(32);
/* 268 */       double inputadapter_value32 = inputadapter_isNull32 ? -1.0 : (inputadapter_row.getDouble(32));
/* 269 */
/* 270 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 271 */
/* 272 */       UnsafeRow agg_fastAggBuffer = null;
/* 273 */
/* 274 */       if (true) {
/* 275 */         if (!inputadapter_isNull16) {
/* 276 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 277 */             inputadapter_value16);
/* 278 */         }
/* 279 */       }
/* 280 */
/* 281 */       if (agg_fastAggBuffer == null) {
/* 282 */         // generate grouping key
/* 283 */         agg_rowWriter.zeroOutNullBytes();
/* 284 */
/* 285 */         if (inputadapter_isNull16) {
/* 286 */           agg_rowWriter.setNullAt(0);
/* 287 */         } else {
/* 288 */           agg_rowWriter.write(0, inputadapter_value16);
/* 289 */         }
/* 290 */         agg_value6 = 42;
/* 291 */
/* 292 */         if (!inputadapter_isNull16) {
/* 293 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value16, agg_value6);
/* 294 */         }
/* 295 */         if (true) {
/* 296 */           // try to get the buffer from hash map
/* 297 */           agg_unsafeRowAggBuffer =
/* 298 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value6);
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
/* 310 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value6);
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
/* 322 */
/* 323 */         // evaluate aggregate function
/* 324 */         boolean agg_isNull23 = true;
/* 325 */         double agg_value25 = -1.0;
/* 326 */
/* 327 */         boolean agg_isNull25 = agg_fastAggBuffer.isNullAt(0);
/* 328 */         double agg_value27 = agg_isNull25 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 329 */         boolean agg_isNull24 = agg_isNull25;
/* 330 */         double agg_value26 = agg_value27;
/* 331 */         if (agg_isNull24) {
/* 332 */           boolean agg_isNull26 = false;
/* 333 */           double agg_value28 = -1.0;
/* 334 */           if (!false) {
/* 335 */             agg_value28 = (double) 0;
/* 336 */           }
/* 337 */           if (!agg_isNull26) {
/* 338 */             agg_isNull24 = false;
/* 339 */             agg_value26 = agg_value28;
/* 340 */           }
/* 341 */         }
/* 342 */
/* 343 */         if (!inputadapter_isNull27) {
/* 344 */           agg_isNull23 = false; // resultCode could change nullability.
/* 345 */           agg_value25 = agg_value26 + inputadapter_value27;
/* 346 */
/* 347 */         }
/* 348 */         boolean agg_isNull22 = agg_isNull23;
/* 349 */         double agg_value24 = agg_value25;
/* 350 */         if (agg_isNull22) {
/* 351 */           boolean agg_isNull29 = agg_fastAggBuffer.isNullAt(0);
/* 352 */           double agg_value31 = agg_isNull29 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 353 */           if (!agg_isNull29) {
/* 354 */             agg_isNull22 = false;
/* 355 */             agg_value24 = agg_value31;
/* 356 */           }
/* 357 */         }
/* 358 */         boolean agg_isNull31 = true;
/* 359 */         double agg_value33 = -1.0;
/* 360 */
/* 361 */         boolean agg_isNull33 = agg_fastAggBuffer.isNullAt(1);
/* 362 */         double agg_value35 = agg_isNull33 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 363 */         boolean agg_isNull32 = agg_isNull33;
/* 364 */         double agg_value34 = agg_value35;
/* 365 */         if (agg_isNull32) {
/* 366 */           boolean agg_isNull34 = false;
/* 367 */           double agg_value36 = -1.0;
/* 368 */           if (!false) {
/* 369 */             agg_value36 = (double) 0;
/* 370 */           }
/* 371 */           if (!agg_isNull34) {
/* 372 */             agg_isNull32 = false;
/* 373 */             agg_value34 = agg_value36;
/* 374 */           }
/* 375 */         }
/* 376 */
/* 377 */         if (!inputadapter_isNull32) {
/* 378 */           agg_isNull31 = false; // resultCode could change nullability.
/* 379 */           agg_value33 = agg_value34 + inputadapter_value32;
/* 380 */
/* 381 */         }
/* 382 */         boolean agg_isNull30 = agg_isNull31;
/* 383 */         double agg_value32 = agg_value33;
/* 384 */         if (agg_isNull30) {
/* 385 */           boolean agg_isNull37 = agg_fastAggBuffer.isNullAt(1);
/* 386 */           double agg_value39 = agg_isNull37 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 387 */           if (!agg_isNull37) {
/* 388 */             agg_isNull30 = false;
/* 389 */             agg_value32 = agg_value39;
/* 390 */           }
/* 391 */         }
/* 392 */         // update fast row
/* 393 */         if (!agg_isNull22) {
/* 394 */           agg_fastAggBuffer.setDouble(0, agg_value24);
/* 395 */         } else {
/* 396 */           agg_fastAggBuffer.setNullAt(0);
/* 397 */         }
/* 398 */
/* 399 */         if (!agg_isNull30) {
/* 400 */           agg_fastAggBuffer.setDouble(1, agg_value32);
/* 401 */         } else {
/* 402 */           agg_fastAggBuffer.setNullAt(1);
/* 403 */         }
/* 404 */
/* 405 */       } else {
/* 406 */         // update unsafe row
/* 407 */
/* 408 */         // common sub-expressions
/* 409 */
/* 410 */         // evaluate aggregate function
/* 411 */         boolean agg_isNull7 = true;
/* 412 */         double agg_value9 = -1.0;
/* 413 */
/* 414 */         boolean agg_isNull9 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 415 */         double agg_value11 = agg_isNull9 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 416 */         boolean agg_isNull8 = agg_isNull9;
/* 417 */         double agg_value10 = agg_value11;
/* 418 */         if (agg_isNull8) {
/* 419 */           boolean agg_isNull10 = false;
/* 420 */           double agg_value12 = -1.0;
/* 421 */           if (!false) {
/* 422 */             agg_value12 = (double) 0;
/* 423 */           }
/* 424 */           if (!agg_isNull10) {
/* 425 */             agg_isNull8 = false;
/* 426 */             agg_value10 = agg_value12;
/* 427 */           }
/* 428 */         }
/* 429 */
/* 430 */         if (!inputadapter_isNull27) {
/* 431 */           agg_isNull7 = false; // resultCode could change nullability.
/* 432 */           agg_value9 = agg_value10 + inputadapter_value27;
/* 433 */
/* 434 */         }
/* 435 */         boolean agg_isNull6 = agg_isNull7;
/* 436 */         double agg_value8 = agg_value9;
/* 437 */         if (agg_isNull6) {
/* 438 */           boolean agg_isNull13 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 439 */           double agg_value15 = agg_isNull13 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 440 */           if (!agg_isNull13) {
/* 441 */             agg_isNull6 = false;
/* 442 */             agg_value8 = agg_value15;
/* 443 */           }
/* 444 */         }
/* 445 */         boolean agg_isNull15 = true;
/* 446 */         double agg_value17 = -1.0;
/* 447 */
/* 448 */         boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 449 */         double agg_value19 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 450 */         boolean agg_isNull16 = agg_isNull17;
/* 451 */         double agg_value18 = agg_value19;
/* 452 */         if (agg_isNull16) {
/* 453 */           boolean agg_isNull18 = false;
/* 454 */           double agg_value20 = -1.0;
/* 455 */           if (!false) {
/* 456 */             agg_value20 = (double) 0;
/* 457 */           }
/* 458 */           if (!agg_isNull18) {
/* 459 */             agg_isNull16 = false;
/* 460 */             agg_value18 = agg_value20;
/* 461 */           }
/* 462 */         }
/* 463 */
/* 464 */         if (!inputadapter_isNull32) {
/* 465 */           agg_isNull15 = false; // resultCode could change nullability.
/* 466 */           agg_value17 = agg_value18 + inputadapter_value32;
/* 467 */
/* 468 */         }
/* 469 */         boolean agg_isNull14 = agg_isNull15;
/* 470 */         double agg_value16 = agg_value17;
/* 471 */         if (agg_isNull14) {
/* 472 */           boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 473 */           double agg_value23 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 474 */           if (!agg_isNull21) {
/* 475 */             agg_isNull14 = false;
/* 476 */             agg_value16 = agg_value23;
/* 477 */           }
/* 478 */         }
/* 479 */         // update unsafe row buffer
/* 480 */         if (!agg_isNull6) {
/* 481 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value8);
/* 482 */         } else {
/* 483 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 484 */         }
/* 485 */
/* 486 */         if (!agg_isNull14) {
/* 487 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value16);
/* 488 */         } else {
/* 489 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 490 */         }
/* 491 */
/* 492 */       }
/* 493 */       if (shouldStop()) return;
/* 494 */     }
/* 495 */
/* 496 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 497 */
/* 498 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 499 */   }
/* 500 */
/* 501 */   private void wholestagecodegen_init_2() {
/* 502 */     project_result2 = new UnsafeRow(4);
/* 503 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 504 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 4);
/* 505 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 506 */
/* 507 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 508 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 509 */
/* 510 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 511 */     bhj_result2 = new UnsafeRow(5);
/* 512 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 0);
/* 513 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 5);
/* 514 */     project_result3 = new UnsafeRow(3);
/* 515 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 0);
/* 516 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 3);
/* 517 */
/* 518 */   }
/* 519 */
/* 520 */   private void wholestagecodegen_init_1() {
/* 521 */     bhj_result = new UnsafeRow(7);
/* 522 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 523 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 524 */     project_result1 = new UnsafeRow(5);
/* 525 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 526 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 527 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 528 */
/* 529 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 530 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 531 */
/* 532 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 533 */     bhj_result1 = new UnsafeRow(6);
/* 534 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 535 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 6);
/* 536 */
/* 537 */   }
/* 538 */
/* 539 */   protected void processNext() throws java.io.IOException {
/* 540 */     if (!agg_initAgg) {
/* 541 */       agg_initAgg = true;
/* 542 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 543 */       agg_doAggregateWithKeys();
/* 544 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 545 */     }
/* 546 */
/* 547 */     // output the result
/* 548 */
/* 549 */     while (agg_fastHashMapIter.next()) {
/* 550 */       wholestagecodegen_numOutputRows.add(1);
/* 551 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 552 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 553 */
/* 554 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 555 */
/* 556 */       append(agg_resultRow);
/* 557 */
/* 558 */       if (shouldStop()) return;
/* 559 */     }
/* 560 */     agg_fastHashMap.close();
/* 561 */
/* 562 */     while (agg_mapIter.next()) {
/* 563 */       wholestagecodegen_numOutputRows.add(1);
/* 564 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 565 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 566 */
/* 567 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 568 */
/* 569 */       append(agg_resultRow);
/* 570 */
/* 571 */       if (shouldStop()) return;
/* 572 */     }
/* 573 */
/* 574 */     agg_mapIter.close();
/* 575 */     if (agg_sorter == null) {
/* 576 */       agg_hashMap.free();
/* 577 */     }
/* 578 */   }
/* 579 */ }
