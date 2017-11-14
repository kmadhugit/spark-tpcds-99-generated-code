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
/* 031 */   private UnsafeRow scan_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 035 */   private UnsafeRow filter_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 038 */   private UnsafeRow project_result;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 041 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 042 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 043 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 044 */   private UnsafeRow bhj_result;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 047 */   private UnsafeRow project_result1;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 050 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 051 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 052 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 053 */   private UnsafeRow bhj_result1;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 056 */   private UnsafeRow project_result2;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 059 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 060 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 061 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 062 */   private UnsafeRow bhj_result2;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 065 */   private UnsafeRow project_result3;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 068 */   private org.apache.spark.sql.execution.metric.SQLMetric expand_numOutputRows;
/* 069 */   private UnsafeRow expand_result;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder expand_holder;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter expand_rowWriter;
/* 072 */   private UnsafeRow agg_result5;
/* 073 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 075 */   private int agg_value15;
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
/* 104 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 105 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 106 */     scan_scanTime1 = 0;
/* 107 */     scan_batch = null;
/* 108 */     scan_batchIdx = 0;
/* 109 */     scan_colInstance0 = null;
/* 110 */     scan_colInstance1 = null;
/* 111 */     scan_colInstance2 = null;
/* 112 */     scan_colInstance3 = null;
/* 113 */     scan_result = new UnsafeRow(4);
/* 114 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 115 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 116 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 117 */
/* 118 */   }
/* 119 */
/* 120 */   private void wholestagecodegen_init_3() {
/* 121 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[17];
/* 122 */
/* 123 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 124 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 125 */
/* 126 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 127 */     bhj_result2 = new UnsafeRow(7);
/* 128 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 128);
/* 129 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 7);
/* 130 */     project_result3 = new UnsafeRow(5);
/* 131 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 128);
/* 132 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 5);
/* 133 */     this.expand_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[19];
/* 134 */     expand_result = new UnsafeRow(6);
/* 135 */     this.expand_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(expand_result, 128);
/* 136 */
/* 137 */   }
/* 138 */
/* 139 */   private void scan_nextBatch() throws java.io.IOException {
/* 140 */     long getBatchStart = System.nanoTime();
/* 141 */     if (scan_input.hasNext()) {
/* 142 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 143 */       scan_numOutputRows.add(scan_batch.numRows());
/* 144 */       scan_batchIdx = 0;
/* 145 */       scan_colInstance0 = scan_batch.column(0);
/* 146 */       scan_colInstance1 = scan_batch.column(1);
/* 147 */       scan_colInstance2 = scan_batch.column(2);
/* 148 */       scan_colInstance3 = scan_batch.column(3);
/* 149 */
/* 150 */     }
/* 151 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 152 */   }
/* 153 */
/* 154 */   public class agg_FastHashMap {
/* 155 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 156 */     private int[] buckets;
/* 157 */     private int capacity = 1 << 16;
/* 158 */     private double loadFactor = 0.5;
/* 159 */     private int numBuckets = (int) (capacity / loadFactor);
/* 160 */     private int maxSteps = 2;
/* 161 */     private int numRows = 0;
/* 162 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 163 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 164 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 165 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.StringType)
/* 166 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 167 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 168 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.LongType);
/* 169 */     private Object emptyVBase;
/* 170 */     private long emptyVOff;
/* 171 */     private int emptyVLen;
/* 172 */     private boolean isBatchFull = false;
/* 173 */
/* 174 */     public agg_FastHashMap(
/* 175 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 176 */       InternalRow emptyAggregationBuffer) {
/* 177 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 178 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 179 */
/* 180 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 181 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 182 */
/* 183 */       emptyVBase = emptyBuffer;
/* 184 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 185 */       emptyVLen = emptyBuffer.length;
/* 186 */
/* 187 */       buckets = new int[numBuckets];
/* 188 */       java.util.Arrays.fill(buckets, -1);
/* 189 */     }
/* 190 */
/* 191 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, int agg_key4) {
/* 192 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4);
/* 193 */       int step = 0;
/* 194 */       int idx = (int) h & (numBuckets - 1);
/* 195 */       while (step < maxSteps) {
/* 196 */         // Return bucket index if it's either an empty slot or already contains the key
/* 197 */         if (buckets[idx] == -1) {
/* 198 */           if (numRows < capacity && !isBatchFull) {
/* 199 */             // creating the unsafe for new entry
/* 200 */             UnsafeRow agg_result = new UnsafeRow(5);
/* 201 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 202 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 203 */               128);
/* 204 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 205 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 206 */               agg_holder,
/* 207 */               5);
/* 208 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 209 */             agg_rowWriter.zeroOutNullBytes();
/* 210 */             agg_rowWriter.write(0, agg_key);
/* 211 */             agg_rowWriter.write(1, agg_key1);
/* 212 */             agg_rowWriter.write(2, agg_key2);
/* 213 */             agg_rowWriter.write(3, agg_key3);
/* 214 */             agg_rowWriter.write(4, agg_key4);
/* 215 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 216 */             Object kbase = agg_result.getBaseObject();
/* 217 */             long koff = agg_result.getBaseOffset();
/* 218 */             int klen = agg_result.getSizeInBytes();
/* 219 */
/* 220 */             UnsafeRow vRow
/* 221 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 222 */             if (vRow == null) {
/* 223 */               isBatchFull = true;
/* 224 */             } else {
/* 225 */               buckets[idx] = numRows++;
/* 226 */             }
/* 227 */             return vRow;
/* 228 */           } else {
/* 229 */             // No more space
/* 230 */             return null;
/* 231 */           }
/* 232 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4)) {
/* 233 */           return batch.getValueRow(buckets[idx]);
/* 234 */         }
/* 235 */         idx = (idx + 1) & (numBuckets - 1);
/* 236 */         step++;
/* 237 */       }
/* 238 */       // Didn't find it
/* 239 */       return null;
/* 240 */     }
/* 241 */
/* 242 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, int agg_key4) {
/* 243 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 244 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getInt(4) == agg_key4);
/* 245 */     }
/* 246 */
/* 247 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, int agg_key4) {
/* 248 */       long agg_hash = 0;
/* 249 */
/* 250 */       int agg_result = 0;
/* 251 */       byte[] agg_bytes = agg_key.getBytes();
/* 252 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 253 */         int agg_hash1 = agg_bytes[i];
/* 254 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 255 */       }
/* 256 */
/* 257 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 258 */
/* 259 */       int agg_result1 = 0;
/* 260 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 261 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 262 */         int agg_hash2 = agg_bytes1[i];
/* 263 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 264 */       }
/* 265 */
/* 266 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 267 */
/* 268 */       int agg_result2 = 0;
/* 269 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 270 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 271 */         int agg_hash3 = agg_bytes2[i];
/* 272 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 273 */       }
/* 274 */
/* 275 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 276 */
/* 277 */       int agg_result3 = 0;
/* 278 */       byte[] agg_bytes3 = agg_key3.getBytes();
/* 279 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 280 */         int agg_hash4 = agg_bytes3[i];
/* 281 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash4 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 282 */       }
/* 283 */
/* 284 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 285 */
/* 286 */       int agg_result4 = agg_key4;
/* 287 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
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
/* 313 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 314 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 315 */
/* 316 */         if (!(!(scan_isNull))) continue;
/* 317 */
/* 318 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 319 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 320 */
/* 321 */         if (!(!(scan_isNull1))) continue;
/* 322 */
/* 323 */         filter_numOutputRows.add(1);
/* 324 */
/* 325 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 326 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 327 */
/* 328 */         // generate join key for stream side
/* 329 */
/* 330 */         boolean bhj_isNull = scan_isNull3;
/* 331 */         long bhj_value = -1L;
/* 332 */         if (!scan_isNull3) {
/* 333 */           bhj_value = (long) scan_value3;
/* 334 */         }
/* 335 */         // find matches from HashedRelation
/* 336 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 337 */         if (bhj_matched == null) continue;
/* 338 */
/* 339 */         bhj_numOutputRows.add(1);
/* 340 */
/* 341 */         // generate join key for stream side
/* 342 */
/* 343 */         boolean bhj_isNull8 = false;
/* 344 */         long bhj_value8 = -1L;
/* 345 */         if (!false) {
/* 346 */           bhj_value8 = (long) scan_value;
/* 347 */         }
/* 348 */         // find matches from HashedRelation
/* 349 */         UnsafeRow bhj_matched1 = bhj_isNull8 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value8);
/* 350 */         if (bhj_matched1 == null) continue;
/* 351 */
/* 352 */         bhj_numOutputRows1.add(1);
/* 353 */
/* 354 */         // generate join key for stream side
/* 355 */
/* 356 */         boolean bhj_isNull23 = false;
/* 357 */         long bhj_value23 = -1L;
/* 358 */         if (!false) {
/* 359 */           bhj_value23 = (long) scan_value1;
/* 360 */         }
/* 361 */         // find matches from HashedRelation
/* 362 */         UnsafeRow bhj_matched2 = bhj_isNull23 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value23);
/* 363 */         if (bhj_matched2 == null) continue;
/* 364 */
/* 365 */         bhj_numOutputRows2.add(1);
/* 366 */
/* 367 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 368 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 369 */         boolean bhj_isNull14 = bhj_matched1.isNullAt(4);
/* 370 */         UTF8String bhj_value14 = bhj_isNull14 ? null : (bhj_matched1.getUTF8String(4));
/* 371 */         boolean bhj_isNull11 = bhj_matched1.isNullAt(1);
/* 372 */         UTF8String bhj_value11 = bhj_isNull11 ? null : (bhj_matched1.getUTF8String(1));
/* 373 */         boolean bhj_isNull12 = bhj_matched1.isNullAt(2);
/* 374 */         UTF8String bhj_value12 = bhj_isNull12 ? null : (bhj_matched1.getUTF8String(2));
/* 375 */         boolean bhj_isNull13 = bhj_matched1.isNullAt(3);
/* 376 */         UTF8String bhj_value13 = bhj_isNull13 ? null : (bhj_matched1.getUTF8String(3));
/* 377 */
/* 378 */         boolean expand_isNull1 = true;
/* 379 */         UTF8String expand_value1 = null;
/* 380 */         boolean expand_isNull2 = true;
/* 381 */         UTF8String expand_value2 = null;
/* 382 */         boolean expand_isNull3 = true;
/* 383 */         UTF8String expand_value3 = null;
/* 384 */         boolean expand_isNull4 = true;
/* 385 */         UTF8String expand_value4 = null;
/* 386 */         boolean expand_isNull5 = true;
/* 387 */         int expand_value5 = -1;
/* 388 */         for (int expand_i = 0; expand_i < 5; expand_i ++) {
/* 389 */           switch (expand_i) {
/* 390 */           case 0:
/* 391 */             expand_isNull1 = bhj_isNull14;
/* 392 */             expand_value1 = bhj_value14;
/* 393 */
/* 394 */             expand_isNull2 = bhj_isNull11;
/* 395 */             expand_value2 = bhj_value11;
/* 396 */
/* 397 */             expand_isNull3 = bhj_isNull12;
/* 398 */             expand_value3 = bhj_value12;
/* 399 */
/* 400 */             expand_isNull4 = bhj_isNull13;
/* 401 */             expand_value4 = bhj_value13;
/* 402 */
/* 403 */             expand_isNull5 = false;
/* 404 */             expand_value5 = 0;
/* 405 */             break;
/* 406 */
/* 407 */           case 1:
/* 408 */             expand_isNull1 = bhj_isNull14;
/* 409 */             expand_value1 = bhj_value14;
/* 410 */
/* 411 */             expand_isNull2 = bhj_isNull11;
/* 412 */             expand_value2 = bhj_value11;
/* 413 */
/* 414 */             expand_isNull3 = bhj_isNull12;
/* 415 */             expand_value3 = bhj_value12;
/* 416 */
/* 417 */             final UTF8String expand_value14 = null;
/* 418 */             expand_isNull4 = true;
/* 419 */             expand_value4 = expand_value14;
/* 420 */
/* 421 */             expand_isNull5 = false;
/* 422 */             expand_value5 = 1;
/* 423 */             break;
/* 424 */
/* 425 */           case 2:
/* 426 */             expand_isNull1 = bhj_isNull14;
/* 427 */             expand_value1 = bhj_value14;
/* 428 */
/* 429 */             expand_isNull2 = bhj_isNull11;
/* 430 */             expand_value2 = bhj_value11;
/* 431 */
/* 432 */             final UTF8String expand_value18 = null;
/* 433 */             expand_isNull3 = true;
/* 434 */             expand_value3 = expand_value18;
/* 435 */
/* 436 */             final UTF8String expand_value19 = null;
/* 437 */             expand_isNull4 = true;
/* 438 */             expand_value4 = expand_value19;
/* 439 */
/* 440 */             expand_isNull5 = false;
/* 441 */             expand_value5 = 3;
/* 442 */             break;
/* 443 */
/* 444 */           case 3:
/* 445 */             expand_isNull1 = bhj_isNull14;
/* 446 */             expand_value1 = bhj_value14;
/* 447 */
/* 448 */             final UTF8String expand_value22 = null;
/* 449 */             expand_isNull2 = true;
/* 450 */             expand_value2 = expand_value22;
/* 451 */
/* 452 */             final UTF8String expand_value23 = null;
/* 453 */             expand_isNull3 = true;
/* 454 */             expand_value3 = expand_value23;
/* 455 */
/* 456 */             final UTF8String expand_value24 = null;
/* 457 */             expand_isNull4 = true;
/* 458 */             expand_value4 = expand_value24;
/* 459 */
/* 460 */             expand_isNull5 = false;
/* 461 */             expand_value5 = 7;
/* 462 */             break;
/* 463 */
/* 464 */           case 4:
/* 465 */             final UTF8String expand_value26 = null;
/* 466 */             expand_isNull1 = true;
/* 467 */             expand_value1 = expand_value26;
/* 468 */
/* 469 */             final UTF8String expand_value27 = null;
/* 470 */             expand_isNull2 = true;
/* 471 */             expand_value2 = expand_value27;
/* 472 */
/* 473 */             final UTF8String expand_value28 = null;
/* 474 */             expand_isNull3 = true;
/* 475 */             expand_value3 = expand_value28;
/* 476 */
/* 477 */             final UTF8String expand_value29 = null;
/* 478 */             expand_isNull4 = true;
/* 479 */             expand_value4 = expand_value29;
/* 480 */
/* 481 */             expand_isNull5 = false;
/* 482 */             expand_value5 = 15;
/* 483 */             break;
/* 484 */           }
/* 485 */           expand_numOutputRows.add(1);
/* 486 */
/* 487 */           UnsafeRow agg_unsafeRowAggBuffer = null;
/* 488 */
/* 489 */           UnsafeRow agg_fastAggBuffer = null;
/* 490 */
/* 491 */           if (true) {
/* 492 */             if (!expand_isNull1 && !expand_isNull2 && !expand_isNull3 && !expand_isNull4 && !expand_isNull5) {
/* 493 */               agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 494 */                 expand_value1, expand_value2, expand_value3, expand_value4, expand_value5);
/* 495 */             }
/* 496 */           }
/* 497 */
/* 498 */           if (agg_fastAggBuffer == null) {
/* 499 */             // generate grouping key
/* 500 */             agg_holder.reset();
/* 501 */
/* 502 */             agg_rowWriter.zeroOutNullBytes();
/* 503 */
/* 504 */             if (expand_isNull1) {
/* 505 */               agg_rowWriter.setNullAt(0);
/* 506 */             } else {
/* 507 */               agg_rowWriter.write(0, expand_value1);
/* 508 */             }
/* 509 */
/* 510 */             if (expand_isNull2) {
/* 511 */               agg_rowWriter.setNullAt(1);
/* 512 */             } else {
/* 513 */               agg_rowWriter.write(1, expand_value2);
/* 514 */             }
/* 515 */
/* 516 */             if (expand_isNull3) {
/* 517 */               agg_rowWriter.setNullAt(2);
/* 518 */             } else {
/* 519 */               agg_rowWriter.write(2, expand_value3);
/* 520 */             }
/* 521 */
/* 522 */             if (expand_isNull4) {
/* 523 */               agg_rowWriter.setNullAt(3);
/* 524 */             } else {
/* 525 */               agg_rowWriter.write(3, expand_value4);
/* 526 */             }
/* 527 */
/* 528 */             if (expand_isNull5) {
/* 529 */               agg_rowWriter.setNullAt(4);
/* 530 */             } else {
/* 531 */               agg_rowWriter.write(4, expand_value5);
/* 532 */             }
/* 533 */             agg_result5.setTotalSize(agg_holder.totalSize());
/* 534 */             agg_value15 = 42;
/* 535 */
/* 536 */             if (!expand_isNull1) {
/* 537 */               agg_value15 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value1.getBaseObject(), expand_value1.getBaseOffset(), expand_value1.numBytes(), agg_value15);
/* 538 */             }
/* 539 */
/* 540 */             if (!expand_isNull2) {
/* 541 */               agg_value15 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value2.getBaseObject(), expand_value2.getBaseOffset(), expand_value2.numBytes(), agg_value15);
/* 542 */             }
/* 543 */
/* 544 */             if (!expand_isNull3) {
/* 545 */               agg_value15 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value3.getBaseObject(), expand_value3.getBaseOffset(), expand_value3.numBytes(), agg_value15);
/* 546 */             }
/* 547 */
/* 548 */             if (!expand_isNull4) {
/* 549 */               agg_value15 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value4.getBaseObject(), expand_value4.getBaseOffset(), expand_value4.numBytes(), agg_value15);
/* 550 */             }
/* 551 */
/* 552 */             agg_value15 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(expand_value5, agg_value15);
/* 553 */             if (true) {
/* 554 */               // try to get the buffer from hash map
/* 555 */               agg_unsafeRowAggBuffer =
/* 556 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value15);
/* 557 */             }
/* 558 */             if (agg_unsafeRowAggBuffer == null) {
/* 559 */               if (agg_sorter == null) {
/* 560 */                 agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 561 */               } else {
/* 562 */                 agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 563 */               }
/* 564 */
/* 565 */               // the hash map had be spilled, it should have enough memory now,
/* 566 */               // try  to allocate buffer again.
/* 567 */               agg_unsafeRowAggBuffer =
/* 568 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value15);
/* 569 */               if (agg_unsafeRowAggBuffer == null) {
/* 570 */                 // failed to allocate the first page
/* 571 */                 throw new OutOfMemoryError("No enough memory for aggregation");
/* 572 */               }
/* 573 */             }
/* 574 */           }
/* 575 */
/* 576 */           if (agg_fastAggBuffer != null) {
/* 577 */             // update fast row
/* 578 */
/* 579 */             // common sub-expressions
/* 580 */             boolean agg_isNull33 = scan_isNull2;
/* 581 */             long agg_value35 = -1L;
/* 582 */             if (!scan_isNull2) {
/* 583 */               agg_value35 = (long) scan_value2;
/* 584 */             }
/* 585 */             // evaluate aggregate function
/* 586 */             boolean agg_isNull35 = true;
/* 587 */             double agg_value37 = -1.0;
/* 588 */
/* 589 */             boolean agg_isNull36 = agg_fastAggBuffer.isNullAt(0);
/* 590 */             double agg_value38 = agg_isNull36 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 591 */             if (!agg_isNull36) {
/* 592 */               boolean agg_isNull38 = agg_isNull33;
/* 593 */               double agg_value40 = -1.0;
/* 594 */               if (!agg_isNull33) {
/* 595 */                 agg_value40 = (double) agg_value35;
/* 596 */               }
/* 597 */               boolean agg_isNull37 = agg_isNull38;
/* 598 */               double agg_value39 = agg_value40;
/* 599 */               if (agg_isNull37) {
/* 600 */                 boolean agg_isNull39 = false;
/* 601 */                 double agg_value41 = -1.0;
/* 602 */                 if (!false) {
/* 603 */                   agg_value41 = (double) 0;
/* 604 */                 }
/* 605 */                 if (!agg_isNull39) {
/* 606 */                   agg_isNull37 = false;
/* 607 */                   agg_value39 = agg_value41;
/* 608 */                 }
/* 609 */               }
/* 610 */
/* 611 */               agg_isNull35 = false; // resultCode could change nullability.
/* 612 */               agg_value37 = agg_value38 + agg_value39;
/* 613 */
/* 614 */             }
/* 615 */             boolean agg_isNull41 = false;
/* 616 */             long agg_value43 = -1L;
/* 617 */             if (!false && agg_isNull33) {
/* 618 */               boolean agg_isNull43 = agg_fastAggBuffer.isNullAt(1);
/* 619 */               long agg_value45 = agg_isNull43 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 620 */               agg_isNull41 = agg_isNull43;
/* 621 */               agg_value43 = agg_value45;
/* 622 */             } else {
/* 623 */               boolean agg_isNull44 = true;
/* 624 */               long agg_value46 = -1L;
/* 625 */
/* 626 */               boolean agg_isNull45 = agg_fastAggBuffer.isNullAt(1);
/* 627 */               long agg_value47 = agg_isNull45 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 628 */               if (!agg_isNull45) {
/* 629 */                 agg_isNull44 = false; // resultCode could change nullability.
/* 630 */                 agg_value46 = agg_value47 + 1L;
/* 631 */
/* 632 */               }
/* 633 */               agg_isNull41 = agg_isNull44;
/* 634 */               agg_value43 = agg_value46;
/* 635 */             }
/* 636 */             // update fast row
/* 637 */             if (!agg_isNull35) {
/* 638 */               agg_fastAggBuffer.setDouble(0, agg_value37);
/* 639 */             } else {
/* 640 */               agg_fastAggBuffer.setNullAt(0);
/* 641 */             }
/* 642 */
/* 643 */             if (!agg_isNull41) {
/* 644 */               agg_fastAggBuffer.setLong(1, agg_value43);
/* 645 */             } else {
/* 646 */               agg_fastAggBuffer.setNullAt(1);
/* 647 */             }
/* 648 */
/* 649 */           } else {
/* 650 */             // update unsafe row
/* 651 */
/* 652 */             // common sub-expressions
/* 653 */             boolean agg_isNull19 = scan_isNull2;
/* 654 */             long agg_value21 = -1L;
/* 655 */             if (!scan_isNull2) {
/* 656 */               agg_value21 = (long) scan_value2;
/* 657 */             }
/* 658 */             // evaluate aggregate function
/* 659 */             boolean agg_isNull21 = true;
/* 660 */             double agg_value23 = -1.0;
/* 661 */
/* 662 */             boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 663 */             double agg_value24 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 664 */             if (!agg_isNull22) {
/* 665 */               boolean agg_isNull24 = agg_isNull19;
/* 666 */               double agg_value26 = -1.0;
/* 667 */               if (!agg_isNull19) {
/* 668 */                 agg_value26 = (double) agg_value21;
/* 669 */               }
/* 670 */               boolean agg_isNull23 = agg_isNull24;
/* 671 */               double agg_value25 = agg_value26;
/* 672 */               if (agg_isNull23) {
/* 673 */                 boolean agg_isNull25 = false;
/* 674 */                 double agg_value27 = -1.0;
/* 675 */                 if (!false) {
/* 676 */                   agg_value27 = (double) 0;
/* 677 */                 }
/* 678 */                 if (!agg_isNull25) {
/* 679 */                   agg_isNull23 = false;
/* 680 */                   agg_value25 = agg_value27;
/* 681 */                 }
/* 682 */               }
/* 683 */
/* 684 */               agg_isNull21 = false; // resultCode could change nullability.
/* 685 */               agg_value23 = agg_value24 + agg_value25;
/* 686 */
/* 687 */             }
/* 688 */             boolean agg_isNull27 = false;
/* 689 */             long agg_value29 = -1L;
/* 690 */             if (!false && agg_isNull19) {
/* 691 */               boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 692 */               long agg_value31 = agg_isNull29 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 693 */               agg_isNull27 = agg_isNull29;
/* 694 */               agg_value29 = agg_value31;
/* 695 */             } else {
/* 696 */               boolean agg_isNull30 = true;
/* 697 */               long agg_value32 = -1L;
/* 698 */
/* 699 */               boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 700 */               long agg_value33 = agg_isNull31 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 701 */               if (!agg_isNull31) {
/* 702 */                 agg_isNull30 = false; // resultCode could change nullability.
/* 703 */                 agg_value32 = agg_value33 + 1L;
/* 704 */
/* 705 */               }
/* 706 */               agg_isNull27 = agg_isNull30;
/* 707 */               agg_value29 = agg_value32;
/* 708 */             }
/* 709 */             // update unsafe row buffer
/* 710 */             if (!agg_isNull21) {
/* 711 */               agg_unsafeRowAggBuffer.setDouble(0, agg_value23);
/* 712 */             } else {
/* 713 */               agg_unsafeRowAggBuffer.setNullAt(0);
/* 714 */             }
/* 715 */
/* 716 */             if (!agg_isNull27) {
/* 717 */               agg_unsafeRowAggBuffer.setLong(1, agg_value29);
/* 718 */             } else {
/* 719 */               agg_unsafeRowAggBuffer.setNullAt(1);
/* 720 */             }
/* 721 */
/* 722 */           }
/* 723 */
/* 724 */         }
/* 725 */         // shouldStop check is eliminated
/* 726 */       }
/* 727 */       scan_batchIdx = scan_numRows;
/* 728 */       scan_batch = null;
/* 729 */       scan_nextBatch();
/* 730 */     }
/* 731 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 732 */     scan_scanTime1 = 0;
/* 733 */
/* 734 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 735 */
/* 736 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 737 */   }
/* 738 */
/* 739 */   private void wholestagecodegen_init_2() {
/* 740 */     project_result1 = new UnsafeRow(3);
/* 741 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 742 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 3);
/* 743 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[15];
/* 744 */
/* 745 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 746 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 747 */
/* 748 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 749 */     bhj_result1 = new UnsafeRow(8);
/* 750 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 128);
/* 751 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 8);
/* 752 */     project_result2 = new UnsafeRow(6);
/* 753 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 128);
/* 754 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 755 */
/* 756 */   }
/* 757 */
/* 758 */   private void wholestagecodegen_init_1() {
/* 759 */     filter_result = new UnsafeRow(4);
/* 760 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 761 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 762 */     project_result = new UnsafeRow(4);
/* 763 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 764 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 765 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 766 */
/* 767 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 768 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 769 */
/* 770 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 771 */     bhj_result = new UnsafeRow(5);
/* 772 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 773 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 774 */
/* 775 */   }
/* 776 */
/* 777 */   private void wholestagecodegen_init_4() {
/* 778 */     this.expand_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(expand_holder, 6);
/* 779 */     agg_result5 = new UnsafeRow(5);
/* 780 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result5, 128);
/* 781 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 782 */
/* 783 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 784 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[20];
/* 785 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[21];
/* 786 */
/* 787 */   }
/* 788 */
/* 789 */   protected void processNext() throws java.io.IOException {
/* 790 */     if (!agg_initAgg) {
/* 791 */       agg_initAgg = true;
/* 792 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 793 */       agg_doAggregateWithKeys();
/* 794 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 795 */     }
/* 796 */
/* 797 */     // output the result
/* 798 */
/* 799 */     while (agg_fastHashMapIter.next()) {
/* 800 */       wholestagecodegen_numOutputRows.add(1);
/* 801 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 802 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 803 */
/* 804 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 805 */
/* 806 */       append(agg_resultRow.copy());
/* 807 */
/* 808 */       if (shouldStop()) return;
/* 809 */     }
/* 810 */     agg_fastHashMap.close();
/* 811 */
/* 812 */     while (agg_mapIter.next()) {
/* 813 */       wholestagecodegen_numOutputRows.add(1);
/* 814 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 815 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 816 */
/* 817 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 818 */
/* 819 */       append(agg_resultRow.copy());
/* 820 */
/* 821 */       if (shouldStop()) return;
/* 822 */     }
/* 823 */
/* 824 */     agg_mapIter.close();
/* 825 */     if (agg_sorter == null) {
/* 826 */       agg_hashMap.free();
/* 827 */     }
/* 828 */   }
/* 829 */ }
