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
/* 021 */   private scala.collection.Iterator scan_input;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 024 */   private long scan_scanTime1;
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 026 */   private int scan_batchIdx;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 028 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 030 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 031 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 032 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 033 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 034 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 035 */   private UnsafeRow scan_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 039 */   private UnsafeRow filter_result;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 042 */   private UnsafeRow project_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 045 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 046 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 047 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 048 */   private UnsafeRow bhj_result;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 051 */   private UnsafeRow project_result1;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 054 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 055 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 056 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 057 */   private UnsafeRow bhj_result1;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 060 */   private UnsafeRow project_result2;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 063 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 064 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 065 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 066 */   private UnsafeRow bhj_result2;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 069 */   private UnsafeRow project_result3;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 072 */   private UnsafeRow agg_result4;
/* 073 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 075 */   private int agg_value12;
/* 076 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 077 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 078 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 079 */
/* 080 */   public GeneratedIterator(Object[] references) {
/* 081 */     this.references = references;
/* 082 */   }
/* 083 */
/* 084 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 085 */     partitionIndex = index;
/* 086 */     this.inputs = inputs;
/* 087 */     wholestagecodegen_init_0();
/* 088 */     wholestagecodegen_init_1();
/* 089 */     wholestagecodegen_init_2();
/* 090 */     wholestagecodegen_init_3();
/* 091 */     wholestagecodegen_init_4();
/* 092 */
/* 093 */   }
/* 094 */
/* 095 */   private void wholestagecodegen_init_0() {
/* 096 */     agg_initAgg = false;
/* 097 */
/* 098 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 099 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 100 */
/* 101 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 102 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 103 */     scan_input = inputs[0];
/* 104 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 105 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 106 */     scan_scanTime1 = 0;
/* 107 */     scan_batch = null;
/* 108 */     scan_batchIdx = 0;
/* 109 */     scan_colInstance0 = null;
/* 110 */     scan_colInstance1 = null;
/* 111 */     scan_colInstance2 = null;
/* 112 */     scan_colInstance3 = null;
/* 113 */     scan_colInstance4 = null;
/* 114 */     scan_colInstance5 = null;
/* 115 */     scan_colInstance6 = null;
/* 116 */     scan_colInstance7 = null;
/* 117 */     scan_result = new UnsafeRow(8);
/* 118 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 119 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 8);
/* 120 */
/* 121 */   }
/* 122 */
/* 123 */   private void wholestagecodegen_init_3() {
/* 124 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 7);
/* 125 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[16];
/* 126 */
/* 127 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 128 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 129 */
/* 130 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 131 */     bhj_result2 = new UnsafeRow(8);
/* 132 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 32);
/* 133 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 8);
/* 134 */     project_result3 = new UnsafeRow(6);
/* 135 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 32);
/* 136 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 6);
/* 137 */     agg_result4 = new UnsafeRow(4);
/* 138 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result4, 32);
/* 139 */
/* 140 */   }
/* 141 */
/* 142 */   private void scan_nextBatch() throws java.io.IOException {
/* 143 */     long getBatchStart = System.nanoTime();
/* 144 */     if (scan_input.hasNext()) {
/* 145 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 146 */       scan_numOutputRows.add(scan_batch.numRows());
/* 147 */       scan_batchIdx = 0;
/* 148 */       scan_colInstance0 = scan_batch.column(0);
/* 149 */       scan_colInstance1 = scan_batch.column(1);
/* 150 */       scan_colInstance2 = scan_batch.column(2);
/* 151 */       scan_colInstance3 = scan_batch.column(3);
/* 152 */       scan_colInstance4 = scan_batch.column(4);
/* 153 */       scan_colInstance5 = scan_batch.column(5);
/* 154 */       scan_colInstance6 = scan_batch.column(6);
/* 155 */       scan_colInstance7 = scan_batch.column(7);
/* 156 */
/* 157 */     }
/* 158 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 159 */   }
/* 160 */
/* 161 */   public class agg_FastHashMap {
/* 162 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 163 */     private int[] buckets;
/* 164 */     private int capacity = 1 << 16;
/* 165 */     private double loadFactor = 0.5;
/* 166 */     private int numBuckets = (int) (capacity / loadFactor);
/* 167 */     private int maxSteps = 2;
/* 168 */     private int numRows = 0;
/* 169 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 170 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 171 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 172 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.StringType);
/* 173 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 174 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 175 */     private Object emptyVBase;
/* 176 */     private long emptyVOff;
/* 177 */     private int emptyVLen;
/* 178 */     private boolean isBatchFull = false;
/* 179 */
/* 180 */     public agg_FastHashMap(
/* 181 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 182 */       InternalRow emptyAggregationBuffer) {
/* 183 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 184 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 185 */
/* 186 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 187 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 188 */
/* 189 */       emptyVBase = emptyBuffer;
/* 190 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 191 */       emptyVLen = emptyBuffer.length;
/* 192 */
/* 193 */       buckets = new int[numBuckets];
/* 194 */       java.util.Arrays.fill(buckets, -1);
/* 195 */     }
/* 196 */
/* 197 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key, int agg_key1, int agg_key2, UTF8String agg_key3) {
/* 198 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3);
/* 199 */       int step = 0;
/* 200 */       int idx = (int) h & (numBuckets - 1);
/* 201 */       while (step < maxSteps) {
/* 202 */         // Return bucket index if it's either an empty slot or already contains the key
/* 203 */         if (buckets[idx] == -1) {
/* 204 */           if (numRows < capacity && !isBatchFull) {
/* 205 */             // creating the unsafe for new entry
/* 206 */             UnsafeRow agg_result = new UnsafeRow(4);
/* 207 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 208 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 209 */               32);
/* 210 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 211 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 212 */               agg_holder,
/* 213 */               4);
/* 214 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 215 */             agg_rowWriter.zeroOutNullBytes();
/* 216 */             agg_rowWriter.write(0, agg_key);
/* 217 */             agg_rowWriter.write(1, agg_key1);
/* 218 */             agg_rowWriter.write(2, agg_key2);
/* 219 */             agg_rowWriter.write(3, agg_key3);
/* 220 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 221 */             Object kbase = agg_result.getBaseObject();
/* 222 */             long koff = agg_result.getBaseOffset();
/* 223 */             int klen = agg_result.getSizeInBytes();
/* 224 */
/* 225 */             UnsafeRow vRow
/* 226 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 227 */             if (vRow == null) {
/* 228 */               isBatchFull = true;
/* 229 */             } else {
/* 230 */               buckets[idx] = numRows++;
/* 231 */             }
/* 232 */             return vRow;
/* 233 */           } else {
/* 234 */             // No more space
/* 235 */             return null;
/* 236 */           }
/* 237 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3)) {
/* 238 */           return batch.getValueRow(buckets[idx]);
/* 239 */         }
/* 240 */         idx = (idx + 1) & (numBuckets - 1);
/* 241 */         step++;
/* 242 */       }
/* 243 */       // Didn't find it
/* 244 */       return null;
/* 245 */     }
/* 246 */
/* 247 */     private boolean equals(int idx, int agg_key, int agg_key1, int agg_key2, UTF8String agg_key3) {
/* 248 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 249 */       return (row.getInt(0) == agg_key) && (row.getInt(1) == agg_key1) && (row.getInt(2) == agg_key2) && (row.getUTF8String(3).equals(agg_key3));
/* 250 */     }
/* 251 */
/* 252 */     private long hash(int agg_key, int agg_key1, int agg_key2, UTF8String agg_key3) {
/* 253 */       long agg_hash = 0;
/* 254 */
/* 255 */       int agg_result = agg_key;
/* 256 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 257 */
/* 258 */       int agg_result1 = agg_key1;
/* 259 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 260 */
/* 261 */       int agg_result2 = agg_key2;
/* 262 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 263 */
/* 264 */       int agg_result3 = 0;
/* 265 */       byte[] agg_bytes = agg_key3.getBytes();
/* 266 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 267 */         int agg_hash1 = agg_bytes[i];
/* 268 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash1 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 269 */       }
/* 270 */
/* 271 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 272 */
/* 273 */       return agg_hash;
/* 274 */     }
/* 275 */
/* 276 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 277 */       return batch.rowIterator();
/* 278 */     }
/* 279 */
/* 280 */     public void close() {
/* 281 */       batch.close();
/* 282 */     }
/* 283 */
/* 284 */   }
/* 285 */
/* 286 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 287 */     agg_hashMap = agg_plan.createHashMap();
/* 288 */
/* 289 */     if (scan_batch == null) {
/* 290 */       scan_nextBatch();
/* 291 */     }
/* 292 */     while (scan_batch != null) {
/* 293 */       int scan_numRows = scan_batch.numRows();
/* 294 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 295 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 296 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 297 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 298 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 299 */
/* 300 */         if (!(!(scan_isNull3))) continue;
/* 301 */
/* 302 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 303 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 304 */
/* 305 */         if (!(!(scan_isNull1))) continue;
/* 306 */
/* 307 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 308 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 309 */
/* 310 */         if (!(!(scan_isNull))) continue;
/* 311 */
/* 312 */         filter_numOutputRows.add(1);
/* 313 */
/* 314 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 315 */         int scan_value7 = scan_isNull7 ? -1 : (scan_colInstance7.getInt(scan_rowIdx));
/* 316 */
/* 317 */         // generate join key for stream side
/* 318 */
/* 319 */         boolean bhj_isNull = scan_isNull7;
/* 320 */         long bhj_value = -1L;
/* 321 */         if (!scan_isNull7) {
/* 322 */           bhj_value = (long) scan_value7;
/* 323 */         }
/* 324 */         // find matches from HashedRelation
/* 325 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 326 */         if (bhj_matched == null) continue;
/* 327 */
/* 328 */         bhj_numOutputRows.add(1);
/* 329 */
/* 330 */         // generate join key for stream side
/* 331 */
/* 332 */         boolean bhj_isNull12 = false;
/* 333 */         long bhj_value12 = -1L;
/* 334 */         if (!false) {
/* 335 */           bhj_value12 = (long) scan_value3;
/* 336 */         }
/* 337 */         // find matches from HashedRelation
/* 338 */         UnsafeRow bhj_matched1 = bhj_isNull12 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value12);
/* 339 */         if (bhj_matched1 == null) continue;
/* 340 */
/* 341 */         bhj_numOutputRows1.add(1);
/* 342 */
/* 343 */         // generate join key for stream side
/* 344 */
/* 345 */         boolean bhj_isNull25 = false;
/* 346 */         long bhj_value25 = -1L;
/* 347 */         if (!false) {
/* 348 */           bhj_value25 = (long) scan_value1;
/* 349 */         }
/* 350 */         // find matches from HashedRelation
/* 351 */         UnsafeRow bhj_matched2 = bhj_isNull25 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value25);
/* 352 */         if (bhj_matched2 == null) continue;
/* 353 */
/* 354 */         bhj_numOutputRows2.add(1);
/* 355 */
/* 356 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 357 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 358 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 359 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 360 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 361 */         double scan_value5 = scan_isNull5 ? -1.0 : (scan_colInstance5.getDouble(scan_rowIdx));
/* 362 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 363 */         double scan_value6 = scan_isNull6 ? -1.0 : (scan_colInstance6.getDouble(scan_rowIdx));
/* 364 */         boolean bhj_isNull15 = bhj_matched1.isNullAt(1);
/* 365 */         UTF8String bhj_value15 = bhj_isNull15 ? null : (bhj_matched1.getUTF8String(1));
/* 366 */
/* 367 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 368 */
/* 369 */         UnsafeRow agg_fastAggBuffer = null;
/* 370 */
/* 371 */         if (true) {
/* 372 */           if (!scan_isNull4 && !false && !scan_isNull2 && !bhj_isNull15) {
/* 373 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 374 */               scan_value4, scan_value, scan_value2, bhj_value15);
/* 375 */           }
/* 376 */         }
/* 377 */
/* 378 */         if (agg_fastAggBuffer == null) {
/* 379 */           // generate grouping key
/* 380 */           agg_holder.reset();
/* 381 */
/* 382 */           agg_rowWriter.zeroOutNullBytes();
/* 383 */
/* 384 */           if (scan_isNull4) {
/* 385 */             agg_rowWriter.setNullAt(0);
/* 386 */           } else {
/* 387 */             agg_rowWriter.write(0, scan_value4);
/* 388 */           }
/* 389 */
/* 390 */           agg_rowWriter.write(1, scan_value);
/* 391 */
/* 392 */           if (scan_isNull2) {
/* 393 */             agg_rowWriter.setNullAt(2);
/* 394 */           } else {
/* 395 */             agg_rowWriter.write(2, scan_value2);
/* 396 */           }
/* 397 */
/* 398 */           if (bhj_isNull15) {
/* 399 */             agg_rowWriter.setNullAt(3);
/* 400 */           } else {
/* 401 */             agg_rowWriter.write(3, bhj_value15);
/* 402 */           }
/* 403 */           agg_result4.setTotalSize(agg_holder.totalSize());
/* 404 */           agg_value12 = 42;
/* 405 */
/* 406 */           if (!scan_isNull4) {
/* 407 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value4, agg_value12);
/* 408 */           }
/* 409 */
/* 410 */           if (!false) {
/* 411 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value, agg_value12);
/* 412 */           }
/* 413 */
/* 414 */           if (!scan_isNull2) {
/* 415 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value2, agg_value12);
/* 416 */           }
/* 417 */
/* 418 */           if (!bhj_isNull15) {
/* 419 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value15.getBaseObject(), bhj_value15.getBaseOffset(), bhj_value15.numBytes(), agg_value12);
/* 420 */           }
/* 421 */           if (true) {
/* 422 */             // try to get the buffer from hash map
/* 423 */             agg_unsafeRowAggBuffer =
/* 424 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value12);
/* 425 */           }
/* 426 */           if (agg_unsafeRowAggBuffer == null) {
/* 427 */             if (agg_sorter == null) {
/* 428 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 429 */             } else {
/* 430 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 431 */             }
/* 432 */
/* 433 */             // the hash map had be spilled, it should have enough memory now,
/* 434 */             // try  to allocate buffer again.
/* 435 */             agg_unsafeRowAggBuffer =
/* 436 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value12);
/* 437 */             if (agg_unsafeRowAggBuffer == null) {
/* 438 */               // failed to allocate the first page
/* 439 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 440 */             }
/* 441 */           }
/* 442 */         }
/* 443 */
/* 444 */         if (agg_fastAggBuffer != null) {
/* 445 */           // update fast row
/* 446 */
/* 447 */           // common sub-expressions
/* 448 */
/* 449 */           // evaluate aggregate function
/* 450 */           boolean agg_isNull32 = true;
/* 451 */           double agg_value34 = -1.0;
/* 452 */
/* 453 */           boolean agg_isNull34 = agg_fastAggBuffer.isNullAt(0);
/* 454 */           double agg_value36 = agg_isNull34 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 455 */           boolean agg_isNull33 = agg_isNull34;
/* 456 */           double agg_value35 = agg_value36;
/* 457 */           if (agg_isNull33) {
/* 458 */             boolean agg_isNull35 = false;
/* 459 */             double agg_value37 = -1.0;
/* 460 */             if (!false) {
/* 461 */               agg_value37 = (double) 0;
/* 462 */             }
/* 463 */             if (!agg_isNull35) {
/* 464 */               agg_isNull33 = false;
/* 465 */               agg_value35 = agg_value37;
/* 466 */             }
/* 467 */           }
/* 468 */
/* 469 */           if (!scan_isNull5) {
/* 470 */             agg_isNull32 = false; // resultCode could change nullability.
/* 471 */             agg_value34 = agg_value35 + scan_value5;
/* 472 */
/* 473 */           }
/* 474 */           boolean agg_isNull31 = agg_isNull32;
/* 475 */           double agg_value33 = agg_value34;
/* 476 */           if (agg_isNull31) {
/* 477 */             boolean agg_isNull38 = agg_fastAggBuffer.isNullAt(0);
/* 478 */             double agg_value40 = agg_isNull38 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 479 */             if (!agg_isNull38) {
/* 480 */               agg_isNull31 = false;
/* 481 */               agg_value33 = agg_value40;
/* 482 */             }
/* 483 */           }
/* 484 */           boolean agg_isNull40 = true;
/* 485 */           double agg_value42 = -1.0;
/* 486 */
/* 487 */           boolean agg_isNull42 = agg_fastAggBuffer.isNullAt(1);
/* 488 */           double agg_value44 = agg_isNull42 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 489 */           boolean agg_isNull41 = agg_isNull42;
/* 490 */           double agg_value43 = agg_value44;
/* 491 */           if (agg_isNull41) {
/* 492 */             boolean agg_isNull43 = false;
/* 493 */             double agg_value45 = -1.0;
/* 494 */             if (!false) {
/* 495 */               agg_value45 = (double) 0;
/* 496 */             }
/* 497 */             if (!agg_isNull43) {
/* 498 */               agg_isNull41 = false;
/* 499 */               agg_value43 = agg_value45;
/* 500 */             }
/* 501 */           }
/* 502 */
/* 503 */           if (!scan_isNull6) {
/* 504 */             agg_isNull40 = false; // resultCode could change nullability.
/* 505 */             agg_value42 = agg_value43 + scan_value6;
/* 506 */
/* 507 */           }
/* 508 */           boolean agg_isNull39 = agg_isNull40;
/* 509 */           double agg_value41 = agg_value42;
/* 510 */           if (agg_isNull39) {
/* 511 */             boolean agg_isNull46 = agg_fastAggBuffer.isNullAt(1);
/* 512 */             double agg_value48 = agg_isNull46 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 513 */             if (!agg_isNull46) {
/* 514 */               agg_isNull39 = false;
/* 515 */               agg_value41 = agg_value48;
/* 516 */             }
/* 517 */           }
/* 518 */           // update fast row
/* 519 */           if (!agg_isNull31) {
/* 520 */             agg_fastAggBuffer.setDouble(0, agg_value33);
/* 521 */           } else {
/* 522 */             agg_fastAggBuffer.setNullAt(0);
/* 523 */           }
/* 524 */
/* 525 */           if (!agg_isNull39) {
/* 526 */             agg_fastAggBuffer.setDouble(1, agg_value41);
/* 527 */           } else {
/* 528 */             agg_fastAggBuffer.setNullAt(1);
/* 529 */           }
/* 530 */
/* 531 */         } else {
/* 532 */           // update unsafe row
/* 533 */
/* 534 */           // common sub-expressions
/* 535 */
/* 536 */           // evaluate aggregate function
/* 537 */           boolean agg_isNull16 = true;
/* 538 */           double agg_value18 = -1.0;
/* 539 */
/* 540 */           boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 541 */           double agg_value20 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 542 */           boolean agg_isNull17 = agg_isNull18;
/* 543 */           double agg_value19 = agg_value20;
/* 544 */           if (agg_isNull17) {
/* 545 */             boolean agg_isNull19 = false;
/* 546 */             double agg_value21 = -1.0;
/* 547 */             if (!false) {
/* 548 */               agg_value21 = (double) 0;
/* 549 */             }
/* 550 */             if (!agg_isNull19) {
/* 551 */               agg_isNull17 = false;
/* 552 */               agg_value19 = agg_value21;
/* 553 */             }
/* 554 */           }
/* 555 */
/* 556 */           if (!scan_isNull5) {
/* 557 */             agg_isNull16 = false; // resultCode could change nullability.
/* 558 */             agg_value18 = agg_value19 + scan_value5;
/* 559 */
/* 560 */           }
/* 561 */           boolean agg_isNull15 = agg_isNull16;
/* 562 */           double agg_value17 = agg_value18;
/* 563 */           if (agg_isNull15) {
/* 564 */             boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 565 */             double agg_value24 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 566 */             if (!agg_isNull22) {
/* 567 */               agg_isNull15 = false;
/* 568 */               agg_value17 = agg_value24;
/* 569 */             }
/* 570 */           }
/* 571 */           boolean agg_isNull24 = true;
/* 572 */           double agg_value26 = -1.0;
/* 573 */
/* 574 */           boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 575 */           double agg_value28 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 576 */           boolean agg_isNull25 = agg_isNull26;
/* 577 */           double agg_value27 = agg_value28;
/* 578 */           if (agg_isNull25) {
/* 579 */             boolean agg_isNull27 = false;
/* 580 */             double agg_value29 = -1.0;
/* 581 */             if (!false) {
/* 582 */               agg_value29 = (double) 0;
/* 583 */             }
/* 584 */             if (!agg_isNull27) {
/* 585 */               agg_isNull25 = false;
/* 586 */               agg_value27 = agg_value29;
/* 587 */             }
/* 588 */           }
/* 589 */
/* 590 */           if (!scan_isNull6) {
/* 591 */             agg_isNull24 = false; // resultCode could change nullability.
/* 592 */             agg_value26 = agg_value27 + scan_value6;
/* 593 */
/* 594 */           }
/* 595 */           boolean agg_isNull23 = agg_isNull24;
/* 596 */           double agg_value25 = agg_value26;
/* 597 */           if (agg_isNull23) {
/* 598 */             boolean agg_isNull30 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 599 */             double agg_value32 = agg_isNull30 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 600 */             if (!agg_isNull30) {
/* 601 */               agg_isNull23 = false;
/* 602 */               agg_value25 = agg_value32;
/* 603 */             }
/* 604 */           }
/* 605 */           // update unsafe row buffer
/* 606 */           if (!agg_isNull15) {
/* 607 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value17);
/* 608 */           } else {
/* 609 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 610 */           }
/* 611 */
/* 612 */           if (!agg_isNull23) {
/* 613 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value25);
/* 614 */           } else {
/* 615 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 616 */           }
/* 617 */
/* 618 */         }
/* 619 */         // shouldStop check is eliminated
/* 620 */       }
/* 621 */       scan_batchIdx = scan_numRows;
/* 622 */       scan_batch = null;
/* 623 */       scan_nextBatch();
/* 624 */     }
/* 625 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 626 */     scan_scanTime1 = 0;
/* 627 */
/* 628 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 629 */
/* 630 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 631 */   }
/* 632 */
/* 633 */   private void wholestagecodegen_init_2() {
/* 634 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 9);
/* 635 */     project_result1 = new UnsafeRow(7);
/* 636 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 637 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 7);
/* 638 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[14];
/* 639 */
/* 640 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 641 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 642 */
/* 643 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 644 */     bhj_result1 = new UnsafeRow(9);
/* 645 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 32);
/* 646 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 9);
/* 647 */     project_result2 = new UnsafeRow(7);
/* 648 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 32);
/* 649 */
/* 650 */   }
/* 651 */
/* 652 */   private void wholestagecodegen_init_1() {
/* 653 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 654 */     filter_result = new UnsafeRow(8);
/* 655 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 656 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 8);
/* 657 */     project_result = new UnsafeRow(8);
/* 658 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 659 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
/* 660 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[12];
/* 661 */
/* 662 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 663 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 664 */
/* 665 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 666 */     bhj_result = new UnsafeRow(9);
/* 667 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 668 */
/* 669 */   }
/* 670 */
/* 671 */   private void wholestagecodegen_init_4() {
/* 672 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 673 */
/* 674 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 675 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 676 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[19];
/* 677 */
/* 678 */   }
/* 679 */
/* 680 */   protected void processNext() throws java.io.IOException {
/* 681 */     if (!agg_initAgg) {
/* 682 */       agg_initAgg = true;
/* 683 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 684 */       agg_doAggregateWithKeys();
/* 685 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 686 */     }
/* 687 */
/* 688 */     // output the result
/* 689 */
/* 690 */     while (agg_fastHashMapIter.next()) {
/* 691 */       wholestagecodegen_numOutputRows.add(1);
/* 692 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 693 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 694 */
/* 695 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 696 */
/* 697 */       append(agg_resultRow);
/* 698 */
/* 699 */       if (shouldStop()) return;
/* 700 */     }
/* 701 */     agg_fastHashMap.close();
/* 702 */
/* 703 */     while (agg_mapIter.next()) {
/* 704 */       wholestagecodegen_numOutputRows.add(1);
/* 705 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 706 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 707 */
/* 708 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 709 */
/* 710 */       append(agg_resultRow);
/* 711 */
/* 712 */       if (shouldStop()) return;
/* 713 */     }
/* 714 */
/* 715 */     agg_mapIter.close();
/* 716 */     if (agg_sorter == null) {
/* 717 */       agg_hashMap.free();
/* 718 */     }
/* 719 */   }
/* 720 */ }
