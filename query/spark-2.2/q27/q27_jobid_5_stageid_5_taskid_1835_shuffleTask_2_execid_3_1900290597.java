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
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private long agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private double agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private long agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private double agg_bufValue6;
/* 023 */   private boolean agg_bufIsNull7;
/* 024 */   private long agg_bufValue7;
/* 025 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 026 */   private agg_FastHashMap agg_fastHashMap;
/* 027 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 028 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 029 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 030 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 033 */   private scala.collection.Iterator scan_input;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 035 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 036 */   private long scan_scanTime1;
/* 037 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 038 */   private int scan_batchIdx;
/* 039 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 040 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 041 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 042 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 043 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 044 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 045 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 046 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 047 */   private UnsafeRow scan_result;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 050 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 051 */   private UnsafeRow filter_result;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 054 */   private UnsafeRow project_result;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 057 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 058 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 059 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 060 */   private UnsafeRow bhj_result;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 063 */   private UnsafeRow project_result1;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 066 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 067 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 068 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 069 */   private UnsafeRow bhj_result1;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 072 */   private UnsafeRow project_result2;
/* 073 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 075 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 076 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 077 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 078 */   private UnsafeRow bhj_result2;
/* 079 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 080 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 081 */   private UnsafeRow project_result3;
/* 082 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 083 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 084 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 085 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 086 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 087 */   private UnsafeRow bhj_result3;
/* 088 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 089 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 090 */   private UnsafeRow project_result4;
/* 091 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 092 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 093 */   private org.apache.spark.sql.execution.metric.SQLMetric expand_numOutputRows;
/* 094 */   private UnsafeRow expand_result;
/* 095 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder expand_holder;
/* 096 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter expand_rowWriter;
/* 097 */   private UnsafeRow agg_result3;
/* 098 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 099 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 100 */   private int agg_value26;
/* 101 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 102 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 103 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 104 */
/* 105 */   public GeneratedIterator(Object[] references) {
/* 106 */     this.references = references;
/* 107 */   }
/* 108 */
/* 109 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 110 */     partitionIndex = index;
/* 111 */     this.inputs = inputs;
/* 112 */     wholestagecodegen_init_0();
/* 113 */     wholestagecodegen_init_1();
/* 114 */     wholestagecodegen_init_2();
/* 115 */     wholestagecodegen_init_3();
/* 116 */     wholestagecodegen_init_4();
/* 117 */     wholestagecodegen_init_5();
/* 118 */
/* 119 */   }
/* 120 */
/* 121 */   private void wholestagecodegen_init_0() {
/* 122 */     agg_initAgg = false;
/* 123 */
/* 124 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 125 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 126 */
/* 127 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 128 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 129 */     scan_input = inputs[0];
/* 130 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 131 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 132 */     scan_scanTime1 = 0;
/* 133 */     scan_batch = null;
/* 134 */     scan_batchIdx = 0;
/* 135 */     scan_colInstance0 = null;
/* 136 */     scan_colInstance1 = null;
/* 137 */     scan_colInstance2 = null;
/* 138 */     scan_colInstance3 = null;
/* 139 */     scan_colInstance4 = null;
/* 140 */     scan_colInstance5 = null;
/* 141 */     scan_colInstance6 = null;
/* 142 */     scan_colInstance7 = null;
/* 143 */     scan_result = new UnsafeRow(8);
/* 144 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 145 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 8);
/* 146 */
/* 147 */   }
/* 148 */
/* 149 */   private void wholestagecodegen_init_3() {
/* 150 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 151 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[21];
/* 152 */
/* 153 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 154 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 155 */
/* 156 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[22];
/* 157 */     bhj_result2 = new UnsafeRow(8);
/* 158 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 32);
/* 159 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 8);
/* 160 */     project_result3 = new UnsafeRow(6);
/* 161 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 32);
/* 162 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 6);
/* 163 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[23];
/* 164 */
/* 165 */   }
/* 166 */
/* 167 */   private void scan_nextBatch() throws java.io.IOException {
/* 168 */     long getBatchStart = System.nanoTime();
/* 169 */     if (scan_input.hasNext()) {
/* 170 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 171 */       scan_numOutputRows.add(scan_batch.numRows());
/* 172 */       scan_batchIdx = 0;
/* 173 */       scan_colInstance0 = scan_batch.column(0);
/* 174 */       scan_colInstance1 = scan_batch.column(1);
/* 175 */       scan_colInstance2 = scan_batch.column(2);
/* 176 */       scan_colInstance3 = scan_batch.column(3);
/* 177 */       scan_colInstance4 = scan_batch.column(4);
/* 178 */       scan_colInstance5 = scan_batch.column(5);
/* 179 */       scan_colInstance6 = scan_batch.column(6);
/* 180 */       scan_colInstance7 = scan_batch.column(7);
/* 181 */
/* 182 */     }
/* 183 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 184 */   }
/* 185 */
/* 186 */   public class agg_FastHashMap {
/* 187 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 188 */     private int[] buckets;
/* 189 */     private int capacity = 1 << 16;
/* 190 */     private double loadFactor = 0.5;
/* 191 */     private int numBuckets = (int) (capacity / loadFactor);
/* 192 */     private int maxSteps = 2;
/* 193 */     private int numRows = 0;
/* 194 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 195 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 196 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 197 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 198 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.LongType)
/* 199 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 200 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.LongType)
/* 201 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 202 */     .add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.LongType)
/* 203 */     .add("((java.lang.String) references[12])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 204 */     .add("((java.lang.String) references[13])", org.apache.spark.sql.types.DataTypes.LongType);
/* 205 */     private Object emptyVBase;
/* 206 */     private long emptyVOff;
/* 207 */     private int emptyVLen;
/* 208 */     private boolean isBatchFull = false;
/* 209 */
/* 210 */     public agg_FastHashMap(
/* 211 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 212 */       InternalRow emptyAggregationBuffer) {
/* 213 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 214 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 215 */
/* 216 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 217 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 218 */
/* 219 */       emptyVBase = emptyBuffer;
/* 220 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 221 */       emptyVLen = emptyBuffer.length;
/* 222 */
/* 223 */       buckets = new int[numBuckets];
/* 224 */       java.util.Arrays.fill(buckets, -1);
/* 225 */     }
/* 226 */
/* 227 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, int agg_key2) {
/* 228 */       long h = hash(agg_key, agg_key1, agg_key2);
/* 229 */       int step = 0;
/* 230 */       int idx = (int) h & (numBuckets - 1);
/* 231 */       while (step < maxSteps) {
/* 232 */         // Return bucket index if it's either an empty slot or already contains the key
/* 233 */         if (buckets[idx] == -1) {
/* 234 */           if (numRows < capacity && !isBatchFull) {
/* 235 */             // creating the unsafe for new entry
/* 236 */             UnsafeRow agg_result = new UnsafeRow(3);
/* 237 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 238 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 239 */               64);
/* 240 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 241 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 242 */               agg_holder,
/* 243 */               3);
/* 244 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 245 */             agg_rowWriter.zeroOutNullBytes();
/* 246 */             agg_rowWriter.write(0, agg_key);
/* 247 */             agg_rowWriter.write(1, agg_key1);
/* 248 */             agg_rowWriter.write(2, agg_key2);
/* 249 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 250 */             Object kbase = agg_result.getBaseObject();
/* 251 */             long koff = agg_result.getBaseOffset();
/* 252 */             int klen = agg_result.getSizeInBytes();
/* 253 */
/* 254 */             UnsafeRow vRow
/* 255 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 256 */             if (vRow == null) {
/* 257 */               isBatchFull = true;
/* 258 */             } else {
/* 259 */               buckets[idx] = numRows++;
/* 260 */             }
/* 261 */             return vRow;
/* 262 */           } else {
/* 263 */             // No more space
/* 264 */             return null;
/* 265 */           }
/* 266 */         } else if (equals(idx, agg_key, agg_key1, agg_key2)) {
/* 267 */           return batch.getValueRow(buckets[idx]);
/* 268 */         }
/* 269 */         idx = (idx + 1) & (numBuckets - 1);
/* 270 */         step++;
/* 271 */       }
/* 272 */       // Didn't find it
/* 273 */       return null;
/* 274 */     }
/* 275 */
/* 276 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, int agg_key2) {
/* 277 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 278 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getInt(2) == agg_key2);
/* 279 */     }
/* 280 */
/* 281 */     private long hash(UTF8String agg_key, UTF8String agg_key1, int agg_key2) {
/* 282 */       long agg_hash = 0;
/* 283 */
/* 284 */       int agg_result = 0;
/* 285 */       byte[] agg_bytes = agg_key.getBytes();
/* 286 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 287 */         int agg_hash1 = agg_bytes[i];
/* 288 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 289 */       }
/* 290 */
/* 291 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 292 */
/* 293 */       int agg_result1 = 0;
/* 294 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 295 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 296 */         int agg_hash2 = agg_bytes1[i];
/* 297 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 298 */       }
/* 299 */
/* 300 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 301 */
/* 302 */       int agg_result2 = agg_key2;
/* 303 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 304 */
/* 305 */       return agg_hash;
/* 306 */     }
/* 307 */
/* 308 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 309 */       return batch.rowIterator();
/* 310 */     }
/* 311 */
/* 312 */     public void close() {
/* 313 */       batch.close();
/* 314 */     }
/* 315 */
/* 316 */   }
/* 317 */
/* 318 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 319 */     agg_hashMap = agg_plan.createHashMap();
/* 320 */
/* 321 */     if (scan_batch == null) {
/* 322 */       scan_nextBatch();
/* 323 */     }
/* 324 */     while (scan_batch != null) {
/* 325 */       int scan_numRows = scan_batch.numRows();
/* 326 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 327 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 328 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 329 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 330 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 331 */
/* 332 */         if (!(!(scan_isNull1))) continue;
/* 333 */
/* 334 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 335 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 336 */
/* 337 */         if (!(!(scan_isNull2))) continue;
/* 338 */
/* 339 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 340 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 341 */
/* 342 */         if (!(!(scan_isNull))) continue;
/* 343 */
/* 344 */         filter_numOutputRows.add(1);
/* 345 */
/* 346 */         // generate join key for stream side
/* 347 */
/* 348 */         boolean bhj_isNull = false;
/* 349 */         long bhj_value = -1L;
/* 350 */         if (!false) {
/* 351 */           bhj_value = (long) scan_value1;
/* 352 */         }
/* 353 */         // find matches from HashedRelation
/* 354 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 355 */         if (bhj_matched == null) continue;
/* 356 */
/* 357 */         bhj_numOutputRows.add(1);
/* 358 */
/* 359 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 360 */         int scan_value7 = scan_isNull7 ? -1 : (scan_colInstance7.getInt(scan_rowIdx));
/* 361 */
/* 362 */         // generate join key for stream side
/* 363 */
/* 364 */         boolean bhj_isNull12 = scan_isNull7;
/* 365 */         long bhj_value12 = -1L;
/* 366 */         if (!scan_isNull7) {
/* 367 */           bhj_value12 = (long) scan_value7;
/* 368 */         }
/* 369 */         // find matches from HashedRelation
/* 370 */         UnsafeRow bhj_matched1 = bhj_isNull12 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value12);
/* 371 */         if (bhj_matched1 == null) continue;
/* 372 */
/* 373 */         bhj_numOutputRows1.add(1);
/* 374 */
/* 375 */         // generate join key for stream side
/* 376 */
/* 377 */         boolean bhj_isNull23 = false;
/* 378 */         long bhj_value23 = -1L;
/* 379 */         if (!false) {
/* 380 */           bhj_value23 = (long) scan_value2;
/* 381 */         }
/* 382 */         // find matches from HashedRelation
/* 383 */         UnsafeRow bhj_matched2 = bhj_isNull23 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value23);
/* 384 */         if (bhj_matched2 == null) continue;
/* 385 */
/* 386 */         bhj_numOutputRows2.add(1);
/* 387 */
/* 388 */         // generate join key for stream side
/* 389 */
/* 390 */         boolean bhj_isNull35 = false;
/* 391 */         long bhj_value35 = -1L;
/* 392 */         if (!false) {
/* 393 */           bhj_value35 = (long) scan_value;
/* 394 */         }
/* 395 */         // find matches from HashedRelation
/* 396 */         UnsafeRow bhj_matched3 = bhj_isNull35 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value35);
/* 397 */         if (bhj_matched3 == null) continue;
/* 398 */
/* 399 */         bhj_numOutputRows3.add(1);
/* 400 */
/* 401 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 402 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 403 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 404 */         double scan_value4 = scan_isNull4 ? -1.0 : (scan_colInstance4.getDouble(scan_rowIdx));
/* 405 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 406 */         double scan_value5 = scan_isNull5 ? -1.0 : (scan_colInstance5.getDouble(scan_rowIdx));
/* 407 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 408 */         double scan_value6 = scan_isNull6 ? -1.0 : (scan_colInstance6.getDouble(scan_rowIdx));
/* 409 */         boolean bhj_isNull38 = bhj_matched3.isNullAt(1);
/* 410 */         UTF8String bhj_value38 = bhj_isNull38 ? null : (bhj_matched3.getUTF8String(1));
/* 411 */         boolean bhj_isNull26 = bhj_matched2.isNullAt(1);
/* 412 */         UTF8String bhj_value26 = bhj_isNull26 ? null : (bhj_matched2.getUTF8String(1));
/* 413 */
/* 414 */         boolean expand_isNull4 = true;
/* 415 */         UTF8String expand_value4 = null;
/* 416 */         boolean expand_isNull5 = true;
/* 417 */         UTF8String expand_value5 = null;
/* 418 */         boolean expand_isNull6 = true;
/* 419 */         int expand_value6 = -1;
/* 420 */         for (int expand_i = 0; expand_i < 3; expand_i ++) {
/* 421 */           switch (expand_i) {
/* 422 */           case 0:
/* 423 */             expand_isNull4 = bhj_isNull38;
/* 424 */             expand_value4 = bhj_value38;
/* 425 */
/* 426 */             expand_isNull5 = bhj_isNull26;
/* 427 */             expand_value5 = bhj_value26;
/* 428 */
/* 429 */             expand_isNull6 = false;
/* 430 */             expand_value6 = 0;
/* 431 */             break;
/* 432 */
/* 433 */           case 1:
/* 434 */             expand_isNull4 = bhj_isNull38;
/* 435 */             expand_value4 = bhj_value38;
/* 436 */
/* 437 */             final UTF8String expand_value11 = null;
/* 438 */             expand_isNull5 = true;
/* 439 */             expand_value5 = expand_value11;
/* 440 */
/* 441 */             expand_isNull6 = false;
/* 442 */             expand_value6 = 1;
/* 443 */             break;
/* 444 */
/* 445 */           case 2:
/* 446 */             final UTF8String expand_value13 = null;
/* 447 */             expand_isNull4 = true;
/* 448 */             expand_value4 = expand_value13;
/* 449 */
/* 450 */             final UTF8String expand_value14 = null;
/* 451 */             expand_isNull5 = true;
/* 452 */             expand_value5 = expand_value14;
/* 453 */
/* 454 */             expand_isNull6 = false;
/* 455 */             expand_value6 = 3;
/* 456 */             break;
/* 457 */           }
/* 458 */           expand_numOutputRows.add(1);
/* 459 */
/* 460 */           UnsafeRow agg_unsafeRowAggBuffer = null;
/* 461 */
/* 462 */           UnsafeRow agg_fastAggBuffer = null;
/* 463 */
/* 464 */           if (true) {
/* 465 */             if (!expand_isNull4 && !expand_isNull5 && !expand_isNull6) {
/* 466 */               agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 467 */                 expand_value4, expand_value5, expand_value6);
/* 468 */             }
/* 469 */           }
/* 470 */
/* 471 */           if (agg_fastAggBuffer == null) {
/* 472 */             // generate grouping key
/* 473 */             agg_holder.reset();
/* 474 */
/* 475 */             agg_rowWriter.zeroOutNullBytes();
/* 476 */
/* 477 */             if (expand_isNull4) {
/* 478 */               agg_rowWriter.setNullAt(0);
/* 479 */             } else {
/* 480 */               agg_rowWriter.write(0, expand_value4);
/* 481 */             }
/* 482 */
/* 483 */             if (expand_isNull5) {
/* 484 */               agg_rowWriter.setNullAt(1);
/* 485 */             } else {
/* 486 */               agg_rowWriter.write(1, expand_value5);
/* 487 */             }
/* 488 */
/* 489 */             if (expand_isNull6) {
/* 490 */               agg_rowWriter.setNullAt(2);
/* 491 */             } else {
/* 492 */               agg_rowWriter.write(2, expand_value6);
/* 493 */             }
/* 494 */             agg_result3.setTotalSize(agg_holder.totalSize());
/* 495 */             agg_value26 = 42;
/* 496 */
/* 497 */             if (!expand_isNull4) {
/* 498 */               agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value4.getBaseObject(), expand_value4.getBaseOffset(), expand_value4.numBytes(), agg_value26);
/* 499 */             }
/* 500 */
/* 501 */             if (!expand_isNull5) {
/* 502 */               agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value5.getBaseObject(), expand_value5.getBaseOffset(), expand_value5.numBytes(), agg_value26);
/* 503 */             }
/* 504 */
/* 505 */             agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(expand_value6, agg_value26);
/* 506 */             if (true) {
/* 507 */               // try to get the buffer from hash map
/* 508 */               agg_unsafeRowAggBuffer =
/* 509 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value26);
/* 510 */             }
/* 511 */             if (agg_unsafeRowAggBuffer == null) {
/* 512 */               if (agg_sorter == null) {
/* 513 */                 agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 514 */               } else {
/* 515 */                 agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 516 */               }
/* 517 */
/* 518 */               // the hash map had be spilled, it should have enough memory now,
/* 519 */               // try  to allocate buffer again.
/* 520 */               agg_unsafeRowAggBuffer =
/* 521 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value26);
/* 522 */               if (agg_unsafeRowAggBuffer == null) {
/* 523 */                 // failed to allocate the first page
/* 524 */                 throw new OutOfMemoryError("No enough memory for aggregation");
/* 525 */               }
/* 526 */             }
/* 527 */           }
/* 528 */
/* 529 */           if (agg_fastAggBuffer != null) {
/* 530 */             // update fast row
/* 531 */
/* 532 */             // common sub-expressions
/* 533 */             boolean agg_isNull75 = scan_isNull3;
/* 534 */             long agg_value83 = -1L;
/* 535 */             if (!scan_isNull3) {
/* 536 */               agg_value83 = (long) scan_value3;
/* 537 */             }
/* 538 */             // evaluate aggregate function
/* 539 */             boolean agg_isNull77 = true;
/* 540 */             double agg_value85 = -1.0;
/* 541 */
/* 542 */             boolean agg_isNull78 = agg_fastAggBuffer.isNullAt(0);
/* 543 */             double agg_value86 = agg_isNull78 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 544 */             if (!agg_isNull78) {
/* 545 */               boolean agg_isNull80 = agg_isNull75;
/* 546 */               double agg_value88 = -1.0;
/* 547 */               if (!agg_isNull75) {
/* 548 */                 agg_value88 = (double) agg_value83;
/* 549 */               }
/* 550 */               boolean agg_isNull79 = agg_isNull80;
/* 551 */               double agg_value87 = agg_value88;
/* 552 */               if (agg_isNull79) {
/* 553 */                 boolean agg_isNull81 = false;
/* 554 */                 double agg_value89 = -1.0;
/* 555 */                 if (!false) {
/* 556 */                   agg_value89 = (double) 0;
/* 557 */                 }
/* 558 */                 if (!agg_isNull81) {
/* 559 */                   agg_isNull79 = false;
/* 560 */                   agg_value87 = agg_value89;
/* 561 */                 }
/* 562 */               }
/* 563 */
/* 564 */               agg_isNull77 = false; // resultCode could change nullability.
/* 565 */               agg_value85 = agg_value86 + agg_value87;
/* 566 */
/* 567 */             }
/* 568 */             boolean agg_isNull83 = false;
/* 569 */             long agg_value91 = -1L;
/* 570 */             if (!false && agg_isNull75) {
/* 571 */               boolean agg_isNull85 = agg_fastAggBuffer.isNullAt(1);
/* 572 */               long agg_value93 = agg_isNull85 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 573 */               agg_isNull83 = agg_isNull85;
/* 574 */               agg_value91 = agg_value93;
/* 575 */             } else {
/* 576 */               boolean agg_isNull86 = true;
/* 577 */               long agg_value94 = -1L;
/* 578 */
/* 579 */               boolean agg_isNull87 = agg_fastAggBuffer.isNullAt(1);
/* 580 */               long agg_value95 = agg_isNull87 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 581 */               if (!agg_isNull87) {
/* 582 */                 agg_isNull86 = false; // resultCode could change nullability.
/* 583 */                 agg_value94 = agg_value95 + 1L;
/* 584 */
/* 585 */               }
/* 586 */               agg_isNull83 = agg_isNull86;
/* 587 */               agg_value91 = agg_value94;
/* 588 */             }
/* 589 */             boolean agg_isNull89 = true;
/* 590 */             double agg_value97 = -1.0;
/* 591 */
/* 592 */             boolean agg_isNull90 = agg_fastAggBuffer.isNullAt(2);
/* 593 */             double agg_value98 = agg_isNull90 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 594 */             if (!agg_isNull90) {
/* 595 */               boolean agg_isNull91 = scan_isNull4;
/* 596 */               double agg_value99 = scan_value4;
/* 597 */               if (agg_isNull91) {
/* 598 */                 boolean agg_isNull93 = false;
/* 599 */                 double agg_value101 = -1.0;
/* 600 */                 if (!false) {
/* 601 */                   agg_value101 = (double) 0;
/* 602 */                 }
/* 603 */                 if (!agg_isNull93) {
/* 604 */                   agg_isNull91 = false;
/* 605 */                   agg_value99 = agg_value101;
/* 606 */                 }
/* 607 */               }
/* 608 */
/* 609 */               agg_isNull89 = false; // resultCode could change nullability.
/* 610 */               agg_value97 = agg_value98 + agg_value99;
/* 611 */
/* 612 */             }
/* 613 */             boolean agg_isNull95 = false;
/* 614 */             long agg_value103 = -1L;
/* 615 */             if (!false && scan_isNull4) {
/* 616 */               boolean agg_isNull98 = agg_fastAggBuffer.isNullAt(3);
/* 617 */               long agg_value106 = agg_isNull98 ? -1L : (agg_fastAggBuffer.getLong(3));
/* 618 */               agg_isNull95 = agg_isNull98;
/* 619 */               agg_value103 = agg_value106;
/* 620 */             } else {
/* 621 */               boolean agg_isNull99 = true;
/* 622 */               long agg_value107 = -1L;
/* 623 */
/* 624 */               boolean agg_isNull100 = agg_fastAggBuffer.isNullAt(3);
/* 625 */               long agg_value108 = agg_isNull100 ? -1L : (agg_fastAggBuffer.getLong(3));
/* 626 */               if (!agg_isNull100) {
/* 627 */                 agg_isNull99 = false; // resultCode could change nullability.
/* 628 */                 agg_value107 = agg_value108 + 1L;
/* 629 */
/* 630 */               }
/* 631 */               agg_isNull95 = agg_isNull99;
/* 632 */               agg_value103 = agg_value107;
/* 633 */             }
/* 634 */             boolean agg_isNull102 = true;
/* 635 */             double agg_value110 = -1.0;
/* 636 */
/* 637 */             boolean agg_isNull103 = agg_fastAggBuffer.isNullAt(4);
/* 638 */             double agg_value111 = agg_isNull103 ? -1.0 : (agg_fastAggBuffer.getDouble(4));
/* 639 */             if (!agg_isNull103) {
/* 640 */               boolean agg_isNull104 = scan_isNull6;
/* 641 */               double agg_value112 = scan_value6;
/* 642 */               if (agg_isNull104) {
/* 643 */                 boolean agg_isNull106 = false;
/* 644 */                 double agg_value114 = -1.0;
/* 645 */                 if (!false) {
/* 646 */                   agg_value114 = (double) 0;
/* 647 */                 }
/* 648 */                 if (!agg_isNull106) {
/* 649 */                   agg_isNull104 = false;
/* 650 */                   agg_value112 = agg_value114;
/* 651 */                 }
/* 652 */               }
/* 653 */
/* 654 */               agg_isNull102 = false; // resultCode could change nullability.
/* 655 */               agg_value110 = agg_value111 + agg_value112;
/* 656 */
/* 657 */             }
/* 658 */             boolean agg_isNull108 = false;
/* 659 */             long agg_value116 = -1L;
/* 660 */             if (!false && scan_isNull6) {
/* 661 */               boolean agg_isNull111 = agg_fastAggBuffer.isNullAt(5);
/* 662 */               long agg_value119 = agg_isNull111 ? -1L : (agg_fastAggBuffer.getLong(5));
/* 663 */               agg_isNull108 = agg_isNull111;
/* 664 */               agg_value116 = agg_value119;
/* 665 */             } else {
/* 666 */               boolean agg_isNull112 = true;
/* 667 */               long agg_value120 = -1L;
/* 668 */
/* 669 */               boolean agg_isNull113 = agg_fastAggBuffer.isNullAt(5);
/* 670 */               long agg_value121 = agg_isNull113 ? -1L : (agg_fastAggBuffer.getLong(5));
/* 671 */               if (!agg_isNull113) {
/* 672 */                 agg_isNull112 = false; // resultCode could change nullability.
/* 673 */                 agg_value120 = agg_value121 + 1L;
/* 674 */
/* 675 */               }
/* 676 */               agg_isNull108 = agg_isNull112;
/* 677 */               agg_value116 = agg_value120;
/* 678 */             }
/* 679 */             boolean agg_isNull115 = true;
/* 680 */             double agg_value123 = -1.0;
/* 681 */
/* 682 */             boolean agg_isNull116 = agg_fastAggBuffer.isNullAt(6);
/* 683 */             double agg_value124 = agg_isNull116 ? -1.0 : (agg_fastAggBuffer.getDouble(6));
/* 684 */             if (!agg_isNull116) {
/* 685 */               boolean agg_isNull117 = scan_isNull5;
/* 686 */               double agg_value125 = scan_value5;
/* 687 */               if (agg_isNull117) {
/* 688 */                 boolean agg_isNull119 = false;
/* 689 */                 double agg_value127 = -1.0;
/* 690 */                 if (!false) {
/* 691 */                   agg_value127 = (double) 0;
/* 692 */                 }
/* 693 */                 if (!agg_isNull119) {
/* 694 */                   agg_isNull117 = false;
/* 695 */                   agg_value125 = agg_value127;
/* 696 */                 }
/* 697 */               }
/* 698 */
/* 699 */               agg_isNull115 = false; // resultCode could change nullability.
/* 700 */               agg_value123 = agg_value124 + agg_value125;
/* 701 */
/* 702 */             }
/* 703 */             boolean agg_isNull121 = false;
/* 704 */             long agg_value129 = -1L;
/* 705 */             if (!false && scan_isNull5) {
/* 706 */               boolean agg_isNull124 = agg_fastAggBuffer.isNullAt(7);
/* 707 */               long agg_value132 = agg_isNull124 ? -1L : (agg_fastAggBuffer.getLong(7));
/* 708 */               agg_isNull121 = agg_isNull124;
/* 709 */               agg_value129 = agg_value132;
/* 710 */             } else {
/* 711 */               boolean agg_isNull125 = true;
/* 712 */               long agg_value133 = -1L;
/* 713 */
/* 714 */               boolean agg_isNull126 = agg_fastAggBuffer.isNullAt(7);
/* 715 */               long agg_value134 = agg_isNull126 ? -1L : (agg_fastAggBuffer.getLong(7));
/* 716 */               if (!agg_isNull126) {
/* 717 */                 agg_isNull125 = false; // resultCode could change nullability.
/* 718 */                 agg_value133 = agg_value134 + 1L;
/* 719 */
/* 720 */               }
/* 721 */               agg_isNull121 = agg_isNull125;
/* 722 */               agg_value129 = agg_value133;
/* 723 */             }
/* 724 */             // update fast row
/* 725 */             if (!agg_isNull77) {
/* 726 */               agg_fastAggBuffer.setDouble(0, agg_value85);
/* 727 */             } else {
/* 728 */               agg_fastAggBuffer.setNullAt(0);
/* 729 */             }
/* 730 */
/* 731 */             if (!agg_isNull83) {
/* 732 */               agg_fastAggBuffer.setLong(1, agg_value91);
/* 733 */             } else {
/* 734 */               agg_fastAggBuffer.setNullAt(1);
/* 735 */             }
/* 736 */
/* 737 */             if (!agg_isNull89) {
/* 738 */               agg_fastAggBuffer.setDouble(2, agg_value97);
/* 739 */             } else {
/* 740 */               agg_fastAggBuffer.setNullAt(2);
/* 741 */             }
/* 742 */
/* 743 */             if (!agg_isNull95) {
/* 744 */               agg_fastAggBuffer.setLong(3, agg_value103);
/* 745 */             } else {
/* 746 */               agg_fastAggBuffer.setNullAt(3);
/* 747 */             }
/* 748 */
/* 749 */             if (!agg_isNull102) {
/* 750 */               agg_fastAggBuffer.setDouble(4, agg_value110);
/* 751 */             } else {
/* 752 */               agg_fastAggBuffer.setNullAt(4);
/* 753 */             }
/* 754 */
/* 755 */             if (!agg_isNull108) {
/* 756 */               agg_fastAggBuffer.setLong(5, agg_value116);
/* 757 */             } else {
/* 758 */               agg_fastAggBuffer.setNullAt(5);
/* 759 */             }
/* 760 */
/* 761 */             if (!agg_isNull115) {
/* 762 */               agg_fastAggBuffer.setDouble(6, agg_value123);
/* 763 */             } else {
/* 764 */               agg_fastAggBuffer.setNullAt(6);
/* 765 */             }
/* 766 */
/* 767 */             if (!agg_isNull121) {
/* 768 */               agg_fastAggBuffer.setLong(7, agg_value129);
/* 769 */             } else {
/* 770 */               agg_fastAggBuffer.setNullAt(7);
/* 771 */             }
/* 772 */
/* 773 */           } else {
/* 774 */             // update unsafe row
/* 775 */
/* 776 */             // common sub-expressions
/* 777 */             boolean agg_isNull22 = scan_isNull3;
/* 778 */             long agg_value30 = -1L;
/* 779 */             if (!scan_isNull3) {
/* 780 */               agg_value30 = (long) scan_value3;
/* 781 */             }
/* 782 */             // evaluate aggregate function
/* 783 */             boolean agg_isNull24 = true;
/* 784 */             double agg_value32 = -1.0;
/* 785 */
/* 786 */             boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 787 */             double agg_value33 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 788 */             if (!agg_isNull25) {
/* 789 */               boolean agg_isNull27 = agg_isNull22;
/* 790 */               double agg_value35 = -1.0;
/* 791 */               if (!agg_isNull22) {
/* 792 */                 agg_value35 = (double) agg_value30;
/* 793 */               }
/* 794 */               boolean agg_isNull26 = agg_isNull27;
/* 795 */               double agg_value34 = agg_value35;
/* 796 */               if (agg_isNull26) {
/* 797 */                 boolean agg_isNull28 = false;
/* 798 */                 double agg_value36 = -1.0;
/* 799 */                 if (!false) {
/* 800 */                   agg_value36 = (double) 0;
/* 801 */                 }
/* 802 */                 if (!agg_isNull28) {
/* 803 */                   agg_isNull26 = false;
/* 804 */                   agg_value34 = agg_value36;
/* 805 */                 }
/* 806 */               }
/* 807 */
/* 808 */               agg_isNull24 = false; // resultCode could change nullability.
/* 809 */               agg_value32 = agg_value33 + agg_value34;
/* 810 */
/* 811 */             }
/* 812 */             boolean agg_isNull30 = false;
/* 813 */             long agg_value38 = -1L;
/* 814 */             if (!false && agg_isNull22) {
/* 815 */               boolean agg_isNull32 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 816 */               long agg_value40 = agg_isNull32 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 817 */               agg_isNull30 = agg_isNull32;
/* 818 */               agg_value38 = agg_value40;
/* 819 */             } else {
/* 820 */               boolean agg_isNull33 = true;
/* 821 */               long agg_value41 = -1L;
/* 822 */
/* 823 */               boolean agg_isNull34 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 824 */               long agg_value42 = agg_isNull34 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 825 */               if (!agg_isNull34) {
/* 826 */                 agg_isNull33 = false; // resultCode could change nullability.
/* 827 */                 agg_value41 = agg_value42 + 1L;
/* 828 */
/* 829 */               }
/* 830 */               agg_isNull30 = agg_isNull33;
/* 831 */               agg_value38 = agg_value41;
/* 832 */             }
/* 833 */             boolean agg_isNull36 = true;
/* 834 */             double agg_value44 = -1.0;
/* 835 */
/* 836 */             boolean agg_isNull37 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 837 */             double agg_value45 = agg_isNull37 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 838 */             if (!agg_isNull37) {
/* 839 */               boolean agg_isNull38 = scan_isNull4;
/* 840 */               double agg_value46 = scan_value4;
/* 841 */               if (agg_isNull38) {
/* 842 */                 boolean agg_isNull40 = false;
/* 843 */                 double agg_value48 = -1.0;
/* 844 */                 if (!false) {
/* 845 */                   agg_value48 = (double) 0;
/* 846 */                 }
/* 847 */                 if (!agg_isNull40) {
/* 848 */                   agg_isNull38 = false;
/* 849 */                   agg_value46 = agg_value48;
/* 850 */                 }
/* 851 */               }
/* 852 */
/* 853 */               agg_isNull36 = false; // resultCode could change nullability.
/* 854 */               agg_value44 = agg_value45 + agg_value46;
/* 855 */
/* 856 */             }
/* 857 */             boolean agg_isNull42 = false;
/* 858 */             long agg_value50 = -1L;
/* 859 */             if (!false && scan_isNull4) {
/* 860 */               boolean agg_isNull45 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 861 */               long agg_value53 = agg_isNull45 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 862 */               agg_isNull42 = agg_isNull45;
/* 863 */               agg_value50 = agg_value53;
/* 864 */             } else {
/* 865 */               boolean agg_isNull46 = true;
/* 866 */               long agg_value54 = -1L;
/* 867 */
/* 868 */               boolean agg_isNull47 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 869 */               long agg_value55 = agg_isNull47 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 870 */               if (!agg_isNull47) {
/* 871 */                 agg_isNull46 = false; // resultCode could change nullability.
/* 872 */                 agg_value54 = agg_value55 + 1L;
/* 873 */
/* 874 */               }
/* 875 */               agg_isNull42 = agg_isNull46;
/* 876 */               agg_value50 = agg_value54;
/* 877 */             }
/* 878 */             boolean agg_isNull49 = true;
/* 879 */             double agg_value57 = -1.0;
/* 880 */
/* 881 */             boolean agg_isNull50 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 882 */             double agg_value58 = agg_isNull50 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 883 */             if (!agg_isNull50) {
/* 884 */               boolean agg_isNull51 = scan_isNull6;
/* 885 */               double agg_value59 = scan_value6;
/* 886 */               if (agg_isNull51) {
/* 887 */                 boolean agg_isNull53 = false;
/* 888 */                 double agg_value61 = -1.0;
/* 889 */                 if (!false) {
/* 890 */                   agg_value61 = (double) 0;
/* 891 */                 }
/* 892 */                 if (!agg_isNull53) {
/* 893 */                   agg_isNull51 = false;
/* 894 */                   agg_value59 = agg_value61;
/* 895 */                 }
/* 896 */               }
/* 897 */
/* 898 */               agg_isNull49 = false; // resultCode could change nullability.
/* 899 */               agg_value57 = agg_value58 + agg_value59;
/* 900 */
/* 901 */             }
/* 902 */             boolean agg_isNull55 = false;
/* 903 */             long agg_value63 = -1L;
/* 904 */             if (!false && scan_isNull6) {
/* 905 */               boolean agg_isNull58 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 906 */               long agg_value66 = agg_isNull58 ? -1L : (agg_unsafeRowAggBuffer.getLong(5));
/* 907 */               agg_isNull55 = agg_isNull58;
/* 908 */               agg_value63 = agg_value66;
/* 909 */             } else {
/* 910 */               boolean agg_isNull59 = true;
/* 911 */               long agg_value67 = -1L;
/* 912 */
/* 913 */               boolean agg_isNull60 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 914 */               long agg_value68 = agg_isNull60 ? -1L : (agg_unsafeRowAggBuffer.getLong(5));
/* 915 */               if (!agg_isNull60) {
/* 916 */                 agg_isNull59 = false; // resultCode could change nullability.
/* 917 */                 agg_value67 = agg_value68 + 1L;
/* 918 */
/* 919 */               }
/* 920 */               agg_isNull55 = agg_isNull59;
/* 921 */               agg_value63 = agg_value67;
/* 922 */             }
/* 923 */             boolean agg_isNull62 = true;
/* 924 */             double agg_value70 = -1.0;
/* 925 */
/* 926 */             boolean agg_isNull63 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 927 */             double agg_value71 = agg_isNull63 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 928 */             if (!agg_isNull63) {
/* 929 */               boolean agg_isNull64 = scan_isNull5;
/* 930 */               double agg_value72 = scan_value5;
/* 931 */               if (agg_isNull64) {
/* 932 */                 boolean agg_isNull66 = false;
/* 933 */                 double agg_value74 = -1.0;
/* 934 */                 if (!false) {
/* 935 */                   agg_value74 = (double) 0;
/* 936 */                 }
/* 937 */                 if (!agg_isNull66) {
/* 938 */                   agg_isNull64 = false;
/* 939 */                   agg_value72 = agg_value74;
/* 940 */                 }
/* 941 */               }
/* 942 */
/* 943 */               agg_isNull62 = false; // resultCode could change nullability.
/* 944 */               agg_value70 = agg_value71 + agg_value72;
/* 945 */
/* 946 */             }
/* 947 */             boolean agg_isNull68 = false;
/* 948 */             long agg_value76 = -1L;
/* 949 */             if (!false && scan_isNull5) {
/* 950 */               boolean agg_isNull71 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 951 */               long agg_value79 = agg_isNull71 ? -1L : (agg_unsafeRowAggBuffer.getLong(7));
/* 952 */               agg_isNull68 = agg_isNull71;
/* 953 */               agg_value76 = agg_value79;
/* 954 */             } else {
/* 955 */               boolean agg_isNull72 = true;
/* 956 */               long agg_value80 = -1L;
/* 957 */
/* 958 */               boolean agg_isNull73 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 959 */               long agg_value81 = agg_isNull73 ? -1L : (agg_unsafeRowAggBuffer.getLong(7));
/* 960 */               if (!agg_isNull73) {
/* 961 */                 agg_isNull72 = false; // resultCode could change nullability.
/* 962 */                 agg_value80 = agg_value81 + 1L;
/* 963 */
/* 964 */               }
/* 965 */               agg_isNull68 = agg_isNull72;
/* 966 */               agg_value76 = agg_value80;
/* 967 */             }
/* 968 */             // update unsafe row buffer
/* 969 */             if (!agg_isNull24) {
/* 970 */               agg_unsafeRowAggBuffer.setDouble(0, agg_value32);
/* 971 */             } else {
/* 972 */               agg_unsafeRowAggBuffer.setNullAt(0);
/* 973 */             }
/* 974 */
/* 975 */             if (!agg_isNull30) {
/* 976 */               agg_unsafeRowAggBuffer.setLong(1, agg_value38);
/* 977 */             } else {
/* 978 */               agg_unsafeRowAggBuffer.setNullAt(1);
/* 979 */             }
/* 980 */
/* 981 */             if (!agg_isNull36) {
/* 982 */               agg_unsafeRowAggBuffer.setDouble(2, agg_value44);
/* 983 */             } else {
/* 984 */               agg_unsafeRowAggBuffer.setNullAt(2);
/* 985 */             }
/* 986 */
/* 987 */             if (!agg_isNull42) {
/* 988 */               agg_unsafeRowAggBuffer.setLong(3, agg_value50);
/* 989 */             } else {
/* 990 */               agg_unsafeRowAggBuffer.setNullAt(3);
/* 991 */             }
/* 992 */
/* 993 */             if (!agg_isNull49) {
/* 994 */               agg_unsafeRowAggBuffer.setDouble(4, agg_value57);
/* 995 */             } else {
/* 996 */               agg_unsafeRowAggBuffer.setNullAt(4);
/* 997 */             }
/* 998 */
/* 999 */             if (!agg_isNull55) {
/* 1000 */               agg_unsafeRowAggBuffer.setLong(5, agg_value63);
/* 1001 */             } else {
/* 1002 */               agg_unsafeRowAggBuffer.setNullAt(5);
/* 1003 */             }
/* 1004 */
/* 1005 */             if (!agg_isNull62) {
/* 1006 */               agg_unsafeRowAggBuffer.setDouble(6, agg_value70);
/* 1007 */             } else {
/* 1008 */               agg_unsafeRowAggBuffer.setNullAt(6);
/* 1009 */             }
/* 1010 */
/* 1011 */             if (!agg_isNull68) {
/* 1012 */               agg_unsafeRowAggBuffer.setLong(7, agg_value76);
/* 1013 */             } else {
/* 1014 */               agg_unsafeRowAggBuffer.setNullAt(7);
/* 1015 */             }
/* 1016 */
/* 1017 */           }
/* 1018 */
/* 1019 */         }
/* 1020 */         // shouldStop check is eliminated
/* 1021 */       }
/* 1022 */       scan_batchIdx = scan_numRows;
/* 1023 */       scan_batch = null;
/* 1024 */       scan_nextBatch();
/* 1025 */     }
/* 1026 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 1027 */     scan_scanTime1 = 0;
/* 1028 */
/* 1029 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 1030 */
/* 1031 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1032 */   }
/* 1033 */
/* 1034 */   private void wholestagecodegen_init_5() {
/* 1035 */     agg_result3 = new UnsafeRow(3);
/* 1036 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 64);
/* 1037 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 1038 */
/* 1039 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 1040 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[26];
/* 1041 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[27];
/* 1042 */
/* 1043 */   }
/* 1044 */
/* 1045 */   private void wholestagecodegen_init_2() {
/* 1046 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 9);
/* 1047 */     project_result1 = new UnsafeRow(7);
/* 1048 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 1049 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 7);
/* 1050 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[19];
/* 1051 */
/* 1052 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 1053 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 1054 */
/* 1055 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[20];
/* 1056 */     bhj_result1 = new UnsafeRow(8);
/* 1057 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 1058 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 8);
/* 1059 */     project_result2 = new UnsafeRow(6);
/* 1060 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 1061 */
/* 1062 */   }
/* 1063 */
/* 1064 */   private void wholestagecodegen_init_1() {
/* 1065 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 1066 */     filter_result = new UnsafeRow(8);
/* 1067 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 1068 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 8);
/* 1069 */     project_result = new UnsafeRow(8);
/* 1070 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 1071 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
/* 1072 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[17];
/* 1073 */
/* 1074 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 1075 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 1076 */
/* 1077 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 1078 */     bhj_result = new UnsafeRow(9);
/* 1079 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 1080 */
/* 1081 */   }
/* 1082 */
/* 1083 */   private void wholestagecodegen_init_4() {
/* 1084 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 1085 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 1086 */
/* 1087 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[24];
/* 1088 */     bhj_result3 = new UnsafeRow(8);
/* 1089 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 64);
/* 1090 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 8);
/* 1091 */     project_result4 = new UnsafeRow(6);
/* 1092 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 64);
/* 1093 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 6);
/* 1094 */     this.expand_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[25];
/* 1095 */     expand_result = new UnsafeRow(7);
/* 1096 */     this.expand_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(expand_result, 64);
/* 1097 */     this.expand_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(expand_holder, 7);
/* 1098 */
/* 1099 */   }
/* 1100 */
/* 1101 */   protected void processNext() throws java.io.IOException {
/* 1102 */     if (!agg_initAgg) {
/* 1103 */       agg_initAgg = true;
/* 1104 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1105 */       agg_doAggregateWithKeys();
/* 1106 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1107 */     }
/* 1108 */
/* 1109 */     // output the result
/* 1110 */
/* 1111 */     while (agg_fastHashMapIter.next()) {
/* 1112 */       wholestagecodegen_numOutputRows.add(1);
/* 1113 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 1114 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 1115 */
/* 1116 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1117 */
/* 1118 */       append(agg_resultRow.copy());
/* 1119 */
/* 1120 */       if (shouldStop()) return;
/* 1121 */     }
/* 1122 */     agg_fastHashMap.close();
/* 1123 */
/* 1124 */     while (agg_mapIter.next()) {
/* 1125 */       wholestagecodegen_numOutputRows.add(1);
/* 1126 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1127 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1128 */
/* 1129 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1130 */
/* 1131 */       append(agg_resultRow.copy());
/* 1132 */
/* 1133 */       if (shouldStop()) return;
/* 1134 */     }
/* 1135 */
/* 1136 */     agg_mapIter.close();
/* 1137 */     if (agg_sorter == null) {
/* 1138 */       agg_hashMap.free();
/* 1139 */     }
/* 1140 */   }
/* 1141 */ }
