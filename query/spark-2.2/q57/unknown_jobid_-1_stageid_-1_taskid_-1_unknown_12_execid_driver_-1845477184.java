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
/* 066 */   private UnsafeRow agg_result5;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 069 */   private int agg_value12;
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
/* 098 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 099 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
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
/* 110 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 111 */
/* 112 */   }
/* 113 */
/* 114 */   private void wholestagecodegen_init_3() {
/* 115 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[16];
/* 116 */
/* 117 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 118 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 119 */
/* 120 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
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
/* 159 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 160 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 161 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType);
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
/* 296 */       int scan_numRows = scan_batch.numRows();
/* 297 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 298 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 299 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 300 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 301 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 302 */
/* 303 */         if (!(!(scan_isNull1))) continue;
/* 304 */
/* 305 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 306 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 307 */
/* 308 */         if (!(!(scan_isNull))) continue;
/* 309 */
/* 310 */         filter_numOutputRows.add(1);
/* 311 */
/* 312 */         // generate join key for stream side
/* 313 */
/* 314 */         boolean bhj_isNull = false;
/* 315 */         long bhj_value = -1L;
/* 316 */         if (!false) {
/* 317 */           bhj_value = (long) scan_value1;
/* 318 */         }
/* 319 */         // find matches from HashedRelation
/* 320 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 321 */         if (bhj_matched == null) continue;
/* 322 */
/* 323 */         bhj_numOutputRows.add(1);
/* 324 */
/* 325 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 326 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 327 */
/* 328 */         // generate join key for stream side
/* 329 */
/* 330 */         boolean bhj_isNull12 = scan_isNull3;
/* 331 */         long bhj_value12 = -1L;
/* 332 */         if (!scan_isNull3) {
/* 333 */           bhj_value12 = (long) scan_value3;
/* 334 */         }
/* 335 */         // find matches from HashedRelation
/* 336 */         UnsafeRow bhj_matched1 = bhj_isNull12 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value12);
/* 337 */         if (bhj_matched1 == null) continue;
/* 338 */
/* 339 */         bhj_numOutputRows1.add(1);
/* 340 */
/* 341 */         // generate join key for stream side
/* 342 */
/* 343 */         boolean bhj_isNull25 = false;
/* 344 */         long bhj_value25 = -1L;
/* 345 */         if (!false) {
/* 346 */           bhj_value25 = (long) scan_value;
/* 347 */         }
/* 348 */         // find matches from HashedRelation
/* 349 */         UnsafeRow bhj_matched2 = bhj_isNull25 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value25);
/* 350 */         if (bhj_matched2 == null) continue;
/* 351 */
/* 352 */         bhj_numOutputRows2.add(1);
/* 353 */
/* 354 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 355 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 356 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 357 */         UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 358 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 359 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 360 */         boolean bhj_isNull15 = bhj_matched1.isNullAt(1);
/* 361 */         int bhj_value15 = bhj_isNull15 ? -1 : (bhj_matched1.getInt(1));
/* 362 */         boolean bhj_isNull16 = bhj_matched1.isNullAt(2);
/* 363 */         int bhj_value16 = bhj_isNull16 ? -1 : (bhj_matched1.getInt(2));
/* 364 */         boolean bhj_isNull28 = bhj_matched2.isNullAt(1);
/* 365 */         UTF8String bhj_value28 = bhj_isNull28 ? null : (bhj_matched2.getUTF8String(1));
/* 366 */
/* 367 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 368 */
/* 369 */         UnsafeRow agg_fastAggBuffer = null;
/* 370 */
/* 371 */         if (true) {
/* 372 */           if (!bhj_isNull4 && !bhj_isNull3 && !bhj_isNull28 && !bhj_isNull15 && !bhj_isNull16) {
/* 373 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 374 */               bhj_value4, bhj_value3, bhj_value28, bhj_value15, bhj_value16);
/* 375 */           }
/* 376 */         }
/* 377 */
/* 378 */         if (agg_fastAggBuffer == null) {
/* 379 */           // generate grouping key
/* 380 */           agg_holder.reset();
/* 381 */
/* 382 */           agg_rowWriter.zeroOutNullBytes();
/* 383 */
/* 384 */           if (bhj_isNull4) {
/* 385 */             agg_rowWriter.setNullAt(0);
/* 386 */           } else {
/* 387 */             agg_rowWriter.write(0, bhj_value4);
/* 388 */           }
/* 389 */
/* 390 */           if (bhj_isNull3) {
/* 391 */             agg_rowWriter.setNullAt(1);
/* 392 */           } else {
/* 393 */             agg_rowWriter.write(1, bhj_value3);
/* 394 */           }
/* 395 */
/* 396 */           if (bhj_isNull28) {
/* 397 */             agg_rowWriter.setNullAt(2);
/* 398 */           } else {
/* 399 */             agg_rowWriter.write(2, bhj_value28);
/* 400 */           }
/* 401 */
/* 402 */           if (bhj_isNull15) {
/* 403 */             agg_rowWriter.setNullAt(3);
/* 404 */           } else {
/* 405 */             agg_rowWriter.write(3, bhj_value15);
/* 406 */           }
/* 407 */
/* 408 */           if (bhj_isNull16) {
/* 409 */             agg_rowWriter.setNullAt(4);
/* 410 */           } else {
/* 411 */             agg_rowWriter.write(4, bhj_value16);
/* 412 */           }
/* 413 */           agg_result5.setTotalSize(agg_holder.totalSize());
/* 414 */           agg_value12 = 42;
/* 415 */
/* 416 */           if (!bhj_isNull4) {
/* 417 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value4.getBaseObject(), bhj_value4.getBaseOffset(), bhj_value4.numBytes(), agg_value12);
/* 418 */           }
/* 419 */
/* 420 */           if (!bhj_isNull3) {
/* 421 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value3.getBaseObject(), bhj_value3.getBaseOffset(), bhj_value3.numBytes(), agg_value12);
/* 422 */           }
/* 423 */
/* 424 */           if (!bhj_isNull28) {
/* 425 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value28.getBaseObject(), bhj_value28.getBaseOffset(), bhj_value28.numBytes(), agg_value12);
/* 426 */           }
/* 427 */
/* 428 */           if (!bhj_isNull15) {
/* 429 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value15, agg_value12);
/* 430 */           }
/* 431 */
/* 432 */           if (!bhj_isNull16) {
/* 433 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value16, agg_value12);
/* 434 */           }
/* 435 */           if (true) {
/* 436 */             // try to get the buffer from hash map
/* 437 */             agg_unsafeRowAggBuffer =
/* 438 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value12);
/* 439 */           }
/* 440 */           if (agg_unsafeRowAggBuffer == null) {
/* 441 */             if (agg_sorter == null) {
/* 442 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 443 */             } else {
/* 444 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 445 */             }
/* 446 */
/* 447 */             // the hash map had be spilled, it should have enough memory now,
/* 448 */             // try  to allocate buffer again.
/* 449 */             agg_unsafeRowAggBuffer =
/* 450 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value12);
/* 451 */             if (agg_unsafeRowAggBuffer == null) {
/* 452 */               // failed to allocate the first page
/* 453 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 454 */             }
/* 455 */           }
/* 456 */         }
/* 457 */
/* 458 */         if (agg_fastAggBuffer != null) {
/* 459 */           // update fast row
/* 460 */
/* 461 */           // common sub-expressions
/* 462 */
/* 463 */           // evaluate aggregate function
/* 464 */           boolean agg_isNull26 = true;
/* 465 */           double agg_value27 = -1.0;
/* 466 */
/* 467 */           boolean agg_isNull28 = agg_fastAggBuffer.isNullAt(0);
/* 468 */           double agg_value29 = agg_isNull28 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 469 */           boolean agg_isNull27 = agg_isNull28;
/* 470 */           double agg_value28 = agg_value29;
/* 471 */           if (agg_isNull27) {
/* 472 */             boolean agg_isNull29 = false;
/* 473 */             double agg_value30 = -1.0;
/* 474 */             if (!false) {
/* 475 */               agg_value30 = (double) 0;
/* 476 */             }
/* 477 */             if (!agg_isNull29) {
/* 478 */               agg_isNull27 = false;
/* 479 */               agg_value28 = agg_value30;
/* 480 */             }
/* 481 */           }
/* 482 */
/* 483 */           if (!scan_isNull2) {
/* 484 */             agg_isNull26 = false; // resultCode could change nullability.
/* 485 */             agg_value27 = agg_value28 + scan_value2;
/* 486 */
/* 487 */           }
/* 488 */           boolean agg_isNull25 = agg_isNull26;
/* 489 */           double agg_value26 = agg_value27;
/* 490 */           if (agg_isNull25) {
/* 491 */             boolean agg_isNull32 = agg_fastAggBuffer.isNullAt(0);
/* 492 */             double agg_value33 = agg_isNull32 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 493 */             if (!agg_isNull32) {
/* 494 */               agg_isNull25 = false;
/* 495 */               agg_value26 = agg_value33;
/* 496 */             }
/* 497 */           }
/* 498 */           // update fast row
/* 499 */           if (!agg_isNull25) {
/* 500 */             agg_fastAggBuffer.setDouble(0, agg_value26);
/* 501 */           } else {
/* 502 */             agg_fastAggBuffer.setNullAt(0);
/* 503 */           }
/* 504 */
/* 505 */         } else {
/* 506 */           // update unsafe row
/* 507 */
/* 508 */           // common sub-expressions
/* 509 */
/* 510 */           // evaluate aggregate function
/* 511 */           boolean agg_isNull18 = true;
/* 512 */           double agg_value19 = -1.0;
/* 513 */
/* 514 */           boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 515 */           double agg_value21 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 516 */           boolean agg_isNull19 = agg_isNull20;
/* 517 */           double agg_value20 = agg_value21;
/* 518 */           if (agg_isNull19) {
/* 519 */             boolean agg_isNull21 = false;
/* 520 */             double agg_value22 = -1.0;
/* 521 */             if (!false) {
/* 522 */               agg_value22 = (double) 0;
/* 523 */             }
/* 524 */             if (!agg_isNull21) {
/* 525 */               agg_isNull19 = false;
/* 526 */               agg_value20 = agg_value22;
/* 527 */             }
/* 528 */           }
/* 529 */
/* 530 */           if (!scan_isNull2) {
/* 531 */             agg_isNull18 = false; // resultCode could change nullability.
/* 532 */             agg_value19 = agg_value20 + scan_value2;
/* 533 */
/* 534 */           }
/* 535 */           boolean agg_isNull17 = agg_isNull18;
/* 536 */           double agg_value18 = agg_value19;
/* 537 */           if (agg_isNull17) {
/* 538 */             boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 539 */             double agg_value25 = agg_isNull24 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 540 */             if (!agg_isNull24) {
/* 541 */               agg_isNull17 = false;
/* 542 */               agg_value18 = agg_value25;
/* 543 */             }
/* 544 */           }
/* 545 */           // update unsafe row buffer
/* 546 */           if (!agg_isNull17) {
/* 547 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value18);
/* 548 */           } else {
/* 549 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 550 */           }
/* 551 */
/* 552 */         }
/* 553 */         // shouldStop check is eliminated
/* 554 */       }
/* 555 */       scan_batchIdx = scan_numRows;
/* 556 */       scan_batch = null;
/* 557 */       scan_nextBatch();
/* 558 */     }
/* 559 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 560 */     scan_scanTime1 = 0;
/* 561 */
/* 562 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 563 */
/* 564 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 565 */   }
/* 566 */
/* 567 */   private void wholestagecodegen_init_2() {
/* 568 */     project_result1 = new UnsafeRow(5);
/* 569 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 64);
/* 570 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 571 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[14];
/* 572 */
/* 573 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 574 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 575 */
/* 576 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 577 */     bhj_result1 = new UnsafeRow(8);
/* 578 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 579 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 8);
/* 580 */     project_result2 = new UnsafeRow(6);
/* 581 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 582 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 583 */
/* 584 */   }
/* 585 */
/* 586 */   private void wholestagecodegen_init_1() {
/* 587 */     filter_result = new UnsafeRow(4);
/* 588 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 589 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 590 */     project_result = new UnsafeRow(4);
/* 591 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 592 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 593 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[12];
/* 594 */
/* 595 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 596 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 597 */
/* 598 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 599 */     bhj_result = new UnsafeRow(7);
/* 600 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 64);
/* 601 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 602 */
/* 603 */   }
/* 604 */
/* 605 */   private void wholestagecodegen_init_4() {
/* 606 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 607 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 608 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[19];
/* 609 */
/* 610 */   }
/* 611 */
/* 612 */   protected void processNext() throws java.io.IOException {
/* 613 */     if (!agg_initAgg) {
/* 614 */       agg_initAgg = true;
/* 615 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 616 */       agg_doAggregateWithKeys();
/* 617 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 618 */     }
/* 619 */
/* 620 */     // output the result
/* 621 */
/* 622 */     while (agg_fastHashMapIter.next()) {
/* 623 */       wholestagecodegen_numOutputRows.add(1);
/* 624 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 625 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 626 */
/* 627 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 628 */
/* 629 */       append(agg_resultRow);
/* 630 */
/* 631 */       if (shouldStop()) return;
/* 632 */     }
/* 633 */     agg_fastHashMap.close();
/* 634 */
/* 635 */     while (agg_mapIter.next()) {
/* 636 */       wholestagecodegen_numOutputRows.add(1);
/* 637 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 638 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 639 */
/* 640 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 641 */
/* 642 */       append(agg_resultRow);
/* 643 */
/* 644 */       if (shouldStop()) return;
/* 645 */     }
/* 646 */
/* 647 */     agg_mapIter.close();
/* 648 */     if (agg_sorter == null) {
/* 649 */       agg_hashMap.free();
/* 650 */     }
/* 651 */   }
/* 652 */ }
