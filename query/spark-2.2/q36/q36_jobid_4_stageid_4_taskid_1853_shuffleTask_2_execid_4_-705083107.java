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
/* 017 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 018 */   private agg_FastHashMap agg_fastHashMap;
/* 019 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 020 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 021 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 022 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 025 */   private scala.collection.Iterator scan_input;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 028 */   private long scan_scanTime1;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 030 */   private int scan_batchIdx;
/* 031 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 032 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 033 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 034 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 035 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 036 */   private UnsafeRow scan_result;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 040 */   private UnsafeRow filter_result;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 043 */   private UnsafeRow project_result;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 046 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 047 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 048 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 049 */   private UnsafeRow bhj_result;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 052 */   private UnsafeRow project_result1;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 055 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 056 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 057 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 058 */   private UnsafeRow bhj_result1;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 061 */   private UnsafeRow project_result2;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 064 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 065 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 066 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 067 */   private UnsafeRow bhj_result2;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 070 */   private UnsafeRow project_result3;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 072 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 073 */   private org.apache.spark.sql.execution.metric.SQLMetric expand_numOutputRows;
/* 074 */   private UnsafeRow expand_result;
/* 075 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder expand_holder;
/* 076 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter expand_rowWriter;
/* 077 */   private UnsafeRow agg_result3;
/* 078 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 079 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 080 */   private int agg_value14;
/* 081 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 082 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 083 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 084 */
/* 085 */   public GeneratedIterator(Object[] references) {
/* 086 */     this.references = references;
/* 087 */   }
/* 088 */
/* 089 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 090 */     partitionIndex = index;
/* 091 */     this.inputs = inputs;
/* 092 */     wholestagecodegen_init_0();
/* 093 */     wholestagecodegen_init_1();
/* 094 */     wholestagecodegen_init_2();
/* 095 */     wholestagecodegen_init_3();
/* 096 */     wholestagecodegen_init_4();
/* 097 */
/* 098 */   }
/* 099 */
/* 100 */   private void wholestagecodegen_init_0() {
/* 101 */     agg_initAgg = false;
/* 102 */
/* 103 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 104 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 105 */
/* 106 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 107 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 108 */     scan_input = inputs[0];
/* 109 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 110 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 111 */     scan_scanTime1 = 0;
/* 112 */     scan_batch = null;
/* 113 */     scan_batchIdx = 0;
/* 114 */     scan_colInstance0 = null;
/* 115 */     scan_colInstance1 = null;
/* 116 */     scan_colInstance2 = null;
/* 117 */     scan_colInstance3 = null;
/* 118 */     scan_colInstance4 = null;
/* 119 */     scan_result = new UnsafeRow(5);
/* 120 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 121 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 5);
/* 122 */
/* 123 */   }
/* 124 */
/* 125 */   private void wholestagecodegen_init_3() {
/* 126 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 5);
/* 127 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[17];
/* 128 */
/* 129 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 130 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 131 */
/* 132 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 133 */     bhj_result2 = new UnsafeRow(6);
/* 134 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 64);
/* 135 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 6);
/* 136 */     project_result3 = new UnsafeRow(4);
/* 137 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 64);
/* 138 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 4);
/* 139 */     this.expand_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[19];
/* 140 */
/* 141 */   }
/* 142 */
/* 143 */   private void scan_nextBatch() throws java.io.IOException {
/* 144 */     long getBatchStart = System.nanoTime();
/* 145 */     if (scan_input.hasNext()) {
/* 146 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 147 */       scan_numOutputRows.add(scan_batch.numRows());
/* 148 */       scan_batchIdx = 0;
/* 149 */       scan_colInstance0 = scan_batch.column(0);
/* 150 */       scan_colInstance1 = scan_batch.column(1);
/* 151 */       scan_colInstance2 = scan_batch.column(2);
/* 152 */       scan_colInstance3 = scan_batch.column(3);
/* 153 */       scan_colInstance4 = scan_batch.column(4);
/* 154 */
/* 155 */     }
/* 156 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 157 */   }
/* 158 */
/* 159 */   public class agg_FastHashMap {
/* 160 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 161 */     private int[] buckets;
/* 162 */     private int capacity = 1 << 16;
/* 163 */     private double loadFactor = 0.5;
/* 164 */     private int numBuckets = (int) (capacity / loadFactor);
/* 165 */     private int maxSteps = 2;
/* 166 */     private int numRows = 0;
/* 167 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 168 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 169 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 170 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 171 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 172 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 173 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 174 */     private Object emptyVBase;
/* 175 */     private long emptyVOff;
/* 176 */     private int emptyVLen;
/* 177 */     private boolean isBatchFull = false;
/* 178 */
/* 179 */     public agg_FastHashMap(
/* 180 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 181 */       InternalRow emptyAggregationBuffer) {
/* 182 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 183 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 184 */
/* 185 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 186 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 187 */
/* 188 */       emptyVBase = emptyBuffer;
/* 189 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 190 */       emptyVLen = emptyBuffer.length;
/* 191 */
/* 192 */       buckets = new int[numBuckets];
/* 193 */       java.util.Arrays.fill(buckets, -1);
/* 194 */     }
/* 195 */
/* 196 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, int agg_key2) {
/* 197 */       long h = hash(agg_key, agg_key1, agg_key2);
/* 198 */       int step = 0;
/* 199 */       int idx = (int) h & (numBuckets - 1);
/* 200 */       while (step < maxSteps) {
/* 201 */         // Return bucket index if it's either an empty slot or already contains the key
/* 202 */         if (buckets[idx] == -1) {
/* 203 */           if (numRows < capacity && !isBatchFull) {
/* 204 */             // creating the unsafe for new entry
/* 205 */             UnsafeRow agg_result = new UnsafeRow(3);
/* 206 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 207 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 208 */               64);
/* 209 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 210 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 211 */               agg_holder,
/* 212 */               3);
/* 213 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 214 */             agg_rowWriter.zeroOutNullBytes();
/* 215 */             agg_rowWriter.write(0, agg_key);
/* 216 */             agg_rowWriter.write(1, agg_key1);
/* 217 */             agg_rowWriter.write(2, agg_key2);
/* 218 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 219 */             Object kbase = agg_result.getBaseObject();
/* 220 */             long koff = agg_result.getBaseOffset();
/* 221 */             int klen = agg_result.getSizeInBytes();
/* 222 */
/* 223 */             UnsafeRow vRow
/* 224 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 225 */             if (vRow == null) {
/* 226 */               isBatchFull = true;
/* 227 */             } else {
/* 228 */               buckets[idx] = numRows++;
/* 229 */             }
/* 230 */             return vRow;
/* 231 */           } else {
/* 232 */             // No more space
/* 233 */             return null;
/* 234 */           }
/* 235 */         } else if (equals(idx, agg_key, agg_key1, agg_key2)) {
/* 236 */           return batch.getValueRow(buckets[idx]);
/* 237 */         }
/* 238 */         idx = (idx + 1) & (numBuckets - 1);
/* 239 */         step++;
/* 240 */       }
/* 241 */       // Didn't find it
/* 242 */       return null;
/* 243 */     }
/* 244 */
/* 245 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, int agg_key2) {
/* 246 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 247 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getInt(2) == agg_key2);
/* 248 */     }
/* 249 */
/* 250 */     private long hash(UTF8String agg_key, UTF8String agg_key1, int agg_key2) {
/* 251 */       long agg_hash = 0;
/* 252 */
/* 253 */       int agg_result = 0;
/* 254 */       byte[] agg_bytes = agg_key.getBytes();
/* 255 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 256 */         int agg_hash1 = agg_bytes[i];
/* 257 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 258 */       }
/* 259 */
/* 260 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 261 */
/* 262 */       int agg_result1 = 0;
/* 263 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 264 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 265 */         int agg_hash2 = agg_bytes1[i];
/* 266 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 267 */       }
/* 268 */
/* 269 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 270 */
/* 271 */       int agg_result2 = agg_key2;
/* 272 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 273 */
/* 274 */       return agg_hash;
/* 275 */     }
/* 276 */
/* 277 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 278 */       return batch.rowIterator();
/* 279 */     }
/* 280 */
/* 281 */     public void close() {
/* 282 */       batch.close();
/* 283 */     }
/* 284 */
/* 285 */   }
/* 286 */
/* 287 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 288 */     agg_hashMap = agg_plan.createHashMap();
/* 289 */
/* 290 */     if (scan_batch == null) {
/* 291 */       scan_nextBatch();
/* 292 */     }
/* 293 */     while (scan_batch != null) {
/* 294 */       int scan_numRows = scan_batch.numRows();
/* 295 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 296 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 297 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 298 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 299 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 300 */
/* 301 */         if (!(!(scan_isNull))) continue;
/* 302 */
/* 303 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 304 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 305 */
/* 306 */         if (!(!(scan_isNull1))) continue;
/* 307 */
/* 308 */         filter_numOutputRows.add(1);
/* 309 */
/* 310 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 311 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 312 */
/* 313 */         // generate join key for stream side
/* 314 */
/* 315 */         boolean bhj_isNull = scan_isNull4;
/* 316 */         long bhj_value = -1L;
/* 317 */         if (!scan_isNull4) {
/* 318 */           bhj_value = (long) scan_value4;
/* 319 */         }
/* 320 */         // find matches from HashedRelation
/* 321 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 322 */         if (bhj_matched == null) continue;
/* 323 */
/* 324 */         bhj_numOutputRows.add(1);
/* 325 */
/* 326 */         // generate join key for stream side
/* 327 */
/* 328 */         boolean bhj_isNull9 = false;
/* 329 */         long bhj_value9 = -1L;
/* 330 */         if (!false) {
/* 331 */           bhj_value9 = (long) scan_value;
/* 332 */         }
/* 333 */         // find matches from HashedRelation
/* 334 */         UnsafeRow bhj_matched1 = bhj_isNull9 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value9);
/* 335 */         if (bhj_matched1 == null) continue;
/* 336 */
/* 337 */         bhj_numOutputRows1.add(1);
/* 338 */
/* 339 */         // generate join key for stream side
/* 340 */
/* 341 */         boolean bhj_isNull21 = false;
/* 342 */         long bhj_value21 = -1L;
/* 343 */         if (!false) {
/* 344 */           bhj_value21 = (long) scan_value1;
/* 345 */         }
/* 346 */         // find matches from HashedRelation
/* 347 */         UnsafeRow bhj_matched2 = bhj_isNull21 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value21);
/* 348 */         if (bhj_matched2 == null) continue;
/* 349 */
/* 350 */         bhj_numOutputRows2.add(1);
/* 351 */
/* 352 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 353 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 354 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 355 */         double scan_value3 = scan_isNull3 ? -1.0 : (scan_colInstance3.getDouble(scan_rowIdx));
/* 356 */         boolean bhj_isNull13 = bhj_matched1.isNullAt(2);
/* 357 */         UTF8String bhj_value13 = bhj_isNull13 ? null : (bhj_matched1.getUTF8String(2));
/* 358 */         boolean bhj_isNull12 = bhj_matched1.isNullAt(1);
/* 359 */         UTF8String bhj_value12 = bhj_isNull12 ? null : (bhj_matched1.getUTF8String(1));
/* 360 */
/* 361 */         boolean expand_isNull2 = true;
/* 362 */         UTF8String expand_value2 = null;
/* 363 */         boolean expand_isNull3 = true;
/* 364 */         UTF8String expand_value3 = null;
/* 365 */         boolean expand_isNull4 = true;
/* 366 */         int expand_value4 = -1;
/* 367 */         for (int expand_i = 0; expand_i < 3; expand_i ++) {
/* 368 */           switch (expand_i) {
/* 369 */           case 0:
/* 370 */             expand_isNull2 = bhj_isNull13;
/* 371 */             expand_value2 = bhj_value13;
/* 372 */
/* 373 */             expand_isNull3 = bhj_isNull12;
/* 374 */             expand_value3 = bhj_value12;
/* 375 */
/* 376 */             expand_isNull4 = false;
/* 377 */             expand_value4 = 0;
/* 378 */             break;
/* 379 */
/* 380 */           case 1:
/* 381 */             expand_isNull2 = bhj_isNull13;
/* 382 */             expand_value2 = bhj_value13;
/* 383 */
/* 384 */             final UTF8String expand_value9 = null;
/* 385 */             expand_isNull3 = true;
/* 386 */             expand_value3 = expand_value9;
/* 387 */
/* 388 */             expand_isNull4 = false;
/* 389 */             expand_value4 = 1;
/* 390 */             break;
/* 391 */
/* 392 */           case 2:
/* 393 */             final UTF8String expand_value11 = null;
/* 394 */             expand_isNull2 = true;
/* 395 */             expand_value2 = expand_value11;
/* 396 */
/* 397 */             final UTF8String expand_value12 = null;
/* 398 */             expand_isNull3 = true;
/* 399 */             expand_value3 = expand_value12;
/* 400 */
/* 401 */             expand_isNull4 = false;
/* 402 */             expand_value4 = 3;
/* 403 */             break;
/* 404 */           }
/* 405 */           expand_numOutputRows.add(1);
/* 406 */
/* 407 */           UnsafeRow agg_unsafeRowAggBuffer = null;
/* 408 */
/* 409 */           UnsafeRow agg_fastAggBuffer = null;
/* 410 */
/* 411 */           if (true) {
/* 412 */             if (!expand_isNull2 && !expand_isNull3 && !expand_isNull4) {
/* 413 */               agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 414 */                 expand_value2, expand_value3, expand_value4);
/* 415 */             }
/* 416 */           }
/* 417 */
/* 418 */           if (agg_fastAggBuffer == null) {
/* 419 */             // generate grouping key
/* 420 */             agg_holder.reset();
/* 421 */
/* 422 */             agg_rowWriter.zeroOutNullBytes();
/* 423 */
/* 424 */             if (expand_isNull2) {
/* 425 */               agg_rowWriter.setNullAt(0);
/* 426 */             } else {
/* 427 */               agg_rowWriter.write(0, expand_value2);
/* 428 */             }
/* 429 */
/* 430 */             if (expand_isNull3) {
/* 431 */               agg_rowWriter.setNullAt(1);
/* 432 */             } else {
/* 433 */               agg_rowWriter.write(1, expand_value3);
/* 434 */             }
/* 435 */
/* 436 */             if (expand_isNull4) {
/* 437 */               agg_rowWriter.setNullAt(2);
/* 438 */             } else {
/* 439 */               agg_rowWriter.write(2, expand_value4);
/* 440 */             }
/* 441 */             agg_result3.setTotalSize(agg_holder.totalSize());
/* 442 */             agg_value14 = 42;
/* 443 */
/* 444 */             if (!expand_isNull2) {
/* 445 */               agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value2.getBaseObject(), expand_value2.getBaseOffset(), expand_value2.numBytes(), agg_value14);
/* 446 */             }
/* 447 */
/* 448 */             if (!expand_isNull3) {
/* 449 */               agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value3.getBaseObject(), expand_value3.getBaseOffset(), expand_value3.numBytes(), agg_value14);
/* 450 */             }
/* 451 */
/* 452 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(expand_value4, agg_value14);
/* 453 */             if (true) {
/* 454 */               // try to get the buffer from hash map
/* 455 */               agg_unsafeRowAggBuffer =
/* 456 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value14);
/* 457 */             }
/* 458 */             if (agg_unsafeRowAggBuffer == null) {
/* 459 */               if (agg_sorter == null) {
/* 460 */                 agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 461 */               } else {
/* 462 */                 agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 463 */               }
/* 464 */
/* 465 */               // the hash map had be spilled, it should have enough memory now,
/* 466 */               // try  to allocate buffer again.
/* 467 */               agg_unsafeRowAggBuffer =
/* 468 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value14);
/* 469 */               if (agg_unsafeRowAggBuffer == null) {
/* 470 */                 // failed to allocate the first page
/* 471 */                 throw new OutOfMemoryError("No enough memory for aggregation");
/* 472 */               }
/* 473 */             }
/* 474 */           }
/* 475 */
/* 476 */           if (agg_fastAggBuffer != null) {
/* 477 */             // update fast row
/* 478 */
/* 479 */             // common sub-expressions
/* 480 */
/* 481 */             // evaluate aggregate function
/* 482 */             boolean agg_isNull51 = true;
/* 483 */             double agg_value55 = -1.0;
/* 484 */
/* 485 */             boolean agg_isNull53 = agg_fastAggBuffer.isNullAt(0);
/* 486 */             double agg_value57 = agg_isNull53 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 487 */             boolean agg_isNull52 = agg_isNull53;
/* 488 */             double agg_value56 = agg_value57;
/* 489 */             if (agg_isNull52) {
/* 490 */               boolean agg_isNull54 = false;
/* 491 */               double agg_value58 = -1.0;
/* 492 */               if (!false) {
/* 493 */                 agg_value58 = (double) 0;
/* 494 */               }
/* 495 */               if (!agg_isNull54) {
/* 496 */                 agg_isNull52 = false;
/* 497 */                 agg_value56 = agg_value58;
/* 498 */               }
/* 499 */             }
/* 500 */
/* 501 */             if (!scan_isNull3) {
/* 502 */               agg_isNull51 = false; // resultCode could change nullability.
/* 503 */               agg_value55 = agg_value56 + scan_value3;
/* 504 */
/* 505 */             }
/* 506 */             boolean agg_isNull50 = agg_isNull51;
/* 507 */             double agg_value54 = agg_value55;
/* 508 */             if (agg_isNull50) {
/* 509 */               boolean agg_isNull57 = agg_fastAggBuffer.isNullAt(0);
/* 510 */               double agg_value61 = agg_isNull57 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 511 */               if (!agg_isNull57) {
/* 512 */                 agg_isNull50 = false;
/* 513 */                 agg_value54 = agg_value61;
/* 514 */               }
/* 515 */             }
/* 516 */             boolean agg_isNull59 = true;
/* 517 */             double agg_value63 = -1.0;
/* 518 */
/* 519 */             boolean agg_isNull61 = agg_fastAggBuffer.isNullAt(1);
/* 520 */             double agg_value65 = agg_isNull61 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 521 */             boolean agg_isNull60 = agg_isNull61;
/* 522 */             double agg_value64 = agg_value65;
/* 523 */             if (agg_isNull60) {
/* 524 */               boolean agg_isNull62 = false;
/* 525 */               double agg_value66 = -1.0;
/* 526 */               if (!false) {
/* 527 */                 agg_value66 = (double) 0;
/* 528 */               }
/* 529 */               if (!agg_isNull62) {
/* 530 */                 agg_isNull60 = false;
/* 531 */                 agg_value64 = agg_value66;
/* 532 */               }
/* 533 */             }
/* 534 */
/* 535 */             if (!scan_isNull2) {
/* 536 */               agg_isNull59 = false; // resultCode could change nullability.
/* 537 */               agg_value63 = agg_value64 + scan_value2;
/* 538 */
/* 539 */             }
/* 540 */             boolean agg_isNull58 = agg_isNull59;
/* 541 */             double agg_value62 = agg_value63;
/* 542 */             if (agg_isNull58) {
/* 543 */               boolean agg_isNull65 = agg_fastAggBuffer.isNullAt(1);
/* 544 */               double agg_value69 = agg_isNull65 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 545 */               if (!agg_isNull65) {
/* 546 */                 agg_isNull58 = false;
/* 547 */                 agg_value62 = agg_value69;
/* 548 */               }
/* 549 */             }
/* 550 */             boolean agg_isNull67 = true;
/* 551 */             double agg_value71 = -1.0;
/* 552 */
/* 553 */             boolean agg_isNull69 = agg_fastAggBuffer.isNullAt(2);
/* 554 */             double agg_value73 = agg_isNull69 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 555 */             boolean agg_isNull68 = agg_isNull69;
/* 556 */             double agg_value72 = agg_value73;
/* 557 */             if (agg_isNull68) {
/* 558 */               boolean agg_isNull70 = false;
/* 559 */               double agg_value74 = -1.0;
/* 560 */               if (!false) {
/* 561 */                 agg_value74 = (double) 0;
/* 562 */               }
/* 563 */               if (!agg_isNull70) {
/* 564 */                 agg_isNull68 = false;
/* 565 */                 agg_value72 = agg_value74;
/* 566 */               }
/* 567 */             }
/* 568 */
/* 569 */             if (!scan_isNull3) {
/* 570 */               agg_isNull67 = false; // resultCode could change nullability.
/* 571 */               agg_value71 = agg_value72 + scan_value3;
/* 572 */
/* 573 */             }
/* 574 */             boolean agg_isNull66 = agg_isNull67;
/* 575 */             double agg_value70 = agg_value71;
/* 576 */             if (agg_isNull66) {
/* 577 */               boolean agg_isNull73 = agg_fastAggBuffer.isNullAt(2);
/* 578 */               double agg_value77 = agg_isNull73 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 579 */               if (!agg_isNull73) {
/* 580 */                 agg_isNull66 = false;
/* 581 */                 agg_value70 = agg_value77;
/* 582 */               }
/* 583 */             }
/* 584 */             boolean agg_isNull75 = true;
/* 585 */             double agg_value79 = -1.0;
/* 586 */
/* 587 */             boolean agg_isNull77 = agg_fastAggBuffer.isNullAt(3);
/* 588 */             double agg_value81 = agg_isNull77 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 589 */             boolean agg_isNull76 = agg_isNull77;
/* 590 */             double agg_value80 = agg_value81;
/* 591 */             if (agg_isNull76) {
/* 592 */               boolean agg_isNull78 = false;
/* 593 */               double agg_value82 = -1.0;
/* 594 */               if (!false) {
/* 595 */                 agg_value82 = (double) 0;
/* 596 */               }
/* 597 */               if (!agg_isNull78) {
/* 598 */                 agg_isNull76 = false;
/* 599 */                 agg_value80 = agg_value82;
/* 600 */               }
/* 601 */             }
/* 602 */
/* 603 */             if (!scan_isNull2) {
/* 604 */               agg_isNull75 = false; // resultCode could change nullability.
/* 605 */               agg_value79 = agg_value80 + scan_value2;
/* 606 */
/* 607 */             }
/* 608 */             boolean agg_isNull74 = agg_isNull75;
/* 609 */             double agg_value78 = agg_value79;
/* 610 */             if (agg_isNull74) {
/* 611 */               boolean agg_isNull81 = agg_fastAggBuffer.isNullAt(3);
/* 612 */               double agg_value85 = agg_isNull81 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 613 */               if (!agg_isNull81) {
/* 614 */                 agg_isNull74 = false;
/* 615 */                 agg_value78 = agg_value85;
/* 616 */               }
/* 617 */             }
/* 618 */             // update fast row
/* 619 */             if (!agg_isNull50) {
/* 620 */               agg_fastAggBuffer.setDouble(0, agg_value54);
/* 621 */             } else {
/* 622 */               agg_fastAggBuffer.setNullAt(0);
/* 623 */             }
/* 624 */
/* 625 */             if (!agg_isNull58) {
/* 626 */               agg_fastAggBuffer.setDouble(1, agg_value62);
/* 627 */             } else {
/* 628 */               agg_fastAggBuffer.setNullAt(1);
/* 629 */             }
/* 630 */
/* 631 */             if (!agg_isNull66) {
/* 632 */               agg_fastAggBuffer.setDouble(2, agg_value70);
/* 633 */             } else {
/* 634 */               agg_fastAggBuffer.setNullAt(2);
/* 635 */             }
/* 636 */
/* 637 */             if (!agg_isNull74) {
/* 638 */               agg_fastAggBuffer.setDouble(3, agg_value78);
/* 639 */             } else {
/* 640 */               agg_fastAggBuffer.setNullAt(3);
/* 641 */             }
/* 642 */
/* 643 */           } else {
/* 644 */             // update unsafe row
/* 645 */
/* 646 */             // common sub-expressions
/* 647 */
/* 648 */             // evaluate aggregate function
/* 649 */             boolean agg_isNull17 = true;
/* 650 */             double agg_value21 = -1.0;
/* 651 */
/* 652 */             boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 653 */             double agg_value23 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 654 */             boolean agg_isNull18 = agg_isNull19;
/* 655 */             double agg_value22 = agg_value23;
/* 656 */             if (agg_isNull18) {
/* 657 */               boolean agg_isNull20 = false;
/* 658 */               double agg_value24 = -1.0;
/* 659 */               if (!false) {
/* 660 */                 agg_value24 = (double) 0;
/* 661 */               }
/* 662 */               if (!agg_isNull20) {
/* 663 */                 agg_isNull18 = false;
/* 664 */                 agg_value22 = agg_value24;
/* 665 */               }
/* 666 */             }
/* 667 */
/* 668 */             if (!scan_isNull3) {
/* 669 */               agg_isNull17 = false; // resultCode could change nullability.
/* 670 */               agg_value21 = agg_value22 + scan_value3;
/* 671 */
/* 672 */             }
/* 673 */             boolean agg_isNull16 = agg_isNull17;
/* 674 */             double agg_value20 = agg_value21;
/* 675 */             if (agg_isNull16) {
/* 676 */               boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 677 */               double agg_value27 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 678 */               if (!agg_isNull23) {
/* 679 */                 agg_isNull16 = false;
/* 680 */                 agg_value20 = agg_value27;
/* 681 */               }
/* 682 */             }
/* 683 */             boolean agg_isNull25 = true;
/* 684 */             double agg_value29 = -1.0;
/* 685 */
/* 686 */             boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 687 */             double agg_value31 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 688 */             boolean agg_isNull26 = agg_isNull27;
/* 689 */             double agg_value30 = agg_value31;
/* 690 */             if (agg_isNull26) {
/* 691 */               boolean agg_isNull28 = false;
/* 692 */               double agg_value32 = -1.0;
/* 693 */               if (!false) {
/* 694 */                 agg_value32 = (double) 0;
/* 695 */               }
/* 696 */               if (!agg_isNull28) {
/* 697 */                 agg_isNull26 = false;
/* 698 */                 agg_value30 = agg_value32;
/* 699 */               }
/* 700 */             }
/* 701 */
/* 702 */             if (!scan_isNull2) {
/* 703 */               agg_isNull25 = false; // resultCode could change nullability.
/* 704 */               agg_value29 = agg_value30 + scan_value2;
/* 705 */
/* 706 */             }
/* 707 */             boolean agg_isNull24 = agg_isNull25;
/* 708 */             double agg_value28 = agg_value29;
/* 709 */             if (agg_isNull24) {
/* 710 */               boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 711 */               double agg_value35 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 712 */               if (!agg_isNull31) {
/* 713 */                 agg_isNull24 = false;
/* 714 */                 agg_value28 = agg_value35;
/* 715 */               }
/* 716 */             }
/* 717 */             boolean agg_isNull33 = true;
/* 718 */             double agg_value37 = -1.0;
/* 719 */
/* 720 */             boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 721 */             double agg_value39 = agg_isNull35 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 722 */             boolean agg_isNull34 = agg_isNull35;
/* 723 */             double agg_value38 = agg_value39;
/* 724 */             if (agg_isNull34) {
/* 725 */               boolean agg_isNull36 = false;
/* 726 */               double agg_value40 = -1.0;
/* 727 */               if (!false) {
/* 728 */                 agg_value40 = (double) 0;
/* 729 */               }
/* 730 */               if (!agg_isNull36) {
/* 731 */                 agg_isNull34 = false;
/* 732 */                 agg_value38 = agg_value40;
/* 733 */               }
/* 734 */             }
/* 735 */
/* 736 */             if (!scan_isNull3) {
/* 737 */               agg_isNull33 = false; // resultCode could change nullability.
/* 738 */               agg_value37 = agg_value38 + scan_value3;
/* 739 */
/* 740 */             }
/* 741 */             boolean agg_isNull32 = agg_isNull33;
/* 742 */             double agg_value36 = agg_value37;
/* 743 */             if (agg_isNull32) {
/* 744 */               boolean agg_isNull39 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 745 */               double agg_value43 = agg_isNull39 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 746 */               if (!agg_isNull39) {
/* 747 */                 agg_isNull32 = false;
/* 748 */                 agg_value36 = agg_value43;
/* 749 */               }
/* 750 */             }
/* 751 */             boolean agg_isNull41 = true;
/* 752 */             double agg_value45 = -1.0;
/* 753 */
/* 754 */             boolean agg_isNull43 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 755 */             double agg_value47 = agg_isNull43 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 756 */             boolean agg_isNull42 = agg_isNull43;
/* 757 */             double agg_value46 = agg_value47;
/* 758 */             if (agg_isNull42) {
/* 759 */               boolean agg_isNull44 = false;
/* 760 */               double agg_value48 = -1.0;
/* 761 */               if (!false) {
/* 762 */                 agg_value48 = (double) 0;
/* 763 */               }
/* 764 */               if (!agg_isNull44) {
/* 765 */                 agg_isNull42 = false;
/* 766 */                 agg_value46 = agg_value48;
/* 767 */               }
/* 768 */             }
/* 769 */
/* 770 */             if (!scan_isNull2) {
/* 771 */               agg_isNull41 = false; // resultCode could change nullability.
/* 772 */               agg_value45 = agg_value46 + scan_value2;
/* 773 */
/* 774 */             }
/* 775 */             boolean agg_isNull40 = agg_isNull41;
/* 776 */             double agg_value44 = agg_value45;
/* 777 */             if (agg_isNull40) {
/* 778 */               boolean agg_isNull47 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 779 */               double agg_value51 = agg_isNull47 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 780 */               if (!agg_isNull47) {
/* 781 */                 agg_isNull40 = false;
/* 782 */                 agg_value44 = agg_value51;
/* 783 */               }
/* 784 */             }
/* 785 */             // update unsafe row buffer
/* 786 */             if (!agg_isNull16) {
/* 787 */               agg_unsafeRowAggBuffer.setDouble(0, agg_value20);
/* 788 */             } else {
/* 789 */               agg_unsafeRowAggBuffer.setNullAt(0);
/* 790 */             }
/* 791 */
/* 792 */             if (!agg_isNull24) {
/* 793 */               agg_unsafeRowAggBuffer.setDouble(1, agg_value28);
/* 794 */             } else {
/* 795 */               agg_unsafeRowAggBuffer.setNullAt(1);
/* 796 */             }
/* 797 */
/* 798 */             if (!agg_isNull32) {
/* 799 */               agg_unsafeRowAggBuffer.setDouble(2, agg_value36);
/* 800 */             } else {
/* 801 */               agg_unsafeRowAggBuffer.setNullAt(2);
/* 802 */             }
/* 803 */
/* 804 */             if (!agg_isNull40) {
/* 805 */               agg_unsafeRowAggBuffer.setDouble(3, agg_value44);
/* 806 */             } else {
/* 807 */               agg_unsafeRowAggBuffer.setNullAt(3);
/* 808 */             }
/* 809 */
/* 810 */           }
/* 811 */
/* 812 */         }
/* 813 */         // shouldStop check is eliminated
/* 814 */       }
/* 815 */       scan_batchIdx = scan_numRows;
/* 816 */       scan_batch = null;
/* 817 */       scan_nextBatch();
/* 818 */     }
/* 819 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 820 */     scan_scanTime1 = 0;
/* 821 */
/* 822 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 823 */
/* 824 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 825 */   }
/* 826 */
/* 827 */   private void wholestagecodegen_init_2() {
/* 828 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 6);
/* 829 */     project_result1 = new UnsafeRow(4);
/* 830 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 831 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 4);
/* 832 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[15];
/* 833 */
/* 834 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 835 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 836 */
/* 837 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 838 */     bhj_result1 = new UnsafeRow(7);
/* 839 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 840 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 7);
/* 841 */     project_result2 = new UnsafeRow(5);
/* 842 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 843 */
/* 844 */   }
/* 845 */
/* 846 */   private void wholestagecodegen_init_1() {
/* 847 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 848 */     filter_result = new UnsafeRow(5);
/* 849 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 850 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 851 */     project_result = new UnsafeRow(5);
/* 852 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 853 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 854 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 855 */
/* 856 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 857 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 858 */
/* 859 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 860 */     bhj_result = new UnsafeRow(6);
/* 861 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 862 */
/* 863 */   }
/* 864 */
/* 865 */   private void wholestagecodegen_init_4() {
/* 866 */     expand_result = new UnsafeRow(5);
/* 867 */     this.expand_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(expand_result, 64);
/* 868 */     this.expand_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(expand_holder, 5);
/* 869 */     agg_result3 = new UnsafeRow(3);
/* 870 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 64);
/* 871 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 872 */
/* 873 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 874 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[20];
/* 875 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[21];
/* 876 */
/* 877 */   }
/* 878 */
/* 879 */   protected void processNext() throws java.io.IOException {
/* 880 */     if (!agg_initAgg) {
/* 881 */       agg_initAgg = true;
/* 882 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 883 */       agg_doAggregateWithKeys();
/* 884 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 885 */     }
/* 886 */
/* 887 */     // output the result
/* 888 */
/* 889 */     while (agg_fastHashMapIter.next()) {
/* 890 */       wholestagecodegen_numOutputRows.add(1);
/* 891 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 892 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 893 */
/* 894 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 895 */
/* 896 */       append(agg_resultRow.copy());
/* 897 */
/* 898 */       if (shouldStop()) return;
/* 899 */     }
/* 900 */     agg_fastHashMap.close();
/* 901 */
/* 902 */     while (agg_mapIter.next()) {
/* 903 */       wholestagecodegen_numOutputRows.add(1);
/* 904 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 905 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 906 */
/* 907 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 908 */
/* 909 */       append(agg_resultRow.copy());
/* 910 */
/* 911 */       if (shouldStop()) return;
/* 912 */     }
/* 913 */
/* 914 */     agg_mapIter.close();
/* 915 */     if (agg_sorter == null) {
/* 916 */       agg_hashMap.free();
/* 917 */     }
/* 918 */   }
/* 919 */ }
