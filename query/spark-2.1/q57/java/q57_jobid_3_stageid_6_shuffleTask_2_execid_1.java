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
/* 028 */   private UnsafeRow scan_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 032 */   private UnsafeRow filter_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 035 */   private UnsafeRow project_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 038 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 039 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 041 */   private UnsafeRow bhj_result;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 044 */   private UnsafeRow project_result1;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 047 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 048 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 049 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 050 */   private UnsafeRow bhj_result1;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 053 */   private UnsafeRow project_result2;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 056 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 057 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 058 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 059 */   private UnsafeRow bhj_result2;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 062 */   private UnsafeRow project_result3;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 065 */   private UnsafeRow agg_result5;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 068 */   private int agg_value12;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 070 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 071 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 072 */
/* 073 */   public GeneratedIterator(Object[] references) {
/* 074 */     this.references = references;
/* 075 */   }
/* 076 */
/* 077 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 078 */     partitionIndex = index;
/* 079 */     this.inputs = inputs;
/* 080 */     wholestagecodegen_init_0();
/* 081 */     wholestagecodegen_init_1();
/* 082 */     wholestagecodegen_init_2();
/* 083 */     wholestagecodegen_init_3();
/* 084 */     wholestagecodegen_init_4();
/* 085 */
/* 086 */   }
/* 087 */
/* 088 */   private void wholestagecodegen_init_0() {
/* 089 */     agg_initAgg = false;
/* 090 */
/* 091 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 092 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 093 */
/* 094 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 095 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 096 */     scan_input = inputs[0];
/* 097 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 098 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 099 */     scan_scanTime1 = 0;
/* 100 */     scan_batch = null;
/* 101 */     scan_batchIdx = 0;
/* 102 */     scan_colInstance0 = null;
/* 103 */     scan_colInstance1 = null;
/* 104 */     scan_colInstance2 = null;
/* 105 */     scan_result = new UnsafeRow(3);
/* 106 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 64);
/* 107 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 108 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 109 */
/* 110 */   }
/* 111 */
/* 112 */   private void wholestagecodegen_init_3() {
/* 113 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 114 */
/* 115 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 116 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 117 */
/* 118 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 119 */     bhj_result2 = new UnsafeRow(8);
/* 120 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 96);
/* 121 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 8);
/* 122 */     project_result3 = new UnsafeRow(6);
/* 123 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 96);
/* 124 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 6);
/* 125 */     agg_result5 = new UnsafeRow(5);
/* 126 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result5, 96);
/* 127 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 128 */
/* 129 */   }
/* 130 */
/* 131 */   private void scan_nextBatch() throws java.io.IOException {
/* 132 */     long getBatchStart = System.nanoTime();
/* 133 */     if (scan_input.hasNext()) {
/* 134 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 135 */       scan_numOutputRows.add(scan_batch.numRows());
/* 136 */       scan_batchIdx = 0;
/* 137 */       scan_colInstance0 = scan_batch.column(0);
/* 138 */       scan_colInstance1 = scan_batch.column(1);
/* 139 */       scan_colInstance2 = scan_batch.column(2);
/* 140 */
/* 141 */     }
/* 142 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 143 */   }
/* 144 */
/* 145 */   public class agg_FastHashMap {
/* 146 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 147 */     private int[] buckets;
/* 148 */     private int capacity = 1 << 16;
/* 149 */     private double loadFactor = 0.5;
/* 150 */     private int numBuckets = (int) (capacity / loadFactor);
/* 151 */     private int maxSteps = 2;
/* 152 */     private int numRows = 0;
/* 153 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("i_category", org.apache.spark.sql.types.DataTypes.StringType)
/* 154 */     .add("i_brand", org.apache.spark.sql.types.DataTypes.StringType)
/* 155 */     .add("cc_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 156 */     .add("d_year", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 157 */     .add("d_moy", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 158 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 159 */     private Object emptyVBase;
/* 160 */     private long emptyVOff;
/* 161 */     private int emptyVLen;
/* 162 */     private boolean isBatchFull = false;
/* 163 */
/* 164 */     public agg_FastHashMap(
/* 165 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 166 */       InternalRow emptyAggregationBuffer) {
/* 167 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 168 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 169 */
/* 170 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 171 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 172 */
/* 173 */       emptyVBase = emptyBuffer;
/* 174 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 175 */       emptyVLen = emptyBuffer.length;
/* 176 */
/* 177 */       buckets = new int[numBuckets];
/* 178 */       java.util.Arrays.fill(buckets, -1);
/* 179 */     }
/* 180 */
/* 181 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, int agg_key4) {
/* 182 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4);
/* 183 */       int step = 0;
/* 184 */       int idx = (int) h & (numBuckets - 1);
/* 185 */       while (step < maxSteps) {
/* 186 */         // Return bucket index if it's either an empty slot or already contains the key
/* 187 */         if (buckets[idx] == -1) {
/* 188 */           if (numRows < capacity && !isBatchFull) {
/* 189 */             // creating the unsafe for new entry
/* 190 */             UnsafeRow agg_result = new UnsafeRow(5);
/* 191 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 192 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 193 */               96);
/* 194 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 195 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 196 */               agg_holder,
/* 197 */               5);
/* 198 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 199 */             agg_rowWriter.zeroOutNullBytes();
/* 200 */             agg_rowWriter.write(0, agg_key);
/* 201 */             agg_rowWriter.write(1, agg_key1);
/* 202 */             agg_rowWriter.write(2, agg_key2);
/* 203 */             agg_rowWriter.write(3, agg_key3);
/* 204 */             agg_rowWriter.write(4, agg_key4);
/* 205 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 206 */             Object kbase = agg_result.getBaseObject();
/* 207 */             long koff = agg_result.getBaseOffset();
/* 208 */             int klen = agg_result.getSizeInBytes();
/* 209 */
/* 210 */             UnsafeRow vRow
/* 211 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 212 */             if (vRow == null) {
/* 213 */               isBatchFull = true;
/* 214 */             } else {
/* 215 */               buckets[idx] = numRows++;
/* 216 */             }
/* 217 */             return vRow;
/* 218 */           } else {
/* 219 */             // No more space
/* 220 */             return null;
/* 221 */           }
/* 222 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4)) {
/* 223 */           return batch.getValueRow(buckets[idx]);
/* 224 */         }
/* 225 */         idx = (idx + 1) & (numBuckets - 1);
/* 226 */         step++;
/* 227 */       }
/* 228 */       // Didn't find it
/* 229 */       return null;
/* 230 */     }
/* 231 */
/* 232 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, int agg_key4) {
/* 233 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 234 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getInt(3) == agg_key3) && (row.getInt(4) == agg_key4);
/* 235 */     }
/* 236 */
/* 237 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, int agg_key4) {
/* 238 */       long agg_hash = 0;
/* 239 */
/* 240 */       int agg_result = 0;
/* 241 */       byte[] agg_bytes = agg_key.getBytes();
/* 242 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 243 */         int agg_hash1 = agg_bytes[i];
/* 244 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 245 */       }
/* 246 */
/* 247 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 248 */
/* 249 */       int agg_result1 = 0;
/* 250 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 251 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 252 */         int agg_hash2 = agg_bytes1[i];
/* 253 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 254 */       }
/* 255 */
/* 256 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 257 */
/* 258 */       int agg_result2 = 0;
/* 259 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 260 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 261 */         int agg_hash3 = agg_bytes2[i];
/* 262 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 263 */       }
/* 264 */
/* 265 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 266 */
/* 267 */       int agg_result3 = agg_key3;
/* 268 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 269 */
/* 270 */       int agg_result4 = agg_key4;
/* 271 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
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
/* 293 */       int numRows = scan_batch.numRows();
/* 294 */       while (scan_batchIdx < numRows) {
/* 295 */         int scan_rowIdx = scan_batchIdx++;
/* 296 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 297 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 298 */
/* 299 */         if (!(!(scan_isNull))) continue;
/* 300 */
/* 301 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 302 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 303 */
/* 304 */         if (!(!(scan_isNull1))) continue;
/* 305 */
/* 306 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 307 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 308 */
/* 309 */         if (!(!(scan_isNull2))) continue;
/* 310 */
/* 311 */         filter_numOutputRows.add(1);
/* 312 */
/* 313 */         // generate join key for stream side
/* 314 */
/* 315 */         boolean bhj_isNull = false;
/* 316 */         long bhj_value = -1L;
/* 317 */         if (!false) {
/* 318 */           bhj_value = (long) scan_value;
/* 319 */         }
/* 320 */         // find matches from HashedRelation
/* 321 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 322 */         if (bhj_matched == null) continue;
/* 323 */
/* 324 */         bhj_numOutputRows.add(1);
/* 325 */
/* 326 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 327 */         int bhj_value5 = bhj_isNull5 ? -1 : (bhj_matched.getInt(3));
/* 328 */
/* 329 */         // generate join key for stream side
/* 330 */
/* 331 */         boolean bhj_isNull13 = bhj_isNull5;
/* 332 */         long bhj_value13 = -1L;
/* 333 */         if (!bhj_isNull5) {
/* 334 */           bhj_value13 = (long) bhj_value5;
/* 335 */         }
/* 336 */         // find matches from HashedRelation
/* 337 */         UnsafeRow bhj_matched1 = bhj_isNull13 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value13);
/* 338 */         if (bhj_matched1 == null) continue;
/* 339 */
/* 340 */         bhj_numOutputRows1.add(1);
/* 341 */
/* 342 */         boolean bhj_isNull2 = bhj_matched.isNullAt(0);
/* 343 */         int bhj_value2 = bhj_isNull2 ? -1 : (bhj_matched.getInt(0));
/* 344 */
/* 345 */         // generate join key for stream side
/* 346 */
/* 347 */         boolean bhj_isNull26 = bhj_isNull2;
/* 348 */         long bhj_value26 = -1L;
/* 349 */         if (!bhj_isNull2) {
/* 350 */           bhj_value26 = (long) bhj_value2;
/* 351 */         }
/* 352 */         // find matches from HashedRelation
/* 353 */         UnsafeRow bhj_matched2 = bhj_isNull26 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value26);
/* 354 */         if (bhj_matched2 == null) continue;
/* 355 */
/* 356 */         bhj_numOutputRows2.add(1);
/* 357 */
/* 358 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 359 */         double bhj_value4 = bhj_isNull4 ? -1.0 : (bhj_matched.getDouble(2));
/* 360 */         boolean bhj_isNull16 = bhj_matched1.isNullAt(1);
/* 361 */         int bhj_value16 = bhj_isNull16 ? -1 : (bhj_matched1.getInt(1));
/* 362 */         boolean bhj_isNull17 = bhj_matched1.isNullAt(2);
/* 363 */         int bhj_value17 = bhj_isNull17 ? -1 : (bhj_matched1.getInt(2));
/* 364 */         boolean bhj_isNull29 = bhj_matched2.isNullAt(1);
/* 365 */         UTF8String bhj_value29 = bhj_isNull29 ? null : (bhj_matched2.getUTF8String(1));
/* 366 */
/* 367 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 368 */
/* 369 */         UnsafeRow agg_fastAggBuffer = null;
/* 370 */
/* 371 */         if (true) {
/* 372 */           if (!false && !false && !bhj_isNull29 && !bhj_isNull16 && !bhj_isNull17) {
/* 373 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 374 */               scan_value2, scan_value1, bhj_value29, bhj_value16, bhj_value17);
/* 375 */           }
/* 376 */         }
/* 377 */
/* 378 */         if (agg_fastAggBuffer == null) {
/* 379 */           // generate grouping key
/* 380 */           agg_holder.reset();
/* 381 */
/* 382 */           agg_rowWriter.zeroOutNullBytes();
/* 383 */
/* 384 */           agg_rowWriter.write(0, scan_value2);
/* 385 */
/* 386 */           agg_rowWriter.write(1, scan_value1);
/* 387 */
/* 388 */           if (bhj_isNull29) {
/* 389 */             agg_rowWriter.setNullAt(2);
/* 390 */           } else {
/* 391 */             agg_rowWriter.write(2, bhj_value29);
/* 392 */           }
/* 393 */
/* 394 */           if (bhj_isNull16) {
/* 395 */             agg_rowWriter.setNullAt(3);
/* 396 */           } else {
/* 397 */             agg_rowWriter.write(3, bhj_value16);
/* 398 */           }
/* 399 */
/* 400 */           if (bhj_isNull17) {
/* 401 */             agg_rowWriter.setNullAt(4);
/* 402 */           } else {
/* 403 */             agg_rowWriter.write(4, bhj_value17);
/* 404 */           }
/* 405 */           agg_result5.setTotalSize(agg_holder.totalSize());
/* 406 */           agg_value12 = 42;
/* 407 */
/* 408 */           if (!false) {
/* 409 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value2.getBaseObject(), scan_value2.getBaseOffset(), scan_value2.numBytes(), agg_value12);
/* 410 */           }
/* 411 */
/* 412 */           if (!false) {
/* 413 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value1.getBaseObject(), scan_value1.getBaseOffset(), scan_value1.numBytes(), agg_value12);
/* 414 */           }
/* 415 */
/* 416 */           if (!bhj_isNull29) {
/* 417 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value29.getBaseObject(), bhj_value29.getBaseOffset(), bhj_value29.numBytes(), agg_value12);
/* 418 */           }
/* 419 */
/* 420 */           if (!bhj_isNull16) {
/* 421 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value16, agg_value12);
/* 422 */           }
/* 423 */
/* 424 */           if (!bhj_isNull17) {
/* 425 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value17, agg_value12);
/* 426 */           }
/* 427 */           if (true) {
/* 428 */             // try to get the buffer from hash map
/* 429 */             agg_unsafeRowAggBuffer =
/* 430 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value12);
/* 431 */           }
/* 432 */           if (agg_unsafeRowAggBuffer == null) {
/* 433 */             if (agg_sorter == null) {
/* 434 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 435 */             } else {
/* 436 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 437 */             }
/* 438 */
/* 439 */             // the hash map had be spilled, it should have enough memory now,
/* 440 */             // try  to allocate buffer again.
/* 441 */             agg_unsafeRowAggBuffer =
/* 442 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value12);
/* 443 */             if (agg_unsafeRowAggBuffer == null) {
/* 444 */               // failed to allocate the first page
/* 445 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 446 */             }
/* 447 */           }
/* 448 */         }
/* 449 */
/* 450 */         if (agg_fastAggBuffer != null) {
/* 451 */           // update fast row
/* 452 */
/* 453 */           // common sub-expressions
/* 454 */
/* 455 */           // evaluate aggregate function
/* 456 */           boolean agg_isNull27 = true;
/* 457 */           double agg_value28 = -1.0;
/* 458 */
/* 459 */           boolean agg_isNull29 = agg_fastAggBuffer.isNullAt(0);
/* 460 */           double agg_value30 = agg_isNull29 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 461 */           boolean agg_isNull28 = agg_isNull29;
/* 462 */           double agg_value29 = agg_value30;
/* 463 */           if (agg_isNull28) {
/* 464 */             boolean agg_isNull30 = false;
/* 465 */             double agg_value31 = -1.0;
/* 466 */             if (!false) {
/* 467 */               agg_value31 = (double) 0;
/* 468 */             }
/* 469 */             if (!agg_isNull30) {
/* 470 */               agg_isNull28 = false;
/* 471 */               agg_value29 = agg_value31;
/* 472 */             }
/* 473 */           }
/* 474 */
/* 475 */           boolean agg_isNull32 = bhj_isNull4;
/* 476 */           double agg_value33 = -1.0;
/* 477 */           if (!bhj_isNull4) {
/* 478 */             agg_value33 = bhj_value4;
/* 479 */           }
/* 480 */           if (!agg_isNull32) {
/* 481 */             agg_isNull27 = false; // resultCode could change nullability.
/* 482 */             agg_value28 = agg_value29 + agg_value33;
/* 483 */
/* 484 */           }
/* 485 */           boolean agg_isNull26 = agg_isNull27;
/* 486 */           double agg_value27 = agg_value28;
/* 487 */           if (agg_isNull26) {
/* 488 */             boolean agg_isNull34 = agg_fastAggBuffer.isNullAt(0);
/* 489 */             double agg_value35 = agg_isNull34 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 490 */             if (!agg_isNull34) {
/* 491 */               agg_isNull26 = false;
/* 492 */               agg_value27 = agg_value35;
/* 493 */             }
/* 494 */           }
/* 495 */           // update fast row
/* 496 */           if (!agg_isNull26) {
/* 497 */             agg_fastAggBuffer.setDouble(0, agg_value27);
/* 498 */           } else {
/* 499 */             agg_fastAggBuffer.setNullAt(0);
/* 500 */           }
/* 501 */
/* 502 */         } else {
/* 503 */           // update unsafe row
/* 504 */
/* 505 */           // common sub-expressions
/* 506 */
/* 507 */           // evaluate aggregate function
/* 508 */           boolean agg_isNull18 = true;
/* 509 */           double agg_value19 = -1.0;
/* 510 */
/* 511 */           boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 512 */           double agg_value21 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 513 */           boolean agg_isNull19 = agg_isNull20;
/* 514 */           double agg_value20 = agg_value21;
/* 515 */           if (agg_isNull19) {
/* 516 */             boolean agg_isNull21 = false;
/* 517 */             double agg_value22 = -1.0;
/* 518 */             if (!false) {
/* 519 */               agg_value22 = (double) 0;
/* 520 */             }
/* 521 */             if (!agg_isNull21) {
/* 522 */               agg_isNull19 = false;
/* 523 */               agg_value20 = agg_value22;
/* 524 */             }
/* 525 */           }
/* 526 */
/* 527 */           boolean agg_isNull23 = bhj_isNull4;
/* 528 */           double agg_value24 = -1.0;
/* 529 */           if (!bhj_isNull4) {
/* 530 */             agg_value24 = bhj_value4;
/* 531 */           }
/* 532 */           if (!agg_isNull23) {
/* 533 */             agg_isNull18 = false; // resultCode could change nullability.
/* 534 */             agg_value19 = agg_value20 + agg_value24;
/* 535 */
/* 536 */           }
/* 537 */           boolean agg_isNull17 = agg_isNull18;
/* 538 */           double agg_value18 = agg_value19;
/* 539 */           if (agg_isNull17) {
/* 540 */             boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 541 */             double agg_value26 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 542 */             if (!agg_isNull25) {
/* 543 */               agg_isNull17 = false;
/* 544 */               agg_value18 = agg_value26;
/* 545 */             }
/* 546 */           }
/* 547 */           // update unsafe row buffer
/* 548 */           if (!agg_isNull17) {
/* 549 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value18);
/* 550 */           } else {
/* 551 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 552 */           }
/* 553 */
/* 554 */         }
/* 555 */         if (shouldStop()) return;
/* 556 */       }
/* 557 */       scan_batch = null;
/* 558 */       scan_nextBatch();
/* 559 */     }
/* 560 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 561 */     scan_scanTime1 = 0;
/* 562 */
/* 563 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 564 */
/* 565 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 566 */   }
/* 567 */
/* 568 */   private void wholestagecodegen_init_2() {
/* 569 */     project_result1 = new UnsafeRow(5);
/* 570 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 64);
/* 571 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 572 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 573 */
/* 574 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 575 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 576 */
/* 577 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 578 */     bhj_result1 = new UnsafeRow(8);
/* 579 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 580 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 8);
/* 581 */     project_result2 = new UnsafeRow(6);
/* 582 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 583 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 584 */
/* 585 */   }
/* 586 */
/* 587 */   private void wholestagecodegen_init_1() {
/* 588 */     filter_result = new UnsafeRow(3);
/* 589 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 64);
/* 590 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 591 */     project_result = new UnsafeRow(3);
/* 592 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 593 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 594 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 595 */
/* 596 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 597 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 598 */
/* 599 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 600 */     bhj_result = new UnsafeRow(7);
/* 601 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 64);
/* 602 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 603 */
/* 604 */   }
/* 605 */
/* 606 */   private void wholestagecodegen_init_4() {
/* 607 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 608 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 609 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 610 */
/* 611 */   }
/* 612 */
/* 613 */   protected void processNext() throws java.io.IOException {
/* 614 */     if (!agg_initAgg) {
/* 615 */       agg_initAgg = true;
/* 616 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 617 */       agg_doAggregateWithKeys();
/* 618 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 619 */     }
/* 620 */
/* 621 */     // output the result
/* 622 */
/* 623 */     while (agg_fastHashMapIter.next()) {
/* 624 */       wholestagecodegen_numOutputRows.add(1);
/* 625 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 626 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 627 */
/* 628 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 629 */
/* 630 */       append(agg_resultRow);
/* 631 */
/* 632 */       if (shouldStop()) return;
/* 633 */     }
/* 634 */     agg_fastHashMap.close();
/* 635 */
/* 636 */     while (agg_mapIter.next()) {
/* 637 */       wholestagecodegen_numOutputRows.add(1);
/* 638 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 639 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 640 */
/* 641 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 642 */
/* 643 */       append(agg_resultRow);
/* 644 */
/* 645 */       if (shouldStop()) return;
/* 646 */     }
/* 647 */
/* 648 */     agg_mapIter.close();
/* 649 */     if (agg_sorter == null) {
/* 650 */       agg_hashMap.free();
/* 651 */     }
/* 652 */   }
/* 653 */ }
