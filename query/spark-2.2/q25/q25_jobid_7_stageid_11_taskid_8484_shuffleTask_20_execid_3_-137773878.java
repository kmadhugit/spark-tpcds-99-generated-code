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
/* 023 */   private scala.collection.Iterator smj_leftInput;
/* 024 */   private scala.collection.Iterator smj_rightInput;
/* 025 */   private InternalRow smj_leftRow;
/* 026 */   private InternalRow smj_rightRow;
/* 027 */   private long smj_value6;
/* 028 */   private long smj_value7;
/* 029 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 030 */   private long smj_value8;
/* 031 */   private long smj_value9;
/* 032 */   private int smj_value10;
/* 033 */   private boolean smj_isNull6;
/* 034 */   private int smj_value11;
/* 035 */   private boolean smj_isNull7;
/* 036 */   private double smj_value12;
/* 037 */   private boolean smj_isNull8;
/* 038 */   private int smj_value13;
/* 039 */   private boolean smj_isNull9;
/* 040 */   private long smj_value14;
/* 041 */   private boolean smj_isNull10;
/* 042 */   private long smj_value15;
/* 043 */   private boolean smj_isNull11;
/* 044 */   private double smj_value16;
/* 045 */   private boolean smj_isNull12;
/* 046 */   private int smj_value17;
/* 047 */   private boolean smj_isNull13;
/* 048 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 049 */   private UnsafeRow smj_result;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 052 */   private UnsafeRow project_result;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 055 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 056 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 057 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 058 */   private UnsafeRow bhj_result;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 061 */   private UnsafeRow project_result1;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 064 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 065 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 066 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 067 */   private UnsafeRow bhj_result1;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 070 */   private UnsafeRow project_result2;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 072 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 073 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 074 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 075 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 076 */   private UnsafeRow bhj_result2;
/* 077 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 078 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 079 */   private UnsafeRow project_result3;
/* 080 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 081 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 082 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 083 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 084 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 085 */   private UnsafeRow bhj_result3;
/* 086 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 087 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 088 */   private UnsafeRow project_result4;
/* 089 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 090 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 091 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast4;
/* 092 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation4;
/* 093 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows4;
/* 094 */   private UnsafeRow bhj_result4;
/* 095 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder4;
/* 096 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter4;
/* 097 */   private UnsafeRow project_result5;
/* 098 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder5;
/* 099 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter5;
/* 100 */   private UnsafeRow agg_result4;
/* 101 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 102 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 103 */   private int agg_value14;
/* 104 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 105 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 106 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 107 */
/* 108 */   public GeneratedIterator(Object[] references) {
/* 109 */     this.references = references;
/* 110 */   }
/* 111 */
/* 112 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 113 */     partitionIndex = index;
/* 114 */     this.inputs = inputs;
/* 115 */     wholestagecodegen_init_0();
/* 116 */     wholestagecodegen_init_1();
/* 117 */     wholestagecodegen_init_2();
/* 118 */     wholestagecodegen_init_3();
/* 119 */     wholestagecodegen_init_4();
/* 120 */     wholestagecodegen_init_5();
/* 121 */
/* 122 */   }
/* 123 */
/* 124 */   private void wholestagecodegen_init_0() {
/* 125 */     agg_initAgg = false;
/* 126 */
/* 127 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 128 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 129 */
/* 130 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 131 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 132 */     smj_leftInput = inputs[0];
/* 133 */     smj_rightInput = inputs[1];
/* 134 */
/* 135 */     smj_rightRow = null;
/* 136 */
/* 137 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 138 */
/* 139 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 140 */     smj_result = new UnsafeRow(12);
/* 141 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 142 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 12);
/* 143 */     project_result = new UnsafeRow(8);
/* 144 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 145 */
/* 146 */   }
/* 147 */
/* 148 */   private void wholestagecodegen_init_3() {
/* 149 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 150 */     bhj_result2 = new UnsafeRow(7);
/* 151 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 0);
/* 152 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 7);
/* 153 */     project_result3 = new UnsafeRow(5);
/* 154 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 0);
/* 155 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 5);
/* 156 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[17];
/* 157 */
/* 158 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 159 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 160 */
/* 161 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 162 */     bhj_result3 = new UnsafeRow(8);
/* 163 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 64);
/* 164 */
/* 165 */   }
/* 166 */
/* 167 */   public class agg_FastHashMap {
/* 168 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 169 */     private int[] buckets;
/* 170 */     private int capacity = 1 << 16;
/* 171 */     private double loadFactor = 0.5;
/* 172 */     private int numBuckets = (int) (capacity / loadFactor);
/* 173 */     private int maxSteps = 2;
/* 174 */     private int numRows = 0;
/* 175 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 176 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 177 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 178 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.StringType);
/* 179 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 180 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 181 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 182 */     private Object emptyVBase;
/* 183 */     private long emptyVOff;
/* 184 */     private int emptyVLen;
/* 185 */     private boolean isBatchFull = false;
/* 186 */
/* 187 */     public agg_FastHashMap(
/* 188 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 189 */       InternalRow emptyAggregationBuffer) {
/* 190 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 191 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 192 */
/* 193 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 194 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 195 */
/* 196 */       emptyVBase = emptyBuffer;
/* 197 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 198 */       emptyVLen = emptyBuffer.length;
/* 199 */
/* 200 */       buckets = new int[numBuckets];
/* 201 */       java.util.Arrays.fill(buckets, -1);
/* 202 */     }
/* 203 */
/* 204 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3) {
/* 205 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3);
/* 206 */       int step = 0;
/* 207 */       int idx = (int) h & (numBuckets - 1);
/* 208 */       while (step < maxSteps) {
/* 209 */         // Return bucket index if it's either an empty slot or already contains the key
/* 210 */         if (buckets[idx] == -1) {
/* 211 */           if (numRows < capacity && !isBatchFull) {
/* 212 */             // creating the unsafe for new entry
/* 213 */             UnsafeRow agg_result = new UnsafeRow(4);
/* 214 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 215 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 216 */               128);
/* 217 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 218 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 219 */               agg_holder,
/* 220 */               4);
/* 221 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 222 */             agg_rowWriter.zeroOutNullBytes();
/* 223 */             agg_rowWriter.write(0, agg_key);
/* 224 */             agg_rowWriter.write(1, agg_key1);
/* 225 */             agg_rowWriter.write(2, agg_key2);
/* 226 */             agg_rowWriter.write(3, agg_key3);
/* 227 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 228 */             Object kbase = agg_result.getBaseObject();
/* 229 */             long koff = agg_result.getBaseOffset();
/* 230 */             int klen = agg_result.getSizeInBytes();
/* 231 */
/* 232 */             UnsafeRow vRow
/* 233 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 234 */             if (vRow == null) {
/* 235 */               isBatchFull = true;
/* 236 */             } else {
/* 237 */               buckets[idx] = numRows++;
/* 238 */             }
/* 239 */             return vRow;
/* 240 */           } else {
/* 241 */             // No more space
/* 242 */             return null;
/* 243 */           }
/* 244 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3)) {
/* 245 */           return batch.getValueRow(buckets[idx]);
/* 246 */         }
/* 247 */         idx = (idx + 1) & (numBuckets - 1);
/* 248 */         step++;
/* 249 */       }
/* 250 */       // Didn't find it
/* 251 */       return null;
/* 252 */     }
/* 253 */
/* 254 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3) {
/* 255 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 256 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3));
/* 257 */     }
/* 258 */
/* 259 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3) {
/* 260 */       long agg_hash = 0;
/* 261 */
/* 262 */       int agg_result = 0;
/* 263 */       byte[] agg_bytes = agg_key.getBytes();
/* 264 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 265 */         int agg_hash1 = agg_bytes[i];
/* 266 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 267 */       }
/* 268 */
/* 269 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 270 */
/* 271 */       int agg_result1 = 0;
/* 272 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 273 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 274 */         int agg_hash2 = agg_bytes1[i];
/* 275 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 276 */       }
/* 277 */
/* 278 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 279 */
/* 280 */       int agg_result2 = 0;
/* 281 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 282 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 283 */         int agg_hash3 = agg_bytes2[i];
/* 284 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 285 */       }
/* 286 */
/* 287 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 288 */
/* 289 */       int agg_result3 = 0;
/* 290 */       byte[] agg_bytes3 = agg_key3.getBytes();
/* 291 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 292 */         int agg_hash4 = agg_bytes3[i];
/* 293 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash4 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 294 */       }
/* 295 */
/* 296 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 297 */
/* 298 */       return agg_hash;
/* 299 */     }
/* 300 */
/* 301 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 302 */       return batch.rowIterator();
/* 303 */     }
/* 304 */
/* 305 */     public void close() {
/* 306 */       batch.close();
/* 307 */     }
/* 308 */
/* 309 */   }
/* 310 */
/* 311 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 312 */     agg_hashMap = agg_plan.createHashMap();
/* 313 */
/* 314 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 315 */       smj_isNull6 = smj_leftRow.isNullAt(0);
/* 316 */       smj_value10 = smj_isNull6 ? -1 : (smj_leftRow.getInt(0));
/* 317 */       smj_isNull7 = smj_leftRow.isNullAt(1);
/* 318 */       smj_value11 = smj_isNull7 ? -1 : (smj_leftRow.getInt(1));
/* 319 */       smj_isNull8 = smj_leftRow.isNullAt(2);
/* 320 */       smj_value12 = smj_isNull8 ? -1.0 : (smj_leftRow.getDouble(2));
/* 321 */       smj_isNull9 = smj_leftRow.isNullAt(3);
/* 322 */       smj_value13 = smj_isNull9 ? -1 : (smj_leftRow.getInt(3));
/* 323 */       smj_isNull10 = smj_leftRow.isNullAt(4);
/* 324 */       smj_value14 = smj_isNull10 ? -1L : (smj_leftRow.getLong(4));
/* 325 */       smj_isNull11 = smj_leftRow.isNullAt(5);
/* 326 */       smj_value15 = smj_isNull11 ? -1L : (smj_leftRow.getLong(5));
/* 327 */       smj_isNull12 = smj_leftRow.isNullAt(6);
/* 328 */       smj_value16 = smj_isNull12 ? -1.0 : (smj_leftRow.getDouble(6));
/* 329 */       smj_isNull13 = smj_leftRow.isNullAt(7);
/* 330 */       smj_value17 = smj_isNull13 ? -1 : (smj_leftRow.getInt(7));
/* 331 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 332 */       while (smj_iterator.hasNext()) {
/* 333 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 334 */
/* 335 */         smj_numOutputRows.add(1);
/* 336 */
/* 337 */         // generate join key for stream side
/* 338 */
/* 339 */         boolean bhj_isNull = smj_isNull9;
/* 340 */         long bhj_value = -1L;
/* 341 */         if (!smj_isNull9) {
/* 342 */           bhj_value = (long) smj_value13;
/* 343 */         }
/* 344 */         // find matches from HashedRelation
/* 345 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 346 */         if (bhj_matched == null) continue;
/* 347 */
/* 348 */         bhj_numOutputRows.add(1);
/* 349 */
/* 350 */         // generate join key for stream side
/* 351 */
/* 352 */         boolean bhj_isNull12 = smj_isNull13;
/* 353 */         long bhj_value12 = -1L;
/* 354 */         if (!smj_isNull13) {
/* 355 */           bhj_value12 = (long) smj_value17;
/* 356 */         }
/* 357 */         // find matches from HashedRelation
/* 358 */         UnsafeRow bhj_matched1 = bhj_isNull12 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value12);
/* 359 */         if (bhj_matched1 == null) continue;
/* 360 */
/* 361 */         bhj_numOutputRows1.add(1);
/* 362 */
/* 363 */         boolean smj_isNull17 = smj_rightRow1.isNullAt(3);
/* 364 */         int smj_value21 = smj_isNull17 ? -1 : (smj_rightRow1.getInt(3));
/* 365 */
/* 366 */         // generate join key for stream side
/* 367 */
/* 368 */         boolean bhj_isNull23 = smj_isNull17;
/* 369 */         long bhj_value23 = -1L;
/* 370 */         if (!smj_isNull17) {
/* 371 */           bhj_value23 = (long) smj_value21;
/* 372 */         }
/* 373 */         // find matches from HashedRelation
/* 374 */         UnsafeRow bhj_matched2 = bhj_isNull23 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value23);
/* 375 */         if (bhj_matched2 == null) continue;
/* 376 */
/* 377 */         bhj_numOutputRows2.add(1);
/* 378 */
/* 379 */         // generate join key for stream side
/* 380 */
/* 381 */         boolean bhj_isNull33 = smj_isNull7;
/* 382 */         long bhj_value33 = -1L;
/* 383 */         if (!smj_isNull7) {
/* 384 */           bhj_value33 = (long) smj_value11;
/* 385 */         }
/* 386 */         // find matches from HashedRelation
/* 387 */         UnsafeRow bhj_matched3 = bhj_isNull33 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value33);
/* 388 */         if (bhj_matched3 == null) continue;
/* 389 */
/* 390 */         bhj_numOutputRows3.add(1);
/* 391 */
/* 392 */         // generate join key for stream side
/* 393 */
/* 394 */         boolean bhj_isNull46 = smj_isNull6;
/* 395 */         long bhj_value46 = -1L;
/* 396 */         if (!smj_isNull6) {
/* 397 */           bhj_value46 = (long) smj_value10;
/* 398 */         }
/* 399 */         // find matches from HashedRelation
/* 400 */         UnsafeRow bhj_matched4 = bhj_isNull46 ? null: (UnsafeRow)bhj_relation4.getValue(bhj_value46);
/* 401 */         if (bhj_matched4 == null) continue;
/* 402 */
/* 403 */         bhj_numOutputRows4.add(1);
/* 404 */
/* 405 */         boolean smj_isNull16 = smj_rightRow1.isNullAt(2);
/* 406 */         double smj_value20 = smj_isNull16 ? -1.0 : (smj_rightRow1.getDouble(2));
/* 407 */         boolean bhj_isNull36 = bhj_matched3.isNullAt(1);
/* 408 */         UTF8String bhj_value36 = bhj_isNull36 ? null : (bhj_matched3.getUTF8String(1));
/* 409 */         boolean bhj_isNull37 = bhj_matched3.isNullAt(2);
/* 410 */         UTF8String bhj_value37 = bhj_isNull37 ? null : (bhj_matched3.getUTF8String(2));
/* 411 */         boolean bhj_isNull49 = bhj_matched4.isNullAt(1);
/* 412 */         UTF8String bhj_value49 = bhj_isNull49 ? null : (bhj_matched4.getUTF8String(1));
/* 413 */         boolean bhj_isNull50 = bhj_matched4.isNullAt(2);
/* 414 */         UTF8String bhj_value50 = bhj_isNull50 ? null : (bhj_matched4.getUTF8String(2));
/* 415 */
/* 416 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 417 */
/* 418 */         UnsafeRow agg_fastAggBuffer = null;
/* 419 */
/* 420 */         if (true) {
/* 421 */           if (!bhj_isNull49 && !bhj_isNull50 && !bhj_isNull36 && !bhj_isNull37) {
/* 422 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 423 */               bhj_value49, bhj_value50, bhj_value36, bhj_value37);
/* 424 */           }
/* 425 */         }
/* 426 */
/* 427 */         if (agg_fastAggBuffer == null) {
/* 428 */           // generate grouping key
/* 429 */           agg_holder.reset();
/* 430 */
/* 431 */           agg_rowWriter.zeroOutNullBytes();
/* 432 */
/* 433 */           if (bhj_isNull49) {
/* 434 */             agg_rowWriter.setNullAt(0);
/* 435 */           } else {
/* 436 */             agg_rowWriter.write(0, bhj_value49);
/* 437 */           }
/* 438 */
/* 439 */           if (bhj_isNull50) {
/* 440 */             agg_rowWriter.setNullAt(1);
/* 441 */           } else {
/* 442 */             agg_rowWriter.write(1, bhj_value50);
/* 443 */           }
/* 444 */
/* 445 */           if (bhj_isNull36) {
/* 446 */             agg_rowWriter.setNullAt(2);
/* 447 */           } else {
/* 448 */             agg_rowWriter.write(2, bhj_value36);
/* 449 */           }
/* 450 */
/* 451 */           if (bhj_isNull37) {
/* 452 */             agg_rowWriter.setNullAt(3);
/* 453 */           } else {
/* 454 */             agg_rowWriter.write(3, bhj_value37);
/* 455 */           }
/* 456 */           agg_result4.setTotalSize(agg_holder.totalSize());
/* 457 */           agg_value14 = 42;
/* 458 */
/* 459 */           if (!bhj_isNull49) {
/* 460 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value49.getBaseObject(), bhj_value49.getBaseOffset(), bhj_value49.numBytes(), agg_value14);
/* 461 */           }
/* 462 */
/* 463 */           if (!bhj_isNull50) {
/* 464 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value50.getBaseObject(), bhj_value50.getBaseOffset(), bhj_value50.numBytes(), agg_value14);
/* 465 */           }
/* 466 */
/* 467 */           if (!bhj_isNull36) {
/* 468 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value36.getBaseObject(), bhj_value36.getBaseOffset(), bhj_value36.numBytes(), agg_value14);
/* 469 */           }
/* 470 */
/* 471 */           if (!bhj_isNull37) {
/* 472 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value37.getBaseObject(), bhj_value37.getBaseOffset(), bhj_value37.numBytes(), agg_value14);
/* 473 */           }
/* 474 */           if (true) {
/* 475 */             // try to get the buffer from hash map
/* 476 */             agg_unsafeRowAggBuffer =
/* 477 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value14);
/* 478 */           }
/* 479 */           if (agg_unsafeRowAggBuffer == null) {
/* 480 */             if (agg_sorter == null) {
/* 481 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 482 */             } else {
/* 483 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 484 */             }
/* 485 */
/* 486 */             // the hash map had be spilled, it should have enough memory now,
/* 487 */             // try  to allocate buffer again.
/* 488 */             agg_unsafeRowAggBuffer =
/* 489 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value14);
/* 490 */             if (agg_unsafeRowAggBuffer == null) {
/* 491 */               // failed to allocate the first page
/* 492 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 493 */             }
/* 494 */           }
/* 495 */         }
/* 496 */
/* 497 */         if (agg_fastAggBuffer != null) {
/* 498 */           // update fast row
/* 499 */
/* 500 */           // common sub-expressions
/* 501 */
/* 502 */           // evaluate aggregate function
/* 503 */           boolean agg_isNull41 = true;
/* 504 */           double agg_value44 = -1.0;
/* 505 */
/* 506 */           boolean agg_isNull43 = agg_fastAggBuffer.isNullAt(0);
/* 507 */           double agg_value46 = agg_isNull43 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 508 */           boolean agg_isNull42 = agg_isNull43;
/* 509 */           double agg_value45 = agg_value46;
/* 510 */           if (agg_isNull42) {
/* 511 */             boolean agg_isNull44 = false;
/* 512 */             double agg_value47 = -1.0;
/* 513 */             if (!false) {
/* 514 */               agg_value47 = (double) 0;
/* 515 */             }
/* 516 */             if (!agg_isNull44) {
/* 517 */               agg_isNull42 = false;
/* 518 */               agg_value45 = agg_value47;
/* 519 */             }
/* 520 */           }
/* 521 */
/* 522 */           if (!smj_isNull8) {
/* 523 */             agg_isNull41 = false; // resultCode could change nullability.
/* 524 */             agg_value44 = agg_value45 + smj_value12;
/* 525 */
/* 526 */           }
/* 527 */           boolean agg_isNull40 = agg_isNull41;
/* 528 */           double agg_value43 = agg_value44;
/* 529 */           if (agg_isNull40) {
/* 530 */             boolean agg_isNull47 = agg_fastAggBuffer.isNullAt(0);
/* 531 */             double agg_value50 = agg_isNull47 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 532 */             if (!agg_isNull47) {
/* 533 */               agg_isNull40 = false;
/* 534 */               agg_value43 = agg_value50;
/* 535 */             }
/* 536 */           }
/* 537 */           boolean agg_isNull49 = true;
/* 538 */           double agg_value52 = -1.0;
/* 539 */
/* 540 */           boolean agg_isNull51 = agg_fastAggBuffer.isNullAt(1);
/* 541 */           double agg_value54 = agg_isNull51 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 542 */           boolean agg_isNull50 = agg_isNull51;
/* 543 */           double agg_value53 = agg_value54;
/* 544 */           if (agg_isNull50) {
/* 545 */             boolean agg_isNull52 = false;
/* 546 */             double agg_value55 = -1.0;
/* 547 */             if (!false) {
/* 548 */               agg_value55 = (double) 0;
/* 549 */             }
/* 550 */             if (!agg_isNull52) {
/* 551 */               agg_isNull50 = false;
/* 552 */               agg_value53 = agg_value55;
/* 553 */             }
/* 554 */           }
/* 555 */
/* 556 */           if (!smj_isNull12) {
/* 557 */             agg_isNull49 = false; // resultCode could change nullability.
/* 558 */             agg_value52 = agg_value53 + smj_value16;
/* 559 */
/* 560 */           }
/* 561 */           boolean agg_isNull48 = agg_isNull49;
/* 562 */           double agg_value51 = agg_value52;
/* 563 */           if (agg_isNull48) {
/* 564 */             boolean agg_isNull55 = agg_fastAggBuffer.isNullAt(1);
/* 565 */             double agg_value58 = agg_isNull55 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 566 */             if (!agg_isNull55) {
/* 567 */               agg_isNull48 = false;
/* 568 */               agg_value51 = agg_value58;
/* 569 */             }
/* 570 */           }
/* 571 */           boolean agg_isNull57 = true;
/* 572 */           double agg_value60 = -1.0;
/* 573 */
/* 574 */           boolean agg_isNull59 = agg_fastAggBuffer.isNullAt(2);
/* 575 */           double agg_value62 = agg_isNull59 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 576 */           boolean agg_isNull58 = agg_isNull59;
/* 577 */           double agg_value61 = agg_value62;
/* 578 */           if (agg_isNull58) {
/* 579 */             boolean agg_isNull60 = false;
/* 580 */             double agg_value63 = -1.0;
/* 581 */             if (!false) {
/* 582 */               agg_value63 = (double) 0;
/* 583 */             }
/* 584 */             if (!agg_isNull60) {
/* 585 */               agg_isNull58 = false;
/* 586 */               agg_value61 = agg_value63;
/* 587 */             }
/* 588 */           }
/* 589 */
/* 590 */           if (!smj_isNull16) {
/* 591 */             agg_isNull57 = false; // resultCode could change nullability.
/* 592 */             agg_value60 = agg_value61 + smj_value20;
/* 593 */
/* 594 */           }
/* 595 */           boolean agg_isNull56 = agg_isNull57;
/* 596 */           double agg_value59 = agg_value60;
/* 597 */           if (agg_isNull56) {
/* 598 */             boolean agg_isNull63 = agg_fastAggBuffer.isNullAt(2);
/* 599 */             double agg_value66 = agg_isNull63 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 600 */             if (!agg_isNull63) {
/* 601 */               agg_isNull56 = false;
/* 602 */               agg_value59 = agg_value66;
/* 603 */             }
/* 604 */           }
/* 605 */           // update fast row
/* 606 */           if (!agg_isNull40) {
/* 607 */             agg_fastAggBuffer.setDouble(0, agg_value43);
/* 608 */           } else {
/* 609 */             agg_fastAggBuffer.setNullAt(0);
/* 610 */           }
/* 611 */
/* 612 */           if (!agg_isNull48) {
/* 613 */             agg_fastAggBuffer.setDouble(1, agg_value51);
/* 614 */           } else {
/* 615 */             agg_fastAggBuffer.setNullAt(1);
/* 616 */           }
/* 617 */
/* 618 */           if (!agg_isNull56) {
/* 619 */             agg_fastAggBuffer.setDouble(2, agg_value59);
/* 620 */           } else {
/* 621 */             agg_fastAggBuffer.setNullAt(2);
/* 622 */           }
/* 623 */
/* 624 */         } else {
/* 625 */           // update unsafe row
/* 626 */
/* 627 */           // common sub-expressions
/* 628 */
/* 629 */           // evaluate aggregate function
/* 630 */           boolean agg_isNull17 = true;
/* 631 */           double agg_value20 = -1.0;
/* 632 */
/* 633 */           boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 634 */           double agg_value22 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 635 */           boolean agg_isNull18 = agg_isNull19;
/* 636 */           double agg_value21 = agg_value22;
/* 637 */           if (agg_isNull18) {
/* 638 */             boolean agg_isNull20 = false;
/* 639 */             double agg_value23 = -1.0;
/* 640 */             if (!false) {
/* 641 */               agg_value23 = (double) 0;
/* 642 */             }
/* 643 */             if (!agg_isNull20) {
/* 644 */               agg_isNull18 = false;
/* 645 */               agg_value21 = agg_value23;
/* 646 */             }
/* 647 */           }
/* 648 */
/* 649 */           if (!smj_isNull8) {
/* 650 */             agg_isNull17 = false; // resultCode could change nullability.
/* 651 */             agg_value20 = agg_value21 + smj_value12;
/* 652 */
/* 653 */           }
/* 654 */           boolean agg_isNull16 = agg_isNull17;
/* 655 */           double agg_value19 = agg_value20;
/* 656 */           if (agg_isNull16) {
/* 657 */             boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 658 */             double agg_value26 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 659 */             if (!agg_isNull23) {
/* 660 */               agg_isNull16 = false;
/* 661 */               agg_value19 = agg_value26;
/* 662 */             }
/* 663 */           }
/* 664 */           boolean agg_isNull25 = true;
/* 665 */           double agg_value28 = -1.0;
/* 666 */
/* 667 */           boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 668 */           double agg_value30 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 669 */           boolean agg_isNull26 = agg_isNull27;
/* 670 */           double agg_value29 = agg_value30;
/* 671 */           if (agg_isNull26) {
/* 672 */             boolean agg_isNull28 = false;
/* 673 */             double agg_value31 = -1.0;
/* 674 */             if (!false) {
/* 675 */               agg_value31 = (double) 0;
/* 676 */             }
/* 677 */             if (!agg_isNull28) {
/* 678 */               agg_isNull26 = false;
/* 679 */               agg_value29 = agg_value31;
/* 680 */             }
/* 681 */           }
/* 682 */
/* 683 */           if (!smj_isNull12) {
/* 684 */             agg_isNull25 = false; // resultCode could change nullability.
/* 685 */             agg_value28 = agg_value29 + smj_value16;
/* 686 */
/* 687 */           }
/* 688 */           boolean agg_isNull24 = agg_isNull25;
/* 689 */           double agg_value27 = agg_value28;
/* 690 */           if (agg_isNull24) {
/* 691 */             boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 692 */             double agg_value34 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 693 */             if (!agg_isNull31) {
/* 694 */               agg_isNull24 = false;
/* 695 */               agg_value27 = agg_value34;
/* 696 */             }
/* 697 */           }
/* 698 */           boolean agg_isNull33 = true;
/* 699 */           double agg_value36 = -1.0;
/* 700 */
/* 701 */           boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 702 */           double agg_value38 = agg_isNull35 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 703 */           boolean agg_isNull34 = agg_isNull35;
/* 704 */           double agg_value37 = agg_value38;
/* 705 */           if (agg_isNull34) {
/* 706 */             boolean agg_isNull36 = false;
/* 707 */             double agg_value39 = -1.0;
/* 708 */             if (!false) {
/* 709 */               agg_value39 = (double) 0;
/* 710 */             }
/* 711 */             if (!agg_isNull36) {
/* 712 */               agg_isNull34 = false;
/* 713 */               agg_value37 = agg_value39;
/* 714 */             }
/* 715 */           }
/* 716 */
/* 717 */           if (!smj_isNull16) {
/* 718 */             agg_isNull33 = false; // resultCode could change nullability.
/* 719 */             agg_value36 = agg_value37 + smj_value20;
/* 720 */
/* 721 */           }
/* 722 */           boolean agg_isNull32 = agg_isNull33;
/* 723 */           double agg_value35 = agg_value36;
/* 724 */           if (agg_isNull32) {
/* 725 */             boolean agg_isNull39 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 726 */             double agg_value42 = agg_isNull39 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 727 */             if (!agg_isNull39) {
/* 728 */               agg_isNull32 = false;
/* 729 */               agg_value35 = agg_value42;
/* 730 */             }
/* 731 */           }
/* 732 */           // update unsafe row buffer
/* 733 */           if (!agg_isNull16) {
/* 734 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value19);
/* 735 */           } else {
/* 736 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 737 */           }
/* 738 */
/* 739 */           if (!agg_isNull24) {
/* 740 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value27);
/* 741 */           } else {
/* 742 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 743 */           }
/* 744 */
/* 745 */           if (!agg_isNull32) {
/* 746 */             agg_unsafeRowAggBuffer.setDouble(2, agg_value35);
/* 747 */           } else {
/* 748 */             agg_unsafeRowAggBuffer.setNullAt(2);
/* 749 */           }
/* 750 */
/* 751 */         }
/* 752 */
/* 753 */       }
/* 754 */       if (shouldStop()) return;
/* 755 */     }
/* 756 */
/* 757 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 758 */
/* 759 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 760 */   }
/* 761 */
/* 762 */   private boolean findNextInnerJoinRows(
/* 763 */     scala.collection.Iterator leftIter,
/* 764 */     scala.collection.Iterator rightIter) {
/* 765 */     smj_leftRow = null;
/* 766 */     int comp = 0;
/* 767 */     while (smj_leftRow == null) {
/* 768 */       if (!leftIter.hasNext()) return false;
/* 769 */       smj_leftRow = (InternalRow) leftIter.next();
/* 770 */
/* 771 */       boolean smj_isNull = smj_leftRow.isNullAt(5);
/* 772 */       long smj_value = smj_isNull ? -1L : (smj_leftRow.getLong(5));
/* 773 */
/* 774 */       boolean smj_isNull1 = smj_leftRow.isNullAt(4);
/* 775 */       long smj_value1 = smj_isNull1 ? -1L : (smj_leftRow.getLong(4));
/* 776 */       if (smj_isNull || smj_isNull1) {
/* 777 */         smj_leftRow = null;
/* 778 */         continue;
/* 779 */       }
/* 780 */       if (!smj_matches.isEmpty()) {
/* 781 */         comp = 0;
/* 782 */         if (comp == 0) {
/* 783 */           comp = (smj_value > smj_value8 ? 1 : smj_value < smj_value8 ? -1 : 0);
/* 784 */         }
/* 785 */         if (comp == 0) {
/* 786 */           comp = (smj_value1 > smj_value9 ? 1 : smj_value1 < smj_value9 ? -1 : 0);
/* 787 */         }
/* 788 */
/* 789 */         if (comp == 0) {
/* 790 */           return true;
/* 791 */         }
/* 792 */         smj_matches.clear();
/* 793 */       }
/* 794 */
/* 795 */       do {
/* 796 */         if (smj_rightRow == null) {
/* 797 */           if (!rightIter.hasNext()) {
/* 798 */             smj_value8 = smj_value;
/* 799 */             smj_value9 = smj_value1;
/* 800 */             return !smj_matches.isEmpty();
/* 801 */           }
/* 802 */           smj_rightRow = (InternalRow) rightIter.next();
/* 803 */
/* 804 */           boolean smj_isNull3 = smj_rightRow.isNullAt(0);
/* 805 */           int smj_value3 = smj_isNull3 ? -1 : (smj_rightRow.getInt(0));
/* 806 */           boolean smj_isNull2 = smj_isNull3;
/* 807 */           long smj_value2 = -1L;
/* 808 */           if (!smj_isNull3) {
/* 809 */             smj_value2 = (long) smj_value3;
/* 810 */           }
/* 811 */
/* 812 */           boolean smj_isNull5 = smj_rightRow.isNullAt(1);
/* 813 */           int smj_value5 = smj_isNull5 ? -1 : (smj_rightRow.getInt(1));
/* 814 */           boolean smj_isNull4 = smj_isNull5;
/* 815 */           long smj_value4 = -1L;
/* 816 */           if (!smj_isNull5) {
/* 817 */             smj_value4 = (long) smj_value5;
/* 818 */           }
/* 819 */           if (smj_isNull2 || smj_isNull4) {
/* 820 */             smj_rightRow = null;
/* 821 */             continue;
/* 822 */           }
/* 823 */           smj_value6 = smj_value2;
/* 824 */           smj_value7 = smj_value4;
/* 825 */         }
/* 826 */
/* 827 */         comp = 0;
/* 828 */         if (comp == 0) {
/* 829 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 830 */         }
/* 831 */         if (comp == 0) {
/* 832 */           comp = (smj_value1 > smj_value7 ? 1 : smj_value1 < smj_value7 ? -1 : 0);
/* 833 */         }
/* 834 */
/* 835 */         if (comp > 0) {
/* 836 */           smj_rightRow = null;
/* 837 */         } else if (comp < 0) {
/* 838 */           if (!smj_matches.isEmpty()) {
/* 839 */             smj_value8 = smj_value;
/* 840 */             smj_value9 = smj_value1;
/* 841 */             return true;
/* 842 */           }
/* 843 */           smj_leftRow = null;
/* 844 */         } else {
/* 845 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 846 */           smj_rightRow = null;;
/* 847 */         }
/* 848 */       } while (smj_leftRow != null);
/* 849 */     }
/* 850 */     return false; // unreachable
/* 851 */   }
/* 852 */
/* 853 */   private void wholestagecodegen_init_5() {
/* 854 */     this.project_rowWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder5, 7);
/* 855 */     agg_result4 = new UnsafeRow(4);
/* 856 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result4, 128);
/* 857 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 858 */
/* 859 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 860 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[21];
/* 861 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[22];
/* 862 */
/* 863 */   }
/* 864 */
/* 865 */   private void wholestagecodegen_init_2() {
/* 866 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 867 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 868 */
/* 869 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 870 */     bhj_result1 = new UnsafeRow(8);
/* 871 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 872 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 8);
/* 873 */     project_result2 = new UnsafeRow(6);
/* 874 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 875 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 876 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[15];
/* 877 */
/* 878 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 879 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 880 */
/* 881 */   }
/* 882 */
/* 883 */   private void wholestagecodegen_init_1() {
/* 884 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
/* 885 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[11];
/* 886 */
/* 887 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 888 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 889 */
/* 890 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 891 */     bhj_result = new UnsafeRow(9);
/* 892 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 893 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 9);
/* 894 */     project_result1 = new UnsafeRow(7);
/* 895 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 896 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 7);
/* 897 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 898 */
/* 899 */   }
/* 900 */
/* 901 */   private void wholestagecodegen_init_4() {
/* 902 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 8);
/* 903 */     project_result4 = new UnsafeRow(6);
/* 904 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 64);
/* 905 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 6);
/* 906 */     this.bhj_broadcast4 = (org.apache.spark.broadcast.TorrentBroadcast) references[19];
/* 907 */
/* 908 */     bhj_relation4 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast4.value()).asReadOnlyCopy();
/* 909 */     incPeakExecutionMemory(bhj_relation4.estimatedSize());
/* 910 */
/* 911 */     this.bhj_numOutputRows4 = (org.apache.spark.sql.execution.metric.SQLMetric) references[20];
/* 912 */     bhj_result4 = new UnsafeRow(9);
/* 913 */     this.bhj_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result4, 128);
/* 914 */     this.bhj_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder4, 9);
/* 915 */     project_result5 = new UnsafeRow(7);
/* 916 */     this.project_holder5 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result5, 128);
/* 917 */
/* 918 */   }
/* 919 */
/* 920 */   protected void processNext() throws java.io.IOException {
/* 921 */     if (!agg_initAgg) {
/* 922 */       agg_initAgg = true;
/* 923 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 924 */       agg_doAggregateWithKeys();
/* 925 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 926 */     }
/* 927 */
/* 928 */     // output the result
/* 929 */
/* 930 */     while (agg_fastHashMapIter.next()) {
/* 931 */       wholestagecodegen_numOutputRows.add(1);
/* 932 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 933 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 934 */
/* 935 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 936 */
/* 937 */       append(agg_resultRow.copy());
/* 938 */
/* 939 */       if (shouldStop()) return;
/* 940 */     }
/* 941 */     agg_fastHashMap.close();
/* 942 */
/* 943 */     while (agg_mapIter.next()) {
/* 944 */       wholestagecodegen_numOutputRows.add(1);
/* 945 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 946 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 947 */
/* 948 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 949 */
/* 950 */       append(agg_resultRow.copy());
/* 951 */
/* 952 */       if (shouldStop()) return;
/* 953 */     }
/* 954 */
/* 955 */     agg_mapIter.close();
/* 956 */     if (agg_sorter == null) {
/* 957 */       agg_hashMap.free();
/* 958 */     }
/* 959 */   }
/* 960 */ }
