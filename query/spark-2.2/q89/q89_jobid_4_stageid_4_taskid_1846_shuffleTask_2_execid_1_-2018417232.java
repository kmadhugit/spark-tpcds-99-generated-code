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
/* 068 */   private UnsafeRow agg_result6;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 071 */   private int agg_value16;
/* 072 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 073 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 074 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 075 */
/* 076 */   public GeneratedIterator(Object[] references) {
/* 077 */     this.references = references;
/* 078 */   }
/* 079 */
/* 080 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 081 */     partitionIndex = index;
/* 082 */     this.inputs = inputs;
/* 083 */     wholestagecodegen_init_0();
/* 084 */     wholestagecodegen_init_1();
/* 085 */     wholestagecodegen_init_2();
/* 086 */     wholestagecodegen_init_3();
/* 087 */     wholestagecodegen_init_4();
/* 088 */
/* 089 */   }
/* 090 */
/* 091 */   private void wholestagecodegen_init_0() {
/* 092 */     agg_initAgg = false;
/* 093 */
/* 094 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 095 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 096 */
/* 097 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 098 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 099 */     scan_input = inputs[0];
/* 100 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 101 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 102 */     scan_scanTime1 = 0;
/* 103 */     scan_batch = null;
/* 104 */     scan_batchIdx = 0;
/* 105 */     scan_colInstance0 = null;
/* 106 */     scan_colInstance1 = null;
/* 107 */     scan_colInstance2 = null;
/* 108 */     scan_colInstance3 = null;
/* 109 */     scan_result = new UnsafeRow(4);
/* 110 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 111 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 112 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 113 */
/* 114 */   }
/* 115 */
/* 116 */   private void wholestagecodegen_init_3() {
/* 117 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[18];
/* 118 */
/* 119 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 120 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 121 */
/* 122 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[19];
/* 123 */     bhj_result2 = new UnsafeRow(9);
/* 124 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 160);
/* 125 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 9);
/* 126 */     project_result3 = new UnsafeRow(7);
/* 127 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 160);
/* 128 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 7);
/* 129 */     agg_result6 = new UnsafeRow(6);
/* 130 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result6, 160);
/* 131 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 6);
/* 132 */
/* 133 */   }
/* 134 */
/* 135 */   private void scan_nextBatch() throws java.io.IOException {
/* 136 */     long getBatchStart = System.nanoTime();
/* 137 */     if (scan_input.hasNext()) {
/* 138 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 139 */       scan_numOutputRows.add(scan_batch.numRows());
/* 140 */       scan_batchIdx = 0;
/* 141 */       scan_colInstance0 = scan_batch.column(0);
/* 142 */       scan_colInstance1 = scan_batch.column(1);
/* 143 */       scan_colInstance2 = scan_batch.column(2);
/* 144 */       scan_colInstance3 = scan_batch.column(3);
/* 145 */
/* 146 */     }
/* 147 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 148 */   }
/* 149 */
/* 150 */   public class agg_FastHashMap {
/* 151 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 152 */     private int[] buckets;
/* 153 */     private int capacity = 1 << 16;
/* 154 */     private double loadFactor = 0.5;
/* 155 */     private int numBuckets = (int) (capacity / loadFactor);
/* 156 */     private int maxSteps = 2;
/* 157 */     private int numRows = 0;
/* 158 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 159 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 160 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 161 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.StringType)
/* 162 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.StringType)
/* 163 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 164 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 165 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 166 */     private Object emptyVBase;
/* 167 */     private long emptyVOff;
/* 168 */     private int emptyVLen;
/* 169 */     private boolean isBatchFull = false;
/* 170 */
/* 171 */     public agg_FastHashMap(
/* 172 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 173 */       InternalRow emptyAggregationBuffer) {
/* 174 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 175 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 176 */
/* 177 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 178 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 179 */
/* 180 */       emptyVBase = emptyBuffer;
/* 181 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 182 */       emptyVLen = emptyBuffer.length;
/* 183 */
/* 184 */       buckets = new int[numBuckets];
/* 185 */       java.util.Arrays.fill(buckets, -1);
/* 186 */     }
/* 187 */
/* 188 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, int agg_key5) {
/* 189 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5);
/* 190 */       int step = 0;
/* 191 */       int idx = (int) h & (numBuckets - 1);
/* 192 */       while (step < maxSteps) {
/* 193 */         // Return bucket index if it's either an empty slot or already contains the key
/* 194 */         if (buckets[idx] == -1) {
/* 195 */           if (numRows < capacity && !isBatchFull) {
/* 196 */             // creating the unsafe for new entry
/* 197 */             UnsafeRow agg_result = new UnsafeRow(6);
/* 198 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 199 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 200 */               160);
/* 201 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 202 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 203 */               agg_holder,
/* 204 */               6);
/* 205 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 206 */             agg_rowWriter.zeroOutNullBytes();
/* 207 */             agg_rowWriter.write(0, agg_key);
/* 208 */             agg_rowWriter.write(1, agg_key1);
/* 209 */             agg_rowWriter.write(2, agg_key2);
/* 210 */             agg_rowWriter.write(3, agg_key3);
/* 211 */             agg_rowWriter.write(4, agg_key4);
/* 212 */             agg_rowWriter.write(5, agg_key5);
/* 213 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 214 */             Object kbase = agg_result.getBaseObject();
/* 215 */             long koff = agg_result.getBaseOffset();
/* 216 */             int klen = agg_result.getSizeInBytes();
/* 217 */
/* 218 */             UnsafeRow vRow
/* 219 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 220 */             if (vRow == null) {
/* 221 */               isBatchFull = true;
/* 222 */             } else {
/* 223 */               buckets[idx] = numRows++;
/* 224 */             }
/* 225 */             return vRow;
/* 226 */           } else {
/* 227 */             // No more space
/* 228 */             return null;
/* 229 */           }
/* 230 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5)) {
/* 231 */           return batch.getValueRow(buckets[idx]);
/* 232 */         }
/* 233 */         idx = (idx + 1) & (numBuckets - 1);
/* 234 */         step++;
/* 235 */       }
/* 236 */       // Didn't find it
/* 237 */       return null;
/* 238 */     }
/* 239 */
/* 240 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, int agg_key5) {
/* 241 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 242 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getUTF8String(4).equals(agg_key4)) && (row.getInt(5) == agg_key5);
/* 243 */     }
/* 244 */
/* 245 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, int agg_key5) {
/* 246 */       long agg_hash = 0;
/* 247 */
/* 248 */       int agg_result = 0;
/* 249 */       byte[] agg_bytes = agg_key.getBytes();
/* 250 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 251 */         int agg_hash1 = agg_bytes[i];
/* 252 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 253 */       }
/* 254 */
/* 255 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 256 */
/* 257 */       int agg_result1 = 0;
/* 258 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 259 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 260 */         int agg_hash2 = agg_bytes1[i];
/* 261 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 262 */       }
/* 263 */
/* 264 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 265 */
/* 266 */       int agg_result2 = 0;
/* 267 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 268 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 269 */         int agg_hash3 = agg_bytes2[i];
/* 270 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 271 */       }
/* 272 */
/* 273 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 274 */
/* 275 */       int agg_result3 = 0;
/* 276 */       byte[] agg_bytes3 = agg_key3.getBytes();
/* 277 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 278 */         int agg_hash4 = agg_bytes3[i];
/* 279 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash4 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 280 */       }
/* 281 */
/* 282 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 283 */
/* 284 */       int agg_result4 = 0;
/* 285 */       byte[] agg_bytes4 = agg_key4.getBytes();
/* 286 */       for (int i = 0; i < agg_bytes4.length; i++) {
/* 287 */         int agg_hash5 = agg_bytes4[i];
/* 288 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash5 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 289 */       }
/* 290 */
/* 291 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 292 */
/* 293 */       int agg_result5 = agg_key5;
/* 294 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 295 */
/* 296 */       return agg_hash;
/* 297 */     }
/* 298 */
/* 299 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 300 */       return batch.rowIterator();
/* 301 */     }
/* 302 */
/* 303 */     public void close() {
/* 304 */       batch.close();
/* 305 */     }
/* 306 */
/* 307 */   }
/* 308 */
/* 309 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 310 */     agg_hashMap = agg_plan.createHashMap();
/* 311 */
/* 312 */     if (scan_batch == null) {
/* 313 */       scan_nextBatch();
/* 314 */     }
/* 315 */     while (scan_batch != null) {
/* 316 */       int scan_numRows = scan_batch.numRows();
/* 317 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 318 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 319 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 320 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 321 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 322 */
/* 323 */         if (!(!(scan_isNull))) continue;
/* 324 */
/* 325 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 326 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 327 */
/* 328 */         if (!(!(scan_isNull1))) continue;
/* 329 */
/* 330 */         filter_numOutputRows.add(1);
/* 331 */
/* 332 */         // generate join key for stream side
/* 333 */
/* 334 */         boolean bhj_isNull = false;
/* 335 */         long bhj_value = -1L;
/* 336 */         if (!false) {
/* 337 */           bhj_value = (long) scan_value;
/* 338 */         }
/* 339 */         // find matches from HashedRelation
/* 340 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 341 */         if (bhj_matched == null) continue;
/* 342 */
/* 343 */         bhj_numOutputRows.add(1);
/* 344 */
/* 345 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 346 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 347 */
/* 348 */         // generate join key for stream side
/* 349 */
/* 350 */         boolean bhj_isNull14 = scan_isNull3;
/* 351 */         long bhj_value14 = -1L;
/* 352 */         if (!scan_isNull3) {
/* 353 */           bhj_value14 = (long) scan_value3;
/* 354 */         }
/* 355 */         // find matches from HashedRelation
/* 356 */         UnsafeRow bhj_matched1 = bhj_isNull14 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value14);
/* 357 */         if (bhj_matched1 == null) continue;
/* 358 */
/* 359 */         bhj_numOutputRows1.add(1);
/* 360 */
/* 361 */         // generate join key for stream side
/* 362 */
/* 363 */         boolean bhj_isNull26 = false;
/* 364 */         long bhj_value26 = -1L;
/* 365 */         if (!false) {
/* 366 */           bhj_value26 = (long) scan_value1;
/* 367 */         }
/* 368 */         // find matches from HashedRelation
/* 369 */         UnsafeRow bhj_matched2 = bhj_isNull26 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value26);
/* 370 */         if (bhj_matched2 == null) continue;
/* 371 */
/* 372 */         bhj_numOutputRows2.add(1);
/* 373 */
/* 374 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 375 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 376 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 377 */         UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 378 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 379 */         UTF8String bhj_value5 = bhj_isNull5 ? null : (bhj_matched.getUTF8String(3));
/* 380 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 381 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 382 */         boolean bhj_isNull17 = bhj_matched1.isNullAt(1);
/* 383 */         int bhj_value17 = bhj_isNull17 ? -1 : (bhj_matched1.getInt(1));
/* 384 */         boolean bhj_isNull29 = bhj_matched2.isNullAt(1);
/* 385 */         UTF8String bhj_value29 = bhj_isNull29 ? null : (bhj_matched2.getUTF8String(1));
/* 386 */         boolean bhj_isNull30 = bhj_matched2.isNullAt(2);
/* 387 */         UTF8String bhj_value30 = bhj_isNull30 ? null : (bhj_matched2.getUTF8String(2));
/* 388 */
/* 389 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 390 */
/* 391 */         UnsafeRow agg_fastAggBuffer = null;
/* 392 */
/* 393 */         if (true) {
/* 394 */           if (!bhj_isNull5 && !bhj_isNull4 && !bhj_isNull3 && !bhj_isNull29 && !bhj_isNull30 && !bhj_isNull17) {
/* 395 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 396 */               bhj_value5, bhj_value4, bhj_value3, bhj_value29, bhj_value30, bhj_value17);
/* 397 */           }
/* 398 */         }
/* 399 */
/* 400 */         if (agg_fastAggBuffer == null) {
/* 401 */           // generate grouping key
/* 402 */           agg_holder.reset();
/* 403 */
/* 404 */           agg_rowWriter.zeroOutNullBytes();
/* 405 */
/* 406 */           if (bhj_isNull5) {
/* 407 */             agg_rowWriter.setNullAt(0);
/* 408 */           } else {
/* 409 */             agg_rowWriter.write(0, bhj_value5);
/* 410 */           }
/* 411 */
/* 412 */           if (bhj_isNull4) {
/* 413 */             agg_rowWriter.setNullAt(1);
/* 414 */           } else {
/* 415 */             agg_rowWriter.write(1, bhj_value4);
/* 416 */           }
/* 417 */
/* 418 */           if (bhj_isNull3) {
/* 419 */             agg_rowWriter.setNullAt(2);
/* 420 */           } else {
/* 421 */             agg_rowWriter.write(2, bhj_value3);
/* 422 */           }
/* 423 */
/* 424 */           if (bhj_isNull29) {
/* 425 */             agg_rowWriter.setNullAt(3);
/* 426 */           } else {
/* 427 */             agg_rowWriter.write(3, bhj_value29);
/* 428 */           }
/* 429 */
/* 430 */           if (bhj_isNull30) {
/* 431 */             agg_rowWriter.setNullAt(4);
/* 432 */           } else {
/* 433 */             agg_rowWriter.write(4, bhj_value30);
/* 434 */           }
/* 435 */
/* 436 */           if (bhj_isNull17) {
/* 437 */             agg_rowWriter.setNullAt(5);
/* 438 */           } else {
/* 439 */             agg_rowWriter.write(5, bhj_value17);
/* 440 */           }
/* 441 */           agg_result6.setTotalSize(agg_holder.totalSize());
/* 442 */           agg_value16 = 42;
/* 443 */
/* 444 */           if (!bhj_isNull5) {
/* 445 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value5.getBaseObject(), bhj_value5.getBaseOffset(), bhj_value5.numBytes(), agg_value16);
/* 446 */           }
/* 447 */
/* 448 */           if (!bhj_isNull4) {
/* 449 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value4.getBaseObject(), bhj_value4.getBaseOffset(), bhj_value4.numBytes(), agg_value16);
/* 450 */           }
/* 451 */
/* 452 */           if (!bhj_isNull3) {
/* 453 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value3.getBaseObject(), bhj_value3.getBaseOffset(), bhj_value3.numBytes(), agg_value16);
/* 454 */           }
/* 455 */
/* 456 */           if (!bhj_isNull29) {
/* 457 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value29.getBaseObject(), bhj_value29.getBaseOffset(), bhj_value29.numBytes(), agg_value16);
/* 458 */           }
/* 459 */
/* 460 */           if (!bhj_isNull30) {
/* 461 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value30.getBaseObject(), bhj_value30.getBaseOffset(), bhj_value30.numBytes(), agg_value16);
/* 462 */           }
/* 463 */
/* 464 */           if (!bhj_isNull17) {
/* 465 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value17, agg_value16);
/* 466 */           }
/* 467 */           if (true) {
/* 468 */             // try to get the buffer from hash map
/* 469 */             agg_unsafeRowAggBuffer =
/* 470 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result6, agg_value16);
/* 471 */           }
/* 472 */           if (agg_unsafeRowAggBuffer == null) {
/* 473 */             if (agg_sorter == null) {
/* 474 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 475 */             } else {
/* 476 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 477 */             }
/* 478 */
/* 479 */             // the hash map had be spilled, it should have enough memory now,
/* 480 */             // try  to allocate buffer again.
/* 481 */             agg_unsafeRowAggBuffer =
/* 482 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result6, agg_value16);
/* 483 */             if (agg_unsafeRowAggBuffer == null) {
/* 484 */               // failed to allocate the first page
/* 485 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 486 */             }
/* 487 */           }
/* 488 */         }
/* 489 */
/* 490 */         if (agg_fastAggBuffer != null) {
/* 491 */           // update fast row
/* 492 */
/* 493 */           // common sub-expressions
/* 494 */
/* 495 */           // evaluate aggregate function
/* 496 */           boolean agg_isNull40 = true;
/* 497 */           double agg_value42 = -1.0;
/* 498 */
/* 499 */           boolean agg_isNull42 = agg_fastAggBuffer.isNullAt(0);
/* 500 */           double agg_value44 = agg_isNull42 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 501 */           boolean agg_isNull41 = agg_isNull42;
/* 502 */           double agg_value43 = agg_value44;
/* 503 */           if (agg_isNull41) {
/* 504 */             boolean agg_isNull43 = false;
/* 505 */             double agg_value45 = -1.0;
/* 506 */             if (!false) {
/* 507 */               agg_value45 = (double) 0;
/* 508 */             }
/* 509 */             if (!agg_isNull43) {
/* 510 */               agg_isNull41 = false;
/* 511 */               agg_value43 = agg_value45;
/* 512 */             }
/* 513 */           }
/* 514 */
/* 515 */           if (!scan_isNull2) {
/* 516 */             agg_isNull40 = false; // resultCode could change nullability.
/* 517 */             agg_value42 = agg_value43 + scan_value2;
/* 518 */
/* 519 */           }
/* 520 */           boolean agg_isNull39 = agg_isNull40;
/* 521 */           double agg_value41 = agg_value42;
/* 522 */           if (agg_isNull39) {
/* 523 */             boolean agg_isNull46 = agg_fastAggBuffer.isNullAt(0);
/* 524 */             double agg_value48 = agg_isNull46 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 525 */             if (!agg_isNull46) {
/* 526 */               agg_isNull39 = false;
/* 527 */               agg_value41 = agg_value48;
/* 528 */             }
/* 529 */           }
/* 530 */           boolean agg_isNull48 = true;
/* 531 */           double agg_value50 = -1.0;
/* 532 */
/* 533 */           boolean agg_isNull50 = agg_fastAggBuffer.isNullAt(1);
/* 534 */           double agg_value52 = agg_isNull50 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 535 */           boolean agg_isNull49 = agg_isNull50;
/* 536 */           double agg_value51 = agg_value52;
/* 537 */           if (agg_isNull49) {
/* 538 */             boolean agg_isNull51 = false;
/* 539 */             double agg_value53 = -1.0;
/* 540 */             if (!false) {
/* 541 */               agg_value53 = (double) 0;
/* 542 */             }
/* 543 */             if (!agg_isNull51) {
/* 544 */               agg_isNull49 = false;
/* 545 */               agg_value51 = agg_value53;
/* 546 */             }
/* 547 */           }
/* 548 */
/* 549 */           if (!scan_isNull2) {
/* 550 */             agg_isNull48 = false; // resultCode could change nullability.
/* 551 */             agg_value50 = agg_value51 + scan_value2;
/* 552 */
/* 553 */           }
/* 554 */           boolean agg_isNull47 = agg_isNull48;
/* 555 */           double agg_value49 = agg_value50;
/* 556 */           if (agg_isNull47) {
/* 557 */             boolean agg_isNull54 = agg_fastAggBuffer.isNullAt(1);
/* 558 */             double agg_value56 = agg_isNull54 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 559 */             if (!agg_isNull54) {
/* 560 */               agg_isNull47 = false;
/* 561 */               agg_value49 = agg_value56;
/* 562 */             }
/* 563 */           }
/* 564 */           // update fast row
/* 565 */           if (!agg_isNull39) {
/* 566 */             agg_fastAggBuffer.setDouble(0, agg_value41);
/* 567 */           } else {
/* 568 */             agg_fastAggBuffer.setNullAt(0);
/* 569 */           }
/* 570 */
/* 571 */           if (!agg_isNull47) {
/* 572 */             agg_fastAggBuffer.setDouble(1, agg_value49);
/* 573 */           } else {
/* 574 */             agg_fastAggBuffer.setNullAt(1);
/* 575 */           }
/* 576 */
/* 577 */         } else {
/* 578 */           // update unsafe row
/* 579 */
/* 580 */           // common sub-expressions
/* 581 */
/* 582 */           // evaluate aggregate function
/* 583 */           boolean agg_isNull23 = true;
/* 584 */           double agg_value25 = -1.0;
/* 585 */
/* 586 */           boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 587 */           double agg_value27 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 588 */           boolean agg_isNull24 = agg_isNull25;
/* 589 */           double agg_value26 = agg_value27;
/* 590 */           if (agg_isNull24) {
/* 591 */             boolean agg_isNull26 = false;
/* 592 */             double agg_value28 = -1.0;
/* 593 */             if (!false) {
/* 594 */               agg_value28 = (double) 0;
/* 595 */             }
/* 596 */             if (!agg_isNull26) {
/* 597 */               agg_isNull24 = false;
/* 598 */               agg_value26 = agg_value28;
/* 599 */             }
/* 600 */           }
/* 601 */
/* 602 */           if (!scan_isNull2) {
/* 603 */             agg_isNull23 = false; // resultCode could change nullability.
/* 604 */             agg_value25 = agg_value26 + scan_value2;
/* 605 */
/* 606 */           }
/* 607 */           boolean agg_isNull22 = agg_isNull23;
/* 608 */           double agg_value24 = agg_value25;
/* 609 */           if (agg_isNull22) {
/* 610 */             boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 611 */             double agg_value31 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 612 */             if (!agg_isNull29) {
/* 613 */               agg_isNull22 = false;
/* 614 */               agg_value24 = agg_value31;
/* 615 */             }
/* 616 */           }
/* 617 */           boolean agg_isNull31 = true;
/* 618 */           double agg_value33 = -1.0;
/* 619 */
/* 620 */           boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 621 */           double agg_value35 = agg_isNull33 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 622 */           boolean agg_isNull32 = agg_isNull33;
/* 623 */           double agg_value34 = agg_value35;
/* 624 */           if (agg_isNull32) {
/* 625 */             boolean agg_isNull34 = false;
/* 626 */             double agg_value36 = -1.0;
/* 627 */             if (!false) {
/* 628 */               agg_value36 = (double) 0;
/* 629 */             }
/* 630 */             if (!agg_isNull34) {
/* 631 */               agg_isNull32 = false;
/* 632 */               agg_value34 = agg_value36;
/* 633 */             }
/* 634 */           }
/* 635 */
/* 636 */           if (!scan_isNull2) {
/* 637 */             agg_isNull31 = false; // resultCode could change nullability.
/* 638 */             agg_value33 = agg_value34 + scan_value2;
/* 639 */
/* 640 */           }
/* 641 */           boolean agg_isNull30 = agg_isNull31;
/* 642 */           double agg_value32 = agg_value33;
/* 643 */           if (agg_isNull30) {
/* 644 */             boolean agg_isNull37 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 645 */             double agg_value39 = agg_isNull37 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 646 */             if (!agg_isNull37) {
/* 647 */               agg_isNull30 = false;
/* 648 */               agg_value32 = agg_value39;
/* 649 */             }
/* 650 */           }
/* 651 */           // update unsafe row buffer
/* 652 */           if (!agg_isNull22) {
/* 653 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value24);
/* 654 */           } else {
/* 655 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 656 */           }
/* 657 */
/* 658 */           if (!agg_isNull30) {
/* 659 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value32);
/* 660 */           } else {
/* 661 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 662 */           }
/* 663 */
/* 664 */         }
/* 665 */         // shouldStop check is eliminated
/* 666 */       }
/* 667 */       scan_batchIdx = scan_numRows;
/* 668 */       scan_batch = null;
/* 669 */       scan_nextBatch();
/* 670 */     }
/* 671 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 672 */     scan_scanTime1 = 0;
/* 673 */
/* 674 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 675 */
/* 676 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 677 */   }
/* 678 */
/* 679 */   private void wholestagecodegen_init_2() {
/* 680 */     project_result1 = new UnsafeRow(6);
/* 681 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 96);
/* 682 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 6);
/* 683 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[16];
/* 684 */
/* 685 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 686 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 687 */
/* 688 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 689 */     bhj_result1 = new UnsafeRow(8);
/* 690 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 96);
/* 691 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 8);
/* 692 */     project_result2 = new UnsafeRow(6);
/* 693 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 96);
/* 694 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 695 */
/* 696 */   }
/* 697 */
/* 698 */   private void wholestagecodegen_init_1() {
/* 699 */     filter_result = new UnsafeRow(4);
/* 700 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 701 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 702 */     project_result = new UnsafeRow(4);
/* 703 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 704 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 705 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[14];
/* 706 */
/* 707 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 708 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 709 */
/* 710 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 711 */     bhj_result = new UnsafeRow(8);
/* 712 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 96);
/* 713 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 8);
/* 714 */
/* 715 */   }
/* 716 */
/* 717 */   private void wholestagecodegen_init_4() {
/* 718 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 719 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[20];
/* 720 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[21];
/* 721 */
/* 722 */   }
/* 723 */
/* 724 */   protected void processNext() throws java.io.IOException {
/* 725 */     if (!agg_initAgg) {
/* 726 */       agg_initAgg = true;
/* 727 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 728 */       agg_doAggregateWithKeys();
/* 729 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 730 */     }
/* 731 */
/* 732 */     // output the result
/* 733 */
/* 734 */     while (agg_fastHashMapIter.next()) {
/* 735 */       wholestagecodegen_numOutputRows.add(1);
/* 736 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 737 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 738 */
/* 739 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 740 */
/* 741 */       append(agg_resultRow);
/* 742 */
/* 743 */       if (shouldStop()) return;
/* 744 */     }
/* 745 */     agg_fastHashMap.close();
/* 746 */
/* 747 */     while (agg_mapIter.next()) {
/* 748 */       wholestagecodegen_numOutputRows.add(1);
/* 749 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 750 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 751 */
/* 752 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 753 */
/* 754 */       append(agg_resultRow);
/* 755 */
/* 756 */       if (shouldStop()) return;
/* 757 */     }
/* 758 */
/* 759 */     agg_mapIter.close();
/* 760 */     if (agg_sorter == null) {
/* 761 */       agg_hashMap.free();
/* 762 */     }
/* 763 */   }
/* 764 */ }
