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
/* 067 */   private UnsafeRow agg_result5;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 070 */   private int agg_value14;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 072 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 073 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 074 */
/* 075 */   public GeneratedIterator(Object[] references) {
/* 076 */     this.references = references;
/* 077 */   }
/* 078 */
/* 079 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 080 */     partitionIndex = index;
/* 081 */     this.inputs = inputs;
/* 082 */     wholestagecodegen_init_0();
/* 083 */     wholestagecodegen_init_1();
/* 084 */     wholestagecodegen_init_2();
/* 085 */     wholestagecodegen_init_3();
/* 086 */     wholestagecodegen_init_4();
/* 087 */
/* 088 */   }
/* 089 */
/* 090 */   private void wholestagecodegen_init_0() {
/* 091 */     agg_initAgg = false;
/* 092 */
/* 093 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 094 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 095 */
/* 096 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 097 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 098 */     scan_input = inputs[0];
/* 099 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 100 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 101 */     scan_scanTime1 = 0;
/* 102 */     scan_batch = null;
/* 103 */     scan_batchIdx = 0;
/* 104 */     scan_colInstance0 = null;
/* 105 */     scan_colInstance1 = null;
/* 106 */     scan_colInstance2 = null;
/* 107 */     scan_result = new UnsafeRow(3);
/* 108 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 64);
/* 109 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 110 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 111 */
/* 112 */   }
/* 113 */
/* 114 */   private void wholestagecodegen_init_3() {
/* 115 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 116 */
/* 117 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 118 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 119 */
/* 120 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 121 */     bhj_result2 = new UnsafeRow(8);
/* 122 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 96);
/* 123 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 8);
/* 124 */     project_result3 = new UnsafeRow(6);
/* 125 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 96);
/* 126 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 6);
/* 127 */     agg_result5 = new UnsafeRow(5);
/* 128 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result5, 96);
/* 129 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 130 */
/* 131 */   }
/* 132 */
/* 133 */   private void scan_nextBatch() throws java.io.IOException {
/* 134 */     long getBatchStart = System.nanoTime();
/* 135 */     if (scan_input.hasNext()) {
/* 136 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 137 */       scan_numOutputRows.add(scan_batch.numRows());
/* 138 */       scan_batchIdx = 0;
/* 139 */       scan_colInstance0 = scan_batch.column(0);
/* 140 */       scan_colInstance1 = scan_batch.column(1);
/* 141 */       scan_colInstance2 = scan_batch.column(2);
/* 142 */
/* 143 */     }
/* 144 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 145 */   }
/* 146 */
/* 147 */   public class agg_FastHashMap {
/* 148 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 149 */     private int[] buckets;
/* 150 */     private int capacity = 1 << 16;
/* 151 */     private double loadFactor = 0.5;
/* 152 */     private int numBuckets = (int) (capacity / loadFactor);
/* 153 */     private int maxSteps = 2;
/* 154 */     private int numRows = 0;
/* 155 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("i_category", org.apache.spark.sql.types.DataTypes.StringType)
/* 156 */     .add("i_brand", org.apache.spark.sql.types.DataTypes.StringType)
/* 157 */     .add("cc_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 158 */     .add("d_year", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 159 */     .add("d_moy", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 160 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 161 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 162 */     private Object emptyVBase;
/* 163 */     private long emptyVOff;
/* 164 */     private int emptyVLen;
/* 165 */     private boolean isBatchFull = false;
/* 166 */
/* 167 */     public agg_FastHashMap(
/* 168 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 169 */       InternalRow emptyAggregationBuffer) {
/* 170 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 171 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 172 */
/* 173 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 174 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 175 */
/* 176 */       emptyVBase = emptyBuffer;
/* 177 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 178 */       emptyVLen = emptyBuffer.length;
/* 179 */
/* 180 */       buckets = new int[numBuckets];
/* 181 */       java.util.Arrays.fill(buckets, -1);
/* 182 */     }
/* 183 */
/* 184 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, int agg_key4) {
/* 185 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4);
/* 186 */       int step = 0;
/* 187 */       int idx = (int) h & (numBuckets - 1);
/* 188 */       while (step < maxSteps) {
/* 189 */         // Return bucket index if it's either an empty slot or already contains the key
/* 190 */         if (buckets[idx] == -1) {
/* 191 */           if (numRows < capacity && !isBatchFull) {
/* 192 */             // creating the unsafe for new entry
/* 193 */             UnsafeRow agg_result = new UnsafeRow(5);
/* 194 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 195 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 196 */               96);
/* 197 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 198 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 199 */               agg_holder,
/* 200 */               5);
/* 201 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 202 */             agg_rowWriter.zeroOutNullBytes();
/* 203 */             agg_rowWriter.write(0, agg_key);
/* 204 */             agg_rowWriter.write(1, agg_key1);
/* 205 */             agg_rowWriter.write(2, agg_key2);
/* 206 */             agg_rowWriter.write(3, agg_key3);
/* 207 */             agg_rowWriter.write(4, agg_key4);
/* 208 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 209 */             Object kbase = agg_result.getBaseObject();
/* 210 */             long koff = agg_result.getBaseOffset();
/* 211 */             int klen = agg_result.getSizeInBytes();
/* 212 */
/* 213 */             UnsafeRow vRow
/* 214 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 215 */             if (vRow == null) {
/* 216 */               isBatchFull = true;
/* 217 */             } else {
/* 218 */               buckets[idx] = numRows++;
/* 219 */             }
/* 220 */             return vRow;
/* 221 */           } else {
/* 222 */             // No more space
/* 223 */             return null;
/* 224 */           }
/* 225 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4)) {
/* 226 */           return batch.getValueRow(buckets[idx]);
/* 227 */         }
/* 228 */         idx = (idx + 1) & (numBuckets - 1);
/* 229 */         step++;
/* 230 */       }
/* 231 */       // Didn't find it
/* 232 */       return null;
/* 233 */     }
/* 234 */
/* 235 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, int agg_key4) {
/* 236 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 237 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getInt(3) == agg_key3) && (row.getInt(4) == agg_key4);
/* 238 */     }
/* 239 */
/* 240 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, int agg_key4) {
/* 241 */       long agg_hash = 0;
/* 242 */
/* 243 */       int agg_result = 0;
/* 244 */       byte[] agg_bytes = agg_key.getBytes();
/* 245 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 246 */         int agg_hash1 = agg_bytes[i];
/* 247 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 248 */       }
/* 249 */
/* 250 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 251 */
/* 252 */       int agg_result1 = 0;
/* 253 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 254 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 255 */         int agg_hash2 = agg_bytes1[i];
/* 256 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 257 */       }
/* 258 */
/* 259 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 260 */
/* 261 */       int agg_result2 = 0;
/* 262 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 263 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 264 */         int agg_hash3 = agg_bytes2[i];
/* 265 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 266 */       }
/* 267 */
/* 268 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 269 */
/* 270 */       int agg_result3 = agg_key3;
/* 271 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 272 */
/* 273 */       int agg_result4 = agg_key4;
/* 274 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 275 */
/* 276 */       return agg_hash;
/* 277 */     }
/* 278 */
/* 279 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 280 */       return batch.rowIterator();
/* 281 */     }
/* 282 */
/* 283 */     public void close() {
/* 284 */       batch.close();
/* 285 */     }
/* 286 */
/* 287 */   }
/* 288 */
/* 289 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 290 */     agg_hashMap = agg_plan.createHashMap();
/* 291 */
/* 292 */     if (scan_batch == null) {
/* 293 */       scan_nextBatch();
/* 294 */     }
/* 295 */     while (scan_batch != null) {
/* 296 */       int numRows = scan_batch.numRows();
/* 297 */       while (scan_batchIdx < numRows) {
/* 298 */         int scan_rowIdx = scan_batchIdx++;
/* 299 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 300 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 301 */
/* 302 */         if (!(!(scan_isNull))) continue;
/* 303 */
/* 304 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 305 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 306 */
/* 307 */         if (!(!(scan_isNull1))) continue;
/* 308 */
/* 309 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 310 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 311 */
/* 312 */         if (!(!(scan_isNull2))) continue;
/* 313 */
/* 314 */         filter_numOutputRows.add(1);
/* 315 */
/* 316 */         // generate join key for stream side
/* 317 */
/* 318 */         boolean bhj_isNull = false;
/* 319 */         long bhj_value = -1L;
/* 320 */         if (!false) {
/* 321 */           bhj_value = (long) scan_value;
/* 322 */         }
/* 323 */         // find matches from HashedRelation
/* 324 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 325 */         if (bhj_matched == null) continue;
/* 326 */
/* 327 */         bhj_numOutputRows.add(1);
/* 328 */
/* 329 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 330 */         int bhj_value5 = bhj_isNull5 ? -1 : (bhj_matched.getInt(3));
/* 331 */
/* 332 */         // generate join key for stream side
/* 333 */
/* 334 */         boolean bhj_isNull13 = bhj_isNull5;
/* 335 */         long bhj_value13 = -1L;
/* 336 */         if (!bhj_isNull5) {
/* 337 */           bhj_value13 = (long) bhj_value5;
/* 338 */         }
/* 339 */         // find matches from HashedRelation
/* 340 */         UnsafeRow bhj_matched1 = bhj_isNull13 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value13);
/* 341 */         if (bhj_matched1 == null) continue;
/* 342 */
/* 343 */         bhj_numOutputRows1.add(1);
/* 344 */
/* 345 */         boolean bhj_isNull2 = bhj_matched.isNullAt(0);
/* 346 */         int bhj_value2 = bhj_isNull2 ? -1 : (bhj_matched.getInt(0));
/* 347 */
/* 348 */         // generate join key for stream side
/* 349 */
/* 350 */         boolean bhj_isNull26 = bhj_isNull2;
/* 351 */         long bhj_value26 = -1L;
/* 352 */         if (!bhj_isNull2) {
/* 353 */           bhj_value26 = (long) bhj_value2;
/* 354 */         }
/* 355 */         // find matches from HashedRelation
/* 356 */         UnsafeRow bhj_matched2 = bhj_isNull26 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value26);
/* 357 */         if (bhj_matched2 == null) continue;
/* 358 */
/* 359 */         bhj_numOutputRows2.add(1);
/* 360 */
/* 361 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 362 */         double bhj_value4 = bhj_isNull4 ? -1.0 : (bhj_matched.getDouble(2));
/* 363 */         boolean bhj_isNull16 = bhj_matched1.isNullAt(1);
/* 364 */         int bhj_value16 = bhj_isNull16 ? -1 : (bhj_matched1.getInt(1));
/* 365 */         boolean bhj_isNull17 = bhj_matched1.isNullAt(2);
/* 366 */         int bhj_value17 = bhj_isNull17 ? -1 : (bhj_matched1.getInt(2));
/* 367 */         boolean bhj_isNull29 = bhj_matched2.isNullAt(1);
/* 368 */         UTF8String bhj_value29 = bhj_isNull29 ? null : (bhj_matched2.getUTF8String(1));
/* 369 */
/* 370 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 371 */
/* 372 */         UnsafeRow agg_fastAggBuffer = null;
/* 373 */
/* 374 */         if (true) {
/* 375 */           if (!false && !false && !bhj_isNull29 && !bhj_isNull16 && !bhj_isNull17) {
/* 376 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 377 */               scan_value2, scan_value1, bhj_value29, bhj_value16, bhj_value17);
/* 378 */           }
/* 379 */         }
/* 380 */
/* 381 */         if (agg_fastAggBuffer == null) {
/* 382 */           // generate grouping key
/* 383 */           agg_holder.reset();
/* 384 */
/* 385 */           agg_rowWriter.zeroOutNullBytes();
/* 386 */
/* 387 */           agg_rowWriter.write(0, scan_value2);
/* 388 */
/* 389 */           agg_rowWriter.write(1, scan_value1);
/* 390 */
/* 391 */           if (bhj_isNull29) {
/* 392 */             agg_rowWriter.setNullAt(2);
/* 393 */           } else {
/* 394 */             agg_rowWriter.write(2, bhj_value29);
/* 395 */           }
/* 396 */
/* 397 */           if (bhj_isNull16) {
/* 398 */             agg_rowWriter.setNullAt(3);
/* 399 */           } else {
/* 400 */             agg_rowWriter.write(3, bhj_value16);
/* 401 */           }
/* 402 */
/* 403 */           if (bhj_isNull17) {
/* 404 */             agg_rowWriter.setNullAt(4);
/* 405 */           } else {
/* 406 */             agg_rowWriter.write(4, bhj_value17);
/* 407 */           }
/* 408 */           agg_result5.setTotalSize(agg_holder.totalSize());
/* 409 */           agg_value14 = 42;
/* 410 */
/* 411 */           if (!false) {
/* 412 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value2.getBaseObject(), scan_value2.getBaseOffset(), scan_value2.numBytes(), agg_value14);
/* 413 */           }
/* 414 */
/* 415 */           if (!false) {
/* 416 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value1.getBaseObject(), scan_value1.getBaseOffset(), scan_value1.numBytes(), agg_value14);
/* 417 */           }
/* 418 */
/* 419 */           if (!bhj_isNull29) {
/* 420 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value29.getBaseObject(), bhj_value29.getBaseOffset(), bhj_value29.numBytes(), agg_value14);
/* 421 */           }
/* 422 */
/* 423 */           if (!bhj_isNull16) {
/* 424 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value16, agg_value14);
/* 425 */           }
/* 426 */
/* 427 */           if (!bhj_isNull17) {
/* 428 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value17, agg_value14);
/* 429 */           }
/* 430 */           if (true) {
/* 431 */             // try to get the buffer from hash map
/* 432 */             agg_unsafeRowAggBuffer =
/* 433 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value14);
/* 434 */           }
/* 435 */           if (agg_unsafeRowAggBuffer == null) {
/* 436 */             if (agg_sorter == null) {
/* 437 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 438 */             } else {
/* 439 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 440 */             }
/* 441 */
/* 442 */             // the hash map had be spilled, it should have enough memory now,
/* 443 */             // try  to allocate buffer again.
/* 444 */             agg_unsafeRowAggBuffer =
/* 445 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value14);
/* 446 */             if (agg_unsafeRowAggBuffer == null) {
/* 447 */               // failed to allocate the first page
/* 448 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 449 */             }
/* 450 */           }
/* 451 */         }
/* 452 */
/* 453 */         if (agg_fastAggBuffer != null) {
/* 454 */           // update fast row
/* 455 */
/* 456 */           // common sub-expressions
/* 457 */           boolean agg_isNull32 = bhj_isNull4;
/* 458 */           double agg_value34 = -1.0;
/* 459 */           if (!bhj_isNull4) {
/* 460 */             agg_value34 = bhj_value4;
/* 461 */           }
/* 462 */           boolean agg_isNull34 = false;
/* 463 */           double agg_value36 = -1.0;
/* 464 */           if (!false) {
/* 465 */             agg_value36 = (double) 0;
/* 466 */           }
/* 467 */           // evaluate aggregate function
/* 468 */           boolean agg_isNull37 = true;
/* 469 */           double agg_value39 = -1.0;
/* 470 */
/* 471 */           boolean agg_isNull39 = agg_fastAggBuffer.isNullAt(0);
/* 472 */           double agg_value41 = agg_isNull39 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 473 */           boolean agg_isNull38 = agg_isNull39;
/* 474 */           double agg_value40 = agg_value41;
/* 475 */           if (agg_isNull38) {
/* 476 */             if (!agg_isNull34) {
/* 477 */               agg_isNull38 = false;
/* 478 */               agg_value40 = agg_value36;
/* 479 */             }
/* 480 */           }
/* 481 */
/* 482 */           if (!agg_isNull32) {
/* 483 */             agg_isNull37 = false; // resultCode could change nullability.
/* 484 */             agg_value39 = agg_value40 + agg_value34;
/* 485 */
/* 486 */           }
/* 487 */           boolean agg_isNull36 = agg_isNull37;
/* 488 */           double agg_value38 = agg_value39;
/* 489 */           if (agg_isNull36) {
/* 490 */             boolean agg_isNull40 = agg_fastAggBuffer.isNullAt(0);
/* 491 */             double agg_value42 = agg_isNull40 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 492 */             if (!agg_isNull40) {
/* 493 */               agg_isNull36 = false;
/* 494 */               agg_value38 = agg_value42;
/* 495 */             }
/* 496 */           }
/* 497 */           boolean agg_isNull42 = true;
/* 498 */           double agg_value44 = -1.0;
/* 499 */
/* 500 */           boolean agg_isNull44 = agg_fastAggBuffer.isNullAt(1);
/* 501 */           double agg_value46 = agg_isNull44 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 502 */           boolean agg_isNull43 = agg_isNull44;
/* 503 */           double agg_value45 = agg_value46;
/* 504 */           if (agg_isNull43) {
/* 505 */             if (!agg_isNull34) {
/* 506 */               agg_isNull43 = false;
/* 507 */               agg_value45 = agg_value36;
/* 508 */             }
/* 509 */           }
/* 510 */
/* 511 */           if (!agg_isNull32) {
/* 512 */             agg_isNull42 = false; // resultCode could change nullability.
/* 513 */             agg_value44 = agg_value45 + agg_value34;
/* 514 */
/* 515 */           }
/* 516 */           boolean agg_isNull41 = agg_isNull42;
/* 517 */           double agg_value43 = agg_value44;
/* 518 */           if (agg_isNull41) {
/* 519 */             boolean agg_isNull45 = agg_fastAggBuffer.isNullAt(1);
/* 520 */             double agg_value47 = agg_isNull45 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 521 */             if (!agg_isNull45) {
/* 522 */               agg_isNull41 = false;
/* 523 */               agg_value43 = agg_value47;
/* 524 */             }
/* 525 */           }
/* 526 */           // update fast row
/* 527 */           if (!agg_isNull36) {
/* 528 */             agg_fastAggBuffer.setDouble(0, agg_value38);
/* 529 */           } else {
/* 530 */             agg_fastAggBuffer.setNullAt(0);
/* 531 */           }
/* 532 */
/* 533 */           if (!agg_isNull41) {
/* 534 */             agg_fastAggBuffer.setDouble(1, agg_value43);
/* 535 */           } else {
/* 536 */             agg_fastAggBuffer.setNullAt(1);
/* 537 */           }
/* 538 */
/* 539 */         } else {
/* 540 */           // update unsafe row
/* 541 */
/* 542 */           // common sub-expressions
/* 543 */           boolean agg_isNull18 = bhj_isNull4;
/* 544 */           double agg_value20 = -1.0;
/* 545 */           if (!bhj_isNull4) {
/* 546 */             agg_value20 = bhj_value4;
/* 547 */           }
/* 548 */           boolean agg_isNull20 = false;
/* 549 */           double agg_value22 = -1.0;
/* 550 */           if (!false) {
/* 551 */             agg_value22 = (double) 0;
/* 552 */           }
/* 553 */           // evaluate aggregate function
/* 554 */           boolean agg_isNull23 = true;
/* 555 */           double agg_value25 = -1.0;
/* 556 */
/* 557 */           boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 558 */           double agg_value27 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 559 */           boolean agg_isNull24 = agg_isNull25;
/* 560 */           double agg_value26 = agg_value27;
/* 561 */           if (agg_isNull24) {
/* 562 */             if (!agg_isNull20) {
/* 563 */               agg_isNull24 = false;
/* 564 */               agg_value26 = agg_value22;
/* 565 */             }
/* 566 */           }
/* 567 */
/* 568 */           if (!agg_isNull18) {
/* 569 */             agg_isNull23 = false; // resultCode could change nullability.
/* 570 */             agg_value25 = agg_value26 + agg_value20;
/* 571 */
/* 572 */           }
/* 573 */           boolean agg_isNull22 = agg_isNull23;
/* 574 */           double agg_value24 = agg_value25;
/* 575 */           if (agg_isNull22) {
/* 576 */             boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 577 */             double agg_value28 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 578 */             if (!agg_isNull26) {
/* 579 */               agg_isNull22 = false;
/* 580 */               agg_value24 = agg_value28;
/* 581 */             }
/* 582 */           }
/* 583 */           boolean agg_isNull28 = true;
/* 584 */           double agg_value30 = -1.0;
/* 585 */
/* 586 */           boolean agg_isNull30 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 587 */           double agg_value32 = agg_isNull30 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 588 */           boolean agg_isNull29 = agg_isNull30;
/* 589 */           double agg_value31 = agg_value32;
/* 590 */           if (agg_isNull29) {
/* 591 */             if (!agg_isNull20) {
/* 592 */               agg_isNull29 = false;
/* 593 */               agg_value31 = agg_value22;
/* 594 */             }
/* 595 */           }
/* 596 */
/* 597 */           if (!agg_isNull18) {
/* 598 */             agg_isNull28 = false; // resultCode could change nullability.
/* 599 */             agg_value30 = agg_value31 + agg_value20;
/* 600 */
/* 601 */           }
/* 602 */           boolean agg_isNull27 = agg_isNull28;
/* 603 */           double agg_value29 = agg_value30;
/* 604 */           if (agg_isNull27) {
/* 605 */             boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 606 */             double agg_value33 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 607 */             if (!agg_isNull31) {
/* 608 */               agg_isNull27 = false;
/* 609 */               agg_value29 = agg_value33;
/* 610 */             }
/* 611 */           }
/* 612 */           // update unsafe row buffer
/* 613 */           if (!agg_isNull22) {
/* 614 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value24);
/* 615 */           } else {
/* 616 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 617 */           }
/* 618 */
/* 619 */           if (!agg_isNull27) {
/* 620 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value29);
/* 621 */           } else {
/* 622 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 623 */           }
/* 624 */
/* 625 */         }
/* 626 */         if (shouldStop()) return;
/* 627 */       }
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
/* 639 */   private void wholestagecodegen_init_2() {
/* 640 */     project_result1 = new UnsafeRow(5);
/* 641 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 64);
/* 642 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 643 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 644 */
/* 645 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 646 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 647 */
/* 648 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 649 */     bhj_result1 = new UnsafeRow(8);
/* 650 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 651 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 8);
/* 652 */     project_result2 = new UnsafeRow(6);
/* 653 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 654 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 655 */
/* 656 */   }
/* 657 */
/* 658 */   private void wholestagecodegen_init_1() {
/* 659 */     filter_result = new UnsafeRow(3);
/* 660 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 64);
/* 661 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 662 */     project_result = new UnsafeRow(3);
/* 663 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 664 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 665 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 666 */
/* 667 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 668 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 669 */
/* 670 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 671 */     bhj_result = new UnsafeRow(7);
/* 672 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 64);
/* 673 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 674 */
/* 675 */   }
/* 676 */
/* 677 */   private void wholestagecodegen_init_4() {
/* 678 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 679 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 680 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 681 */
/* 682 */   }
/* 683 */
/* 684 */   protected void processNext() throws java.io.IOException {
/* 685 */     if (!agg_initAgg) {
/* 686 */       agg_initAgg = true;
/* 687 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 688 */       agg_doAggregateWithKeys();
/* 689 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 690 */     }
/* 691 */
/* 692 */     // output the result
/* 693 */
/* 694 */     while (agg_fastHashMapIter.next()) {
/* 695 */       wholestagecodegen_numOutputRows.add(1);
/* 696 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 697 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 698 */
/* 699 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 700 */
/* 701 */       append(agg_resultRow);
/* 702 */
/* 703 */       if (shouldStop()) return;
/* 704 */     }
/* 705 */     agg_fastHashMap.close();
/* 706 */
/* 707 */     while (agg_mapIter.next()) {
/* 708 */       wholestagecodegen_numOutputRows.add(1);
/* 709 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 710 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 711 */
/* 712 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 713 */
/* 714 */       append(agg_resultRow);
/* 715 */
/* 716 */       if (shouldStop()) return;
/* 717 */     }
/* 718 */
/* 719 */     agg_mapIter.close();
/* 720 */     if (agg_sorter == null) {
/* 721 */       agg_hashMap.free();
/* 722 */     }
/* 723 */   }
/* 724 */ }
