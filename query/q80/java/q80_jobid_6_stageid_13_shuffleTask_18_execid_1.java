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
/* 045 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 046 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 047 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 048 */   private UnsafeRow bhj_result2;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 051 */   private UnsafeRow project_result3;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 054 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 055 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 056 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 057 */   private UnsafeRow bhj_result3;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 060 */   private UnsafeRow project_result4;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 063 */   private UnsafeRow agg_result1;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 066 */   private int agg_value8;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 068 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 069 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 070 */
/* 071 */   public GeneratedIterator(Object[] references) {
/* 072 */     this.references = references;
/* 073 */   }
/* 074 */
/* 075 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 076 */     partitionIndex = index;
/* 077 */     this.inputs = inputs;
/* 078 */     wholestagecodegen_init_0();
/* 079 */     wholestagecodegen_init_1();
/* 080 */     wholestagecodegen_init_2();
/* 081 */     wholestagecodegen_init_3();
/* 082 */     wholestagecodegen_init_4();
/* 083 */
/* 084 */   }
/* 085 */
/* 086 */   private void wholestagecodegen_init_0() {
/* 087 */     agg_initAgg = false;
/* 088 */
/* 089 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 090 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 091 */
/* 092 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 093 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 094 */     inputadapter_input = inputs[0];
/* 095 */     project_result = new UnsafeRow(8);
/* 096 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 097 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
/* 098 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 099 */
/* 100 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 101 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 102 */
/* 103 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 104 */
/* 105 */   }
/* 106 */
/* 107 */   private void wholestagecodegen_init_3() {
/* 108 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[9];
/* 109 */
/* 110 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 111 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 112 */
/* 113 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 114 */     bhj_result3 = new UnsafeRow(7);
/* 115 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 32);
/* 116 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 7);
/* 117 */     project_result4 = new UnsafeRow(5);
/* 118 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 32);
/* 119 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 5);
/* 120 */     agg_result1 = new UnsafeRow(1);
/* 121 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 122 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 123 */
/* 124 */   }
/* 125 */
/* 126 */   public class agg_FastHashMap {
/* 127 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 128 */     private int[] buckets;
/* 129 */     private int capacity = 1 << 16;
/* 130 */     private double loadFactor = 0.5;
/* 131 */     private int numBuckets = (int) (capacity / loadFactor);
/* 132 */     private int maxSteps = 2;
/* 133 */     private int numRows = 0;
/* 134 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("cp_catalog_page_id", org.apache.spark.sql.types.DataTypes.StringType);
/* 135 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 136 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 137 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 138 */     private Object emptyVBase;
/* 139 */     private long emptyVOff;
/* 140 */     private int emptyVLen;
/* 141 */     private boolean isBatchFull = false;
/* 142 */
/* 143 */     public agg_FastHashMap(
/* 144 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 145 */       InternalRow emptyAggregationBuffer) {
/* 146 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 147 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 148 */
/* 149 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 150 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 151 */
/* 152 */       emptyVBase = emptyBuffer;
/* 153 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 154 */       emptyVLen = emptyBuffer.length;
/* 155 */
/* 156 */       buckets = new int[numBuckets];
/* 157 */       java.util.Arrays.fill(buckets, -1);
/* 158 */     }
/* 159 */
/* 160 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key) {
/* 161 */       long h = hash(agg_key);
/* 162 */       int step = 0;
/* 163 */       int idx = (int) h & (numBuckets - 1);
/* 164 */       while (step < maxSteps) {
/* 165 */         // Return bucket index if it's either an empty slot or already contains the key
/* 166 */         if (buckets[idx] == -1) {
/* 167 */           if (numRows < capacity && !isBatchFull) {
/* 168 */             // creating the unsafe for new entry
/* 169 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 170 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 171 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 172 */               32);
/* 173 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 174 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 175 */               agg_holder,
/* 176 */               1);
/* 177 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 178 */             agg_rowWriter.zeroOutNullBytes();
/* 179 */             agg_rowWriter.write(0, agg_key);
/* 180 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 181 */             Object kbase = agg_result.getBaseObject();
/* 182 */             long koff = agg_result.getBaseOffset();
/* 183 */             int klen = agg_result.getSizeInBytes();
/* 184 */
/* 185 */             UnsafeRow vRow
/* 186 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 187 */             if (vRow == null) {
/* 188 */               isBatchFull = true;
/* 189 */             } else {
/* 190 */               buckets[idx] = numRows++;
/* 191 */             }
/* 192 */             return vRow;
/* 193 */           } else {
/* 194 */             // No more space
/* 195 */             return null;
/* 196 */           }
/* 197 */         } else if (equals(idx, agg_key)) {
/* 198 */           return batch.getValueRow(buckets[idx]);
/* 199 */         }
/* 200 */         idx = (idx + 1) & (numBuckets - 1);
/* 201 */         step++;
/* 202 */       }
/* 203 */       // Didn't find it
/* 204 */       return null;
/* 205 */     }
/* 206 */
/* 207 */     private boolean equals(int idx, UTF8String agg_key) {
/* 208 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 209 */       return (row.getUTF8String(0).equals(agg_key));
/* 210 */     }
/* 211 */
/* 212 */     private long hash(UTF8String agg_key) {
/* 213 */       long agg_hash = 0;
/* 214 */
/* 215 */       int agg_result = 0;
/* 216 */       byte[] agg_bytes = agg_key.getBytes();
/* 217 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 218 */         int agg_hash1 = agg_bytes[i];
/* 219 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 220 */       }
/* 221 */
/* 222 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 223 */
/* 224 */       return agg_hash;
/* 225 */     }
/* 226 */
/* 227 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 228 */       return batch.rowIterator();
/* 229 */     }
/* 230 */
/* 231 */     public void close() {
/* 232 */       batch.close();
/* 233 */     }
/* 234 */
/* 235 */   }
/* 236 */
/* 237 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 238 */     agg_hashMap = agg_plan.createHashMap();
/* 239 */
/* 240 */     while (inputadapter_input.hasNext()) {
/* 241 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 242 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 243 */       int inputadapter_value6 = inputadapter_isNull6 ? -1 : (inputadapter_row.getInt(6));
/* 244 */
/* 245 */       // generate join key for stream side
/* 246 */
/* 247 */       boolean bhj_isNull = inputadapter_isNull6;
/* 248 */       long bhj_value = -1L;
/* 249 */       if (!inputadapter_isNull6) {
/* 250 */         bhj_value = (long) inputadapter_value6;
/* 251 */       }
/* 252 */       // find matches from HashedRelation
/* 253 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 254 */       if (bhj_matched == null) continue;
/* 255 */
/* 256 */       bhj_numOutputRows.add(1);
/* 257 */
/* 258 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 259 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 260 */
/* 261 */       // generate join key for stream side
/* 262 */
/* 263 */       boolean bhj_isNull12 = inputadapter_isNull;
/* 264 */       long bhj_value12 = -1L;
/* 265 */       if (!inputadapter_isNull) {
/* 266 */         bhj_value12 = (long) inputadapter_value;
/* 267 */       }
/* 268 */       // find matches from HashedRelation
/* 269 */       UnsafeRow bhj_matched1 = bhj_isNull12 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value12);
/* 270 */       if (bhj_matched1 == null) continue;
/* 271 */
/* 272 */       bhj_numOutputRows1.add(1);
/* 273 */
/* 274 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 275 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 276 */
/* 277 */       // generate join key for stream side
/* 278 */
/* 279 */       boolean bhj_isNull25 = inputadapter_isNull1;
/* 280 */       long bhj_value25 = -1L;
/* 281 */       if (!inputadapter_isNull1) {
/* 282 */         bhj_value25 = (long) inputadapter_value1;
/* 283 */       }
/* 284 */       // find matches from HashedRelation
/* 285 */       UnsafeRow bhj_matched2 = bhj_isNull25 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value25);
/* 286 */       if (bhj_matched2 == null) continue;
/* 287 */
/* 288 */       bhj_numOutputRows2.add(1);
/* 289 */
/* 290 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 291 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 292 */
/* 293 */       // generate join key for stream side
/* 294 */
/* 295 */       boolean bhj_isNull36 = inputadapter_isNull2;
/* 296 */       long bhj_value36 = -1L;
/* 297 */       if (!inputadapter_isNull2) {
/* 298 */         bhj_value36 = (long) inputadapter_value2;
/* 299 */       }
/* 300 */       // find matches from HashedRelation
/* 301 */       UnsafeRow bhj_matched3 = bhj_isNull36 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value36);
/* 302 */       if (bhj_matched3 == null) continue;
/* 303 */
/* 304 */       bhj_numOutputRows3.add(1);
/* 305 */
/* 306 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 307 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 308 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 309 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 310 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 311 */       double inputadapter_value9 = inputadapter_isNull9 ? -1.0 : (inputadapter_row.getDouble(9));
/* 312 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 313 */       double inputadapter_value10 = inputadapter_isNull10 ? -1.0 : (inputadapter_row.getDouble(10));
/* 314 */       boolean bhj_isNull15 = bhj_matched1.isNullAt(1);
/* 315 */       UTF8String bhj_value15 = bhj_isNull15 ? null : (bhj_matched1.getUTF8String(1));
/* 316 */
/* 317 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 318 */
/* 319 */       UnsafeRow agg_fastAggBuffer = null;
/* 320 */
/* 321 */       if (true) {
/* 322 */         if (!bhj_isNull15) {
/* 323 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 324 */             bhj_value15);
/* 325 */         }
/* 326 */       }
/* 327 */
/* 328 */       if (agg_fastAggBuffer == null) {
/* 329 */         // generate grouping key
/* 330 */         agg_holder.reset();
/* 331 */
/* 332 */         agg_rowWriter.zeroOutNullBytes();
/* 333 */
/* 334 */         if (bhj_isNull15) {
/* 335 */           agg_rowWriter.setNullAt(0);
/* 336 */         } else {
/* 337 */           agg_rowWriter.write(0, bhj_value15);
/* 338 */         }
/* 339 */         agg_result1.setTotalSize(agg_holder.totalSize());
/* 340 */         agg_value8 = 42;
/* 341 */
/* 342 */         if (!bhj_isNull15) {
/* 343 */           agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value15.getBaseObject(), bhj_value15.getBaseOffset(), bhj_value15.numBytes(), agg_value8);
/* 344 */         }
/* 345 */         if (true) {
/* 346 */           // try to get the buffer from hash map
/* 347 */           agg_unsafeRowAggBuffer =
/* 348 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value8);
/* 349 */         }
/* 350 */         if (agg_unsafeRowAggBuffer == null) {
/* 351 */           if (agg_sorter == null) {
/* 352 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 353 */           } else {
/* 354 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 355 */           }
/* 356 */
/* 357 */           // the hash map had be spilled, it should have enough memory now,
/* 358 */           // try  to allocate buffer again.
/* 359 */           agg_unsafeRowAggBuffer =
/* 360 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value8);
/* 361 */           if (agg_unsafeRowAggBuffer == null) {
/* 362 */             // failed to allocate the first page
/* 363 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 364 */           }
/* 365 */         }
/* 366 */       }
/* 367 */
/* 368 */       if (agg_fastAggBuffer != null) {
/* 369 */         // update fast row
/* 370 */
/* 371 */         // common sub-expressions
/* 372 */         boolean agg_isNull34 = false;
/* 373 */         double agg_value37 = -1.0;
/* 374 */         if (!false) {
/* 375 */           agg_value37 = (double) 0;
/* 376 */         }
/* 377 */         // evaluate aggregate function
/* 378 */         boolean agg_isNull37 = true;
/* 379 */         double agg_value40 = -1.0;
/* 380 */
/* 381 */         boolean agg_isNull39 = agg_fastAggBuffer.isNullAt(0);
/* 382 */         double agg_value42 = agg_isNull39 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 383 */         boolean agg_isNull38 = agg_isNull39;
/* 384 */         double agg_value41 = agg_value42;
/* 385 */         if (agg_isNull38) {
/* 386 */           if (!agg_isNull34) {
/* 387 */             agg_isNull38 = false;
/* 388 */             agg_value41 = agg_value37;
/* 389 */           }
/* 390 */         }
/* 391 */
/* 392 */         boolean agg_isNull40 = inputadapter_isNull4;
/* 393 */         double agg_value43 = -1.0;
/* 394 */         if (!inputadapter_isNull4) {
/* 395 */           agg_value43 = inputadapter_value4;
/* 396 */         }
/* 397 */         if (!agg_isNull40) {
/* 398 */           agg_isNull37 = false; // resultCode could change nullability.
/* 399 */           agg_value40 = agg_value41 + agg_value43;
/* 400 */
/* 401 */         }
/* 402 */         boolean agg_isNull36 = agg_isNull37;
/* 403 */         double agg_value39 = agg_value40;
/* 404 */         if (agg_isNull36) {
/* 405 */           boolean agg_isNull42 = agg_fastAggBuffer.isNullAt(0);
/* 406 */           double agg_value45 = agg_isNull42 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 407 */           if (!agg_isNull42) {
/* 408 */             agg_isNull36 = false;
/* 409 */             agg_value39 = agg_value45;
/* 410 */           }
/* 411 */         }
/* 412 */         boolean agg_isNull43 = false;
/* 413 */
/* 414 */         boolean agg_isNull45 = agg_fastAggBuffer.isNullAt(1);
/* 415 */         double agg_value48 = agg_isNull45 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 416 */         boolean agg_isNull44 = agg_isNull45;
/* 417 */         double agg_value47 = agg_value48;
/* 418 */         if (agg_isNull44) {
/* 419 */           if (!agg_isNull34) {
/* 420 */             agg_isNull44 = false;
/* 421 */             agg_value47 = agg_value37;
/* 422 */           }
/* 423 */         }
/* 424 */
/* 425 */         boolean agg_isNull47 = inputadapter_isNull9;
/* 426 */         double agg_value50 = inputadapter_value9;
/* 427 */         if (agg_isNull47) {
/* 428 */           if (!false) {
/* 429 */             agg_isNull47 = false;
/* 430 */             agg_value50 = 0.0D;
/* 431 */           }
/* 432 */         }
/* 433 */         boolean agg_isNull46 = agg_isNull47;
/* 434 */         double agg_value49 = -1.0;
/* 435 */         if (!agg_isNull47) {
/* 436 */           agg_value49 = agg_value50;
/* 437 */         }
/* 438 */         double agg_value46 = -1.0;
/* 439 */         agg_value46 = agg_value47 + agg_value49;
/* 440 */         boolean agg_isNull51 = true;
/* 441 */         double agg_value54 = -1.0;
/* 442 */
/* 443 */         boolean agg_isNull53 = agg_fastAggBuffer.isNullAt(2);
/* 444 */         double agg_value56 = agg_isNull53 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 445 */         boolean agg_isNull52 = agg_isNull53;
/* 446 */         double agg_value55 = agg_value56;
/* 447 */         if (agg_isNull52) {
/* 448 */           if (!agg_isNull34) {
/* 449 */             agg_isNull52 = false;
/* 450 */             agg_value55 = agg_value37;
/* 451 */           }
/* 452 */         }
/* 453 */
/* 454 */         boolean agg_isNull55 = true;
/* 455 */         double agg_value58 = -1.0;
/* 456 */
/* 457 */         if (!inputadapter_isNull5) {
/* 458 */           boolean agg_isNull57 = inputadapter_isNull10;
/* 459 */           double agg_value60 = inputadapter_value10;
/* 460 */           if (agg_isNull57) {
/* 461 */             if (!false) {
/* 462 */               agg_isNull57 = false;
/* 463 */               agg_value60 = 0.0D;
/* 464 */             }
/* 465 */           }
/* 466 */
/* 467 */           agg_isNull55 = false; // resultCode could change nullability.
/* 468 */           agg_value58 = inputadapter_value5 - agg_value60;
/* 469 */
/* 470 */         }
/* 471 */         boolean agg_isNull54 = agg_isNull55;
/* 472 */         double agg_value57 = -1.0;
/* 473 */         if (!agg_isNull55) {
/* 474 */           agg_value57 = agg_value58;
/* 475 */         }
/* 476 */         if (!agg_isNull54) {
/* 477 */           agg_isNull51 = false; // resultCode could change nullability.
/* 478 */           agg_value54 = agg_value55 + agg_value57;
/* 479 */
/* 480 */         }
/* 481 */         boolean agg_isNull50 = agg_isNull51;
/* 482 */         double agg_value53 = agg_value54;
/* 483 */         if (agg_isNull50) {
/* 484 */           boolean agg_isNull60 = agg_fastAggBuffer.isNullAt(2);
/* 485 */           double agg_value63 = agg_isNull60 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 486 */           if (!agg_isNull60) {
/* 487 */             agg_isNull50 = false;
/* 488 */             agg_value53 = agg_value63;
/* 489 */           }
/* 490 */         }
/* 491 */         // update fast row
/* 492 */         if (!agg_isNull36) {
/* 493 */           agg_fastAggBuffer.setDouble(0, agg_value39);
/* 494 */         } else {
/* 495 */           agg_fastAggBuffer.setNullAt(0);
/* 496 */         }
/* 497 */
/* 498 */         agg_fastAggBuffer.setDouble(1, agg_value46);
/* 499 */
/* 500 */         if (!agg_isNull50) {
/* 501 */           agg_fastAggBuffer.setDouble(2, agg_value53);
/* 502 */         } else {
/* 503 */           agg_fastAggBuffer.setNullAt(2);
/* 504 */         }
/* 505 */
/* 506 */       } else {
/* 507 */         // update unsafe row
/* 508 */
/* 509 */         // common sub-expressions
/* 510 */         boolean agg_isNull7 = false;
/* 511 */         double agg_value10 = -1.0;
/* 512 */         if (!false) {
/* 513 */           agg_value10 = (double) 0;
/* 514 */         }
/* 515 */         // evaluate aggregate function
/* 516 */         boolean agg_isNull10 = true;
/* 517 */         double agg_value13 = -1.0;
/* 518 */
/* 519 */         boolean agg_isNull12 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 520 */         double agg_value15 = agg_isNull12 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 521 */         boolean agg_isNull11 = agg_isNull12;
/* 522 */         double agg_value14 = agg_value15;
/* 523 */         if (agg_isNull11) {
/* 524 */           if (!agg_isNull7) {
/* 525 */             agg_isNull11 = false;
/* 526 */             agg_value14 = agg_value10;
/* 527 */           }
/* 528 */         }
/* 529 */
/* 530 */         boolean agg_isNull13 = inputadapter_isNull4;
/* 531 */         double agg_value16 = -1.0;
/* 532 */         if (!inputadapter_isNull4) {
/* 533 */           agg_value16 = inputadapter_value4;
/* 534 */         }
/* 535 */         if (!agg_isNull13) {
/* 536 */           agg_isNull10 = false; // resultCode could change nullability.
/* 537 */           agg_value13 = agg_value14 + agg_value16;
/* 538 */
/* 539 */         }
/* 540 */         boolean agg_isNull9 = agg_isNull10;
/* 541 */         double agg_value12 = agg_value13;
/* 542 */         if (agg_isNull9) {
/* 543 */           boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 544 */           double agg_value18 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 545 */           if (!agg_isNull15) {
/* 546 */             agg_isNull9 = false;
/* 547 */             agg_value12 = agg_value18;
/* 548 */           }
/* 549 */         }
/* 550 */         boolean agg_isNull16 = false;
/* 551 */
/* 552 */         boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 553 */         double agg_value21 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 554 */         boolean agg_isNull17 = agg_isNull18;
/* 555 */         double agg_value20 = agg_value21;
/* 556 */         if (agg_isNull17) {
/* 557 */           if (!agg_isNull7) {
/* 558 */             agg_isNull17 = false;
/* 559 */             agg_value20 = agg_value10;
/* 560 */           }
/* 561 */         }
/* 562 */
/* 563 */         boolean agg_isNull20 = inputadapter_isNull9;
/* 564 */         double agg_value23 = inputadapter_value9;
/* 565 */         if (agg_isNull20) {
/* 566 */           if (!false) {
/* 567 */             agg_isNull20 = false;
/* 568 */             agg_value23 = 0.0D;
/* 569 */           }
/* 570 */         }
/* 571 */         boolean agg_isNull19 = agg_isNull20;
/* 572 */         double agg_value22 = -1.0;
/* 573 */         if (!agg_isNull20) {
/* 574 */           agg_value22 = agg_value23;
/* 575 */         }
/* 576 */         double agg_value19 = -1.0;
/* 577 */         agg_value19 = agg_value20 + agg_value22;
/* 578 */         boolean agg_isNull24 = true;
/* 579 */         double agg_value27 = -1.0;
/* 580 */
/* 581 */         boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 582 */         double agg_value29 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 583 */         boolean agg_isNull25 = agg_isNull26;
/* 584 */         double agg_value28 = agg_value29;
/* 585 */         if (agg_isNull25) {
/* 586 */           if (!agg_isNull7) {
/* 587 */             agg_isNull25 = false;
/* 588 */             agg_value28 = agg_value10;
/* 589 */           }
/* 590 */         }
/* 591 */
/* 592 */         boolean agg_isNull28 = true;
/* 593 */         double agg_value31 = -1.0;
/* 594 */
/* 595 */         if (!inputadapter_isNull5) {
/* 596 */           boolean agg_isNull30 = inputadapter_isNull10;
/* 597 */           double agg_value33 = inputadapter_value10;
/* 598 */           if (agg_isNull30) {
/* 599 */             if (!false) {
/* 600 */               agg_isNull30 = false;
/* 601 */               agg_value33 = 0.0D;
/* 602 */             }
/* 603 */           }
/* 604 */
/* 605 */           agg_isNull28 = false; // resultCode could change nullability.
/* 606 */           agg_value31 = inputadapter_value5 - agg_value33;
/* 607 */
/* 608 */         }
/* 609 */         boolean agg_isNull27 = agg_isNull28;
/* 610 */         double agg_value30 = -1.0;
/* 611 */         if (!agg_isNull28) {
/* 612 */           agg_value30 = agg_value31;
/* 613 */         }
/* 614 */         if (!agg_isNull27) {
/* 615 */           agg_isNull24 = false; // resultCode could change nullability.
/* 616 */           agg_value27 = agg_value28 + agg_value30;
/* 617 */
/* 618 */         }
/* 619 */         boolean agg_isNull23 = agg_isNull24;
/* 620 */         double agg_value26 = agg_value27;
/* 621 */         if (agg_isNull23) {
/* 622 */           boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 623 */           double agg_value36 = agg_isNull33 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 624 */           if (!agg_isNull33) {
/* 625 */             agg_isNull23 = false;
/* 626 */             agg_value26 = agg_value36;
/* 627 */           }
/* 628 */         }
/* 629 */         // update unsafe row buffer
/* 630 */         if (!agg_isNull9) {
/* 631 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value12);
/* 632 */         } else {
/* 633 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 634 */         }
/* 635 */
/* 636 */         agg_unsafeRowAggBuffer.setDouble(1, agg_value19);
/* 637 */
/* 638 */         if (!agg_isNull23) {
/* 639 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value26);
/* 640 */         } else {
/* 641 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 642 */         }
/* 643 */
/* 644 */       }
/* 645 */       if (shouldStop()) return;
/* 646 */     }
/* 647 */
/* 648 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 649 */
/* 650 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 651 */   }
/* 652 */
/* 653 */   private void wholestagecodegen_init_2() {
/* 654 */     project_result2 = new UnsafeRow(7);
/* 655 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 32);
/* 656 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 7);
/* 657 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[7];
/* 658 */
/* 659 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 660 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 661 */
/* 662 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 663 */     bhj_result2 = new UnsafeRow(8);
/* 664 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 32);
/* 665 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 8);
/* 666 */     project_result3 = new UnsafeRow(6);
/* 667 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 32);
/* 668 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 6);
/* 669 */
/* 670 */   }
/* 671 */
/* 672 */   private void wholestagecodegen_init_1() {
/* 673 */     bhj_result = new UnsafeRow(9);
/* 674 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 675 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 9);
/* 676 */     project_result1 = new UnsafeRow(7);
/* 677 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 678 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 7);
/* 679 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 680 */
/* 681 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 682 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 683 */
/* 684 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 685 */     bhj_result1 = new UnsafeRow(9);
/* 686 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 32);
/* 687 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 9);
/* 688 */
/* 689 */   }
/* 690 */
/* 691 */   private void wholestagecodegen_init_4() {
/* 692 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 693 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 694 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 695 */
/* 696 */   }
/* 697 */
/* 698 */   protected void processNext() throws java.io.IOException {
/* 699 */     if (!agg_initAgg) {
/* 700 */       agg_initAgg = true;
/* 701 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 702 */       agg_doAggregateWithKeys();
/* 703 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 704 */     }
/* 705 */
/* 706 */     // output the result
/* 707 */
/* 708 */     while (agg_fastHashMapIter.next()) {
/* 709 */       wholestagecodegen_numOutputRows.add(1);
/* 710 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 711 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 712 */
/* 713 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 714 */
/* 715 */       append(agg_resultRow);
/* 716 */
/* 717 */       if (shouldStop()) return;
/* 718 */     }
/* 719 */     agg_fastHashMap.close();
/* 720 */
/* 721 */     while (agg_mapIter.next()) {
/* 722 */       wholestagecodegen_numOutputRows.add(1);
/* 723 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 724 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 725 */
/* 726 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 727 */
/* 728 */       append(agg_resultRow);
/* 729 */
/* 730 */       if (shouldStop()) return;
/* 731 */     }
/* 732 */
/* 733 */     agg_mapIter.close();
/* 734 */     if (agg_sorter == null) {
/* 735 */       agg_hashMap.free();
/* 736 */     }
/* 737 */   }
/* 738 */ }
