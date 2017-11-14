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
/* 066 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 067 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 068 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 069 */   private UnsafeRow bhj_result3;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 072 */   private UnsafeRow project_result4;
/* 073 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 075 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast4;
/* 076 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation4;
/* 077 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows4;
/* 078 */   private UnsafeRow bhj_result4;
/* 079 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder4;
/* 080 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter4;
/* 081 */   private UnsafeRow project_result5;
/* 082 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder5;
/* 083 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter5;
/* 084 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast5;
/* 085 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation5;
/* 086 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows5;
/* 087 */   private UnsafeRow bhj_result5;
/* 088 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder5;
/* 089 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter5;
/* 090 */   private UnsafeRow project_result6;
/* 091 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder6;
/* 092 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter6;
/* 093 */   private UnsafeRow agg_result5;
/* 094 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 095 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 096 */   private int agg_value12;
/* 097 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 098 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 099 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 100 */
/* 101 */   public GeneratedIterator(Object[] references) {
/* 102 */     this.references = references;
/* 103 */   }
/* 104 */
/* 105 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 106 */     partitionIndex = index;
/* 107 */     this.inputs = inputs;
/* 108 */     wholestagecodegen_init_0();
/* 109 */     wholestagecodegen_init_1();
/* 110 */     wholestagecodegen_init_2();
/* 111 */     wholestagecodegen_init_3();
/* 112 */     wholestagecodegen_init_4();
/* 113 */     wholestagecodegen_init_5();
/* 114 */     wholestagecodegen_init_6();
/* 115 */
/* 116 */   }
/* 117 */
/* 118 */   private void wholestagecodegen_init_0() {
/* 119 */     agg_initAgg = false;
/* 120 */
/* 121 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 122 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 123 */
/* 124 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 125 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 126 */     scan_input = inputs[0];
/* 127 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 128 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 129 */     scan_scanTime1 = 0;
/* 130 */     scan_batch = null;
/* 131 */     scan_batchIdx = 0;
/* 132 */     scan_colInstance0 = null;
/* 133 */     scan_colInstance1 = null;
/* 134 */     scan_colInstance2 = null;
/* 135 */     scan_colInstance3 = null;
/* 136 */     scan_result = new UnsafeRow(4);
/* 137 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 96);
/* 138 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 139 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 140 */
/* 141 */   }
/* 142 */
/* 143 */   private void wholestagecodegen_init_3() {
/* 144 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 145 */
/* 146 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 147 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 148 */
/* 149 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 150 */     bhj_result2 = new UnsafeRow(9);
/* 151 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 96);
/* 152 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 9);
/* 153 */     project_result3 = new UnsafeRow(7);
/* 154 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 96);
/* 155 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 7);
/* 156 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[12];
/* 157 */
/* 158 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 159 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 160 */
/* 161 */   }
/* 162 */
/* 163 */   private void scan_nextBatch() throws java.io.IOException {
/* 164 */     long getBatchStart = System.nanoTime();
/* 165 */     if (scan_input.hasNext()) {
/* 166 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 167 */       scan_numOutputRows.add(scan_batch.numRows());
/* 168 */       scan_batchIdx = 0;
/* 169 */       scan_colInstance0 = scan_batch.column(0);
/* 170 */       scan_colInstance1 = scan_batch.column(1);
/* 171 */       scan_colInstance2 = scan_batch.column(2);
/* 172 */       scan_colInstance3 = scan_batch.column(3);
/* 173 */
/* 174 */     }
/* 175 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 176 */   }
/* 177 */
/* 178 */   public class agg_FastHashMap {
/* 179 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 180 */     private int[] buckets;
/* 181 */     private int capacity = 1 << 16;
/* 182 */     private double loadFactor = 0.5;
/* 183 */     private int numBuckets = (int) (capacity / loadFactor);
/* 184 */     private int maxSteps = 2;
/* 185 */     private int numRows = 0;
/* 186 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("cc_call_center_id", org.apache.spark.sql.types.DataTypes.StringType)
/* 187 */     .add("cc_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 188 */     .add("cc_manager", org.apache.spark.sql.types.DataTypes.StringType)
/* 189 */     .add("cd_marital_status", org.apache.spark.sql.types.DataTypes.StringType)
/* 190 */     .add("cd_education_status", org.apache.spark.sql.types.DataTypes.StringType);
/* 191 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 192 */     private Object emptyVBase;
/* 193 */     private long emptyVOff;
/* 194 */     private int emptyVLen;
/* 195 */     private boolean isBatchFull = false;
/* 196 */
/* 197 */     public agg_FastHashMap(
/* 198 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 199 */       InternalRow emptyAggregationBuffer) {
/* 200 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 201 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 202 */
/* 203 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 204 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 205 */
/* 206 */       emptyVBase = emptyBuffer;
/* 207 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 208 */       emptyVLen = emptyBuffer.length;
/* 209 */
/* 210 */       buckets = new int[numBuckets];
/* 211 */       java.util.Arrays.fill(buckets, -1);
/* 212 */     }
/* 213 */
/* 214 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4) {
/* 215 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4);
/* 216 */       int step = 0;
/* 217 */       int idx = (int) h & (numBuckets - 1);
/* 218 */       while (step < maxSteps) {
/* 219 */         // Return bucket index if it's either an empty slot or already contains the key
/* 220 */         if (buckets[idx] == -1) {
/* 221 */           if (numRows < capacity && !isBatchFull) {
/* 222 */             // creating the unsafe for new entry
/* 223 */             UnsafeRow agg_result = new UnsafeRow(5);
/* 224 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 225 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 226 */               160);
/* 227 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 228 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 229 */               agg_holder,
/* 230 */               5);
/* 231 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 232 */             agg_rowWriter.zeroOutNullBytes();
/* 233 */             agg_rowWriter.write(0, agg_key);
/* 234 */             agg_rowWriter.write(1, agg_key1);
/* 235 */             agg_rowWriter.write(2, agg_key2);
/* 236 */             agg_rowWriter.write(3, agg_key3);
/* 237 */             agg_rowWriter.write(4, agg_key4);
/* 238 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 239 */             Object kbase = agg_result.getBaseObject();
/* 240 */             long koff = agg_result.getBaseOffset();
/* 241 */             int klen = agg_result.getSizeInBytes();
/* 242 */
/* 243 */             UnsafeRow vRow
/* 244 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 245 */             if (vRow == null) {
/* 246 */               isBatchFull = true;
/* 247 */             } else {
/* 248 */               buckets[idx] = numRows++;
/* 249 */             }
/* 250 */             return vRow;
/* 251 */           } else {
/* 252 */             // No more space
/* 253 */             return null;
/* 254 */           }
/* 255 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4)) {
/* 256 */           return batch.getValueRow(buckets[idx]);
/* 257 */         }
/* 258 */         idx = (idx + 1) & (numBuckets - 1);
/* 259 */         step++;
/* 260 */       }
/* 261 */       // Didn't find it
/* 262 */       return null;
/* 263 */     }
/* 264 */
/* 265 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4) {
/* 266 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 267 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getUTF8String(4).equals(agg_key4));
/* 268 */     }
/* 269 */
/* 270 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4) {
/* 271 */       long agg_hash = 0;
/* 272 */
/* 273 */       int agg_result = 0;
/* 274 */       byte[] agg_bytes = agg_key.getBytes();
/* 275 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 276 */         int agg_hash1 = agg_bytes[i];
/* 277 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 278 */       }
/* 279 */
/* 280 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 281 */
/* 282 */       int agg_result1 = 0;
/* 283 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 284 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 285 */         int agg_hash2 = agg_bytes1[i];
/* 286 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 287 */       }
/* 288 */
/* 289 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 290 */
/* 291 */       int agg_result2 = 0;
/* 292 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 293 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 294 */         int agg_hash3 = agg_bytes2[i];
/* 295 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 296 */       }
/* 297 */
/* 298 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 299 */
/* 300 */       int agg_result3 = 0;
/* 301 */       byte[] agg_bytes3 = agg_key3.getBytes();
/* 302 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 303 */         int agg_hash4 = agg_bytes3[i];
/* 304 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash4 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 305 */       }
/* 306 */
/* 307 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 308 */
/* 309 */       int agg_result4 = 0;
/* 310 */       byte[] agg_bytes4 = agg_key4.getBytes();
/* 311 */       for (int i = 0; i < agg_bytes4.length; i++) {
/* 312 */         int agg_hash5 = agg_bytes4[i];
/* 313 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash5 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 314 */       }
/* 315 */
/* 316 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 317 */
/* 318 */       return agg_hash;
/* 319 */     }
/* 320 */
/* 321 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 322 */       return batch.rowIterator();
/* 323 */     }
/* 324 */
/* 325 */     public void close() {
/* 326 */       batch.close();
/* 327 */     }
/* 328 */
/* 329 */   }
/* 330 */
/* 331 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 332 */     agg_hashMap = agg_plan.createHashMap();
/* 333 */
/* 334 */     if (scan_batch == null) {
/* 335 */       scan_nextBatch();
/* 336 */     }
/* 337 */     while (scan_batch != null) {
/* 338 */       int numRows = scan_batch.numRows();
/* 339 */       while (scan_batchIdx < numRows) {
/* 340 */         int scan_rowIdx = scan_batchIdx++;
/* 341 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 342 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 343 */
/* 344 */         if (!(!(scan_isNull))) continue;
/* 345 */
/* 346 */         filter_numOutputRows.add(1);
/* 347 */
/* 348 */         // generate join key for stream side
/* 349 */
/* 350 */         boolean bhj_isNull = false;
/* 351 */         long bhj_value = -1L;
/* 352 */         if (!false) {
/* 353 */           bhj_value = (long) scan_value;
/* 354 */         }
/* 355 */         // find matches from HashedRelation
/* 356 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 357 */         if (bhj_matched == null) continue;
/* 358 */
/* 359 */         bhj_numOutputRows.add(1);
/* 360 */
/* 361 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 362 */         int bhj_value5 = bhj_isNull5 ? -1 : (bhj_matched.getInt(3));
/* 363 */
/* 364 */         // generate join key for stream side
/* 365 */
/* 366 */         boolean bhj_isNull14 = bhj_isNull5;
/* 367 */         long bhj_value14 = -1L;
/* 368 */         if (!bhj_isNull5) {
/* 369 */           bhj_value14 = (long) bhj_value5;
/* 370 */         }
/* 371 */         // find matches from HashedRelation
/* 372 */         UnsafeRow bhj_matched1 = bhj_isNull14 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value14);
/* 373 */         if (bhj_matched1 == null) continue;
/* 374 */
/* 375 */         bhj_numOutputRows1.add(1);
/* 376 */
/* 377 */         boolean bhj_isNull2 = bhj_matched.isNullAt(0);
/* 378 */         int bhj_value2 = bhj_isNull2 ? -1 : (bhj_matched.getInt(0));
/* 379 */
/* 380 */         // generate join key for stream side
/* 381 */
/* 382 */         boolean bhj_isNull24 = bhj_isNull2;
/* 383 */         long bhj_value24 = -1L;
/* 384 */         if (!bhj_isNull2) {
/* 385 */           bhj_value24 = (long) bhj_value2;
/* 386 */         }
/* 387 */         // find matches from HashedRelation
/* 388 */         UnsafeRow bhj_matched2 = bhj_isNull24 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value24);
/* 389 */         if (bhj_matched2 == null) continue;
/* 390 */
/* 391 */         bhj_numOutputRows2.add(1);
/* 392 */
/* 393 */         boolean bhj_isNull29 = bhj_matched2.isNullAt(3);
/* 394 */         int bhj_value29 = bhj_isNull29 ? -1 : (bhj_matched2.getInt(3));
/* 395 */
/* 396 */         // generate join key for stream side
/* 397 */
/* 398 */         boolean bhj_isNull39 = bhj_isNull29;
/* 399 */         long bhj_value39 = -1L;
/* 400 */         if (!bhj_isNull29) {
/* 401 */           bhj_value39 = (long) bhj_value29;
/* 402 */         }
/* 403 */         // find matches from HashedRelation
/* 404 */         UnsafeRow bhj_matched3 = bhj_isNull39 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value39);
/* 405 */         if (bhj_matched3 == null) continue;
/* 406 */
/* 407 */         bhj_numOutputRows3.add(1);
/* 408 */
/* 409 */         boolean bhj_isNull27 = bhj_matched2.isNullAt(1);
/* 410 */         int bhj_value27 = bhj_isNull27 ? -1 : (bhj_matched2.getInt(1));
/* 411 */
/* 412 */         // generate join key for stream side
/* 413 */
/* 414 */         boolean bhj_isNull50 = bhj_isNull27;
/* 415 */         long bhj_value50 = -1L;
/* 416 */         if (!bhj_isNull27) {
/* 417 */           bhj_value50 = (long) bhj_value27;
/* 418 */         }
/* 419 */         // find matches from HashedRelation
/* 420 */         UnsafeRow bhj_matched4 = bhj_isNull50 ? null: (UnsafeRow)bhj_relation4.getValue(bhj_value50);
/* 421 */         if (bhj_matched4 == null) continue;
/* 422 */
/* 423 */         bhj_numOutputRows4.add(1);
/* 424 */
/* 425 */         boolean bhj_isNull28 = bhj_matched2.isNullAt(2);
/* 426 */         int bhj_value28 = bhj_isNull28 ? -1 : (bhj_matched2.getInt(2));
/* 427 */
/* 428 */         // generate join key for stream side
/* 429 */
/* 430 */         boolean bhj_isNull64 = bhj_isNull28;
/* 431 */         long bhj_value64 = -1L;
/* 432 */         if (!bhj_isNull28) {
/* 433 */           bhj_value64 = (long) bhj_value28;
/* 434 */         }
/* 435 */         // find matches from HashedRelation
/* 436 */         UnsafeRow bhj_matched5 = bhj_isNull64 ? null: (UnsafeRow)bhj_relation5.getValue(bhj_value64);
/* 437 */         if (bhj_matched5 == null) continue;
/* 438 */
/* 439 */         bhj_numOutputRows5.add(1);
/* 440 */
/* 441 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 442 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 443 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 444 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 445 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 446 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 447 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 448 */         double bhj_value4 = bhj_isNull4 ? -1.0 : (bhj_matched.getDouble(2));
/* 449 */         boolean bhj_isNull53 = bhj_matched4.isNullAt(1);
/* 450 */         UTF8String bhj_value53 = bhj_isNull53 ? null : (bhj_matched4.getUTF8String(1));
/* 451 */         boolean bhj_isNull54 = bhj_matched4.isNullAt(2);
/* 452 */         UTF8String bhj_value54 = bhj_isNull54 ? null : (bhj_matched4.getUTF8String(2));
/* 453 */
/* 454 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 455 */
/* 456 */         UnsafeRow agg_fastAggBuffer = null;
/* 457 */
/* 458 */         if (true) {
/* 459 */           if (!scan_isNull1 && !scan_isNull2 && !scan_isNull3 && !bhj_isNull53 && !bhj_isNull54) {
/* 460 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 461 */               scan_value1, scan_value2, scan_value3, bhj_value53, bhj_value54);
/* 462 */           }
/* 463 */         }
/* 464 */
/* 465 */         if (agg_fastAggBuffer == null) {
/* 466 */           // generate grouping key
/* 467 */           agg_holder.reset();
/* 468 */
/* 469 */           agg_rowWriter.zeroOutNullBytes();
/* 470 */
/* 471 */           if (scan_isNull1) {
/* 472 */             agg_rowWriter.setNullAt(0);
/* 473 */           } else {
/* 474 */             agg_rowWriter.write(0, scan_value1);
/* 475 */           }
/* 476 */
/* 477 */           if (scan_isNull2) {
/* 478 */             agg_rowWriter.setNullAt(1);
/* 479 */           } else {
/* 480 */             agg_rowWriter.write(1, scan_value2);
/* 481 */           }
/* 482 */
/* 483 */           if (scan_isNull3) {
/* 484 */             agg_rowWriter.setNullAt(2);
/* 485 */           } else {
/* 486 */             agg_rowWriter.write(2, scan_value3);
/* 487 */           }
/* 488 */
/* 489 */           if (bhj_isNull53) {
/* 490 */             agg_rowWriter.setNullAt(3);
/* 491 */           } else {
/* 492 */             agg_rowWriter.write(3, bhj_value53);
/* 493 */           }
/* 494 */
/* 495 */           if (bhj_isNull54) {
/* 496 */             agg_rowWriter.setNullAt(4);
/* 497 */           } else {
/* 498 */             agg_rowWriter.write(4, bhj_value54);
/* 499 */           }
/* 500 */           agg_result5.setTotalSize(agg_holder.totalSize());
/* 501 */           agg_value12 = 42;
/* 502 */
/* 503 */           if (!scan_isNull1) {
/* 504 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value1.getBaseObject(), scan_value1.getBaseOffset(), scan_value1.numBytes(), agg_value12);
/* 505 */           }
/* 506 */
/* 507 */           if (!scan_isNull2) {
/* 508 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value2.getBaseObject(), scan_value2.getBaseOffset(), scan_value2.numBytes(), agg_value12);
/* 509 */           }
/* 510 */
/* 511 */           if (!scan_isNull3) {
/* 512 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value3.getBaseObject(), scan_value3.getBaseOffset(), scan_value3.numBytes(), agg_value12);
/* 513 */           }
/* 514 */
/* 515 */           if (!bhj_isNull53) {
/* 516 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value53.getBaseObject(), bhj_value53.getBaseOffset(), bhj_value53.numBytes(), agg_value12);
/* 517 */           }
/* 518 */
/* 519 */           if (!bhj_isNull54) {
/* 520 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value54.getBaseObject(), bhj_value54.getBaseOffset(), bhj_value54.numBytes(), agg_value12);
/* 521 */           }
/* 522 */           if (true) {
/* 523 */             // try to get the buffer from hash map
/* 524 */             agg_unsafeRowAggBuffer =
/* 525 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value12);
/* 526 */           }
/* 527 */           if (agg_unsafeRowAggBuffer == null) {
/* 528 */             if (agg_sorter == null) {
/* 529 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 530 */             } else {
/* 531 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 532 */             }
/* 533 */
/* 534 */             // the hash map had be spilled, it should have enough memory now,
/* 535 */             // try  to allocate buffer again.
/* 536 */             agg_unsafeRowAggBuffer =
/* 537 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value12);
/* 538 */             if (agg_unsafeRowAggBuffer == null) {
/* 539 */               // failed to allocate the first page
/* 540 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 541 */             }
/* 542 */           }
/* 543 */         }
/* 544 */
/* 545 */         if (agg_fastAggBuffer != null) {
/* 546 */           // update fast row
/* 547 */
/* 548 */           // common sub-expressions
/* 549 */
/* 550 */           // evaluate aggregate function
/* 551 */           boolean agg_isNull27 = true;
/* 552 */           double agg_value28 = -1.0;
/* 553 */
/* 554 */           boolean agg_isNull29 = agg_fastAggBuffer.isNullAt(0);
/* 555 */           double agg_value30 = agg_isNull29 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 556 */           boolean agg_isNull28 = agg_isNull29;
/* 557 */           double agg_value29 = agg_value30;
/* 558 */           if (agg_isNull28) {
/* 559 */             boolean agg_isNull30 = false;
/* 560 */             double agg_value31 = -1.0;
/* 561 */             if (!false) {
/* 562 */               agg_value31 = (double) 0;
/* 563 */             }
/* 564 */             if (!agg_isNull30) {
/* 565 */               agg_isNull28 = false;
/* 566 */               agg_value29 = agg_value31;
/* 567 */             }
/* 568 */           }
/* 569 */
/* 570 */           boolean agg_isNull32 = bhj_isNull4;
/* 571 */           double agg_value33 = -1.0;
/* 572 */           if (!bhj_isNull4) {
/* 573 */             agg_value33 = bhj_value4;
/* 574 */           }
/* 575 */           if (!agg_isNull32) {
/* 576 */             agg_isNull27 = false; // resultCode could change nullability.
/* 577 */             agg_value28 = agg_value29 + agg_value33;
/* 578 */
/* 579 */           }
/* 580 */           boolean agg_isNull26 = agg_isNull27;
/* 581 */           double agg_value27 = agg_value28;
/* 582 */           if (agg_isNull26) {
/* 583 */             boolean agg_isNull34 = agg_fastAggBuffer.isNullAt(0);
/* 584 */             double agg_value35 = agg_isNull34 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 585 */             if (!agg_isNull34) {
/* 586 */               agg_isNull26 = false;
/* 587 */               agg_value27 = agg_value35;
/* 588 */             }
/* 589 */           }
/* 590 */           // update fast row
/* 591 */           if (!agg_isNull26) {
/* 592 */             agg_fastAggBuffer.setDouble(0, agg_value27);
/* 593 */           } else {
/* 594 */             agg_fastAggBuffer.setNullAt(0);
/* 595 */           }
/* 596 */
/* 597 */         } else {
/* 598 */           // update unsafe row
/* 599 */
/* 600 */           // common sub-expressions
/* 601 */
/* 602 */           // evaluate aggregate function
/* 603 */           boolean agg_isNull18 = true;
/* 604 */           double agg_value19 = -1.0;
/* 605 */
/* 606 */           boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 607 */           double agg_value21 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 608 */           boolean agg_isNull19 = agg_isNull20;
/* 609 */           double agg_value20 = agg_value21;
/* 610 */           if (agg_isNull19) {
/* 611 */             boolean agg_isNull21 = false;
/* 612 */             double agg_value22 = -1.0;
/* 613 */             if (!false) {
/* 614 */               agg_value22 = (double) 0;
/* 615 */             }
/* 616 */             if (!agg_isNull21) {
/* 617 */               agg_isNull19 = false;
/* 618 */               agg_value20 = agg_value22;
/* 619 */             }
/* 620 */           }
/* 621 */
/* 622 */           boolean agg_isNull23 = bhj_isNull4;
/* 623 */           double agg_value24 = -1.0;
/* 624 */           if (!bhj_isNull4) {
/* 625 */             agg_value24 = bhj_value4;
/* 626 */           }
/* 627 */           if (!agg_isNull23) {
/* 628 */             agg_isNull18 = false; // resultCode could change nullability.
/* 629 */             agg_value19 = agg_value20 + agg_value24;
/* 630 */
/* 631 */           }
/* 632 */           boolean agg_isNull17 = agg_isNull18;
/* 633 */           double agg_value18 = agg_value19;
/* 634 */           if (agg_isNull17) {
/* 635 */             boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 636 */             double agg_value26 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 637 */             if (!agg_isNull25) {
/* 638 */               agg_isNull17 = false;
/* 639 */               agg_value18 = agg_value26;
/* 640 */             }
/* 641 */           }
/* 642 */           // update unsafe row buffer
/* 643 */           if (!agg_isNull17) {
/* 644 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value18);
/* 645 */           } else {
/* 646 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 647 */           }
/* 648 */
/* 649 */         }
/* 650 */         if (shouldStop()) return;
/* 651 */       }
/* 652 */       scan_batch = null;
/* 653 */       scan_nextBatch();
/* 654 */     }
/* 655 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 656 */     scan_scanTime1 = 0;
/* 657 */
/* 658 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 659 */
/* 660 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 661 */   }
/* 662 */
/* 663 */   private void wholestagecodegen_init_5() {
/* 664 */     this.bhj_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder4, 9);
/* 665 */     project_result5 = new UnsafeRow(7);
/* 666 */     this.project_holder5 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result5, 160);
/* 667 */     this.project_rowWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder5, 7);
/* 668 */     this.bhj_broadcast5 = (org.apache.spark.broadcast.TorrentBroadcast) references[16];
/* 669 */
/* 670 */     bhj_relation5 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast5.value()).asReadOnlyCopy();
/* 671 */     incPeakExecutionMemory(bhj_relation5.estimatedSize());
/* 672 */
/* 673 */     this.bhj_numOutputRows5 = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 674 */     bhj_result5 = new UnsafeRow(8);
/* 675 */     this.bhj_holder5 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result5, 160);
/* 676 */     this.bhj_rowWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder5, 8);
/* 677 */     project_result6 = new UnsafeRow(6);
/* 678 */     this.project_holder6 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result6, 160);
/* 679 */
/* 680 */   }
/* 681 */
/* 682 */   private void wholestagecodegen_init_2() {
/* 683 */     project_result1 = new UnsafeRow(6);
/* 684 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 96);
/* 685 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 6);
/* 686 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 687 */
/* 688 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 689 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 690 */
/* 691 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 692 */     bhj_result1 = new UnsafeRow(7);
/* 693 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 96);
/* 694 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 7);
/* 695 */     project_result2 = new UnsafeRow(5);
/* 696 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 96);
/* 697 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 5);
/* 698 */
/* 699 */   }
/* 700 */
/* 701 */   private void wholestagecodegen_init_1() {
/* 702 */     filter_result = new UnsafeRow(4);
/* 703 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 96);
/* 704 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 705 */     project_result = new UnsafeRow(4);
/* 706 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 707 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 708 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 709 */
/* 710 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 711 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 712 */
/* 713 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 714 */     bhj_result = new UnsafeRow(8);
/* 715 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 96);
/* 716 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 8);
/* 717 */
/* 718 */   }
/* 719 */
/* 720 */   private void wholestagecodegen_init_4() {
/* 721 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 722 */     bhj_result3 = new UnsafeRow(8);
/* 723 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 96);
/* 724 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 8);
/* 725 */     project_result4 = new UnsafeRow(6);
/* 726 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 96);
/* 727 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 6);
/* 728 */     this.bhj_broadcast4 = (org.apache.spark.broadcast.TorrentBroadcast) references[14];
/* 729 */
/* 730 */     bhj_relation4 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast4.value()).asReadOnlyCopy();
/* 731 */     incPeakExecutionMemory(bhj_relation4.estimatedSize());
/* 732 */
/* 733 */     this.bhj_numOutputRows4 = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 734 */     bhj_result4 = new UnsafeRow(9);
/* 735 */     this.bhj_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result4, 160);
/* 736 */
/* 737 */   }
/* 738 */
/* 739 */   private void wholestagecodegen_init_6() {
/* 740 */     this.project_rowWriter6 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder6, 6);
/* 741 */     agg_result5 = new UnsafeRow(5);
/* 742 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result5, 160);
/* 743 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 744 */
/* 745 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 746 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 747 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[19];
/* 748 */
/* 749 */   }
/* 750 */
/* 751 */   protected void processNext() throws java.io.IOException {
/* 752 */     if (!agg_initAgg) {
/* 753 */       agg_initAgg = true;
/* 754 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 755 */       agg_doAggregateWithKeys();
/* 756 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 757 */     }
/* 758 */
/* 759 */     // output the result
/* 760 */
/* 761 */     while (agg_fastHashMapIter.next()) {
/* 762 */       wholestagecodegen_numOutputRows.add(1);
/* 763 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 764 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 765 */
/* 766 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 767 */
/* 768 */       append(agg_resultRow);
/* 769 */
/* 770 */       if (shouldStop()) return;
/* 771 */     }
/* 772 */     agg_fastHashMap.close();
/* 773 */
/* 774 */     while (agg_mapIter.next()) {
/* 775 */       wholestagecodegen_numOutputRows.add(1);
/* 776 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 777 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 778 */
/* 779 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 780 */
/* 781 */       append(agg_resultRow);
/* 782 */
/* 783 */       if (shouldStop()) return;
/* 784 */     }
/* 785 */
/* 786 */     agg_mapIter.close();
/* 787 */     if (agg_sorter == null) {
/* 788 */       agg_hashMap.free();
/* 789 */     }
/* 790 */   }
/* 791 */ }
