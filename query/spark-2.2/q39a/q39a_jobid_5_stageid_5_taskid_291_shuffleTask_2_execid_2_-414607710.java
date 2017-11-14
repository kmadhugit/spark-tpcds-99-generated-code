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
/* 037 */   private UnsafeRow scan_result;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 041 */   private UnsafeRow filter_result;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 044 */   private UnsafeRow project_result;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 047 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 048 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 049 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 050 */   private UnsafeRow bhj_result;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 053 */   private UnsafeRow project_result1;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 056 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 057 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 058 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 059 */   private UnsafeRow bhj_result1;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 062 */   private UnsafeRow project_result2;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 065 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 066 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 067 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 068 */   private UnsafeRow bhj_result2;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 071 */   private UnsafeRow project_result3;
/* 072 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 073 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 074 */   private UnsafeRow agg_result4;
/* 075 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 076 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 077 */   private int agg_value19;
/* 078 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 079 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 080 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 081 */
/* 082 */   public GeneratedIterator(Object[] references) {
/* 083 */     this.references = references;
/* 084 */   }
/* 085 */
/* 086 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 087 */     partitionIndex = index;
/* 088 */     this.inputs = inputs;
/* 089 */     wholestagecodegen_init_0();
/* 090 */     wholestagecodegen_init_1();
/* 091 */     wholestagecodegen_init_2();
/* 092 */     wholestagecodegen_init_3();
/* 093 */     wholestagecodegen_init_4();
/* 094 */
/* 095 */   }
/* 096 */
/* 097 */   private void wholestagecodegen_init_0() {
/* 098 */     agg_initAgg = false;
/* 099 */
/* 100 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 101 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 102 */
/* 103 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 104 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 105 */     scan_input = inputs[0];
/* 106 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 107 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 108 */     scan_scanTime1 = 0;
/* 109 */     scan_batch = null;
/* 110 */     scan_batchIdx = 0;
/* 111 */     scan_colInstance0 = null;
/* 112 */     scan_colInstance1 = null;
/* 113 */     scan_colInstance2 = null;
/* 114 */     scan_colInstance3 = null;
/* 115 */     scan_result = new UnsafeRow(4);
/* 116 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 117 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 118 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 119 */
/* 120 */   }
/* 121 */
/* 122 */   private void wholestagecodegen_init_3() {
/* 123 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[19];
/* 124 */
/* 125 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 126 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 127 */
/* 128 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[20];
/* 129 */     bhj_result2 = new UnsafeRow(7);
/* 130 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 32);
/* 131 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 7);
/* 132 */     project_result3 = new UnsafeRow(5);
/* 133 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 32);
/* 134 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 5);
/* 135 */     agg_result4 = new UnsafeRow(4);
/* 136 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result4, 32);
/* 137 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 138 */
/* 139 */   }
/* 140 */
/* 141 */   private void scan_nextBatch() throws java.io.IOException {
/* 142 */     long getBatchStart = System.nanoTime();
/* 143 */     if (scan_input.hasNext()) {
/* 144 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 145 */       scan_numOutputRows.add(scan_batch.numRows());
/* 146 */       scan_batchIdx = 0;
/* 147 */       scan_colInstance0 = scan_batch.column(0);
/* 148 */       scan_colInstance1 = scan_batch.column(1);
/* 149 */       scan_colInstance2 = scan_batch.column(2);
/* 150 */       scan_colInstance3 = scan_batch.column(3);
/* 151 */
/* 152 */     }
/* 153 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 154 */   }
/* 155 */
/* 156 */   public class agg_FastHashMap {
/* 157 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 158 */     private int[] buckets;
/* 159 */     private int capacity = 1 << 16;
/* 160 */     private double loadFactor = 0.5;
/* 161 */     private int numBuckets = (int) (capacity / loadFactor);
/* 162 */     private int maxSteps = 2;
/* 163 */     private int numRows = 0;
/* 164 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 165 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 166 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 167 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 168 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 169 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 170 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 171 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 172 */     .add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.LongType);
/* 173 */     private Object emptyVBase;
/* 174 */     private long emptyVOff;
/* 175 */     private int emptyVLen;
/* 176 */     private boolean isBatchFull = false;
/* 177 */
/* 178 */     public agg_FastHashMap(
/* 179 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 180 */       InternalRow emptyAggregationBuffer) {
/* 181 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 182 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 183 */
/* 184 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 185 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 186 */
/* 187 */       emptyVBase = emptyBuffer;
/* 188 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 189 */       emptyVLen = emptyBuffer.length;
/* 190 */
/* 191 */       buckets = new int[numBuckets];
/* 192 */       java.util.Arrays.fill(buckets, -1);
/* 193 */     }
/* 194 */
/* 195 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, int agg_key1, int agg_key2, int agg_key3) {
/* 196 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3);
/* 197 */       int step = 0;
/* 198 */       int idx = (int) h & (numBuckets - 1);
/* 199 */       while (step < maxSteps) {
/* 200 */         // Return bucket index if it's either an empty slot or already contains the key
/* 201 */         if (buckets[idx] == -1) {
/* 202 */           if (numRows < capacity && !isBatchFull) {
/* 203 */             // creating the unsafe for new entry
/* 204 */             UnsafeRow agg_result = new UnsafeRow(4);
/* 205 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 206 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 207 */               32);
/* 208 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 209 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 210 */               agg_holder,
/* 211 */               4);
/* 212 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 213 */             agg_rowWriter.zeroOutNullBytes();
/* 214 */             agg_rowWriter.write(0, agg_key);
/* 215 */             agg_rowWriter.write(1, agg_key1);
/* 216 */             agg_rowWriter.write(2, agg_key2);
/* 217 */             agg_rowWriter.write(3, agg_key3);
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
/* 235 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3)) {
/* 236 */           return batch.getValueRow(buckets[idx]);
/* 237 */         }
/* 238 */         idx = (idx + 1) & (numBuckets - 1);
/* 239 */         step++;
/* 240 */       }
/* 241 */       // Didn't find it
/* 242 */       return null;
/* 243 */     }
/* 244 */
/* 245 */     private boolean equals(int idx, UTF8String agg_key, int agg_key1, int agg_key2, int agg_key3) {
/* 246 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 247 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getInt(1) == agg_key1) && (row.getInt(2) == agg_key2) && (row.getInt(3) == agg_key3);
/* 248 */     }
/* 249 */
/* 250 */     private long hash(UTF8String agg_key, int agg_key1, int agg_key2, int agg_key3) {
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
/* 262 */       int agg_result1 = agg_key1;
/* 263 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 264 */
/* 265 */       int agg_result2 = agg_key2;
/* 266 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 267 */
/* 268 */       int agg_result3 = agg_key3;
/* 269 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 270 */
/* 271 */       return agg_hash;
/* 272 */     }
/* 273 */
/* 274 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 275 */       return batch.rowIterator();
/* 276 */     }
/* 277 */
/* 278 */     public void close() {
/* 279 */       batch.close();
/* 280 */     }
/* 281 */
/* 282 */   }
/* 283 */
/* 284 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 285 */     agg_hashMap = agg_plan.createHashMap();
/* 286 */
/* 287 */     if (scan_batch == null) {
/* 288 */       scan_nextBatch();
/* 289 */     }
/* 290 */     while (scan_batch != null) {
/* 291 */       int scan_numRows = scan_batch.numRows();
/* 292 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 293 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 294 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 295 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 296 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 297 */
/* 298 */         if (!(!(scan_isNull))) continue;
/* 299 */
/* 300 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 301 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 302 */
/* 303 */         if (!(!(scan_isNull1))) continue;
/* 304 */
/* 305 */         filter_numOutputRows.add(1);
/* 306 */
/* 307 */         // generate join key for stream side
/* 308 */
/* 309 */         boolean bhj_isNull = false;
/* 310 */         long bhj_value = -1L;
/* 311 */         if (!false) {
/* 312 */           bhj_value = (long) scan_value;
/* 313 */         }
/* 314 */         // find matches from HashedRelation
/* 315 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 316 */         if (bhj_matched == null) continue;
/* 317 */
/* 318 */         bhj_numOutputRows.add(1);
/* 319 */
/* 320 */         // generate join key for stream side
/* 321 */
/* 322 */         boolean bhj_isNull8 = false;
/* 323 */         long bhj_value8 = -1L;
/* 324 */         if (!false) {
/* 325 */           bhj_value8 = (long) scan_value1;
/* 326 */         }
/* 327 */         // find matches from HashedRelation
/* 328 */         UnsafeRow bhj_matched1 = bhj_isNull8 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value8);
/* 329 */         if (bhj_matched1 == null) continue;
/* 330 */
/* 331 */         bhj_numOutputRows1.add(1);
/* 332 */
/* 333 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 334 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 335 */
/* 336 */         // generate join key for stream side
/* 337 */
/* 338 */         boolean bhj_isNull18 = scan_isNull3;
/* 339 */         long bhj_value18 = -1L;
/* 340 */         if (!scan_isNull3) {
/* 341 */           bhj_value18 = (long) scan_value3;
/* 342 */         }
/* 343 */         // find matches from HashedRelation
/* 344 */         UnsafeRow bhj_matched2 = bhj_isNull18 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value18);
/* 345 */         if (bhj_matched2 == null) continue;
/* 346 */
/* 347 */         bhj_numOutputRows2.add(1);
/* 348 */
/* 349 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 350 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 351 */         boolean bhj_isNull2 = bhj_matched.isNullAt(0);
/* 352 */         int bhj_value2 = bhj_isNull2 ? -1 : (bhj_matched.getInt(0));
/* 353 */         boolean bhj_isNull10 = bhj_matched1.isNullAt(0);
/* 354 */         int bhj_value10 = bhj_isNull10 ? -1 : (bhj_matched1.getInt(0));
/* 355 */         boolean bhj_isNull11 = bhj_matched1.isNullAt(1);
/* 356 */         UTF8String bhj_value11 = bhj_isNull11 ? null : (bhj_matched1.getUTF8String(1));
/* 357 */         boolean bhj_isNull21 = bhj_matched2.isNullAt(1);
/* 358 */         int bhj_value21 = bhj_isNull21 ? -1 : (bhj_matched2.getInt(1));
/* 359 */
/* 360 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 361 */
/* 362 */         UnsafeRow agg_fastAggBuffer = null;
/* 363 */
/* 364 */         if (true) {
/* 365 */           if (!bhj_isNull11 && !bhj_isNull10 && !bhj_isNull2 && !bhj_isNull21) {
/* 366 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 367 */               bhj_value11, bhj_value10, bhj_value2, bhj_value21);
/* 368 */           }
/* 369 */         }
/* 370 */
/* 371 */         if (agg_fastAggBuffer == null) {
/* 372 */           // generate grouping key
/* 373 */           agg_holder.reset();
/* 374 */
/* 375 */           agg_rowWriter.zeroOutNullBytes();
/* 376 */
/* 377 */           if (bhj_isNull11) {
/* 378 */             agg_rowWriter.setNullAt(0);
/* 379 */           } else {
/* 380 */             agg_rowWriter.write(0, bhj_value11);
/* 381 */           }
/* 382 */
/* 383 */           if (bhj_isNull10) {
/* 384 */             agg_rowWriter.setNullAt(1);
/* 385 */           } else {
/* 386 */             agg_rowWriter.write(1, bhj_value10);
/* 387 */           }
/* 388 */
/* 389 */           if (bhj_isNull2) {
/* 390 */             agg_rowWriter.setNullAt(2);
/* 391 */           } else {
/* 392 */             agg_rowWriter.write(2, bhj_value2);
/* 393 */           }
/* 394 */
/* 395 */           if (bhj_isNull21) {
/* 396 */             agg_rowWriter.setNullAt(3);
/* 397 */           } else {
/* 398 */             agg_rowWriter.write(3, bhj_value21);
/* 399 */           }
/* 400 */           agg_result4.setTotalSize(agg_holder.totalSize());
/* 401 */           agg_value19 = 42;
/* 402 */
/* 403 */           if (!bhj_isNull11) {
/* 404 */             agg_value19 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value11.getBaseObject(), bhj_value11.getBaseOffset(), bhj_value11.numBytes(), agg_value19);
/* 405 */           }
/* 406 */
/* 407 */           if (!bhj_isNull10) {
/* 408 */             agg_value19 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value10, agg_value19);
/* 409 */           }
/* 410 */
/* 411 */           if (!bhj_isNull2) {
/* 412 */             agg_value19 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value2, agg_value19);
/* 413 */           }
/* 414 */
/* 415 */           if (!bhj_isNull21) {
/* 416 */             agg_value19 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value21, agg_value19);
/* 417 */           }
/* 418 */           if (true) {
/* 419 */             // try to get the buffer from hash map
/* 420 */             agg_unsafeRowAggBuffer =
/* 421 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value19);
/* 422 */           }
/* 423 */           if (agg_unsafeRowAggBuffer == null) {
/* 424 */             if (agg_sorter == null) {
/* 425 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 426 */             } else {
/* 427 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 428 */             }
/* 429 */
/* 430 */             // the hash map had be spilled, it should have enough memory now,
/* 431 */             // try  to allocate buffer again.
/* 432 */             agg_unsafeRowAggBuffer =
/* 433 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value19);
/* 434 */             if (agg_unsafeRowAggBuffer == null) {
/* 435 */               // failed to allocate the first page
/* 436 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 437 */             }
/* 438 */           }
/* 439 */         }
/* 440 */
/* 441 */         if (agg_fastAggBuffer != null) {
/* 442 */           // update fast row
/* 443 */
/* 444 */           // common sub-expressions
/* 445 */           boolean agg_isNull75 = scan_isNull2;
/* 446 */           long agg_value80 = -1L;
/* 447 */           if (!scan_isNull2) {
/* 448 */             agg_value80 = (long) scan_value2;
/* 449 */           }
/* 450 */           boolean agg_isNull78 = scan_isNull2;
/* 451 */           double agg_value83 = -1.0;
/* 452 */           if (!scan_isNull2) {
/* 453 */             agg_value83 = (double) scan_value2;
/* 454 */           }
/* 455 */           // evaluate aggregate function
/* 456 */           boolean agg_isNull80 = false;
/* 457 */           double agg_value85 = -1.0;
/* 458 */           if (!false && agg_isNull78) {
/* 459 */             double agg_value86 = agg_fastAggBuffer.getDouble(0);
/* 460 */             agg_isNull80 = false;
/* 461 */             agg_value85 = agg_value86;
/* 462 */           } else {
/* 463 */             boolean agg_isNull82 = false;
/* 464 */
/* 465 */             double agg_value88 = agg_fastAggBuffer.getDouble(0);
/* 466 */
/* 467 */             double agg_value87 = -1.0;
/* 468 */             agg_value87 = agg_value88 + 1.0D;
/* 469 */             agg_isNull80 = false;
/* 470 */             agg_value85 = agg_value87;
/* 471 */           }
/* 472 */           boolean agg_isNull85 = false;
/* 473 */           double agg_value90 = -1.0;
/* 474 */           if (!false && agg_isNull78) {
/* 475 */             double agg_value91 = agg_fastAggBuffer.getDouble(1);
/* 476 */             agg_isNull85 = false;
/* 477 */             agg_value90 = agg_value91;
/* 478 */           } else {
/* 479 */             boolean agg_isNull87 = true;
/* 480 */             double agg_value92 = -1.0;
/* 481 */
/* 482 */             double agg_value93 = agg_fastAggBuffer.getDouble(1);
/* 483 */
/* 484 */             boolean agg_isNull94 = false;
/* 485 */
/* 486 */             double agg_value100 = agg_fastAggBuffer.getDouble(0);
/* 487 */
/* 488 */             double agg_value99 = -1.0;
/* 489 */             agg_value99 = agg_value100 + 1.0D;
/* 490 */             boolean agg_isNull89 = false;
/* 491 */             double agg_value94 = -1.0;
/* 492 */             if (false || agg_value99 == 0) {
/* 493 */               agg_isNull89 = true;
/* 494 */             } else {
/* 495 */               boolean agg_isNull90 = true;
/* 496 */               double agg_value95 = -1.0;
/* 497 */
/* 498 */               boolean agg_isNull91 = scan_isNull2;
/* 499 */               double agg_value96 = -1.0;
/* 500 */               if (!scan_isNull2) {
/* 501 */                 agg_value96 = (double) scan_value2;
/* 502 */               }
/* 503 */               if (!agg_isNull91) {
/* 504 */                 double agg_value98 = agg_fastAggBuffer.getDouble(1);
/* 505 */
/* 506 */                 agg_isNull90 = false; // resultCode could change nullability.
/* 507 */                 agg_value95 = agg_value96 - agg_value98;
/* 508 */
/* 509 */               }
/* 510 */               if (agg_isNull90) {
/* 511 */                 agg_isNull89 = true;
/* 512 */               } else {
/* 513 */                 agg_value94 = (double)(agg_value95 / agg_value99);
/* 514 */               }
/* 515 */             }
/* 516 */             if (!agg_isNull89) {
/* 517 */               agg_isNull87 = false; // resultCode could change nullability.
/* 518 */               agg_value92 = agg_value93 + agg_value94;
/* 519 */
/* 520 */             }
/* 521 */             agg_isNull85 = agg_isNull87;
/* 522 */             agg_value90 = agg_value92;
/* 523 */           }
/* 524 */           boolean agg_isNull97 = false;
/* 525 */           double agg_value102 = -1.0;
/* 526 */           if (!false && agg_isNull78) {
/* 527 */             double agg_value103 = agg_fastAggBuffer.getDouble(2);
/* 528 */             agg_isNull97 = false;
/* 529 */             agg_value102 = agg_value103;
/* 530 */           } else {
/* 531 */             boolean agg_isNull99 = true;
/* 532 */             double agg_value104 = -1.0;
/* 533 */
/* 534 */             double agg_value105 = agg_fastAggBuffer.getDouble(2);
/* 535 */
/* 536 */             boolean agg_isNull101 = true;
/* 537 */             double agg_value106 = -1.0;
/* 538 */
/* 539 */             boolean agg_isNull102 = true;
/* 540 */             double agg_value107 = -1.0;
/* 541 */
/* 542 */             boolean agg_isNull103 = scan_isNull2;
/* 543 */             double agg_value108 = -1.0;
/* 544 */             if (!scan_isNull2) {
/* 545 */               agg_value108 = (double) scan_value2;
/* 546 */             }
/* 547 */             if (!agg_isNull103) {
/* 548 */               double agg_value110 = agg_fastAggBuffer.getDouble(1);
/* 549 */
/* 550 */               agg_isNull102 = false; // resultCode could change nullability.
/* 551 */               agg_value107 = agg_value108 - agg_value110;
/* 552 */
/* 553 */             }
/* 554 */             if (!agg_isNull102) {
/* 555 */               boolean agg_isNull106 = true;
/* 556 */               double agg_value111 = -1.0;
/* 557 */
/* 558 */               boolean agg_isNull107 = true;
/* 559 */               double agg_value112 = -1.0;
/* 560 */
/* 561 */               boolean agg_isNull108 = scan_isNull2;
/* 562 */               double agg_value113 = -1.0;
/* 563 */               if (!scan_isNull2) {
/* 564 */                 agg_value113 = (double) scan_value2;
/* 565 */               }
/* 566 */               if (!agg_isNull108) {
/* 567 */                 double agg_value115 = agg_fastAggBuffer.getDouble(1);
/* 568 */
/* 569 */                 agg_isNull107 = false; // resultCode could change nullability.
/* 570 */                 agg_value112 = agg_value113 - agg_value115;
/* 571 */
/* 572 */               }
/* 573 */               if (!agg_isNull107) {
/* 574 */                 boolean agg_isNull116 = false;
/* 575 */
/* 576 */                 double agg_value122 = agg_fastAggBuffer.getDouble(0);
/* 577 */
/* 578 */                 double agg_value121 = -1.0;
/* 579 */                 agg_value121 = agg_value122 + 1.0D;
/* 580 */                 boolean agg_isNull111 = false;
/* 581 */                 double agg_value116 = -1.0;
/* 582 */                 if (false || agg_value121 == 0) {
/* 583 */                   agg_isNull111 = true;
/* 584 */                 } else {
/* 585 */                   boolean agg_isNull112 = true;
/* 586 */                   double agg_value117 = -1.0;
/* 587 */
/* 588 */                   boolean agg_isNull113 = scan_isNull2;
/* 589 */                   double agg_value118 = -1.0;
/* 590 */                   if (!scan_isNull2) {
/* 591 */                     agg_value118 = (double) scan_value2;
/* 592 */                   }
/* 593 */                   if (!agg_isNull113) {
/* 594 */                     double agg_value120 = agg_fastAggBuffer.getDouble(1);
/* 595 */
/* 596 */                     agg_isNull112 = false; // resultCode could change nullability.
/* 597 */                     agg_value117 = agg_value118 - agg_value120;
/* 598 */
/* 599 */                   }
/* 600 */                   if (agg_isNull112) {
/* 601 */                     agg_isNull111 = true;
/* 602 */                   } else {
/* 603 */                     agg_value116 = (double)(agg_value117 / agg_value121);
/* 604 */                   }
/* 605 */                 }
/* 606 */                 if (!agg_isNull111) {
/* 607 */                   agg_isNull106 = false; // resultCode could change nullability.
/* 608 */                   agg_value111 = agg_value112 - agg_value116;
/* 609 */
/* 610 */                 }
/* 611 */
/* 612 */               }
/* 613 */               if (!agg_isNull106) {
/* 614 */                 agg_isNull101 = false; // resultCode could change nullability.
/* 615 */                 agg_value106 = agg_value107 * agg_value111;
/* 616 */
/* 617 */               }
/* 618 */
/* 619 */             }
/* 620 */             if (!agg_isNull101) {
/* 621 */               agg_isNull99 = false; // resultCode could change nullability.
/* 622 */               agg_value104 = agg_value105 + agg_value106;
/* 623 */
/* 624 */             }
/* 625 */             agg_isNull97 = agg_isNull99;
/* 626 */             agg_value102 = agg_value104;
/* 627 */           }
/* 628 */           boolean agg_isNull119 = true;
/* 629 */           double agg_value124 = -1.0;
/* 630 */
/* 631 */           boolean agg_isNull120 = agg_fastAggBuffer.isNullAt(3);
/* 632 */           double agg_value125 = agg_isNull120 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 633 */           if (!agg_isNull120) {
/* 634 */             boolean agg_isNull122 = agg_isNull75;
/* 635 */             double agg_value127 = -1.0;
/* 636 */             if (!agg_isNull75) {
/* 637 */               agg_value127 = (double) agg_value80;
/* 638 */             }
/* 639 */             boolean agg_isNull121 = agg_isNull122;
/* 640 */             double agg_value126 = agg_value127;
/* 641 */             if (agg_isNull121) {
/* 642 */               boolean agg_isNull123 = false;
/* 643 */               double agg_value128 = -1.0;
/* 644 */               if (!false) {
/* 645 */                 agg_value128 = (double) 0;
/* 646 */               }
/* 647 */               if (!agg_isNull123) {
/* 648 */                 agg_isNull121 = false;
/* 649 */                 agg_value126 = agg_value128;
/* 650 */               }
/* 651 */             }
/* 652 */
/* 653 */             agg_isNull119 = false; // resultCode could change nullability.
/* 654 */             agg_value124 = agg_value125 + agg_value126;
/* 655 */
/* 656 */           }
/* 657 */           boolean agg_isNull125 = false;
/* 658 */           long agg_value130 = -1L;
/* 659 */           if (!false && agg_isNull75) {
/* 660 */             boolean agg_isNull127 = agg_fastAggBuffer.isNullAt(4);
/* 661 */             long agg_value132 = agg_isNull127 ? -1L : (agg_fastAggBuffer.getLong(4));
/* 662 */             agg_isNull125 = agg_isNull127;
/* 663 */             agg_value130 = agg_value132;
/* 664 */           } else {
/* 665 */             boolean agg_isNull128 = true;
/* 666 */             long agg_value133 = -1L;
/* 667 */
/* 668 */             boolean agg_isNull129 = agg_fastAggBuffer.isNullAt(4);
/* 669 */             long agg_value134 = agg_isNull129 ? -1L : (agg_fastAggBuffer.getLong(4));
/* 670 */             if (!agg_isNull129) {
/* 671 */               agg_isNull128 = false; // resultCode could change nullability.
/* 672 */               agg_value133 = agg_value134 + 1L;
/* 673 */
/* 674 */             }
/* 675 */             agg_isNull125 = agg_isNull128;
/* 676 */             agg_value130 = agg_value133;
/* 677 */           }
/* 678 */           // update fast row
/* 679 */           agg_fastAggBuffer.setDouble(0, agg_value85);
/* 680 */
/* 681 */           if (!agg_isNull85) {
/* 682 */             agg_fastAggBuffer.setDouble(1, agg_value90);
/* 683 */           } else {
/* 684 */             agg_fastAggBuffer.setNullAt(1);
/* 685 */           }
/* 686 */
/* 687 */           if (!agg_isNull97) {
/* 688 */             agg_fastAggBuffer.setDouble(2, agg_value102);
/* 689 */           } else {
/* 690 */             agg_fastAggBuffer.setNullAt(2);
/* 691 */           }
/* 692 */
/* 693 */           if (!agg_isNull119) {
/* 694 */             agg_fastAggBuffer.setDouble(3, agg_value124);
/* 695 */           } else {
/* 696 */             agg_fastAggBuffer.setNullAt(3);
/* 697 */           }
/* 698 */
/* 699 */           if (!agg_isNull125) {
/* 700 */             agg_fastAggBuffer.setLong(4, agg_value130);
/* 701 */           } else {
/* 702 */             agg_fastAggBuffer.setNullAt(4);
/* 703 */           }
/* 704 */
/* 705 */         } else {
/* 706 */           // update unsafe row
/* 707 */
/* 708 */           // common sub-expressions
/* 709 */           boolean agg_isNull19 = scan_isNull2;
/* 710 */           long agg_value24 = -1L;
/* 711 */           if (!scan_isNull2) {
/* 712 */             agg_value24 = (long) scan_value2;
/* 713 */           }
/* 714 */           boolean agg_isNull22 = scan_isNull2;
/* 715 */           double agg_value27 = -1.0;
/* 716 */           if (!scan_isNull2) {
/* 717 */             agg_value27 = (double) scan_value2;
/* 718 */           }
/* 719 */           // evaluate aggregate function
/* 720 */           boolean agg_isNull24 = false;
/* 721 */           double agg_value29 = -1.0;
/* 722 */           if (!false && agg_isNull22) {
/* 723 */             double agg_value30 = agg_unsafeRowAggBuffer.getDouble(0);
/* 724 */             agg_isNull24 = false;
/* 725 */             agg_value29 = agg_value30;
/* 726 */           } else {
/* 727 */             boolean agg_isNull26 = false;
/* 728 */
/* 729 */             double agg_value32 = agg_unsafeRowAggBuffer.getDouble(0);
/* 730 */
/* 731 */             double agg_value31 = -1.0;
/* 732 */             agg_value31 = agg_value32 + 1.0D;
/* 733 */             agg_isNull24 = false;
/* 734 */             agg_value29 = agg_value31;
/* 735 */           }
/* 736 */           boolean agg_isNull29 = false;
/* 737 */           double agg_value34 = -1.0;
/* 738 */           if (!false && agg_isNull22) {
/* 739 */             double agg_value35 = agg_unsafeRowAggBuffer.getDouble(1);
/* 740 */             agg_isNull29 = false;
/* 741 */             agg_value34 = agg_value35;
/* 742 */           } else {
/* 743 */             boolean agg_isNull31 = true;
/* 744 */             double agg_value36 = -1.0;
/* 745 */
/* 746 */             double agg_value37 = agg_unsafeRowAggBuffer.getDouble(1);
/* 747 */
/* 748 */             boolean agg_isNull38 = false;
/* 749 */
/* 750 */             double agg_value44 = agg_unsafeRowAggBuffer.getDouble(0);
/* 751 */
/* 752 */             double agg_value43 = -1.0;
/* 753 */             agg_value43 = agg_value44 + 1.0D;
/* 754 */             boolean agg_isNull33 = false;
/* 755 */             double agg_value38 = -1.0;
/* 756 */             if (false || agg_value43 == 0) {
/* 757 */               agg_isNull33 = true;
/* 758 */             } else {
/* 759 */               boolean agg_isNull34 = true;
/* 760 */               double agg_value39 = -1.0;
/* 761 */
/* 762 */               boolean agg_isNull35 = scan_isNull2;
/* 763 */               double agg_value40 = -1.0;
/* 764 */               if (!scan_isNull2) {
/* 765 */                 agg_value40 = (double) scan_value2;
/* 766 */               }
/* 767 */               if (!agg_isNull35) {
/* 768 */                 double agg_value42 = agg_unsafeRowAggBuffer.getDouble(1);
/* 769 */
/* 770 */                 agg_isNull34 = false; // resultCode could change nullability.
/* 771 */                 agg_value39 = agg_value40 - agg_value42;
/* 772 */
/* 773 */               }
/* 774 */               if (agg_isNull34) {
/* 775 */                 agg_isNull33 = true;
/* 776 */               } else {
/* 777 */                 agg_value38 = (double)(agg_value39 / agg_value43);
/* 778 */               }
/* 779 */             }
/* 780 */             if (!agg_isNull33) {
/* 781 */               agg_isNull31 = false; // resultCode could change nullability.
/* 782 */               agg_value36 = agg_value37 + agg_value38;
/* 783 */
/* 784 */             }
/* 785 */             agg_isNull29 = agg_isNull31;
/* 786 */             agg_value34 = agg_value36;
/* 787 */           }
/* 788 */           boolean agg_isNull41 = false;
/* 789 */           double agg_value46 = -1.0;
/* 790 */           if (!false && agg_isNull22) {
/* 791 */             double agg_value47 = agg_unsafeRowAggBuffer.getDouble(2);
/* 792 */             agg_isNull41 = false;
/* 793 */             agg_value46 = agg_value47;
/* 794 */           } else {
/* 795 */             boolean agg_isNull43 = true;
/* 796 */             double agg_value48 = -1.0;
/* 797 */
/* 798 */             double agg_value49 = agg_unsafeRowAggBuffer.getDouble(2);
/* 799 */
/* 800 */             boolean agg_isNull45 = true;
/* 801 */             double agg_value50 = -1.0;
/* 802 */
/* 803 */             boolean agg_isNull46 = true;
/* 804 */             double agg_value51 = -1.0;
/* 805 */
/* 806 */             boolean agg_isNull47 = scan_isNull2;
/* 807 */             double agg_value52 = -1.0;
/* 808 */             if (!scan_isNull2) {
/* 809 */               agg_value52 = (double) scan_value2;
/* 810 */             }
/* 811 */             if (!agg_isNull47) {
/* 812 */               double agg_value54 = agg_unsafeRowAggBuffer.getDouble(1);
/* 813 */
/* 814 */               agg_isNull46 = false; // resultCode could change nullability.
/* 815 */               agg_value51 = agg_value52 - agg_value54;
/* 816 */
/* 817 */             }
/* 818 */             if (!agg_isNull46) {
/* 819 */               boolean agg_isNull50 = true;
/* 820 */               double agg_value55 = -1.0;
/* 821 */
/* 822 */               boolean agg_isNull51 = true;
/* 823 */               double agg_value56 = -1.0;
/* 824 */
/* 825 */               boolean agg_isNull52 = scan_isNull2;
/* 826 */               double agg_value57 = -1.0;
/* 827 */               if (!scan_isNull2) {
/* 828 */                 agg_value57 = (double) scan_value2;
/* 829 */               }
/* 830 */               if (!agg_isNull52) {
/* 831 */                 double agg_value59 = agg_unsafeRowAggBuffer.getDouble(1);
/* 832 */
/* 833 */                 agg_isNull51 = false; // resultCode could change nullability.
/* 834 */                 agg_value56 = agg_value57 - agg_value59;
/* 835 */
/* 836 */               }
/* 837 */               if (!agg_isNull51) {
/* 838 */                 boolean agg_isNull60 = false;
/* 839 */
/* 840 */                 double agg_value66 = agg_unsafeRowAggBuffer.getDouble(0);
/* 841 */
/* 842 */                 double agg_value65 = -1.0;
/* 843 */                 agg_value65 = agg_value66 + 1.0D;
/* 844 */                 boolean agg_isNull55 = false;
/* 845 */                 double agg_value60 = -1.0;
/* 846 */                 if (false || agg_value65 == 0) {
/* 847 */                   agg_isNull55 = true;
/* 848 */                 } else {
/* 849 */                   boolean agg_isNull56 = true;
/* 850 */                   double agg_value61 = -1.0;
/* 851 */
/* 852 */                   boolean agg_isNull57 = scan_isNull2;
/* 853 */                   double agg_value62 = -1.0;
/* 854 */                   if (!scan_isNull2) {
/* 855 */                     agg_value62 = (double) scan_value2;
/* 856 */                   }
/* 857 */                   if (!agg_isNull57) {
/* 858 */                     double agg_value64 = agg_unsafeRowAggBuffer.getDouble(1);
/* 859 */
/* 860 */                     agg_isNull56 = false; // resultCode could change nullability.
/* 861 */                     agg_value61 = agg_value62 - agg_value64;
/* 862 */
/* 863 */                   }
/* 864 */                   if (agg_isNull56) {
/* 865 */                     agg_isNull55 = true;
/* 866 */                   } else {
/* 867 */                     agg_value60 = (double)(agg_value61 / agg_value65);
/* 868 */                   }
/* 869 */                 }
/* 870 */                 if (!agg_isNull55) {
/* 871 */                   agg_isNull50 = false; // resultCode could change nullability.
/* 872 */                   agg_value55 = agg_value56 - agg_value60;
/* 873 */
/* 874 */                 }
/* 875 */
/* 876 */               }
/* 877 */               if (!agg_isNull50) {
/* 878 */                 agg_isNull45 = false; // resultCode could change nullability.
/* 879 */                 agg_value50 = agg_value51 * agg_value55;
/* 880 */
/* 881 */               }
/* 882 */
/* 883 */             }
/* 884 */             if (!agg_isNull45) {
/* 885 */               agg_isNull43 = false; // resultCode could change nullability.
/* 886 */               agg_value48 = agg_value49 + agg_value50;
/* 887 */
/* 888 */             }
/* 889 */             agg_isNull41 = agg_isNull43;
/* 890 */             agg_value46 = agg_value48;
/* 891 */           }
/* 892 */           boolean agg_isNull63 = true;
/* 893 */           double agg_value68 = -1.0;
/* 894 */
/* 895 */           boolean agg_isNull64 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 896 */           double agg_value69 = agg_isNull64 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 897 */           if (!agg_isNull64) {
/* 898 */             boolean agg_isNull66 = agg_isNull19;
/* 899 */             double agg_value71 = -1.0;
/* 900 */             if (!agg_isNull19) {
/* 901 */               agg_value71 = (double) agg_value24;
/* 902 */             }
/* 903 */             boolean agg_isNull65 = agg_isNull66;
/* 904 */             double agg_value70 = agg_value71;
/* 905 */             if (agg_isNull65) {
/* 906 */               boolean agg_isNull67 = false;
/* 907 */               double agg_value72 = -1.0;
/* 908 */               if (!false) {
/* 909 */                 agg_value72 = (double) 0;
/* 910 */               }
/* 911 */               if (!agg_isNull67) {
/* 912 */                 agg_isNull65 = false;
/* 913 */                 agg_value70 = agg_value72;
/* 914 */               }
/* 915 */             }
/* 916 */
/* 917 */             agg_isNull63 = false; // resultCode could change nullability.
/* 918 */             agg_value68 = agg_value69 + agg_value70;
/* 919 */
/* 920 */           }
/* 921 */           boolean agg_isNull69 = false;
/* 922 */           long agg_value74 = -1L;
/* 923 */           if (!false && agg_isNull19) {
/* 924 */             boolean agg_isNull71 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 925 */             long agg_value76 = agg_isNull71 ? -1L : (agg_unsafeRowAggBuffer.getLong(4));
/* 926 */             agg_isNull69 = agg_isNull71;
/* 927 */             agg_value74 = agg_value76;
/* 928 */           } else {
/* 929 */             boolean agg_isNull72 = true;
/* 930 */             long agg_value77 = -1L;
/* 931 */
/* 932 */             boolean agg_isNull73 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 933 */             long agg_value78 = agg_isNull73 ? -1L : (agg_unsafeRowAggBuffer.getLong(4));
/* 934 */             if (!agg_isNull73) {
/* 935 */               agg_isNull72 = false; // resultCode could change nullability.
/* 936 */               agg_value77 = agg_value78 + 1L;
/* 937 */
/* 938 */             }
/* 939 */             agg_isNull69 = agg_isNull72;
/* 940 */             agg_value74 = agg_value77;
/* 941 */           }
/* 942 */           // update unsafe row buffer
/* 943 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value29);
/* 944 */
/* 945 */           if (!agg_isNull29) {
/* 946 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value34);
/* 947 */           } else {
/* 948 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 949 */           }
/* 950 */
/* 951 */           if (!agg_isNull41) {
/* 952 */             agg_unsafeRowAggBuffer.setDouble(2, agg_value46);
/* 953 */           } else {
/* 954 */             agg_unsafeRowAggBuffer.setNullAt(2);
/* 955 */           }
/* 956 */
/* 957 */           if (!agg_isNull63) {
/* 958 */             agg_unsafeRowAggBuffer.setDouble(3, agg_value68);
/* 959 */           } else {
/* 960 */             agg_unsafeRowAggBuffer.setNullAt(3);
/* 961 */           }
/* 962 */
/* 963 */           if (!agg_isNull69) {
/* 964 */             agg_unsafeRowAggBuffer.setLong(4, agg_value74);
/* 965 */           } else {
/* 966 */             agg_unsafeRowAggBuffer.setNullAt(4);
/* 967 */           }
/* 968 */
/* 969 */         }
/* 970 */         // shouldStop check is eliminated
/* 971 */       }
/* 972 */       scan_batchIdx = scan_numRows;
/* 973 */       scan_batch = null;
/* 974 */       scan_nextBatch();
/* 975 */     }
/* 976 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 977 */     scan_scanTime1 = 0;
/* 978 */
/* 979 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 980 */
/* 981 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 982 */   }
/* 983 */
/* 984 */   private void wholestagecodegen_init_2() {
/* 985 */     project_result1 = new UnsafeRow(4);
/* 986 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 987 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 4);
/* 988 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[17];
/* 989 */
/* 990 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 991 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 992 */
/* 993 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 994 */     bhj_result1 = new UnsafeRow(6);
/* 995 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 32);
/* 996 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 6);
/* 997 */     project_result2 = new UnsafeRow(5);
/* 998 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 32);
/* 999 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 5);
/* 1000 */
/* 1001 */   }
/* 1002 */
/* 1003 */   private void wholestagecodegen_init_1() {
/* 1004 */     filter_result = new UnsafeRow(4);
/* 1005 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 1006 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 1007 */     project_result = new UnsafeRow(4);
/* 1008 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 1009 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 1010 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[15];
/* 1011 */
/* 1012 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 1013 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 1014 */
/* 1015 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 1016 */     bhj_result = new UnsafeRow(5);
/* 1017 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 1018 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 1019 */
/* 1020 */   }
/* 1021 */
/* 1022 */   private void wholestagecodegen_init_4() {
/* 1023 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 1024 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[21];
/* 1025 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[22];
/* 1026 */
/* 1027 */   }
/* 1028 */
/* 1029 */   protected void processNext() throws java.io.IOException {
/* 1030 */     if (!agg_initAgg) {
/* 1031 */       agg_initAgg = true;
/* 1032 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1033 */       agg_doAggregateWithKeys();
/* 1034 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1035 */     }
/* 1036 */
/* 1037 */     // output the result
/* 1038 */
/* 1039 */     while (agg_fastHashMapIter.next()) {
/* 1040 */       wholestagecodegen_numOutputRows.add(1);
/* 1041 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 1042 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 1043 */
/* 1044 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1045 */
/* 1046 */       append(agg_resultRow);
/* 1047 */
/* 1048 */       if (shouldStop()) return;
/* 1049 */     }
/* 1050 */     agg_fastHashMap.close();
/* 1051 */
/* 1052 */     while (agg_mapIter.next()) {
/* 1053 */       wholestagecodegen_numOutputRows.add(1);
/* 1054 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1055 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1056 */
/* 1057 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1058 */
/* 1059 */       append(agg_resultRow);
/* 1060 */
/* 1061 */       if (shouldStop()) return;
/* 1062 */     }
/* 1063 */
/* 1064 */     agg_mapIter.close();
/* 1065 */     if (agg_sorter == null) {
/* 1066 */       agg_hashMap.free();
/* 1067 */     }
/* 1068 */   }
/* 1069 */ }
