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
/* 014 */   private long agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private long agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private long agg_bufValue4;
/* 019 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 020 */   private agg_FastHashMap agg_fastHashMap;
/* 021 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 022 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 023 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 024 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 027 */   private scala.collection.Iterator scan_input;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 030 */   private long scan_scanTime1;
/* 031 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 032 */   private int scan_batchIdx;
/* 033 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 034 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 035 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 036 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 037 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 038 */   private UnsafeRow scan_result;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 042 */   private UnsafeRow filter_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 045 */   private UnsafeRow project_result;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 048 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 049 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 050 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 051 */   private UnsafeRow bhj_result;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 054 */   private UnsafeRow project_result1;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 057 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 058 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 059 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 060 */   private UnsafeRow bhj_result1;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 063 */   private UnsafeRow project_result2;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 066 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 067 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 068 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 069 */   private UnsafeRow bhj_result2;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 072 */   private UnsafeRow project_result3;
/* 073 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 075 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 076 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 077 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 078 */   private UnsafeRow bhj_result3;
/* 079 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 080 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 081 */   private UnsafeRow project_result4;
/* 082 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 083 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 084 */   private UnsafeRow agg_result3;
/* 085 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 086 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 087 */   private int agg_value22;
/* 088 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 089 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 090 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 091 */
/* 092 */   public GeneratedIterator(Object[] references) {
/* 093 */     this.references = references;
/* 094 */   }
/* 095 */
/* 096 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 097 */     partitionIndex = index;
/* 098 */     this.inputs = inputs;
/* 099 */     wholestagecodegen_init_0();
/* 100 */     wholestagecodegen_init_1();
/* 101 */     wholestagecodegen_init_2();
/* 102 */     wholestagecodegen_init_3();
/* 103 */     wholestagecodegen_init_4();
/* 104 */     wholestagecodegen_init_5();
/* 105 */
/* 106 */   }
/* 107 */
/* 108 */   private void wholestagecodegen_init_0() {
/* 109 */     agg_initAgg = false;
/* 110 */
/* 111 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 112 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 113 */
/* 114 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 115 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 116 */     scan_input = inputs[0];
/* 117 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 118 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 119 */     scan_scanTime1 = 0;
/* 120 */     scan_batch = null;
/* 121 */     scan_batchIdx = 0;
/* 122 */     scan_colInstance0 = null;
/* 123 */     scan_colInstance1 = null;
/* 124 */     scan_colInstance2 = null;
/* 125 */     scan_colInstance3 = null;
/* 126 */     scan_colInstance4 = null;
/* 127 */     scan_result = new UnsafeRow(5);
/* 128 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 129 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 5);
/* 130 */
/* 131 */   }
/* 132 */
/* 133 */   private void wholestagecodegen_init_3() {
/* 134 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 5);
/* 135 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[18];
/* 136 */
/* 137 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 138 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 139 */
/* 140 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[19];
/* 141 */     bhj_result2 = new UnsafeRow(7);
/* 142 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 96);
/* 143 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 7);
/* 144 */     project_result3 = new UnsafeRow(5);
/* 145 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 96);
/* 146 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 5);
/* 147 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[20];
/* 148 */
/* 149 */   }
/* 150 */
/* 151 */   private void scan_nextBatch() throws java.io.IOException {
/* 152 */     long getBatchStart = System.nanoTime();
/* 153 */     if (scan_input.hasNext()) {
/* 154 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 155 */       scan_numOutputRows.add(scan_batch.numRows());
/* 156 */       scan_batchIdx = 0;
/* 157 */       scan_colInstance0 = scan_batch.column(0);
/* 158 */       scan_colInstance1 = scan_batch.column(1);
/* 159 */       scan_colInstance2 = scan_batch.column(2);
/* 160 */       scan_colInstance3 = scan_batch.column(3);
/* 161 */       scan_colInstance4 = scan_batch.column(4);
/* 162 */
/* 163 */     }
/* 164 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 165 */   }
/* 166 */
/* 167 */   public class agg_FastHashMap {
/* 168 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 169 */     private int[] buckets;
/* 170 */     private int capacity = 1 << 16;
/* 171 */     private double loadFactor = 0.5;
/* 172 */     private int numBuckets = (int) (capacity / loadFactor);
/* 173 */     private int maxSteps = 2;
/* 174 */     private int numRows = 0;
/* 175 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 176 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 177 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType);
/* 178 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.LongType)
/* 179 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.LongType)
/* 180 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.LongType)
/* 181 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.LongType)
/* 182 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.LongType);
/* 183 */     private Object emptyVBase;
/* 184 */     private long emptyVOff;
/* 185 */     private int emptyVLen;
/* 186 */     private boolean isBatchFull = false;
/* 187 */
/* 188 */     public agg_FastHashMap(
/* 189 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 190 */       InternalRow emptyAggregationBuffer) {
/* 191 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 192 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 193 */
/* 194 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 195 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 196 */
/* 197 */       emptyVBase = emptyBuffer;
/* 198 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 199 */       emptyVLen = emptyBuffer.length;
/* 200 */
/* 201 */       buckets = new int[numBuckets];
/* 202 */       java.util.Arrays.fill(buckets, -1);
/* 203 */     }
/* 204 */
/* 205 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2) {
/* 206 */       long h = hash(agg_key, agg_key1, agg_key2);
/* 207 */       int step = 0;
/* 208 */       int idx = (int) h & (numBuckets - 1);
/* 209 */       while (step < maxSteps) {
/* 210 */         // Return bucket index if it's either an empty slot or already contains the key
/* 211 */         if (buckets[idx] == -1) {
/* 212 */           if (numRows < capacity && !isBatchFull) {
/* 213 */             // creating the unsafe for new entry
/* 214 */             UnsafeRow agg_result = new UnsafeRow(3);
/* 215 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 216 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 217 */               96);
/* 218 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 219 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 220 */               agg_holder,
/* 221 */               3);
/* 222 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 223 */             agg_rowWriter.zeroOutNullBytes();
/* 224 */             agg_rowWriter.write(0, agg_key);
/* 225 */             agg_rowWriter.write(1, agg_key1);
/* 226 */             agg_rowWriter.write(2, agg_key2);
/* 227 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 228 */             Object kbase = agg_result.getBaseObject();
/* 229 */             long koff = agg_result.getBaseOffset();
/* 230 */             int klen = agg_result.getSizeInBytes();
/* 231 */
/* 232 */             UnsafeRow vRow
/* 233 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 234 */             if (vRow == null) {
/* 235 */               isBatchFull = true;
/* 236 */             } else {
/* 237 */               buckets[idx] = numRows++;
/* 238 */             }
/* 239 */             return vRow;
/* 240 */           } else {
/* 241 */             // No more space
/* 242 */             return null;
/* 243 */           }
/* 244 */         } else if (equals(idx, agg_key, agg_key1, agg_key2)) {
/* 245 */           return batch.getValueRow(buckets[idx]);
/* 246 */         }
/* 247 */         idx = (idx + 1) & (numBuckets - 1);
/* 248 */         step++;
/* 249 */       }
/* 250 */       // Didn't find it
/* 251 */       return null;
/* 252 */     }
/* 253 */
/* 254 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2) {
/* 255 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 256 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2));
/* 257 */     }
/* 258 */
/* 259 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2) {
/* 260 */       long agg_hash = 0;
/* 261 */
/* 262 */       int agg_result = 0;
/* 263 */       byte[] agg_bytes = agg_key.getBytes();
/* 264 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 265 */         int agg_hash1 = agg_bytes[i];
/* 266 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 267 */       }
/* 268 */
/* 269 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 270 */
/* 271 */       int agg_result1 = 0;
/* 272 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 273 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 274 */         int agg_hash2 = agg_bytes1[i];
/* 275 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 276 */       }
/* 277 */
/* 278 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 279 */
/* 280 */       int agg_result2 = 0;
/* 281 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 282 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 283 */         int agg_hash3 = agg_bytes2[i];
/* 284 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 285 */       }
/* 286 */
/* 287 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 288 */
/* 289 */       return agg_hash;
/* 290 */     }
/* 291 */
/* 292 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 293 */       return batch.rowIterator();
/* 294 */     }
/* 295 */
/* 296 */     public void close() {
/* 297 */       batch.close();
/* 298 */     }
/* 299 */
/* 300 */   }
/* 301 */
/* 302 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 303 */     agg_hashMap = agg_plan.createHashMap();
/* 304 */
/* 305 */     if (scan_batch == null) {
/* 306 */       scan_nextBatch();
/* 307 */     }
/* 308 */     while (scan_batch != null) {
/* 309 */       int scan_numRows = scan_batch.numRows();
/* 310 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 311 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 312 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 313 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 314 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 315 */
/* 316 */         if (!(!(scan_isNull3))) continue;
/* 317 */
/* 318 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 319 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 320 */
/* 321 */         if (!(!(scan_isNull2))) continue;
/* 322 */
/* 323 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 324 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 325 */
/* 326 */         if (!(!(scan_isNull1))) continue;
/* 327 */
/* 328 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 329 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 330 */
/* 331 */         if (!(!(scan_isNull))) continue;
/* 332 */
/* 333 */         filter_numOutputRows.add(1);
/* 334 */
/* 335 */         // generate join key for stream side
/* 336 */
/* 337 */         boolean bhj_isNull = false;
/* 338 */         long bhj_value = -1L;
/* 339 */         if (!false) {
/* 340 */           bhj_value = (long) scan_value3;
/* 341 */         }
/* 342 */         // find matches from HashedRelation
/* 343 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 344 */         if (bhj_matched == null) continue;
/* 345 */
/* 346 */         bhj_numOutputRows.add(1);
/* 347 */
/* 348 */         // generate join key for stream side
/* 349 */
/* 350 */         boolean bhj_isNull11 = false;
/* 351 */         long bhj_value11 = -1L;
/* 352 */         if (!false) {
/* 353 */           bhj_value11 = (long) scan_value2;
/* 354 */         }
/* 355 */         // find matches from HashedRelation
/* 356 */         UnsafeRow bhj_matched1 = bhj_isNull11 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value11);
/* 357 */         if (bhj_matched1 == null) continue;
/* 358 */
/* 359 */         bhj_numOutputRows1.add(1);
/* 360 */
/* 361 */         // generate join key for stream side
/* 362 */
/* 363 */         boolean bhj_isNull22 = false;
/* 364 */         long bhj_value22 = -1L;
/* 365 */         if (!false) {
/* 366 */           bhj_value22 = (long) scan_value1;
/* 367 */         }
/* 368 */         // find matches from HashedRelation
/* 369 */         UnsafeRow bhj_matched2 = bhj_isNull22 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value22);
/* 370 */         if (bhj_matched2 == null) continue;
/* 371 */
/* 372 */         bhj_numOutputRows2.add(1);
/* 373 */
/* 374 */         // generate join key for stream side
/* 375 */
/* 376 */         boolean bhj_isNull33 = false;
/* 377 */         long bhj_value33 = -1L;
/* 378 */         if (!false) {
/* 379 */           bhj_value33 = (long) scan_value;
/* 380 */         }
/* 381 */         // find matches from HashedRelation
/* 382 */         UnsafeRow bhj_matched3 = bhj_isNull33 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value33);
/* 383 */         if (bhj_matched3 == null) continue;
/* 384 */
/* 385 */         bhj_numOutputRows3.add(1);
/* 386 */
/* 387 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 388 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 389 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 390 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 391 */         boolean bhj_isNull14 = bhj_matched1.isNullAt(1);
/* 392 */         UTF8String bhj_value14 = bhj_isNull14 ? null : (bhj_matched1.getUTF8String(1));
/* 393 */         boolean bhj_isNull25 = bhj_matched2.isNullAt(1);
/* 394 */         UTF8String bhj_value25 = bhj_isNull25 ? null : (bhj_matched2.getUTF8String(1));
/* 395 */
/* 396 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 397 */
/* 398 */         UnsafeRow agg_fastAggBuffer = null;
/* 399 */
/* 400 */         if (true) {
/* 401 */           boolean agg_isNull11 = true;
/* 402 */           UTF8String agg_value16 = null;
/* 403 */
/* 404 */           if (!bhj_isNull3) {
/* 405 */             agg_isNull11 = false; // resultCode could change nullability.
/* 406 */             agg_value16 = bhj_value3.substringSQL(1, 20);
/* 407 */
/* 408 */           }
/* 409 */
/* 410 */           if (!agg_isNull11 && !bhj_isNull14 && !bhj_isNull25) {
/* 411 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 412 */               agg_value16, bhj_value14, bhj_value25);
/* 413 */           }
/* 414 */         }
/* 415 */
/* 416 */         if (agg_fastAggBuffer == null) {
/* 417 */           // generate grouping key
/* 418 */           agg_holder.reset();
/* 419 */
/* 420 */           agg_rowWriter.zeroOutNullBytes();
/* 421 */
/* 422 */           boolean agg_isNull5 = true;
/* 423 */           UTF8String agg_value10 = null;
/* 424 */
/* 425 */           if (!bhj_isNull3) {
/* 426 */             agg_isNull5 = false; // resultCode could change nullability.
/* 427 */             agg_value10 = bhj_value3.substringSQL(1, 20);
/* 428 */
/* 429 */           }
/* 430 */           if (agg_isNull5) {
/* 431 */             agg_rowWriter.setNullAt(0);
/* 432 */           } else {
/* 433 */             agg_rowWriter.write(0, agg_value10);
/* 434 */           }
/* 435 */
/* 436 */           if (bhj_isNull14) {
/* 437 */             agg_rowWriter.setNullAt(1);
/* 438 */           } else {
/* 439 */             agg_rowWriter.write(1, bhj_value14);
/* 440 */           }
/* 441 */
/* 442 */           if (bhj_isNull25) {
/* 443 */             agg_rowWriter.setNullAt(2);
/* 444 */           } else {
/* 445 */             agg_rowWriter.write(2, bhj_value25);
/* 446 */           }
/* 447 */           agg_result3.setTotalSize(agg_holder.totalSize());
/* 448 */           agg_value22 = 42;
/* 449 */
/* 450 */           boolean agg_isNull18 = true;
/* 451 */           UTF8String agg_value23 = null;
/* 452 */
/* 453 */           if (!bhj_isNull3) {
/* 454 */             agg_isNull18 = false; // resultCode could change nullability.
/* 455 */             agg_value23 = bhj_value3.substringSQL(1, 20);
/* 456 */
/* 457 */           }
/* 458 */           if (!agg_isNull18) {
/* 459 */             agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(agg_value23.getBaseObject(), agg_value23.getBaseOffset(), agg_value23.numBytes(), agg_value22);
/* 460 */           }
/* 461 */
/* 462 */           if (!bhj_isNull14) {
/* 463 */             agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value14.getBaseObject(), bhj_value14.getBaseOffset(), bhj_value14.numBytes(), agg_value22);
/* 464 */           }
/* 465 */
/* 466 */           if (!bhj_isNull25) {
/* 467 */             agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value25.getBaseObject(), bhj_value25.getBaseOffset(), bhj_value25.numBytes(), agg_value22);
/* 468 */           }
/* 469 */           if (true) {
/* 470 */             // try to get the buffer from hash map
/* 471 */             agg_unsafeRowAggBuffer =
/* 472 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value22);
/* 473 */           }
/* 474 */           if (agg_unsafeRowAggBuffer == null) {
/* 475 */             if (agg_sorter == null) {
/* 476 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 477 */             } else {
/* 478 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 479 */             }
/* 480 */
/* 481 */             // the hash map had be spilled, it should have enough memory now,
/* 482 */             // try  to allocate buffer again.
/* 483 */             agg_unsafeRowAggBuffer =
/* 484 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value22);
/* 485 */             if (agg_unsafeRowAggBuffer == null) {
/* 486 */               // failed to allocate the first page
/* 487 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 488 */             }
/* 489 */           }
/* 490 */         }
/* 491 */
/* 492 */         if (agg_fastAggBuffer != null) {
/* 493 */           // update fast row
/* 494 */
/* 495 */           // common sub-expressions
/* 496 */           boolean agg_isNull91 = true;
/* 497 */           int agg_value96 = -1;
/* 498 */
/* 499 */           if (!false) {
/* 500 */             if (!scan_isNull4) {
/* 501 */               agg_isNull91 = false; // resultCode could change nullability.
/* 502 */               agg_value96 = scan_value - scan_value4;
/* 503 */
/* 504 */             }
/* 505 */
/* 506 */           }
/* 507 */           // evaluate aggregate function
/* 508 */           boolean agg_isNull94 = false;
/* 509 */
/* 510 */           boolean agg_isNull96 = agg_fastAggBuffer.isNullAt(0);
/* 511 */           long agg_value101 = agg_isNull96 ? -1L : (agg_fastAggBuffer.getLong(0));
/* 512 */           boolean agg_isNull95 = agg_isNull96;
/* 513 */           long agg_value100 = agg_value101;
/* 514 */           if (agg_isNull95) {
/* 515 */             boolean agg_isNull97 = false;
/* 516 */             long agg_value102 = -1L;
/* 517 */             if (!false) {
/* 518 */               agg_value102 = (long) 0;
/* 519 */             }
/* 520 */             if (!agg_isNull97) {
/* 521 */               agg_isNull95 = false;
/* 522 */               agg_value100 = agg_value102;
/* 523 */             }
/* 524 */           }
/* 525 */
/* 526 */           boolean agg_isNull100 = true;
/* 527 */           int agg_value105 = -1;
/* 528 */
/* 529 */           boolean agg_isNull101 = true;
/* 530 */           boolean agg_value106 = false;
/* 531 */
/* 532 */           if (!agg_isNull91) {
/* 533 */             agg_isNull101 = false; // resultCode could change nullability.
/* 534 */             agg_value106 = agg_value96 <= 30;
/* 535 */
/* 536 */           }
/* 537 */           if (!agg_isNull101 && agg_value106) {
/* 538 */             agg_isNull100 = false;
/* 539 */             agg_value105 = 1;
/* 540 */           }
/* 541 */
/* 542 */           else {
/* 543 */             agg_isNull100 = false;
/* 544 */             agg_value105 = 0;
/* 545 */           }
/* 546 */           boolean agg_isNull99 = agg_isNull100;
/* 547 */           long agg_value104 = -1L;
/* 548 */           if (!agg_isNull100) {
/* 549 */             agg_value104 = (long) agg_value105;
/* 550 */           }
/* 551 */           long agg_value99 = -1L;
/* 552 */           agg_value99 = agg_value100 + agg_value104;
/* 553 */           boolean agg_isNull105 = false;
/* 554 */
/* 555 */           boolean agg_isNull107 = agg_fastAggBuffer.isNullAt(1);
/* 556 */           long agg_value112 = agg_isNull107 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 557 */           boolean agg_isNull106 = agg_isNull107;
/* 558 */           long agg_value111 = agg_value112;
/* 559 */           if (agg_isNull106) {
/* 560 */             boolean agg_isNull108 = false;
/* 561 */             long agg_value113 = -1L;
/* 562 */             if (!false) {
/* 563 */               agg_value113 = (long) 0;
/* 564 */             }
/* 565 */             if (!agg_isNull108) {
/* 566 */               agg_isNull106 = false;
/* 567 */               agg_value111 = agg_value113;
/* 568 */             }
/* 569 */           }
/* 570 */
/* 571 */           boolean agg_isNull111 = true;
/* 572 */           int agg_value116 = -1;
/* 573 */
/* 574 */           boolean agg_isNull113 = true;
/* 575 */           boolean agg_value118 = false;
/* 576 */
/* 577 */           if (!agg_isNull91) {
/* 578 */             agg_isNull113 = false; // resultCode could change nullability.
/* 579 */             agg_value118 = agg_value96 > 30;
/* 580 */
/* 581 */           }
/* 582 */           boolean agg_isNull112 = false;
/* 583 */           boolean agg_value117 = false;
/* 584 */
/* 585 */           if (!agg_isNull113 && !agg_value118) {
/* 586 */           } else {
/* 587 */             boolean agg_isNull115 = true;
/* 588 */             boolean agg_value120 = false;
/* 589 */
/* 590 */             if (!agg_isNull91) {
/* 591 */               agg_isNull115 = false; // resultCode could change nullability.
/* 592 */               agg_value120 = agg_value96 <= 60;
/* 593 */
/* 594 */             }
/* 595 */             if (!agg_isNull115 && !agg_value120) {
/* 596 */             } else if (!agg_isNull113 && !agg_isNull115) {
/* 597 */               agg_value117 = true;
/* 598 */             } else {
/* 599 */               agg_isNull112 = true;
/* 600 */             }
/* 601 */           }
/* 602 */           if (!agg_isNull112 && agg_value117) {
/* 603 */             agg_isNull111 = false;
/* 604 */             agg_value116 = 1;
/* 605 */           }
/* 606 */
/* 607 */           else {
/* 608 */             agg_isNull111 = false;
/* 609 */             agg_value116 = 0;
/* 610 */           }
/* 611 */           boolean agg_isNull110 = agg_isNull111;
/* 612 */           long agg_value115 = -1L;
/* 613 */           if (!agg_isNull111) {
/* 614 */             agg_value115 = (long) agg_value116;
/* 615 */           }
/* 616 */           long agg_value110 = -1L;
/* 617 */           agg_value110 = agg_value111 + agg_value115;
/* 618 */           boolean agg_isNull119 = false;
/* 619 */
/* 620 */           boolean agg_isNull121 = agg_fastAggBuffer.isNullAt(2);
/* 621 */           long agg_value126 = agg_isNull121 ? -1L : (agg_fastAggBuffer.getLong(2));
/* 622 */           boolean agg_isNull120 = agg_isNull121;
/* 623 */           long agg_value125 = agg_value126;
/* 624 */           if (agg_isNull120) {
/* 625 */             boolean agg_isNull122 = false;
/* 626 */             long agg_value127 = -1L;
/* 627 */             if (!false) {
/* 628 */               agg_value127 = (long) 0;
/* 629 */             }
/* 630 */             if (!agg_isNull122) {
/* 631 */               agg_isNull120 = false;
/* 632 */               agg_value125 = agg_value127;
/* 633 */             }
/* 634 */           }
/* 635 */
/* 636 */           boolean agg_isNull125 = true;
/* 637 */           int agg_value130 = -1;
/* 638 */
/* 639 */           boolean agg_isNull127 = true;
/* 640 */           boolean agg_value132 = false;
/* 641 */
/* 642 */           if (!agg_isNull91) {
/* 643 */             agg_isNull127 = false; // resultCode could change nullability.
/* 644 */             agg_value132 = agg_value96 > 60;
/* 645 */
/* 646 */           }
/* 647 */           boolean agg_isNull126 = false;
/* 648 */           boolean agg_value131 = false;
/* 649 */
/* 650 */           if (!agg_isNull127 && !agg_value132) {
/* 651 */           } else {
/* 652 */             boolean agg_isNull129 = true;
/* 653 */             boolean agg_value134 = false;
/* 654 */
/* 655 */             if (!agg_isNull91) {
/* 656 */               agg_isNull129 = false; // resultCode could change nullability.
/* 657 */               agg_value134 = agg_value96 <= 90;
/* 658 */
/* 659 */             }
/* 660 */             if (!agg_isNull129 && !agg_value134) {
/* 661 */             } else if (!agg_isNull127 && !agg_isNull129) {
/* 662 */               agg_value131 = true;
/* 663 */             } else {
/* 664 */               agg_isNull126 = true;
/* 665 */             }
/* 666 */           }
/* 667 */           if (!agg_isNull126 && agg_value131) {
/* 668 */             agg_isNull125 = false;
/* 669 */             agg_value130 = 1;
/* 670 */           }
/* 671 */
/* 672 */           else {
/* 673 */             agg_isNull125 = false;
/* 674 */             agg_value130 = 0;
/* 675 */           }
/* 676 */           boolean agg_isNull124 = agg_isNull125;
/* 677 */           long agg_value129 = -1L;
/* 678 */           if (!agg_isNull125) {
/* 679 */             agg_value129 = (long) agg_value130;
/* 680 */           }
/* 681 */           long agg_value124 = -1L;
/* 682 */           agg_value124 = agg_value125 + agg_value129;
/* 683 */           boolean agg_isNull133 = false;
/* 684 */
/* 685 */           boolean agg_isNull135 = agg_fastAggBuffer.isNullAt(3);
/* 686 */           long agg_value140 = agg_isNull135 ? -1L : (agg_fastAggBuffer.getLong(3));
/* 687 */           boolean agg_isNull134 = agg_isNull135;
/* 688 */           long agg_value139 = agg_value140;
/* 689 */           if (agg_isNull134) {
/* 690 */             boolean agg_isNull136 = false;
/* 691 */             long agg_value141 = -1L;
/* 692 */             if (!false) {
/* 693 */               agg_value141 = (long) 0;
/* 694 */             }
/* 695 */             if (!agg_isNull136) {
/* 696 */               agg_isNull134 = false;
/* 697 */               agg_value139 = agg_value141;
/* 698 */             }
/* 699 */           }
/* 700 */
/* 701 */           boolean agg_isNull139 = true;
/* 702 */           int agg_value144 = -1;
/* 703 */
/* 704 */           boolean agg_isNull141 = true;
/* 705 */           boolean agg_value146 = false;
/* 706 */
/* 707 */           if (!agg_isNull91) {
/* 708 */             agg_isNull141 = false; // resultCode could change nullability.
/* 709 */             agg_value146 = agg_value96 > 90;
/* 710 */
/* 711 */           }
/* 712 */           boolean agg_isNull140 = false;
/* 713 */           boolean agg_value145 = false;
/* 714 */
/* 715 */           if (!agg_isNull141 && !agg_value146) {
/* 716 */           } else {
/* 717 */             boolean agg_isNull143 = true;
/* 718 */             boolean agg_value148 = false;
/* 719 */
/* 720 */             if (!agg_isNull91) {
/* 721 */               agg_isNull143 = false; // resultCode could change nullability.
/* 722 */               agg_value148 = agg_value96 <= 120;
/* 723 */
/* 724 */             }
/* 725 */             if (!agg_isNull143 && !agg_value148) {
/* 726 */             } else if (!agg_isNull141 && !agg_isNull143) {
/* 727 */               agg_value145 = true;
/* 728 */             } else {
/* 729 */               agg_isNull140 = true;
/* 730 */             }
/* 731 */           }
/* 732 */           if (!agg_isNull140 && agg_value145) {
/* 733 */             agg_isNull139 = false;
/* 734 */             agg_value144 = 1;
/* 735 */           }
/* 736 */
/* 737 */           else {
/* 738 */             agg_isNull139 = false;
/* 739 */             agg_value144 = 0;
/* 740 */           }
/* 741 */           boolean agg_isNull138 = agg_isNull139;
/* 742 */           long agg_value143 = -1L;
/* 743 */           if (!agg_isNull139) {
/* 744 */             agg_value143 = (long) agg_value144;
/* 745 */           }
/* 746 */           long agg_value138 = -1L;
/* 747 */           agg_value138 = agg_value139 + agg_value143;
/* 748 */           boolean agg_isNull147 = false;
/* 749 */
/* 750 */           boolean agg_isNull149 = agg_fastAggBuffer.isNullAt(4);
/* 751 */           long agg_value154 = agg_isNull149 ? -1L : (agg_fastAggBuffer.getLong(4));
/* 752 */           boolean agg_isNull148 = agg_isNull149;
/* 753 */           long agg_value153 = agg_value154;
/* 754 */           if (agg_isNull148) {
/* 755 */             boolean agg_isNull150 = false;
/* 756 */             long agg_value155 = -1L;
/* 757 */             if (!false) {
/* 758 */               agg_value155 = (long) 0;
/* 759 */             }
/* 760 */             if (!agg_isNull150) {
/* 761 */               agg_isNull148 = false;
/* 762 */               agg_value153 = agg_value155;
/* 763 */             }
/* 764 */           }
/* 765 */
/* 766 */           boolean agg_isNull153 = true;
/* 767 */           int agg_value158 = -1;
/* 768 */
/* 769 */           boolean agg_isNull154 = true;
/* 770 */           boolean agg_value159 = false;
/* 771 */
/* 772 */           if (!agg_isNull91) {
/* 773 */             agg_isNull154 = false; // resultCode could change nullability.
/* 774 */             agg_value159 = agg_value96 > 120;
/* 775 */
/* 776 */           }
/* 777 */           if (!agg_isNull154 && agg_value159) {
/* 778 */             agg_isNull153 = false;
/* 779 */             agg_value158 = 1;
/* 780 */           }
/* 781 */
/* 782 */           else {
/* 783 */             agg_isNull153 = false;
/* 784 */             agg_value158 = 0;
/* 785 */           }
/* 786 */           boolean agg_isNull152 = agg_isNull153;
/* 787 */           long agg_value157 = -1L;
/* 788 */           if (!agg_isNull153) {
/* 789 */             agg_value157 = (long) agg_value158;
/* 790 */           }
/* 791 */           long agg_value152 = -1L;
/* 792 */           agg_value152 = agg_value153 + agg_value157;
/* 793 */           // update fast row
/* 794 */           agg_fastAggBuffer.setLong(0, agg_value99);
/* 795 */           agg_fastAggBuffer.setLong(1, agg_value110);
/* 796 */           agg_fastAggBuffer.setLong(2, agg_value124);
/* 797 */           agg_fastAggBuffer.setLong(3, agg_value138);
/* 798 */           agg_fastAggBuffer.setLong(4, agg_value152);
/* 799 */
/* 800 */         } else {
/* 801 */           // update unsafe row
/* 802 */
/* 803 */           // common sub-expressions
/* 804 */           boolean agg_isNull24 = true;
/* 805 */           int agg_value29 = -1;
/* 806 */
/* 807 */           if (!false) {
/* 808 */             if (!scan_isNull4) {
/* 809 */               agg_isNull24 = false; // resultCode could change nullability.
/* 810 */               agg_value29 = scan_value - scan_value4;
/* 811 */
/* 812 */             }
/* 813 */
/* 814 */           }
/* 815 */           // evaluate aggregate function
/* 816 */           boolean agg_isNull27 = false;
/* 817 */
/* 818 */           boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 819 */           long agg_value34 = agg_isNull29 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 820 */           boolean agg_isNull28 = agg_isNull29;
/* 821 */           long agg_value33 = agg_value34;
/* 822 */           if (agg_isNull28) {
/* 823 */             boolean agg_isNull30 = false;
/* 824 */             long agg_value35 = -1L;
/* 825 */             if (!false) {
/* 826 */               agg_value35 = (long) 0;
/* 827 */             }
/* 828 */             if (!agg_isNull30) {
/* 829 */               agg_isNull28 = false;
/* 830 */               agg_value33 = agg_value35;
/* 831 */             }
/* 832 */           }
/* 833 */
/* 834 */           boolean agg_isNull33 = true;
/* 835 */           int agg_value38 = -1;
/* 836 */
/* 837 */           boolean agg_isNull34 = true;
/* 838 */           boolean agg_value39 = false;
/* 839 */
/* 840 */           if (!agg_isNull24) {
/* 841 */             agg_isNull34 = false; // resultCode could change nullability.
/* 842 */             agg_value39 = agg_value29 <= 30;
/* 843 */
/* 844 */           }
/* 845 */           if (!agg_isNull34 && agg_value39) {
/* 846 */             agg_isNull33 = false;
/* 847 */             agg_value38 = 1;
/* 848 */           }
/* 849 */
/* 850 */           else {
/* 851 */             agg_isNull33 = false;
/* 852 */             agg_value38 = 0;
/* 853 */           }
/* 854 */           boolean agg_isNull32 = agg_isNull33;
/* 855 */           long agg_value37 = -1L;
/* 856 */           if (!agg_isNull33) {
/* 857 */             agg_value37 = (long) agg_value38;
/* 858 */           }
/* 859 */           long agg_value32 = -1L;
/* 860 */           agg_value32 = agg_value33 + agg_value37;
/* 861 */           boolean agg_isNull38 = false;
/* 862 */
/* 863 */           boolean agg_isNull40 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 864 */           long agg_value45 = agg_isNull40 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 865 */           boolean agg_isNull39 = agg_isNull40;
/* 866 */           long agg_value44 = agg_value45;
/* 867 */           if (agg_isNull39) {
/* 868 */             boolean agg_isNull41 = false;
/* 869 */             long agg_value46 = -1L;
/* 870 */             if (!false) {
/* 871 */               agg_value46 = (long) 0;
/* 872 */             }
/* 873 */             if (!agg_isNull41) {
/* 874 */               agg_isNull39 = false;
/* 875 */               agg_value44 = agg_value46;
/* 876 */             }
/* 877 */           }
/* 878 */
/* 879 */           boolean agg_isNull44 = true;
/* 880 */           int agg_value49 = -1;
/* 881 */
/* 882 */           boolean agg_isNull46 = true;
/* 883 */           boolean agg_value51 = false;
/* 884 */
/* 885 */           if (!agg_isNull24) {
/* 886 */             agg_isNull46 = false; // resultCode could change nullability.
/* 887 */             agg_value51 = agg_value29 > 30;
/* 888 */
/* 889 */           }
/* 890 */           boolean agg_isNull45 = false;
/* 891 */           boolean agg_value50 = false;
/* 892 */
/* 893 */           if (!agg_isNull46 && !agg_value51) {
/* 894 */           } else {
/* 895 */             boolean agg_isNull48 = true;
/* 896 */             boolean agg_value53 = false;
/* 897 */
/* 898 */             if (!agg_isNull24) {
/* 899 */               agg_isNull48 = false; // resultCode could change nullability.
/* 900 */               agg_value53 = agg_value29 <= 60;
/* 901 */
/* 902 */             }
/* 903 */             if (!agg_isNull48 && !agg_value53) {
/* 904 */             } else if (!agg_isNull46 && !agg_isNull48) {
/* 905 */               agg_value50 = true;
/* 906 */             } else {
/* 907 */               agg_isNull45 = true;
/* 908 */             }
/* 909 */           }
/* 910 */           if (!agg_isNull45 && agg_value50) {
/* 911 */             agg_isNull44 = false;
/* 912 */             agg_value49 = 1;
/* 913 */           }
/* 914 */
/* 915 */           else {
/* 916 */             agg_isNull44 = false;
/* 917 */             agg_value49 = 0;
/* 918 */           }
/* 919 */           boolean agg_isNull43 = agg_isNull44;
/* 920 */           long agg_value48 = -1L;
/* 921 */           if (!agg_isNull44) {
/* 922 */             agg_value48 = (long) agg_value49;
/* 923 */           }
/* 924 */           long agg_value43 = -1L;
/* 925 */           agg_value43 = agg_value44 + agg_value48;
/* 926 */           boolean agg_isNull52 = false;
/* 927 */
/* 928 */           boolean agg_isNull54 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 929 */           long agg_value59 = agg_isNull54 ? -1L : (agg_unsafeRowAggBuffer.getLong(2));
/* 930 */           boolean agg_isNull53 = agg_isNull54;
/* 931 */           long agg_value58 = agg_value59;
/* 932 */           if (agg_isNull53) {
/* 933 */             boolean agg_isNull55 = false;
/* 934 */             long agg_value60 = -1L;
/* 935 */             if (!false) {
/* 936 */               agg_value60 = (long) 0;
/* 937 */             }
/* 938 */             if (!agg_isNull55) {
/* 939 */               agg_isNull53 = false;
/* 940 */               agg_value58 = agg_value60;
/* 941 */             }
/* 942 */           }
/* 943 */
/* 944 */           boolean agg_isNull58 = true;
/* 945 */           int agg_value63 = -1;
/* 946 */
/* 947 */           boolean agg_isNull60 = true;
/* 948 */           boolean agg_value65 = false;
/* 949 */
/* 950 */           if (!agg_isNull24) {
/* 951 */             agg_isNull60 = false; // resultCode could change nullability.
/* 952 */             agg_value65 = agg_value29 > 60;
/* 953 */
/* 954 */           }
/* 955 */           boolean agg_isNull59 = false;
/* 956 */           boolean agg_value64 = false;
/* 957 */
/* 958 */           if (!agg_isNull60 && !agg_value65) {
/* 959 */           } else {
/* 960 */             boolean agg_isNull62 = true;
/* 961 */             boolean agg_value67 = false;
/* 962 */
/* 963 */             if (!agg_isNull24) {
/* 964 */               agg_isNull62 = false; // resultCode could change nullability.
/* 965 */               agg_value67 = agg_value29 <= 90;
/* 966 */
/* 967 */             }
/* 968 */             if (!agg_isNull62 && !agg_value67) {
/* 969 */             } else if (!agg_isNull60 && !agg_isNull62) {
/* 970 */               agg_value64 = true;
/* 971 */             } else {
/* 972 */               agg_isNull59 = true;
/* 973 */             }
/* 974 */           }
/* 975 */           if (!agg_isNull59 && agg_value64) {
/* 976 */             agg_isNull58 = false;
/* 977 */             agg_value63 = 1;
/* 978 */           }
/* 979 */
/* 980 */           else {
/* 981 */             agg_isNull58 = false;
/* 982 */             agg_value63 = 0;
/* 983 */           }
/* 984 */           boolean agg_isNull57 = agg_isNull58;
/* 985 */           long agg_value62 = -1L;
/* 986 */           if (!agg_isNull58) {
/* 987 */             agg_value62 = (long) agg_value63;
/* 988 */           }
/* 989 */           long agg_value57 = -1L;
/* 990 */           agg_value57 = agg_value58 + agg_value62;
/* 991 */           boolean agg_isNull66 = false;
/* 992 */
/* 993 */           boolean agg_isNull68 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 994 */           long agg_value73 = agg_isNull68 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 995 */           boolean agg_isNull67 = agg_isNull68;
/* 996 */           long agg_value72 = agg_value73;
/* 997 */           if (agg_isNull67) {
/* 998 */             boolean agg_isNull69 = false;
/* 999 */             long agg_value74 = -1L;
/* 1000 */             if (!false) {
/* 1001 */               agg_value74 = (long) 0;
/* 1002 */             }
/* 1003 */             if (!agg_isNull69) {
/* 1004 */               agg_isNull67 = false;
/* 1005 */               agg_value72 = agg_value74;
/* 1006 */             }
/* 1007 */           }
/* 1008 */
/* 1009 */           boolean agg_isNull72 = true;
/* 1010 */           int agg_value77 = -1;
/* 1011 */
/* 1012 */           boolean agg_isNull74 = true;
/* 1013 */           boolean agg_value79 = false;
/* 1014 */
/* 1015 */           if (!agg_isNull24) {
/* 1016 */             agg_isNull74 = false; // resultCode could change nullability.
/* 1017 */             agg_value79 = agg_value29 > 90;
/* 1018 */
/* 1019 */           }
/* 1020 */           boolean agg_isNull73 = false;
/* 1021 */           boolean agg_value78 = false;
/* 1022 */
/* 1023 */           if (!agg_isNull74 && !agg_value79) {
/* 1024 */           } else {
/* 1025 */             boolean agg_isNull76 = true;
/* 1026 */             boolean agg_value81 = false;
/* 1027 */
/* 1028 */             if (!agg_isNull24) {
/* 1029 */               agg_isNull76 = false; // resultCode could change nullability.
/* 1030 */               agg_value81 = agg_value29 <= 120;
/* 1031 */
/* 1032 */             }
/* 1033 */             if (!agg_isNull76 && !agg_value81) {
/* 1034 */             } else if (!agg_isNull74 && !agg_isNull76) {
/* 1035 */               agg_value78 = true;
/* 1036 */             } else {
/* 1037 */               agg_isNull73 = true;
/* 1038 */             }
/* 1039 */           }
/* 1040 */           if (!agg_isNull73 && agg_value78) {
/* 1041 */             agg_isNull72 = false;
/* 1042 */             agg_value77 = 1;
/* 1043 */           }
/* 1044 */
/* 1045 */           else {
/* 1046 */             agg_isNull72 = false;
/* 1047 */             agg_value77 = 0;
/* 1048 */           }
/* 1049 */           boolean agg_isNull71 = agg_isNull72;
/* 1050 */           long agg_value76 = -1L;
/* 1051 */           if (!agg_isNull72) {
/* 1052 */             agg_value76 = (long) agg_value77;
/* 1053 */           }
/* 1054 */           long agg_value71 = -1L;
/* 1055 */           agg_value71 = agg_value72 + agg_value76;
/* 1056 */           boolean agg_isNull80 = false;
/* 1057 */
/* 1058 */           boolean agg_isNull82 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 1059 */           long agg_value87 = agg_isNull82 ? -1L : (agg_unsafeRowAggBuffer.getLong(4));
/* 1060 */           boolean agg_isNull81 = agg_isNull82;
/* 1061 */           long agg_value86 = agg_value87;
/* 1062 */           if (agg_isNull81) {
/* 1063 */             boolean agg_isNull83 = false;
/* 1064 */             long agg_value88 = -1L;
/* 1065 */             if (!false) {
/* 1066 */               agg_value88 = (long) 0;
/* 1067 */             }
/* 1068 */             if (!agg_isNull83) {
/* 1069 */               agg_isNull81 = false;
/* 1070 */               agg_value86 = agg_value88;
/* 1071 */             }
/* 1072 */           }
/* 1073 */
/* 1074 */           boolean agg_isNull86 = true;
/* 1075 */           int agg_value91 = -1;
/* 1076 */
/* 1077 */           boolean agg_isNull87 = true;
/* 1078 */           boolean agg_value92 = false;
/* 1079 */
/* 1080 */           if (!agg_isNull24) {
/* 1081 */             agg_isNull87 = false; // resultCode could change nullability.
/* 1082 */             agg_value92 = agg_value29 > 120;
/* 1083 */
/* 1084 */           }
/* 1085 */           if (!agg_isNull87 && agg_value92) {
/* 1086 */             agg_isNull86 = false;
/* 1087 */             agg_value91 = 1;
/* 1088 */           }
/* 1089 */
/* 1090 */           else {
/* 1091 */             agg_isNull86 = false;
/* 1092 */             agg_value91 = 0;
/* 1093 */           }
/* 1094 */           boolean agg_isNull85 = agg_isNull86;
/* 1095 */           long agg_value90 = -1L;
/* 1096 */           if (!agg_isNull86) {
/* 1097 */             agg_value90 = (long) agg_value91;
/* 1098 */           }
/* 1099 */           long agg_value85 = -1L;
/* 1100 */           agg_value85 = agg_value86 + agg_value90;
/* 1101 */           // update unsafe row buffer
/* 1102 */           agg_unsafeRowAggBuffer.setLong(0, agg_value32);
/* 1103 */           agg_unsafeRowAggBuffer.setLong(1, agg_value43);
/* 1104 */           agg_unsafeRowAggBuffer.setLong(2, agg_value57);
/* 1105 */           agg_unsafeRowAggBuffer.setLong(3, agg_value71);
/* 1106 */           agg_unsafeRowAggBuffer.setLong(4, agg_value85);
/* 1107 */
/* 1108 */         }
/* 1109 */         // shouldStop check is eliminated
/* 1110 */       }
/* 1111 */       scan_batchIdx = scan_numRows;
/* 1112 */       scan_batch = null;
/* 1113 */       scan_nextBatch();
/* 1114 */     }
/* 1115 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 1116 */     scan_scanTime1 = 0;
/* 1117 */
/* 1118 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 1119 */
/* 1120 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1121 */   }
/* 1122 */
/* 1123 */   private void wholestagecodegen_init_5() {
/* 1124 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 1125 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[22];
/* 1126 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[23];
/* 1127 */
/* 1128 */   }
/* 1129 */
/* 1130 */   private void wholestagecodegen_init_2() {
/* 1131 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 1132 */     project_result1 = new UnsafeRow(5);
/* 1133 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 1134 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 1135 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[16];
/* 1136 */
/* 1137 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 1138 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 1139 */
/* 1140 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 1141 */     bhj_result1 = new UnsafeRow(7);
/* 1142 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 1143 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 7);
/* 1144 */     project_result2 = new UnsafeRow(5);
/* 1145 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 1146 */
/* 1147 */   }
/* 1148 */
/* 1149 */   private void wholestagecodegen_init_1() {
/* 1150 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 1151 */     filter_result = new UnsafeRow(5);
/* 1152 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 1153 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 1154 */     project_result = new UnsafeRow(5);
/* 1155 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 1156 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 1157 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[14];
/* 1158 */
/* 1159 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 1160 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 1161 */
/* 1162 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 1163 */     bhj_result = new UnsafeRow(7);
/* 1164 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 1165 */
/* 1166 */   }
/* 1167 */
/* 1168 */   private void wholestagecodegen_init_4() {
/* 1169 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 1170 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 1171 */
/* 1172 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[21];
/* 1173 */     bhj_result3 = new UnsafeRow(6);
/* 1174 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 96);
/* 1175 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 6);
/* 1176 */     project_result4 = new UnsafeRow(5);
/* 1177 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 96);
/* 1178 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 5);
/* 1179 */     agg_result3 = new UnsafeRow(3);
/* 1180 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 96);
/* 1181 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 1182 */
/* 1183 */   }
/* 1184 */
/* 1185 */   protected void processNext() throws java.io.IOException {
/* 1186 */     if (!agg_initAgg) {
/* 1187 */       agg_initAgg = true;
/* 1188 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1189 */       agg_doAggregateWithKeys();
/* 1190 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1191 */     }
/* 1192 */
/* 1193 */     // output the result
/* 1194 */
/* 1195 */     while (agg_fastHashMapIter.next()) {
/* 1196 */       wholestagecodegen_numOutputRows.add(1);
/* 1197 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 1198 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 1199 */
/* 1200 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1201 */
/* 1202 */       append(agg_resultRow);
/* 1203 */
/* 1204 */       if (shouldStop()) return;
/* 1205 */     }
/* 1206 */     agg_fastHashMap.close();
/* 1207 */
/* 1208 */     while (agg_mapIter.next()) {
/* 1209 */       wholestagecodegen_numOutputRows.add(1);
/* 1210 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1211 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1212 */
/* 1213 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1214 */
/* 1215 */       append(agg_resultRow);
/* 1216 */
/* 1217 */       if (shouldStop()) return;
/* 1218 */     }
/* 1219 */
/* 1220 */     agg_mapIter.close();
/* 1221 */     if (agg_sorter == null) {
/* 1222 */       agg_hashMap.free();
/* 1223 */     }
/* 1224 */   }
/* 1225 */ }
