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
/* 100 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 101 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 102 */     scan_scanTime1 = 0;
/* 103 */     scan_batch = null;
/* 104 */     scan_batchIdx = 0;
/* 105 */     scan_colInstance0 = null;
/* 106 */     scan_colInstance1 = null;
/* 107 */     scan_colInstance2 = null;
/* 108 */     scan_colInstance3 = null;
/* 109 */     scan_result = new UnsafeRow(4);
/* 110 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 96);
/* 111 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 112 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 113 */
/* 114 */   }
/* 115 */
/* 116 */   private void wholestagecodegen_init_3() {
/* 117 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[22];
/* 118 */
/* 119 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 120 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 121 */
/* 122 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[23];
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
/* 158 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("i_category", org.apache.spark.sql.types.DataTypes.StringType)
/* 159 */     .add("i_class", org.apache.spark.sql.types.DataTypes.StringType)
/* 160 */     .add("i_brand", org.apache.spark.sql.types.DataTypes.StringType)
/* 161 */     .add("s_store_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 162 */     .add("s_company_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 163 */     .add("d_moy", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 164 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 165 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
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
/* 316 */       int numRows = scan_batch.numRows();
/* 317 */       while (scan_batchIdx < numRows) {
/* 318 */         int scan_rowIdx = scan_batchIdx++;
/* 319 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 320 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 321 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 322 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 323 */
/* 324 */         boolean filter_value2 = false;
/* 325 */         boolean filter_isNull2 = scan_isNull3;
/* 326 */         if (!filter_isNull2) {
/* 327 */           if (!filter_value2) {
/* 328 */             Object filter_obj = ((Expression) references[6]).eval(null);
/* 329 */             UTF8String filter_value4 = (UTF8String) filter_obj;
/* 330 */             if (false) {
/* 331 */               filter_isNull2 = true;
/* 332 */             } else if (scan_value3.equals(filter_value4)) {
/* 333 */               filter_isNull2 = false;
/* 334 */               filter_value2 = true;
/* 335 */             }
/* 336 */           }
/* 337 */
/* 338 */           if (!filter_value2) {
/* 339 */             Object filter_obj1 = ((Expression) references[7]).eval(null);
/* 340 */             UTF8String filter_value5 = (UTF8String) filter_obj1;
/* 341 */             if (false) {
/* 342 */               filter_isNull2 = true;
/* 343 */             } else if (scan_value3.equals(filter_value5)) {
/* 344 */               filter_isNull2 = false;
/* 345 */               filter_value2 = true;
/* 346 */             }
/* 347 */           }
/* 348 */
/* 349 */           if (!filter_value2) {
/* 350 */             Object filter_obj2 = ((Expression) references[8]).eval(null);
/* 351 */             UTF8String filter_value6 = (UTF8String) filter_obj2;
/* 352 */             if (false) {
/* 353 */               filter_isNull2 = true;
/* 354 */             } else if (scan_value3.equals(filter_value6)) {
/* 355 */               filter_isNull2 = false;
/* 356 */               filter_value2 = true;
/* 357 */             }
/* 358 */           }
/* 359 */
/* 360 */         }
/* 361 */         boolean filter_isNull1 = false;
/* 362 */         boolean filter_value1 = false;
/* 363 */
/* 364 */         if (!filter_isNull2 && !filter_value2) {
/* 365 */         } else {
/* 366 */           boolean filter_value7 = false;
/* 367 */           boolean filter_isNull7 = scan_isNull2;
/* 368 */           if (!filter_isNull7) {
/* 369 */             if (!filter_value7) {
/* 370 */               Object filter_obj3 = ((Expression) references[9]).eval(null);
/* 371 */               UTF8String filter_value9 = (UTF8String) filter_obj3;
/* 372 */               if (false) {
/* 373 */                 filter_isNull7 = true;
/* 374 */               } else if (scan_value2.equals(filter_value9)) {
/* 375 */                 filter_isNull7 = false;
/* 376 */                 filter_value7 = true;
/* 377 */               }
/* 378 */             }
/* 379 */
/* 380 */             if (!filter_value7) {
/* 381 */               Object filter_obj4 = ((Expression) references[10]).eval(null);
/* 382 */               UTF8String filter_value10 = (UTF8String) filter_obj4;
/* 383 */               if (false) {
/* 384 */                 filter_isNull7 = true;
/* 385 */               } else if (scan_value2.equals(filter_value10)) {
/* 386 */                 filter_isNull7 = false;
/* 387 */                 filter_value7 = true;
/* 388 */               }
/* 389 */             }
/* 390 */
/* 391 */             if (!filter_value7) {
/* 392 */               Object filter_obj5 = ((Expression) references[11]).eval(null);
/* 393 */               UTF8String filter_value11 = (UTF8String) filter_obj5;
/* 394 */               if (false) {
/* 395 */                 filter_isNull7 = true;
/* 396 */               } else if (scan_value2.equals(filter_value11)) {
/* 397 */                 filter_isNull7 = false;
/* 398 */                 filter_value7 = true;
/* 399 */               }
/* 400 */             }
/* 401 */
/* 402 */           }
/* 403 */           if (!filter_isNull7 && !filter_value7) {
/* 404 */           } else if (!filter_isNull2 && !filter_isNull7) {
/* 405 */             filter_value1 = true;
/* 406 */           } else {
/* 407 */             filter_isNull1 = true;
/* 408 */           }
/* 409 */         }
/* 410 */         boolean filter_isNull = false;
/* 411 */         boolean filter_value = true;
/* 412 */
/* 413 */         if (!filter_isNull1 && filter_value1) {
/* 414 */         } else {
/* 415 */           boolean filter_value13 = false;
/* 416 */           boolean filter_isNull13 = scan_isNull3;
/* 417 */           if (!filter_isNull13) {
/* 418 */             if (!filter_value13) {
/* 419 */               Object filter_obj6 = ((Expression) references[12]).eval(null);
/* 420 */               UTF8String filter_value15 = (UTF8String) filter_obj6;
/* 421 */               if (false) {
/* 422 */                 filter_isNull13 = true;
/* 423 */               } else if (scan_value3.equals(filter_value15)) {
/* 424 */                 filter_isNull13 = false;
/* 425 */                 filter_value13 = true;
/* 426 */               }
/* 427 */             }
/* 428 */
/* 429 */             if (!filter_value13) {
/* 430 */               Object filter_obj7 = ((Expression) references[13]).eval(null);
/* 431 */               UTF8String filter_value16 = (UTF8String) filter_obj7;
/* 432 */               if (false) {
/* 433 */                 filter_isNull13 = true;
/* 434 */               } else if (scan_value3.equals(filter_value16)) {
/* 435 */                 filter_isNull13 = false;
/* 436 */                 filter_value13 = true;
/* 437 */               }
/* 438 */             }
/* 439 */
/* 440 */             if (!filter_value13) {
/* 441 */               Object filter_obj8 = ((Expression) references[14]).eval(null);
/* 442 */               UTF8String filter_value17 = (UTF8String) filter_obj8;
/* 443 */               if (false) {
/* 444 */                 filter_isNull13 = true;
/* 445 */               } else if (scan_value3.equals(filter_value17)) {
/* 446 */                 filter_isNull13 = false;
/* 447 */                 filter_value13 = true;
/* 448 */               }
/* 449 */             }
/* 450 */
/* 451 */           }
/* 452 */           boolean filter_isNull12 = false;
/* 453 */           boolean filter_value12 = false;
/* 454 */
/* 455 */           if (!filter_isNull13 && !filter_value13) {
/* 456 */           } else {
/* 457 */             boolean filter_value18 = false;
/* 458 */             boolean filter_isNull18 = scan_isNull2;
/* 459 */             if (!filter_isNull18) {
/* 460 */               if (!filter_value18) {
/* 461 */                 Object filter_obj9 = ((Expression) references[15]).eval(null);
/* 462 */                 UTF8String filter_value20 = (UTF8String) filter_obj9;
/* 463 */                 if (false) {
/* 464 */                   filter_isNull18 = true;
/* 465 */                 } else if (scan_value2.equals(filter_value20)) {
/* 466 */                   filter_isNull18 = false;
/* 467 */                   filter_value18 = true;
/* 468 */                 }
/* 469 */               }
/* 470 */
/* 471 */               if (!filter_value18) {
/* 472 */                 Object filter_obj10 = ((Expression) references[16]).eval(null);
/* 473 */                 UTF8String filter_value21 = (UTF8String) filter_obj10;
/* 474 */                 if (false) {
/* 475 */                   filter_isNull18 = true;
/* 476 */                 } else if (scan_value2.equals(filter_value21)) {
/* 477 */                   filter_isNull18 = false;
/* 478 */                   filter_value18 = true;
/* 479 */                 }
/* 480 */               }
/* 481 */
/* 482 */               if (!filter_value18) {
/* 483 */                 Object filter_obj11 = ((Expression) references[17]).eval(null);
/* 484 */                 UTF8String filter_value22 = (UTF8String) filter_obj11;
/* 485 */                 if (false) {
/* 486 */                   filter_isNull18 = true;
/* 487 */                 } else if (scan_value2.equals(filter_value22)) {
/* 488 */                   filter_isNull18 = false;
/* 489 */                   filter_value18 = true;
/* 490 */                 }
/* 491 */               }
/* 492 */
/* 493 */             }
/* 494 */             if (!filter_isNull18 && !filter_value18) {
/* 495 */             } else if (!filter_isNull13 && !filter_isNull18) {
/* 496 */               filter_value12 = true;
/* 497 */             } else {
/* 498 */               filter_isNull12 = true;
/* 499 */             }
/* 500 */           }
/* 501 */           if (!filter_isNull12 && filter_value12) {
/* 502 */           } else if (!filter_isNull1 && !filter_isNull12) {
/* 503 */             filter_value = false;
/* 504 */           } else {
/* 505 */             filter_isNull = true;
/* 506 */           }
/* 507 */         }
/* 508 */         if (filter_isNull || !filter_value) continue;
/* 509 */
/* 510 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 511 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 512 */
/* 513 */         if (!(!(scan_isNull))) continue;
/* 514 */
/* 515 */         filter_numOutputRows.add(1);
/* 516 */
/* 517 */         // generate join key for stream side
/* 518 */
/* 519 */         boolean bhj_isNull = false;
/* 520 */         long bhj_value = -1L;
/* 521 */         if (!false) {
/* 522 */           bhj_value = (long) scan_value;
/* 523 */         }
/* 524 */         // find matches from HashedRelation
/* 525 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 526 */         if (bhj_matched == null) continue;
/* 527 */
/* 528 */         bhj_numOutputRows.add(1);
/* 529 */
/* 530 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 531 */         int bhj_value5 = bhj_isNull5 ? -1 : (bhj_matched.getInt(3));
/* 532 */
/* 533 */         // generate join key for stream side
/* 534 */
/* 535 */         boolean bhj_isNull14 = bhj_isNull5;
/* 536 */         long bhj_value14 = -1L;
/* 537 */         if (!bhj_isNull5) {
/* 538 */           bhj_value14 = (long) bhj_value5;
/* 539 */         }
/* 540 */         // find matches from HashedRelation
/* 541 */         UnsafeRow bhj_matched1 = bhj_isNull14 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value14);
/* 542 */         if (bhj_matched1 == null) continue;
/* 543 */
/* 544 */         bhj_numOutputRows1.add(1);
/* 545 */
/* 546 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 547 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 548 */
/* 549 */         // generate join key for stream side
/* 550 */
/* 551 */         boolean bhj_isNull26 = bhj_isNull3;
/* 552 */         long bhj_value26 = -1L;
/* 553 */         if (!bhj_isNull3) {
/* 554 */           bhj_value26 = (long) bhj_value3;
/* 555 */         }
/* 556 */         // find matches from HashedRelation
/* 557 */         UnsafeRow bhj_matched2 = bhj_isNull26 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value26);
/* 558 */         if (bhj_matched2 == null) continue;
/* 559 */
/* 560 */         bhj_numOutputRows2.add(1);
/* 561 */
/* 562 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 563 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 564 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 565 */         double bhj_value4 = bhj_isNull4 ? -1.0 : (bhj_matched.getDouble(2));
/* 566 */         boolean bhj_isNull17 = bhj_matched1.isNullAt(1);
/* 567 */         int bhj_value17 = bhj_isNull17 ? -1 : (bhj_matched1.getInt(1));
/* 568 */         boolean bhj_isNull29 = bhj_matched2.isNullAt(1);
/* 569 */         UTF8String bhj_value29 = bhj_isNull29 ? null : (bhj_matched2.getUTF8String(1));
/* 570 */         boolean bhj_isNull30 = bhj_matched2.isNullAt(2);
/* 571 */         UTF8String bhj_value30 = bhj_isNull30 ? null : (bhj_matched2.getUTF8String(2));
/* 572 */
/* 573 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 574 */
/* 575 */         UnsafeRow agg_fastAggBuffer = null;
/* 576 */
/* 577 */         if (true) {
/* 578 */           if (!scan_isNull3 && !scan_isNull2 && !scan_isNull1 && !bhj_isNull29 && !bhj_isNull30 && !bhj_isNull17) {
/* 579 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 580 */               scan_value3, scan_value2, scan_value1, bhj_value29, bhj_value30, bhj_value17);
/* 581 */           }
/* 582 */         }
/* 583 */
/* 584 */         if (agg_fastAggBuffer == null) {
/* 585 */           // generate grouping key
/* 586 */           agg_holder.reset();
/* 587 */
/* 588 */           agg_rowWriter.zeroOutNullBytes();
/* 589 */
/* 590 */           if (scan_isNull3) {
/* 591 */             agg_rowWriter.setNullAt(0);
/* 592 */           } else {
/* 593 */             agg_rowWriter.write(0, scan_value3);
/* 594 */           }
/* 595 */
/* 596 */           if (scan_isNull2) {
/* 597 */             agg_rowWriter.setNullAt(1);
/* 598 */           } else {
/* 599 */             agg_rowWriter.write(1, scan_value2);
/* 600 */           }
/* 601 */
/* 602 */           if (scan_isNull1) {
/* 603 */             agg_rowWriter.setNullAt(2);
/* 604 */           } else {
/* 605 */             agg_rowWriter.write(2, scan_value1);
/* 606 */           }
/* 607 */
/* 608 */           if (bhj_isNull29) {
/* 609 */             agg_rowWriter.setNullAt(3);
/* 610 */           } else {
/* 611 */             agg_rowWriter.write(3, bhj_value29);
/* 612 */           }
/* 613 */
/* 614 */           if (bhj_isNull30) {
/* 615 */             agg_rowWriter.setNullAt(4);
/* 616 */           } else {
/* 617 */             agg_rowWriter.write(4, bhj_value30);
/* 618 */           }
/* 619 */
/* 620 */           if (bhj_isNull17) {
/* 621 */             agg_rowWriter.setNullAt(5);
/* 622 */           } else {
/* 623 */             agg_rowWriter.write(5, bhj_value17);
/* 624 */           }
/* 625 */           agg_result6.setTotalSize(agg_holder.totalSize());
/* 626 */           agg_value16 = 42;
/* 627 */
/* 628 */           if (!scan_isNull3) {
/* 629 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value3.getBaseObject(), scan_value3.getBaseOffset(), scan_value3.numBytes(), agg_value16);
/* 630 */           }
/* 631 */
/* 632 */           if (!scan_isNull2) {
/* 633 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value2.getBaseObject(), scan_value2.getBaseOffset(), scan_value2.numBytes(), agg_value16);
/* 634 */           }
/* 635 */
/* 636 */           if (!scan_isNull1) {
/* 637 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value1.getBaseObject(), scan_value1.getBaseOffset(), scan_value1.numBytes(), agg_value16);
/* 638 */           }
/* 639 */
/* 640 */           if (!bhj_isNull29) {
/* 641 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value29.getBaseObject(), bhj_value29.getBaseOffset(), bhj_value29.numBytes(), agg_value16);
/* 642 */           }
/* 643 */
/* 644 */           if (!bhj_isNull30) {
/* 645 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value30.getBaseObject(), bhj_value30.getBaseOffset(), bhj_value30.numBytes(), agg_value16);
/* 646 */           }
/* 647 */
/* 648 */           if (!bhj_isNull17) {
/* 649 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value17, agg_value16);
/* 650 */           }
/* 651 */           if (true) {
/* 652 */             // try to get the buffer from hash map
/* 653 */             agg_unsafeRowAggBuffer =
/* 654 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result6, agg_value16);
/* 655 */           }
/* 656 */           if (agg_unsafeRowAggBuffer == null) {
/* 657 */             if (agg_sorter == null) {
/* 658 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 659 */             } else {
/* 660 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 661 */             }
/* 662 */
/* 663 */             // the hash map had be spilled, it should have enough memory now,
/* 664 */             // try  to allocate buffer again.
/* 665 */             agg_unsafeRowAggBuffer =
/* 666 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result6, agg_value16);
/* 667 */             if (agg_unsafeRowAggBuffer == null) {
/* 668 */               // failed to allocate the first page
/* 669 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 670 */             }
/* 671 */           }
/* 672 */         }
/* 673 */
/* 674 */         if (agg_fastAggBuffer != null) {
/* 675 */           // update fast row
/* 676 */
/* 677 */           // common sub-expressions
/* 678 */           boolean agg_isNull35 = bhj_isNull4;
/* 679 */           double agg_value37 = -1.0;
/* 680 */           if (!bhj_isNull4) {
/* 681 */             agg_value37 = bhj_value4;
/* 682 */           }
/* 683 */           boolean agg_isNull37 = false;
/* 684 */           double agg_value39 = -1.0;
/* 685 */           if (!false) {
/* 686 */             agg_value39 = (double) 0;
/* 687 */           }
/* 688 */           // evaluate aggregate function
/* 689 */           boolean agg_isNull40 = true;
/* 690 */           double agg_value42 = -1.0;
/* 691 */
/* 692 */           boolean agg_isNull42 = agg_fastAggBuffer.isNullAt(0);
/* 693 */           double agg_value44 = agg_isNull42 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 694 */           boolean agg_isNull41 = agg_isNull42;
/* 695 */           double agg_value43 = agg_value44;
/* 696 */           if (agg_isNull41) {
/* 697 */             if (!agg_isNull37) {
/* 698 */               agg_isNull41 = false;
/* 699 */               agg_value43 = agg_value39;
/* 700 */             }
/* 701 */           }
/* 702 */
/* 703 */           if (!agg_isNull35) {
/* 704 */             agg_isNull40 = false; // resultCode could change nullability.
/* 705 */             agg_value42 = agg_value43 + agg_value37;
/* 706 */
/* 707 */           }
/* 708 */           boolean agg_isNull39 = agg_isNull40;
/* 709 */           double agg_value41 = agg_value42;
/* 710 */           if (agg_isNull39) {
/* 711 */             boolean agg_isNull43 = agg_fastAggBuffer.isNullAt(0);
/* 712 */             double agg_value45 = agg_isNull43 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 713 */             if (!agg_isNull43) {
/* 714 */               agg_isNull39 = false;
/* 715 */               agg_value41 = agg_value45;
/* 716 */             }
/* 717 */           }
/* 718 */           boolean agg_isNull45 = true;
/* 719 */           double agg_value47 = -1.0;
/* 720 */
/* 721 */           boolean agg_isNull47 = agg_fastAggBuffer.isNullAt(1);
/* 722 */           double agg_value49 = agg_isNull47 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 723 */           boolean agg_isNull46 = agg_isNull47;
/* 724 */           double agg_value48 = agg_value49;
/* 725 */           if (agg_isNull46) {
/* 726 */             if (!agg_isNull37) {
/* 727 */               agg_isNull46 = false;
/* 728 */               agg_value48 = agg_value39;
/* 729 */             }
/* 730 */           }
/* 731 */
/* 732 */           if (!agg_isNull35) {
/* 733 */             agg_isNull45 = false; // resultCode could change nullability.
/* 734 */             agg_value47 = agg_value48 + agg_value37;
/* 735 */
/* 736 */           }
/* 737 */           boolean agg_isNull44 = agg_isNull45;
/* 738 */           double agg_value46 = agg_value47;
/* 739 */           if (agg_isNull44) {
/* 740 */             boolean agg_isNull48 = agg_fastAggBuffer.isNullAt(1);
/* 741 */             double agg_value50 = agg_isNull48 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 742 */             if (!agg_isNull48) {
/* 743 */               agg_isNull44 = false;
/* 744 */               agg_value46 = agg_value50;
/* 745 */             }
/* 746 */           }
/* 747 */           // update fast row
/* 748 */           if (!agg_isNull39) {
/* 749 */             agg_fastAggBuffer.setDouble(0, agg_value41);
/* 750 */           } else {
/* 751 */             agg_fastAggBuffer.setNullAt(0);
/* 752 */           }
/* 753 */
/* 754 */           if (!agg_isNull44) {
/* 755 */             agg_fastAggBuffer.setDouble(1, agg_value46);
/* 756 */           } else {
/* 757 */             agg_fastAggBuffer.setNullAt(1);
/* 758 */           }
/* 759 */
/* 760 */         } else {
/* 761 */           // update unsafe row
/* 762 */
/* 763 */           // common sub-expressions
/* 764 */           boolean agg_isNull21 = bhj_isNull4;
/* 765 */           double agg_value23 = -1.0;
/* 766 */           if (!bhj_isNull4) {
/* 767 */             agg_value23 = bhj_value4;
/* 768 */           }
/* 769 */           boolean agg_isNull23 = false;
/* 770 */           double agg_value25 = -1.0;
/* 771 */           if (!false) {
/* 772 */             agg_value25 = (double) 0;
/* 773 */           }
/* 774 */           // evaluate aggregate function
/* 775 */           boolean agg_isNull26 = true;
/* 776 */           double agg_value28 = -1.0;
/* 777 */
/* 778 */           boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 779 */           double agg_value30 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 780 */           boolean agg_isNull27 = agg_isNull28;
/* 781 */           double agg_value29 = agg_value30;
/* 782 */           if (agg_isNull27) {
/* 783 */             if (!agg_isNull23) {
/* 784 */               agg_isNull27 = false;
/* 785 */               agg_value29 = agg_value25;
/* 786 */             }
/* 787 */           }
/* 788 */
/* 789 */           if (!agg_isNull21) {
/* 790 */             agg_isNull26 = false; // resultCode could change nullability.
/* 791 */             agg_value28 = agg_value29 + agg_value23;
/* 792 */
/* 793 */           }
/* 794 */           boolean agg_isNull25 = agg_isNull26;
/* 795 */           double agg_value27 = agg_value28;
/* 796 */           if (agg_isNull25) {
/* 797 */             boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 798 */             double agg_value31 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 799 */             if (!agg_isNull29) {
/* 800 */               agg_isNull25 = false;
/* 801 */               agg_value27 = agg_value31;
/* 802 */             }
/* 803 */           }
/* 804 */           boolean agg_isNull31 = true;
/* 805 */           double agg_value33 = -1.0;
/* 806 */
/* 807 */           boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 808 */           double agg_value35 = agg_isNull33 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 809 */           boolean agg_isNull32 = agg_isNull33;
/* 810 */           double agg_value34 = agg_value35;
/* 811 */           if (agg_isNull32) {
/* 812 */             if (!agg_isNull23) {
/* 813 */               agg_isNull32 = false;
/* 814 */               agg_value34 = agg_value25;
/* 815 */             }
/* 816 */           }
/* 817 */
/* 818 */           if (!agg_isNull21) {
/* 819 */             agg_isNull31 = false; // resultCode could change nullability.
/* 820 */             agg_value33 = agg_value34 + agg_value23;
/* 821 */
/* 822 */           }
/* 823 */           boolean agg_isNull30 = agg_isNull31;
/* 824 */           double agg_value32 = agg_value33;
/* 825 */           if (agg_isNull30) {
/* 826 */             boolean agg_isNull34 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 827 */             double agg_value36 = agg_isNull34 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 828 */             if (!agg_isNull34) {
/* 829 */               agg_isNull30 = false;
/* 830 */               agg_value32 = agg_value36;
/* 831 */             }
/* 832 */           }
/* 833 */           // update unsafe row buffer
/* 834 */           if (!agg_isNull25) {
/* 835 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value27);
/* 836 */           } else {
/* 837 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 838 */           }
/* 839 */
/* 840 */           if (!agg_isNull30) {
/* 841 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value32);
/* 842 */           } else {
/* 843 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 844 */           }
/* 845 */
/* 846 */         }
/* 847 */         if (shouldStop()) return;
/* 848 */       }
/* 849 */       scan_batch = null;
/* 850 */       scan_nextBatch();
/* 851 */     }
/* 852 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 853 */     scan_scanTime1 = 0;
/* 854 */
/* 855 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 856 */
/* 857 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 858 */   }
/* 859 */
/* 860 */   private void wholestagecodegen_init_2() {
/* 861 */     project_result1 = new UnsafeRow(6);
/* 862 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 96);
/* 863 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 6);
/* 864 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[20];
/* 865 */
/* 866 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 867 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 868 */
/* 869 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[21];
/* 870 */     bhj_result1 = new UnsafeRow(8);
/* 871 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 96);
/* 872 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 8);
/* 873 */     project_result2 = new UnsafeRow(6);
/* 874 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 96);
/* 875 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 876 */
/* 877 */   }
/* 878 */
/* 879 */   private void wholestagecodegen_init_1() {
/* 880 */     filter_result = new UnsafeRow(4);
/* 881 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 96);
/* 882 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 883 */     project_result = new UnsafeRow(4);
/* 884 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 885 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 886 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[18];
/* 887 */
/* 888 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 889 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 890 */
/* 891 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[19];
/* 892 */     bhj_result = new UnsafeRow(8);
/* 893 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 96);
/* 894 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 8);
/* 895 */
/* 896 */   }
/* 897 */
/* 898 */   private void wholestagecodegen_init_4() {
/* 899 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 900 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[24];
/* 901 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[25];
/* 902 */
/* 903 */   }
/* 904 */
/* 905 */   protected void processNext() throws java.io.IOException {
/* 906 */     if (!agg_initAgg) {
/* 907 */       agg_initAgg = true;
/* 908 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 909 */       agg_doAggregateWithKeys();
/* 910 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 911 */     }
/* 912 */
/* 913 */     // output the result
/* 914 */
/* 915 */     while (agg_fastHashMapIter.next()) {
/* 916 */       wholestagecodegen_numOutputRows.add(1);
/* 917 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 918 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 919 */
/* 920 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 921 */
/* 922 */       append(agg_resultRow);
/* 923 */
/* 924 */       if (shouldStop()) return;
/* 925 */     }
/* 926 */     agg_fastHashMap.close();
/* 927 */
/* 928 */     while (agg_mapIter.next()) {
/* 929 */       wholestagecodegen_numOutputRows.add(1);
/* 930 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 931 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 932 */
/* 933 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 934 */
/* 935 */       append(agg_resultRow);
/* 936 */
/* 937 */       if (shouldStop()) return;
/* 938 */     }
/* 939 */
/* 940 */     agg_mapIter.close();
/* 941 */     if (agg_sorter == null) {
/* 942 */       agg_hashMap.free();
/* 943 */     }
/* 944 */   }
/* 945 */ }
