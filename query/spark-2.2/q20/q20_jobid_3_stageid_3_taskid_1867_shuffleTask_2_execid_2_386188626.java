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
/* 023 */   private scala.collection.Iterator scan_input;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 026 */   private long scan_scanTime1;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 028 */   private int scan_batchIdx;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 030 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 031 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 032 */   private UnsafeRow scan_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 035 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 036 */   private UnsafeRow filter_result;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 039 */   private UnsafeRow project_result;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 042 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 043 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 044 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 045 */   private UnsafeRow bhj_result;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 048 */   private UnsafeRow project_result1;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 051 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 052 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 053 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 054 */   private UnsafeRow bhj_result1;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 057 */   private UnsafeRow project_result2;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 060 */   private UnsafeRow agg_result5;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 063 */   private int agg_value16;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 065 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 066 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 067 */
/* 068 */   public GeneratedIterator(Object[] references) {
/* 069 */     this.references = references;
/* 070 */   }
/* 071 */
/* 072 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 073 */     partitionIndex = index;
/* 074 */     this.inputs = inputs;
/* 075 */     wholestagecodegen_init_0();
/* 076 */     wholestagecodegen_init_1();
/* 077 */     wholestagecodegen_init_2();
/* 078 */     wholestagecodegen_init_3();
/* 079 */
/* 080 */   }
/* 081 */
/* 082 */   private void wholestagecodegen_init_0() {
/* 083 */     agg_initAgg = false;
/* 084 */
/* 085 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 086 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 087 */
/* 088 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 089 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 090 */     scan_input = inputs[0];
/* 091 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 092 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 093 */     scan_scanTime1 = 0;
/* 094 */     scan_batch = null;
/* 095 */     scan_batchIdx = 0;
/* 096 */     scan_colInstance0 = null;
/* 097 */     scan_colInstance1 = null;
/* 098 */     scan_colInstance2 = null;
/* 099 */     scan_result = new UnsafeRow(3);
/* 100 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 101 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 102 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 103 */
/* 104 */   }
/* 105 */
/* 106 */   private void wholestagecodegen_init_3() {
/* 107 */     agg_result5 = new UnsafeRow(5);
/* 108 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result5, 128);
/* 109 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 110 */
/* 111 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 112 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 113 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[19];
/* 114 */
/* 115 */   }
/* 116 */
/* 117 */   private void scan_nextBatch() throws java.io.IOException {
/* 118 */     long getBatchStart = System.nanoTime();
/* 119 */     if (scan_input.hasNext()) {
/* 120 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 121 */       scan_numOutputRows.add(scan_batch.numRows());
/* 122 */       scan_batchIdx = 0;
/* 123 */       scan_colInstance0 = scan_batch.column(0);
/* 124 */       scan_colInstance1 = scan_batch.column(1);
/* 125 */       scan_colInstance2 = scan_batch.column(2);
/* 126 */
/* 127 */     }
/* 128 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 129 */   }
/* 130 */
/* 131 */   public class agg_FastHashMap {
/* 132 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 133 */     private int[] buckets;
/* 134 */     private int capacity = 1 << 16;
/* 135 */     private double loadFactor = 0.5;
/* 136 */     private int numBuckets = (int) (capacity / loadFactor);
/* 137 */     private int maxSteps = 2;
/* 138 */     private int numRows = 0;
/* 139 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 140 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 141 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 142 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.StringType)
/* 143 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 144 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 145 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 146 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 147 */     private Object emptyVBase;
/* 148 */     private long emptyVOff;
/* 149 */     private int emptyVLen;
/* 150 */     private boolean isBatchFull = false;
/* 151 */
/* 152 */     public agg_FastHashMap(
/* 153 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 154 */       InternalRow emptyAggregationBuffer) {
/* 155 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 156 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 157 */
/* 158 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 159 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 160 */
/* 161 */       emptyVBase = emptyBuffer;
/* 162 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 163 */       emptyVLen = emptyBuffer.length;
/* 164 */
/* 165 */       buckets = new int[numBuckets];
/* 166 */       java.util.Arrays.fill(buckets, -1);
/* 167 */     }
/* 168 */
/* 169 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, double agg_key4) {
/* 170 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4);
/* 171 */       int step = 0;
/* 172 */       int idx = (int) h & (numBuckets - 1);
/* 173 */       while (step < maxSteps) {
/* 174 */         // Return bucket index if it's either an empty slot or already contains the key
/* 175 */         if (buckets[idx] == -1) {
/* 176 */           if (numRows < capacity && !isBatchFull) {
/* 177 */             // creating the unsafe for new entry
/* 178 */             UnsafeRow agg_result = new UnsafeRow(5);
/* 179 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 180 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 181 */               128);
/* 182 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 183 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 184 */               agg_holder,
/* 185 */               5);
/* 186 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 187 */             agg_rowWriter.zeroOutNullBytes();
/* 188 */             agg_rowWriter.write(0, agg_key);
/* 189 */             agg_rowWriter.write(1, agg_key1);
/* 190 */             agg_rowWriter.write(2, agg_key2);
/* 191 */             agg_rowWriter.write(3, agg_key3);
/* 192 */             agg_rowWriter.write(4, agg_key4);
/* 193 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 194 */             Object kbase = agg_result.getBaseObject();
/* 195 */             long koff = agg_result.getBaseOffset();
/* 196 */             int klen = agg_result.getSizeInBytes();
/* 197 */
/* 198 */             UnsafeRow vRow
/* 199 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 200 */             if (vRow == null) {
/* 201 */               isBatchFull = true;
/* 202 */             } else {
/* 203 */               buckets[idx] = numRows++;
/* 204 */             }
/* 205 */             return vRow;
/* 206 */           } else {
/* 207 */             // No more space
/* 208 */             return null;
/* 209 */           }
/* 210 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4)) {
/* 211 */           return batch.getValueRow(buckets[idx]);
/* 212 */         }
/* 213 */         idx = (idx + 1) & (numBuckets - 1);
/* 214 */         step++;
/* 215 */       }
/* 216 */       // Didn't find it
/* 217 */       return null;
/* 218 */     }
/* 219 */
/* 220 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, double agg_key4) {
/* 221 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 222 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && ((java.lang.Double.isNaN(row.getDouble(4)) && java.lang.Double.isNaN(agg_key4)) || row.getDouble(4) == agg_key4);
/* 223 */     }
/* 224 */
/* 225 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, double agg_key4) {
/* 226 */       long agg_hash = 0;
/* 227 */
/* 228 */       int agg_result = 0;
/* 229 */       byte[] agg_bytes = agg_key.getBytes();
/* 230 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 231 */         int agg_hash1 = agg_bytes[i];
/* 232 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 233 */       }
/* 234 */
/* 235 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 236 */
/* 237 */       int agg_result1 = 0;
/* 238 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 239 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 240 */         int agg_hash2 = agg_bytes1[i];
/* 241 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 242 */       }
/* 243 */
/* 244 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 245 */
/* 246 */       int agg_result2 = 0;
/* 247 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 248 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 249 */         int agg_hash3 = agg_bytes2[i];
/* 250 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 251 */       }
/* 252 */
/* 253 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 254 */
/* 255 */       int agg_result3 = 0;
/* 256 */       byte[] agg_bytes3 = agg_key3.getBytes();
/* 257 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 258 */         int agg_hash4 = agg_bytes3[i];
/* 259 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash4 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 260 */       }
/* 261 */
/* 262 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 263 */
/* 264 */       long agg_result4 = Double.doubleToLongBits(agg_key4);
/* 265 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 266 */
/* 267 */       return agg_hash;
/* 268 */     }
/* 269 */
/* 270 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 271 */       return batch.rowIterator();
/* 272 */     }
/* 273 */
/* 274 */     public void close() {
/* 275 */       batch.close();
/* 276 */     }
/* 277 */
/* 278 */   }
/* 279 */
/* 280 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 281 */     agg_hashMap = agg_plan.createHashMap();
/* 282 */
/* 283 */     if (scan_batch == null) {
/* 284 */       scan_nextBatch();
/* 285 */     }
/* 286 */     while (scan_batch != null) {
/* 287 */       int scan_numRows = scan_batch.numRows();
/* 288 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 289 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 290 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 291 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 292 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 293 */
/* 294 */         if (!(!(scan_isNull))) continue;
/* 295 */
/* 296 */         filter_numOutputRows.add(1);
/* 297 */
/* 298 */         // generate join key for stream side
/* 299 */
/* 300 */         boolean bhj_isNull = false;
/* 301 */         long bhj_value = -1L;
/* 302 */         if (!false) {
/* 303 */           bhj_value = (long) scan_value;
/* 304 */         }
/* 305 */         // find matches from HashedRelation
/* 306 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 307 */         if (bhj_matched == null) continue;
/* 308 */
/* 309 */         bhj_numOutputRows.add(1);
/* 310 */
/* 311 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 312 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 313 */
/* 314 */         // generate join key for stream side
/* 315 */
/* 316 */         boolean bhj_isNull17 = scan_isNull2;
/* 317 */         long bhj_value17 = -1L;
/* 318 */         if (!scan_isNull2) {
/* 319 */           bhj_value17 = (long) scan_value2;
/* 320 */         }
/* 321 */         // find matches from HashedRelation
/* 322 */         UnsafeRow bhj_matched1 = bhj_isNull17 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value17);
/* 323 */         if (bhj_matched1 == null) continue;
/* 324 */
/* 325 */         bhj_numOutputRows1.add(1);
/* 326 */
/* 327 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 328 */         double scan_value1 = scan_isNull1 ? -1.0 : (scan_colInstance1.getDouble(scan_rowIdx));
/* 329 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 330 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 331 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 332 */         UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 333 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 334 */         double bhj_value5 = bhj_isNull5 ? -1.0 : (bhj_matched.getDouble(3));
/* 335 */         boolean bhj_isNull6 = bhj_matched.isNullAt(4);
/* 336 */         UTF8String bhj_value6 = bhj_isNull6 ? null : (bhj_matched.getUTF8String(4));
/* 337 */         boolean bhj_isNull7 = bhj_matched.isNullAt(5);
/* 338 */         UTF8String bhj_value7 = bhj_isNull7 ? null : (bhj_matched.getUTF8String(5));
/* 339 */
/* 340 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 341 */
/* 342 */         UnsafeRow agg_fastAggBuffer = null;
/* 343 */
/* 344 */         if (true) {
/* 345 */           if (!bhj_isNull3 && !bhj_isNull4 && !bhj_isNull7 && !bhj_isNull6 && !bhj_isNull5) {
/* 346 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 347 */               bhj_value3, bhj_value4, bhj_value7, bhj_value6, bhj_value5);
/* 348 */           }
/* 349 */         }
/* 350 */
/* 351 */         if (agg_fastAggBuffer == null) {
/* 352 */           // generate grouping key
/* 353 */           agg_holder.reset();
/* 354 */
/* 355 */           agg_rowWriter.zeroOutNullBytes();
/* 356 */
/* 357 */           if (bhj_isNull3) {
/* 358 */             agg_rowWriter.setNullAt(0);
/* 359 */           } else {
/* 360 */             agg_rowWriter.write(0, bhj_value3);
/* 361 */           }
/* 362 */
/* 363 */           if (bhj_isNull4) {
/* 364 */             agg_rowWriter.setNullAt(1);
/* 365 */           } else {
/* 366 */             agg_rowWriter.write(1, bhj_value4);
/* 367 */           }
/* 368 */
/* 369 */           if (bhj_isNull7) {
/* 370 */             agg_rowWriter.setNullAt(2);
/* 371 */           } else {
/* 372 */             agg_rowWriter.write(2, bhj_value7);
/* 373 */           }
/* 374 */
/* 375 */           if (bhj_isNull6) {
/* 376 */             agg_rowWriter.setNullAt(3);
/* 377 */           } else {
/* 378 */             agg_rowWriter.write(3, bhj_value6);
/* 379 */           }
/* 380 */
/* 381 */           if (bhj_isNull5) {
/* 382 */             agg_rowWriter.setNullAt(4);
/* 383 */           } else {
/* 384 */             agg_rowWriter.write(4, bhj_value5);
/* 385 */           }
/* 386 */           agg_result5.setTotalSize(agg_holder.totalSize());
/* 387 */           agg_value16 = 42;
/* 388 */
/* 389 */           if (!bhj_isNull3) {
/* 390 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value3.getBaseObject(), bhj_value3.getBaseOffset(), bhj_value3.numBytes(), agg_value16);
/* 391 */           }
/* 392 */
/* 393 */           if (!bhj_isNull4) {
/* 394 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value4.getBaseObject(), bhj_value4.getBaseOffset(), bhj_value4.numBytes(), agg_value16);
/* 395 */           }
/* 396 */
/* 397 */           if (!bhj_isNull7) {
/* 398 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value7.getBaseObject(), bhj_value7.getBaseOffset(), bhj_value7.numBytes(), agg_value16);
/* 399 */           }
/* 400 */
/* 401 */           if (!bhj_isNull6) {
/* 402 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value6.getBaseObject(), bhj_value6.getBaseOffset(), bhj_value6.numBytes(), agg_value16);
/* 403 */           }
/* 404 */
/* 405 */           if (!bhj_isNull5) {
/* 406 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(Double.doubleToLongBits(bhj_value5), agg_value16);
/* 407 */           }
/* 408 */           if (true) {
/* 409 */             // try to get the buffer from hash map
/* 410 */             agg_unsafeRowAggBuffer =
/* 411 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value16);
/* 412 */           }
/* 413 */           if (agg_unsafeRowAggBuffer == null) {
/* 414 */             if (agg_sorter == null) {
/* 415 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 416 */             } else {
/* 417 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 418 */             }
/* 419 */
/* 420 */             // the hash map had be spilled, it should have enough memory now,
/* 421 */             // try  to allocate buffer again.
/* 422 */             agg_unsafeRowAggBuffer =
/* 423 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value16);
/* 424 */             if (agg_unsafeRowAggBuffer == null) {
/* 425 */               // failed to allocate the first page
/* 426 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 427 */             }
/* 428 */           }
/* 429 */         }
/* 430 */
/* 431 */         if (agg_fastAggBuffer != null) {
/* 432 */           // update fast row
/* 433 */
/* 434 */           // common sub-expressions
/* 435 */
/* 436 */           // evaluate aggregate function
/* 437 */           boolean agg_isNull46 = true;
/* 438 */           double agg_value49 = -1.0;
/* 439 */
/* 440 */           boolean agg_isNull48 = agg_fastAggBuffer.isNullAt(0);
/* 441 */           double agg_value51 = agg_isNull48 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 442 */           boolean agg_isNull47 = agg_isNull48;
/* 443 */           double agg_value50 = agg_value51;
/* 444 */           if (agg_isNull47) {
/* 445 */             boolean agg_isNull49 = false;
/* 446 */             double agg_value52 = -1.0;
/* 447 */             if (!false) {
/* 448 */               agg_value52 = (double) 0;
/* 449 */             }
/* 450 */             if (!agg_isNull49) {
/* 451 */               agg_isNull47 = false;
/* 452 */               agg_value50 = agg_value52;
/* 453 */             }
/* 454 */           }
/* 455 */
/* 456 */           if (!scan_isNull1) {
/* 457 */             agg_isNull46 = false; // resultCode could change nullability.
/* 458 */             agg_value49 = agg_value50 + scan_value1;
/* 459 */
/* 460 */           }
/* 461 */           boolean agg_isNull45 = agg_isNull46;
/* 462 */           double agg_value48 = agg_value49;
/* 463 */           if (agg_isNull45) {
/* 464 */             boolean agg_isNull52 = agg_fastAggBuffer.isNullAt(0);
/* 465 */             double agg_value55 = agg_isNull52 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 466 */             if (!agg_isNull52) {
/* 467 */               agg_isNull45 = false;
/* 468 */               agg_value48 = agg_value55;
/* 469 */             }
/* 470 */           }
/* 471 */           boolean agg_isNull54 = true;
/* 472 */           double agg_value57 = -1.0;
/* 473 */
/* 474 */           boolean agg_isNull56 = agg_fastAggBuffer.isNullAt(1);
/* 475 */           double agg_value59 = agg_isNull56 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 476 */           boolean agg_isNull55 = agg_isNull56;
/* 477 */           double agg_value58 = agg_value59;
/* 478 */           if (agg_isNull55) {
/* 479 */             boolean agg_isNull57 = false;
/* 480 */             double agg_value60 = -1.0;
/* 481 */             if (!false) {
/* 482 */               agg_value60 = (double) 0;
/* 483 */             }
/* 484 */             if (!agg_isNull57) {
/* 485 */               agg_isNull55 = false;
/* 486 */               agg_value58 = agg_value60;
/* 487 */             }
/* 488 */           }
/* 489 */
/* 490 */           if (!scan_isNull1) {
/* 491 */             agg_isNull54 = false; // resultCode could change nullability.
/* 492 */             agg_value57 = agg_value58 + scan_value1;
/* 493 */
/* 494 */           }
/* 495 */           boolean agg_isNull53 = agg_isNull54;
/* 496 */           double agg_value56 = agg_value57;
/* 497 */           if (agg_isNull53) {
/* 498 */             boolean agg_isNull60 = agg_fastAggBuffer.isNullAt(1);
/* 499 */             double agg_value63 = agg_isNull60 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 500 */             if (!agg_isNull60) {
/* 501 */               agg_isNull53 = false;
/* 502 */               agg_value56 = agg_value63;
/* 503 */             }
/* 504 */           }
/* 505 */           boolean agg_isNull62 = true;
/* 506 */           double agg_value65 = -1.0;
/* 507 */
/* 508 */           boolean agg_isNull64 = agg_fastAggBuffer.isNullAt(2);
/* 509 */           double agg_value67 = agg_isNull64 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 510 */           boolean agg_isNull63 = agg_isNull64;
/* 511 */           double agg_value66 = agg_value67;
/* 512 */           if (agg_isNull63) {
/* 513 */             boolean agg_isNull65 = false;
/* 514 */             double agg_value68 = -1.0;
/* 515 */             if (!false) {
/* 516 */               agg_value68 = (double) 0;
/* 517 */             }
/* 518 */             if (!agg_isNull65) {
/* 519 */               agg_isNull63 = false;
/* 520 */               agg_value66 = agg_value68;
/* 521 */             }
/* 522 */           }
/* 523 */
/* 524 */           if (!scan_isNull1) {
/* 525 */             agg_isNull62 = false; // resultCode could change nullability.
/* 526 */             agg_value65 = agg_value66 + scan_value1;
/* 527 */
/* 528 */           }
/* 529 */           boolean agg_isNull61 = agg_isNull62;
/* 530 */           double agg_value64 = agg_value65;
/* 531 */           if (agg_isNull61) {
/* 532 */             boolean agg_isNull68 = agg_fastAggBuffer.isNullAt(2);
/* 533 */             double agg_value71 = agg_isNull68 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 534 */             if (!agg_isNull68) {
/* 535 */               agg_isNull61 = false;
/* 536 */               agg_value64 = agg_value71;
/* 537 */             }
/* 538 */           }
/* 539 */           // update fast row
/* 540 */           if (!agg_isNull45) {
/* 541 */             agg_fastAggBuffer.setDouble(0, agg_value48);
/* 542 */           } else {
/* 543 */             agg_fastAggBuffer.setNullAt(0);
/* 544 */           }
/* 545 */
/* 546 */           if (!agg_isNull53) {
/* 547 */             agg_fastAggBuffer.setDouble(1, agg_value56);
/* 548 */           } else {
/* 549 */             agg_fastAggBuffer.setNullAt(1);
/* 550 */           }
/* 551 */
/* 552 */           if (!agg_isNull61) {
/* 553 */             agg_fastAggBuffer.setDouble(2, agg_value64);
/* 554 */           } else {
/* 555 */             agg_fastAggBuffer.setNullAt(2);
/* 556 */           }
/* 557 */
/* 558 */         } else {
/* 559 */           // update unsafe row
/* 560 */
/* 561 */           // common sub-expressions
/* 562 */
/* 563 */           // evaluate aggregate function
/* 564 */           boolean agg_isNull21 = true;
/* 565 */           double agg_value24 = -1.0;
/* 566 */
/* 567 */           boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 568 */           double agg_value26 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 569 */           boolean agg_isNull22 = agg_isNull23;
/* 570 */           double agg_value25 = agg_value26;
/* 571 */           if (agg_isNull22) {
/* 572 */             boolean agg_isNull24 = false;
/* 573 */             double agg_value27 = -1.0;
/* 574 */             if (!false) {
/* 575 */               agg_value27 = (double) 0;
/* 576 */             }
/* 577 */             if (!agg_isNull24) {
/* 578 */               agg_isNull22 = false;
/* 579 */               agg_value25 = agg_value27;
/* 580 */             }
/* 581 */           }
/* 582 */
/* 583 */           if (!scan_isNull1) {
/* 584 */             agg_isNull21 = false; // resultCode could change nullability.
/* 585 */             agg_value24 = agg_value25 + scan_value1;
/* 586 */
/* 587 */           }
/* 588 */           boolean agg_isNull20 = agg_isNull21;
/* 589 */           double agg_value23 = agg_value24;
/* 590 */           if (agg_isNull20) {
/* 591 */             boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 592 */             double agg_value30 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 593 */             if (!agg_isNull27) {
/* 594 */               agg_isNull20 = false;
/* 595 */               agg_value23 = agg_value30;
/* 596 */             }
/* 597 */           }
/* 598 */           boolean agg_isNull29 = true;
/* 599 */           double agg_value32 = -1.0;
/* 600 */
/* 601 */           boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 602 */           double agg_value34 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 603 */           boolean agg_isNull30 = agg_isNull31;
/* 604 */           double agg_value33 = agg_value34;
/* 605 */           if (agg_isNull30) {
/* 606 */             boolean agg_isNull32 = false;
/* 607 */             double agg_value35 = -1.0;
/* 608 */             if (!false) {
/* 609 */               agg_value35 = (double) 0;
/* 610 */             }
/* 611 */             if (!agg_isNull32) {
/* 612 */               agg_isNull30 = false;
/* 613 */               agg_value33 = agg_value35;
/* 614 */             }
/* 615 */           }
/* 616 */
/* 617 */           if (!scan_isNull1) {
/* 618 */             agg_isNull29 = false; // resultCode could change nullability.
/* 619 */             agg_value32 = agg_value33 + scan_value1;
/* 620 */
/* 621 */           }
/* 622 */           boolean agg_isNull28 = agg_isNull29;
/* 623 */           double agg_value31 = agg_value32;
/* 624 */           if (agg_isNull28) {
/* 625 */             boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 626 */             double agg_value38 = agg_isNull35 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 627 */             if (!agg_isNull35) {
/* 628 */               agg_isNull28 = false;
/* 629 */               agg_value31 = agg_value38;
/* 630 */             }
/* 631 */           }
/* 632 */           boolean agg_isNull37 = true;
/* 633 */           double agg_value40 = -1.0;
/* 634 */
/* 635 */           boolean agg_isNull39 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 636 */           double agg_value42 = agg_isNull39 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 637 */           boolean agg_isNull38 = agg_isNull39;
/* 638 */           double agg_value41 = agg_value42;
/* 639 */           if (agg_isNull38) {
/* 640 */             boolean agg_isNull40 = false;
/* 641 */             double agg_value43 = -1.0;
/* 642 */             if (!false) {
/* 643 */               agg_value43 = (double) 0;
/* 644 */             }
/* 645 */             if (!agg_isNull40) {
/* 646 */               agg_isNull38 = false;
/* 647 */               agg_value41 = agg_value43;
/* 648 */             }
/* 649 */           }
/* 650 */
/* 651 */           if (!scan_isNull1) {
/* 652 */             agg_isNull37 = false; // resultCode could change nullability.
/* 653 */             agg_value40 = agg_value41 + scan_value1;
/* 654 */
/* 655 */           }
/* 656 */           boolean agg_isNull36 = agg_isNull37;
/* 657 */           double agg_value39 = agg_value40;
/* 658 */           if (agg_isNull36) {
/* 659 */             boolean agg_isNull43 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 660 */             double agg_value46 = agg_isNull43 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 661 */             if (!agg_isNull43) {
/* 662 */               agg_isNull36 = false;
/* 663 */               agg_value39 = agg_value46;
/* 664 */             }
/* 665 */           }
/* 666 */           // update unsafe row buffer
/* 667 */           if (!agg_isNull20) {
/* 668 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value23);
/* 669 */           } else {
/* 670 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 671 */           }
/* 672 */
/* 673 */           if (!agg_isNull28) {
/* 674 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value31);
/* 675 */           } else {
/* 676 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 677 */           }
/* 678 */
/* 679 */           if (!agg_isNull36) {
/* 680 */             agg_unsafeRowAggBuffer.setDouble(2, agg_value39);
/* 681 */           } else {
/* 682 */             agg_unsafeRowAggBuffer.setNullAt(2);
/* 683 */           }
/* 684 */
/* 685 */         }
/* 686 */         // shouldStop check is eliminated
/* 687 */       }
/* 688 */       scan_batchIdx = scan_numRows;
/* 689 */       scan_batch = null;
/* 690 */       scan_nextBatch();
/* 691 */     }
/* 692 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 693 */     scan_scanTime1 = 0;
/* 694 */
/* 695 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 696 */
/* 697 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 698 */   }
/* 699 */
/* 700 */   private void wholestagecodegen_init_2() {
/* 701 */     project_result1 = new UnsafeRow(7);
/* 702 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 128);
/* 703 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 7);
/* 704 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[16];
/* 705 */
/* 706 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 707 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 708 */
/* 709 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 710 */     bhj_result1 = new UnsafeRow(8);
/* 711 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 128);
/* 712 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 8);
/* 713 */     project_result2 = new UnsafeRow(6);
/* 714 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 128);
/* 715 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 716 */
/* 717 */   }
/* 718 */
/* 719 */   private void wholestagecodegen_init_1() {
/* 720 */     filter_result = new UnsafeRow(3);
/* 721 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 722 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 723 */     project_result = new UnsafeRow(3);
/* 724 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 725 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 726 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[14];
/* 727 */
/* 728 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 729 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 730 */
/* 731 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 732 */     bhj_result = new UnsafeRow(9);
/* 733 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 128);
/* 734 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 9);
/* 735 */
/* 736 */   }
/* 737 */
/* 738 */   protected void processNext() throws java.io.IOException {
/* 739 */     if (!agg_initAgg) {
/* 740 */       agg_initAgg = true;
/* 741 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 742 */       agg_doAggregateWithKeys();
/* 743 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 744 */     }
/* 745 */
/* 746 */     // output the result
/* 747 */
/* 748 */     while (agg_fastHashMapIter.next()) {
/* 749 */       wholestagecodegen_numOutputRows.add(1);
/* 750 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 751 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 752 */
/* 753 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 754 */
/* 755 */       append(agg_resultRow);
/* 756 */
/* 757 */       if (shouldStop()) return;
/* 758 */     }
/* 759 */     agg_fastHashMap.close();
/* 760 */
/* 761 */     while (agg_mapIter.next()) {
/* 762 */       wholestagecodegen_numOutputRows.add(1);
/* 763 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 764 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 765 */
/* 766 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 767 */
/* 768 */       append(agg_resultRow);
/* 769 */
/* 770 */       if (shouldStop()) return;
/* 771 */     }
/* 772 */
/* 773 */     agg_mapIter.close();
/* 774 */     if (agg_sorter == null) {
/* 775 */       agg_hashMap.free();
/* 776 */     }
/* 777 */   }
/* 778 */ }
