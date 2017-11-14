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
/* 029 */   private UnsafeRow scan_result;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 033 */   private UnsafeRow filter_result;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 036 */   private UnsafeRow project_result;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 039 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 040 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 042 */   private UnsafeRow bhj_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 045 */   private UnsafeRow project_result1;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 048 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 049 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 050 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 051 */   private UnsafeRow bhj_result1;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 054 */   private UnsafeRow project_result2;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 057 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 058 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 059 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 060 */   private UnsafeRow bhj_result2;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 063 */   private UnsafeRow project_result3;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 066 */   private UnsafeRow agg_result6;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 069 */   private int agg_value14;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 071 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 072 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 073 */
/* 074 */   public GeneratedIterator(Object[] references) {
/* 075 */     this.references = references;
/* 076 */   }
/* 077 */
/* 078 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 079 */     partitionIndex = index;
/* 080 */     this.inputs = inputs;
/* 081 */     wholestagecodegen_init_0();
/* 082 */     wholestagecodegen_init_1();
/* 083 */     wholestagecodegen_init_2();
/* 084 */     wholestagecodegen_init_3();
/* 085 */     wholestagecodegen_init_4();
/* 086 */
/* 087 */   }
/* 088 */
/* 089 */   private void wholestagecodegen_init_0() {
/* 090 */     agg_initAgg = false;
/* 091 */
/* 092 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 093 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 094 */
/* 095 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 096 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 097 */     scan_input = inputs[0];
/* 098 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 099 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 100 */     scan_scanTime1 = 0;
/* 101 */     scan_batch = null;
/* 102 */     scan_batchIdx = 0;
/* 103 */     scan_colInstance0 = null;
/* 104 */     scan_colInstance1 = null;
/* 105 */     scan_colInstance2 = null;
/* 106 */     scan_colInstance3 = null;
/* 107 */     scan_result = new UnsafeRow(4);
/* 108 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 109 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 110 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 111 */
/* 112 */   }
/* 113 */
/* 114 */   private void wholestagecodegen_init_3() {
/* 115 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[17];
/* 116 */
/* 117 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 118 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 119 */
/* 120 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 121 */     bhj_result2 = new UnsafeRow(9);
/* 122 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 128);
/* 123 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 9);
/* 124 */     project_result3 = new UnsafeRow(7);
/* 125 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 128);
/* 126 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 7);
/* 127 */     agg_result6 = new UnsafeRow(6);
/* 128 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result6, 128);
/* 129 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 6);
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
/* 142 */       scan_colInstance3 = scan_batch.column(3);
/* 143 */
/* 144 */     }
/* 145 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 146 */   }
/* 147 */
/* 148 */   public class agg_FastHashMap {
/* 149 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 150 */     private int[] buckets;
/* 151 */     private int capacity = 1 << 16;
/* 152 */     private double loadFactor = 0.5;
/* 153 */     private int numBuckets = (int) (capacity / loadFactor);
/* 154 */     private int maxSteps = 2;
/* 155 */     private int numRows = 0;
/* 156 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 157 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 158 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 159 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.StringType)
/* 160 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 161 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 162 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 163 */     private Object emptyVBase;
/* 164 */     private long emptyVOff;
/* 165 */     private int emptyVLen;
/* 166 */     private boolean isBatchFull = false;
/* 167 */
/* 168 */     public agg_FastHashMap(
/* 169 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 170 */       InternalRow emptyAggregationBuffer) {
/* 171 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 172 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 173 */
/* 174 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 175 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 176 */
/* 177 */       emptyVBase = emptyBuffer;
/* 178 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 179 */       emptyVLen = emptyBuffer.length;
/* 180 */
/* 181 */       buckets = new int[numBuckets];
/* 182 */       java.util.Arrays.fill(buckets, -1);
/* 183 */     }
/* 184 */
/* 185 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, int agg_key4, int agg_key5) {
/* 186 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5);
/* 187 */       int step = 0;
/* 188 */       int idx = (int) h & (numBuckets - 1);
/* 189 */       while (step < maxSteps) {
/* 190 */         // Return bucket index if it's either an empty slot or already contains the key
/* 191 */         if (buckets[idx] == -1) {
/* 192 */           if (numRows < capacity && !isBatchFull) {
/* 193 */             // creating the unsafe for new entry
/* 194 */             UnsafeRow agg_result = new UnsafeRow(6);
/* 195 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 196 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 197 */               128);
/* 198 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 199 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 200 */               agg_holder,
/* 201 */               6);
/* 202 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 203 */             agg_rowWriter.zeroOutNullBytes();
/* 204 */             agg_rowWriter.write(0, agg_key);
/* 205 */             agg_rowWriter.write(1, agg_key1);
/* 206 */             agg_rowWriter.write(2, agg_key2);
/* 207 */             agg_rowWriter.write(3, agg_key3);
/* 208 */             agg_rowWriter.write(4, agg_key4);
/* 209 */             agg_rowWriter.write(5, agg_key5);
/* 210 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 211 */             Object kbase = agg_result.getBaseObject();
/* 212 */             long koff = agg_result.getBaseOffset();
/* 213 */             int klen = agg_result.getSizeInBytes();
/* 214 */
/* 215 */             UnsafeRow vRow
/* 216 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 217 */             if (vRow == null) {
/* 218 */               isBatchFull = true;
/* 219 */             } else {
/* 220 */               buckets[idx] = numRows++;
/* 221 */             }
/* 222 */             return vRow;
/* 223 */           } else {
/* 224 */             // No more space
/* 225 */             return null;
/* 226 */           }
/* 227 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5)) {
/* 228 */           return batch.getValueRow(buckets[idx]);
/* 229 */         }
/* 230 */         idx = (idx + 1) & (numBuckets - 1);
/* 231 */         step++;
/* 232 */       }
/* 233 */       // Didn't find it
/* 234 */       return null;
/* 235 */     }
/* 236 */
/* 237 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, int agg_key4, int agg_key5) {
/* 238 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 239 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getInt(4) == agg_key4) && (row.getInt(5) == agg_key5);
/* 240 */     }
/* 241 */
/* 242 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, int agg_key4, int agg_key5) {
/* 243 */       long agg_hash = 0;
/* 244 */
/* 245 */       int agg_result = 0;
/* 246 */       byte[] agg_bytes = agg_key.getBytes();
/* 247 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 248 */         int agg_hash1 = agg_bytes[i];
/* 249 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 250 */       }
/* 251 */
/* 252 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 253 */
/* 254 */       int agg_result1 = 0;
/* 255 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 256 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 257 */         int agg_hash2 = agg_bytes1[i];
/* 258 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 259 */       }
/* 260 */
/* 261 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 262 */
/* 263 */       int agg_result2 = 0;
/* 264 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 265 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 266 */         int agg_hash3 = agg_bytes2[i];
/* 267 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 268 */       }
/* 269 */
/* 270 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 271 */
/* 272 */       int agg_result3 = 0;
/* 273 */       byte[] agg_bytes3 = agg_key3.getBytes();
/* 274 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 275 */         int agg_hash4 = agg_bytes3[i];
/* 276 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash4 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 277 */       }
/* 278 */
/* 279 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 280 */
/* 281 */       int agg_result4 = agg_key4;
/* 282 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 283 */
/* 284 */       int agg_result5 = agg_key5;
/* 285 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 286 */
/* 287 */       return agg_hash;
/* 288 */     }
/* 289 */
/* 290 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 291 */       return batch.rowIterator();
/* 292 */     }
/* 293 */
/* 294 */     public void close() {
/* 295 */       batch.close();
/* 296 */     }
/* 297 */
/* 298 */   }
/* 299 */
/* 300 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 301 */     agg_hashMap = agg_plan.createHashMap();
/* 302 */
/* 303 */     if (scan_batch == null) {
/* 304 */       scan_nextBatch();
/* 305 */     }
/* 306 */     while (scan_batch != null) {
/* 307 */       int scan_numRows = scan_batch.numRows();
/* 308 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 309 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 310 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 311 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 312 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 313 */
/* 314 */         if (!(!(scan_isNull))) continue;
/* 315 */
/* 316 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 317 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 318 */
/* 319 */         if (!(!(scan_isNull1))) continue;
/* 320 */
/* 321 */         filter_numOutputRows.add(1);
/* 322 */
/* 323 */         // generate join key for stream side
/* 324 */
/* 325 */         boolean bhj_isNull = false;
/* 326 */         long bhj_value = -1L;
/* 327 */         if (!false) {
/* 328 */           bhj_value = (long) scan_value;
/* 329 */         }
/* 330 */         // find matches from HashedRelation
/* 331 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 332 */         if (bhj_matched == null) continue;
/* 333 */
/* 334 */         bhj_numOutputRows.add(1);
/* 335 */
/* 336 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 337 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 338 */
/* 339 */         // generate join key for stream side
/* 340 */
/* 341 */         boolean bhj_isNull12 = scan_isNull3;
/* 342 */         long bhj_value12 = -1L;
/* 343 */         if (!scan_isNull3) {
/* 344 */           bhj_value12 = (long) scan_value3;
/* 345 */         }
/* 346 */         // find matches from HashedRelation
/* 347 */         UnsafeRow bhj_matched1 = bhj_isNull12 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value12);
/* 348 */         if (bhj_matched1 == null) continue;
/* 349 */
/* 350 */         bhj_numOutputRows1.add(1);
/* 351 */
/* 352 */         // generate join key for stream side
/* 353 */
/* 354 */         boolean bhj_isNull25 = false;
/* 355 */         long bhj_value25 = -1L;
/* 356 */         if (!false) {
/* 357 */           bhj_value25 = (long) scan_value1;
/* 358 */         }
/* 359 */         // find matches from HashedRelation
/* 360 */         UnsafeRow bhj_matched2 = bhj_isNull25 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value25);
/* 361 */         if (bhj_matched2 == null) continue;
/* 362 */
/* 363 */         bhj_numOutputRows2.add(1);
/* 364 */
/* 365 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 366 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 367 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 368 */         UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 369 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 370 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 371 */         boolean bhj_isNull15 = bhj_matched1.isNullAt(1);
/* 372 */         int bhj_value15 = bhj_isNull15 ? -1 : (bhj_matched1.getInt(1));
/* 373 */         boolean bhj_isNull16 = bhj_matched1.isNullAt(2);
/* 374 */         int bhj_value16 = bhj_isNull16 ? -1 : (bhj_matched1.getInt(2));
/* 375 */         boolean bhj_isNull28 = bhj_matched2.isNullAt(1);
/* 376 */         UTF8String bhj_value28 = bhj_isNull28 ? null : (bhj_matched2.getUTF8String(1));
/* 377 */         boolean bhj_isNull29 = bhj_matched2.isNullAt(2);
/* 378 */         UTF8String bhj_value29 = bhj_isNull29 ? null : (bhj_matched2.getUTF8String(2));
/* 379 */
/* 380 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 381 */
/* 382 */         UnsafeRow agg_fastAggBuffer = null;
/* 383 */
/* 384 */         if (true) {
/* 385 */           if (!bhj_isNull4 && !bhj_isNull3 && !bhj_isNull28 && !bhj_isNull29 && !bhj_isNull15 && !bhj_isNull16) {
/* 386 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 387 */               bhj_value4, bhj_value3, bhj_value28, bhj_value29, bhj_value15, bhj_value16);
/* 388 */           }
/* 389 */         }
/* 390 */
/* 391 */         if (agg_fastAggBuffer == null) {
/* 392 */           // generate grouping key
/* 393 */           agg_holder.reset();
/* 394 */
/* 395 */           agg_rowWriter.zeroOutNullBytes();
/* 396 */
/* 397 */           if (bhj_isNull4) {
/* 398 */             agg_rowWriter.setNullAt(0);
/* 399 */           } else {
/* 400 */             agg_rowWriter.write(0, bhj_value4);
/* 401 */           }
/* 402 */
/* 403 */           if (bhj_isNull3) {
/* 404 */             agg_rowWriter.setNullAt(1);
/* 405 */           } else {
/* 406 */             agg_rowWriter.write(1, bhj_value3);
/* 407 */           }
/* 408 */
/* 409 */           if (bhj_isNull28) {
/* 410 */             agg_rowWriter.setNullAt(2);
/* 411 */           } else {
/* 412 */             agg_rowWriter.write(2, bhj_value28);
/* 413 */           }
/* 414 */
/* 415 */           if (bhj_isNull29) {
/* 416 */             agg_rowWriter.setNullAt(3);
/* 417 */           } else {
/* 418 */             agg_rowWriter.write(3, bhj_value29);
/* 419 */           }
/* 420 */
/* 421 */           if (bhj_isNull15) {
/* 422 */             agg_rowWriter.setNullAt(4);
/* 423 */           } else {
/* 424 */             agg_rowWriter.write(4, bhj_value15);
/* 425 */           }
/* 426 */
/* 427 */           if (bhj_isNull16) {
/* 428 */             agg_rowWriter.setNullAt(5);
/* 429 */           } else {
/* 430 */             agg_rowWriter.write(5, bhj_value16);
/* 431 */           }
/* 432 */           agg_result6.setTotalSize(agg_holder.totalSize());
/* 433 */           agg_value14 = 42;
/* 434 */
/* 435 */           if (!bhj_isNull4) {
/* 436 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value4.getBaseObject(), bhj_value4.getBaseOffset(), bhj_value4.numBytes(), agg_value14);
/* 437 */           }
/* 438 */
/* 439 */           if (!bhj_isNull3) {
/* 440 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value3.getBaseObject(), bhj_value3.getBaseOffset(), bhj_value3.numBytes(), agg_value14);
/* 441 */           }
/* 442 */
/* 443 */           if (!bhj_isNull28) {
/* 444 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value28.getBaseObject(), bhj_value28.getBaseOffset(), bhj_value28.numBytes(), agg_value14);
/* 445 */           }
/* 446 */
/* 447 */           if (!bhj_isNull29) {
/* 448 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value29.getBaseObject(), bhj_value29.getBaseOffset(), bhj_value29.numBytes(), agg_value14);
/* 449 */           }
/* 450 */
/* 451 */           if (!bhj_isNull15) {
/* 452 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value15, agg_value14);
/* 453 */           }
/* 454 */
/* 455 */           if (!bhj_isNull16) {
/* 456 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value16, agg_value14);
/* 457 */           }
/* 458 */           if (true) {
/* 459 */             // try to get the buffer from hash map
/* 460 */             agg_unsafeRowAggBuffer =
/* 461 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result6, agg_value14);
/* 462 */           }
/* 463 */           if (agg_unsafeRowAggBuffer == null) {
/* 464 */             if (agg_sorter == null) {
/* 465 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 466 */             } else {
/* 467 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 468 */             }
/* 469 */
/* 470 */             // the hash map had be spilled, it should have enough memory now,
/* 471 */             // try  to allocate buffer again.
/* 472 */             agg_unsafeRowAggBuffer =
/* 473 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result6, agg_value14);
/* 474 */             if (agg_unsafeRowAggBuffer == null) {
/* 475 */               // failed to allocate the first page
/* 476 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 477 */             }
/* 478 */           }
/* 479 */         }
/* 480 */
/* 481 */         if (agg_fastAggBuffer != null) {
/* 482 */           // update fast row
/* 483 */
/* 484 */           // common sub-expressions
/* 485 */
/* 486 */           // evaluate aggregate function
/* 487 */           boolean agg_isNull29 = true;
/* 488 */           double agg_value30 = -1.0;
/* 489 */
/* 490 */           boolean agg_isNull31 = agg_fastAggBuffer.isNullAt(0);
/* 491 */           double agg_value32 = agg_isNull31 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 492 */           boolean agg_isNull30 = agg_isNull31;
/* 493 */           double agg_value31 = agg_value32;
/* 494 */           if (agg_isNull30) {
/* 495 */             boolean agg_isNull32 = false;
/* 496 */             double agg_value33 = -1.0;
/* 497 */             if (!false) {
/* 498 */               agg_value33 = (double) 0;
/* 499 */             }
/* 500 */             if (!agg_isNull32) {
/* 501 */               agg_isNull30 = false;
/* 502 */               agg_value31 = agg_value33;
/* 503 */             }
/* 504 */           }
/* 505 */
/* 506 */           if (!scan_isNull2) {
/* 507 */             agg_isNull29 = false; // resultCode could change nullability.
/* 508 */             agg_value30 = agg_value31 + scan_value2;
/* 509 */
/* 510 */           }
/* 511 */           boolean agg_isNull28 = agg_isNull29;
/* 512 */           double agg_value29 = agg_value30;
/* 513 */           if (agg_isNull28) {
/* 514 */             boolean agg_isNull35 = agg_fastAggBuffer.isNullAt(0);
/* 515 */             double agg_value36 = agg_isNull35 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 516 */             if (!agg_isNull35) {
/* 517 */               agg_isNull28 = false;
/* 518 */               agg_value29 = agg_value36;
/* 519 */             }
/* 520 */           }
/* 521 */           // update fast row
/* 522 */           if (!agg_isNull28) {
/* 523 */             agg_fastAggBuffer.setDouble(0, agg_value29);
/* 524 */           } else {
/* 525 */             agg_fastAggBuffer.setNullAt(0);
/* 526 */           }
/* 527 */
/* 528 */         } else {
/* 529 */           // update unsafe row
/* 530 */
/* 531 */           // common sub-expressions
/* 532 */
/* 533 */           // evaluate aggregate function
/* 534 */           boolean agg_isNull21 = true;
/* 535 */           double agg_value22 = -1.0;
/* 536 */
/* 537 */           boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 538 */           double agg_value24 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 539 */           boolean agg_isNull22 = agg_isNull23;
/* 540 */           double agg_value23 = agg_value24;
/* 541 */           if (agg_isNull22) {
/* 542 */             boolean agg_isNull24 = false;
/* 543 */             double agg_value25 = -1.0;
/* 544 */             if (!false) {
/* 545 */               agg_value25 = (double) 0;
/* 546 */             }
/* 547 */             if (!agg_isNull24) {
/* 548 */               agg_isNull22 = false;
/* 549 */               agg_value23 = agg_value25;
/* 550 */             }
/* 551 */           }
/* 552 */
/* 553 */           if (!scan_isNull2) {
/* 554 */             agg_isNull21 = false; // resultCode could change nullability.
/* 555 */             agg_value22 = agg_value23 + scan_value2;
/* 556 */
/* 557 */           }
/* 558 */           boolean agg_isNull20 = agg_isNull21;
/* 559 */           double agg_value21 = agg_value22;
/* 560 */           if (agg_isNull20) {
/* 561 */             boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 562 */             double agg_value28 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 563 */             if (!agg_isNull27) {
/* 564 */               agg_isNull20 = false;
/* 565 */               agg_value21 = agg_value28;
/* 566 */             }
/* 567 */           }
/* 568 */           // update unsafe row buffer
/* 569 */           if (!agg_isNull20) {
/* 570 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value21);
/* 571 */           } else {
/* 572 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 573 */           }
/* 574 */
/* 575 */         }
/* 576 */         // shouldStop check is eliminated
/* 577 */       }
/* 578 */       scan_batchIdx = scan_numRows;
/* 579 */       scan_batch = null;
/* 580 */       scan_nextBatch();
/* 581 */     }
/* 582 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 583 */     scan_scanTime1 = 0;
/* 584 */
/* 585 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 586 */
/* 587 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 588 */   }
/* 589 */
/* 590 */   private void wholestagecodegen_init_2() {
/* 591 */     project_result1 = new UnsafeRow(5);
/* 592 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 64);
/* 593 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 594 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[15];
/* 595 */
/* 596 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 597 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 598 */
/* 599 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 600 */     bhj_result1 = new UnsafeRow(8);
/* 601 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 602 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 8);
/* 603 */     project_result2 = new UnsafeRow(6);
/* 604 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 605 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 606 */
/* 607 */   }
/* 608 */
/* 609 */   private void wholestagecodegen_init_1() {
/* 610 */     filter_result = new UnsafeRow(4);
/* 611 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 612 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 613 */     project_result = new UnsafeRow(4);
/* 614 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 615 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 616 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 617 */
/* 618 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 619 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 620 */
/* 621 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 622 */     bhj_result = new UnsafeRow(7);
/* 623 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 64);
/* 624 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 625 */
/* 626 */   }
/* 627 */
/* 628 */   private void wholestagecodegen_init_4() {
/* 629 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 630 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[19];
/* 631 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[20];
/* 632 */
/* 633 */   }
/* 634 */
/* 635 */   protected void processNext() throws java.io.IOException {
/* 636 */     if (!agg_initAgg) {
/* 637 */       agg_initAgg = true;
/* 638 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 639 */       agg_doAggregateWithKeys();
/* 640 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 641 */     }
/* 642 */
/* 643 */     // output the result
/* 644 */
/* 645 */     while (agg_fastHashMapIter.next()) {
/* 646 */       wholestagecodegen_numOutputRows.add(1);
/* 647 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 648 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 649 */
/* 650 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 651 */
/* 652 */       append(agg_resultRow);
/* 653 */
/* 654 */       if (shouldStop()) return;
/* 655 */     }
/* 656 */     agg_fastHashMap.close();
/* 657 */
/* 658 */     while (agg_mapIter.next()) {
/* 659 */       wholestagecodegen_numOutputRows.add(1);
/* 660 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 661 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 662 */
/* 663 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 664 */
/* 665 */       append(agg_resultRow);
/* 666 */
/* 667 */       if (shouldStop()) return;
/* 668 */     }
/* 669 */
/* 670 */     agg_mapIter.close();
/* 671 */     if (agg_sorter == null) {
/* 672 */       agg_hashMap.free();
/* 673 */     }
/* 674 */   }
/* 675 */ }
