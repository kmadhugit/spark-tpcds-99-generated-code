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
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private long agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private double agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private long agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private double agg_bufValue6;
/* 023 */   private boolean agg_bufIsNull7;
/* 024 */   private long agg_bufValue7;
/* 025 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 026 */   private agg_FastHashMap agg_fastHashMap;
/* 027 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 028 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 029 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 030 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 033 */   private scala.collection.Iterator smj_leftInput;
/* 034 */   private scala.collection.Iterator smj_rightInput;
/* 035 */   private InternalRow smj_leftRow;
/* 036 */   private InternalRow smj_rightRow;
/* 037 */   private long smj_value6;
/* 038 */   private long smj_value7;
/* 039 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 040 */   private long smj_value8;
/* 041 */   private long smj_value9;
/* 042 */   private int smj_value10;
/* 043 */   private boolean smj_isNull6;
/* 044 */   private int smj_value11;
/* 045 */   private boolean smj_isNull7;
/* 046 */   private int smj_value12;
/* 047 */   private boolean smj_isNull8;
/* 048 */   private int smj_value13;
/* 049 */   private boolean smj_isNull9;
/* 050 */   private double smj_value14;
/* 051 */   private boolean smj_isNull10;
/* 052 */   private double smj_value15;
/* 053 */   private boolean smj_isNull11;
/* 054 */   private int smj_value16;
/* 055 */   private boolean smj_isNull12;
/* 056 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 057 */   private UnsafeRow smj_result;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 060 */   private UnsafeRow project_result;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 063 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 064 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 065 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 066 */   private UnsafeRow bhj_result;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 069 */   private UnsafeRow project_result1;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 072 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 073 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 074 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 075 */   private UnsafeRow bhj_result1;
/* 076 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 077 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 078 */   private UnsafeRow project_result2;
/* 079 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 080 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 081 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 082 */   private org.apache.spark.sql.execution.joins.UnsafeHashedRelation bhj_relation2;
/* 083 */   private UnsafeRow bhj_result2;
/* 084 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 085 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 086 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 087 */   private UnsafeRow bhj_result3;
/* 088 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 089 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 090 */   private UnsafeRow project_result3;
/* 091 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 092 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 093 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 094 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 095 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 096 */   private UnsafeRow bhj_result4;
/* 097 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder4;
/* 098 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter4;
/* 099 */   private UnsafeRow project_result4;
/* 100 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 101 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 102 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast4;
/* 103 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation4;
/* 104 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows4;
/* 105 */   private UnsafeRow bhj_result5;
/* 106 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder5;
/* 107 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter5;
/* 108 */   private UnsafeRow project_result5;
/* 109 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder5;
/* 110 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter5;
/* 111 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast5;
/* 112 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation5;
/* 113 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows5;
/* 114 */   private UnsafeRow bhj_result6;
/* 115 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder6;
/* 116 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter6;
/* 117 */   private UnsafeRow project_result6;
/* 118 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder6;
/* 119 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter6;
/* 120 */   private UnsafeRow agg_result1;
/* 121 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 122 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 123 */   private int agg_value22;
/* 124 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 125 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 126 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 127 */
/* 128 */   public GeneratedIterator(Object[] references) {
/* 129 */     this.references = references;
/* 130 */   }
/* 131 */
/* 132 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 133 */     partitionIndex = index;
/* 134 */     this.inputs = inputs;
/* 135 */     wholestagecodegen_init_0();
/* 136 */     wholestagecodegen_init_1();
/* 137 */     wholestagecodegen_init_2();
/* 138 */     wholestagecodegen_init_3();
/* 139 */     wholestagecodegen_init_4();
/* 140 */     wholestagecodegen_init_5();
/* 141 */     wholestagecodegen_init_6();
/* 142 */
/* 143 */   }
/* 144 */
/* 145 */   private void wholestagecodegen_init_0() {
/* 146 */     agg_initAgg = false;
/* 147 */
/* 148 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 149 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 150 */
/* 151 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 152 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 153 */     smj_leftInput = inputs[0];
/* 154 */     smj_rightInput = inputs[1];
/* 155 */
/* 156 */     smj_rightRow = null;
/* 157 */
/* 158 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 159 */
/* 160 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 161 */     smj_result = new UnsafeRow(15);
/* 162 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 163 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 15);
/* 164 */     project_result = new UnsafeRow(11);
/* 165 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 166 */
/* 167 */   }
/* 168 */
/* 169 */   private void wholestagecodegen_init_3() {
/* 170 */     bhj_result2 = new UnsafeRow(3);
/* 171 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 64);
/* 172 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 3);
/* 173 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[24];
/* 174 */     bhj_result3 = new UnsafeRow(13);
/* 175 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 128);
/* 176 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 13);
/* 177 */     project_result3 = new UnsafeRow(7);
/* 178 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 0);
/* 179 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 7);
/* 180 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[25];
/* 181 */
/* 182 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 183 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 184 */
/* 185 */   }
/* 186 */
/* 187 */   public class agg_FastHashMap {
/* 188 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 189 */     private int[] buckets;
/* 190 */     private int capacity = 1 << 16;
/* 191 */     private double loadFactor = 0.5;
/* 192 */     private int numBuckets = (int) (capacity / loadFactor);
/* 193 */     private int maxSteps = 2;
/* 194 */     private int numRows = 0;
/* 195 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType);
/* 196 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 197 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.LongType)
/* 198 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 199 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.LongType)
/* 200 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 201 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.LongType)
/* 202 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 203 */     .add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.LongType);
/* 204 */     private Object emptyVBase;
/* 205 */     private long emptyVOff;
/* 206 */     private int emptyVLen;
/* 207 */     private boolean isBatchFull = false;
/* 208 */
/* 209 */     public agg_FastHashMap(
/* 210 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 211 */       InternalRow emptyAggregationBuffer) {
/* 212 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 213 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 214 */
/* 215 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 216 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 217 */
/* 218 */       emptyVBase = emptyBuffer;
/* 219 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 220 */       emptyVLen = emptyBuffer.length;
/* 221 */
/* 222 */       buckets = new int[numBuckets];
/* 223 */       java.util.Arrays.fill(buckets, -1);
/* 224 */     }
/* 225 */
/* 226 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key) {
/* 227 */       long h = hash(agg_key);
/* 228 */       int step = 0;
/* 229 */       int idx = (int) h & (numBuckets - 1);
/* 230 */       while (step < maxSteps) {
/* 231 */         // Return bucket index if it's either an empty slot or already contains the key
/* 232 */         if (buckets[idx] == -1) {
/* 233 */           if (numRows < capacity && !isBatchFull) {
/* 234 */             // creating the unsafe for new entry
/* 235 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 236 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 237 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 238 */               32);
/* 239 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 240 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 241 */               agg_holder,
/* 242 */               1);
/* 243 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 244 */             agg_rowWriter.zeroOutNullBytes();
/* 245 */             agg_rowWriter.write(0, agg_key);
/* 246 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 247 */             Object kbase = agg_result.getBaseObject();
/* 248 */             long koff = agg_result.getBaseOffset();
/* 249 */             int klen = agg_result.getSizeInBytes();
/* 250 */
/* 251 */             UnsafeRow vRow
/* 252 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 253 */             if (vRow == null) {
/* 254 */               isBatchFull = true;
/* 255 */             } else {
/* 256 */               buckets[idx] = numRows++;
/* 257 */             }
/* 258 */             return vRow;
/* 259 */           } else {
/* 260 */             // No more space
/* 261 */             return null;
/* 262 */           }
/* 263 */         } else if (equals(idx, agg_key)) {
/* 264 */           return batch.getValueRow(buckets[idx]);
/* 265 */         }
/* 266 */         idx = (idx + 1) & (numBuckets - 1);
/* 267 */         step++;
/* 268 */       }
/* 269 */       // Didn't find it
/* 270 */       return null;
/* 271 */     }
/* 272 */
/* 273 */     private boolean equals(int idx, UTF8String agg_key) {
/* 274 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 275 */       return (row.getUTF8String(0).equals(agg_key));
/* 276 */     }
/* 277 */
/* 278 */     private long hash(UTF8String agg_key) {
/* 279 */       long agg_hash = 0;
/* 280 */
/* 281 */       int agg_result = 0;
/* 282 */       byte[] agg_bytes = agg_key.getBytes();
/* 283 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 284 */         int agg_hash1 = agg_bytes[i];
/* 285 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 286 */       }
/* 287 */
/* 288 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 289 */
/* 290 */       return agg_hash;
/* 291 */     }
/* 292 */
/* 293 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 294 */       return batch.rowIterator();
/* 295 */     }
/* 296 */
/* 297 */     public void close() {
/* 298 */       batch.close();
/* 299 */     }
/* 300 */
/* 301 */   }
/* 302 */
/* 303 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 304 */     agg_hashMap = agg_plan.createHashMap();
/* 305 */
/* 306 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 307 */       smj_isNull6 = smj_leftRow.isNullAt(0);
/* 308 */       smj_value10 = smj_isNull6 ? -1 : (smj_leftRow.getInt(0));
/* 309 */       smj_isNull7 = smj_leftRow.isNullAt(1);
/* 310 */       smj_value11 = smj_isNull7 ? -1 : (smj_leftRow.getInt(1));
/* 311 */       smj_isNull8 = smj_leftRow.isNullAt(2);
/* 312 */       smj_value12 = smj_isNull8 ? -1 : (smj_leftRow.getInt(2));
/* 313 */       smj_isNull9 = smj_leftRow.isNullAt(3);
/* 314 */       smj_value13 = smj_isNull9 ? -1 : (smj_leftRow.getInt(3));
/* 315 */       smj_isNull10 = smj_leftRow.isNullAt(4);
/* 316 */       smj_value14 = smj_isNull10 ? -1.0 : (smj_leftRow.getDouble(4));
/* 317 */       smj_isNull11 = smj_leftRow.isNullAt(5);
/* 318 */       smj_value15 = smj_isNull11 ? -1.0 : (smj_leftRow.getDouble(5));
/* 319 */       smj_isNull12 = smj_leftRow.isNullAt(6);
/* 320 */       smj_value16 = smj_isNull12 ? -1 : (smj_leftRow.getInt(6));
/* 321 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 322 */       while (smj_iterator.hasNext()) {
/* 323 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 324 */
/* 325 */         smj_numOutputRows.add(1);
/* 326 */
/* 327 */         // generate join key for stream side
/* 328 */
/* 329 */         boolean bhj_isNull = smj_isNull7;
/* 330 */         long bhj_value = -1L;
/* 331 */         if (!smj_isNull7) {
/* 332 */           bhj_value = (long) smj_value11;
/* 333 */         }
/* 334 */         // find matches from HashedRelation
/* 335 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 336 */         if (bhj_matched == null) continue;
/* 337 */
/* 338 */         bhj_numOutputRows.add(1);
/* 339 */
/* 340 */         boolean smj_isNull14 = smj_rightRow1.isNullAt(1);
/* 341 */         long smj_value18 = smj_isNull14 ? -1L : (smj_rightRow1.getLong(1));
/* 342 */
/* 343 */         // generate join key for stream side
/* 344 */
/* 345 */         // find matches from HashedRelation
/* 346 */         UnsafeRow bhj_matched1 = smj_isNull14 ? null: (UnsafeRow)bhj_relation1.getValue(smj_value18);
/* 347 */         if (bhj_matched1 == null) continue;
/* 348 */
/* 349 */         boolean bhj_isNull17 = bhj_matched1.isNullAt(1);
/* 350 */         UTF8String bhj_value17 = bhj_isNull17 ? null : (bhj_matched1.getUTF8String(1));
/* 351 */         boolean bhj_isNull18 = bhj_matched1.isNullAt(2);
/* 352 */         UTF8String bhj_value18 = bhj_isNull18 ? null : (bhj_matched1.getUTF8String(2));
/* 353 */
/* 354 */         boolean bhj_isNull24 = true;
/* 355 */         boolean bhj_value24 = false;
/* 356 */
/* 357 */         if (!bhj_isNull17) {
/* 358 */           bhj_isNull24 = false; // resultCode could change nullability.
/* 359 */           bhj_value24 = bhj_value17.equals(((UTF8String) references[16]));
/* 360 */
/* 361 */         }
/* 362 */         boolean bhj_isNull23 = false;
/* 363 */         boolean bhj_value23 = false;
/* 364 */
/* 365 */         if (!bhj_isNull24 && !bhj_value24) {
/* 366 */         } else {
/* 367 */           boolean bhj_isNull27 = true;
/* 368 */           boolean bhj_value27 = false;
/* 369 */
/* 370 */           if (!bhj_isNull18) {
/* 371 */             bhj_isNull27 = false; // resultCode could change nullability.
/* 372 */             bhj_value27 = bhj_value18.equals(((UTF8String) references[17]));
/* 373 */
/* 374 */           }
/* 375 */           if (!bhj_isNull27 && !bhj_value27) {
/* 376 */           } else if (!bhj_isNull24 && !bhj_isNull27) {
/* 377 */             bhj_value23 = true;
/* 378 */           } else {
/* 379 */             bhj_isNull23 = true;
/* 380 */           }
/* 381 */         }
/* 382 */         boolean bhj_isNull22 = false;
/* 383 */         boolean bhj_value22 = false;
/* 384 */
/* 385 */         if (!bhj_isNull23 && !bhj_value23) {
/* 386 */         } else {
/* 387 */           boolean bhj_isNull30 = true;
/* 388 */           boolean bhj_value30 = false;
/* 389 */
/* 390 */           if (!smj_isNull10) {
/* 391 */             bhj_isNull30 = false; // resultCode could change nullability.
/* 392 */             bhj_value30 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value14, 100.0D) >= 0;
/* 393 */
/* 394 */           }
/* 395 */           if (!bhj_isNull30 && !bhj_value30) {
/* 396 */           } else if (!bhj_isNull23 && !bhj_isNull30) {
/* 397 */             bhj_value22 = true;
/* 398 */           } else {
/* 399 */             bhj_isNull22 = true;
/* 400 */           }
/* 401 */         }
/* 402 */         boolean bhj_isNull21 = false;
/* 403 */         boolean bhj_value21 = false;
/* 404 */
/* 405 */         if (!bhj_isNull22 && !bhj_value22) {
/* 406 */         } else {
/* 407 */           boolean bhj_isNull33 = true;
/* 408 */           boolean bhj_value33 = false;
/* 409 */
/* 410 */           if (!smj_isNull10) {
/* 411 */             bhj_isNull33 = false; // resultCode could change nullability.
/* 412 */             bhj_value33 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value14, 150.0D) <= 0;
/* 413 */
/* 414 */           }
/* 415 */           if (!bhj_isNull33 && !bhj_value33) {
/* 416 */           } else if (!bhj_isNull22 && !bhj_isNull33) {
/* 417 */             bhj_value21 = true;
/* 418 */           } else {
/* 419 */             bhj_isNull21 = true;
/* 420 */           }
/* 421 */         }
/* 422 */         boolean bhj_isNull20 = false;
/* 423 */         boolean bhj_value20 = true;
/* 424 */
/* 425 */         if (!bhj_isNull21 && bhj_value21) {
/* 426 */         } else {
/* 427 */           boolean bhj_isNull39 = true;
/* 428 */           boolean bhj_value39 = false;
/* 429 */
/* 430 */           if (!bhj_isNull17) {
/* 431 */             bhj_isNull39 = false; // resultCode could change nullability.
/* 432 */             bhj_value39 = bhj_value17.equals(((UTF8String) references[18]));
/* 433 */
/* 434 */           }
/* 435 */           boolean bhj_isNull38 = false;
/* 436 */           boolean bhj_value38 = false;
/* 437 */
/* 438 */           if (!bhj_isNull39 && !bhj_value39) {
/* 439 */           } else {
/* 440 */             boolean bhj_isNull42 = true;
/* 441 */             boolean bhj_value42 = false;
/* 442 */
/* 443 */             if (!bhj_isNull18) {
/* 444 */               bhj_isNull42 = false; // resultCode could change nullability.
/* 445 */               bhj_value42 = bhj_value18.equals(((UTF8String) references[19]));
/* 446 */
/* 447 */             }
/* 448 */             if (!bhj_isNull42 && !bhj_value42) {
/* 449 */             } else if (!bhj_isNull39 && !bhj_isNull42) {
/* 450 */               bhj_value38 = true;
/* 451 */             } else {
/* 452 */               bhj_isNull38 = true;
/* 453 */             }
/* 454 */           }
/* 455 */           boolean bhj_isNull37 = false;
/* 456 */           boolean bhj_value37 = false;
/* 457 */
/* 458 */           if (!bhj_isNull38 && !bhj_value38) {
/* 459 */           } else {
/* 460 */             boolean bhj_isNull45 = true;
/* 461 */             boolean bhj_value45 = false;
/* 462 */
/* 463 */             if (!smj_isNull10) {
/* 464 */               bhj_isNull45 = false; // resultCode could change nullability.
/* 465 */               bhj_value45 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value14, 50.0D) >= 0;
/* 466 */
/* 467 */             }
/* 468 */             if (!bhj_isNull45 && !bhj_value45) {
/* 469 */             } else if (!bhj_isNull38 && !bhj_isNull45) {
/* 470 */               bhj_value37 = true;
/* 471 */             } else {
/* 472 */               bhj_isNull37 = true;
/* 473 */             }
/* 474 */           }
/* 475 */           boolean bhj_isNull36 = false;
/* 476 */           boolean bhj_value36 = false;
/* 477 */
/* 478 */           if (!bhj_isNull37 && !bhj_value37) {
/* 479 */           } else {
/* 480 */             boolean bhj_isNull48 = true;
/* 481 */             boolean bhj_value48 = false;
/* 482 */
/* 483 */             if (!smj_isNull10) {
/* 484 */               bhj_isNull48 = false; // resultCode could change nullability.
/* 485 */               bhj_value48 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value14, 100.0D) <= 0;
/* 486 */
/* 487 */             }
/* 488 */             if (!bhj_isNull48 && !bhj_value48) {
/* 489 */             } else if (!bhj_isNull37 && !bhj_isNull48) {
/* 490 */               bhj_value36 = true;
/* 491 */             } else {
/* 492 */               bhj_isNull36 = true;
/* 493 */             }
/* 494 */           }
/* 495 */           if (!bhj_isNull36 && bhj_value36) {
/* 496 */           } else if (!bhj_isNull21 && !bhj_isNull36) {
/* 497 */             bhj_value20 = false;
/* 498 */           } else {
/* 499 */             bhj_isNull20 = true;
/* 500 */           }
/* 501 */         }
/* 502 */         boolean bhj_isNull19 = false;
/* 503 */         boolean bhj_value19 = true;
/* 504 */
/* 505 */         if (!bhj_isNull20 && bhj_value20) {
/* 506 */         } else {
/* 507 */           boolean bhj_isNull54 = true;
/* 508 */           boolean bhj_value54 = false;
/* 509 */
/* 510 */           if (!bhj_isNull17) {
/* 511 */             bhj_isNull54 = false; // resultCode could change nullability.
/* 512 */             bhj_value54 = bhj_value17.equals(((UTF8String) references[20]));
/* 513 */
/* 514 */           }
/* 515 */           boolean bhj_isNull53 = false;
/* 516 */           boolean bhj_value53 = false;
/* 517 */
/* 518 */           if (!bhj_isNull54 && !bhj_value54) {
/* 519 */           } else {
/* 520 */             boolean bhj_isNull57 = true;
/* 521 */             boolean bhj_value57 = false;
/* 522 */
/* 523 */             if (!bhj_isNull18) {
/* 524 */               bhj_isNull57 = false; // resultCode could change nullability.
/* 525 */               bhj_value57 = bhj_value18.equals(((UTF8String) references[21]));
/* 526 */
/* 527 */             }
/* 528 */             if (!bhj_isNull57 && !bhj_value57) {
/* 529 */             } else if (!bhj_isNull54 && !bhj_isNull57) {
/* 530 */               bhj_value53 = true;
/* 531 */             } else {
/* 532 */               bhj_isNull53 = true;
/* 533 */             }
/* 534 */           }
/* 535 */           boolean bhj_isNull52 = false;
/* 536 */           boolean bhj_value52 = false;
/* 537 */
/* 538 */           if (!bhj_isNull53 && !bhj_value53) {
/* 539 */           } else {
/* 540 */             boolean bhj_isNull60 = true;
/* 541 */             boolean bhj_value60 = false;
/* 542 */
/* 543 */             if (!smj_isNull10) {
/* 544 */               bhj_isNull60 = false; // resultCode could change nullability.
/* 545 */               bhj_value60 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value14, 150.0D) >= 0;
/* 546 */
/* 547 */             }
/* 548 */             if (!bhj_isNull60 && !bhj_value60) {
/* 549 */             } else if (!bhj_isNull53 && !bhj_isNull60) {
/* 550 */               bhj_value52 = true;
/* 551 */             } else {
/* 552 */               bhj_isNull52 = true;
/* 553 */             }
/* 554 */           }
/* 555 */           boolean bhj_isNull51 = false;
/* 556 */           boolean bhj_value51 = false;
/* 557 */
/* 558 */           if (!bhj_isNull52 && !bhj_value52) {
/* 559 */           } else {
/* 560 */             boolean bhj_isNull63 = true;
/* 561 */             boolean bhj_value63 = false;
/* 562 */
/* 563 */             if (!smj_isNull10) {
/* 564 */               bhj_isNull63 = false; // resultCode could change nullability.
/* 565 */               bhj_value63 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value14, 200.0D) <= 0;
/* 566 */
/* 567 */             }
/* 568 */             if (!bhj_isNull63 && !bhj_value63) {
/* 569 */             } else if (!bhj_isNull52 && !bhj_isNull63) {
/* 570 */               bhj_value51 = true;
/* 571 */             } else {
/* 572 */               bhj_isNull51 = true;
/* 573 */             }
/* 574 */           }
/* 575 */           if (!bhj_isNull51 && bhj_value51) {
/* 576 */           } else if (!bhj_isNull20 && !bhj_isNull51) {
/* 577 */             bhj_value19 = false;
/* 578 */           } else {
/* 579 */             bhj_isNull19 = true;
/* 580 */           }
/* 581 */         }
/* 582 */         if (bhj_isNull19 || !bhj_value19) continue;
/* 583 */
/* 584 */         bhj_numOutputRows1.add(1);
/* 585 */
/* 586 */         boolean smj_isNull16 = smj_rightRow1.isNullAt(3);
/* 587 */         long smj_value20 = smj_isNull16 ? -1L : (smj_rightRow1.getLong(3));
/* 588 */
/* 589 */         // generate join key for stream side
/* 590 */
/* 591 */         bhj_holder2.reset();
/* 592 */
/* 593 */         bhj_rowWriter2.zeroOutNullBytes();
/* 594 */
/* 595 */         if (smj_isNull16) {
/* 596 */           bhj_rowWriter2.setNullAt(0);
/* 597 */         } else {
/* 598 */           bhj_rowWriter2.write(0, smj_value20);
/* 599 */         }
/* 600 */
/* 601 */         if (bhj_isNull17) {
/* 602 */           bhj_rowWriter2.setNullAt(1);
/* 603 */         } else {
/* 604 */           bhj_rowWriter2.write(1, bhj_value17);
/* 605 */         }
/* 606 */
/* 607 */         if (bhj_isNull18) {
/* 608 */           bhj_rowWriter2.setNullAt(2);
/* 609 */         } else {
/* 610 */           bhj_rowWriter2.write(2, bhj_value18);
/* 611 */         }
/* 612 */         bhj_result2.setTotalSize(bhj_holder2.totalSize());
/* 613 */
/* 614 */         // find matches from HashedRelation
/* 615 */         UnsafeRow bhj_matched2 = bhj_result2.anyNull() ? null: (UnsafeRow)bhj_relation2.getValue(bhj_result2);
/* 616 */         if (bhj_matched2 == null) continue;
/* 617 */
/* 618 */         bhj_numOutputRows2.add(1);
/* 619 */
/* 620 */         boolean smj_isNull15 = smj_rightRow1.isNullAt(2);
/* 621 */         long smj_value19 = smj_isNull15 ? -1L : (smj_rightRow1.getLong(2));
/* 622 */
/* 623 */         // generate join key for stream side
/* 624 */
/* 625 */         // find matches from HashedRelation
/* 626 */         UnsafeRow bhj_matched3 = smj_isNull15 ? null: (UnsafeRow)bhj_relation3.getValue(smj_value19);
/* 627 */         if (bhj_matched3 == null) continue;
/* 628 */
/* 629 */         boolean bhj_isNull100 = bhj_matched3.isNullAt(1);
/* 630 */         UTF8String bhj_value100 = bhj_isNull100 ? null : (bhj_matched3.getUTF8String(1));
/* 631 */
/* 632 */         boolean bhj_value105 = false;
/* 633 */         boolean bhj_isNull105 = bhj_isNull100;
/* 634 */         if (!bhj_isNull105) {
/* 635 */           if (!bhj_value105) {
/* 636 */             if (false) {
/* 637 */               bhj_isNull105 = true;
/* 638 */             } else if (bhj_value100.equals(((UTF8String) references[26]))) {
/* 639 */               bhj_isNull105 = false;
/* 640 */               bhj_value105 = true;
/* 641 */             }
/* 642 */           }
/* 643 */
/* 644 */           if (!bhj_value105) {
/* 645 */             if (false) {
/* 646 */               bhj_isNull105 = true;
/* 647 */             } else if (bhj_value100.equals(((UTF8String) references[27]))) {
/* 648 */               bhj_isNull105 = false;
/* 649 */               bhj_value105 = true;
/* 650 */             }
/* 651 */           }
/* 652 */
/* 653 */           if (!bhj_value105) {
/* 654 */             if (false) {
/* 655 */               bhj_isNull105 = true;
/* 656 */             } else if (bhj_value100.equals(((UTF8String) references[28]))) {
/* 657 */               bhj_isNull105 = false;
/* 658 */               bhj_value105 = true;
/* 659 */             }
/* 660 */           }
/* 661 */
/* 662 */         }
/* 663 */         boolean bhj_isNull104 = false;
/* 664 */         boolean bhj_value104 = false;
/* 665 */
/* 666 */         if (!bhj_isNull105 && !bhj_value105) {
/* 667 */         } else {
/* 668 */           boolean bhj_isNull110 = true;
/* 669 */           boolean bhj_value110 = false;
/* 670 */
/* 671 */           if (!smj_isNull11) {
/* 672 */             bhj_isNull110 = false; // resultCode could change nullability.
/* 673 */             bhj_value110 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value15, 100.0D) >= 0;
/* 674 */
/* 675 */           }
/* 676 */           if (!bhj_isNull110 && !bhj_value110) {
/* 677 */           } else if (!bhj_isNull105 && !bhj_isNull110) {
/* 678 */             bhj_value104 = true;
/* 679 */           } else {
/* 680 */             bhj_isNull104 = true;
/* 681 */           }
/* 682 */         }
/* 683 */         boolean bhj_isNull103 = false;
/* 684 */         boolean bhj_value103 = false;
/* 685 */
/* 686 */         if (!bhj_isNull104 && !bhj_value104) {
/* 687 */         } else {
/* 688 */           boolean bhj_isNull113 = true;
/* 689 */           boolean bhj_value113 = false;
/* 690 */
/* 691 */           if (!smj_isNull11) {
/* 692 */             bhj_isNull113 = false; // resultCode could change nullability.
/* 693 */             bhj_value113 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value15, 200.0D) <= 0;
/* 694 */
/* 695 */           }
/* 696 */           if (!bhj_isNull113 && !bhj_value113) {
/* 697 */           } else if (!bhj_isNull104 && !bhj_isNull113) {
/* 698 */             bhj_value103 = true;
/* 699 */           } else {
/* 700 */             bhj_isNull103 = true;
/* 701 */           }
/* 702 */         }
/* 703 */         boolean bhj_isNull102 = false;
/* 704 */         boolean bhj_value102 = true;
/* 705 */
/* 706 */         if (!bhj_isNull103 && bhj_value103) {
/* 707 */         } else {
/* 708 */           boolean bhj_value118 = false;
/* 709 */           boolean bhj_isNull118 = bhj_isNull100;
/* 710 */           if (!bhj_isNull118) {
/* 711 */             if (!bhj_value118) {
/* 712 */               if (false) {
/* 713 */                 bhj_isNull118 = true;
/* 714 */               } else if (bhj_value100.equals(((UTF8String) references[29]))) {
/* 715 */                 bhj_isNull118 = false;
/* 716 */                 bhj_value118 = true;
/* 717 */               }
/* 718 */             }
/* 719 */
/* 720 */             if (!bhj_value118) {
/* 721 */               if (false) {
/* 722 */                 bhj_isNull118 = true;
/* 723 */               } else if (bhj_value100.equals(((UTF8String) references[30]))) {
/* 724 */                 bhj_isNull118 = false;
/* 725 */                 bhj_value118 = true;
/* 726 */               }
/* 727 */             }
/* 728 */
/* 729 */             if (!bhj_value118) {
/* 730 */               if (false) {
/* 731 */                 bhj_isNull118 = true;
/* 732 */               } else if (bhj_value100.equals(((UTF8String) references[31]))) {
/* 733 */                 bhj_isNull118 = false;
/* 734 */                 bhj_value118 = true;
/* 735 */               }
/* 736 */             }
/* 737 */
/* 738 */           }
/* 739 */           boolean bhj_isNull117 = false;
/* 740 */           boolean bhj_value117 = false;
/* 741 */
/* 742 */           if (!bhj_isNull118 && !bhj_value118) {
/* 743 */           } else {
/* 744 */             boolean bhj_isNull123 = true;
/* 745 */             boolean bhj_value123 = false;
/* 746 */
/* 747 */             if (!smj_isNull11) {
/* 748 */               bhj_isNull123 = false; // resultCode could change nullability.
/* 749 */               bhj_value123 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value15, 150.0D) >= 0;
/* 750 */
/* 751 */             }
/* 752 */             if (!bhj_isNull123 && !bhj_value123) {
/* 753 */             } else if (!bhj_isNull118 && !bhj_isNull123) {
/* 754 */               bhj_value117 = true;
/* 755 */             } else {
/* 756 */               bhj_isNull117 = true;
/* 757 */             }
/* 758 */           }
/* 759 */           boolean bhj_isNull116 = false;
/* 760 */           boolean bhj_value116 = false;
/* 761 */
/* 762 */           if (!bhj_isNull117 && !bhj_value117) {
/* 763 */           } else {
/* 764 */             boolean bhj_isNull126 = true;
/* 765 */             boolean bhj_value126 = false;
/* 766 */
/* 767 */             if (!smj_isNull11) {
/* 768 */               bhj_isNull126 = false; // resultCode could change nullability.
/* 769 */               bhj_value126 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value15, 300.0D) <= 0;
/* 770 */
/* 771 */             }
/* 772 */             if (!bhj_isNull126 && !bhj_value126) {
/* 773 */             } else if (!bhj_isNull117 && !bhj_isNull126) {
/* 774 */               bhj_value116 = true;
/* 775 */             } else {
/* 776 */               bhj_isNull116 = true;
/* 777 */             }
/* 778 */           }
/* 779 */           if (!bhj_isNull116 && bhj_value116) {
/* 780 */           } else if (!bhj_isNull103 && !bhj_isNull116) {
/* 781 */             bhj_value102 = false;
/* 782 */           } else {
/* 783 */             bhj_isNull102 = true;
/* 784 */           }
/* 785 */         }
/* 786 */         boolean bhj_isNull101 = false;
/* 787 */         boolean bhj_value101 = true;
/* 788 */
/* 789 */         if (!bhj_isNull102 && bhj_value102) {
/* 790 */         } else {
/* 791 */           boolean bhj_value131 = false;
/* 792 */           boolean bhj_isNull131 = bhj_isNull100;
/* 793 */           if (!bhj_isNull131) {
/* 794 */             if (!bhj_value131) {
/* 795 */               if (false) {
/* 796 */                 bhj_isNull131 = true;
/* 797 */               } else if (bhj_value100.equals(((UTF8String) references[32]))) {
/* 798 */                 bhj_isNull131 = false;
/* 799 */                 bhj_value131 = true;
/* 800 */               }
/* 801 */             }
/* 802 */
/* 803 */             if (!bhj_value131) {
/* 804 */               if (false) {
/* 805 */                 bhj_isNull131 = true;
/* 806 */               } else if (bhj_value100.equals(((UTF8String) references[33]))) {
/* 807 */                 bhj_isNull131 = false;
/* 808 */                 bhj_value131 = true;
/* 809 */               }
/* 810 */             }
/* 811 */
/* 812 */             if (!bhj_value131) {
/* 813 */               if (false) {
/* 814 */                 bhj_isNull131 = true;
/* 815 */               } else if (bhj_value100.equals(((UTF8String) references[34]))) {
/* 816 */                 bhj_isNull131 = false;
/* 817 */                 bhj_value131 = true;
/* 818 */               }
/* 819 */             }
/* 820 */
/* 821 */           }
/* 822 */           boolean bhj_isNull130 = false;
/* 823 */           boolean bhj_value130 = false;
/* 824 */
/* 825 */           if (!bhj_isNull131 && !bhj_value131) {
/* 826 */           } else {
/* 827 */             boolean bhj_isNull136 = true;
/* 828 */             boolean bhj_value136 = false;
/* 829 */
/* 830 */             if (!smj_isNull11) {
/* 831 */               bhj_isNull136 = false; // resultCode could change nullability.
/* 832 */               bhj_value136 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value15, 50.0D) >= 0;
/* 833 */
/* 834 */             }
/* 835 */             if (!bhj_isNull136 && !bhj_value136) {
/* 836 */             } else if (!bhj_isNull131 && !bhj_isNull136) {
/* 837 */               bhj_value130 = true;
/* 838 */             } else {
/* 839 */               bhj_isNull130 = true;
/* 840 */             }
/* 841 */           }
/* 842 */           boolean bhj_isNull129 = false;
/* 843 */           boolean bhj_value129 = false;
/* 844 */
/* 845 */           if (!bhj_isNull130 && !bhj_value130) {
/* 846 */           } else {
/* 847 */             boolean bhj_isNull139 = true;
/* 848 */             boolean bhj_value139 = false;
/* 849 */
/* 850 */             if (!smj_isNull11) {
/* 851 */               bhj_isNull139 = false; // resultCode could change nullability.
/* 852 */               bhj_value139 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value15, 250.0D) <= 0;
/* 853 */
/* 854 */             }
/* 855 */             if (!bhj_isNull139 && !bhj_value139) {
/* 856 */             } else if (!bhj_isNull130 && !bhj_isNull139) {
/* 857 */               bhj_value129 = true;
/* 858 */             } else {
/* 859 */               bhj_isNull129 = true;
/* 860 */             }
/* 861 */           }
/* 862 */           if (!bhj_isNull129 && bhj_value129) {
/* 863 */           } else if (!bhj_isNull102 && !bhj_isNull129) {
/* 864 */             bhj_value101 = false;
/* 865 */           } else {
/* 866 */             bhj_isNull101 = true;
/* 867 */           }
/* 868 */         }
/* 869 */         if (bhj_isNull101 || !bhj_value101) continue;
/* 870 */
/* 871 */         bhj_numOutputRows3.add(1);
/* 872 */
/* 873 */         // generate join key for stream side
/* 874 */
/* 875 */         boolean bhj_isNull151 = smj_isNull12;
/* 876 */         long bhj_value151 = -1L;
/* 877 */         if (!smj_isNull12) {
/* 878 */           bhj_value151 = (long) smj_value16;
/* 879 */         }
/* 880 */         // find matches from HashedRelation
/* 881 */         UnsafeRow bhj_matched4 = bhj_isNull151 ? null: (UnsafeRow)bhj_relation4.getValue(bhj_value151);
/* 882 */         if (bhj_matched4 == null) continue;
/* 883 */
/* 884 */         bhj_numOutputRows4.add(1);
/* 885 */
/* 886 */         boolean smj_isNull17 = smj_rightRow1.isNullAt(4);
/* 887 */         long smj_value21 = smj_isNull17 ? -1L : (smj_rightRow1.getLong(4));
/* 888 */
/* 889 */         // generate join key for stream side
/* 890 */
/* 891 */         // find matches from HashedRelation
/* 892 */         UnsafeRow bhj_matched5 = smj_isNull17 ? null: (UnsafeRow)bhj_relation5.getValue(smj_value21);
/* 893 */         if (bhj_matched5 == null) continue;
/* 894 */
/* 895 */         bhj_numOutputRows5.add(1);
/* 896 */
/* 897 */         boolean smj_isNull19 = smj_rightRow1.isNullAt(6);
/* 898 */         double smj_value23 = smj_isNull19 ? -1.0 : (smj_rightRow1.getDouble(6));
/* 899 */         boolean smj_isNull20 = smj_rightRow1.isNullAt(7);
/* 900 */         double smj_value24 = smj_isNull20 ? -1.0 : (smj_rightRow1.getDouble(7));
/* 901 */         boolean bhj_isNull162 = bhj_matched5.isNullAt(1);
/* 902 */         UTF8String bhj_value162 = bhj_isNull162 ? null : (bhj_matched5.getUTF8String(1));
/* 903 */
/* 904 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 905 */
/* 906 */         UnsafeRow agg_fastAggBuffer = null;
/* 907 */
/* 908 */         if (true) {
/* 909 */           if (!bhj_isNull162) {
/* 910 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 911 */               bhj_value162);
/* 912 */           }
/* 913 */         }
/* 914 */
/* 915 */         if (agg_fastAggBuffer == null) {
/* 916 */           // generate grouping key
/* 917 */           agg_holder.reset();
/* 918 */
/* 919 */           agg_rowWriter.zeroOutNullBytes();
/* 920 */
/* 921 */           if (bhj_isNull162) {
/* 922 */             agg_rowWriter.setNullAt(0);
/* 923 */           } else {
/* 924 */             agg_rowWriter.write(0, bhj_value162);
/* 925 */           }
/* 926 */           agg_result1.setTotalSize(agg_holder.totalSize());
/* 927 */           agg_value22 = 42;
/* 928 */
/* 929 */           if (!bhj_isNull162) {
/* 930 */             agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value162.getBaseObject(), bhj_value162.getBaseOffset(), bhj_value162.numBytes(), agg_value22);
/* 931 */           }
/* 932 */           if (true) {
/* 933 */             // try to get the buffer from hash map
/* 934 */             agg_unsafeRowAggBuffer =
/* 935 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value22);
/* 936 */           }
/* 937 */           if (agg_unsafeRowAggBuffer == null) {
/* 938 */             if (agg_sorter == null) {
/* 939 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 940 */             } else {
/* 941 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 942 */             }
/* 943 */
/* 944 */             // the hash map had be spilled, it should have enough memory now,
/* 945 */             // try  to allocate buffer again.
/* 946 */             agg_unsafeRowAggBuffer =
/* 947 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value22);
/* 948 */             if (agg_unsafeRowAggBuffer == null) {
/* 949 */               // failed to allocate the first page
/* 950 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 951 */             }
/* 952 */           }
/* 953 */         }
/* 954 */
/* 955 */         if (agg_fastAggBuffer != null) {
/* 956 */           // update fast row
/* 957 */
/* 958 */           // common sub-expressions
/* 959 */           boolean agg_isNull68 = smj_isNull9;
/* 960 */           long agg_value76 = -1L;
/* 961 */           if (!smj_isNull9) {
/* 962 */             agg_value76 = (long) smj_value13;
/* 963 */           }
/* 964 */           boolean agg_isNull70 = smj_isNull9;
/* 965 */           long agg_value78 = -1L;
/* 966 */           if (!smj_isNull9) {
/* 967 */             agg_value78 = (long) smj_value13;
/* 968 */           }
/* 969 */           boolean agg_isNull74 = smj_isNull9;
/* 970 */           long agg_value82 = -1L;
/* 971 */           if (!smj_isNull9) {
/* 972 */             agg_value82 = (long) smj_value13;
/* 973 */           }
/* 974 */           boolean agg_isNull73 = agg_isNull74;
/* 975 */           double agg_value81 = -1.0;
/* 976 */           if (!agg_isNull74) {
/* 977 */             agg_value81 = (double) agg_value82;
/* 978 */           }
/* 979 */           boolean agg_isNull72 = agg_isNull73;
/* 980 */           double agg_value80 = agg_value81;
/* 981 */           if (agg_isNull72) {
/* 982 */             boolean agg_isNull76 = false;
/* 983 */             double agg_value84 = -1.0;
/* 984 */             if (!false) {
/* 985 */               agg_value84 = (double) 0;
/* 986 */             }
/* 987 */             if (!agg_isNull76) {
/* 988 */               agg_isNull72 = false;
/* 989 */               agg_value80 = agg_value84;
/* 990 */             }
/* 991 */           }
/* 992 */           // evaluate aggregate function
/* 993 */           boolean agg_isNull78 = true;
/* 994 */           double agg_value86 = -1.0;
/* 995 */
/* 996 */           boolean agg_isNull79 = agg_fastAggBuffer.isNullAt(0);
/* 997 */           double agg_value87 = agg_isNull79 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 998 */           if (!agg_isNull79) {
/* 999 */             agg_isNull78 = false; // resultCode could change nullability.
/* 1000 */             agg_value86 = agg_value87 + agg_value80;
/* 1001 */
/* 1002 */           }
/* 1003 */           boolean agg_isNull80 = false;
/* 1004 */           long agg_value88 = -1L;
/* 1005 */           if (!false && agg_isNull68) {
/* 1006 */             boolean agg_isNull81 = agg_fastAggBuffer.isNullAt(1);
/* 1007 */             long agg_value89 = agg_isNull81 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 1008 */             agg_isNull80 = agg_isNull81;
/* 1009 */             agg_value88 = agg_value89;
/* 1010 */           } else {
/* 1011 */             boolean agg_isNull82 = true;
/* 1012 */             long agg_value90 = -1L;
/* 1013 */
/* 1014 */             boolean agg_isNull83 = agg_fastAggBuffer.isNullAt(1);
/* 1015 */             long agg_value91 = agg_isNull83 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 1016 */             if (!agg_isNull83) {
/* 1017 */               agg_isNull82 = false; // resultCode could change nullability.
/* 1018 */               agg_value90 = agg_value91 + 1L;
/* 1019 */
/* 1020 */             }
/* 1021 */             agg_isNull80 = agg_isNull82;
/* 1022 */             agg_value88 = agg_value90;
/* 1023 */           }
/* 1024 */           boolean agg_isNull85 = true;
/* 1025 */           double agg_value93 = -1.0;
/* 1026 */
/* 1027 */           boolean agg_isNull86 = agg_fastAggBuffer.isNullAt(2);
/* 1028 */           double agg_value94 = agg_isNull86 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 1029 */           if (!agg_isNull86) {
/* 1030 */             boolean agg_isNull87 = smj_isNull20;
/* 1031 */             double agg_value95 = smj_value24;
/* 1032 */             if (agg_isNull87) {
/* 1033 */               boolean agg_isNull89 = false;
/* 1034 */               double agg_value97 = -1.0;
/* 1035 */               if (!false) {
/* 1036 */                 agg_value97 = (double) 0;
/* 1037 */               }
/* 1038 */               if (!agg_isNull89) {
/* 1039 */                 agg_isNull87 = false;
/* 1040 */                 agg_value95 = agg_value97;
/* 1041 */               }
/* 1042 */             }
/* 1043 */
/* 1044 */             agg_isNull85 = false; // resultCode could change nullability.
/* 1045 */             agg_value93 = agg_value94 + agg_value95;
/* 1046 */
/* 1047 */           }
/* 1048 */           boolean agg_isNull91 = false;
/* 1049 */           long agg_value99 = -1L;
/* 1050 */           if (!false && smj_isNull20) {
/* 1051 */             boolean agg_isNull94 = agg_fastAggBuffer.isNullAt(3);
/* 1052 */             long agg_value102 = agg_isNull94 ? -1L : (agg_fastAggBuffer.getLong(3));
/* 1053 */             agg_isNull91 = agg_isNull94;
/* 1054 */             agg_value99 = agg_value102;
/* 1055 */           } else {
/* 1056 */             boolean agg_isNull95 = true;
/* 1057 */             long agg_value103 = -1L;
/* 1058 */
/* 1059 */             boolean agg_isNull96 = agg_fastAggBuffer.isNullAt(3);
/* 1060 */             long agg_value104 = agg_isNull96 ? -1L : (agg_fastAggBuffer.getLong(3));
/* 1061 */             if (!agg_isNull96) {
/* 1062 */               agg_isNull95 = false; // resultCode could change nullability.
/* 1063 */               agg_value103 = agg_value104 + 1L;
/* 1064 */
/* 1065 */             }
/* 1066 */             agg_isNull91 = agg_isNull95;
/* 1067 */             agg_value99 = agg_value103;
/* 1068 */           }
/* 1069 */           boolean agg_isNull98 = true;
/* 1070 */           double agg_value106 = -1.0;
/* 1071 */
/* 1072 */           boolean agg_isNull99 = agg_fastAggBuffer.isNullAt(4);
/* 1073 */           double agg_value107 = agg_isNull99 ? -1.0 : (agg_fastAggBuffer.getDouble(4));
/* 1074 */           if (!agg_isNull99) {
/* 1075 */             boolean agg_isNull100 = smj_isNull19;
/* 1076 */             double agg_value108 = smj_value23;
/* 1077 */             if (agg_isNull100) {
/* 1078 */               boolean agg_isNull102 = false;
/* 1079 */               double agg_value110 = -1.0;
/* 1080 */               if (!false) {
/* 1081 */                 agg_value110 = (double) 0;
/* 1082 */               }
/* 1083 */               if (!agg_isNull102) {
/* 1084 */                 agg_isNull100 = false;
/* 1085 */                 agg_value108 = agg_value110;
/* 1086 */               }
/* 1087 */             }
/* 1088 */
/* 1089 */             agg_isNull98 = false; // resultCode could change nullability.
/* 1090 */             agg_value106 = agg_value107 + agg_value108;
/* 1091 */
/* 1092 */           }
/* 1093 */           boolean agg_isNull104 = false;
/* 1094 */           long agg_value112 = -1L;
/* 1095 */           if (!false && smj_isNull19) {
/* 1096 */             boolean agg_isNull107 = agg_fastAggBuffer.isNullAt(5);
/* 1097 */             long agg_value115 = agg_isNull107 ? -1L : (agg_fastAggBuffer.getLong(5));
/* 1098 */             agg_isNull104 = agg_isNull107;
/* 1099 */             agg_value112 = agg_value115;
/* 1100 */           } else {
/* 1101 */             boolean agg_isNull108 = true;
/* 1102 */             long agg_value116 = -1L;
/* 1103 */
/* 1104 */             boolean agg_isNull109 = agg_fastAggBuffer.isNullAt(5);
/* 1105 */             long agg_value117 = agg_isNull109 ? -1L : (agg_fastAggBuffer.getLong(5));
/* 1106 */             if (!agg_isNull109) {
/* 1107 */               agg_isNull108 = false; // resultCode could change nullability.
/* 1108 */               agg_value116 = agg_value117 + 1L;
/* 1109 */
/* 1110 */             }
/* 1111 */             agg_isNull104 = agg_isNull108;
/* 1112 */             agg_value112 = agg_value116;
/* 1113 */           }
/* 1114 */           boolean agg_isNull111 = true;
/* 1115 */           double agg_value119 = -1.0;
/* 1116 */
/* 1117 */           boolean agg_isNull112 = agg_fastAggBuffer.isNullAt(6);
/* 1118 */           double agg_value120 = agg_isNull112 ? -1.0 : (agg_fastAggBuffer.getDouble(6));
/* 1119 */           if (!agg_isNull112) {
/* 1120 */             agg_isNull111 = false; // resultCode could change nullability.
/* 1121 */             agg_value119 = agg_value120 + agg_value80;
/* 1122 */
/* 1123 */           }
/* 1124 */           boolean agg_isNull113 = false;
/* 1125 */           long agg_value121 = -1L;
/* 1126 */           if (!false && agg_isNull68) {
/* 1127 */             boolean agg_isNull114 = agg_fastAggBuffer.isNullAt(7);
/* 1128 */             long agg_value122 = agg_isNull114 ? -1L : (agg_fastAggBuffer.getLong(7));
/* 1129 */             agg_isNull113 = agg_isNull114;
/* 1130 */             agg_value121 = agg_value122;
/* 1131 */           } else {
/* 1132 */             boolean agg_isNull115 = true;
/* 1133 */             long agg_value123 = -1L;
/* 1134 */
/* 1135 */             boolean agg_isNull116 = agg_fastAggBuffer.isNullAt(7);
/* 1136 */             long agg_value124 = agg_isNull116 ? -1L : (agg_fastAggBuffer.getLong(7));
/* 1137 */             if (!agg_isNull116) {
/* 1138 */               agg_isNull115 = false; // resultCode could change nullability.
/* 1139 */               agg_value123 = agg_value124 + 1L;
/* 1140 */
/* 1141 */             }
/* 1142 */             agg_isNull113 = agg_isNull115;
/* 1143 */             agg_value121 = agg_value123;
/* 1144 */           }
/* 1145 */           // update fast row
/* 1146 */           if (!agg_isNull78) {
/* 1147 */             agg_fastAggBuffer.setDouble(0, agg_value86);
/* 1148 */           } else {
/* 1149 */             agg_fastAggBuffer.setNullAt(0);
/* 1150 */           }
/* 1151 */
/* 1152 */           if (!agg_isNull80) {
/* 1153 */             agg_fastAggBuffer.setLong(1, agg_value88);
/* 1154 */           } else {
/* 1155 */             agg_fastAggBuffer.setNullAt(1);
/* 1156 */           }
/* 1157 */
/* 1158 */           if (!agg_isNull85) {
/* 1159 */             agg_fastAggBuffer.setDouble(2, agg_value93);
/* 1160 */           } else {
/* 1161 */             agg_fastAggBuffer.setNullAt(2);
/* 1162 */           }
/* 1163 */
/* 1164 */           if (!agg_isNull91) {
/* 1165 */             agg_fastAggBuffer.setLong(3, agg_value99);
/* 1166 */           } else {
/* 1167 */             agg_fastAggBuffer.setNullAt(3);
/* 1168 */           }
/* 1169 */
/* 1170 */           if (!agg_isNull98) {
/* 1171 */             agg_fastAggBuffer.setDouble(4, agg_value106);
/* 1172 */           } else {
/* 1173 */             agg_fastAggBuffer.setNullAt(4);
/* 1174 */           }
/* 1175 */
/* 1176 */           if (!agg_isNull104) {
/* 1177 */             agg_fastAggBuffer.setLong(5, agg_value112);
/* 1178 */           } else {
/* 1179 */             agg_fastAggBuffer.setNullAt(5);
/* 1180 */           }
/* 1181 */
/* 1182 */           if (!agg_isNull111) {
/* 1183 */             agg_fastAggBuffer.setDouble(6, agg_value119);
/* 1184 */           } else {
/* 1185 */             agg_fastAggBuffer.setNullAt(6);
/* 1186 */           }
/* 1187 */
/* 1188 */           if (!agg_isNull113) {
/* 1189 */             agg_fastAggBuffer.setLong(7, agg_value121);
/* 1190 */           } else {
/* 1191 */             agg_fastAggBuffer.setNullAt(7);
/* 1192 */           }
/* 1193 */
/* 1194 */         } else {
/* 1195 */           // update unsafe row
/* 1196 */
/* 1197 */           // common sub-expressions
/* 1198 */           boolean agg_isNull17 = smj_isNull9;
/* 1199 */           long agg_value25 = -1L;
/* 1200 */           if (!smj_isNull9) {
/* 1201 */             agg_value25 = (long) smj_value13;
/* 1202 */           }
/* 1203 */           boolean agg_isNull19 = smj_isNull9;
/* 1204 */           long agg_value27 = -1L;
/* 1205 */           if (!smj_isNull9) {
/* 1206 */             agg_value27 = (long) smj_value13;
/* 1207 */           }
/* 1208 */           boolean agg_isNull23 = smj_isNull9;
/* 1209 */           long agg_value31 = -1L;
/* 1210 */           if (!smj_isNull9) {
/* 1211 */             agg_value31 = (long) smj_value13;
/* 1212 */           }
/* 1213 */           boolean agg_isNull22 = agg_isNull23;
/* 1214 */           double agg_value30 = -1.0;
/* 1215 */           if (!agg_isNull23) {
/* 1216 */             agg_value30 = (double) agg_value31;
/* 1217 */           }
/* 1218 */           boolean agg_isNull21 = agg_isNull22;
/* 1219 */           double agg_value29 = agg_value30;
/* 1220 */           if (agg_isNull21) {
/* 1221 */             boolean agg_isNull25 = false;
/* 1222 */             double agg_value33 = -1.0;
/* 1223 */             if (!false) {
/* 1224 */               agg_value33 = (double) 0;
/* 1225 */             }
/* 1226 */             if (!agg_isNull25) {
/* 1227 */               agg_isNull21 = false;
/* 1228 */               agg_value29 = agg_value33;
/* 1229 */             }
/* 1230 */           }
/* 1231 */           // evaluate aggregate function
/* 1232 */           boolean agg_isNull27 = true;
/* 1233 */           double agg_value35 = -1.0;
/* 1234 */
/* 1235 */           boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 1236 */           double agg_value36 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 1237 */           if (!agg_isNull28) {
/* 1238 */             agg_isNull27 = false; // resultCode could change nullability.
/* 1239 */             agg_value35 = agg_value36 + agg_value29;
/* 1240 */
/* 1241 */           }
/* 1242 */           boolean agg_isNull29 = false;
/* 1243 */           long agg_value37 = -1L;
/* 1244 */           if (!false && agg_isNull17) {
/* 1245 */             boolean agg_isNull30 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 1246 */             long agg_value38 = agg_isNull30 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 1247 */             agg_isNull29 = agg_isNull30;
/* 1248 */             agg_value37 = agg_value38;
/* 1249 */           } else {
/* 1250 */             boolean agg_isNull31 = true;
/* 1251 */             long agg_value39 = -1L;
/* 1252 */
/* 1253 */             boolean agg_isNull32 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 1254 */             long agg_value40 = agg_isNull32 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 1255 */             if (!agg_isNull32) {
/* 1256 */               agg_isNull31 = false; // resultCode could change nullability.
/* 1257 */               agg_value39 = agg_value40 + 1L;
/* 1258 */
/* 1259 */             }
/* 1260 */             agg_isNull29 = agg_isNull31;
/* 1261 */             agg_value37 = agg_value39;
/* 1262 */           }
/* 1263 */           boolean agg_isNull34 = true;
/* 1264 */           double agg_value42 = -1.0;
/* 1265 */
/* 1266 */           boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 1267 */           double agg_value43 = agg_isNull35 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 1268 */           if (!agg_isNull35) {
/* 1269 */             boolean agg_isNull36 = smj_isNull20;
/* 1270 */             double agg_value44 = smj_value24;
/* 1271 */             if (agg_isNull36) {
/* 1272 */               boolean agg_isNull38 = false;
/* 1273 */               double agg_value46 = -1.0;
/* 1274 */               if (!false) {
/* 1275 */                 agg_value46 = (double) 0;
/* 1276 */               }
/* 1277 */               if (!agg_isNull38) {
/* 1278 */                 agg_isNull36 = false;
/* 1279 */                 agg_value44 = agg_value46;
/* 1280 */               }
/* 1281 */             }
/* 1282 */
/* 1283 */             agg_isNull34 = false; // resultCode could change nullability.
/* 1284 */             agg_value42 = agg_value43 + agg_value44;
/* 1285 */
/* 1286 */           }
/* 1287 */           boolean agg_isNull40 = false;
/* 1288 */           long agg_value48 = -1L;
/* 1289 */           if (!false && smj_isNull20) {
/* 1290 */             boolean agg_isNull43 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 1291 */             long agg_value51 = agg_isNull43 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 1292 */             agg_isNull40 = agg_isNull43;
/* 1293 */             agg_value48 = agg_value51;
/* 1294 */           } else {
/* 1295 */             boolean agg_isNull44 = true;
/* 1296 */             long agg_value52 = -1L;
/* 1297 */
/* 1298 */             boolean agg_isNull45 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 1299 */             long agg_value53 = agg_isNull45 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 1300 */             if (!agg_isNull45) {
/* 1301 */               agg_isNull44 = false; // resultCode could change nullability.
/* 1302 */               agg_value52 = agg_value53 + 1L;
/* 1303 */
/* 1304 */             }
/* 1305 */             agg_isNull40 = agg_isNull44;
/* 1306 */             agg_value48 = agg_value52;
/* 1307 */           }
/* 1308 */           boolean agg_isNull47 = true;
/* 1309 */           double agg_value55 = -1.0;
/* 1310 */
/* 1311 */           boolean agg_isNull48 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 1312 */           double agg_value56 = agg_isNull48 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 1313 */           if (!agg_isNull48) {
/* 1314 */             boolean agg_isNull49 = smj_isNull19;
/* 1315 */             double agg_value57 = smj_value23;
/* 1316 */             if (agg_isNull49) {
/* 1317 */               boolean agg_isNull51 = false;
/* 1318 */               double agg_value59 = -1.0;
/* 1319 */               if (!false) {
/* 1320 */                 agg_value59 = (double) 0;
/* 1321 */               }
/* 1322 */               if (!agg_isNull51) {
/* 1323 */                 agg_isNull49 = false;
/* 1324 */                 agg_value57 = agg_value59;
/* 1325 */               }
/* 1326 */             }
/* 1327 */
/* 1328 */             agg_isNull47 = false; // resultCode could change nullability.
/* 1329 */             agg_value55 = agg_value56 + agg_value57;
/* 1330 */
/* 1331 */           }
/* 1332 */           boolean agg_isNull53 = false;
/* 1333 */           long agg_value61 = -1L;
/* 1334 */           if (!false && smj_isNull19) {
/* 1335 */             boolean agg_isNull56 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 1336 */             long agg_value64 = agg_isNull56 ? -1L : (agg_unsafeRowAggBuffer.getLong(5));
/* 1337 */             agg_isNull53 = agg_isNull56;
/* 1338 */             agg_value61 = agg_value64;
/* 1339 */           } else {
/* 1340 */             boolean agg_isNull57 = true;
/* 1341 */             long agg_value65 = -1L;
/* 1342 */
/* 1343 */             boolean agg_isNull58 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 1344 */             long agg_value66 = agg_isNull58 ? -1L : (agg_unsafeRowAggBuffer.getLong(5));
/* 1345 */             if (!agg_isNull58) {
/* 1346 */               agg_isNull57 = false; // resultCode could change nullability.
/* 1347 */               agg_value65 = agg_value66 + 1L;
/* 1348 */
/* 1349 */             }
/* 1350 */             agg_isNull53 = agg_isNull57;
/* 1351 */             agg_value61 = agg_value65;
/* 1352 */           }
/* 1353 */           boolean agg_isNull60 = true;
/* 1354 */           double agg_value68 = -1.0;
/* 1355 */
/* 1356 */           boolean agg_isNull61 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 1357 */           double agg_value69 = agg_isNull61 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 1358 */           if (!agg_isNull61) {
/* 1359 */             agg_isNull60 = false; // resultCode could change nullability.
/* 1360 */             agg_value68 = agg_value69 + agg_value29;
/* 1361 */
/* 1362 */           }
/* 1363 */           boolean agg_isNull62 = false;
/* 1364 */           long agg_value70 = -1L;
/* 1365 */           if (!false && agg_isNull17) {
/* 1366 */             boolean agg_isNull63 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 1367 */             long agg_value71 = agg_isNull63 ? -1L : (agg_unsafeRowAggBuffer.getLong(7));
/* 1368 */             agg_isNull62 = agg_isNull63;
/* 1369 */             agg_value70 = agg_value71;
/* 1370 */           } else {
/* 1371 */             boolean agg_isNull64 = true;
/* 1372 */             long agg_value72 = -1L;
/* 1373 */
/* 1374 */             boolean agg_isNull65 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 1375 */             long agg_value73 = agg_isNull65 ? -1L : (agg_unsafeRowAggBuffer.getLong(7));
/* 1376 */             if (!agg_isNull65) {
/* 1377 */               agg_isNull64 = false; // resultCode could change nullability.
/* 1378 */               agg_value72 = agg_value73 + 1L;
/* 1379 */
/* 1380 */             }
/* 1381 */             agg_isNull62 = agg_isNull64;
/* 1382 */             agg_value70 = agg_value72;
/* 1383 */           }
/* 1384 */           // update unsafe row buffer
/* 1385 */           if (!agg_isNull27) {
/* 1386 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value35);
/* 1387 */           } else {
/* 1388 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 1389 */           }
/* 1390 */
/* 1391 */           if (!agg_isNull29) {
/* 1392 */             agg_unsafeRowAggBuffer.setLong(1, agg_value37);
/* 1393 */           } else {
/* 1394 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 1395 */           }
/* 1396 */
/* 1397 */           if (!agg_isNull34) {
/* 1398 */             agg_unsafeRowAggBuffer.setDouble(2, agg_value42);
/* 1399 */           } else {
/* 1400 */             agg_unsafeRowAggBuffer.setNullAt(2);
/* 1401 */           }
/* 1402 */
/* 1403 */           if (!agg_isNull40) {
/* 1404 */             agg_unsafeRowAggBuffer.setLong(3, agg_value48);
/* 1405 */           } else {
/* 1406 */             agg_unsafeRowAggBuffer.setNullAt(3);
/* 1407 */           }
/* 1408 */
/* 1409 */           if (!agg_isNull47) {
/* 1410 */             agg_unsafeRowAggBuffer.setDouble(4, agg_value55);
/* 1411 */           } else {
/* 1412 */             agg_unsafeRowAggBuffer.setNullAt(4);
/* 1413 */           }
/* 1414 */
/* 1415 */           if (!agg_isNull53) {
/* 1416 */             agg_unsafeRowAggBuffer.setLong(5, agg_value61);
/* 1417 */           } else {
/* 1418 */             agg_unsafeRowAggBuffer.setNullAt(5);
/* 1419 */           }
/* 1420 */
/* 1421 */           if (!agg_isNull60) {
/* 1422 */             agg_unsafeRowAggBuffer.setDouble(6, agg_value68);
/* 1423 */           } else {
/* 1424 */             agg_unsafeRowAggBuffer.setNullAt(6);
/* 1425 */           }
/* 1426 */
/* 1427 */           if (!agg_isNull62) {
/* 1428 */             agg_unsafeRowAggBuffer.setLong(7, agg_value70);
/* 1429 */           } else {
/* 1430 */             agg_unsafeRowAggBuffer.setNullAt(7);
/* 1431 */           }
/* 1432 */
/* 1433 */         }
/* 1434 */
/* 1435 */       }
/* 1436 */       if (shouldStop()) return;
/* 1437 */     }
/* 1438 */
/* 1439 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 1440 */
/* 1441 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1442 */   }
/* 1443 */
/* 1444 */   private boolean findNextInnerJoinRows(
/* 1445 */     scala.collection.Iterator leftIter,
/* 1446 */     scala.collection.Iterator rightIter) {
/* 1447 */     smj_leftRow = null;
/* 1448 */     int comp = 0;
/* 1449 */     while (smj_leftRow == null) {
/* 1450 */       if (!leftIter.hasNext()) return false;
/* 1451 */       smj_leftRow = (InternalRow) leftIter.next();
/* 1452 */
/* 1453 */       boolean smj_isNull1 = smj_leftRow.isNullAt(0);
/* 1454 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(0));
/* 1455 */       boolean smj_isNull = smj_isNull1;
/* 1456 */       long smj_value = -1L;
/* 1457 */       if (!smj_isNull1) {
/* 1458 */         smj_value = (long) smj_value1;
/* 1459 */       }
/* 1460 */
/* 1461 */       boolean smj_isNull3 = smj_leftRow.isNullAt(2);
/* 1462 */       int smj_value3 = smj_isNull3 ? -1 : (smj_leftRow.getInt(2));
/* 1463 */       boolean smj_isNull2 = smj_isNull3;
/* 1464 */       long smj_value2 = -1L;
/* 1465 */       if (!smj_isNull3) {
/* 1466 */         smj_value2 = (long) smj_value3;
/* 1467 */       }
/* 1468 */       if (smj_isNull || smj_isNull2) {
/* 1469 */         smj_leftRow = null;
/* 1470 */         continue;
/* 1471 */       }
/* 1472 */       if (!smj_matches.isEmpty()) {
/* 1473 */         comp = 0;
/* 1474 */         if (comp == 0) {
/* 1475 */           comp = (smj_value > smj_value8 ? 1 : smj_value < smj_value8 ? -1 : 0);
/* 1476 */         }
/* 1477 */         if (comp == 0) {
/* 1478 */           comp = (smj_value2 > smj_value9 ? 1 : smj_value2 < smj_value9 ? -1 : 0);
/* 1479 */         }
/* 1480 */
/* 1481 */         if (comp == 0) {
/* 1482 */           return true;
/* 1483 */         }
/* 1484 */         smj_matches.clear();
/* 1485 */       }
/* 1486 */
/* 1487 */       do {
/* 1488 */         if (smj_rightRow == null) {
/* 1489 */           if (!rightIter.hasNext()) {
/* 1490 */             smj_value8 = smj_value;
/* 1491 */             smj_value9 = smj_value2;
/* 1492 */             return !smj_matches.isEmpty();
/* 1493 */           }
/* 1494 */           smj_rightRow = (InternalRow) rightIter.next();
/* 1495 */
/* 1496 */           boolean smj_isNull4 = smj_rightRow.isNullAt(0);
/* 1497 */           long smj_value4 = smj_isNull4 ? -1L : (smj_rightRow.getLong(0));
/* 1498 */
/* 1499 */           boolean smj_isNull5 = smj_rightRow.isNullAt(5);
/* 1500 */           long smj_value5 = smj_isNull5 ? -1L : (smj_rightRow.getLong(5));
/* 1501 */           if (smj_isNull4 || smj_isNull5) {
/* 1502 */             smj_rightRow = null;
/* 1503 */             continue;
/* 1504 */           }
/* 1505 */           smj_value6 = smj_value4;
/* 1506 */           smj_value7 = smj_value5;
/* 1507 */         }
/* 1508 */
/* 1509 */         comp = 0;
/* 1510 */         if (comp == 0) {
/* 1511 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 1512 */         }
/* 1513 */         if (comp == 0) {
/* 1514 */           comp = (smj_value2 > smj_value7 ? 1 : smj_value2 < smj_value7 ? -1 : 0);
/* 1515 */         }
/* 1516 */
/* 1517 */         if (comp > 0) {
/* 1518 */           smj_rightRow = null;
/* 1519 */         } else if (comp < 0) {
/* 1520 */           if (!smj_matches.isEmpty()) {
/* 1521 */             smj_value8 = smj_value;
/* 1522 */             smj_value9 = smj_value2;
/* 1523 */             return true;
/* 1524 */           }
/* 1525 */           smj_leftRow = null;
/* 1526 */         } else {
/* 1527 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 1528 */           smj_rightRow = null;;
/* 1529 */         }
/* 1530 */       } while (smj_leftRow != null);
/* 1531 */     }
/* 1532 */     return false; // unreachable
/* 1533 */   }
/* 1534 */
/* 1535 */   private void wholestagecodegen_init_5() {
/* 1536 */     this.bhj_rowWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder5, 6);
/* 1537 */     project_result5 = new UnsafeRow(4);
/* 1538 */     this.project_holder5 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result5, 0);
/* 1539 */     this.project_rowWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder5, 4);
/* 1540 */     this.bhj_broadcast5 = (org.apache.spark.broadcast.TorrentBroadcast) references[38];
/* 1541 */
/* 1542 */     bhj_relation5 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast5.value()).asReadOnlyCopy();
/* 1543 */     incPeakExecutionMemory(bhj_relation5.estimatedSize());
/* 1544 */
/* 1545 */     this.bhj_numOutputRows5 = (org.apache.spark.sql.execution.metric.SQLMetric) references[39];
/* 1546 */     bhj_result6 = new UnsafeRow(6);
/* 1547 */     this.bhj_holder6 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result6, 32);
/* 1548 */     this.bhj_rowWriter6 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder6, 6);
/* 1549 */     project_result6 = new UnsafeRow(4);
/* 1550 */     this.project_holder6 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result6, 32);
/* 1551 */
/* 1552 */   }
/* 1553 */
/* 1554 */   private void wholestagecodegen_init_2() {
/* 1555 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 1556 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 1557 */
/* 1558 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[22];
/* 1559 */     bhj_result1 = new UnsafeRow(13);
/* 1560 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 1561 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 13);
/* 1562 */     project_result2 = new UnsafeRow(10);
/* 1563 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 1564 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 10);
/* 1565 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[23];
/* 1566 */
/* 1567 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.UnsafeHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 1568 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 1569 */
/* 1570 */   }
/* 1571 */
/* 1572 */   private void wholestagecodegen_init_1() {
/* 1573 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 11);
/* 1574 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 1575 */
/* 1576 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 1577 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 1578 */
/* 1579 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 1580 */     bhj_result = new UnsafeRow(12);
/* 1581 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 1582 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 12);
/* 1583 */     project_result1 = new UnsafeRow(10);
/* 1584 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 1585 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 10);
/* 1586 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[15];
/* 1587 */
/* 1588 */   }
/* 1589 */
/* 1590 */   private void wholestagecodegen_init_4() {
/* 1591 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[35];
/* 1592 */     bhj_result4 = new UnsafeRow(9);
/* 1593 */     this.bhj_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result4, 32);
/* 1594 */     this.bhj_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder4, 9);
/* 1595 */     project_result4 = new UnsafeRow(5);
/* 1596 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 0);
/* 1597 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 5);
/* 1598 */     this.bhj_broadcast4 = (org.apache.spark.broadcast.TorrentBroadcast) references[36];
/* 1599 */
/* 1600 */     bhj_relation4 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast4.value()).asReadOnlyCopy();
/* 1601 */     incPeakExecutionMemory(bhj_relation4.estimatedSize());
/* 1602 */
/* 1603 */     this.bhj_numOutputRows4 = (org.apache.spark.sql.execution.metric.SQLMetric) references[37];
/* 1604 */     bhj_result5 = new UnsafeRow(6);
/* 1605 */     this.bhj_holder5 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result5, 0);
/* 1606 */
/* 1607 */   }
/* 1608 */
/* 1609 */   private void wholestagecodegen_init_6() {
/* 1610 */     this.project_rowWriter6 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder6, 4);
/* 1611 */     agg_result1 = new UnsafeRow(1);
/* 1612 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 1613 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 1614 */
/* 1615 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 1616 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[40];
/* 1617 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[41];
/* 1618 */
/* 1619 */   }
/* 1620 */
/* 1621 */   protected void processNext() throws java.io.IOException {
/* 1622 */     if (!agg_initAgg) {
/* 1623 */       agg_initAgg = true;
/* 1624 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1625 */       agg_doAggregateWithKeys();
/* 1626 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1627 */     }
/* 1628 */
/* 1629 */     // output the result
/* 1630 */
/* 1631 */     while (agg_fastHashMapIter.next()) {
/* 1632 */       wholestagecodegen_numOutputRows.add(1);
/* 1633 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 1634 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 1635 */
/* 1636 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1637 */
/* 1638 */       append(agg_resultRow.copy());
/* 1639 */
/* 1640 */       if (shouldStop()) return;
/* 1641 */     }
/* 1642 */     agg_fastHashMap.close();
/* 1643 */
/* 1644 */     while (agg_mapIter.next()) {
/* 1645 */       wholestagecodegen_numOutputRows.add(1);
/* 1646 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1647 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1648 */
/* 1649 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1650 */
/* 1651 */       append(agg_resultRow.copy());
/* 1652 */
/* 1653 */       if (shouldStop()) return;
/* 1654 */     }
/* 1655 */
/* 1656 */     agg_mapIter.close();
/* 1657 */     if (agg_sorter == null) {
/* 1658 */       agg_hashMap.free();
/* 1659 */     }
/* 1660 */   }
/* 1661 */ }
