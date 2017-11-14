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
/* 026 */   private int smj_value4;
/* 027 */   private boolean smj_isNull2;
/* 028 */   private UTF8String smj_value5;
/* 029 */   private boolean smj_isNull3;
/* 030 */   private UTF8String smj_value6;
/* 031 */   private boolean smj_isNull4;
/* 032 */   private UTF8String smj_value7;
/* 033 */   private boolean smj_isNull5;
/* 034 */   private UTF8String smj_value8;
/* 035 */   private boolean smj_isNull6;
/* 036 */   private UTF8String smj_value9;
/* 037 */   private boolean smj_isNull7;
/* 038 */   private UTF8String smj_value10;
/* 039 */   private boolean smj_isNull8;
/* 040 */   private UTF8String smj_value11;
/* 041 */   private boolean smj_isNull9;
/* 042 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 043 */   private UnsafeRow smj_result;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 046 */   private UnsafeRow project_result;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 049 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 050 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 051 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 052 */   private UnsafeRow bhj_result;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 055 */   private UnsafeRow project_result1;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 058 */   private UnsafeRow agg_result8;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 061 */   private int agg_value18;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 063 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 064 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 065 */
/* 066 */   public GeneratedIterator(Object[] references) {
/* 067 */     this.references = references;
/* 068 */   }
/* 069 */
/* 070 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 071 */     partitionIndex = index;
/* 072 */     this.inputs = inputs;
/* 073 */     wholestagecodegen_init_0();
/* 074 */     wholestagecodegen_init_1();
/* 075 */     wholestagecodegen_init_2();
/* 076 */
/* 077 */   }
/* 078 */
/* 079 */   private void wholestagecodegen_init_0() {
/* 080 */     agg_initAgg = false;
/* 081 */
/* 082 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 083 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 084 */
/* 085 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 086 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 087 */     smj_leftInput = inputs[0];
/* 088 */     smj_rightInput = inputs[1];
/* 089 */
/* 090 */     smj_rightRow = null;
/* 091 */
/* 092 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 093 */
/* 094 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 095 */     smj_result = new UnsafeRow(12);
/* 096 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 224);
/* 097 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 12);
/* 098 */     project_result = new UnsafeRow(10);
/* 099 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 224);
/* 100 */
/* 101 */   }
/* 102 */
/* 103 */   public class agg_FastHashMap {
/* 104 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 105 */     private int[] buckets;
/* 106 */     private int capacity = 1 << 16;
/* 107 */     private double loadFactor = 0.5;
/* 108 */     private int numBuckets = (int) (capacity / loadFactor);
/* 109 */     private int maxSteps = 2;
/* 110 */     private int numRows = 0;
/* 111 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 112 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 113 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 114 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 115 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.StringType)
/* 116 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.StringType)
/* 117 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.StringType)
/* 118 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.StringType);
/* 119 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 120 */     private Object emptyVBase;
/* 121 */     private long emptyVOff;
/* 122 */     private int emptyVLen;
/* 123 */     private boolean isBatchFull = false;
/* 124 */
/* 125 */     public agg_FastHashMap(
/* 126 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 127 */       InternalRow emptyAggregationBuffer) {
/* 128 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 129 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 130 */
/* 131 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 132 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 133 */
/* 134 */       emptyVBase = emptyBuffer;
/* 135 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 136 */       emptyVLen = emptyBuffer.length;
/* 137 */
/* 138 */       buckets = new int[numBuckets];
/* 139 */       java.util.Arrays.fill(buckets, -1);
/* 140 */     }
/* 141 */
/* 142 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, UTF8String agg_key7) {
/* 143 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7);
/* 144 */       int step = 0;
/* 145 */       int idx = (int) h & (numBuckets - 1);
/* 146 */       while (step < maxSteps) {
/* 147 */         // Return bucket index if it's either an empty slot or already contains the key
/* 148 */         if (buckets[idx] == -1) {
/* 149 */           if (numRows < capacity && !isBatchFull) {
/* 150 */             // creating the unsafe for new entry
/* 151 */             UnsafeRow agg_result = new UnsafeRow(8);
/* 152 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 153 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 154 */               224);
/* 155 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 156 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 157 */               agg_holder,
/* 158 */               8);
/* 159 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 160 */             agg_rowWriter.zeroOutNullBytes();
/* 161 */             agg_rowWriter.write(0, agg_key);
/* 162 */             agg_rowWriter.write(1, agg_key1);
/* 163 */             agg_rowWriter.write(2, agg_key2);
/* 164 */             agg_rowWriter.write(3, agg_key3);
/* 165 */             agg_rowWriter.write(4, agg_key4);
/* 166 */             agg_rowWriter.write(5, agg_key5);
/* 167 */             agg_rowWriter.write(6, agg_key6);
/* 168 */             agg_rowWriter.write(7, agg_key7);
/* 169 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 170 */             Object kbase = agg_result.getBaseObject();
/* 171 */             long koff = agg_result.getBaseOffset();
/* 172 */             int klen = agg_result.getSizeInBytes();
/* 173 */
/* 174 */             UnsafeRow vRow
/* 175 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 176 */             if (vRow == null) {
/* 177 */               isBatchFull = true;
/* 178 */             } else {
/* 179 */               buckets[idx] = numRows++;
/* 180 */             }
/* 181 */             return vRow;
/* 182 */           } else {
/* 183 */             // No more space
/* 184 */             return null;
/* 185 */           }
/* 186 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7)) {
/* 187 */           return batch.getValueRow(buckets[idx]);
/* 188 */         }
/* 189 */         idx = (idx + 1) & (numBuckets - 1);
/* 190 */         step++;
/* 191 */       }
/* 192 */       // Didn't find it
/* 193 */       return null;
/* 194 */     }
/* 195 */
/* 196 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, UTF8String agg_key7) {
/* 197 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 198 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getInt(3) == agg_key3) && (row.getUTF8String(4).equals(agg_key4)) && (row.getUTF8String(5).equals(agg_key5)) && (row.getUTF8String(6).equals(agg_key6)) && (row.getUTF8String(7).equals(agg_key7));
/* 199 */     }
/* 200 */
/* 201 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, UTF8String agg_key7) {
/* 202 */       long agg_hash = 0;
/* 203 */
/* 204 */       int agg_result = 0;
/* 205 */       byte[] agg_bytes = agg_key.getBytes();
/* 206 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 207 */         int agg_hash1 = agg_bytes[i];
/* 208 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 209 */       }
/* 210 */
/* 211 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 212 */
/* 213 */       int agg_result1 = 0;
/* 214 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 215 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 216 */         int agg_hash2 = agg_bytes1[i];
/* 217 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 218 */       }
/* 219 */
/* 220 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 221 */
/* 222 */       int agg_result2 = 0;
/* 223 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 224 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 225 */         int agg_hash3 = agg_bytes2[i];
/* 226 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 227 */       }
/* 228 */
/* 229 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 230 */
/* 231 */       int agg_result3 = agg_key3;
/* 232 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 233 */
/* 234 */       int agg_result4 = 0;
/* 235 */       byte[] agg_bytes3 = agg_key4.getBytes();
/* 236 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 237 */         int agg_hash4 = agg_bytes3[i];
/* 238 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash4 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 239 */       }
/* 240 */
/* 241 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 242 */
/* 243 */       int agg_result5 = 0;
/* 244 */       byte[] agg_bytes4 = agg_key5.getBytes();
/* 245 */       for (int i = 0; i < agg_bytes4.length; i++) {
/* 246 */         int agg_hash5 = agg_bytes4[i];
/* 247 */         agg_result5 = (agg_result5 ^ (0x9e3779b9)) + agg_hash5 + (agg_result5 << 6) + (agg_result5 >>> 2);
/* 248 */       }
/* 249 */
/* 250 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 251 */
/* 252 */       int agg_result6 = 0;
/* 253 */       byte[] agg_bytes5 = agg_key6.getBytes();
/* 254 */       for (int i = 0; i < agg_bytes5.length; i++) {
/* 255 */         int agg_hash6 = agg_bytes5[i];
/* 256 */         agg_result6 = (agg_result6 ^ (0x9e3779b9)) + agg_hash6 + (agg_result6 << 6) + (agg_result6 >>> 2);
/* 257 */       }
/* 258 */
/* 259 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result6 + (agg_hash << 6) + (agg_hash >>> 2);
/* 260 */
/* 261 */       int agg_result7 = 0;
/* 262 */       byte[] agg_bytes6 = agg_key7.getBytes();
/* 263 */       for (int i = 0; i < agg_bytes6.length; i++) {
/* 264 */         int agg_hash7 = agg_bytes6[i];
/* 265 */         agg_result7 = (agg_result7 ^ (0x9e3779b9)) + agg_hash7 + (agg_result7 << 6) + (agg_result7 >>> 2);
/* 266 */       }
/* 267 */
/* 268 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result7 + (agg_hash << 6) + (agg_hash >>> 2);
/* 269 */
/* 270 */       return agg_hash;
/* 271 */     }
/* 272 */
/* 273 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 274 */       return batch.rowIterator();
/* 275 */     }
/* 276 */
/* 277 */     public void close() {
/* 278 */       batch.close();
/* 279 */     }
/* 280 */
/* 281 */   }
/* 282 */
/* 283 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 284 */     agg_hashMap = agg_plan.createHashMap();
/* 285 */
/* 286 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 287 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 288 */       smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 289 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 290 */       smj_value5 = smj_isNull3 ? null : (smj_leftRow.getUTF8String(1));
/* 291 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 292 */       smj_value6 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(2));
/* 293 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 294 */       smj_value7 = smj_isNull5 ? null : (smj_leftRow.getUTF8String(3));
/* 295 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 296 */       smj_value8 = smj_isNull6 ? null : (smj_leftRow.getUTF8String(4));
/* 297 */       smj_isNull7 = smj_leftRow.isNullAt(5);
/* 298 */       smj_value9 = smj_isNull7 ? null : (smj_leftRow.getUTF8String(5));
/* 299 */       smj_isNull8 = smj_leftRow.isNullAt(6);
/* 300 */       smj_value10 = smj_isNull8 ? null : (smj_leftRow.getUTF8String(6));
/* 301 */       smj_isNull9 = smj_leftRow.isNullAt(7);
/* 302 */       smj_value11 = smj_isNull9 ? null : (smj_leftRow.getUTF8String(7));
/* 303 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 304 */       while (smj_iterator.hasNext()) {
/* 305 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 306 */
/* 307 */         smj_numOutputRows.add(1);
/* 308 */
/* 309 */         boolean smj_isNull13 = smj_rightRow1.isNullAt(3);
/* 310 */         int smj_value15 = smj_isNull13 ? -1 : (smj_rightRow1.getInt(3));
/* 311 */
/* 312 */         // generate join key for stream side
/* 313 */
/* 314 */         boolean bhj_isNull = smj_isNull13;
/* 315 */         long bhj_value = -1L;
/* 316 */         if (!smj_isNull13) {
/* 317 */           bhj_value = (long) smj_value15;
/* 318 */         }
/* 319 */         // find matches from HashedRelation
/* 320 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 321 */         if (bhj_matched == null) continue;
/* 322 */
/* 323 */         bhj_numOutputRows.add(1);
/* 324 */
/* 325 */         boolean smj_isNull11 = smj_rightRow1.isNullAt(1);
/* 326 */         double smj_value13 = smj_isNull11 ? -1.0 : (smj_rightRow1.getDouble(1));
/* 327 */         boolean smj_isNull12 = smj_rightRow1.isNullAt(2);
/* 328 */         double smj_value14 = smj_isNull12 ? -1.0 : (smj_rightRow1.getDouble(2));
/* 329 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 330 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 331 */
/* 332 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 333 */
/* 334 */         UnsafeRow agg_fastAggBuffer = null;
/* 335 */
/* 336 */         if (true) {
/* 337 */           if (!smj_isNull3 && !smj_isNull4 && !smj_isNull5 && !bhj_isNull3 && !smj_isNull6 && !smj_isNull7 && !smj_isNull8 && !smj_isNull9) {
/* 338 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 339 */               smj_value5, smj_value6, smj_value7, bhj_value3, smj_value8, smj_value9, smj_value10, smj_value11);
/* 340 */           }
/* 341 */         }
/* 342 */
/* 343 */         if (agg_fastAggBuffer == null) {
/* 344 */           // generate grouping key
/* 345 */           agg_holder.reset();
/* 346 */
/* 347 */           agg_rowWriter.zeroOutNullBytes();
/* 348 */
/* 349 */           if (smj_isNull3) {
/* 350 */             agg_rowWriter.setNullAt(0);
/* 351 */           } else {
/* 352 */             agg_rowWriter.write(0, smj_value5);
/* 353 */           }
/* 354 */
/* 355 */           if (smj_isNull4) {
/* 356 */             agg_rowWriter.setNullAt(1);
/* 357 */           } else {
/* 358 */             agg_rowWriter.write(1, smj_value6);
/* 359 */           }
/* 360 */
/* 361 */           if (smj_isNull5) {
/* 362 */             agg_rowWriter.setNullAt(2);
/* 363 */           } else {
/* 364 */             agg_rowWriter.write(2, smj_value7);
/* 365 */           }
/* 366 */
/* 367 */           if (bhj_isNull3) {
/* 368 */             agg_rowWriter.setNullAt(3);
/* 369 */           } else {
/* 370 */             agg_rowWriter.write(3, bhj_value3);
/* 371 */           }
/* 372 */
/* 373 */           if (smj_isNull6) {
/* 374 */             agg_rowWriter.setNullAt(4);
/* 375 */           } else {
/* 376 */             agg_rowWriter.write(4, smj_value8);
/* 377 */           }
/* 378 */
/* 379 */           if (smj_isNull7) {
/* 380 */             agg_rowWriter.setNullAt(5);
/* 381 */           } else {
/* 382 */             agg_rowWriter.write(5, smj_value9);
/* 383 */           }
/* 384 */
/* 385 */           if (smj_isNull8) {
/* 386 */             agg_rowWriter.setNullAt(6);
/* 387 */           } else {
/* 388 */             agg_rowWriter.write(6, smj_value10);
/* 389 */           }
/* 390 */
/* 391 */           if (smj_isNull9) {
/* 392 */             agg_rowWriter.setNullAt(7);
/* 393 */           } else {
/* 394 */             agg_rowWriter.write(7, smj_value11);
/* 395 */           }
/* 396 */           agg_result8.setTotalSize(agg_holder.totalSize());
/* 397 */           agg_value18 = 42;
/* 398 */
/* 399 */           if (!smj_isNull3) {
/* 400 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value5.getBaseObject(), smj_value5.getBaseOffset(), smj_value5.numBytes(), agg_value18);
/* 401 */           }
/* 402 */
/* 403 */           if (!smj_isNull4) {
/* 404 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value6.getBaseObject(), smj_value6.getBaseOffset(), smj_value6.numBytes(), agg_value18);
/* 405 */           }
/* 406 */
/* 407 */           if (!smj_isNull5) {
/* 408 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value7.getBaseObject(), smj_value7.getBaseOffset(), smj_value7.numBytes(), agg_value18);
/* 409 */           }
/* 410 */
/* 411 */           if (!bhj_isNull3) {
/* 412 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value3, agg_value18);
/* 413 */           }
/* 414 */
/* 415 */           if (!smj_isNull6) {
/* 416 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value8.getBaseObject(), smj_value8.getBaseOffset(), smj_value8.numBytes(), agg_value18);
/* 417 */           }
/* 418 */
/* 419 */           if (!smj_isNull7) {
/* 420 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value9.getBaseObject(), smj_value9.getBaseOffset(), smj_value9.numBytes(), agg_value18);
/* 421 */           }
/* 422 */
/* 423 */           if (!smj_isNull8) {
/* 424 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value10.getBaseObject(), smj_value10.getBaseOffset(), smj_value10.numBytes(), agg_value18);
/* 425 */           }
/* 426 */
/* 427 */           if (!smj_isNull9) {
/* 428 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value11.getBaseObject(), smj_value11.getBaseOffset(), smj_value11.numBytes(), agg_value18);
/* 429 */           }
/* 430 */           if (true) {
/* 431 */             // try to get the buffer from hash map
/* 432 */             agg_unsafeRowAggBuffer =
/* 433 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result8, agg_value18);
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
/* 445 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result8, agg_value18);
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
/* 457 */
/* 458 */           // evaluate aggregate function
/* 459 */           boolean agg_isNull37 = true;
/* 460 */           double agg_value38 = -1.0;
/* 461 */
/* 462 */           boolean agg_isNull39 = agg_fastAggBuffer.isNullAt(0);
/* 463 */           double agg_value40 = agg_isNull39 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 464 */           boolean agg_isNull38 = agg_isNull39;
/* 465 */           double agg_value39 = agg_value40;
/* 466 */           if (agg_isNull38) {
/* 467 */             boolean agg_isNull40 = false;
/* 468 */             double agg_value41 = -1.0;
/* 469 */             if (!false) {
/* 470 */               agg_value41 = (double) 0;
/* 471 */             }
/* 472 */             if (!agg_isNull40) {
/* 473 */               agg_isNull38 = false;
/* 474 */               agg_value39 = agg_value41;
/* 475 */             }
/* 476 */           }
/* 477 */
/* 478 */           boolean agg_isNull42 = true;
/* 479 */           double agg_value43 = -1.0;
/* 480 */
/* 481 */           if (!smj_isNull12) {
/* 482 */             if (!smj_isNull11) {
/* 483 */               agg_isNull42 = false; // resultCode could change nullability.
/* 484 */               agg_value43 = smj_value14 - smj_value13;
/* 485 */
/* 486 */             }
/* 487 */
/* 488 */           }
/* 489 */           if (!agg_isNull42) {
/* 490 */             agg_isNull37 = false; // resultCode could change nullability.
/* 491 */             agg_value38 = agg_value39 + agg_value43;
/* 492 */
/* 493 */           }
/* 494 */           boolean agg_isNull36 = agg_isNull37;
/* 495 */           double agg_value37 = agg_value38;
/* 496 */           if (agg_isNull36) {
/* 497 */             boolean agg_isNull45 = agg_fastAggBuffer.isNullAt(0);
/* 498 */             double agg_value46 = agg_isNull45 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 499 */             if (!agg_isNull45) {
/* 500 */               agg_isNull36 = false;
/* 501 */               agg_value37 = agg_value46;
/* 502 */             }
/* 503 */           }
/* 504 */           // update fast row
/* 505 */           if (!agg_isNull36) {
/* 506 */             agg_fastAggBuffer.setDouble(0, agg_value37);
/* 507 */           } else {
/* 508 */             agg_fastAggBuffer.setNullAt(0);
/* 509 */           }
/* 510 */
/* 511 */         } else {
/* 512 */           // update unsafe row
/* 513 */
/* 514 */           // common sub-expressions
/* 515 */
/* 516 */           // evaluate aggregate function
/* 517 */           boolean agg_isNull27 = true;
/* 518 */           double agg_value28 = -1.0;
/* 519 */
/* 520 */           boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 521 */           double agg_value30 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 522 */           boolean agg_isNull28 = agg_isNull29;
/* 523 */           double agg_value29 = agg_value30;
/* 524 */           if (agg_isNull28) {
/* 525 */             boolean agg_isNull30 = false;
/* 526 */             double agg_value31 = -1.0;
/* 527 */             if (!false) {
/* 528 */               agg_value31 = (double) 0;
/* 529 */             }
/* 530 */             if (!agg_isNull30) {
/* 531 */               agg_isNull28 = false;
/* 532 */               agg_value29 = agg_value31;
/* 533 */             }
/* 534 */           }
/* 535 */
/* 536 */           boolean agg_isNull32 = true;
/* 537 */           double agg_value33 = -1.0;
/* 538 */
/* 539 */           if (!smj_isNull12) {
/* 540 */             if (!smj_isNull11) {
/* 541 */               agg_isNull32 = false; // resultCode could change nullability.
/* 542 */               agg_value33 = smj_value14 - smj_value13;
/* 543 */
/* 544 */             }
/* 545 */
/* 546 */           }
/* 547 */           if (!agg_isNull32) {
/* 548 */             agg_isNull27 = false; // resultCode could change nullability.
/* 549 */             agg_value28 = agg_value29 + agg_value33;
/* 550 */
/* 551 */           }
/* 552 */           boolean agg_isNull26 = agg_isNull27;
/* 553 */           double agg_value27 = agg_value28;
/* 554 */           if (agg_isNull26) {
/* 555 */             boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 556 */             double agg_value36 = agg_isNull35 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 557 */             if (!agg_isNull35) {
/* 558 */               agg_isNull26 = false;
/* 559 */               agg_value27 = agg_value36;
/* 560 */             }
/* 561 */           }
/* 562 */           // update unsafe row buffer
/* 563 */           if (!agg_isNull26) {
/* 564 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value27);
/* 565 */           } else {
/* 566 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 567 */           }
/* 568 */
/* 569 */         }
/* 570 */
/* 571 */       }
/* 572 */       if (shouldStop()) return;
/* 573 */     }
/* 574 */
/* 575 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 576 */
/* 577 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 578 */   }
/* 579 */
/* 580 */   private boolean findNextInnerJoinRows(
/* 581 */     scala.collection.Iterator leftIter,
/* 582 */     scala.collection.Iterator rightIter) {
/* 583 */     smj_leftRow = null;
/* 584 */     int comp = 0;
/* 585 */     while (smj_leftRow == null) {
/* 586 */       if (!leftIter.hasNext()) return false;
/* 587 */       smj_leftRow = (InternalRow) leftIter.next();
/* 588 */
/* 589 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 590 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(0));
/* 591 */       if (smj_isNull) {
/* 592 */         smj_leftRow = null;
/* 593 */         continue;
/* 594 */       }
/* 595 */       if (!smj_matches.isEmpty()) {
/* 596 */         comp = 0;
/* 597 */         if (comp == 0) {
/* 598 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 599 */         }
/* 600 */
/* 601 */         if (comp == 0) {
/* 602 */           return true;
/* 603 */         }
/* 604 */         smj_matches.clear();
/* 605 */       }
/* 606 */
/* 607 */       do {
/* 608 */         if (smj_rightRow == null) {
/* 609 */           if (!rightIter.hasNext()) {
/* 610 */             smj_value3 = smj_value;
/* 611 */             return !smj_matches.isEmpty();
/* 612 */           }
/* 613 */           smj_rightRow = (InternalRow) rightIter.next();
/* 614 */
/* 615 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 616 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 617 */           if (smj_isNull1) {
/* 618 */             smj_rightRow = null;
/* 619 */             continue;
/* 620 */           }
/* 621 */           smj_value2 = smj_value1;
/* 622 */         }
/* 623 */
/* 624 */         comp = 0;
/* 625 */         if (comp == 0) {
/* 626 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 627 */         }
/* 628 */
/* 629 */         if (comp > 0) {
/* 630 */           smj_rightRow = null;
/* 631 */         } else if (comp < 0) {
/* 632 */           if (!smj_matches.isEmpty()) {
/* 633 */             smj_value3 = smj_value;
/* 634 */             return true;
/* 635 */           }
/* 636 */           smj_leftRow = null;
/* 637 */         } else {
/* 638 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 639 */           smj_rightRow = null;;
/* 640 */         }
/* 641 */       } while (smj_leftRow != null);
/* 642 */     }
/* 643 */     return false; // unreachable
/* 644 */   }
/* 645 */
/* 646 */   private void wholestagecodegen_init_2() {
/* 647 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 8);
/* 648 */
/* 649 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 650 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 651 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 652 */
/* 653 */   }
/* 654 */
/* 655 */   private void wholestagecodegen_init_1() {
/* 656 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 10);
/* 657 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 658 */
/* 659 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 660 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 661 */
/* 662 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 663 */     bhj_result = new UnsafeRow(12);
/* 664 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 224);
/* 665 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 12);
/* 666 */     project_result1 = new UnsafeRow(10);
/* 667 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 224);
/* 668 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 10);
/* 669 */     agg_result8 = new UnsafeRow(8);
/* 670 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result8, 224);
/* 671 */
/* 672 */   }
/* 673 */
/* 674 */   protected void processNext() throws java.io.IOException {
/* 675 */     if (!agg_initAgg) {
/* 676 */       agg_initAgg = true;
/* 677 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 678 */       agg_doAggregateWithKeys();
/* 679 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 680 */     }
/* 681 */
/* 682 */     // output the result
/* 683 */
/* 684 */     while (agg_fastHashMapIter.next()) {
/* 685 */       wholestagecodegen_numOutputRows.add(1);
/* 686 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 687 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 688 */
/* 689 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 690 */
/* 691 */       append(agg_resultRow.copy());
/* 692 */
/* 693 */       if (shouldStop()) return;
/* 694 */     }
/* 695 */     agg_fastHashMap.close();
/* 696 */
/* 697 */     while (agg_mapIter.next()) {
/* 698 */       wholestagecodegen_numOutputRows.add(1);
/* 699 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 700 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 701 */
/* 702 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 703 */
/* 704 */       append(agg_resultRow.copy());
/* 705 */
/* 706 */       if (shouldStop()) return;
/* 707 */     }
/* 708 */
/* 709 */     agg_mapIter.close();
/* 710 */     if (agg_sorter == null) {
/* 711 */       agg_hashMap.free();
/* 712 */     }
/* 713 */   }
/* 714 */ }
