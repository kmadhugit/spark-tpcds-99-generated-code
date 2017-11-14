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
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 030 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 031 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 032 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 033 */   private UnsafeRow scan_result;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 036 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 037 */   private UnsafeRow filter_result;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 040 */   private UnsafeRow project_result;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 043 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 044 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 045 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 046 */   private UnsafeRow bhj_result;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 049 */   private UnsafeRow project_result1;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 052 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 053 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 054 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 055 */   private UnsafeRow bhj_result1;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 058 */   private UnsafeRow project_result2;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 061 */   private UnsafeRow agg_result8;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 064 */   private int agg_value18;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 066 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 067 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 068 */
/* 069 */   public GeneratedIterator(Object[] references) {
/* 070 */     this.references = references;
/* 071 */   }
/* 072 */
/* 073 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 074 */     partitionIndex = index;
/* 075 */     this.inputs = inputs;
/* 076 */     wholestagecodegen_init_0();
/* 077 */     wholestagecodegen_init_1();
/* 078 */     wholestagecodegen_init_2();
/* 079 */     wholestagecodegen_init_3();
/* 080 */
/* 081 */   }
/* 082 */
/* 083 */   private void wholestagecodegen_init_0() {
/* 084 */     agg_initAgg = false;
/* 085 */
/* 086 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 087 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 088 */
/* 089 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 090 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 091 */     scan_input = inputs[0];
/* 092 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 093 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 094 */     scan_scanTime1 = 0;
/* 095 */     scan_batch = null;
/* 096 */     scan_batchIdx = 0;
/* 097 */     scan_colInstance0 = null;
/* 098 */     scan_colInstance1 = null;
/* 099 */     scan_colInstance2 = null;
/* 100 */     scan_colInstance3 = null;
/* 101 */     scan_colInstance4 = null;
/* 102 */     scan_colInstance5 = null;
/* 103 */     scan_colInstance6 = null;
/* 104 */     scan_colInstance7 = null;
/* 105 */     scan_result = new UnsafeRow(8);
/* 106 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 224);
/* 107 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 8);
/* 108 */
/* 109 */   }
/* 110 */
/* 111 */   private void wholestagecodegen_init_3() {
/* 112 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 10);
/* 113 */     agg_result8 = new UnsafeRow(8);
/* 114 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result8, 224);
/* 115 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 8);
/* 116 */
/* 117 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 118 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 119 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 120 */
/* 121 */   }
/* 122 */
/* 123 */   private void scan_nextBatch() throws java.io.IOException {
/* 124 */     long getBatchStart = System.nanoTime();
/* 125 */     if (scan_input.hasNext()) {
/* 126 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 127 */       scan_numOutputRows.add(scan_batch.numRows());
/* 128 */       scan_batchIdx = 0;
/* 129 */       scan_colInstance0 = scan_batch.column(0);
/* 130 */       scan_colInstance1 = scan_batch.column(1);
/* 131 */       scan_colInstance2 = scan_batch.column(2);
/* 132 */       scan_colInstance3 = scan_batch.column(3);
/* 133 */       scan_colInstance4 = scan_batch.column(4);
/* 134 */       scan_colInstance5 = scan_batch.column(5);
/* 135 */       scan_colInstance6 = scan_batch.column(6);
/* 136 */       scan_colInstance7 = scan_batch.column(7);
/* 137 */
/* 138 */     }
/* 139 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 140 */   }
/* 141 */
/* 142 */   public class agg_FastHashMap {
/* 143 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 144 */     private int[] buckets;
/* 145 */     private int capacity = 1 << 16;
/* 146 */     private double loadFactor = 0.5;
/* 147 */     private int numBuckets = (int) (capacity / loadFactor);
/* 148 */     private int maxSteps = 2;
/* 149 */     private int numRows = 0;
/* 150 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("c_customer_id", org.apache.spark.sql.types.DataTypes.StringType)
/* 151 */     .add("c_first_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 152 */     .add("c_last_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 153 */     .add("d_year", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 154 */     .add("c_preferred_cust_flag", org.apache.spark.sql.types.DataTypes.StringType)
/* 155 */     .add("c_birth_country", org.apache.spark.sql.types.DataTypes.StringType)
/* 156 */     .add("c_login", org.apache.spark.sql.types.DataTypes.StringType)
/* 157 */     .add("c_email_address", org.apache.spark.sql.types.DataTypes.StringType);
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
/* 181 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, UTF8String agg_key7) {
/* 182 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7);
/* 183 */       int step = 0;
/* 184 */       int idx = (int) h & (numBuckets - 1);
/* 185 */       while (step < maxSteps) {
/* 186 */         // Return bucket index if it's either an empty slot or already contains the key
/* 187 */         if (buckets[idx] == -1) {
/* 188 */           if (numRows < capacity && !isBatchFull) {
/* 189 */             // creating the unsafe for new entry
/* 190 */             UnsafeRow agg_result = new UnsafeRow(8);
/* 191 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 192 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 193 */               224);
/* 194 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 195 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 196 */               agg_holder,
/* 197 */               8);
/* 198 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 199 */             agg_rowWriter.zeroOutNullBytes();
/* 200 */             agg_rowWriter.write(0, agg_key);
/* 201 */             agg_rowWriter.write(1, agg_key1);
/* 202 */             agg_rowWriter.write(2, agg_key2);
/* 203 */             agg_rowWriter.write(3, agg_key3);
/* 204 */             agg_rowWriter.write(4, agg_key4);
/* 205 */             agg_rowWriter.write(5, agg_key5);
/* 206 */             agg_rowWriter.write(6, agg_key6);
/* 207 */             agg_rowWriter.write(7, agg_key7);
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
/* 225 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7)) {
/* 226 */           return batch.getValueRow(buckets[idx]);
/* 227 */         }
/* 228 */         idx = (idx + 1) & (numBuckets - 1);
/* 229 */         step++;
/* 230 */       }
/* 231 */       // Didn't find it
/* 232 */       return null;
/* 233 */     }
/* 234 */
/* 235 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, UTF8String agg_key7) {
/* 236 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 237 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getInt(3) == agg_key3) && (row.getUTF8String(4).equals(agg_key4)) && (row.getUTF8String(5).equals(agg_key5)) && (row.getUTF8String(6).equals(agg_key6)) && (row.getUTF8String(7).equals(agg_key7));
/* 238 */     }
/* 239 */
/* 240 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, UTF8String agg_key7) {
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
/* 273 */       int agg_result4 = 0;
/* 274 */       byte[] agg_bytes3 = agg_key4.getBytes();
/* 275 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 276 */         int agg_hash4 = agg_bytes3[i];
/* 277 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash4 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 278 */       }
/* 279 */
/* 280 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 281 */
/* 282 */       int agg_result5 = 0;
/* 283 */       byte[] agg_bytes4 = agg_key5.getBytes();
/* 284 */       for (int i = 0; i < agg_bytes4.length; i++) {
/* 285 */         int agg_hash5 = agg_bytes4[i];
/* 286 */         agg_result5 = (agg_result5 ^ (0x9e3779b9)) + agg_hash5 + (agg_result5 << 6) + (agg_result5 >>> 2);
/* 287 */       }
/* 288 */
/* 289 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 290 */
/* 291 */       int agg_result6 = 0;
/* 292 */       byte[] agg_bytes5 = agg_key6.getBytes();
/* 293 */       for (int i = 0; i < agg_bytes5.length; i++) {
/* 294 */         int agg_hash6 = agg_bytes5[i];
/* 295 */         agg_result6 = (agg_result6 ^ (0x9e3779b9)) + agg_hash6 + (agg_result6 << 6) + (agg_result6 >>> 2);
/* 296 */       }
/* 297 */
/* 298 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result6 + (agg_hash << 6) + (agg_hash >>> 2);
/* 299 */
/* 300 */       int agg_result7 = 0;
/* 301 */       byte[] agg_bytes6 = agg_key7.getBytes();
/* 302 */       for (int i = 0; i < agg_bytes6.length; i++) {
/* 303 */         int agg_hash7 = agg_bytes6[i];
/* 304 */         agg_result7 = (agg_result7 ^ (0x9e3779b9)) + agg_hash7 + (agg_result7 << 6) + (agg_result7 >>> 2);
/* 305 */       }
/* 306 */
/* 307 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result7 + (agg_hash << 6) + (agg_hash >>> 2);
/* 308 */
/* 309 */       return agg_hash;
/* 310 */     }
/* 311 */
/* 312 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 313 */       return batch.rowIterator();
/* 314 */     }
/* 315 */
/* 316 */     public void close() {
/* 317 */       batch.close();
/* 318 */     }
/* 319 */
/* 320 */   }
/* 321 */
/* 322 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 323 */     agg_hashMap = agg_plan.createHashMap();
/* 324 */
/* 325 */     if (scan_batch == null) {
/* 326 */       scan_nextBatch();
/* 327 */     }
/* 328 */     while (scan_batch != null) {
/* 329 */       int numRows = scan_batch.numRows();
/* 330 */       while (scan_batchIdx < numRows) {
/* 331 */         int scan_rowIdx = scan_batchIdx++;
/* 332 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 333 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 334 */
/* 335 */         if (!(!(scan_isNull))) continue;
/* 336 */
/* 337 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 338 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 339 */
/* 340 */         if (!(!(scan_isNull1))) continue;
/* 341 */
/* 342 */         filter_numOutputRows.add(1);
/* 343 */
/* 344 */         // generate join key for stream side
/* 345 */
/* 346 */         boolean bhj_isNull = false;
/* 347 */         long bhj_value = -1L;
/* 348 */         if (!false) {
/* 349 */           bhj_value = (long) scan_value;
/* 350 */         }
/* 351 */         // find matches from HashedRelation
/* 352 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 353 */         if (bhj_matched == null) continue;
/* 354 */
/* 355 */         bhj_numOutputRows.add(1);
/* 356 */
/* 357 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 358 */         int bhj_value5 = bhj_isNull5 ? -1 : (bhj_matched.getInt(3));
/* 359 */
/* 360 */         // generate join key for stream side
/* 361 */
/* 362 */         boolean bhj_isNull18 = bhj_isNull5;
/* 363 */         long bhj_value18 = -1L;
/* 364 */         if (!bhj_isNull5) {
/* 365 */           bhj_value18 = (long) bhj_value5;
/* 366 */         }
/* 367 */         // find matches from HashedRelation
/* 368 */         UnsafeRow bhj_matched1 = bhj_isNull18 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value18);
/* 369 */         if (bhj_matched1 == null) continue;
/* 370 */
/* 371 */         bhj_numOutputRows1.add(1);
/* 372 */
/* 373 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 374 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 375 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 376 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 377 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 378 */         UTF8String scan_value4 = scan_isNull4 ? null : (scan_colInstance4.getUTF8String(scan_rowIdx));
/* 379 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 380 */         UTF8String scan_value5 = scan_isNull5 ? null : (scan_colInstance5.getUTF8String(scan_rowIdx));
/* 381 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 382 */         UTF8String scan_value6 = scan_isNull6 ? null : (scan_colInstance6.getUTF8String(scan_rowIdx));
/* 383 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 384 */         UTF8String scan_value7 = scan_isNull7 ? null : (scan_colInstance7.getUTF8String(scan_rowIdx));
/* 385 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 386 */         double bhj_value3 = bhj_isNull3 ? -1.0 : (bhj_matched.getDouble(1));
/* 387 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 388 */         double bhj_value4 = bhj_isNull4 ? -1.0 : (bhj_matched.getDouble(2));
/* 389 */         boolean bhj_isNull21 = bhj_matched1.isNullAt(1);
/* 390 */         int bhj_value21 = bhj_isNull21 ? -1 : (bhj_matched1.getInt(1));
/* 391 */
/* 392 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 393 */
/* 394 */         UnsafeRow agg_fastAggBuffer = null;
/* 395 */
/* 396 */         if (true) {
/* 397 */           if (!false && !scan_isNull2 && !scan_isNull3 && !bhj_isNull21 && !scan_isNull4 && !scan_isNull5 && !scan_isNull6 && !scan_isNull7) {
/* 398 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 399 */               scan_value1, scan_value2, scan_value3, bhj_value21, scan_value4, scan_value5, scan_value6, scan_value7);
/* 400 */           }
/* 401 */         }
/* 402 */
/* 403 */         if (agg_fastAggBuffer == null) {
/* 404 */           // generate grouping key
/* 405 */           agg_holder.reset();
/* 406 */
/* 407 */           agg_rowWriter.zeroOutNullBytes();
/* 408 */
/* 409 */           agg_rowWriter.write(0, scan_value1);
/* 410 */
/* 411 */           if (scan_isNull2) {
/* 412 */             agg_rowWriter.setNullAt(1);
/* 413 */           } else {
/* 414 */             agg_rowWriter.write(1, scan_value2);
/* 415 */           }
/* 416 */
/* 417 */           if (scan_isNull3) {
/* 418 */             agg_rowWriter.setNullAt(2);
/* 419 */           } else {
/* 420 */             agg_rowWriter.write(2, scan_value3);
/* 421 */           }
/* 422 */
/* 423 */           if (bhj_isNull21) {
/* 424 */             agg_rowWriter.setNullAt(3);
/* 425 */           } else {
/* 426 */             agg_rowWriter.write(3, bhj_value21);
/* 427 */           }
/* 428 */
/* 429 */           if (scan_isNull4) {
/* 430 */             agg_rowWriter.setNullAt(4);
/* 431 */           } else {
/* 432 */             agg_rowWriter.write(4, scan_value4);
/* 433 */           }
/* 434 */
/* 435 */           if (scan_isNull5) {
/* 436 */             agg_rowWriter.setNullAt(5);
/* 437 */           } else {
/* 438 */             agg_rowWriter.write(5, scan_value5);
/* 439 */           }
/* 440 */
/* 441 */           if (scan_isNull6) {
/* 442 */             agg_rowWriter.setNullAt(6);
/* 443 */           } else {
/* 444 */             agg_rowWriter.write(6, scan_value6);
/* 445 */           }
/* 446 */
/* 447 */           if (scan_isNull7) {
/* 448 */             agg_rowWriter.setNullAt(7);
/* 449 */           } else {
/* 450 */             agg_rowWriter.write(7, scan_value7);
/* 451 */           }
/* 452 */           agg_result8.setTotalSize(agg_holder.totalSize());
/* 453 */           agg_value18 = 42;
/* 454 */
/* 455 */           if (!false) {
/* 456 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value1.getBaseObject(), scan_value1.getBaseOffset(), scan_value1.numBytes(), agg_value18);
/* 457 */           }
/* 458 */
/* 459 */           if (!scan_isNull2) {
/* 460 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value2.getBaseObject(), scan_value2.getBaseOffset(), scan_value2.numBytes(), agg_value18);
/* 461 */           }
/* 462 */
/* 463 */           if (!scan_isNull3) {
/* 464 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value3.getBaseObject(), scan_value3.getBaseOffset(), scan_value3.numBytes(), agg_value18);
/* 465 */           }
/* 466 */
/* 467 */           if (!bhj_isNull21) {
/* 468 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value21, agg_value18);
/* 469 */           }
/* 470 */
/* 471 */           if (!scan_isNull4) {
/* 472 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value4.getBaseObject(), scan_value4.getBaseOffset(), scan_value4.numBytes(), agg_value18);
/* 473 */           }
/* 474 */
/* 475 */           if (!scan_isNull5) {
/* 476 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value5.getBaseObject(), scan_value5.getBaseOffset(), scan_value5.numBytes(), agg_value18);
/* 477 */           }
/* 478 */
/* 479 */           if (!scan_isNull6) {
/* 480 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value6.getBaseObject(), scan_value6.getBaseOffset(), scan_value6.numBytes(), agg_value18);
/* 481 */           }
/* 482 */
/* 483 */           if (!scan_isNull7) {
/* 484 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value7.getBaseObject(), scan_value7.getBaseOffset(), scan_value7.numBytes(), agg_value18);
/* 485 */           }
/* 486 */           if (true) {
/* 487 */             // try to get the buffer from hash map
/* 488 */             agg_unsafeRowAggBuffer =
/* 489 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result8, agg_value18);
/* 490 */           }
/* 491 */           if (agg_unsafeRowAggBuffer == null) {
/* 492 */             if (agg_sorter == null) {
/* 493 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 494 */             } else {
/* 495 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 496 */             }
/* 497 */
/* 498 */             // the hash map had be spilled, it should have enough memory now,
/* 499 */             // try  to allocate buffer again.
/* 500 */             agg_unsafeRowAggBuffer =
/* 501 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result8, agg_value18);
/* 502 */             if (agg_unsafeRowAggBuffer == null) {
/* 503 */               // failed to allocate the first page
/* 504 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 505 */             }
/* 506 */           }
/* 507 */         }
/* 508 */
/* 509 */         if (agg_fastAggBuffer != null) {
/* 510 */           // update fast row
/* 511 */
/* 512 */           // common sub-expressions
/* 513 */
/* 514 */           // evaluate aggregate function
/* 515 */           boolean agg_isNull38 = true;
/* 516 */           double agg_value39 = -1.0;
/* 517 */
/* 518 */           boolean agg_isNull40 = agg_fastAggBuffer.isNullAt(0);
/* 519 */           double agg_value41 = agg_isNull40 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 520 */           boolean agg_isNull39 = agg_isNull40;
/* 521 */           double agg_value40 = agg_value41;
/* 522 */           if (agg_isNull39) {
/* 523 */             boolean agg_isNull41 = false;
/* 524 */             double agg_value42 = -1.0;
/* 525 */             if (!false) {
/* 526 */               agg_value42 = (double) 0;
/* 527 */             }
/* 528 */             if (!agg_isNull41) {
/* 529 */               agg_isNull39 = false;
/* 530 */               agg_value40 = agg_value42;
/* 531 */             }
/* 532 */           }
/* 533 */
/* 534 */           boolean agg_isNull44 = true;
/* 535 */           double agg_value45 = -1.0;
/* 536 */
/* 537 */           if (!bhj_isNull4) {
/* 538 */             if (!bhj_isNull3) {
/* 539 */               agg_isNull44 = false; // resultCode could change nullability.
/* 540 */               agg_value45 = bhj_value4 - bhj_value3;
/* 541 */
/* 542 */             }
/* 543 */
/* 544 */           }
/* 545 */           boolean agg_isNull43 = agg_isNull44;
/* 546 */           double agg_value44 = -1.0;
/* 547 */           if (!agg_isNull44) {
/* 548 */             agg_value44 = agg_value45;
/* 549 */           }
/* 550 */           if (!agg_isNull43) {
/* 551 */             agg_isNull38 = false; // resultCode could change nullability.
/* 552 */             agg_value39 = agg_value40 + agg_value44;
/* 553 */
/* 554 */           }
/* 555 */           boolean agg_isNull37 = agg_isNull38;
/* 556 */           double agg_value38 = agg_value39;
/* 557 */           if (agg_isNull37) {
/* 558 */             boolean agg_isNull47 = agg_fastAggBuffer.isNullAt(0);
/* 559 */             double agg_value48 = agg_isNull47 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 560 */             if (!agg_isNull47) {
/* 561 */               agg_isNull37 = false;
/* 562 */               agg_value38 = agg_value48;
/* 563 */             }
/* 564 */           }
/* 565 */           // update fast row
/* 566 */           if (!agg_isNull37) {
/* 567 */             agg_fastAggBuffer.setDouble(0, agg_value38);
/* 568 */           } else {
/* 569 */             agg_fastAggBuffer.setNullAt(0);
/* 570 */           }
/* 571 */
/* 572 */         } else {
/* 573 */           // update unsafe row
/* 574 */
/* 575 */           // common sub-expressions
/* 576 */
/* 577 */           // evaluate aggregate function
/* 578 */           boolean agg_isNull27 = true;
/* 579 */           double agg_value28 = -1.0;
/* 580 */
/* 581 */           boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 582 */           double agg_value30 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 583 */           boolean agg_isNull28 = agg_isNull29;
/* 584 */           double agg_value29 = agg_value30;
/* 585 */           if (agg_isNull28) {
/* 586 */             boolean agg_isNull30 = false;
/* 587 */             double agg_value31 = -1.0;
/* 588 */             if (!false) {
/* 589 */               agg_value31 = (double) 0;
/* 590 */             }
/* 591 */             if (!agg_isNull30) {
/* 592 */               agg_isNull28 = false;
/* 593 */               agg_value29 = agg_value31;
/* 594 */             }
/* 595 */           }
/* 596 */
/* 597 */           boolean agg_isNull33 = true;
/* 598 */           double agg_value34 = -1.0;
/* 599 */
/* 600 */           if (!bhj_isNull4) {
/* 601 */             if (!bhj_isNull3) {
/* 602 */               agg_isNull33 = false; // resultCode could change nullability.
/* 603 */               agg_value34 = bhj_value4 - bhj_value3;
/* 604 */
/* 605 */             }
/* 606 */
/* 607 */           }
/* 608 */           boolean agg_isNull32 = agg_isNull33;
/* 609 */           double agg_value33 = -1.0;
/* 610 */           if (!agg_isNull33) {
/* 611 */             agg_value33 = agg_value34;
/* 612 */           }
/* 613 */           if (!agg_isNull32) {
/* 614 */             agg_isNull27 = false; // resultCode could change nullability.
/* 615 */             agg_value28 = agg_value29 + agg_value33;
/* 616 */
/* 617 */           }
/* 618 */           boolean agg_isNull26 = agg_isNull27;
/* 619 */           double agg_value27 = agg_value28;
/* 620 */           if (agg_isNull26) {
/* 621 */             boolean agg_isNull36 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 622 */             double agg_value37 = agg_isNull36 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 623 */             if (!agg_isNull36) {
/* 624 */               agg_isNull26 = false;
/* 625 */               agg_value27 = agg_value37;
/* 626 */             }
/* 627 */           }
/* 628 */           // update unsafe row buffer
/* 629 */           if (!agg_isNull26) {
/* 630 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value27);
/* 631 */           } else {
/* 632 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 633 */           }
/* 634 */
/* 635 */         }
/* 636 */         if (shouldStop()) return;
/* 637 */       }
/* 638 */       scan_batch = null;
/* 639 */       scan_nextBatch();
/* 640 */     }
/* 641 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 642 */     scan_scanTime1 = 0;
/* 643 */
/* 644 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 645 */
/* 646 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 647 */   }
/* 648 */
/* 649 */   private void wholestagecodegen_init_2() {
/* 650 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 12);
/* 651 */     project_result1 = new UnsafeRow(10);
/* 652 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 224);
/* 653 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 10);
/* 654 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 655 */
/* 656 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 657 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 658 */
/* 659 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 660 */     bhj_result1 = new UnsafeRow(12);
/* 661 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 224);
/* 662 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 12);
/* 663 */     project_result2 = new UnsafeRow(10);
/* 664 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 224);
/* 665 */
/* 666 */   }
/* 667 */
/* 668 */   private void wholestagecodegen_init_1() {
/* 669 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 670 */     filter_result = new UnsafeRow(8);
/* 671 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 224);
/* 672 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 8);
/* 673 */     project_result = new UnsafeRow(8);
/* 674 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 224);
/* 675 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
/* 676 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 677 */
/* 678 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 679 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 680 */
/* 681 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 682 */     bhj_result = new UnsafeRow(12);
/* 683 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 224);
/* 684 */
/* 685 */   }
/* 686 */
/* 687 */   protected void processNext() throws java.io.IOException {
/* 688 */     if (!agg_initAgg) {
/* 689 */       agg_initAgg = true;
/* 690 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 691 */       agg_doAggregateWithKeys();
/* 692 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 693 */     }
/* 694 */
/* 695 */     // output the result
/* 696 */
/* 697 */     while (agg_fastHashMapIter.next()) {
/* 698 */       wholestagecodegen_numOutputRows.add(1);
/* 699 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 700 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 701 */
/* 702 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 703 */
/* 704 */       append(agg_resultRow);
/* 705 */
/* 706 */       if (shouldStop()) return;
/* 707 */     }
/* 708 */     agg_fastHashMap.close();
/* 709 */
/* 710 */     while (agg_mapIter.next()) {
/* 711 */       wholestagecodegen_numOutputRows.add(1);
/* 712 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 713 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 714 */
/* 715 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 716 */
/* 717 */       append(agg_resultRow);
/* 718 */
/* 719 */       if (shouldStop()) return;
/* 720 */     }
/* 721 */
/* 722 */     agg_mapIter.close();
/* 723 */     if (agg_sorter == null) {
/* 724 */       agg_hashMap.free();
/* 725 */     }
/* 726 */   }
/* 727 */ }
