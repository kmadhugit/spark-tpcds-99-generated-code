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
/* 011 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 012 */   private agg_FastHashMap agg_fastHashMap;
/* 013 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 014 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 015 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 016 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 019 */   private scala.collection.Iterator scan_input;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 022 */   private long scan_scanTime1;
/* 023 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 024 */   private int scan_batchIdx;
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 026 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 028 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 030 */   private UnsafeRow scan_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 034 */   private UnsafeRow filter_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 037 */   private UnsafeRow project_result;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 040 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 041 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 042 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 043 */   private UnsafeRow bhj_result;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 046 */   private UnsafeRow project_result1;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 049 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 050 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 051 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 052 */   private UnsafeRow bhj_result1;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 055 */   private UnsafeRow project_result2;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 058 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 059 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 060 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 061 */   private UnsafeRow bhj_result2;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 064 */   private UnsafeRow project_result3;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 067 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 068 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 069 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 070 */   private UnsafeRow bhj_result3;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 072 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 073 */   private UnsafeRow project_result4;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 075 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 076 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast4;
/* 077 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation4;
/* 078 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows4;
/* 079 */   private UnsafeRow bhj_result4;
/* 080 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder4;
/* 081 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter4;
/* 082 */   private UnsafeRow project_result5;
/* 083 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder5;
/* 084 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter5;
/* 085 */   private UnsafeRow agg_result4;
/* 086 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 087 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 088 */   private int agg_value10;
/* 089 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 090 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 091 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 092 */
/* 093 */   public GeneratedIterator(Object[] references) {
/* 094 */     this.references = references;
/* 095 */   }
/* 096 */
/* 097 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 098 */     partitionIndex = index;
/* 099 */     this.inputs = inputs;
/* 100 */     wholestagecodegen_init_0();
/* 101 */     wholestagecodegen_init_1();
/* 102 */     wholestagecodegen_init_2();
/* 103 */     wholestagecodegen_init_3();
/* 104 */     wholestagecodegen_init_4();
/* 105 */     wholestagecodegen_init_5();
/* 106 */
/* 107 */   }
/* 108 */
/* 109 */   private void wholestagecodegen_init_0() {
/* 110 */     agg_initAgg = false;
/* 111 */
/* 112 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 113 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 114 */
/* 115 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 116 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 117 */     scan_input = inputs[0];
/* 118 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 119 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 120 */     scan_scanTime1 = 0;
/* 121 */     scan_batch = null;
/* 122 */     scan_batchIdx = 0;
/* 123 */     scan_colInstance0 = null;
/* 124 */     scan_colInstance1 = null;
/* 125 */     scan_colInstance2 = null;
/* 126 */     scan_colInstance3 = null;
/* 127 */     scan_colInstance4 = null;
/* 128 */     scan_result = new UnsafeRow(5);
/* 129 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 130 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 5);
/* 131 */
/* 132 */   }
/* 133 */
/* 134 */   private void wholestagecodegen_init_3() {
/* 135 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 7);
/* 136 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[15];
/* 137 */
/* 138 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 139 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 140 */
/* 141 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 142 */     bhj_result2 = new UnsafeRow(9);
/* 143 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 64);
/* 144 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 9);
/* 145 */     project_result3 = new UnsafeRow(7);
/* 146 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 64);
/* 147 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 7);
/* 148 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[17];
/* 149 */
/* 150 */   }
/* 151 */
/* 152 */   private void scan_nextBatch() throws java.io.IOException {
/* 153 */     long getBatchStart = System.nanoTime();
/* 154 */     if (scan_input.hasNext()) {
/* 155 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 156 */       scan_numOutputRows.add(scan_batch.numRows());
/* 157 */       scan_batchIdx = 0;
/* 158 */       scan_colInstance0 = scan_batch.column(0);
/* 159 */       scan_colInstance1 = scan_batch.column(1);
/* 160 */       scan_colInstance2 = scan_batch.column(2);
/* 161 */       scan_colInstance3 = scan_batch.column(3);
/* 162 */       scan_colInstance4 = scan_batch.column(4);
/* 163 */
/* 164 */     }
/* 165 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 166 */   }
/* 167 */
/* 168 */   public class agg_FastHashMap {
/* 169 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 170 */     private int[] buckets;
/* 171 */     private int capacity = 1 << 16;
/* 172 */     private double loadFactor = 0.5;
/* 173 */     private int numBuckets = (int) (capacity / loadFactor);
/* 174 */     private int maxSteps = 2;
/* 175 */     private int numRows = 0;
/* 176 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 177 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 178 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 179 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.StringType);
/* 180 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 181 */     private Object emptyVBase;
/* 182 */     private long emptyVOff;
/* 183 */     private int emptyVLen;
/* 184 */     private boolean isBatchFull = false;
/* 185 */
/* 186 */     public agg_FastHashMap(
/* 187 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 188 */       InternalRow emptyAggregationBuffer) {
/* 189 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 190 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 191 */
/* 192 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 193 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 194 */
/* 195 */       emptyVBase = emptyBuffer;
/* 196 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 197 */       emptyVLen = emptyBuffer.length;
/* 198 */
/* 199 */       buckets = new int[numBuckets];
/* 200 */       java.util.Arrays.fill(buckets, -1);
/* 201 */     }
/* 202 */
/* 203 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, int agg_key1, int agg_key2, UTF8String agg_key3) {
/* 204 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3);
/* 205 */       int step = 0;
/* 206 */       int idx = (int) h & (numBuckets - 1);
/* 207 */       while (step < maxSteps) {
/* 208 */         // Return bucket index if it's either an empty slot or already contains the key
/* 209 */         if (buckets[idx] == -1) {
/* 210 */           if (numRows < capacity && !isBatchFull) {
/* 211 */             // creating the unsafe for new entry
/* 212 */             UnsafeRow agg_result = new UnsafeRow(4);
/* 213 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 214 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 215 */               64);
/* 216 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 217 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 218 */               agg_holder,
/* 219 */               4);
/* 220 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 221 */             agg_rowWriter.zeroOutNullBytes();
/* 222 */             agg_rowWriter.write(0, agg_key);
/* 223 */             agg_rowWriter.write(1, agg_key1);
/* 224 */             agg_rowWriter.write(2, agg_key2);
/* 225 */             agg_rowWriter.write(3, agg_key3);
/* 226 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 227 */             Object kbase = agg_result.getBaseObject();
/* 228 */             long koff = agg_result.getBaseOffset();
/* 229 */             int klen = agg_result.getSizeInBytes();
/* 230 */
/* 231 */             UnsafeRow vRow
/* 232 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 233 */             if (vRow == null) {
/* 234 */               isBatchFull = true;
/* 235 */             } else {
/* 236 */               buckets[idx] = numRows++;
/* 237 */             }
/* 238 */             return vRow;
/* 239 */           } else {
/* 240 */             // No more space
/* 241 */             return null;
/* 242 */           }
/* 243 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3)) {
/* 244 */           return batch.getValueRow(buckets[idx]);
/* 245 */         }
/* 246 */         idx = (idx + 1) & (numBuckets - 1);
/* 247 */         step++;
/* 248 */       }
/* 249 */       // Didn't find it
/* 250 */       return null;
/* 251 */     }
/* 252 */
/* 253 */     private boolean equals(int idx, UTF8String agg_key, int agg_key1, int agg_key2, UTF8String agg_key3) {
/* 254 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 255 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getInt(1) == agg_key1) && (row.getInt(2) == agg_key2) && (row.getUTF8String(3).equals(agg_key3));
/* 256 */     }
/* 257 */
/* 258 */     private long hash(UTF8String agg_key, int agg_key1, int agg_key2, UTF8String agg_key3) {
/* 259 */       long agg_hash = 0;
/* 260 */
/* 261 */       int agg_result = 0;
/* 262 */       byte[] agg_bytes = agg_key.getBytes();
/* 263 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 264 */         int agg_hash1 = agg_bytes[i];
/* 265 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 266 */       }
/* 267 */
/* 268 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 269 */
/* 270 */       int agg_result1 = agg_key1;
/* 271 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 272 */
/* 273 */       int agg_result2 = agg_key2;
/* 274 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 275 */
/* 276 */       int agg_result3 = 0;
/* 277 */       byte[] agg_bytes1 = agg_key3.getBytes();
/* 278 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 279 */         int agg_hash2 = agg_bytes1[i];
/* 280 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash2 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 281 */       }
/* 282 */
/* 283 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 284 */
/* 285 */       return agg_hash;
/* 286 */     }
/* 287 */
/* 288 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 289 */       return batch.rowIterator();
/* 290 */     }
/* 291 */
/* 292 */     public void close() {
/* 293 */       batch.close();
/* 294 */     }
/* 295 */
/* 296 */   }
/* 297 */
/* 298 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 299 */     agg_hashMap = agg_plan.createHashMap();
/* 300 */
/* 301 */     if (scan_batch == null) {
/* 302 */       scan_nextBatch();
/* 303 */     }
/* 304 */     while (scan_batch != null) {
/* 305 */       int scan_numRows = scan_batch.numRows();
/* 306 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 307 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 308 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 309 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 310 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 311 */
/* 312 */         if (!(!(scan_isNull))) continue;
/* 313 */
/* 314 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 315 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 316 */
/* 317 */         if (!(!(scan_isNull1))) continue;
/* 318 */
/* 319 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 320 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 321 */
/* 322 */         if (!(!(scan_isNull2))) continue;
/* 323 */
/* 324 */         filter_numOutputRows.add(1);
/* 325 */
/* 326 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 327 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 328 */
/* 329 */         // generate join key for stream side
/* 330 */
/* 331 */         boolean bhj_isNull = scan_isNull4;
/* 332 */         long bhj_value = -1L;
/* 333 */         if (!scan_isNull4) {
/* 334 */           bhj_value = (long) scan_value4;
/* 335 */         }
/* 336 */         // find matches from HashedRelation
/* 337 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 338 */         if (bhj_matched == null) continue;
/* 339 */
/* 340 */         bhj_numOutputRows.add(1);
/* 341 */
/* 342 */         // generate join key for stream side
/* 343 */
/* 344 */         boolean bhj_isNull9 = false;
/* 345 */         long bhj_value9 = -1L;
/* 346 */         if (!false) {
/* 347 */           bhj_value9 = (long) scan_value;
/* 348 */         }
/* 349 */         // find matches from HashedRelation
/* 350 */         UnsafeRow bhj_matched1 = bhj_isNull9 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value9);
/* 351 */         if (bhj_matched1 == null) continue;
/* 352 */
/* 353 */         bhj_numOutputRows1.add(1);
/* 354 */
/* 355 */         // generate join key for stream side
/* 356 */
/* 357 */         boolean bhj_isNull25 = false;
/* 358 */         long bhj_value25 = -1L;
/* 359 */         if (!false) {
/* 360 */           bhj_value25 = (long) scan_value1;
/* 361 */         }
/* 362 */         // find matches from HashedRelation
/* 363 */         UnsafeRow bhj_matched2 = bhj_isNull25 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value25);
/* 364 */         if (bhj_matched2 == null) continue;
/* 365 */
/* 366 */         bhj_numOutputRows2.add(1);
/* 367 */
/* 368 */         boolean bhj_isNull28 = bhj_matched2.isNullAt(1);
/* 369 */         int bhj_value28 = bhj_isNull28 ? -1 : (bhj_matched2.getInt(1));
/* 370 */
/* 371 */         // generate join key for stream side
/* 372 */
/* 373 */         boolean bhj_isNull38 = bhj_isNull28;
/* 374 */         long bhj_value38 = -1L;
/* 375 */         if (!bhj_isNull28) {
/* 376 */           bhj_value38 = (long) bhj_value28;
/* 377 */         }
/* 378 */         // find matches from HashedRelation
/* 379 */         UnsafeRow bhj_matched3 = bhj_isNull38 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value38);
/* 380 */         if (bhj_matched3 == null) continue;
/* 381 */
/* 382 */         bhj_numOutputRows3.add(1);
/* 383 */
/* 384 */         boolean bhj_isNull41 = bhj_matched3.isNullAt(1);
/* 385 */         UTF8String bhj_value41 = bhj_isNull41 ? null : (bhj_matched3.getUTF8String(1));
/* 386 */
/* 387 */         // generate join key for stream side
/* 388 */
/* 389 */         boolean bhj_isNull51 = false;
/* 390 */         long bhj_value51 = -1L;
/* 391 */         if (!false) {
/* 392 */           bhj_value51 = (long) scan_value2;
/* 393 */         }
/* 394 */         // find matches from HashedRelation
/* 395 */         UnsafeRow bhj_matched4 = bhj_isNull51 ? null: (UnsafeRow)bhj_relation4.getValue(bhj_value51);
/* 396 */         if (bhj_matched4 == null) continue;
/* 397 */
/* 398 */         boolean bhj_isNull54 = bhj_matched4.isNullAt(1);
/* 399 */         UTF8String bhj_value54 = bhj_isNull54 ? null : (bhj_matched4.getUTF8String(1));
/* 400 */
/* 401 */         boolean bhj_isNull56 = true;
/* 402 */         boolean bhj_value56 = false;
/* 403 */
/* 404 */         boolean bhj_isNull57 = true;
/* 405 */         UTF8String bhj_value57 = null;
/* 406 */
/* 407 */         if (!bhj_isNull41) {
/* 408 */           bhj_isNull57 = false; // resultCode could change nullability.
/* 409 */           bhj_value57 = bhj_value41.substringSQL(1, 5);
/* 410 */
/* 411 */         }
/* 412 */         if (!bhj_isNull57) {
/* 413 */           boolean bhj_isNull61 = true;
/* 414 */           UTF8String bhj_value61 = null;
/* 415 */
/* 416 */           if (!bhj_isNull54) {
/* 417 */             bhj_isNull61 = false; // resultCode could change nullability.
/* 418 */             bhj_value61 = bhj_value54.substringSQL(1, 5);
/* 419 */
/* 420 */           }
/* 421 */           if (!bhj_isNull61) {
/* 422 */             bhj_isNull56 = false; // resultCode could change nullability.
/* 423 */             bhj_value56 = bhj_value57.equals(bhj_value61);
/* 424 */
/* 425 */           }
/* 426 */
/* 427 */         }
/* 428 */         boolean bhj_isNull55 = bhj_isNull56;
/* 429 */         boolean bhj_value55 = false;
/* 430 */
/* 431 */         if (!bhj_isNull56) {
/* 432 */           bhj_value55 = !(bhj_value56);
/* 433 */         }
/* 434 */         if (bhj_isNull55 || !bhj_value55) continue;
/* 435 */
/* 436 */         bhj_numOutputRows4.add(1);
/* 437 */
/* 438 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 439 */         double scan_value3 = scan_isNull3 ? -1.0 : (scan_colInstance3.getDouble(scan_rowIdx));
/* 440 */         boolean bhj_isNull12 = bhj_matched1.isNullAt(1);
/* 441 */         int bhj_value12 = bhj_isNull12 ? -1 : (bhj_matched1.getInt(1));
/* 442 */         boolean bhj_isNull13 = bhj_matched1.isNullAt(2);
/* 443 */         UTF8String bhj_value13 = bhj_isNull13 ? null : (bhj_matched1.getUTF8String(2));
/* 444 */         boolean bhj_isNull14 = bhj_matched1.isNullAt(3);
/* 445 */         int bhj_value14 = bhj_isNull14 ? -1 : (bhj_matched1.getInt(3));
/* 446 */         boolean bhj_isNull15 = bhj_matched1.isNullAt(4);
/* 447 */         UTF8String bhj_value15 = bhj_isNull15 ? null : (bhj_matched1.getUTF8String(4));
/* 448 */
/* 449 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 450 */
/* 451 */         UnsafeRow agg_fastAggBuffer = null;
/* 452 */
/* 453 */         if (true) {
/* 454 */           if (!bhj_isNull13 && !bhj_isNull12 && !bhj_isNull14 && !bhj_isNull15) {
/* 455 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 456 */               bhj_value13, bhj_value12, bhj_value14, bhj_value15);
/* 457 */           }
/* 458 */         }
/* 459 */
/* 460 */         if (agg_fastAggBuffer == null) {
/* 461 */           // generate grouping key
/* 462 */           agg_holder.reset();
/* 463 */
/* 464 */           agg_rowWriter.zeroOutNullBytes();
/* 465 */
/* 466 */           if (bhj_isNull13) {
/* 467 */             agg_rowWriter.setNullAt(0);
/* 468 */           } else {
/* 469 */             agg_rowWriter.write(0, bhj_value13);
/* 470 */           }
/* 471 */
/* 472 */           if (bhj_isNull12) {
/* 473 */             agg_rowWriter.setNullAt(1);
/* 474 */           } else {
/* 475 */             agg_rowWriter.write(1, bhj_value12);
/* 476 */           }
/* 477 */
/* 478 */           if (bhj_isNull14) {
/* 479 */             agg_rowWriter.setNullAt(2);
/* 480 */           } else {
/* 481 */             agg_rowWriter.write(2, bhj_value14);
/* 482 */           }
/* 483 */
/* 484 */           if (bhj_isNull15) {
/* 485 */             agg_rowWriter.setNullAt(3);
/* 486 */           } else {
/* 487 */             agg_rowWriter.write(3, bhj_value15);
/* 488 */           }
/* 489 */           agg_result4.setTotalSize(agg_holder.totalSize());
/* 490 */           agg_value10 = 42;
/* 491 */
/* 492 */           if (!bhj_isNull13) {
/* 493 */             agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value13.getBaseObject(), bhj_value13.getBaseOffset(), bhj_value13.numBytes(), agg_value10);
/* 494 */           }
/* 495 */
/* 496 */           if (!bhj_isNull12) {
/* 497 */             agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value12, agg_value10);
/* 498 */           }
/* 499 */
/* 500 */           if (!bhj_isNull14) {
/* 501 */             agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value14, agg_value10);
/* 502 */           }
/* 503 */
/* 504 */           if (!bhj_isNull15) {
/* 505 */             agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value15.getBaseObject(), bhj_value15.getBaseOffset(), bhj_value15.numBytes(), agg_value10);
/* 506 */           }
/* 507 */           if (true) {
/* 508 */             // try to get the buffer from hash map
/* 509 */             agg_unsafeRowAggBuffer =
/* 510 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value10);
/* 511 */           }
/* 512 */           if (agg_unsafeRowAggBuffer == null) {
/* 513 */             if (agg_sorter == null) {
/* 514 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 515 */             } else {
/* 516 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 517 */             }
/* 518 */
/* 519 */             // the hash map had be spilled, it should have enough memory now,
/* 520 */             // try  to allocate buffer again.
/* 521 */             agg_unsafeRowAggBuffer =
/* 522 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value10);
/* 523 */             if (agg_unsafeRowAggBuffer == null) {
/* 524 */               // failed to allocate the first page
/* 525 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 526 */             }
/* 527 */           }
/* 528 */         }
/* 529 */
/* 530 */         if (agg_fastAggBuffer != null) {
/* 531 */           // update fast row
/* 532 */
/* 533 */           // common sub-expressions
/* 534 */
/* 535 */           // evaluate aggregate function
/* 536 */           boolean agg_isNull23 = true;
/* 537 */           double agg_value24 = -1.0;
/* 538 */
/* 539 */           boolean agg_isNull25 = agg_fastAggBuffer.isNullAt(0);
/* 540 */           double agg_value26 = agg_isNull25 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 541 */           boolean agg_isNull24 = agg_isNull25;
/* 542 */           double agg_value25 = agg_value26;
/* 543 */           if (agg_isNull24) {
/* 544 */             boolean agg_isNull26 = false;
/* 545 */             double agg_value27 = -1.0;
/* 546 */             if (!false) {
/* 547 */               agg_value27 = (double) 0;
/* 548 */             }
/* 549 */             if (!agg_isNull26) {
/* 550 */               agg_isNull24 = false;
/* 551 */               agg_value25 = agg_value27;
/* 552 */             }
/* 553 */           }
/* 554 */
/* 555 */           if (!scan_isNull3) {
/* 556 */             agg_isNull23 = false; // resultCode could change nullability.
/* 557 */             agg_value24 = agg_value25 + scan_value3;
/* 558 */
/* 559 */           }
/* 560 */           boolean agg_isNull22 = agg_isNull23;
/* 561 */           double agg_value23 = agg_value24;
/* 562 */           if (agg_isNull22) {
/* 563 */             boolean agg_isNull29 = agg_fastAggBuffer.isNullAt(0);
/* 564 */             double agg_value30 = agg_isNull29 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 565 */             if (!agg_isNull29) {
/* 566 */               agg_isNull22 = false;
/* 567 */               agg_value23 = agg_value30;
/* 568 */             }
/* 569 */           }
/* 570 */           // update fast row
/* 571 */           if (!agg_isNull22) {
/* 572 */             agg_fastAggBuffer.setDouble(0, agg_value23);
/* 573 */           } else {
/* 574 */             agg_fastAggBuffer.setNullAt(0);
/* 575 */           }
/* 576 */
/* 577 */         } else {
/* 578 */           // update unsafe row
/* 579 */
/* 580 */           // common sub-expressions
/* 581 */
/* 582 */           // evaluate aggregate function
/* 583 */           boolean agg_isNull15 = true;
/* 584 */           double agg_value16 = -1.0;
/* 585 */
/* 586 */           boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 587 */           double agg_value18 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 588 */           boolean agg_isNull16 = agg_isNull17;
/* 589 */           double agg_value17 = agg_value18;
/* 590 */           if (agg_isNull16) {
/* 591 */             boolean agg_isNull18 = false;
/* 592 */             double agg_value19 = -1.0;
/* 593 */             if (!false) {
/* 594 */               agg_value19 = (double) 0;
/* 595 */             }
/* 596 */             if (!agg_isNull18) {
/* 597 */               agg_isNull16 = false;
/* 598 */               agg_value17 = agg_value19;
/* 599 */             }
/* 600 */           }
/* 601 */
/* 602 */           if (!scan_isNull3) {
/* 603 */             agg_isNull15 = false; // resultCode could change nullability.
/* 604 */             agg_value16 = agg_value17 + scan_value3;
/* 605 */
/* 606 */           }
/* 607 */           boolean agg_isNull14 = agg_isNull15;
/* 608 */           double agg_value15 = agg_value16;
/* 609 */           if (agg_isNull14) {
/* 610 */             boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 611 */             double agg_value22 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 612 */             if (!agg_isNull21) {
/* 613 */               agg_isNull14 = false;
/* 614 */               agg_value15 = agg_value22;
/* 615 */             }
/* 616 */           }
/* 617 */           // update unsafe row buffer
/* 618 */           if (!agg_isNull14) {
/* 619 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value15);
/* 620 */           } else {
/* 621 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 622 */           }
/* 623 */
/* 624 */         }
/* 625 */         // shouldStop check is eliminated
/* 626 */       }
/* 627 */       scan_batchIdx = scan_numRows;
/* 628 */       scan_batch = null;
/* 629 */       scan_nextBatch();
/* 630 */     }
/* 631 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 632 */     scan_scanTime1 = 0;
/* 633 */
/* 634 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 635 */
/* 636 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 637 */   }
/* 638 */
/* 639 */   private void wholestagecodegen_init_5() {
/* 640 */     this.bhj_numOutputRows4 = (org.apache.spark.sql.execution.metric.SQLMetric) references[20];
/* 641 */     bhj_result4 = new UnsafeRow(9);
/* 642 */     this.bhj_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result4, 128);
/* 643 */     this.bhj_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder4, 9);
/* 644 */     project_result5 = new UnsafeRow(5);
/* 645 */     this.project_holder5 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result5, 64);
/* 646 */     this.project_rowWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder5, 5);
/* 647 */     agg_result4 = new UnsafeRow(4);
/* 648 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result4, 64);
/* 649 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 650 */
/* 651 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 652 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[21];
/* 653 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[22];
/* 654 */
/* 655 */   }
/* 656 */
/* 657 */   private void wholestagecodegen_init_2() {
/* 658 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 6);
/* 659 */     project_result1 = new UnsafeRow(4);
/* 660 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 661 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 4);
/* 662 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 663 */
/* 664 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 665 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 666 */
/* 667 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 668 */     bhj_result1 = new UnsafeRow(9);
/* 669 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 670 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 9);
/* 671 */     project_result2 = new UnsafeRow(7);
/* 672 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 673 */
/* 674 */   }
/* 675 */
/* 676 */   private void wholestagecodegen_init_1() {
/* 677 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 678 */     filter_result = new UnsafeRow(5);
/* 679 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 680 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 681 */     project_result = new UnsafeRow(5);
/* 682 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 683 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 684 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[11];
/* 685 */
/* 686 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 687 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 688 */
/* 689 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 690 */     bhj_result = new UnsafeRow(6);
/* 691 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 692 */
/* 693 */   }
/* 694 */
/* 695 */   private void wholestagecodegen_init_4() {
/* 696 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 697 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 698 */
/* 699 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 700 */     bhj_result3 = new UnsafeRow(9);
/* 701 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 96);
/* 702 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 9);
/* 703 */     project_result4 = new UnsafeRow(7);
/* 704 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 96);
/* 705 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 7);
/* 706 */     this.bhj_broadcast4 = (org.apache.spark.broadcast.TorrentBroadcast) references[19];
/* 707 */
/* 708 */     bhj_relation4 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast4.value()).asReadOnlyCopy();
/* 709 */     incPeakExecutionMemory(bhj_relation4.estimatedSize());
/* 710 */
/* 711 */   }
/* 712 */
/* 713 */   protected void processNext() throws java.io.IOException {
/* 714 */     if (!agg_initAgg) {
/* 715 */       agg_initAgg = true;
/* 716 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 717 */       agg_doAggregateWithKeys();
/* 718 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 719 */     }
/* 720 */
/* 721 */     // output the result
/* 722 */
/* 723 */     while (agg_fastHashMapIter.next()) {
/* 724 */       wholestagecodegen_numOutputRows.add(1);
/* 725 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 726 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 727 */
/* 728 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 729 */
/* 730 */       append(agg_resultRow);
/* 731 */
/* 732 */       if (shouldStop()) return;
/* 733 */     }
/* 734 */     agg_fastHashMap.close();
/* 735 */
/* 736 */     while (agg_mapIter.next()) {
/* 737 */       wholestagecodegen_numOutputRows.add(1);
/* 738 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 739 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 740 */
/* 741 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 742 */
/* 743 */       append(agg_resultRow);
/* 744 */
/* 745 */       if (shouldStop()) return;
/* 746 */     }
/* 747 */
/* 748 */     agg_mapIter.close();
/* 749 */     if (agg_sorter == null) {
/* 750 */       agg_hashMap.free();
/* 751 */     }
/* 752 */   }
/* 753 */ }
