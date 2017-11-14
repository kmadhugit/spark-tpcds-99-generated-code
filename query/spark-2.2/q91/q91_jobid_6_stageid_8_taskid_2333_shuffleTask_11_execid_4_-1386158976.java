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
/* 019 */   private scala.collection.Iterator smj_leftInput;
/* 020 */   private scala.collection.Iterator smj_rightInput;
/* 021 */   private InternalRow smj_leftRow;
/* 022 */   private InternalRow smj_rightRow;
/* 023 */   private int smj_value2;
/* 024 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 025 */   private int smj_value3;
/* 026 */   private UTF8String smj_value4;
/* 027 */   private boolean smj_isNull2;
/* 028 */   private UTF8String smj_value5;
/* 029 */   private boolean smj_isNull3;
/* 030 */   private UTF8String smj_value6;
/* 031 */   private boolean smj_isNull4;
/* 032 */   private int smj_value7;
/* 033 */   private boolean smj_isNull5;
/* 034 */   private double smj_value8;
/* 035 */   private boolean smj_isNull6;
/* 036 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 037 */   private UnsafeRow smj_result;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
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
/* 061 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 062 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 063 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 064 */   private UnsafeRow bhj_result2;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 067 */   private UnsafeRow project_result3;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 070 */   private UnsafeRow agg_result5;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 072 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 073 */   private int agg_value12;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 075 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 076 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 077 */
/* 078 */   public GeneratedIterator(Object[] references) {
/* 079 */     this.references = references;
/* 080 */   }
/* 081 */
/* 082 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 083 */     partitionIndex = index;
/* 084 */     this.inputs = inputs;
/* 085 */     wholestagecodegen_init_0();
/* 086 */     wholestagecodegen_init_1();
/* 087 */     wholestagecodegen_init_2();
/* 088 */     wholestagecodegen_init_3();
/* 089 */
/* 090 */   }
/* 091 */
/* 092 */   private void wholestagecodegen_init_0() {
/* 093 */     agg_initAgg = false;
/* 094 */
/* 095 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 096 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 097 */
/* 098 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 099 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 100 */     smj_leftInput = inputs[0];
/* 101 */     smj_rightInput = inputs[1];
/* 102 */
/* 103 */     smj_rightRow = null;
/* 104 */
/* 105 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 106 */
/* 107 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 108 */     smj_result = new UnsafeRow(9);
/* 109 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 96);
/* 110 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 9);
/* 111 */     project_result = new UnsafeRow(7);
/* 112 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 113 */
/* 114 */   }
/* 115 */
/* 116 */   private void wholestagecodegen_init_3() {
/* 117 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 118 */     bhj_result2 = new UnsafeRow(8);
/* 119 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 160);
/* 120 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 8);
/* 121 */     project_result3 = new UnsafeRow(6);
/* 122 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 160);
/* 123 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 6);
/* 124 */     agg_result5 = new UnsafeRow(5);
/* 125 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result5, 160);
/* 126 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 127 */
/* 128 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 129 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 130 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 131 */
/* 132 */   }
/* 133 */
/* 134 */   public class agg_FastHashMap {
/* 135 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 136 */     private int[] buckets;
/* 137 */     private int capacity = 1 << 16;
/* 138 */     private double loadFactor = 0.5;
/* 139 */     private int numBuckets = (int) (capacity / loadFactor);
/* 140 */     private int maxSteps = 2;
/* 141 */     private int numRows = 0;
/* 142 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 143 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 144 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 145 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.StringType)
/* 146 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.StringType);
/* 147 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 148 */     private Object emptyVBase;
/* 149 */     private long emptyVOff;
/* 150 */     private int emptyVLen;
/* 151 */     private boolean isBatchFull = false;
/* 152 */
/* 153 */     public agg_FastHashMap(
/* 154 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 155 */       InternalRow emptyAggregationBuffer) {
/* 156 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 157 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 158 */
/* 159 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 160 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 161 */
/* 162 */       emptyVBase = emptyBuffer;
/* 163 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 164 */       emptyVLen = emptyBuffer.length;
/* 165 */
/* 166 */       buckets = new int[numBuckets];
/* 167 */       java.util.Arrays.fill(buckets, -1);
/* 168 */     }
/* 169 */
/* 170 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4) {
/* 171 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4);
/* 172 */       int step = 0;
/* 173 */       int idx = (int) h & (numBuckets - 1);
/* 174 */       while (step < maxSteps) {
/* 175 */         // Return bucket index if it's either an empty slot or already contains the key
/* 176 */         if (buckets[idx] == -1) {
/* 177 */           if (numRows < capacity && !isBatchFull) {
/* 178 */             // creating the unsafe for new entry
/* 179 */             UnsafeRow agg_result = new UnsafeRow(5);
/* 180 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 181 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 182 */               160);
/* 183 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 184 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 185 */               agg_holder,
/* 186 */               5);
/* 187 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 188 */             agg_rowWriter.zeroOutNullBytes();
/* 189 */             agg_rowWriter.write(0, agg_key);
/* 190 */             agg_rowWriter.write(1, agg_key1);
/* 191 */             agg_rowWriter.write(2, agg_key2);
/* 192 */             agg_rowWriter.write(3, agg_key3);
/* 193 */             agg_rowWriter.write(4, agg_key4);
/* 194 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 195 */             Object kbase = agg_result.getBaseObject();
/* 196 */             long koff = agg_result.getBaseOffset();
/* 197 */             int klen = agg_result.getSizeInBytes();
/* 198 */
/* 199 */             UnsafeRow vRow
/* 200 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 201 */             if (vRow == null) {
/* 202 */               isBatchFull = true;
/* 203 */             } else {
/* 204 */               buckets[idx] = numRows++;
/* 205 */             }
/* 206 */             return vRow;
/* 207 */           } else {
/* 208 */             // No more space
/* 209 */             return null;
/* 210 */           }
/* 211 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4)) {
/* 212 */           return batch.getValueRow(buckets[idx]);
/* 213 */         }
/* 214 */         idx = (idx + 1) & (numBuckets - 1);
/* 215 */         step++;
/* 216 */       }
/* 217 */       // Didn't find it
/* 218 */       return null;
/* 219 */     }
/* 220 */
/* 221 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4) {
/* 222 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 223 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getUTF8String(4).equals(agg_key4));
/* 224 */     }
/* 225 */
/* 226 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4) {
/* 227 */       long agg_hash = 0;
/* 228 */
/* 229 */       int agg_result = 0;
/* 230 */       byte[] agg_bytes = agg_key.getBytes();
/* 231 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 232 */         int agg_hash1 = agg_bytes[i];
/* 233 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 234 */       }
/* 235 */
/* 236 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 237 */
/* 238 */       int agg_result1 = 0;
/* 239 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 240 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 241 */         int agg_hash2 = agg_bytes1[i];
/* 242 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 243 */       }
/* 244 */
/* 245 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 246 */
/* 247 */       int agg_result2 = 0;
/* 248 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 249 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 250 */         int agg_hash3 = agg_bytes2[i];
/* 251 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 252 */       }
/* 253 */
/* 254 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 255 */
/* 256 */       int agg_result3 = 0;
/* 257 */       byte[] agg_bytes3 = agg_key3.getBytes();
/* 258 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 259 */         int agg_hash4 = agg_bytes3[i];
/* 260 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash4 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 261 */       }
/* 262 */
/* 263 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 264 */
/* 265 */       int agg_result4 = 0;
/* 266 */       byte[] agg_bytes4 = agg_key4.getBytes();
/* 267 */       for (int i = 0; i < agg_bytes4.length; i++) {
/* 268 */         int agg_hash5 = agg_bytes4[i];
/* 269 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash5 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 270 */       }
/* 271 */
/* 272 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 273 */
/* 274 */       return agg_hash;
/* 275 */     }
/* 276 */
/* 277 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 278 */       return batch.rowIterator();
/* 279 */     }
/* 280 */
/* 281 */     public void close() {
/* 282 */       batch.close();
/* 283 */     }
/* 284 */
/* 285 */   }
/* 286 */
/* 287 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 288 */     agg_hashMap = agg_plan.createHashMap();
/* 289 */
/* 290 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 291 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 292 */       smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 293 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 294 */       smj_value5 = smj_isNull3 ? null : (smj_leftRow.getUTF8String(1));
/* 295 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 296 */       smj_value6 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(2));
/* 297 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 298 */       smj_value7 = smj_isNull5 ? -1 : (smj_leftRow.getInt(3));
/* 299 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 300 */       smj_value8 = smj_isNull6 ? -1.0 : (smj_leftRow.getDouble(4));
/* 301 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 302 */       while (smj_iterator.hasNext()) {
/* 303 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 304 */
/* 305 */         smj_numOutputRows.add(1);
/* 306 */
/* 307 */         boolean smj_isNull10 = smj_rightRow1.isNullAt(3);
/* 308 */         int smj_value12 = smj_isNull10 ? -1 : (smj_rightRow1.getInt(3));
/* 309 */
/* 310 */         // generate join key for stream side
/* 311 */
/* 312 */         boolean bhj_isNull = smj_isNull10;
/* 313 */         long bhj_value = -1L;
/* 314 */         if (!smj_isNull10) {
/* 315 */           bhj_value = (long) smj_value12;
/* 316 */         }
/* 317 */         // find matches from HashedRelation
/* 318 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 319 */         if (bhj_matched == null) continue;
/* 320 */
/* 321 */         bhj_numOutputRows.add(1);
/* 322 */
/* 323 */         boolean smj_isNull8 = smj_rightRow1.isNullAt(1);
/* 324 */         int smj_value10 = smj_isNull8 ? -1 : (smj_rightRow1.getInt(1));
/* 325 */
/* 326 */         // generate join key for stream side
/* 327 */
/* 328 */         boolean bhj_isNull11 = smj_isNull8;
/* 329 */         long bhj_value11 = -1L;
/* 330 */         if (!smj_isNull8) {
/* 331 */           bhj_value11 = (long) smj_value10;
/* 332 */         }
/* 333 */         // find matches from HashedRelation
/* 334 */         UnsafeRow bhj_matched1 = bhj_isNull11 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value11);
/* 335 */         if (bhj_matched1 == null) continue;
/* 336 */
/* 337 */         bhj_numOutputRows1.add(1);
/* 338 */
/* 339 */         boolean smj_isNull9 = smj_rightRow1.isNullAt(2);
/* 340 */         int smj_value11 = smj_isNull9 ? -1 : (smj_rightRow1.getInt(2));
/* 341 */
/* 342 */         // generate join key for stream side
/* 343 */
/* 344 */         boolean bhj_isNull25 = smj_isNull9;
/* 345 */         long bhj_value25 = -1L;
/* 346 */         if (!smj_isNull9) {
/* 347 */           bhj_value25 = (long) smj_value11;
/* 348 */         }
/* 349 */         // find matches from HashedRelation
/* 350 */         UnsafeRow bhj_matched2 = bhj_isNull25 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value25);
/* 351 */         if (bhj_matched2 == null) continue;
/* 352 */
/* 353 */         bhj_numOutputRows2.add(1);
/* 354 */
/* 355 */         boolean bhj_isNull14 = bhj_matched1.isNullAt(1);
/* 356 */         UTF8String bhj_value14 = bhj_isNull14 ? null : (bhj_matched1.getUTF8String(1));
/* 357 */         boolean bhj_isNull15 = bhj_matched1.isNullAt(2);
/* 358 */         UTF8String bhj_value15 = bhj_isNull15 ? null : (bhj_matched1.getUTF8String(2));
/* 359 */
/* 360 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 361 */
/* 362 */         UnsafeRow agg_fastAggBuffer = null;
/* 363 */
/* 364 */         if (true) {
/* 365 */           if (!smj_isNull2 && !smj_isNull3 && !smj_isNull4 && !bhj_isNull14 && !bhj_isNull15) {
/* 366 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 367 */               smj_value4, smj_value5, smj_value6, bhj_value14, bhj_value15);
/* 368 */           }
/* 369 */         }
/* 370 */
/* 371 */         if (agg_fastAggBuffer == null) {
/* 372 */           // generate grouping key
/* 373 */           agg_holder.reset();
/* 374 */
/* 375 */           agg_rowWriter.zeroOutNullBytes();
/* 376 */
/* 377 */           if (smj_isNull2) {
/* 378 */             agg_rowWriter.setNullAt(0);
/* 379 */           } else {
/* 380 */             agg_rowWriter.write(0, smj_value4);
/* 381 */           }
/* 382 */
/* 383 */           if (smj_isNull3) {
/* 384 */             agg_rowWriter.setNullAt(1);
/* 385 */           } else {
/* 386 */             agg_rowWriter.write(1, smj_value5);
/* 387 */           }
/* 388 */
/* 389 */           if (smj_isNull4) {
/* 390 */             agg_rowWriter.setNullAt(2);
/* 391 */           } else {
/* 392 */             agg_rowWriter.write(2, smj_value6);
/* 393 */           }
/* 394 */
/* 395 */           if (bhj_isNull14) {
/* 396 */             agg_rowWriter.setNullAt(3);
/* 397 */           } else {
/* 398 */             agg_rowWriter.write(3, bhj_value14);
/* 399 */           }
/* 400 */
/* 401 */           if (bhj_isNull15) {
/* 402 */             agg_rowWriter.setNullAt(4);
/* 403 */           } else {
/* 404 */             agg_rowWriter.write(4, bhj_value15);
/* 405 */           }
/* 406 */           agg_result5.setTotalSize(agg_holder.totalSize());
/* 407 */           agg_value12 = 42;
/* 408 */
/* 409 */           if (!smj_isNull2) {
/* 410 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value4.getBaseObject(), smj_value4.getBaseOffset(), smj_value4.numBytes(), agg_value12);
/* 411 */           }
/* 412 */
/* 413 */           if (!smj_isNull3) {
/* 414 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value5.getBaseObject(), smj_value5.getBaseOffset(), smj_value5.numBytes(), agg_value12);
/* 415 */           }
/* 416 */
/* 417 */           if (!smj_isNull4) {
/* 418 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value6.getBaseObject(), smj_value6.getBaseOffset(), smj_value6.numBytes(), agg_value12);
/* 419 */           }
/* 420 */
/* 421 */           if (!bhj_isNull14) {
/* 422 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value14.getBaseObject(), bhj_value14.getBaseOffset(), bhj_value14.numBytes(), agg_value12);
/* 423 */           }
/* 424 */
/* 425 */           if (!bhj_isNull15) {
/* 426 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value15.getBaseObject(), bhj_value15.getBaseOffset(), bhj_value15.numBytes(), agg_value12);
/* 427 */           }
/* 428 */           if (true) {
/* 429 */             // try to get the buffer from hash map
/* 430 */             agg_unsafeRowAggBuffer =
/* 431 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value12);
/* 432 */           }
/* 433 */           if (agg_unsafeRowAggBuffer == null) {
/* 434 */             if (agg_sorter == null) {
/* 435 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 436 */             } else {
/* 437 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 438 */             }
/* 439 */
/* 440 */             // the hash map had be spilled, it should have enough memory now,
/* 441 */             // try  to allocate buffer again.
/* 442 */             agg_unsafeRowAggBuffer =
/* 443 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value12);
/* 444 */             if (agg_unsafeRowAggBuffer == null) {
/* 445 */               // failed to allocate the first page
/* 446 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 447 */             }
/* 448 */           }
/* 449 */         }
/* 450 */
/* 451 */         if (agg_fastAggBuffer != null) {
/* 452 */           // update fast row
/* 453 */
/* 454 */           // common sub-expressions
/* 455 */
/* 456 */           // evaluate aggregate function
/* 457 */           boolean agg_isNull26 = true;
/* 458 */           double agg_value27 = -1.0;
/* 459 */
/* 460 */           boolean agg_isNull28 = agg_fastAggBuffer.isNullAt(0);
/* 461 */           double agg_value29 = agg_isNull28 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 462 */           boolean agg_isNull27 = agg_isNull28;
/* 463 */           double agg_value28 = agg_value29;
/* 464 */           if (agg_isNull27) {
/* 465 */             boolean agg_isNull29 = false;
/* 466 */             double agg_value30 = -1.0;
/* 467 */             if (!false) {
/* 468 */               agg_value30 = (double) 0;
/* 469 */             }
/* 470 */             if (!agg_isNull29) {
/* 471 */               agg_isNull27 = false;
/* 472 */               agg_value28 = agg_value30;
/* 473 */             }
/* 474 */           }
/* 475 */
/* 476 */           if (!smj_isNull6) {
/* 477 */             agg_isNull26 = false; // resultCode could change nullability.
/* 478 */             agg_value27 = agg_value28 + smj_value8;
/* 479 */
/* 480 */           }
/* 481 */           boolean agg_isNull25 = agg_isNull26;
/* 482 */           double agg_value26 = agg_value27;
/* 483 */           if (agg_isNull25) {
/* 484 */             boolean agg_isNull32 = agg_fastAggBuffer.isNullAt(0);
/* 485 */             double agg_value33 = agg_isNull32 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 486 */             if (!agg_isNull32) {
/* 487 */               agg_isNull25 = false;
/* 488 */               agg_value26 = agg_value33;
/* 489 */             }
/* 490 */           }
/* 491 */           // update fast row
/* 492 */           if (!agg_isNull25) {
/* 493 */             agg_fastAggBuffer.setDouble(0, agg_value26);
/* 494 */           } else {
/* 495 */             agg_fastAggBuffer.setNullAt(0);
/* 496 */           }
/* 497 */
/* 498 */         } else {
/* 499 */           // update unsafe row
/* 500 */
/* 501 */           // common sub-expressions
/* 502 */
/* 503 */           // evaluate aggregate function
/* 504 */           boolean agg_isNull18 = true;
/* 505 */           double agg_value19 = -1.0;
/* 506 */
/* 507 */           boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 508 */           double agg_value21 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 509 */           boolean agg_isNull19 = agg_isNull20;
/* 510 */           double agg_value20 = agg_value21;
/* 511 */           if (agg_isNull19) {
/* 512 */             boolean agg_isNull21 = false;
/* 513 */             double agg_value22 = -1.0;
/* 514 */             if (!false) {
/* 515 */               agg_value22 = (double) 0;
/* 516 */             }
/* 517 */             if (!agg_isNull21) {
/* 518 */               agg_isNull19 = false;
/* 519 */               agg_value20 = agg_value22;
/* 520 */             }
/* 521 */           }
/* 522 */
/* 523 */           if (!smj_isNull6) {
/* 524 */             agg_isNull18 = false; // resultCode could change nullability.
/* 525 */             agg_value19 = agg_value20 + smj_value8;
/* 526 */
/* 527 */           }
/* 528 */           boolean agg_isNull17 = agg_isNull18;
/* 529 */           double agg_value18 = agg_value19;
/* 530 */           if (agg_isNull17) {
/* 531 */             boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 532 */             double agg_value25 = agg_isNull24 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 533 */             if (!agg_isNull24) {
/* 534 */               agg_isNull17 = false;
/* 535 */               agg_value18 = agg_value25;
/* 536 */             }
/* 537 */           }
/* 538 */           // update unsafe row buffer
/* 539 */           if (!agg_isNull17) {
/* 540 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value18);
/* 541 */           } else {
/* 542 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 543 */           }
/* 544 */
/* 545 */         }
/* 546 */
/* 547 */       }
/* 548 */       if (shouldStop()) return;
/* 549 */     }
/* 550 */
/* 551 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 552 */
/* 553 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 554 */   }
/* 555 */
/* 556 */   private boolean findNextInnerJoinRows(
/* 557 */     scala.collection.Iterator leftIter,
/* 558 */     scala.collection.Iterator rightIter) {
/* 559 */     smj_leftRow = null;
/* 560 */     int comp = 0;
/* 561 */     while (smj_leftRow == null) {
/* 562 */       if (!leftIter.hasNext()) return false;
/* 563 */       smj_leftRow = (InternalRow) leftIter.next();
/* 564 */
/* 565 */       boolean smj_isNull = smj_leftRow.isNullAt(3);
/* 566 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(3));
/* 567 */       if (smj_isNull) {
/* 568 */         smj_leftRow = null;
/* 569 */         continue;
/* 570 */       }
/* 571 */       if (!smj_matches.isEmpty()) {
/* 572 */         comp = 0;
/* 573 */         if (comp == 0) {
/* 574 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 575 */         }
/* 576 */
/* 577 */         if (comp == 0) {
/* 578 */           return true;
/* 579 */         }
/* 580 */         smj_matches.clear();
/* 581 */       }
/* 582 */
/* 583 */       do {
/* 584 */         if (smj_rightRow == null) {
/* 585 */           if (!rightIter.hasNext()) {
/* 586 */             smj_value3 = smj_value;
/* 587 */             return !smj_matches.isEmpty();
/* 588 */           }
/* 589 */           smj_rightRow = (InternalRow) rightIter.next();
/* 590 */
/* 591 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 592 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 593 */           if (smj_isNull1) {
/* 594 */             smj_rightRow = null;
/* 595 */             continue;
/* 596 */           }
/* 597 */           smj_value2 = smj_value1;
/* 598 */         }
/* 599 */
/* 600 */         comp = 0;
/* 601 */         if (comp == 0) {
/* 602 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 603 */         }
/* 604 */
/* 605 */         if (comp > 0) {
/* 606 */           smj_rightRow = null;
/* 607 */         } else if (comp < 0) {
/* 608 */           if (!smj_matches.isEmpty()) {
/* 609 */             smj_value3 = smj_value;
/* 610 */             return true;
/* 611 */           }
/* 612 */           smj_leftRow = null;
/* 613 */         } else {
/* 614 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 615 */           smj_rightRow = null;;
/* 616 */         }
/* 617 */       } while (smj_leftRow != null);
/* 618 */     }
/* 619 */     return false; // unreachable
/* 620 */   }
/* 621 */
/* 622 */   private void wholestagecodegen_init_2() {
/* 623 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 624 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 625 */
/* 626 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 627 */     bhj_result1 = new UnsafeRow(9);
/* 628 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 160);
/* 629 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 9);
/* 630 */     project_result2 = new UnsafeRow(7);
/* 631 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 160);
/* 632 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 7);
/* 633 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[14];
/* 634 */
/* 635 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 636 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 637 */
/* 638 */   }
/* 639 */
/* 640 */   private void wholestagecodegen_init_1() {
/* 641 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 7);
/* 642 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 643 */
/* 644 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 645 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 646 */
/* 647 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 648 */     bhj_result = new UnsafeRow(8);
/* 649 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 96);
/* 650 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 8);
/* 651 */     project_result1 = new UnsafeRow(6);
/* 652 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 96);
/* 653 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 6);
/* 654 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[12];
/* 655 */
/* 656 */   }
/* 657 */
/* 658 */   protected void processNext() throws java.io.IOException {
/* 659 */     if (!agg_initAgg) {
/* 660 */       agg_initAgg = true;
/* 661 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 662 */       agg_doAggregateWithKeys();
/* 663 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 664 */     }
/* 665 */
/* 666 */     // output the result
/* 667 */
/* 668 */     while (agg_fastHashMapIter.next()) {
/* 669 */       wholestagecodegen_numOutputRows.add(1);
/* 670 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 671 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 672 */
/* 673 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 674 */
/* 675 */       append(agg_resultRow.copy());
/* 676 */
/* 677 */       if (shouldStop()) return;
/* 678 */     }
/* 679 */     agg_fastHashMap.close();
/* 680 */
/* 681 */     while (agg_mapIter.next()) {
/* 682 */       wholestagecodegen_numOutputRows.add(1);
/* 683 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 684 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 685 */
/* 686 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 687 */
/* 688 */       append(agg_resultRow.copy());
/* 689 */
/* 690 */       if (shouldStop()) return;
/* 691 */     }
/* 692 */
/* 693 */     agg_mapIter.close();
/* 694 */     if (agg_sorter == null) {
/* 695 */       agg_hashMap.free();
/* 696 */     }
/* 697 */   }
/* 698 */ }
