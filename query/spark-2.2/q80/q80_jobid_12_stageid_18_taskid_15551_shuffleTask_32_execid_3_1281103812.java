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
/* 098 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[7];
/* 099 */
/* 100 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 101 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 102 */
/* 103 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 104 */
/* 105 */   }
/* 106 */
/* 107 */   private void wholestagecodegen_init_3() {
/* 108 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 109 */
/* 110 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 111 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 112 */
/* 113 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
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
/* 134 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType);
/* 135 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 136 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 137 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.DoubleType);
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
/* 240 */     while (inputadapter_input.hasNext() && !stopEarly()) {
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
/* 258 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 259 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 260 */
/* 261 */       // generate join key for stream side
/* 262 */
/* 263 */       boolean bhj_isNull12 = inputadapter_isNull1;
/* 264 */       long bhj_value12 = -1L;
/* 265 */       if (!inputadapter_isNull1) {
/* 266 */         bhj_value12 = (long) inputadapter_value1;
/* 267 */       }
/* 268 */       // find matches from HashedRelation
/* 269 */       UnsafeRow bhj_matched1 = bhj_isNull12 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value12);
/* 270 */       if (bhj_matched1 == null) continue;
/* 271 */
/* 272 */       bhj_numOutputRows1.add(1);
/* 273 */
/* 274 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 275 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 276 */
/* 277 */       // generate join key for stream side
/* 278 */
/* 279 */       boolean bhj_isNull25 = inputadapter_isNull;
/* 280 */       long bhj_value25 = -1L;
/* 281 */       if (!inputadapter_isNull) {
/* 282 */         bhj_value25 = (long) inputadapter_value;
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
/* 372 */
/* 373 */         // evaluate aggregate function
/* 374 */         boolean agg_isNull36 = true;
/* 375 */         double agg_value39 = -1.0;
/* 376 */
/* 377 */         boolean agg_isNull38 = agg_fastAggBuffer.isNullAt(0);
/* 378 */         double agg_value41 = agg_isNull38 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 379 */         boolean agg_isNull37 = agg_isNull38;
/* 380 */         double agg_value40 = agg_value41;
/* 381 */         if (agg_isNull37) {
/* 382 */           boolean agg_isNull39 = false;
/* 383 */           double agg_value42 = -1.0;
/* 384 */           if (!false) {
/* 385 */             agg_value42 = (double) 0;
/* 386 */           }
/* 387 */           if (!agg_isNull39) {
/* 388 */             agg_isNull37 = false;
/* 389 */             agg_value40 = agg_value42;
/* 390 */           }
/* 391 */         }
/* 392 */
/* 393 */         if (!inputadapter_isNull4) {
/* 394 */           agg_isNull36 = false; // resultCode could change nullability.
/* 395 */           agg_value39 = agg_value40 + inputadapter_value4;
/* 396 */
/* 397 */         }
/* 398 */         boolean agg_isNull35 = agg_isNull36;
/* 399 */         double agg_value38 = agg_value39;
/* 400 */         if (agg_isNull35) {
/* 401 */           boolean agg_isNull42 = agg_fastAggBuffer.isNullAt(0);
/* 402 */           double agg_value45 = agg_isNull42 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 403 */           if (!agg_isNull42) {
/* 404 */             agg_isNull35 = false;
/* 405 */             agg_value38 = agg_value45;
/* 406 */           }
/* 407 */         }
/* 408 */         boolean agg_isNull43 = false;
/* 409 */
/* 410 */         boolean agg_isNull45 = agg_fastAggBuffer.isNullAt(1);
/* 411 */         double agg_value48 = agg_isNull45 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 412 */         boolean agg_isNull44 = agg_isNull45;
/* 413 */         double agg_value47 = agg_value48;
/* 414 */         if (agg_isNull44) {
/* 415 */           boolean agg_isNull46 = false;
/* 416 */           double agg_value49 = -1.0;
/* 417 */           if (!false) {
/* 418 */             agg_value49 = (double) 0;
/* 419 */           }
/* 420 */           if (!agg_isNull46) {
/* 421 */             agg_isNull44 = false;
/* 422 */             agg_value47 = agg_value49;
/* 423 */           }
/* 424 */         }
/* 425 */
/* 426 */         boolean agg_isNull48 = inputadapter_isNull9;
/* 427 */         double agg_value51 = inputadapter_value9;
/* 428 */         if (agg_isNull48) {
/* 429 */           if (!false) {
/* 430 */             agg_isNull48 = false;
/* 431 */             agg_value51 = 0.0D;
/* 432 */           }
/* 433 */         }
/* 434 */         double agg_value46 = -1.0;
/* 435 */         agg_value46 = agg_value47 + agg_value51;
/* 436 */         boolean agg_isNull52 = true;
/* 437 */         double agg_value55 = -1.0;
/* 438 */
/* 439 */         boolean agg_isNull54 = agg_fastAggBuffer.isNullAt(2);
/* 440 */         double agg_value57 = agg_isNull54 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 441 */         boolean agg_isNull53 = agg_isNull54;
/* 442 */         double agg_value56 = agg_value57;
/* 443 */         if (agg_isNull53) {
/* 444 */           boolean agg_isNull55 = false;
/* 445 */           double agg_value58 = -1.0;
/* 446 */           if (!false) {
/* 447 */             agg_value58 = (double) 0;
/* 448 */           }
/* 449 */           if (!agg_isNull55) {
/* 450 */             agg_isNull53 = false;
/* 451 */             agg_value56 = agg_value58;
/* 452 */           }
/* 453 */         }
/* 454 */
/* 455 */         boolean agg_isNull57 = true;
/* 456 */         double agg_value60 = -1.0;
/* 457 */
/* 458 */         if (!inputadapter_isNull5) {
/* 459 */           boolean agg_isNull59 = inputadapter_isNull10;
/* 460 */           double agg_value62 = inputadapter_value10;
/* 461 */           if (agg_isNull59) {
/* 462 */             if (!false) {
/* 463 */               agg_isNull59 = false;
/* 464 */               agg_value62 = 0.0D;
/* 465 */             }
/* 466 */           }
/* 467 */
/* 468 */           agg_isNull57 = false; // resultCode could change nullability.
/* 469 */           agg_value60 = inputadapter_value5 - agg_value62;
/* 470 */
/* 471 */         }
/* 472 */         if (!agg_isNull57) {
/* 473 */           agg_isNull52 = false; // resultCode could change nullability.
/* 474 */           agg_value55 = agg_value56 + agg_value60;
/* 475 */
/* 476 */         }
/* 477 */         boolean agg_isNull51 = agg_isNull52;
/* 478 */         double agg_value54 = agg_value55;
/* 479 */         if (agg_isNull51) {
/* 480 */           boolean agg_isNull62 = agg_fastAggBuffer.isNullAt(2);
/* 481 */           double agg_value65 = agg_isNull62 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 482 */           if (!agg_isNull62) {
/* 483 */             agg_isNull51 = false;
/* 484 */             agg_value54 = agg_value65;
/* 485 */           }
/* 486 */         }
/* 487 */         // update fast row
/* 488 */         if (!agg_isNull35) {
/* 489 */           agg_fastAggBuffer.setDouble(0, agg_value38);
/* 490 */         } else {
/* 491 */           agg_fastAggBuffer.setNullAt(0);
/* 492 */         }
/* 493 */
/* 494 */         agg_fastAggBuffer.setDouble(1, agg_value46);
/* 495 */
/* 496 */         if (!agg_isNull51) {
/* 497 */           agg_fastAggBuffer.setDouble(2, agg_value54);
/* 498 */         } else {
/* 499 */           agg_fastAggBuffer.setNullAt(2);
/* 500 */         }
/* 501 */
/* 502 */       } else {
/* 503 */         // update unsafe row
/* 504 */
/* 505 */         // common sub-expressions
/* 506 */
/* 507 */         // evaluate aggregate function
/* 508 */         boolean agg_isNull8 = true;
/* 509 */         double agg_value11 = -1.0;
/* 510 */
/* 511 */         boolean agg_isNull10 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 512 */         double agg_value13 = agg_isNull10 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 513 */         boolean agg_isNull9 = agg_isNull10;
/* 514 */         double agg_value12 = agg_value13;
/* 515 */         if (agg_isNull9) {
/* 516 */           boolean agg_isNull11 = false;
/* 517 */           double agg_value14 = -1.0;
/* 518 */           if (!false) {
/* 519 */             agg_value14 = (double) 0;
/* 520 */           }
/* 521 */           if (!agg_isNull11) {
/* 522 */             agg_isNull9 = false;
/* 523 */             agg_value12 = agg_value14;
/* 524 */           }
/* 525 */         }
/* 526 */
/* 527 */         if (!inputadapter_isNull4) {
/* 528 */           agg_isNull8 = false; // resultCode could change nullability.
/* 529 */           agg_value11 = agg_value12 + inputadapter_value4;
/* 530 */
/* 531 */         }
/* 532 */         boolean agg_isNull7 = agg_isNull8;
/* 533 */         double agg_value10 = agg_value11;
/* 534 */         if (agg_isNull7) {
/* 535 */           boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 536 */           double agg_value17 = agg_isNull14 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 537 */           if (!agg_isNull14) {
/* 538 */             agg_isNull7 = false;
/* 539 */             agg_value10 = agg_value17;
/* 540 */           }
/* 541 */         }
/* 542 */         boolean agg_isNull15 = false;
/* 543 */
/* 544 */         boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 545 */         double agg_value20 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 546 */         boolean agg_isNull16 = agg_isNull17;
/* 547 */         double agg_value19 = agg_value20;
/* 548 */         if (agg_isNull16) {
/* 549 */           boolean agg_isNull18 = false;
/* 550 */           double agg_value21 = -1.0;
/* 551 */           if (!false) {
/* 552 */             agg_value21 = (double) 0;
/* 553 */           }
/* 554 */           if (!agg_isNull18) {
/* 555 */             agg_isNull16 = false;
/* 556 */             agg_value19 = agg_value21;
/* 557 */           }
/* 558 */         }
/* 559 */
/* 560 */         boolean agg_isNull20 = inputadapter_isNull9;
/* 561 */         double agg_value23 = inputadapter_value9;
/* 562 */         if (agg_isNull20) {
/* 563 */           if (!false) {
/* 564 */             agg_isNull20 = false;
/* 565 */             agg_value23 = 0.0D;
/* 566 */           }
/* 567 */         }
/* 568 */         double agg_value18 = -1.0;
/* 569 */         agg_value18 = agg_value19 + agg_value23;
/* 570 */         boolean agg_isNull24 = true;
/* 571 */         double agg_value27 = -1.0;
/* 572 */
/* 573 */         boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 574 */         double agg_value29 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 575 */         boolean agg_isNull25 = agg_isNull26;
/* 576 */         double agg_value28 = agg_value29;
/* 577 */         if (agg_isNull25) {
/* 578 */           boolean agg_isNull27 = false;
/* 579 */           double agg_value30 = -1.0;
/* 580 */           if (!false) {
/* 581 */             agg_value30 = (double) 0;
/* 582 */           }
/* 583 */           if (!agg_isNull27) {
/* 584 */             agg_isNull25 = false;
/* 585 */             agg_value28 = agg_value30;
/* 586 */           }
/* 587 */         }
/* 588 */
/* 589 */         boolean agg_isNull29 = true;
/* 590 */         double agg_value32 = -1.0;
/* 591 */
/* 592 */         if (!inputadapter_isNull5) {
/* 593 */           boolean agg_isNull31 = inputadapter_isNull10;
/* 594 */           double agg_value34 = inputadapter_value10;
/* 595 */           if (agg_isNull31) {
/* 596 */             if (!false) {
/* 597 */               agg_isNull31 = false;
/* 598 */               agg_value34 = 0.0D;
/* 599 */             }
/* 600 */           }
/* 601 */
/* 602 */           agg_isNull29 = false; // resultCode could change nullability.
/* 603 */           agg_value32 = inputadapter_value5 - agg_value34;
/* 604 */
/* 605 */         }
/* 606 */         if (!agg_isNull29) {
/* 607 */           agg_isNull24 = false; // resultCode could change nullability.
/* 608 */           agg_value27 = agg_value28 + agg_value32;
/* 609 */
/* 610 */         }
/* 611 */         boolean agg_isNull23 = agg_isNull24;
/* 612 */         double agg_value26 = agg_value27;
/* 613 */         if (agg_isNull23) {
/* 614 */           boolean agg_isNull34 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 615 */           double agg_value37 = agg_isNull34 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 616 */           if (!agg_isNull34) {
/* 617 */             agg_isNull23 = false;
/* 618 */             agg_value26 = agg_value37;
/* 619 */           }
/* 620 */         }
/* 621 */         // update unsafe row buffer
/* 622 */         if (!agg_isNull7) {
/* 623 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value10);
/* 624 */         } else {
/* 625 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 626 */         }
/* 627 */
/* 628 */         agg_unsafeRowAggBuffer.setDouble(1, agg_value18);
/* 629 */
/* 630 */         if (!agg_isNull23) {
/* 631 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value26);
/* 632 */         } else {
/* 633 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 634 */         }
/* 635 */
/* 636 */       }
/* 637 */       if (shouldStop()) return;
/* 638 */     }
/* 639 */
/* 640 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 641 */
/* 642 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 643 */   }
/* 644 */
/* 645 */   private void wholestagecodegen_init_2() {
/* 646 */     project_result2 = new UnsafeRow(7);
/* 647 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 32);
/* 648 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 7);
/* 649 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[11];
/* 650 */
/* 651 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 652 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 653 */
/* 654 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 655 */     bhj_result2 = new UnsafeRow(8);
/* 656 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 32);
/* 657 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 8);
/* 658 */     project_result3 = new UnsafeRow(6);
/* 659 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 32);
/* 660 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 6);
/* 661 */
/* 662 */   }
/* 663 */
/* 664 */   private void wholestagecodegen_init_1() {
/* 665 */     bhj_result = new UnsafeRow(9);
/* 666 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 667 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 9);
/* 668 */     project_result1 = new UnsafeRow(7);
/* 669 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 670 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 7);
/* 671 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[9];
/* 672 */
/* 673 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 674 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 675 */
/* 676 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 677 */     bhj_result1 = new UnsafeRow(9);
/* 678 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 32);
/* 679 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 9);
/* 680 */
/* 681 */   }
/* 682 */
/* 683 */   private void wholestagecodegen_init_4() {
/* 684 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 685 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 686 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 687 */
/* 688 */   }
/* 689 */
/* 690 */   protected void processNext() throws java.io.IOException {
/* 691 */     if (!agg_initAgg) {
/* 692 */       agg_initAgg = true;
/* 693 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 694 */       agg_doAggregateWithKeys();
/* 695 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 696 */     }
/* 697 */
/* 698 */     // output the result
/* 699 */
/* 700 */     while (agg_fastHashMapIter.next()) {
/* 701 */       wholestagecodegen_numOutputRows.add(1);
/* 702 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 703 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 704 */
/* 705 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 706 */
/* 707 */       append(agg_resultRow);
/* 708 */
/* 709 */       if (shouldStop()) return;
/* 710 */     }
/* 711 */     agg_fastHashMap.close();
/* 712 */
/* 713 */     while (agg_mapIter.next()) {
/* 714 */       wholestagecodegen_numOutputRows.add(1);
/* 715 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 716 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 717 */
/* 718 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 719 */
/* 720 */       append(agg_resultRow);
/* 721 */
/* 722 */       if (shouldStop()) return;
/* 723 */     }
/* 724 */
/* 725 */     agg_mapIter.close();
/* 726 */     if (agg_sorter == null) {
/* 727 */       agg_hashMap.free();
/* 728 */     }
/* 729 */   }
/* 730 */ }
