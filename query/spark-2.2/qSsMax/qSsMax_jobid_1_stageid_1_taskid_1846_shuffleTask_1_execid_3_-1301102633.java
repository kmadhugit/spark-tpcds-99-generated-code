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
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private int agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private int agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private int agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private int agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private int agg_bufValue6;
/* 023 */   private boolean agg_bufIsNull7;
/* 024 */   private int agg_bufValue7;
/* 025 */   private boolean agg_bufIsNull8;
/* 026 */   private int agg_bufValue8;
/* 027 */   private boolean agg_bufIsNull9;
/* 028 */   private int agg_bufValue9;
/* 029 */   private boolean agg_bufIsNull10;
/* 030 */   private int agg_bufValue10;
/* 031 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 032 */   private agg_FastHashMap agg_fastHashMap;
/* 033 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 034 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 035 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 036 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 037 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 039 */   private scala.collection.Iterator scan_input;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 042 */   private long scan_scanTime1;
/* 043 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 044 */   private int scan_batchIdx;
/* 045 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 046 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 047 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 048 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 049 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 050 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 051 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 052 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 053 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance8;
/* 054 */   private UnsafeRow scan_result;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 057 */   private UnsafeRow agg_result1;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 060 */   private int agg_value24;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 062 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 063 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 064 */
/* 065 */   public GeneratedIterator(Object[] references) {
/* 066 */     this.references = references;
/* 067 */   }
/* 068 */
/* 069 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 070 */     partitionIndex = index;
/* 071 */     this.inputs = inputs;
/* 072 */     wholestagecodegen_init_0();
/* 073 */     wholestagecodegen_init_1();
/* 074 */
/* 075 */   }
/* 076 */
/* 077 */   private void wholestagecodegen_init_0() {
/* 078 */     agg_initAgg = false;
/* 079 */
/* 080 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 081 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 082 */
/* 083 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 084 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 085 */     scan_input = inputs[0];
/* 086 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 087 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 088 */     scan_scanTime1 = 0;
/* 089 */     scan_batch = null;
/* 090 */     scan_batchIdx = 0;
/* 091 */     scan_colInstance0 = null;
/* 092 */     scan_colInstance1 = null;
/* 093 */     scan_colInstance2 = null;
/* 094 */     scan_colInstance3 = null;
/* 095 */     scan_colInstance4 = null;
/* 096 */     scan_colInstance5 = null;
/* 097 */     scan_colInstance6 = null;
/* 098 */     scan_colInstance7 = null;
/* 099 */     scan_colInstance8 = null;
/* 100 */     scan_result = new UnsafeRow(9);
/* 101 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 102 */
/* 103 */   }
/* 104 */
/* 105 */   private void scan_nextBatch() throws java.io.IOException {
/* 106 */     long getBatchStart = System.nanoTime();
/* 107 */     if (scan_input.hasNext()) {
/* 108 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 109 */       scan_numOutputRows.add(scan_batch.numRows());
/* 110 */       scan_batchIdx = 0;
/* 111 */       scan_colInstance0 = scan_batch.column(0);
/* 112 */       scan_colInstance1 = scan_batch.column(1);
/* 113 */       scan_colInstance2 = scan_batch.column(2);
/* 114 */       scan_colInstance3 = scan_batch.column(3);
/* 115 */       scan_colInstance4 = scan_batch.column(4);
/* 116 */       scan_colInstance5 = scan_batch.column(5);
/* 117 */       scan_colInstance6 = scan_batch.column(6);
/* 118 */       scan_colInstance7 = scan_batch.column(7);
/* 119 */       scan_colInstance8 = scan_batch.column(8);
/* 120 */
/* 121 */     }
/* 122 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 123 */   }
/* 124 */
/* 125 */   public class agg_FastHashMap {
/* 126 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 127 */     private int[] buckets;
/* 128 */     private int capacity = 1 << 16;
/* 129 */     private double loadFactor = 0.5;
/* 130 */     private int numBuckets = (int) (capacity / loadFactor);
/* 131 */     private int maxSteps = 2;
/* 132 */     private int numRows = 0;
/* 133 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 134 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.LongType)
/* 135 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.LongType)
/* 136 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 137 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 138 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 139 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 140 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 141 */     .add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 142 */     .add("((java.lang.String) references[12])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 143 */     .add("((java.lang.String) references[13])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 144 */     .add("((java.lang.String) references[14])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 145 */     private Object emptyVBase;
/* 146 */     private long emptyVOff;
/* 147 */     private int emptyVLen;
/* 148 */     private boolean isBatchFull = false;
/* 149 */
/* 150 */     public agg_FastHashMap(
/* 151 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 152 */       InternalRow emptyAggregationBuffer) {
/* 153 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 154 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 155 */
/* 156 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 157 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 158 */
/* 159 */       emptyVBase = emptyBuffer;
/* 160 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 161 */       emptyVLen = emptyBuffer.length;
/* 162 */
/* 163 */       buckets = new int[numBuckets];
/* 164 */       java.util.Arrays.fill(buckets, -1);
/* 165 */     }
/* 166 */
/* 167 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 168 */       long h = hash(agg_key);
/* 169 */       int step = 0;
/* 170 */       int idx = (int) h & (numBuckets - 1);
/* 171 */       while (step < maxSteps) {
/* 172 */         // Return bucket index if it's either an empty slot or already contains the key
/* 173 */         if (buckets[idx] == -1) {
/* 174 */           if (numRows < capacity && !isBatchFull) {
/* 175 */             // creating the unsafe for new entry
/* 176 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 177 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 178 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 179 */               0);
/* 180 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 181 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 182 */               agg_holder,
/* 183 */               1);
/* 184 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 185 */             agg_rowWriter.zeroOutNullBytes();
/* 186 */             agg_rowWriter.write(0, agg_key);
/* 187 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 188 */             Object kbase = agg_result.getBaseObject();
/* 189 */             long koff = agg_result.getBaseOffset();
/* 190 */             int klen = agg_result.getSizeInBytes();
/* 191 */
/* 192 */             UnsafeRow vRow
/* 193 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 194 */             if (vRow == null) {
/* 195 */               isBatchFull = true;
/* 196 */             } else {
/* 197 */               buckets[idx] = numRows++;
/* 198 */             }
/* 199 */             return vRow;
/* 200 */           } else {
/* 201 */             // No more space
/* 202 */             return null;
/* 203 */           }
/* 204 */         } else if (equals(idx, agg_key)) {
/* 205 */           return batch.getValueRow(buckets[idx]);
/* 206 */         }
/* 207 */         idx = (idx + 1) & (numBuckets - 1);
/* 208 */         step++;
/* 209 */       }
/* 210 */       // Didn't find it
/* 211 */       return null;
/* 212 */     }
/* 213 */
/* 214 */     private boolean equals(int idx, int agg_key) {
/* 215 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 216 */       return (row.getInt(0) == agg_key);
/* 217 */     }
/* 218 */
/* 219 */     private long hash(int agg_key) {
/* 220 */       long agg_hash = 0;
/* 221 */
/* 222 */       int agg_result = agg_key;
/* 223 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 224 */
/* 225 */       return agg_hash;
/* 226 */     }
/* 227 */
/* 228 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 229 */       return batch.rowIterator();
/* 230 */     }
/* 231 */
/* 232 */     public void close() {
/* 233 */       batch.close();
/* 234 */     }
/* 235 */
/* 236 */   }
/* 237 */
/* 238 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 239 */     agg_hashMap = agg_plan.createHashMap();
/* 240 */
/* 241 */     if (scan_batch == null) {
/* 242 */       scan_nextBatch();
/* 243 */     }
/* 244 */     while (scan_batch != null) {
/* 245 */       int scan_numRows = scan_batch.numRows();
/* 246 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 247 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 248 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 249 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 250 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 251 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 252 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 253 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 254 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 255 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 256 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 257 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 258 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 259 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 260 */         int scan_value5 = scan_isNull5 ? -1 : (scan_colInstance5.getInt(scan_rowIdx));
/* 261 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 262 */         int scan_value6 = scan_isNull6 ? -1 : (scan_colInstance6.getInt(scan_rowIdx));
/* 263 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 264 */         int scan_value7 = scan_isNull7 ? -1 : (scan_colInstance7.getInt(scan_rowIdx));
/* 265 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 266 */         int scan_value8 = scan_isNull8 ? -1 : (scan_colInstance8.getInt(scan_rowIdx));
/* 267 */
/* 268 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 269 */
/* 270 */         UnsafeRow agg_fastAggBuffer = null;
/* 271 */
/* 272 */         if (true) {
/* 273 */           if (!scan_isNull8) {
/* 274 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 275 */               scan_value8);
/* 276 */           }
/* 277 */         }
/* 278 */
/* 279 */         if (agg_fastAggBuffer == null) {
/* 280 */           // generate grouping key
/* 281 */           agg_rowWriter.zeroOutNullBytes();
/* 282 */
/* 283 */           if (scan_isNull8) {
/* 284 */             agg_rowWriter.setNullAt(0);
/* 285 */           } else {
/* 286 */             agg_rowWriter.write(0, scan_value8);
/* 287 */           }
/* 288 */           agg_value24 = 42;
/* 289 */
/* 290 */           if (!scan_isNull8) {
/* 291 */             agg_value24 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value8, agg_value24);
/* 292 */           }
/* 293 */           if (true) {
/* 294 */             // try to get the buffer from hash map
/* 295 */             agg_unsafeRowAggBuffer =
/* 296 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value24);
/* 297 */           }
/* 298 */           if (agg_unsafeRowAggBuffer == null) {
/* 299 */             if (agg_sorter == null) {
/* 300 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 301 */             } else {
/* 302 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 303 */             }
/* 304 */
/* 305 */             // the hash map had be spilled, it should have enough memory now,
/* 306 */             // try  to allocate buffer again.
/* 307 */             agg_unsafeRowAggBuffer =
/* 308 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value24);
/* 309 */             if (agg_unsafeRowAggBuffer == null) {
/* 310 */               // failed to allocate the first page
/* 311 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 312 */             }
/* 313 */           }
/* 314 */         }
/* 315 */
/* 316 */         if (agg_fastAggBuffer != null) {
/* 317 */           // update fast row
/* 318 */
/* 319 */           // common sub-expressions
/* 320 */
/* 321 */           // evaluate aggregate function
/* 322 */           boolean agg_isNull52 = false;
/* 323 */
/* 324 */           long agg_value64 = agg_fastAggBuffer.getLong(0);
/* 325 */
/* 326 */           long agg_value63 = -1L;
/* 327 */           agg_value63 = agg_value64 + 1L;
/* 328 */           boolean agg_isNull55 = false;
/* 329 */           long agg_value66 = -1L;
/* 330 */           if (!false && scan_isNull8) {
/* 331 */             long agg_value69 = agg_fastAggBuffer.getLong(1);
/* 332 */             agg_isNull55 = false;
/* 333 */             agg_value66 = agg_value69;
/* 334 */           } else {
/* 335 */             boolean agg_isNull59 = false;
/* 336 */
/* 337 */             long agg_value71 = agg_fastAggBuffer.getLong(1);
/* 338 */
/* 339 */             long agg_value70 = -1L;
/* 340 */             agg_value70 = agg_value71 + 1L;
/* 341 */             agg_isNull55 = false;
/* 342 */             agg_value66 = agg_value70;
/* 343 */           }
/* 344 */           boolean agg_isNull63 = agg_fastAggBuffer.isNullAt(2);
/* 345 */           int agg_value74 = agg_isNull63 ? -1 : (agg_fastAggBuffer.getInt(2));
/* 346 */           boolean agg_isNull62 = agg_isNull63;
/* 347 */           int agg_value73 = agg_value74;
/* 348 */
/* 349 */           if (!scan_isNull8 && (agg_isNull62 ||
/* 350 */               scan_value8 > agg_value73)) {
/* 351 */             agg_isNull62 = false;
/* 352 */             agg_value73 = scan_value8;
/* 353 */           }
/* 354 */           boolean agg_isNull66 = agg_fastAggBuffer.isNullAt(3);
/* 355 */           int agg_value77 = agg_isNull66 ? -1 : (agg_fastAggBuffer.getInt(3));
/* 356 */           boolean agg_isNull65 = agg_isNull66;
/* 357 */           int agg_value76 = agg_value77;
/* 358 */
/* 359 */           if (!scan_isNull && (agg_isNull65 ||
/* 360 */               scan_value > agg_value76)) {
/* 361 */             agg_isNull65 = false;
/* 362 */             agg_value76 = scan_value;
/* 363 */           }
/* 364 */           boolean agg_isNull69 = agg_fastAggBuffer.isNullAt(4);
/* 365 */           int agg_value80 = agg_isNull69 ? -1 : (agg_fastAggBuffer.getInt(4));
/* 366 */           boolean agg_isNull68 = agg_isNull69;
/* 367 */           int agg_value79 = agg_value80;
/* 368 */
/* 369 */           if (!scan_isNull1 && (agg_isNull68 ||
/* 370 */               scan_value1 > agg_value79)) {
/* 371 */             agg_isNull68 = false;
/* 372 */             agg_value79 = scan_value1;
/* 373 */           }
/* 374 */           boolean agg_isNull72 = agg_fastAggBuffer.isNullAt(5);
/* 375 */           int agg_value83 = agg_isNull72 ? -1 : (agg_fastAggBuffer.getInt(5));
/* 376 */           boolean agg_isNull71 = agg_isNull72;
/* 377 */           int agg_value82 = agg_value83;
/* 378 */
/* 379 */           if (!scan_isNull2 && (agg_isNull71 ||
/* 380 */               scan_value2 > agg_value82)) {
/* 381 */             agg_isNull71 = false;
/* 382 */             agg_value82 = scan_value2;
/* 383 */           }
/* 384 */           boolean agg_isNull75 = agg_fastAggBuffer.isNullAt(6);
/* 385 */           int agg_value86 = agg_isNull75 ? -1 : (agg_fastAggBuffer.getInt(6));
/* 386 */           boolean agg_isNull74 = agg_isNull75;
/* 387 */           int agg_value85 = agg_value86;
/* 388 */
/* 389 */           if (!scan_isNull3 && (agg_isNull74 ||
/* 390 */               scan_value3 > agg_value85)) {
/* 391 */             agg_isNull74 = false;
/* 392 */             agg_value85 = scan_value3;
/* 393 */           }
/* 394 */           boolean agg_isNull78 = agg_fastAggBuffer.isNullAt(7);
/* 395 */           int agg_value89 = agg_isNull78 ? -1 : (agg_fastAggBuffer.getInt(7));
/* 396 */           boolean agg_isNull77 = agg_isNull78;
/* 397 */           int agg_value88 = agg_value89;
/* 398 */
/* 399 */           if (!scan_isNull4 && (agg_isNull77 ||
/* 400 */               scan_value4 > agg_value88)) {
/* 401 */             agg_isNull77 = false;
/* 402 */             agg_value88 = scan_value4;
/* 403 */           }
/* 404 */           boolean agg_isNull81 = agg_fastAggBuffer.isNullAt(8);
/* 405 */           int agg_value92 = agg_isNull81 ? -1 : (agg_fastAggBuffer.getInt(8));
/* 406 */           boolean agg_isNull80 = agg_isNull81;
/* 407 */           int agg_value91 = agg_value92;
/* 408 */
/* 409 */           if (!scan_isNull5 && (agg_isNull80 ||
/* 410 */               scan_value5 > agg_value91)) {
/* 411 */             agg_isNull80 = false;
/* 412 */             agg_value91 = scan_value5;
/* 413 */           }
/* 414 */           boolean agg_isNull84 = agg_fastAggBuffer.isNullAt(9);
/* 415 */           int agg_value95 = agg_isNull84 ? -1 : (agg_fastAggBuffer.getInt(9));
/* 416 */           boolean agg_isNull83 = agg_isNull84;
/* 417 */           int agg_value94 = agg_value95;
/* 418 */
/* 419 */           if (!scan_isNull6 && (agg_isNull83 ||
/* 420 */               scan_value6 > agg_value94)) {
/* 421 */             agg_isNull83 = false;
/* 422 */             agg_value94 = scan_value6;
/* 423 */           }
/* 424 */           boolean agg_isNull87 = agg_fastAggBuffer.isNullAt(10);
/* 425 */           int agg_value98 = agg_isNull87 ? -1 : (agg_fastAggBuffer.getInt(10));
/* 426 */           boolean agg_isNull86 = agg_isNull87;
/* 427 */           int agg_value97 = agg_value98;
/* 428 */
/* 429 */           if (!scan_isNull7 && (agg_isNull86 ||
/* 430 */               scan_value7 > agg_value97)) {
/* 431 */             agg_isNull86 = false;
/* 432 */             agg_value97 = scan_value7;
/* 433 */           }
/* 434 */           // update fast row
/* 435 */           agg_fastAggBuffer.setLong(0, agg_value63);
/* 436 */           agg_fastAggBuffer.setLong(1, agg_value66);
/* 437 */
/* 438 */           if (!agg_isNull62) {
/* 439 */             agg_fastAggBuffer.setInt(2, agg_value73);
/* 440 */           } else {
/* 441 */             agg_fastAggBuffer.setNullAt(2);
/* 442 */           }
/* 443 */
/* 444 */           if (!agg_isNull65) {
/* 445 */             agg_fastAggBuffer.setInt(3, agg_value76);
/* 446 */           } else {
/* 447 */             agg_fastAggBuffer.setNullAt(3);
/* 448 */           }
/* 449 */
/* 450 */           if (!agg_isNull68) {
/* 451 */             agg_fastAggBuffer.setInt(4, agg_value79);
/* 452 */           } else {
/* 453 */             agg_fastAggBuffer.setNullAt(4);
/* 454 */           }
/* 455 */
/* 456 */           if (!agg_isNull71) {
/* 457 */             agg_fastAggBuffer.setInt(5, agg_value82);
/* 458 */           } else {
/* 459 */             agg_fastAggBuffer.setNullAt(5);
/* 460 */           }
/* 461 */
/* 462 */           if (!agg_isNull74) {
/* 463 */             agg_fastAggBuffer.setInt(6, agg_value85);
/* 464 */           } else {
/* 465 */             agg_fastAggBuffer.setNullAt(6);
/* 466 */           }
/* 467 */
/* 468 */           if (!agg_isNull77) {
/* 469 */             agg_fastAggBuffer.setInt(7, agg_value88);
/* 470 */           } else {
/* 471 */             agg_fastAggBuffer.setNullAt(7);
/* 472 */           }
/* 473 */
/* 474 */           if (!agg_isNull80) {
/* 475 */             agg_fastAggBuffer.setInt(8, agg_value91);
/* 476 */           } else {
/* 477 */             agg_fastAggBuffer.setNullAt(8);
/* 478 */           }
/* 479 */
/* 480 */           if (!agg_isNull83) {
/* 481 */             agg_fastAggBuffer.setInt(9, agg_value94);
/* 482 */           } else {
/* 483 */             agg_fastAggBuffer.setNullAt(9);
/* 484 */           }
/* 485 */
/* 486 */           if (!agg_isNull86) {
/* 487 */             agg_fastAggBuffer.setInt(10, agg_value97);
/* 488 */           } else {
/* 489 */             agg_fastAggBuffer.setNullAt(10);
/* 490 */           }
/* 491 */
/* 492 */         } else {
/* 493 */           // update unsafe row
/* 494 */
/* 495 */           // common sub-expressions
/* 496 */
/* 497 */           // evaluate aggregate function
/* 498 */           boolean agg_isNull15 = false;
/* 499 */
/* 500 */           long agg_value27 = agg_unsafeRowAggBuffer.getLong(0);
/* 501 */
/* 502 */           long agg_value26 = -1L;
/* 503 */           agg_value26 = agg_value27 + 1L;
/* 504 */           boolean agg_isNull18 = false;
/* 505 */           long agg_value29 = -1L;
/* 506 */           if (!false && scan_isNull8) {
/* 507 */             long agg_value32 = agg_unsafeRowAggBuffer.getLong(1);
/* 508 */             agg_isNull18 = false;
/* 509 */             agg_value29 = agg_value32;
/* 510 */           } else {
/* 511 */             boolean agg_isNull22 = false;
/* 512 */
/* 513 */             long agg_value34 = agg_unsafeRowAggBuffer.getLong(1);
/* 514 */
/* 515 */             long agg_value33 = -1L;
/* 516 */             agg_value33 = agg_value34 + 1L;
/* 517 */             agg_isNull18 = false;
/* 518 */             agg_value29 = agg_value33;
/* 519 */           }
/* 520 */           boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 521 */           int agg_value37 = agg_isNull26 ? -1 : (agg_unsafeRowAggBuffer.getInt(2));
/* 522 */           boolean agg_isNull25 = agg_isNull26;
/* 523 */           int agg_value36 = agg_value37;
/* 524 */
/* 525 */           if (!scan_isNull8 && (agg_isNull25 ||
/* 526 */               scan_value8 > agg_value36)) {
/* 527 */             agg_isNull25 = false;
/* 528 */             agg_value36 = scan_value8;
/* 529 */           }
/* 530 */           boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 531 */           int agg_value40 = agg_isNull29 ? -1 : (agg_unsafeRowAggBuffer.getInt(3));
/* 532 */           boolean agg_isNull28 = agg_isNull29;
/* 533 */           int agg_value39 = agg_value40;
/* 534 */
/* 535 */           if (!scan_isNull && (agg_isNull28 ||
/* 536 */               scan_value > agg_value39)) {
/* 537 */             agg_isNull28 = false;
/* 538 */             agg_value39 = scan_value;
/* 539 */           }
/* 540 */           boolean agg_isNull32 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 541 */           int agg_value43 = agg_isNull32 ? -1 : (agg_unsafeRowAggBuffer.getInt(4));
/* 542 */           boolean agg_isNull31 = agg_isNull32;
/* 543 */           int agg_value42 = agg_value43;
/* 544 */
/* 545 */           if (!scan_isNull1 && (agg_isNull31 ||
/* 546 */               scan_value1 > agg_value42)) {
/* 547 */             agg_isNull31 = false;
/* 548 */             agg_value42 = scan_value1;
/* 549 */           }
/* 550 */           boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 551 */           int agg_value46 = agg_isNull35 ? -1 : (agg_unsafeRowAggBuffer.getInt(5));
/* 552 */           boolean agg_isNull34 = agg_isNull35;
/* 553 */           int agg_value45 = agg_value46;
/* 554 */
/* 555 */           if (!scan_isNull2 && (agg_isNull34 ||
/* 556 */               scan_value2 > agg_value45)) {
/* 557 */             agg_isNull34 = false;
/* 558 */             agg_value45 = scan_value2;
/* 559 */           }
/* 560 */           boolean agg_isNull38 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 561 */           int agg_value49 = agg_isNull38 ? -1 : (agg_unsafeRowAggBuffer.getInt(6));
/* 562 */           boolean agg_isNull37 = agg_isNull38;
/* 563 */           int agg_value48 = agg_value49;
/* 564 */
/* 565 */           if (!scan_isNull3 && (agg_isNull37 ||
/* 566 */               scan_value3 > agg_value48)) {
/* 567 */             agg_isNull37 = false;
/* 568 */             agg_value48 = scan_value3;
/* 569 */           }
/* 570 */           boolean agg_isNull41 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 571 */           int agg_value52 = agg_isNull41 ? -1 : (agg_unsafeRowAggBuffer.getInt(7));
/* 572 */           boolean agg_isNull40 = agg_isNull41;
/* 573 */           int agg_value51 = agg_value52;
/* 574 */
/* 575 */           if (!scan_isNull4 && (agg_isNull40 ||
/* 576 */               scan_value4 > agg_value51)) {
/* 577 */             agg_isNull40 = false;
/* 578 */             agg_value51 = scan_value4;
/* 579 */           }
/* 580 */           boolean agg_isNull44 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 581 */           int agg_value55 = agg_isNull44 ? -1 : (agg_unsafeRowAggBuffer.getInt(8));
/* 582 */           boolean agg_isNull43 = agg_isNull44;
/* 583 */           int agg_value54 = agg_value55;
/* 584 */
/* 585 */           if (!scan_isNull5 && (agg_isNull43 ||
/* 586 */               scan_value5 > agg_value54)) {
/* 587 */             agg_isNull43 = false;
/* 588 */             agg_value54 = scan_value5;
/* 589 */           }
/* 590 */           boolean agg_isNull47 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 591 */           int agg_value58 = agg_isNull47 ? -1 : (agg_unsafeRowAggBuffer.getInt(9));
/* 592 */           boolean agg_isNull46 = agg_isNull47;
/* 593 */           int agg_value57 = agg_value58;
/* 594 */
/* 595 */           if (!scan_isNull6 && (agg_isNull46 ||
/* 596 */               scan_value6 > agg_value57)) {
/* 597 */             agg_isNull46 = false;
/* 598 */             agg_value57 = scan_value6;
/* 599 */           }
/* 600 */           boolean agg_isNull50 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 601 */           int agg_value61 = agg_isNull50 ? -1 : (agg_unsafeRowAggBuffer.getInt(10));
/* 602 */           boolean agg_isNull49 = agg_isNull50;
/* 603 */           int agg_value60 = agg_value61;
/* 604 */
/* 605 */           if (!scan_isNull7 && (agg_isNull49 ||
/* 606 */               scan_value7 > agg_value60)) {
/* 607 */             agg_isNull49 = false;
/* 608 */             agg_value60 = scan_value7;
/* 609 */           }
/* 610 */           // update unsafe row buffer
/* 611 */           agg_unsafeRowAggBuffer.setLong(0, agg_value26);
/* 612 */           agg_unsafeRowAggBuffer.setLong(1, agg_value29);
/* 613 */
/* 614 */           if (!agg_isNull25) {
/* 615 */             agg_unsafeRowAggBuffer.setInt(2, agg_value36);
/* 616 */           } else {
/* 617 */             agg_unsafeRowAggBuffer.setNullAt(2);
/* 618 */           }
/* 619 */
/* 620 */           if (!agg_isNull28) {
/* 621 */             agg_unsafeRowAggBuffer.setInt(3, agg_value39);
/* 622 */           } else {
/* 623 */             agg_unsafeRowAggBuffer.setNullAt(3);
/* 624 */           }
/* 625 */
/* 626 */           if (!agg_isNull31) {
/* 627 */             agg_unsafeRowAggBuffer.setInt(4, agg_value42);
/* 628 */           } else {
/* 629 */             agg_unsafeRowAggBuffer.setNullAt(4);
/* 630 */           }
/* 631 */
/* 632 */           if (!agg_isNull34) {
/* 633 */             agg_unsafeRowAggBuffer.setInt(5, agg_value45);
/* 634 */           } else {
/* 635 */             agg_unsafeRowAggBuffer.setNullAt(5);
/* 636 */           }
/* 637 */
/* 638 */           if (!agg_isNull37) {
/* 639 */             agg_unsafeRowAggBuffer.setInt(6, agg_value48);
/* 640 */           } else {
/* 641 */             agg_unsafeRowAggBuffer.setNullAt(6);
/* 642 */           }
/* 643 */
/* 644 */           if (!agg_isNull40) {
/* 645 */             agg_unsafeRowAggBuffer.setInt(7, agg_value51);
/* 646 */           } else {
/* 647 */             agg_unsafeRowAggBuffer.setNullAt(7);
/* 648 */           }
/* 649 */
/* 650 */           if (!agg_isNull43) {
/* 651 */             agg_unsafeRowAggBuffer.setInt(8, agg_value54);
/* 652 */           } else {
/* 653 */             agg_unsafeRowAggBuffer.setNullAt(8);
/* 654 */           }
/* 655 */
/* 656 */           if (!agg_isNull46) {
/* 657 */             agg_unsafeRowAggBuffer.setInt(9, agg_value57);
/* 658 */           } else {
/* 659 */             agg_unsafeRowAggBuffer.setNullAt(9);
/* 660 */           }
/* 661 */
/* 662 */           if (!agg_isNull49) {
/* 663 */             agg_unsafeRowAggBuffer.setInt(10, agg_value60);
/* 664 */           } else {
/* 665 */             agg_unsafeRowAggBuffer.setNullAt(10);
/* 666 */           }
/* 667 */
/* 668 */         }
/* 669 */         // shouldStop check is eliminated
/* 670 */       }
/* 671 */       scan_batchIdx = scan_numRows;
/* 672 */       scan_batch = null;
/* 673 */       scan_nextBatch();
/* 674 */     }
/* 675 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 676 */     scan_scanTime1 = 0;
/* 677 */
/* 678 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 679 */
/* 680 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 681 */   }
/* 682 */
/* 683 */   private void wholestagecodegen_init_1() {
/* 684 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 9);
/* 685 */     agg_result1 = new UnsafeRow(1);
/* 686 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 687 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 688 */
/* 689 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 690 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 691 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 692 */
/* 693 */   }
/* 694 */
/* 695 */   protected void processNext() throws java.io.IOException {
/* 696 */     if (!agg_initAgg) {
/* 697 */       agg_initAgg = true;
/* 698 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 699 */       agg_doAggregateWithKeys();
/* 700 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 701 */     }
/* 702 */
/* 703 */     // output the result
/* 704 */
/* 705 */     while (agg_fastHashMapIter.next()) {
/* 706 */       wholestagecodegen_numOutputRows.add(1);
/* 707 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 708 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 709 */
/* 710 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 711 */
/* 712 */       append(agg_resultRow);
/* 713 */
/* 714 */       if (shouldStop()) return;
/* 715 */     }
/* 716 */     agg_fastHashMap.close();
/* 717 */
/* 718 */     while (agg_mapIter.next()) {
/* 719 */       wholestagecodegen_numOutputRows.add(1);
/* 720 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 721 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 722 */
/* 723 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 724 */
/* 725 */       append(agg_resultRow);
/* 726 */
/* 727 */       if (shouldStop()) return;
/* 728 */     }
/* 729 */
/* 730 */     agg_mapIter.close();
/* 731 */     if (agg_sorter == null) {
/* 732 */       agg_hashMap.free();
/* 733 */     }
/* 734 */   }
/* 735 */ }
