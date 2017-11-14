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
/* 028 */   private double smj_value5;
/* 029 */   private boolean smj_isNull3;
/* 030 */   private UTF8String smj_value6;
/* 031 */   private boolean smj_isNull4;
/* 032 */   private UTF8String smj_value7;
/* 033 */   private boolean smj_isNull5;
/* 034 */   private UTF8String smj_value8;
/* 035 */   private boolean smj_isNull6;
/* 036 */   private double smj_value9;
/* 037 */   private boolean smj_isNull7;
/* 038 */   private UTF8String smj_value10;
/* 039 */   private boolean smj_isNull8;
/* 040 */   private UTF8String smj_value11;
/* 041 */   private boolean smj_isNull9;
/* 042 */   private UTF8String smj_value12;
/* 043 */   private boolean smj_isNull10;
/* 044 */   private int smj_value13;
/* 045 */   private boolean smj_isNull11;
/* 046 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 047 */   private UnsafeRow smj_result;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 050 */   private UnsafeRow project_result;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 053 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 054 */   private org.apache.spark.sql.execution.joins.UnsafeHashedRelation bhj_relation;
/* 055 */   private UnsafeRow bhj_result;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 058 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 059 */   private UnsafeRow bhj_result1;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 062 */   private UnsafeRow project_result1;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 065 */   private UnsafeRow agg_result10;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 068 */   private int agg_value22;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 070 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 071 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 072 */
/* 073 */   public GeneratedIterator(Object[] references) {
/* 074 */     this.references = references;
/* 075 */   }
/* 076 */
/* 077 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 078 */     partitionIndex = index;
/* 079 */     this.inputs = inputs;
/* 080 */     wholestagecodegen_init_0();
/* 081 */     wholestagecodegen_init_1();
/* 082 */     wholestagecodegen_init_2();
/* 083 */
/* 084 */   }
/* 085 */
/* 086 */   private void wholestagecodegen_init_0() {
/* 087 */     agg_initAgg = false;
/* 088 */
/* 089 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 090 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 091 */
/* 092 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 093 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 094 */     smj_leftInput = inputs[0];
/* 095 */     smj_rightInput = inputs[1];
/* 096 */
/* 097 */     smj_rightRow = null;
/* 098 */
/* 099 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 100 */
/* 101 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 102 */     smj_result = new UnsafeRow(14);
/* 103 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 288);
/* 104 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 14);
/* 105 */     project_result = new UnsafeRow(12);
/* 106 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 288);
/* 107 */
/* 108 */   }
/* 109 */
/* 110 */   public class agg_FastHashMap {
/* 111 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 112 */     private int[] buckets;
/* 113 */     private int capacity = 1 << 16;
/* 114 */     private double loadFactor = 0.5;
/* 115 */     private int numBuckets = (int) (capacity / loadFactor);
/* 116 */     private int maxSteps = 2;
/* 117 */     private int numRows = 0;
/* 118 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 119 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 120 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 121 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.StringType)
/* 122 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.StringType)
/* 123 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.StringType)
/* 124 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 125 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 126 */     .add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.StringType)
/* 127 */     .add("((java.lang.String) references[12])", org.apache.spark.sql.types.DataTypes.StringType);
/* 128 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[13])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 129 */     private Object emptyVBase;
/* 130 */     private long emptyVOff;
/* 131 */     private int emptyVLen;
/* 132 */     private boolean isBatchFull = false;
/* 133 */
/* 134 */     public agg_FastHashMap(
/* 135 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 136 */       InternalRow emptyAggregationBuffer) {
/* 137 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 138 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 139 */
/* 140 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 141 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 142 */
/* 143 */       emptyVBase = emptyBuffer;
/* 144 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 145 */       emptyVLen = emptyBuffer.length;
/* 146 */
/* 147 */       buckets = new int[numBuckets];
/* 148 */       java.util.Arrays.fill(buckets, -1);
/* 149 */     }
/* 150 */
/* 151 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, double agg_key6, int agg_key7, UTF8String agg_key8, UTF8String agg_key9) {
/* 152 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7, agg_key8, agg_key9);
/* 153 */       int step = 0;
/* 154 */       int idx = (int) h & (numBuckets - 1);
/* 155 */       while (step < maxSteps) {
/* 156 */         // Return bucket index if it's either an empty slot or already contains the key
/* 157 */         if (buckets[idx] == -1) {
/* 158 */           if (numRows < capacity && !isBatchFull) {
/* 159 */             // creating the unsafe for new entry
/* 160 */             UnsafeRow agg_result = new UnsafeRow(10);
/* 161 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 162 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 163 */               256);
/* 164 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 165 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 166 */               agg_holder,
/* 167 */               10);
/* 168 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 169 */             agg_rowWriter.zeroOutNullBytes();
/* 170 */             agg_rowWriter.write(0, agg_key);
/* 171 */             agg_rowWriter.write(1, agg_key1);
/* 172 */             agg_rowWriter.write(2, agg_key2);
/* 173 */             agg_rowWriter.write(3, agg_key3);
/* 174 */             agg_rowWriter.write(4, agg_key4);
/* 175 */             agg_rowWriter.write(5, agg_key5);
/* 176 */             agg_rowWriter.write(6, agg_key6);
/* 177 */             agg_rowWriter.write(7, agg_key7);
/* 178 */             agg_rowWriter.write(8, agg_key8);
/* 179 */             agg_rowWriter.write(9, agg_key9);
/* 180 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 181 */             Object kbase = agg_result.getBaseObject();
/* 182 */             long koff = agg_result.getBaseOffset();
/* 183 */             int klen = agg_result.getSizeInBytes();
/* 184 */
/* 185 */             UnsafeRow vRow
/* 186 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 187 */             if (vRow == null) {
/* 188 */               isBatchFull = true;
/* 189 */             } else {
/* 190 */               buckets[idx] = numRows++;
/* 191 */             }
/* 192 */             return vRow;
/* 193 */           } else {
/* 194 */             // No more space
/* 195 */             return null;
/* 196 */           }
/* 197 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7, agg_key8, agg_key9)) {
/* 198 */           return batch.getValueRow(buckets[idx]);
/* 199 */         }
/* 200 */         idx = (idx + 1) & (numBuckets - 1);
/* 201 */         step++;
/* 202 */       }
/* 203 */       // Didn't find it
/* 204 */       return null;
/* 205 */     }
/* 206 */
/* 207 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, double agg_key6, int agg_key7, UTF8String agg_key8, UTF8String agg_key9) {
/* 208 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 209 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getUTF8String(4).equals(agg_key4)) && (row.getUTF8String(5).equals(agg_key5)) && ((java.lang.Double.isNaN(row.getDouble(6)) && java.lang.Double.isNaN(agg_key6)) || row.getDouble(6) == agg_key6) && (row.getInt(7) == agg_key7) && (row.getUTF8String(8).equals(agg_key8)) && (row.getUTF8String(9).equals(agg_key9));
/* 210 */     }
/* 211 */
/* 212 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, double agg_key6, int agg_key7, UTF8String agg_key8, UTF8String agg_key9) {
/* 213 */       long agg_hash = 0;
/* 214 */
/* 215 */       int agg_result = 0;
/* 216 */       byte[] agg_bytes = agg_key.getBytes();
/* 217 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 218 */         int agg_hash1 = agg_bytes[i];
/* 219 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 220 */       }
/* 221 */
/* 222 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 223 */
/* 224 */       int agg_result1 = 0;
/* 225 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 226 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 227 */         int agg_hash2 = agg_bytes1[i];
/* 228 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 229 */       }
/* 230 */
/* 231 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 232 */
/* 233 */       int agg_result2 = 0;
/* 234 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 235 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 236 */         int agg_hash3 = agg_bytes2[i];
/* 237 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 238 */       }
/* 239 */
/* 240 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 241 */
/* 242 */       int agg_result3 = 0;
/* 243 */       byte[] agg_bytes3 = agg_key3.getBytes();
/* 244 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 245 */         int agg_hash4 = agg_bytes3[i];
/* 246 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash4 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 247 */       }
/* 248 */
/* 249 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 250 */
/* 251 */       int agg_result4 = 0;
/* 252 */       byte[] agg_bytes4 = agg_key4.getBytes();
/* 253 */       for (int i = 0; i < agg_bytes4.length; i++) {
/* 254 */         int agg_hash5 = agg_bytes4[i];
/* 255 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash5 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 256 */       }
/* 257 */
/* 258 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 259 */
/* 260 */       int agg_result5 = 0;
/* 261 */       byte[] agg_bytes5 = agg_key5.getBytes();
/* 262 */       for (int i = 0; i < agg_bytes5.length; i++) {
/* 263 */         int agg_hash6 = agg_bytes5[i];
/* 264 */         agg_result5 = (agg_result5 ^ (0x9e3779b9)) + agg_hash6 + (agg_result5 << 6) + (agg_result5 >>> 2);
/* 265 */       }
/* 266 */
/* 267 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 268 */
/* 269 */       long agg_result6 = Double.doubleToLongBits(agg_key6);
/* 270 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result6 + (agg_hash << 6) + (agg_hash >>> 2);
/* 271 */
/* 272 */       int agg_result7 = agg_key7;
/* 273 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result7 + (agg_hash << 6) + (agg_hash >>> 2);
/* 274 */
/* 275 */       int agg_result8 = 0;
/* 276 */       byte[] agg_bytes6 = agg_key8.getBytes();
/* 277 */       for (int i = 0; i < agg_bytes6.length; i++) {
/* 278 */         int agg_hash7 = agg_bytes6[i];
/* 279 */         agg_result8 = (agg_result8 ^ (0x9e3779b9)) + agg_hash7 + (agg_result8 << 6) + (agg_result8 >>> 2);
/* 280 */       }
/* 281 */
/* 282 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result8 + (agg_hash << 6) + (agg_hash >>> 2);
/* 283 */
/* 284 */       int agg_result9 = 0;
/* 285 */       byte[] agg_bytes7 = agg_key9.getBytes();
/* 286 */       for (int i = 0; i < agg_bytes7.length; i++) {
/* 287 */         int agg_hash8 = agg_bytes7[i];
/* 288 */         agg_result9 = (agg_result9 ^ (0x9e3779b9)) + agg_hash8 + (agg_result9 << 6) + (agg_result9 >>> 2);
/* 289 */       }
/* 290 */
/* 291 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result9 + (agg_hash << 6) + (agg_hash >>> 2);
/* 292 */
/* 293 */       return agg_hash;
/* 294 */     }
/* 295 */
/* 296 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 297 */       return batch.rowIterator();
/* 298 */     }
/* 299 */
/* 300 */     public void close() {
/* 301 */       batch.close();
/* 302 */     }
/* 303 */
/* 304 */   }
/* 305 */
/* 306 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 307 */     agg_hashMap = agg_plan.createHashMap();
/* 308 */
/* 309 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 310 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 311 */       smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 312 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 313 */       smj_value5 = smj_isNull3 ? -1.0 : (smj_leftRow.getDouble(1));
/* 314 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 315 */       smj_value6 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(2));
/* 316 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 317 */       smj_value7 = smj_isNull5 ? null : (smj_leftRow.getUTF8String(3));
/* 318 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 319 */       smj_value8 = smj_isNull6 ? null : (smj_leftRow.getUTF8String(4));
/* 320 */       smj_isNull7 = smj_leftRow.isNullAt(5);
/* 321 */       smj_value9 = smj_isNull7 ? -1.0 : (smj_leftRow.getDouble(5));
/* 322 */       smj_isNull8 = smj_leftRow.isNullAt(6);
/* 323 */       smj_value10 = smj_isNull8 ? null : (smj_leftRow.getUTF8String(6));
/* 324 */       smj_isNull9 = smj_leftRow.isNullAt(7);
/* 325 */       smj_value11 = smj_isNull9 ? null : (smj_leftRow.getUTF8String(7));
/* 326 */       smj_isNull10 = smj_leftRow.isNullAt(8);
/* 327 */       smj_value12 = smj_isNull10 ? null : (smj_leftRow.getUTF8String(8));
/* 328 */       smj_isNull11 = smj_leftRow.isNullAt(9);
/* 329 */       smj_value13 = smj_isNull11 ? -1 : (smj_leftRow.getInt(9));
/* 330 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 331 */       while (smj_iterator.hasNext()) {
/* 332 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 333 */
/* 334 */         smj_numOutputRows.add(1);
/* 335 */
/* 336 */         boolean smj_isNull15 = smj_rightRow1.isNullAt(3);
/* 337 */         UTF8String smj_value17 = smj_isNull15 ? null : (smj_rightRow1.getUTF8String(3));
/* 338 */
/* 339 */         // generate join key for stream side
/* 340 */
/* 341 */         bhj_holder.reset();
/* 342 */
/* 343 */         bhj_rowWriter.zeroOutNullBytes();
/* 344 */
/* 345 */         if (smj_isNull15) {
/* 346 */           bhj_rowWriter.setNullAt(0);
/* 347 */         } else {
/* 348 */           bhj_rowWriter.write(0, smj_value17);
/* 349 */         }
/* 350 */
/* 351 */         if (smj_isNull6) {
/* 352 */           bhj_rowWriter.setNullAt(1);
/* 353 */         } else {
/* 354 */           bhj_rowWriter.write(1, smj_value8);
/* 355 */         }
/* 356 */         bhj_result.setTotalSize(bhj_holder.totalSize());
/* 357 */
/* 358 */         // find matches from HashRelation
/* 359 */         scala.collection.Iterator bhj_matches = bhj_result.anyNull() ? null : (scala.collection.Iterator)bhj_relation.get(bhj_result);
/* 360 */         if (bhj_matches == null) continue;
/* 361 */         while (bhj_matches.hasNext()) {
/* 362 */           UnsafeRow bhj_matched = (UnsafeRow) bhj_matches.next();
/* 363 */
/* 364 */           bhj_numOutputRows.add(1);
/* 365 */
/* 366 */           boolean smj_isNull13 = smj_rightRow1.isNullAt(1);
/* 367 */           UTF8String smj_value15 = smj_isNull13 ? null : (smj_rightRow1.getUTF8String(1));
/* 368 */           boolean smj_isNull14 = smj_rightRow1.isNullAt(2);
/* 369 */           UTF8String smj_value16 = smj_isNull14 ? null : (smj_rightRow1.getUTF8String(2));
/* 370 */           boolean bhj_isNull2 = bhj_matched.isNullAt(0);
/* 371 */           UTF8String bhj_value2 = bhj_isNull2 ? null : (bhj_matched.getUTF8String(0));
/* 372 */
/* 373 */           UnsafeRow agg_unsafeRowAggBuffer = null;
/* 374 */
/* 375 */           UnsafeRow agg_fastAggBuffer = null;
/* 376 */
/* 377 */           if (true) {
/* 378 */             if (!smj_isNull14 && !smj_isNull13 && !smj_isNull4 && !bhj_isNull2 && !smj_isNull5 && !smj_isNull9 && !smj_isNull7 && !smj_isNull11 && !smj_isNull10 && !smj_isNull8) {
/* 379 */               agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 380 */                 smj_value16, smj_value15, smj_value6, bhj_value2, smj_value7, smj_value11, smj_value9, smj_value13, smj_value12, smj_value10);
/* 381 */             }
/* 382 */           }
/* 383 */
/* 384 */           if (agg_fastAggBuffer == null) {
/* 385 */             // generate grouping key
/* 386 */             agg_holder.reset();
/* 387 */
/* 388 */             agg_rowWriter.zeroOutNullBytes();
/* 389 */
/* 390 */             if (smj_isNull14) {
/* 391 */               agg_rowWriter.setNullAt(0);
/* 392 */             } else {
/* 393 */               agg_rowWriter.write(0, smj_value16);
/* 394 */             }
/* 395 */
/* 396 */             if (smj_isNull13) {
/* 397 */               agg_rowWriter.setNullAt(1);
/* 398 */             } else {
/* 399 */               agg_rowWriter.write(1, smj_value15);
/* 400 */             }
/* 401 */
/* 402 */             if (smj_isNull4) {
/* 403 */               agg_rowWriter.setNullAt(2);
/* 404 */             } else {
/* 405 */               agg_rowWriter.write(2, smj_value6);
/* 406 */             }
/* 407 */
/* 408 */             if (bhj_isNull2) {
/* 409 */               agg_rowWriter.setNullAt(3);
/* 410 */             } else {
/* 411 */               agg_rowWriter.write(3, bhj_value2);
/* 412 */             }
/* 413 */
/* 414 */             if (smj_isNull5) {
/* 415 */               agg_rowWriter.setNullAt(4);
/* 416 */             } else {
/* 417 */               agg_rowWriter.write(4, smj_value7);
/* 418 */             }
/* 419 */
/* 420 */             if (smj_isNull9) {
/* 421 */               agg_rowWriter.setNullAt(5);
/* 422 */             } else {
/* 423 */               agg_rowWriter.write(5, smj_value11);
/* 424 */             }
/* 425 */
/* 426 */             if (smj_isNull7) {
/* 427 */               agg_rowWriter.setNullAt(6);
/* 428 */             } else {
/* 429 */               agg_rowWriter.write(6, smj_value9);
/* 430 */             }
/* 431 */
/* 432 */             if (smj_isNull11) {
/* 433 */               agg_rowWriter.setNullAt(7);
/* 434 */             } else {
/* 435 */               agg_rowWriter.write(7, smj_value13);
/* 436 */             }
/* 437 */
/* 438 */             if (smj_isNull10) {
/* 439 */               agg_rowWriter.setNullAt(8);
/* 440 */             } else {
/* 441 */               agg_rowWriter.write(8, smj_value12);
/* 442 */             }
/* 443 */
/* 444 */             if (smj_isNull8) {
/* 445 */               agg_rowWriter.setNullAt(9);
/* 446 */             } else {
/* 447 */               agg_rowWriter.write(9, smj_value10);
/* 448 */             }
/* 449 */             agg_result10.setTotalSize(agg_holder.totalSize());
/* 450 */             agg_value22 = 42;
/* 451 */
/* 452 */             if (!smj_isNull14) {
/* 453 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value16.getBaseObject(), smj_value16.getBaseOffset(), smj_value16.numBytes(), agg_value22);
/* 454 */             }
/* 455 */
/* 456 */             if (!smj_isNull13) {
/* 457 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value15.getBaseObject(), smj_value15.getBaseOffset(), smj_value15.numBytes(), agg_value22);
/* 458 */             }
/* 459 */
/* 460 */             if (!smj_isNull4) {
/* 461 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value6.getBaseObject(), smj_value6.getBaseOffset(), smj_value6.numBytes(), agg_value22);
/* 462 */             }
/* 463 */
/* 464 */             if (!bhj_isNull2) {
/* 465 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value2.getBaseObject(), bhj_value2.getBaseOffset(), bhj_value2.numBytes(), agg_value22);
/* 466 */             }
/* 467 */
/* 468 */             if (!smj_isNull5) {
/* 469 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value7.getBaseObject(), smj_value7.getBaseOffset(), smj_value7.numBytes(), agg_value22);
/* 470 */             }
/* 471 */
/* 472 */             if (!smj_isNull9) {
/* 473 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value11.getBaseObject(), smj_value11.getBaseOffset(), smj_value11.numBytes(), agg_value22);
/* 474 */             }
/* 475 */
/* 476 */             if (!smj_isNull7) {
/* 477 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(Double.doubleToLongBits(smj_value9), agg_value22);
/* 478 */             }
/* 479 */
/* 480 */             if (!smj_isNull11) {
/* 481 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(smj_value13, agg_value22);
/* 482 */             }
/* 483 */
/* 484 */             if (!smj_isNull10) {
/* 485 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value12.getBaseObject(), smj_value12.getBaseOffset(), smj_value12.numBytes(), agg_value22);
/* 486 */             }
/* 487 */
/* 488 */             if (!smj_isNull8) {
/* 489 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value10.getBaseObject(), smj_value10.getBaseOffset(), smj_value10.numBytes(), agg_value22);
/* 490 */             }
/* 491 */             if (true) {
/* 492 */               // try to get the buffer from hash map
/* 493 */               agg_unsafeRowAggBuffer =
/* 494 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result10, agg_value22);
/* 495 */             }
/* 496 */             if (agg_unsafeRowAggBuffer == null) {
/* 497 */               if (agg_sorter == null) {
/* 498 */                 agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 499 */               } else {
/* 500 */                 agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 501 */               }
/* 502 */
/* 503 */               // the hash map had be spilled, it should have enough memory now,
/* 504 */               // try  to allocate buffer again.
/* 505 */               agg_unsafeRowAggBuffer =
/* 506 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result10, agg_value22);
/* 507 */               if (agg_unsafeRowAggBuffer == null) {
/* 508 */                 // failed to allocate the first page
/* 509 */                 throw new OutOfMemoryError("No enough memory for aggregation");
/* 510 */               }
/* 511 */             }
/* 512 */           }
/* 513 */
/* 514 */           if (agg_fastAggBuffer != null) {
/* 515 */             // update fast row
/* 516 */
/* 517 */             // common sub-expressions
/* 518 */
/* 519 */             // evaluate aggregate function
/* 520 */             boolean agg_isNull41 = true;
/* 521 */             double agg_value42 = -1.0;
/* 522 */
/* 523 */             boolean agg_isNull43 = agg_fastAggBuffer.isNullAt(0);
/* 524 */             double agg_value44 = agg_isNull43 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 525 */             boolean agg_isNull42 = agg_isNull43;
/* 526 */             double agg_value43 = agg_value44;
/* 527 */             if (agg_isNull42) {
/* 528 */               boolean agg_isNull44 = false;
/* 529 */               double agg_value45 = -1.0;
/* 530 */               if (!false) {
/* 531 */                 agg_value45 = (double) 0;
/* 532 */               }
/* 533 */               if (!agg_isNull44) {
/* 534 */                 agg_isNull42 = false;
/* 535 */                 agg_value43 = agg_value45;
/* 536 */               }
/* 537 */             }
/* 538 */
/* 539 */             if (!smj_isNull3) {
/* 540 */               agg_isNull41 = false; // resultCode could change nullability.
/* 541 */               agg_value42 = agg_value43 + smj_value5;
/* 542 */
/* 543 */             }
/* 544 */             boolean agg_isNull40 = agg_isNull41;
/* 545 */             double agg_value41 = agg_value42;
/* 546 */             if (agg_isNull40) {
/* 547 */               boolean agg_isNull47 = agg_fastAggBuffer.isNullAt(0);
/* 548 */               double agg_value48 = agg_isNull47 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 549 */               if (!agg_isNull47) {
/* 550 */                 agg_isNull40 = false;
/* 551 */                 agg_value41 = agg_value48;
/* 552 */               }
/* 553 */             }
/* 554 */             // update fast row
/* 555 */             if (!agg_isNull40) {
/* 556 */               agg_fastAggBuffer.setDouble(0, agg_value41);
/* 557 */             } else {
/* 558 */               agg_fastAggBuffer.setNullAt(0);
/* 559 */             }
/* 560 */
/* 561 */           } else {
/* 562 */             // update unsafe row
/* 563 */
/* 564 */             // common sub-expressions
/* 565 */
/* 566 */             // evaluate aggregate function
/* 567 */             boolean agg_isNull33 = true;
/* 568 */             double agg_value34 = -1.0;
/* 569 */
/* 570 */             boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 571 */             double agg_value36 = agg_isNull35 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 572 */             boolean agg_isNull34 = agg_isNull35;
/* 573 */             double agg_value35 = agg_value36;
/* 574 */             if (agg_isNull34) {
/* 575 */               boolean agg_isNull36 = false;
/* 576 */               double agg_value37 = -1.0;
/* 577 */               if (!false) {
/* 578 */                 agg_value37 = (double) 0;
/* 579 */               }
/* 580 */               if (!agg_isNull36) {
/* 581 */                 agg_isNull34 = false;
/* 582 */                 agg_value35 = agg_value37;
/* 583 */               }
/* 584 */             }
/* 585 */
/* 586 */             if (!smj_isNull3) {
/* 587 */               agg_isNull33 = false; // resultCode could change nullability.
/* 588 */               agg_value34 = agg_value35 + smj_value5;
/* 589 */
/* 590 */             }
/* 591 */             boolean agg_isNull32 = agg_isNull33;
/* 592 */             double agg_value33 = agg_value34;
/* 593 */             if (agg_isNull32) {
/* 594 */               boolean agg_isNull39 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 595 */               double agg_value40 = agg_isNull39 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 596 */               if (!agg_isNull39) {
/* 597 */                 agg_isNull32 = false;
/* 598 */                 agg_value33 = agg_value40;
/* 599 */               }
/* 600 */             }
/* 601 */             // update unsafe row buffer
/* 602 */             if (!agg_isNull32) {
/* 603 */               agg_unsafeRowAggBuffer.setDouble(0, agg_value33);
/* 604 */             } else {
/* 605 */               agg_unsafeRowAggBuffer.setNullAt(0);
/* 606 */             }
/* 607 */
/* 608 */           }
/* 609 */
/* 610 */         }
/* 611 */
/* 612 */       }
/* 613 */       if (shouldStop()) return;
/* 614 */     }
/* 615 */
/* 616 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 617 */
/* 618 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 619 */   }
/* 620 */
/* 621 */   private boolean findNextInnerJoinRows(
/* 622 */     scala.collection.Iterator leftIter,
/* 623 */     scala.collection.Iterator rightIter) {
/* 624 */     smj_leftRow = null;
/* 625 */     int comp = 0;
/* 626 */     while (smj_leftRow == null) {
/* 627 */       if (!leftIter.hasNext()) return false;
/* 628 */       smj_leftRow = (InternalRow) leftIter.next();
/* 629 */
/* 630 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 631 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(0));
/* 632 */       if (smj_isNull) {
/* 633 */         smj_leftRow = null;
/* 634 */         continue;
/* 635 */       }
/* 636 */       if (!smj_matches.isEmpty()) {
/* 637 */         comp = 0;
/* 638 */         if (comp == 0) {
/* 639 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 640 */         }
/* 641 */
/* 642 */         if (comp == 0) {
/* 643 */           return true;
/* 644 */         }
/* 645 */         smj_matches.clear();
/* 646 */       }
/* 647 */
/* 648 */       do {
/* 649 */         if (smj_rightRow == null) {
/* 650 */           if (!rightIter.hasNext()) {
/* 651 */             smj_value3 = smj_value;
/* 652 */             return !smj_matches.isEmpty();
/* 653 */           }
/* 654 */           smj_rightRow = (InternalRow) rightIter.next();
/* 655 */
/* 656 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 657 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 658 */           if (smj_isNull1) {
/* 659 */             smj_rightRow = null;
/* 660 */             continue;
/* 661 */           }
/* 662 */           smj_value2 = smj_value1;
/* 663 */         }
/* 664 */
/* 665 */         comp = 0;
/* 666 */         if (comp == 0) {
/* 667 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 668 */         }
/* 669 */
/* 670 */         if (comp > 0) {
/* 671 */           smj_rightRow = null;
/* 672 */         } else if (comp < 0) {
/* 673 */           if (!smj_matches.isEmpty()) {
/* 674 */             smj_value3 = smj_value;
/* 675 */             return true;
/* 676 */           }
/* 677 */           smj_leftRow = null;
/* 678 */         } else {
/* 679 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 680 */           smj_rightRow = null;;
/* 681 */         }
/* 682 */       } while (smj_leftRow != null);
/* 683 */     }
/* 684 */     return false; // unreachable
/* 685 */   }
/* 686 */
/* 687 */   private void wholestagecodegen_init_2() {
/* 688 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 11);
/* 689 */     agg_result10 = new UnsafeRow(10);
/* 690 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result10, 256);
/* 691 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 10);
/* 692 */
/* 693 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 694 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 695 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 696 */
/* 697 */   }
/* 698 */
/* 699 */   private void wholestagecodegen_init_1() {
/* 700 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 12);
/* 701 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[15];
/* 702 */
/* 703 */     bhj_relation = ((org.apache.spark.sql.execution.joins.UnsafeHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 704 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 705 */
/* 706 */     bhj_result = new UnsafeRow(2);
/* 707 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 64);
/* 708 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 2);
/* 709 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 710 */     bhj_result1 = new UnsafeRow(15);
/* 711 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 384);
/* 712 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 15);
/* 713 */     project_result1 = new UnsafeRow(11);
/* 714 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 256);
/* 715 */
/* 716 */   }
/* 717 */
/* 718 */   protected void processNext() throws java.io.IOException {
/* 719 */     if (!agg_initAgg) {
/* 720 */       agg_initAgg = true;
/* 721 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 722 */       agg_doAggregateWithKeys();
/* 723 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 724 */     }
/* 725 */
/* 726 */     // output the result
/* 727 */
/* 728 */     while (agg_fastHashMapIter.next()) {
/* 729 */       wholestagecodegen_numOutputRows.add(1);
/* 730 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 731 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 732 */
/* 733 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 734 */
/* 735 */       append(agg_resultRow.copy());
/* 736 */
/* 737 */       if (shouldStop()) return;
/* 738 */     }
/* 739 */     agg_fastHashMap.close();
/* 740 */
/* 741 */     while (agg_mapIter.next()) {
/* 742 */       wholestagecodegen_numOutputRows.add(1);
/* 743 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 744 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 745 */
/* 746 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 747 */
/* 748 */       append(agg_resultRow.copy());
/* 749 */
/* 750 */       if (shouldStop()) return;
/* 751 */     }
/* 752 */
/* 753 */     agg_mapIter.close();
/* 754 */     if (agg_sorter == null) {
/* 755 */       agg_hashMap.free();
/* 756 */     }
/* 757 */   }
/* 758 */ }
