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
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private double agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private double agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private double agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private double agg_bufValue6;
/* 023 */   private boolean agg_bufIsNull7;
/* 024 */   private double agg_bufValue7;
/* 025 */   private boolean agg_bufIsNull8;
/* 026 */   private double agg_bufValue8;
/* 027 */   private boolean agg_bufIsNull9;
/* 028 */   private double agg_bufValue9;
/* 029 */   private boolean agg_bufIsNull10;
/* 030 */   private double agg_bufValue10;
/* 031 */   private boolean agg_bufIsNull11;
/* 032 */   private double agg_bufValue11;
/* 033 */   private boolean agg_bufIsNull12;
/* 034 */   private double agg_bufValue12;
/* 035 */   private boolean agg_bufIsNull13;
/* 036 */   private double agg_bufValue13;
/* 037 */   private boolean agg_bufIsNull14;
/* 038 */   private double agg_bufValue14;
/* 039 */   private boolean agg_bufIsNull15;
/* 040 */   private double agg_bufValue15;
/* 041 */   private boolean agg_bufIsNull16;
/* 042 */   private double agg_bufValue16;
/* 043 */   private boolean agg_bufIsNull17;
/* 044 */   private double agg_bufValue17;
/* 045 */   private boolean agg_bufIsNull18;
/* 046 */   private double agg_bufValue18;
/* 047 */   private boolean agg_bufIsNull19;
/* 048 */   private double agg_bufValue19;
/* 049 */   private boolean agg_bufIsNull20;
/* 050 */   private double agg_bufValue20;
/* 051 */   private boolean agg_bufIsNull21;
/* 052 */   private double agg_bufValue21;
/* 053 */   private boolean agg_bufIsNull22;
/* 054 */   private double agg_bufValue22;
/* 055 */   private boolean agg_bufIsNull23;
/* 056 */   private double agg_bufValue23;
/* 057 */   private boolean agg_bufIsNull24;
/* 058 */   private double agg_bufValue24;
/* 059 */   private boolean agg_bufIsNull25;
/* 060 */   private double agg_bufValue25;
/* 061 */   private boolean agg_bufIsNull26;
/* 062 */   private double agg_bufValue26;
/* 063 */   private boolean agg_bufIsNull27;
/* 064 */   private double agg_bufValue27;
/* 065 */   private boolean agg_bufIsNull28;
/* 066 */   private double agg_bufValue28;
/* 067 */   private boolean agg_bufIsNull29;
/* 068 */   private double agg_bufValue29;
/* 069 */   private boolean agg_bufIsNull30;
/* 070 */   private double agg_bufValue30;
/* 071 */   private boolean agg_bufIsNull31;
/* 072 */   private double agg_bufValue31;
/* 073 */   private boolean agg_bufIsNull32;
/* 074 */   private double agg_bufValue32;
/* 075 */   private boolean agg_bufIsNull33;
/* 076 */   private double agg_bufValue33;
/* 077 */   private boolean agg_bufIsNull34;
/* 078 */   private double agg_bufValue34;
/* 079 */   private boolean agg_bufIsNull35;
/* 080 */   private double agg_bufValue35;
/* 081 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 082 */   private agg_FastHashMap agg_fastHashMap;
/* 083 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 084 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 085 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 086 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 087 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 088 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 089 */   private scala.collection.Iterator inputadapter_input;
/* 090 */   private UnsafeRow agg_result8;
/* 091 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 092 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 093 */   private int agg_value88;
/* 094 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 095 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 096 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 097 */
/* 098 */   public GeneratedIterator(Object[] references) {
/* 099 */     this.references = references;
/* 100 */   }
/* 101 */
/* 102 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 103 */     partitionIndex = index;
/* 104 */     this.inputs = inputs;
/* 105 */     agg_initAgg = false;
/* 106 */
/* 107 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 108 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 109 */
/* 110 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 111 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 112 */     inputadapter_input = inputs[0];
/* 113 */     agg_result8 = new UnsafeRow(8);
/* 114 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result8, 192);
/* 115 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 8);
/* 116 */
/* 117 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 118 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 119 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 120 */
/* 121 */   }
/* 122 */
/* 123 */   public class agg_FastHashMap {
/* 124 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 125 */     private int[] buckets;
/* 126 */     private int capacity = 1 << 16;
/* 127 */     private double loadFactor = 0.5;
/* 128 */     private int numBuckets = (int) (capacity / loadFactor);
/* 129 */     private int maxSteps = 2;
/* 130 */     private int numRows = 0;
/* 131 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("w_warehouse_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 132 */     .add("w_warehouse_sq_ft", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 133 */     .add("w_city", org.apache.spark.sql.types.DataTypes.StringType)
/* 134 */     .add("w_county", org.apache.spark.sql.types.DataTypes.StringType)
/* 135 */     .add("w_state", org.apache.spark.sql.types.DataTypes.StringType)
/* 136 */     .add("w_country", org.apache.spark.sql.types.DataTypes.StringType)
/* 137 */     .add("ship_carriers", org.apache.spark.sql.types.DataTypes.StringType)
/* 138 */     .add("year", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 139 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 140 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 141 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 142 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 143 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 144 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 145 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 146 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 147 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 148 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 149 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 150 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 151 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 152 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 153 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 154 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 155 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 156 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 157 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 158 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 159 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 160 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 161 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 162 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 163 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 164 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 165 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 166 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 167 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 168 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 169 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 170 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 171 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 172 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 173 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 174 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 175 */     private Object emptyVBase;
/* 176 */     private long emptyVOff;
/* 177 */     private int emptyVLen;
/* 178 */     private boolean isBatchFull = false;
/* 179 */
/* 180 */     public agg_FastHashMap(
/* 181 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 182 */       InternalRow emptyAggregationBuffer) {
/* 183 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 184 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 185 */
/* 186 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 187 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 188 */
/* 189 */       emptyVBase = emptyBuffer;
/* 190 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 191 */       emptyVLen = emptyBuffer.length;
/* 192 */
/* 193 */       buckets = new int[numBuckets];
/* 194 */       java.util.Arrays.fill(buckets, -1);
/* 195 */     }
/* 196 */
/* 197 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, int agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, int agg_key7) {
/* 198 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7);
/* 199 */       int step = 0;
/* 200 */       int idx = (int) h & (numBuckets - 1);
/* 201 */       while (step < maxSteps) {
/* 202 */         // Return bucket index if it's either an empty slot or already contains the key
/* 203 */         if (buckets[idx] == -1) {
/* 204 */           if (numRows < capacity && !isBatchFull) {
/* 205 */             // creating the unsafe for new entry
/* 206 */             UnsafeRow agg_result = new UnsafeRow(8);
/* 207 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 208 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 209 */               192);
/* 210 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 211 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 212 */               agg_holder,
/* 213 */               8);
/* 214 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 215 */             agg_rowWriter.zeroOutNullBytes();
/* 216 */             agg_rowWriter.write(0, agg_key);
/* 217 */             agg_rowWriter.write(1, agg_key1);
/* 218 */             agg_rowWriter.write(2, agg_key2);
/* 219 */             agg_rowWriter.write(3, agg_key3);
/* 220 */             agg_rowWriter.write(4, agg_key4);
/* 221 */             agg_rowWriter.write(5, agg_key5);
/* 222 */             agg_rowWriter.write(6, agg_key6);
/* 223 */             agg_rowWriter.write(7, agg_key7);
/* 224 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 225 */             Object kbase = agg_result.getBaseObject();
/* 226 */             long koff = agg_result.getBaseOffset();
/* 227 */             int klen = agg_result.getSizeInBytes();
/* 228 */
/* 229 */             UnsafeRow vRow
/* 230 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 231 */             if (vRow == null) {
/* 232 */               isBatchFull = true;
/* 233 */             } else {
/* 234 */               buckets[idx] = numRows++;
/* 235 */             }
/* 236 */             return vRow;
/* 237 */           } else {
/* 238 */             // No more space
/* 239 */             return null;
/* 240 */           }
/* 241 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7)) {
/* 242 */           return batch.getValueRow(buckets[idx]);
/* 243 */         }
/* 244 */         idx = (idx + 1) & (numBuckets - 1);
/* 245 */         step++;
/* 246 */       }
/* 247 */       // Didn't find it
/* 248 */       return null;
/* 249 */     }
/* 250 */
/* 251 */     private boolean equals(int idx, UTF8String agg_key, int agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, int agg_key7) {
/* 252 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 253 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getInt(1) == agg_key1) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getUTF8String(4).equals(agg_key4)) && (row.getUTF8String(5).equals(agg_key5)) && (row.getUTF8String(6).equals(agg_key6)) && (row.getInt(7) == agg_key7);
/* 254 */     }
/* 255 */
/* 256 */     private long hash(UTF8String agg_key, int agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, int agg_key7) {
/* 257 */       long agg_hash = 0;
/* 258 */
/* 259 */       int agg_result = 0;
/* 260 */       byte[] agg_bytes = agg_key.getBytes();
/* 261 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 262 */         int agg_hash1 = agg_bytes[i];
/* 263 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 264 */       }
/* 265 */
/* 266 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 267 */
/* 268 */       int agg_result1 = agg_key1;
/* 269 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 270 */
/* 271 */       int agg_result2 = 0;
/* 272 */       byte[] agg_bytes1 = agg_key2.getBytes();
/* 273 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 274 */         int agg_hash2 = agg_bytes1[i];
/* 275 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash2 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 276 */       }
/* 277 */
/* 278 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 279 */
/* 280 */       int agg_result3 = 0;
/* 281 */       byte[] agg_bytes2 = agg_key3.getBytes();
/* 282 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 283 */         int agg_hash3 = agg_bytes2[i];
/* 284 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash3 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 285 */       }
/* 286 */
/* 287 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 288 */
/* 289 */       int agg_result4 = 0;
/* 290 */       byte[] agg_bytes3 = agg_key4.getBytes();
/* 291 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 292 */         int agg_hash4 = agg_bytes3[i];
/* 293 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash4 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 294 */       }
/* 295 */
/* 296 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 297 */
/* 298 */       int agg_result5 = 0;
/* 299 */       byte[] agg_bytes4 = agg_key5.getBytes();
/* 300 */       for (int i = 0; i < agg_bytes4.length; i++) {
/* 301 */         int agg_hash5 = agg_bytes4[i];
/* 302 */         agg_result5 = (agg_result5 ^ (0x9e3779b9)) + agg_hash5 + (agg_result5 << 6) + (agg_result5 >>> 2);
/* 303 */       }
/* 304 */
/* 305 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 306 */
/* 307 */       int agg_result6 = 0;
/* 308 */       byte[] agg_bytes5 = agg_key6.getBytes();
/* 309 */       for (int i = 0; i < agg_bytes5.length; i++) {
/* 310 */         int agg_hash6 = agg_bytes5[i];
/* 311 */         agg_result6 = (agg_result6 ^ (0x9e3779b9)) + agg_hash6 + (agg_result6 << 6) + (agg_result6 >>> 2);
/* 312 */       }
/* 313 */
/* 314 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result6 + (agg_hash << 6) + (agg_hash >>> 2);
/* 315 */
/* 316 */       int agg_result7 = agg_key7;
/* 317 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result7 + (agg_hash << 6) + (agg_hash >>> 2);
/* 318 */
/* 319 */       return agg_hash;
/* 320 */     }
/* 321 */
/* 322 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 323 */       return batch.rowIterator();
/* 324 */     }
/* 325 */
/* 326 */     public void close() {
/* 327 */       batch.close();
/* 328 */     }
/* 329 */
/* 330 */   }
/* 331 */
/* 332 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 333 */     agg_hashMap = agg_plan.createHashMap();
/* 334 */
/* 335 */     while (inputadapter_input.hasNext()) {
/* 336 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 337 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 338 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 339 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 340 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 341 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 342 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 343 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 344 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 345 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 346 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 347 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 348 */       UTF8String inputadapter_value5 = inputadapter_isNull5 ? null : (inputadapter_row.getUTF8String(5));
/* 349 */       UTF8String inputadapter_value6 = inputadapter_row.getUTF8String(6);
/* 350 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 351 */       int inputadapter_value7 = inputadapter_isNull7 ? -1 : (inputadapter_row.getInt(7));
/* 352 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 353 */       double inputadapter_value8 = inputadapter_isNull8 ? -1.0 : (inputadapter_row.getDouble(8));
/* 354 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 355 */       double inputadapter_value9 = inputadapter_isNull9 ? -1.0 : (inputadapter_row.getDouble(9));
/* 356 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 357 */       double inputadapter_value10 = inputadapter_isNull10 ? -1.0 : (inputadapter_row.getDouble(10));
/* 358 */       boolean inputadapter_isNull11 = inputadapter_row.isNullAt(11);
/* 359 */       double inputadapter_value11 = inputadapter_isNull11 ? -1.0 : (inputadapter_row.getDouble(11));
/* 360 */       boolean inputadapter_isNull12 = inputadapter_row.isNullAt(12);
/* 361 */       double inputadapter_value12 = inputadapter_isNull12 ? -1.0 : (inputadapter_row.getDouble(12));
/* 362 */       boolean inputadapter_isNull13 = inputadapter_row.isNullAt(13);
/* 363 */       double inputadapter_value13 = inputadapter_isNull13 ? -1.0 : (inputadapter_row.getDouble(13));
/* 364 */       boolean inputadapter_isNull14 = inputadapter_row.isNullAt(14);
/* 365 */       double inputadapter_value14 = inputadapter_isNull14 ? -1.0 : (inputadapter_row.getDouble(14));
/* 366 */       boolean inputadapter_isNull15 = inputadapter_row.isNullAt(15);
/* 367 */       double inputadapter_value15 = inputadapter_isNull15 ? -1.0 : (inputadapter_row.getDouble(15));
/* 368 */       boolean inputadapter_isNull16 = inputadapter_row.isNullAt(16);
/* 369 */       double inputadapter_value16 = inputadapter_isNull16 ? -1.0 : (inputadapter_row.getDouble(16));
/* 370 */       boolean inputadapter_isNull17 = inputadapter_row.isNullAt(17);
/* 371 */       double inputadapter_value17 = inputadapter_isNull17 ? -1.0 : (inputadapter_row.getDouble(17));
/* 372 */       boolean inputadapter_isNull18 = inputadapter_row.isNullAt(18);
/* 373 */       double inputadapter_value18 = inputadapter_isNull18 ? -1.0 : (inputadapter_row.getDouble(18));
/* 374 */       boolean inputadapter_isNull19 = inputadapter_row.isNullAt(19);
/* 375 */       double inputadapter_value19 = inputadapter_isNull19 ? -1.0 : (inputadapter_row.getDouble(19));
/* 376 */       boolean inputadapter_isNull20 = inputadapter_row.isNullAt(20);
/* 377 */       double inputadapter_value20 = inputadapter_isNull20 ? -1.0 : (inputadapter_row.getDouble(20));
/* 378 */       boolean inputadapter_isNull21 = inputadapter_row.isNullAt(21);
/* 379 */       double inputadapter_value21 = inputadapter_isNull21 ? -1.0 : (inputadapter_row.getDouble(21));
/* 380 */       boolean inputadapter_isNull22 = inputadapter_row.isNullAt(22);
/* 381 */       double inputadapter_value22 = inputadapter_isNull22 ? -1.0 : (inputadapter_row.getDouble(22));
/* 382 */       boolean inputadapter_isNull23 = inputadapter_row.isNullAt(23);
/* 383 */       double inputadapter_value23 = inputadapter_isNull23 ? -1.0 : (inputadapter_row.getDouble(23));
/* 384 */       boolean inputadapter_isNull24 = inputadapter_row.isNullAt(24);
/* 385 */       double inputadapter_value24 = inputadapter_isNull24 ? -1.0 : (inputadapter_row.getDouble(24));
/* 386 */       boolean inputadapter_isNull25 = inputadapter_row.isNullAt(25);
/* 387 */       double inputadapter_value25 = inputadapter_isNull25 ? -1.0 : (inputadapter_row.getDouble(25));
/* 388 */       boolean inputadapter_isNull26 = inputadapter_row.isNullAt(26);
/* 389 */       double inputadapter_value26 = inputadapter_isNull26 ? -1.0 : (inputadapter_row.getDouble(26));
/* 390 */       boolean inputadapter_isNull27 = inputadapter_row.isNullAt(27);
/* 391 */       double inputadapter_value27 = inputadapter_isNull27 ? -1.0 : (inputadapter_row.getDouble(27));
/* 392 */       boolean inputadapter_isNull28 = inputadapter_row.isNullAt(28);
/* 393 */       double inputadapter_value28 = inputadapter_isNull28 ? -1.0 : (inputadapter_row.getDouble(28));
/* 394 */       boolean inputadapter_isNull29 = inputadapter_row.isNullAt(29);
/* 395 */       double inputadapter_value29 = inputadapter_isNull29 ? -1.0 : (inputadapter_row.getDouble(29));
/* 396 */       boolean inputadapter_isNull30 = inputadapter_row.isNullAt(30);
/* 397 */       double inputadapter_value30 = inputadapter_isNull30 ? -1.0 : (inputadapter_row.getDouble(30));
/* 398 */       boolean inputadapter_isNull31 = inputadapter_row.isNullAt(31);
/* 399 */       double inputadapter_value31 = inputadapter_isNull31 ? -1.0 : (inputadapter_row.getDouble(31));
/* 400 */
/* 401 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 402 */
/* 403 */       UnsafeRow agg_fastAggBuffer = null;
/* 404 */
/* 405 */       if (true) {
/* 406 */         if (!inputadapter_isNull && !inputadapter_isNull1 && !inputadapter_isNull2 && !inputadapter_isNull3 && !inputadapter_isNull4 && !inputadapter_isNull5 && !false && !inputadapter_isNull7) {
/* 407 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 408 */             inputadapter_value, inputadapter_value1, inputadapter_value2, inputadapter_value3, inputadapter_value4, inputadapter_value5, inputadapter_value6, inputadapter_value7);
/* 409 */         }
/* 410 */       }
/* 411 */
/* 412 */       if (agg_fastAggBuffer == null) {
/* 413 */         // generate grouping key
/* 414 */         agg_holder.reset();
/* 415 */
/* 416 */         agg_rowWriter.zeroOutNullBytes();
/* 417 */
/* 418 */         if (inputadapter_isNull) {
/* 419 */           agg_rowWriter.setNullAt(0);
/* 420 */         } else {
/* 421 */           agg_rowWriter.write(0, inputadapter_value);
/* 422 */         }
/* 423 */
/* 424 */         if (inputadapter_isNull1) {
/* 425 */           agg_rowWriter.setNullAt(1);
/* 426 */         } else {
/* 427 */           agg_rowWriter.write(1, inputadapter_value1);
/* 428 */         }
/* 429 */
/* 430 */         if (inputadapter_isNull2) {
/* 431 */           agg_rowWriter.setNullAt(2);
/* 432 */         } else {
/* 433 */           agg_rowWriter.write(2, inputadapter_value2);
/* 434 */         }
/* 435 */
/* 436 */         if (inputadapter_isNull3) {
/* 437 */           agg_rowWriter.setNullAt(3);
/* 438 */         } else {
/* 439 */           agg_rowWriter.write(3, inputadapter_value3);
/* 440 */         }
/* 441 */
/* 442 */         if (inputadapter_isNull4) {
/* 443 */           agg_rowWriter.setNullAt(4);
/* 444 */         } else {
/* 445 */           agg_rowWriter.write(4, inputadapter_value4);
/* 446 */         }
/* 447 */
/* 448 */         if (inputadapter_isNull5) {
/* 449 */           agg_rowWriter.setNullAt(5);
/* 450 */         } else {
/* 451 */           agg_rowWriter.write(5, inputadapter_value5);
/* 452 */         }
/* 453 */
/* 454 */         agg_rowWriter.write(6, inputadapter_value6);
/* 455 */
/* 456 */         if (inputadapter_isNull7) {
/* 457 */           agg_rowWriter.setNullAt(7);
/* 458 */         } else {
/* 459 */           agg_rowWriter.write(7, inputadapter_value7);
/* 460 */         }
/* 461 */         agg_result8.setTotalSize(agg_holder.totalSize());
/* 462 */         agg_value88 = 42;
/* 463 */
/* 464 */         if (!inputadapter_isNull) {
/* 465 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value88);
/* 466 */         }
/* 467 */
/* 468 */         if (!inputadapter_isNull1) {
/* 469 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value88);
/* 470 */         }
/* 471 */
/* 472 */         if (!inputadapter_isNull2) {
/* 473 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value88);
/* 474 */         }
/* 475 */
/* 476 */         if (!inputadapter_isNull3) {
/* 477 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value88);
/* 478 */         }
/* 479 */
/* 480 */         if (!inputadapter_isNull4) {
/* 481 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value4.getBaseObject(), inputadapter_value4.getBaseOffset(), inputadapter_value4.numBytes(), agg_value88);
/* 482 */         }
/* 483 */
/* 484 */         if (!inputadapter_isNull5) {
/* 485 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value5.getBaseObject(), inputadapter_value5.getBaseOffset(), inputadapter_value5.numBytes(), agg_value88);
/* 486 */         }
/* 487 */
/* 488 */         agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value6.getBaseObject(), inputadapter_value6.getBaseOffset(), inputadapter_value6.numBytes(), agg_value88);
/* 489 */
/* 490 */         if (!inputadapter_isNull7) {
/* 491 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value7, agg_value88);
/* 492 */         }
/* 493 */         if (true) {
/* 494 */           // try to get the buffer from hash map
/* 495 */           agg_unsafeRowAggBuffer =
/* 496 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result8, agg_value88);
/* 497 */         }
/* 498 */         if (agg_unsafeRowAggBuffer == null) {
/* 499 */           if (agg_sorter == null) {
/* 500 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 501 */           } else {
/* 502 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 503 */           }
/* 504 */
/* 505 */           // the hash map had be spilled, it should have enough memory now,
/* 506 */           // try  to allocate buffer again.
/* 507 */           agg_unsafeRowAggBuffer =
/* 508 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result8, agg_value88);
/* 509 */           if (agg_unsafeRowAggBuffer == null) {
/* 510 */             // failed to allocate the first page
/* 511 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 512 */           }
/* 513 */         }
/* 514 */       }
/* 515 */
/* 516 */       if (agg_fastAggBuffer != null) {
/* 517 */         // update fast row
/* 518 */
/* 519 */         // common sub-expressions
/* 520 */         boolean agg_isNull329 = inputadapter_isNull1;
/* 521 */         double agg_value365 = -1.0;
/* 522 */         if (!inputadapter_isNull1) {
/* 523 */           agg_value365 = (double) inputadapter_value1;
/* 524 */         }
/* 525 */         boolean agg_isNull331 = false;
/* 526 */         double agg_value367 = -1.0;
/* 527 */         if (!false) {
/* 528 */           agg_value367 = (double) 0;
/* 529 */         }
/* 530 */         // evaluate aggregate function
/* 531 */         boolean agg_isNull334 = true;
/* 532 */         double agg_value370 = -1.0;
/* 533 */
/* 534 */         boolean agg_isNull336 = agg_fastAggBuffer.isNullAt(0);
/* 535 */         double agg_value372 = agg_isNull336 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 536 */         boolean agg_isNull335 = agg_isNull336;
/* 537 */         double agg_value371 = agg_value372;
/* 538 */         if (agg_isNull335) {
/* 539 */           if (!agg_isNull331) {
/* 540 */             agg_isNull335 = false;
/* 541 */             agg_value371 = agg_value367;
/* 542 */           }
/* 543 */         }
/* 544 */
/* 545 */         boolean agg_isNull337 = inputadapter_isNull8;
/* 546 */         double agg_value373 = -1.0;
/* 547 */         if (!inputadapter_isNull8) {
/* 548 */           agg_value373 = inputadapter_value8;
/* 549 */         }
/* 550 */         if (!agg_isNull337) {
/* 551 */           agg_isNull334 = false; // resultCode could change nullability.
/* 552 */           agg_value370 = agg_value371 + agg_value373;
/* 553 */
/* 554 */         }
/* 555 */         boolean agg_isNull333 = agg_isNull334;
/* 556 */         double agg_value369 = agg_value370;
/* 557 */         if (agg_isNull333) {
/* 558 */           boolean agg_isNull339 = agg_fastAggBuffer.isNullAt(0);
/* 559 */           double agg_value375 = agg_isNull339 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 560 */           if (!agg_isNull339) {
/* 561 */             agg_isNull333 = false;
/* 562 */             agg_value369 = agg_value375;
/* 563 */           }
/* 564 */         }
/* 565 */         boolean agg_isNull341 = true;
/* 566 */         double agg_value377 = -1.0;
/* 567 */
/* 568 */         boolean agg_isNull343 = agg_fastAggBuffer.isNullAt(1);
/* 569 */         double agg_value379 = agg_isNull343 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 570 */         boolean agg_isNull342 = agg_isNull343;
/* 571 */         double agg_value378 = agg_value379;
/* 572 */         if (agg_isNull342) {
/* 573 */           if (!agg_isNull331) {
/* 574 */             agg_isNull342 = false;
/* 575 */             agg_value378 = agg_value367;
/* 576 */           }
/* 577 */         }
/* 578 */
/* 579 */         boolean agg_isNull344 = inputadapter_isNull9;
/* 580 */         double agg_value380 = -1.0;
/* 581 */         if (!inputadapter_isNull9) {
/* 582 */           agg_value380 = inputadapter_value9;
/* 583 */         }
/* 584 */         if (!agg_isNull344) {
/* 585 */           agg_isNull341 = false; // resultCode could change nullability.
/* 586 */           agg_value377 = agg_value378 + agg_value380;
/* 587 */
/* 588 */         }
/* 589 */         boolean agg_isNull340 = agg_isNull341;
/* 590 */         double agg_value376 = agg_value377;
/* 591 */         if (agg_isNull340) {
/* 592 */           boolean agg_isNull346 = agg_fastAggBuffer.isNullAt(1);
/* 593 */           double agg_value382 = agg_isNull346 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 594 */           if (!agg_isNull346) {
/* 595 */             agg_isNull340 = false;
/* 596 */             agg_value376 = agg_value382;
/* 597 */           }
/* 598 */         }
/* 599 */         boolean agg_isNull348 = true;
/* 600 */         double agg_value384 = -1.0;
/* 601 */
/* 602 */         boolean agg_isNull350 = agg_fastAggBuffer.isNullAt(2);
/* 603 */         double agg_value386 = agg_isNull350 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 604 */         boolean agg_isNull349 = agg_isNull350;
/* 605 */         double agg_value385 = agg_value386;
/* 606 */         if (agg_isNull349) {
/* 607 */           if (!agg_isNull331) {
/* 608 */             agg_isNull349 = false;
/* 609 */             agg_value385 = agg_value367;
/* 610 */           }
/* 611 */         }
/* 612 */
/* 613 */         boolean agg_isNull351 = inputadapter_isNull10;
/* 614 */         double agg_value387 = -1.0;
/* 615 */         if (!inputadapter_isNull10) {
/* 616 */           agg_value387 = inputadapter_value10;
/* 617 */         }
/* 618 */         if (!agg_isNull351) {
/* 619 */           agg_isNull348 = false; // resultCode could change nullability.
/* 620 */           agg_value384 = agg_value385 + agg_value387;
/* 621 */
/* 622 */         }
/* 623 */         boolean agg_isNull347 = agg_isNull348;
/* 624 */         double agg_value383 = agg_value384;
/* 625 */         if (agg_isNull347) {
/* 626 */           boolean agg_isNull353 = agg_fastAggBuffer.isNullAt(2);
/* 627 */           double agg_value389 = agg_isNull353 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 628 */           if (!agg_isNull353) {
/* 629 */             agg_isNull347 = false;
/* 630 */             agg_value383 = agg_value389;
/* 631 */           }
/* 632 */         }
/* 633 */         boolean agg_isNull355 = true;
/* 634 */         double agg_value391 = -1.0;
/* 635 */
/* 636 */         boolean agg_isNull357 = agg_fastAggBuffer.isNullAt(3);
/* 637 */         double agg_value393 = agg_isNull357 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 638 */         boolean agg_isNull356 = agg_isNull357;
/* 639 */         double agg_value392 = agg_value393;
/* 640 */         if (agg_isNull356) {
/* 641 */           if (!agg_isNull331) {
/* 642 */             agg_isNull356 = false;
/* 643 */             agg_value392 = agg_value367;
/* 644 */           }
/* 645 */         }
/* 646 */
/* 647 */         boolean agg_isNull358 = inputadapter_isNull11;
/* 648 */         double agg_value394 = -1.0;
/* 649 */         if (!inputadapter_isNull11) {
/* 650 */           agg_value394 = inputadapter_value11;
/* 651 */         }
/* 652 */         if (!agg_isNull358) {
/* 653 */           agg_isNull355 = false; // resultCode could change nullability.
/* 654 */           agg_value391 = agg_value392 + agg_value394;
/* 655 */
/* 656 */         }
/* 657 */         boolean agg_isNull354 = agg_isNull355;
/* 658 */         double agg_value390 = agg_value391;
/* 659 */         if (agg_isNull354) {
/* 660 */           boolean agg_isNull360 = agg_fastAggBuffer.isNullAt(3);
/* 661 */           double agg_value396 = agg_isNull360 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 662 */           if (!agg_isNull360) {
/* 663 */             agg_isNull354 = false;
/* 664 */             agg_value390 = agg_value396;
/* 665 */           }
/* 666 */         }
/* 667 */         boolean agg_isNull362 = true;
/* 668 */         double agg_value398 = -1.0;
/* 669 */
/* 670 */         boolean agg_isNull364 = agg_fastAggBuffer.isNullAt(4);
/* 671 */         double agg_value400 = agg_isNull364 ? -1.0 : (agg_fastAggBuffer.getDouble(4));
/* 672 */         boolean agg_isNull363 = agg_isNull364;
/* 673 */         double agg_value399 = agg_value400;
/* 674 */         if (agg_isNull363) {
/* 675 */           if (!agg_isNull331) {
/* 676 */             agg_isNull363 = false;
/* 677 */             agg_value399 = agg_value367;
/* 678 */           }
/* 679 */         }
/* 680 */
/* 681 */         boolean agg_isNull365 = inputadapter_isNull12;
/* 682 */         double agg_value401 = -1.0;
/* 683 */         if (!inputadapter_isNull12) {
/* 684 */           agg_value401 = inputadapter_value12;
/* 685 */         }
/* 686 */         if (!agg_isNull365) {
/* 687 */           agg_isNull362 = false; // resultCode could change nullability.
/* 688 */           agg_value398 = agg_value399 + agg_value401;
/* 689 */
/* 690 */         }
/* 691 */         boolean agg_isNull361 = agg_isNull362;
/* 692 */         double agg_value397 = agg_value398;
/* 693 */         if (agg_isNull361) {
/* 694 */           boolean agg_isNull367 = agg_fastAggBuffer.isNullAt(4);
/* 695 */           double agg_value403 = agg_isNull367 ? -1.0 : (agg_fastAggBuffer.getDouble(4));
/* 696 */           if (!agg_isNull367) {
/* 697 */             agg_isNull361 = false;
/* 698 */             agg_value397 = agg_value403;
/* 699 */           }
/* 700 */         }
/* 701 */         boolean agg_isNull369 = true;
/* 702 */         double agg_value405 = -1.0;
/* 703 */
/* 704 */         boolean agg_isNull371 = agg_fastAggBuffer.isNullAt(5);
/* 705 */         double agg_value407 = agg_isNull371 ? -1.0 : (agg_fastAggBuffer.getDouble(5));
/* 706 */         boolean agg_isNull370 = agg_isNull371;
/* 707 */         double agg_value406 = agg_value407;
/* 708 */         if (agg_isNull370) {
/* 709 */           if (!agg_isNull331) {
/* 710 */             agg_isNull370 = false;
/* 711 */             agg_value406 = agg_value367;
/* 712 */           }
/* 713 */         }
/* 714 */
/* 715 */         boolean agg_isNull372 = inputadapter_isNull13;
/* 716 */         double agg_value408 = -1.0;
/* 717 */         if (!inputadapter_isNull13) {
/* 718 */           agg_value408 = inputadapter_value13;
/* 719 */         }
/* 720 */         if (!agg_isNull372) {
/* 721 */           agg_isNull369 = false; // resultCode could change nullability.
/* 722 */           agg_value405 = agg_value406 + agg_value408;
/* 723 */
/* 724 */         }
/* 725 */         boolean agg_isNull368 = agg_isNull369;
/* 726 */         double agg_value404 = agg_value405;
/* 727 */         if (agg_isNull368) {
/* 728 */           boolean agg_isNull374 = agg_fastAggBuffer.isNullAt(5);
/* 729 */           double agg_value410 = agg_isNull374 ? -1.0 : (agg_fastAggBuffer.getDouble(5));
/* 730 */           if (!agg_isNull374) {
/* 731 */             agg_isNull368 = false;
/* 732 */             agg_value404 = agg_value410;
/* 733 */           }
/* 734 */         }
/* 735 */         boolean agg_isNull376 = true;
/* 736 */         double agg_value412 = -1.0;
/* 737 */
/* 738 */         boolean agg_isNull378 = agg_fastAggBuffer.isNullAt(6);
/* 739 */         double agg_value414 = agg_isNull378 ? -1.0 : (agg_fastAggBuffer.getDouble(6));
/* 740 */         boolean agg_isNull377 = agg_isNull378;
/* 741 */         double agg_value413 = agg_value414;
/* 742 */         if (agg_isNull377) {
/* 743 */           if (!agg_isNull331) {
/* 744 */             agg_isNull377 = false;
/* 745 */             agg_value413 = agg_value367;
/* 746 */           }
/* 747 */         }
/* 748 */
/* 749 */         boolean agg_isNull379 = inputadapter_isNull14;
/* 750 */         double agg_value415 = -1.0;
/* 751 */         if (!inputadapter_isNull14) {
/* 752 */           agg_value415 = inputadapter_value14;
/* 753 */         }
/* 754 */         if (!agg_isNull379) {
/* 755 */           agg_isNull376 = false; // resultCode could change nullability.
/* 756 */           agg_value412 = agg_value413 + agg_value415;
/* 757 */
/* 758 */         }
/* 759 */         boolean agg_isNull375 = agg_isNull376;
/* 760 */         double agg_value411 = agg_value412;
/* 761 */         if (agg_isNull375) {
/* 762 */           boolean agg_isNull381 = agg_fastAggBuffer.isNullAt(6);
/* 763 */           double agg_value417 = agg_isNull381 ? -1.0 : (agg_fastAggBuffer.getDouble(6));
/* 764 */           if (!agg_isNull381) {
/* 765 */             agg_isNull375 = false;
/* 766 */             agg_value411 = agg_value417;
/* 767 */           }
/* 768 */         }
/* 769 */         boolean agg_isNull383 = true;
/* 770 */         double agg_value419 = -1.0;
/* 771 */
/* 772 */         boolean agg_isNull385 = agg_fastAggBuffer.isNullAt(7);
/* 773 */         double agg_value421 = agg_isNull385 ? -1.0 : (agg_fastAggBuffer.getDouble(7));
/* 774 */         boolean agg_isNull384 = agg_isNull385;
/* 775 */         double agg_value420 = agg_value421;
/* 776 */         if (agg_isNull384) {
/* 777 */           if (!agg_isNull331) {
/* 778 */             agg_isNull384 = false;
/* 779 */             agg_value420 = agg_value367;
/* 780 */           }
/* 781 */         }
/* 782 */
/* 783 */         boolean agg_isNull386 = inputadapter_isNull15;
/* 784 */         double agg_value422 = -1.0;
/* 785 */         if (!inputadapter_isNull15) {
/* 786 */           agg_value422 = inputadapter_value15;
/* 787 */         }
/* 788 */         if (!agg_isNull386) {
/* 789 */           agg_isNull383 = false; // resultCode could change nullability.
/* 790 */           agg_value419 = agg_value420 + agg_value422;
/* 791 */
/* 792 */         }
/* 793 */         boolean agg_isNull382 = agg_isNull383;
/* 794 */         double agg_value418 = agg_value419;
/* 795 */         if (agg_isNull382) {
/* 796 */           boolean agg_isNull388 = agg_fastAggBuffer.isNullAt(7);
/* 797 */           double agg_value424 = agg_isNull388 ? -1.0 : (agg_fastAggBuffer.getDouble(7));
/* 798 */           if (!agg_isNull388) {
/* 799 */             agg_isNull382 = false;
/* 800 */             agg_value418 = agg_value424;
/* 801 */           }
/* 802 */         }
/* 803 */         boolean agg_isNull390 = true;
/* 804 */         double agg_value426 = -1.0;
/* 805 */
/* 806 */         boolean agg_isNull392 = agg_fastAggBuffer.isNullAt(8);
/* 807 */         double agg_value428 = agg_isNull392 ? -1.0 : (agg_fastAggBuffer.getDouble(8));
/* 808 */         boolean agg_isNull391 = agg_isNull392;
/* 809 */         double agg_value427 = agg_value428;
/* 810 */         if (agg_isNull391) {
/* 811 */           if (!agg_isNull331) {
/* 812 */             agg_isNull391 = false;
/* 813 */             agg_value427 = agg_value367;
/* 814 */           }
/* 815 */         }
/* 816 */
/* 817 */         boolean agg_isNull393 = inputadapter_isNull16;
/* 818 */         double agg_value429 = -1.0;
/* 819 */         if (!inputadapter_isNull16) {
/* 820 */           agg_value429 = inputadapter_value16;
/* 821 */         }
/* 822 */         if (!agg_isNull393) {
/* 823 */           agg_isNull390 = false; // resultCode could change nullability.
/* 824 */           agg_value426 = agg_value427 + agg_value429;
/* 825 */
/* 826 */         }
/* 827 */         boolean agg_isNull389 = agg_isNull390;
/* 828 */         double agg_value425 = agg_value426;
/* 829 */         if (agg_isNull389) {
/* 830 */           boolean agg_isNull395 = agg_fastAggBuffer.isNullAt(8);
/* 831 */           double agg_value431 = agg_isNull395 ? -1.0 : (agg_fastAggBuffer.getDouble(8));
/* 832 */           if (!agg_isNull395) {
/* 833 */             agg_isNull389 = false;
/* 834 */             agg_value425 = agg_value431;
/* 835 */           }
/* 836 */         }
/* 837 */         boolean agg_isNull397 = true;
/* 838 */         double agg_value433 = -1.0;
/* 839 */
/* 840 */         boolean agg_isNull399 = agg_fastAggBuffer.isNullAt(9);
/* 841 */         double agg_value435 = agg_isNull399 ? -1.0 : (agg_fastAggBuffer.getDouble(9));
/* 842 */         boolean agg_isNull398 = agg_isNull399;
/* 843 */         double agg_value434 = agg_value435;
/* 844 */         if (agg_isNull398) {
/* 845 */           if (!agg_isNull331) {
/* 846 */             agg_isNull398 = false;
/* 847 */             agg_value434 = agg_value367;
/* 848 */           }
/* 849 */         }
/* 850 */
/* 851 */         boolean agg_isNull400 = inputadapter_isNull17;
/* 852 */         double agg_value436 = -1.0;
/* 853 */         if (!inputadapter_isNull17) {
/* 854 */           agg_value436 = inputadapter_value17;
/* 855 */         }
/* 856 */         if (!agg_isNull400) {
/* 857 */           agg_isNull397 = false; // resultCode could change nullability.
/* 858 */           agg_value433 = agg_value434 + agg_value436;
/* 859 */
/* 860 */         }
/* 861 */         boolean agg_isNull396 = agg_isNull397;
/* 862 */         double agg_value432 = agg_value433;
/* 863 */         if (agg_isNull396) {
/* 864 */           boolean agg_isNull402 = agg_fastAggBuffer.isNullAt(9);
/* 865 */           double agg_value438 = agg_isNull402 ? -1.0 : (agg_fastAggBuffer.getDouble(9));
/* 866 */           if (!agg_isNull402) {
/* 867 */             agg_isNull396 = false;
/* 868 */             agg_value432 = agg_value438;
/* 869 */           }
/* 870 */         }
/* 871 */         boolean agg_isNull404 = true;
/* 872 */         double agg_value440 = -1.0;
/* 873 */
/* 874 */         boolean agg_isNull406 = agg_fastAggBuffer.isNullAt(10);
/* 875 */         double agg_value442 = agg_isNull406 ? -1.0 : (agg_fastAggBuffer.getDouble(10));
/* 876 */         boolean agg_isNull405 = agg_isNull406;
/* 877 */         double agg_value441 = agg_value442;
/* 878 */         if (agg_isNull405) {
/* 879 */           if (!agg_isNull331) {
/* 880 */             agg_isNull405 = false;
/* 881 */             agg_value441 = agg_value367;
/* 882 */           }
/* 883 */         }
/* 884 */
/* 885 */         boolean agg_isNull407 = inputadapter_isNull18;
/* 886 */         double agg_value443 = -1.0;
/* 887 */         if (!inputadapter_isNull18) {
/* 888 */           agg_value443 = inputadapter_value18;
/* 889 */         }
/* 890 */         if (!agg_isNull407) {
/* 891 */           agg_isNull404 = false; // resultCode could change nullability.
/* 892 */           agg_value440 = agg_value441 + agg_value443;
/* 893 */
/* 894 */         }
/* 895 */         boolean agg_isNull403 = agg_isNull404;
/* 896 */         double agg_value439 = agg_value440;
/* 897 */         if (agg_isNull403) {
/* 898 */           boolean agg_isNull409 = agg_fastAggBuffer.isNullAt(10);
/* 899 */           double agg_value445 = agg_isNull409 ? -1.0 : (agg_fastAggBuffer.getDouble(10));
/* 900 */           if (!agg_isNull409) {
/* 901 */             agg_isNull403 = false;
/* 902 */             agg_value439 = agg_value445;
/* 903 */           }
/* 904 */         }
/* 905 */         boolean agg_isNull411 = true;
/* 906 */         double agg_value447 = -1.0;
/* 907 */
/* 908 */         boolean agg_isNull413 = agg_fastAggBuffer.isNullAt(11);
/* 909 */         double agg_value449 = agg_isNull413 ? -1.0 : (agg_fastAggBuffer.getDouble(11));
/* 910 */         boolean agg_isNull412 = agg_isNull413;
/* 911 */         double agg_value448 = agg_value449;
/* 912 */         if (agg_isNull412) {
/* 913 */           if (!agg_isNull331) {
/* 914 */             agg_isNull412 = false;
/* 915 */             agg_value448 = agg_value367;
/* 916 */           }
/* 917 */         }
/* 918 */
/* 919 */         boolean agg_isNull414 = inputadapter_isNull19;
/* 920 */         double agg_value450 = -1.0;
/* 921 */         if (!inputadapter_isNull19) {
/* 922 */           agg_value450 = inputadapter_value19;
/* 923 */         }
/* 924 */         if (!agg_isNull414) {
/* 925 */           agg_isNull411 = false; // resultCode could change nullability.
/* 926 */           agg_value447 = agg_value448 + agg_value450;
/* 927 */
/* 928 */         }
/* 929 */         boolean agg_isNull410 = agg_isNull411;
/* 930 */         double agg_value446 = agg_value447;
/* 931 */         if (agg_isNull410) {
/* 932 */           boolean agg_isNull416 = agg_fastAggBuffer.isNullAt(11);
/* 933 */           double agg_value452 = agg_isNull416 ? -1.0 : (agg_fastAggBuffer.getDouble(11));
/* 934 */           if (!agg_isNull416) {
/* 935 */             agg_isNull410 = false;
/* 936 */             agg_value446 = agg_value452;
/* 937 */           }
/* 938 */         }
/* 939 */         boolean agg_isNull418 = true;
/* 940 */         double agg_value454 = -1.0;
/* 941 */
/* 942 */         boolean agg_isNull420 = agg_fastAggBuffer.isNullAt(12);
/* 943 */         double agg_value456 = agg_isNull420 ? -1.0 : (agg_fastAggBuffer.getDouble(12));
/* 944 */         boolean agg_isNull419 = agg_isNull420;
/* 945 */         double agg_value455 = agg_value456;
/* 946 */         if (agg_isNull419) {
/* 947 */           if (!agg_isNull331) {
/* 948 */             agg_isNull419 = false;
/* 949 */             agg_value455 = agg_value367;
/* 950 */           }
/* 951 */         }
/* 952 */
/* 953 */         boolean agg_isNull422 = false;
/* 954 */         double agg_value458 = -1.0;
/* 955 */         if (agg_isNull329 || agg_value365 == 0) {
/* 956 */           agg_isNull422 = true;
/* 957 */         } else {
/* 958 */           if (inputadapter_isNull8) {
/* 959 */             agg_isNull422 = true;
/* 960 */           } else {
/* 961 */             agg_value458 = (double)(inputadapter_value8 / agg_value365);
/* 962 */           }
/* 963 */         }
/* 964 */         boolean agg_isNull421 = agg_isNull422;
/* 965 */         double agg_value457 = -1.0;
/* 966 */         if (!agg_isNull422) {
/* 967 */           agg_value457 = agg_value458;
/* 968 */         }
/* 969 */         if (!agg_isNull421) {
/* 970 */           agg_isNull418 = false; // resultCode could change nullability.
/* 971 */           agg_value454 = agg_value455 + agg_value457;
/* 972 */
/* 973 */         }
/* 974 */         boolean agg_isNull417 = agg_isNull418;
/* 975 */         double agg_value453 = agg_value454;
/* 976 */         if (agg_isNull417) {
/* 977 */           boolean agg_isNull424 = agg_fastAggBuffer.isNullAt(12);
/* 978 */           double agg_value460 = agg_isNull424 ? -1.0 : (agg_fastAggBuffer.getDouble(12));
/* 979 */           if (!agg_isNull424) {
/* 980 */             agg_isNull417 = false;
/* 981 */             agg_value453 = agg_value460;
/* 982 */           }
/* 983 */         }
/* 984 */         boolean agg_isNull426 = true;
/* 985 */         double agg_value462 = -1.0;
/* 986 */
/* 987 */         boolean agg_isNull428 = agg_fastAggBuffer.isNullAt(13);
/* 988 */         double agg_value464 = agg_isNull428 ? -1.0 : (agg_fastAggBuffer.getDouble(13));
/* 989 */         boolean agg_isNull427 = agg_isNull428;
/* 990 */         double agg_value463 = agg_value464;
/* 991 */         if (agg_isNull427) {
/* 992 */           if (!agg_isNull331) {
/* 993 */             agg_isNull427 = false;
/* 994 */             agg_value463 = agg_value367;
/* 995 */           }
/* 996 */         }
/* 997 */
/* 998 */         boolean agg_isNull430 = false;
/* 999 */         double agg_value466 = -1.0;
/* 1000 */         if (agg_isNull329 || agg_value365 == 0) {
/* 1001 */           agg_isNull430 = true;
/* 1002 */         } else {
/* 1003 */           if (inputadapter_isNull9) {
/* 1004 */             agg_isNull430 = true;
/* 1005 */           } else {
/* 1006 */             agg_value466 = (double)(inputadapter_value9 / agg_value365);
/* 1007 */           }
/* 1008 */         }
/* 1009 */         boolean agg_isNull429 = agg_isNull430;
/* 1010 */         double agg_value465 = -1.0;
/* 1011 */         if (!agg_isNull430) {
/* 1012 */           agg_value465 = agg_value466;
/* 1013 */         }
/* 1014 */         if (!agg_isNull429) {
/* 1015 */           agg_isNull426 = false; // resultCode could change nullability.
/* 1016 */           agg_value462 = agg_value463 + agg_value465;
/* 1017 */
/* 1018 */         }
/* 1019 */         boolean agg_isNull425 = agg_isNull426;
/* 1020 */         double agg_value461 = agg_value462;
/* 1021 */         if (agg_isNull425) {
/* 1022 */           boolean agg_isNull432 = agg_fastAggBuffer.isNullAt(13);
/* 1023 */           double agg_value468 = agg_isNull432 ? -1.0 : (agg_fastAggBuffer.getDouble(13));
/* 1024 */           if (!agg_isNull432) {
/* 1025 */             agg_isNull425 = false;
/* 1026 */             agg_value461 = agg_value468;
/* 1027 */           }
/* 1028 */         }
/* 1029 */         boolean agg_isNull434 = true;
/* 1030 */         double agg_value470 = -1.0;
/* 1031 */
/* 1032 */         boolean agg_isNull436 = agg_fastAggBuffer.isNullAt(14);
/* 1033 */         double agg_value472 = agg_isNull436 ? -1.0 : (agg_fastAggBuffer.getDouble(14));
/* 1034 */         boolean agg_isNull435 = agg_isNull436;
/* 1035 */         double agg_value471 = agg_value472;
/* 1036 */         if (agg_isNull435) {
/* 1037 */           if (!agg_isNull331) {
/* 1038 */             agg_isNull435 = false;
/* 1039 */             agg_value471 = agg_value367;
/* 1040 */           }
/* 1041 */         }
/* 1042 */
/* 1043 */         boolean agg_isNull438 = false;
/* 1044 */         double agg_value474 = -1.0;
/* 1045 */         if (agg_isNull329 || agg_value365 == 0) {
/* 1046 */           agg_isNull438 = true;
/* 1047 */         } else {
/* 1048 */           if (inputadapter_isNull10) {
/* 1049 */             agg_isNull438 = true;
/* 1050 */           } else {
/* 1051 */             agg_value474 = (double)(inputadapter_value10 / agg_value365);
/* 1052 */           }
/* 1053 */         }
/* 1054 */         boolean agg_isNull437 = agg_isNull438;
/* 1055 */         double agg_value473 = -1.0;
/* 1056 */         if (!agg_isNull438) {
/* 1057 */           agg_value473 = agg_value474;
/* 1058 */         }
/* 1059 */         if (!agg_isNull437) {
/* 1060 */           agg_isNull434 = false; // resultCode could change nullability.
/* 1061 */           agg_value470 = agg_value471 + agg_value473;
/* 1062 */
/* 1063 */         }
/* 1064 */         boolean agg_isNull433 = agg_isNull434;
/* 1065 */         double agg_value469 = agg_value470;
/* 1066 */         if (agg_isNull433) {
/* 1067 */           boolean agg_isNull440 = agg_fastAggBuffer.isNullAt(14);
/* 1068 */           double agg_value476 = agg_isNull440 ? -1.0 : (agg_fastAggBuffer.getDouble(14));
/* 1069 */           if (!agg_isNull440) {
/* 1070 */             agg_isNull433 = false;
/* 1071 */             agg_value469 = agg_value476;
/* 1072 */           }
/* 1073 */         }
/* 1074 */         boolean agg_isNull442 = true;
/* 1075 */         double agg_value478 = -1.0;
/* 1076 */
/* 1077 */         boolean agg_isNull444 = agg_fastAggBuffer.isNullAt(15);
/* 1078 */         double agg_value480 = agg_isNull444 ? -1.0 : (agg_fastAggBuffer.getDouble(15));
/* 1079 */         boolean agg_isNull443 = agg_isNull444;
/* 1080 */         double agg_value479 = agg_value480;
/* 1081 */         if (agg_isNull443) {
/* 1082 */           if (!agg_isNull331) {
/* 1083 */             agg_isNull443 = false;
/* 1084 */             agg_value479 = agg_value367;
/* 1085 */           }
/* 1086 */         }
/* 1087 */
/* 1088 */         boolean agg_isNull446 = false;
/* 1089 */         double agg_value482 = -1.0;
/* 1090 */         if (agg_isNull329 || agg_value365 == 0) {
/* 1091 */           agg_isNull446 = true;
/* 1092 */         } else {
/* 1093 */           if (inputadapter_isNull11) {
/* 1094 */             agg_isNull446 = true;
/* 1095 */           } else {
/* 1096 */             agg_value482 = (double)(inputadapter_value11 / agg_value365);
/* 1097 */           }
/* 1098 */         }
/* 1099 */         boolean agg_isNull445 = agg_isNull446;
/* 1100 */         double agg_value481 = -1.0;
/* 1101 */         if (!agg_isNull446) {
/* 1102 */           agg_value481 = agg_value482;
/* 1103 */         }
/* 1104 */         if (!agg_isNull445) {
/* 1105 */           agg_isNull442 = false; // resultCode could change nullability.
/* 1106 */           agg_value478 = agg_value479 + agg_value481;
/* 1107 */
/* 1108 */         }
/* 1109 */         boolean agg_isNull441 = agg_isNull442;
/* 1110 */         double agg_value477 = agg_value478;
/* 1111 */         if (agg_isNull441) {
/* 1112 */           boolean agg_isNull448 = agg_fastAggBuffer.isNullAt(15);
/* 1113 */           double agg_value484 = agg_isNull448 ? -1.0 : (agg_fastAggBuffer.getDouble(15));
/* 1114 */           if (!agg_isNull448) {
/* 1115 */             agg_isNull441 = false;
/* 1116 */             agg_value477 = agg_value484;
/* 1117 */           }
/* 1118 */         }
/* 1119 */         boolean agg_isNull450 = true;
/* 1120 */         double agg_value486 = -1.0;
/* 1121 */
/* 1122 */         boolean agg_isNull452 = agg_fastAggBuffer.isNullAt(16);
/* 1123 */         double agg_value488 = agg_isNull452 ? -1.0 : (agg_fastAggBuffer.getDouble(16));
/* 1124 */         boolean agg_isNull451 = agg_isNull452;
/* 1125 */         double agg_value487 = agg_value488;
/* 1126 */         if (agg_isNull451) {
/* 1127 */           if (!agg_isNull331) {
/* 1128 */             agg_isNull451 = false;
/* 1129 */             agg_value487 = agg_value367;
/* 1130 */           }
/* 1131 */         }
/* 1132 */
/* 1133 */         boolean agg_isNull454 = false;
/* 1134 */         double agg_value490 = -1.0;
/* 1135 */         if (agg_isNull329 || agg_value365 == 0) {
/* 1136 */           agg_isNull454 = true;
/* 1137 */         } else {
/* 1138 */           if (inputadapter_isNull12) {
/* 1139 */             agg_isNull454 = true;
/* 1140 */           } else {
/* 1141 */             agg_value490 = (double)(inputadapter_value12 / agg_value365);
/* 1142 */           }
/* 1143 */         }
/* 1144 */         boolean agg_isNull453 = agg_isNull454;
/* 1145 */         double agg_value489 = -1.0;
/* 1146 */         if (!agg_isNull454) {
/* 1147 */           agg_value489 = agg_value490;
/* 1148 */         }
/* 1149 */         if (!agg_isNull453) {
/* 1150 */           agg_isNull450 = false; // resultCode could change nullability.
/* 1151 */           agg_value486 = agg_value487 + agg_value489;
/* 1152 */
/* 1153 */         }
/* 1154 */         boolean agg_isNull449 = agg_isNull450;
/* 1155 */         double agg_value485 = agg_value486;
/* 1156 */         if (agg_isNull449) {
/* 1157 */           boolean agg_isNull456 = agg_fastAggBuffer.isNullAt(16);
/* 1158 */           double agg_value492 = agg_isNull456 ? -1.0 : (agg_fastAggBuffer.getDouble(16));
/* 1159 */           if (!agg_isNull456) {
/* 1160 */             agg_isNull449 = false;
/* 1161 */             agg_value485 = agg_value492;
/* 1162 */           }
/* 1163 */         }
/* 1164 */         boolean agg_isNull458 = true;
/* 1165 */         double agg_value494 = -1.0;
/* 1166 */
/* 1167 */         boolean agg_isNull460 = agg_fastAggBuffer.isNullAt(17);
/* 1168 */         double agg_value496 = agg_isNull460 ? -1.0 : (agg_fastAggBuffer.getDouble(17));
/* 1169 */         boolean agg_isNull459 = agg_isNull460;
/* 1170 */         double agg_value495 = agg_value496;
/* 1171 */         if (agg_isNull459) {
/* 1172 */           if (!agg_isNull331) {
/* 1173 */             agg_isNull459 = false;
/* 1174 */             agg_value495 = agg_value367;
/* 1175 */           }
/* 1176 */         }
/* 1177 */
/* 1178 */         boolean agg_isNull462 = false;
/* 1179 */         double agg_value498 = -1.0;
/* 1180 */         if (agg_isNull329 || agg_value365 == 0) {
/* 1181 */           agg_isNull462 = true;
/* 1182 */         } else {
/* 1183 */           if (inputadapter_isNull13) {
/* 1184 */             agg_isNull462 = true;
/* 1185 */           } else {
/* 1186 */             agg_value498 = (double)(inputadapter_value13 / agg_value365);
/* 1187 */           }
/* 1188 */         }
/* 1189 */         boolean agg_isNull461 = agg_isNull462;
/* 1190 */         double agg_value497 = -1.0;
/* 1191 */         if (!agg_isNull462) {
/* 1192 */           agg_value497 = agg_value498;
/* 1193 */         }
/* 1194 */         if (!agg_isNull461) {
/* 1195 */           agg_isNull458 = false; // resultCode could change nullability.
/* 1196 */           agg_value494 = agg_value495 + agg_value497;
/* 1197 */
/* 1198 */         }
/* 1199 */         boolean agg_isNull457 = agg_isNull458;
/* 1200 */         double agg_value493 = agg_value494;
/* 1201 */         if (agg_isNull457) {
/* 1202 */           boolean agg_isNull464 = agg_fastAggBuffer.isNullAt(17);
/* 1203 */           double agg_value500 = agg_isNull464 ? -1.0 : (agg_fastAggBuffer.getDouble(17));
/* 1204 */           if (!agg_isNull464) {
/* 1205 */             agg_isNull457 = false;
/* 1206 */             agg_value493 = agg_value500;
/* 1207 */           }
/* 1208 */         }
/* 1209 */         boolean agg_isNull466 = true;
/* 1210 */         double agg_value502 = -1.0;
/* 1211 */
/* 1212 */         boolean agg_isNull468 = agg_fastAggBuffer.isNullAt(18);
/* 1213 */         double agg_value504 = agg_isNull468 ? -1.0 : (agg_fastAggBuffer.getDouble(18));
/* 1214 */         boolean agg_isNull467 = agg_isNull468;
/* 1215 */         double agg_value503 = agg_value504;
/* 1216 */         if (agg_isNull467) {
/* 1217 */           if (!agg_isNull331) {
/* 1218 */             agg_isNull467 = false;
/* 1219 */             agg_value503 = agg_value367;
/* 1220 */           }
/* 1221 */         }
/* 1222 */
/* 1223 */         boolean agg_isNull470 = false;
/* 1224 */         double agg_value506 = -1.0;
/* 1225 */         if (agg_isNull329 || agg_value365 == 0) {
/* 1226 */           agg_isNull470 = true;
/* 1227 */         } else {
/* 1228 */           if (inputadapter_isNull14) {
/* 1229 */             agg_isNull470 = true;
/* 1230 */           } else {
/* 1231 */             agg_value506 = (double)(inputadapter_value14 / agg_value365);
/* 1232 */           }
/* 1233 */         }
/* 1234 */         boolean agg_isNull469 = agg_isNull470;
/* 1235 */         double agg_value505 = -1.0;
/* 1236 */         if (!agg_isNull470) {
/* 1237 */           agg_value505 = agg_value506;
/* 1238 */         }
/* 1239 */         if (!agg_isNull469) {
/* 1240 */           agg_isNull466 = false; // resultCode could change nullability.
/* 1241 */           agg_value502 = agg_value503 + agg_value505;
/* 1242 */
/* 1243 */         }
/* 1244 */         boolean agg_isNull465 = agg_isNull466;
/* 1245 */         double agg_value501 = agg_value502;
/* 1246 */         if (agg_isNull465) {
/* 1247 */           boolean agg_isNull472 = agg_fastAggBuffer.isNullAt(18);
/* 1248 */           double agg_value508 = agg_isNull472 ? -1.0 : (agg_fastAggBuffer.getDouble(18));
/* 1249 */           if (!agg_isNull472) {
/* 1250 */             agg_isNull465 = false;
/* 1251 */             agg_value501 = agg_value508;
/* 1252 */           }
/* 1253 */         }
/* 1254 */         boolean agg_isNull474 = true;
/* 1255 */         double agg_value510 = -1.0;
/* 1256 */
/* 1257 */         boolean agg_isNull476 = agg_fastAggBuffer.isNullAt(19);
/* 1258 */         double agg_value512 = agg_isNull476 ? -1.0 : (agg_fastAggBuffer.getDouble(19));
/* 1259 */         boolean agg_isNull475 = agg_isNull476;
/* 1260 */         double agg_value511 = agg_value512;
/* 1261 */         if (agg_isNull475) {
/* 1262 */           if (!agg_isNull331) {
/* 1263 */             agg_isNull475 = false;
/* 1264 */             agg_value511 = agg_value367;
/* 1265 */           }
/* 1266 */         }
/* 1267 */
/* 1268 */         boolean agg_isNull478 = false;
/* 1269 */         double agg_value514 = -1.0;
/* 1270 */         if (agg_isNull329 || agg_value365 == 0) {
/* 1271 */           agg_isNull478 = true;
/* 1272 */         } else {
/* 1273 */           if (inputadapter_isNull15) {
/* 1274 */             agg_isNull478 = true;
/* 1275 */           } else {
/* 1276 */             agg_value514 = (double)(inputadapter_value15 / agg_value365);
/* 1277 */           }
/* 1278 */         }
/* 1279 */         boolean agg_isNull477 = agg_isNull478;
/* 1280 */         double agg_value513 = -1.0;
/* 1281 */         if (!agg_isNull478) {
/* 1282 */           agg_value513 = agg_value514;
/* 1283 */         }
/* 1284 */         if (!agg_isNull477) {
/* 1285 */           agg_isNull474 = false; // resultCode could change nullability.
/* 1286 */           agg_value510 = agg_value511 + agg_value513;
/* 1287 */
/* 1288 */         }
/* 1289 */         boolean agg_isNull473 = agg_isNull474;
/* 1290 */         double agg_value509 = agg_value510;
/* 1291 */         if (agg_isNull473) {
/* 1292 */           boolean agg_isNull480 = agg_fastAggBuffer.isNullAt(19);
/* 1293 */           double agg_value516 = agg_isNull480 ? -1.0 : (agg_fastAggBuffer.getDouble(19));
/* 1294 */           if (!agg_isNull480) {
/* 1295 */             agg_isNull473 = false;
/* 1296 */             agg_value509 = agg_value516;
/* 1297 */           }
/* 1298 */         }
/* 1299 */         boolean agg_isNull482 = true;
/* 1300 */         double agg_value518 = -1.0;
/* 1301 */
/* 1302 */         boolean agg_isNull484 = agg_fastAggBuffer.isNullAt(20);
/* 1303 */         double agg_value520 = agg_isNull484 ? -1.0 : (agg_fastAggBuffer.getDouble(20));
/* 1304 */         boolean agg_isNull483 = agg_isNull484;
/* 1305 */         double agg_value519 = agg_value520;
/* 1306 */         if (agg_isNull483) {
/* 1307 */           if (!agg_isNull331) {
/* 1308 */             agg_isNull483 = false;
/* 1309 */             agg_value519 = agg_value367;
/* 1310 */           }
/* 1311 */         }
/* 1312 */
/* 1313 */         boolean agg_isNull486 = false;
/* 1314 */         double agg_value522 = -1.0;
/* 1315 */         if (agg_isNull329 || agg_value365 == 0) {
/* 1316 */           agg_isNull486 = true;
/* 1317 */         } else {
/* 1318 */           if (inputadapter_isNull16) {
/* 1319 */             agg_isNull486 = true;
/* 1320 */           } else {
/* 1321 */             agg_value522 = (double)(inputadapter_value16 / agg_value365);
/* 1322 */           }
/* 1323 */         }
/* 1324 */         boolean agg_isNull485 = agg_isNull486;
/* 1325 */         double agg_value521 = -1.0;
/* 1326 */         if (!agg_isNull486) {
/* 1327 */           agg_value521 = agg_value522;
/* 1328 */         }
/* 1329 */         if (!agg_isNull485) {
/* 1330 */           agg_isNull482 = false; // resultCode could change nullability.
/* 1331 */           agg_value518 = agg_value519 + agg_value521;
/* 1332 */
/* 1333 */         }
/* 1334 */         boolean agg_isNull481 = agg_isNull482;
/* 1335 */         double agg_value517 = agg_value518;
/* 1336 */         if (agg_isNull481) {
/* 1337 */           boolean agg_isNull488 = agg_fastAggBuffer.isNullAt(20);
/* 1338 */           double agg_value524 = agg_isNull488 ? -1.0 : (agg_fastAggBuffer.getDouble(20));
/* 1339 */           if (!agg_isNull488) {
/* 1340 */             agg_isNull481 = false;
/* 1341 */             agg_value517 = agg_value524;
/* 1342 */           }
/* 1343 */         }
/* 1344 */         boolean agg_isNull490 = true;
/* 1345 */         double agg_value526 = -1.0;
/* 1346 */
/* 1347 */         boolean agg_isNull492 = agg_fastAggBuffer.isNullAt(21);
/* 1348 */         double agg_value528 = agg_isNull492 ? -1.0 : (agg_fastAggBuffer.getDouble(21));
/* 1349 */         boolean agg_isNull491 = agg_isNull492;
/* 1350 */         double agg_value527 = agg_value528;
/* 1351 */         if (agg_isNull491) {
/* 1352 */           if (!agg_isNull331) {
/* 1353 */             agg_isNull491 = false;
/* 1354 */             agg_value527 = agg_value367;
/* 1355 */           }
/* 1356 */         }
/* 1357 */
/* 1358 */         boolean agg_isNull494 = false;
/* 1359 */         double agg_value530 = -1.0;
/* 1360 */         if (agg_isNull329 || agg_value365 == 0) {
/* 1361 */           agg_isNull494 = true;
/* 1362 */         } else {
/* 1363 */           if (inputadapter_isNull17) {
/* 1364 */             agg_isNull494 = true;
/* 1365 */           } else {
/* 1366 */             agg_value530 = (double)(inputadapter_value17 / agg_value365);
/* 1367 */           }
/* 1368 */         }
/* 1369 */         boolean agg_isNull493 = agg_isNull494;
/* 1370 */         double agg_value529 = -1.0;
/* 1371 */         if (!agg_isNull494) {
/* 1372 */           agg_value529 = agg_value530;
/* 1373 */         }
/* 1374 */         if (!agg_isNull493) {
/* 1375 */           agg_isNull490 = false; // resultCode could change nullability.
/* 1376 */           agg_value526 = agg_value527 + agg_value529;
/* 1377 */
/* 1378 */         }
/* 1379 */         boolean agg_isNull489 = agg_isNull490;
/* 1380 */         double agg_value525 = agg_value526;
/* 1381 */         if (agg_isNull489) {
/* 1382 */           boolean agg_isNull496 = agg_fastAggBuffer.isNullAt(21);
/* 1383 */           double agg_value532 = agg_isNull496 ? -1.0 : (agg_fastAggBuffer.getDouble(21));
/* 1384 */           if (!agg_isNull496) {
/* 1385 */             agg_isNull489 = false;
/* 1386 */             agg_value525 = agg_value532;
/* 1387 */           }
/* 1388 */         }
/* 1389 */         boolean agg_isNull498 = true;
/* 1390 */         double agg_value534 = -1.0;
/* 1391 */
/* 1392 */         boolean agg_isNull500 = agg_fastAggBuffer.isNullAt(22);
/* 1393 */         double agg_value536 = agg_isNull500 ? -1.0 : (agg_fastAggBuffer.getDouble(22));
/* 1394 */         boolean agg_isNull499 = agg_isNull500;
/* 1395 */         double agg_value535 = agg_value536;
/* 1396 */         if (agg_isNull499) {
/* 1397 */           if (!agg_isNull331) {
/* 1398 */             agg_isNull499 = false;
/* 1399 */             agg_value535 = agg_value367;
/* 1400 */           }
/* 1401 */         }
/* 1402 */
/* 1403 */         boolean agg_isNull502 = false;
/* 1404 */         double agg_value538 = -1.0;
/* 1405 */         if (agg_isNull329 || agg_value365 == 0) {
/* 1406 */           agg_isNull502 = true;
/* 1407 */         } else {
/* 1408 */           if (inputadapter_isNull18) {
/* 1409 */             agg_isNull502 = true;
/* 1410 */           } else {
/* 1411 */             agg_value538 = (double)(inputadapter_value18 / agg_value365);
/* 1412 */           }
/* 1413 */         }
/* 1414 */         boolean agg_isNull501 = agg_isNull502;
/* 1415 */         double agg_value537 = -1.0;
/* 1416 */         if (!agg_isNull502) {
/* 1417 */           agg_value537 = agg_value538;
/* 1418 */         }
/* 1419 */         if (!agg_isNull501) {
/* 1420 */           agg_isNull498 = false; // resultCode could change nullability.
/* 1421 */           agg_value534 = agg_value535 + agg_value537;
/* 1422 */
/* 1423 */         }
/* 1424 */         boolean agg_isNull497 = agg_isNull498;
/* 1425 */         double agg_value533 = agg_value534;
/* 1426 */         if (agg_isNull497) {
/* 1427 */           boolean agg_isNull504 = agg_fastAggBuffer.isNullAt(22);
/* 1428 */           double agg_value540 = agg_isNull504 ? -1.0 : (agg_fastAggBuffer.getDouble(22));
/* 1429 */           if (!agg_isNull504) {
/* 1430 */             agg_isNull497 = false;
/* 1431 */             agg_value533 = agg_value540;
/* 1432 */           }
/* 1433 */         }
/* 1434 */         boolean agg_isNull506 = true;
/* 1435 */         double agg_value542 = -1.0;
/* 1436 */
/* 1437 */         boolean agg_isNull508 = agg_fastAggBuffer.isNullAt(23);
/* 1438 */         double agg_value544 = agg_isNull508 ? -1.0 : (agg_fastAggBuffer.getDouble(23));
/* 1439 */         boolean agg_isNull507 = agg_isNull508;
/* 1440 */         double agg_value543 = agg_value544;
/* 1441 */         if (agg_isNull507) {
/* 1442 */           if (!agg_isNull331) {
/* 1443 */             agg_isNull507 = false;
/* 1444 */             agg_value543 = agg_value367;
/* 1445 */           }
/* 1446 */         }
/* 1447 */
/* 1448 */         boolean agg_isNull510 = false;
/* 1449 */         double agg_value546 = -1.0;
/* 1450 */         if (agg_isNull329 || agg_value365 == 0) {
/* 1451 */           agg_isNull510 = true;
/* 1452 */         } else {
/* 1453 */           if (inputadapter_isNull19) {
/* 1454 */             agg_isNull510 = true;
/* 1455 */           } else {
/* 1456 */             agg_value546 = (double)(inputadapter_value19 / agg_value365);
/* 1457 */           }
/* 1458 */         }
/* 1459 */         boolean agg_isNull509 = agg_isNull510;
/* 1460 */         double agg_value545 = -1.0;
/* 1461 */         if (!agg_isNull510) {
/* 1462 */           agg_value545 = agg_value546;
/* 1463 */         }
/* 1464 */         if (!agg_isNull509) {
/* 1465 */           agg_isNull506 = false; // resultCode could change nullability.
/* 1466 */           agg_value542 = agg_value543 + agg_value545;
/* 1467 */
/* 1468 */         }
/* 1469 */         boolean agg_isNull505 = agg_isNull506;
/* 1470 */         double agg_value541 = agg_value542;
/* 1471 */         if (agg_isNull505) {
/* 1472 */           boolean agg_isNull512 = agg_fastAggBuffer.isNullAt(23);
/* 1473 */           double agg_value548 = agg_isNull512 ? -1.0 : (agg_fastAggBuffer.getDouble(23));
/* 1474 */           if (!agg_isNull512) {
/* 1475 */             agg_isNull505 = false;
/* 1476 */             agg_value541 = agg_value548;
/* 1477 */           }
/* 1478 */         }
/* 1479 */         boolean agg_isNull514 = true;
/* 1480 */         double agg_value550 = -1.0;
/* 1481 */
/* 1482 */         boolean agg_isNull516 = agg_fastAggBuffer.isNullAt(24);
/* 1483 */         double agg_value552 = agg_isNull516 ? -1.0 : (agg_fastAggBuffer.getDouble(24));
/* 1484 */         boolean agg_isNull515 = agg_isNull516;
/* 1485 */         double agg_value551 = agg_value552;
/* 1486 */         if (agg_isNull515) {
/* 1487 */           if (!agg_isNull331) {
/* 1488 */             agg_isNull515 = false;
/* 1489 */             agg_value551 = agg_value367;
/* 1490 */           }
/* 1491 */         }
/* 1492 */
/* 1493 */         boolean agg_isNull517 = inputadapter_isNull20;
/* 1494 */         double agg_value553 = -1.0;
/* 1495 */         if (!inputadapter_isNull20) {
/* 1496 */           agg_value553 = inputadapter_value20;
/* 1497 */         }
/* 1498 */         if (!agg_isNull517) {
/* 1499 */           agg_isNull514 = false; // resultCode could change nullability.
/* 1500 */           agg_value550 = agg_value551 + agg_value553;
/* 1501 */
/* 1502 */         }
/* 1503 */         boolean agg_isNull513 = agg_isNull514;
/* 1504 */         double agg_value549 = agg_value550;
/* 1505 */         if (agg_isNull513) {
/* 1506 */           boolean agg_isNull519 = agg_fastAggBuffer.isNullAt(24);
/* 1507 */           double agg_value555 = agg_isNull519 ? -1.0 : (agg_fastAggBuffer.getDouble(24));
/* 1508 */           if (!agg_isNull519) {
/* 1509 */             agg_isNull513 = false;
/* 1510 */             agg_value549 = agg_value555;
/* 1511 */           }
/* 1512 */         }
/* 1513 */         boolean agg_isNull521 = true;
/* 1514 */         double agg_value557 = -1.0;
/* 1515 */
/* 1516 */         boolean agg_isNull523 = agg_fastAggBuffer.isNullAt(25);
/* 1517 */         double agg_value559 = agg_isNull523 ? -1.0 : (agg_fastAggBuffer.getDouble(25));
/* 1518 */         boolean agg_isNull522 = agg_isNull523;
/* 1519 */         double agg_value558 = agg_value559;
/* 1520 */         if (agg_isNull522) {
/* 1521 */           if (!agg_isNull331) {
/* 1522 */             agg_isNull522 = false;
/* 1523 */             agg_value558 = agg_value367;
/* 1524 */           }
/* 1525 */         }
/* 1526 */
/* 1527 */         boolean agg_isNull524 = inputadapter_isNull21;
/* 1528 */         double agg_value560 = -1.0;
/* 1529 */         if (!inputadapter_isNull21) {
/* 1530 */           agg_value560 = inputadapter_value21;
/* 1531 */         }
/* 1532 */         if (!agg_isNull524) {
/* 1533 */           agg_isNull521 = false; // resultCode could change nullability.
/* 1534 */           agg_value557 = agg_value558 + agg_value560;
/* 1535 */
/* 1536 */         }
/* 1537 */         boolean agg_isNull520 = agg_isNull521;
/* 1538 */         double agg_value556 = agg_value557;
/* 1539 */         if (agg_isNull520) {
/* 1540 */           boolean agg_isNull526 = agg_fastAggBuffer.isNullAt(25);
/* 1541 */           double agg_value562 = agg_isNull526 ? -1.0 : (agg_fastAggBuffer.getDouble(25));
/* 1542 */           if (!agg_isNull526) {
/* 1543 */             agg_isNull520 = false;
/* 1544 */             agg_value556 = agg_value562;
/* 1545 */           }
/* 1546 */         }
/* 1547 */         boolean agg_isNull528 = true;
/* 1548 */         double agg_value564 = -1.0;
/* 1549 */
/* 1550 */         boolean agg_isNull530 = agg_fastAggBuffer.isNullAt(26);
/* 1551 */         double agg_value566 = agg_isNull530 ? -1.0 : (agg_fastAggBuffer.getDouble(26));
/* 1552 */         boolean agg_isNull529 = agg_isNull530;
/* 1553 */         double agg_value565 = agg_value566;
/* 1554 */         if (agg_isNull529) {
/* 1555 */           if (!agg_isNull331) {
/* 1556 */             agg_isNull529 = false;
/* 1557 */             agg_value565 = agg_value367;
/* 1558 */           }
/* 1559 */         }
/* 1560 */
/* 1561 */         boolean agg_isNull531 = inputadapter_isNull22;
/* 1562 */         double agg_value567 = -1.0;
/* 1563 */         if (!inputadapter_isNull22) {
/* 1564 */           agg_value567 = inputadapter_value22;
/* 1565 */         }
/* 1566 */         if (!agg_isNull531) {
/* 1567 */           agg_isNull528 = false; // resultCode could change nullability.
/* 1568 */           agg_value564 = agg_value565 + agg_value567;
/* 1569 */
/* 1570 */         }
/* 1571 */         boolean agg_isNull527 = agg_isNull528;
/* 1572 */         double agg_value563 = agg_value564;
/* 1573 */         if (agg_isNull527) {
/* 1574 */           boolean agg_isNull533 = agg_fastAggBuffer.isNullAt(26);
/* 1575 */           double agg_value569 = agg_isNull533 ? -1.0 : (agg_fastAggBuffer.getDouble(26));
/* 1576 */           if (!agg_isNull533) {
/* 1577 */             agg_isNull527 = false;
/* 1578 */             agg_value563 = agg_value569;
/* 1579 */           }
/* 1580 */         }
/* 1581 */         boolean agg_isNull535 = true;
/* 1582 */         double agg_value571 = -1.0;
/* 1583 */
/* 1584 */         boolean agg_isNull537 = agg_fastAggBuffer.isNullAt(27);
/* 1585 */         double agg_value573 = agg_isNull537 ? -1.0 : (agg_fastAggBuffer.getDouble(27));
/* 1586 */         boolean agg_isNull536 = agg_isNull537;
/* 1587 */         double agg_value572 = agg_value573;
/* 1588 */         if (agg_isNull536) {
/* 1589 */           if (!agg_isNull331) {
/* 1590 */             agg_isNull536 = false;
/* 1591 */             agg_value572 = agg_value367;
/* 1592 */           }
/* 1593 */         }
/* 1594 */
/* 1595 */         boolean agg_isNull538 = inputadapter_isNull23;
/* 1596 */         double agg_value574 = -1.0;
/* 1597 */         if (!inputadapter_isNull23) {
/* 1598 */           agg_value574 = inputadapter_value23;
/* 1599 */         }
/* 1600 */         if (!agg_isNull538) {
/* 1601 */           agg_isNull535 = false; // resultCode could change nullability.
/* 1602 */           agg_value571 = agg_value572 + agg_value574;
/* 1603 */
/* 1604 */         }
/* 1605 */         boolean agg_isNull534 = agg_isNull535;
/* 1606 */         double agg_value570 = agg_value571;
/* 1607 */         if (agg_isNull534) {
/* 1608 */           boolean agg_isNull540 = agg_fastAggBuffer.isNullAt(27);
/* 1609 */           double agg_value576 = agg_isNull540 ? -1.0 : (agg_fastAggBuffer.getDouble(27));
/* 1610 */           if (!agg_isNull540) {
/* 1611 */             agg_isNull534 = false;
/* 1612 */             agg_value570 = agg_value576;
/* 1613 */           }
/* 1614 */         }
/* 1615 */         boolean agg_isNull542 = true;
/* 1616 */         double agg_value578 = -1.0;
/* 1617 */
/* 1618 */         boolean agg_isNull544 = agg_fastAggBuffer.isNullAt(28);
/* 1619 */         double agg_value580 = agg_isNull544 ? -1.0 : (agg_fastAggBuffer.getDouble(28));
/* 1620 */         boolean agg_isNull543 = agg_isNull544;
/* 1621 */         double agg_value579 = agg_value580;
/* 1622 */         if (agg_isNull543) {
/* 1623 */           if (!agg_isNull331) {
/* 1624 */             agg_isNull543 = false;
/* 1625 */             agg_value579 = agg_value367;
/* 1626 */           }
/* 1627 */         }
/* 1628 */
/* 1629 */         boolean agg_isNull545 = inputadapter_isNull24;
/* 1630 */         double agg_value581 = -1.0;
/* 1631 */         if (!inputadapter_isNull24) {
/* 1632 */           agg_value581 = inputadapter_value24;
/* 1633 */         }
/* 1634 */         if (!agg_isNull545) {
/* 1635 */           agg_isNull542 = false; // resultCode could change nullability.
/* 1636 */           agg_value578 = agg_value579 + agg_value581;
/* 1637 */
/* 1638 */         }
/* 1639 */         boolean agg_isNull541 = agg_isNull542;
/* 1640 */         double agg_value577 = agg_value578;
/* 1641 */         if (agg_isNull541) {
/* 1642 */           boolean agg_isNull547 = agg_fastAggBuffer.isNullAt(28);
/* 1643 */           double agg_value583 = agg_isNull547 ? -1.0 : (agg_fastAggBuffer.getDouble(28));
/* 1644 */           if (!agg_isNull547) {
/* 1645 */             agg_isNull541 = false;
/* 1646 */             agg_value577 = agg_value583;
/* 1647 */           }
/* 1648 */         }
/* 1649 */         boolean agg_isNull549 = true;
/* 1650 */         double agg_value585 = -1.0;
/* 1651 */
/* 1652 */         boolean agg_isNull551 = agg_fastAggBuffer.isNullAt(29);
/* 1653 */         double agg_value587 = agg_isNull551 ? -1.0 : (agg_fastAggBuffer.getDouble(29));
/* 1654 */         boolean agg_isNull550 = agg_isNull551;
/* 1655 */         double agg_value586 = agg_value587;
/* 1656 */         if (agg_isNull550) {
/* 1657 */           if (!agg_isNull331) {
/* 1658 */             agg_isNull550 = false;
/* 1659 */             agg_value586 = agg_value367;
/* 1660 */           }
/* 1661 */         }
/* 1662 */
/* 1663 */         boolean agg_isNull552 = inputadapter_isNull25;
/* 1664 */         double agg_value588 = -1.0;
/* 1665 */         if (!inputadapter_isNull25) {
/* 1666 */           agg_value588 = inputadapter_value25;
/* 1667 */         }
/* 1668 */         if (!agg_isNull552) {
/* 1669 */           agg_isNull549 = false; // resultCode could change nullability.
/* 1670 */           agg_value585 = agg_value586 + agg_value588;
/* 1671 */
/* 1672 */         }
/* 1673 */         boolean agg_isNull548 = agg_isNull549;
/* 1674 */         double agg_value584 = agg_value585;
/* 1675 */         if (agg_isNull548) {
/* 1676 */           boolean agg_isNull554 = agg_fastAggBuffer.isNullAt(29);
/* 1677 */           double agg_value590 = agg_isNull554 ? -1.0 : (agg_fastAggBuffer.getDouble(29));
/* 1678 */           if (!agg_isNull554) {
/* 1679 */             agg_isNull548 = false;
/* 1680 */             agg_value584 = agg_value590;
/* 1681 */           }
/* 1682 */         }
/* 1683 */         boolean agg_isNull556 = true;
/* 1684 */         double agg_value592 = -1.0;
/* 1685 */
/* 1686 */         boolean agg_isNull558 = agg_fastAggBuffer.isNullAt(30);
/* 1687 */         double agg_value594 = agg_isNull558 ? -1.0 : (agg_fastAggBuffer.getDouble(30));
/* 1688 */         boolean agg_isNull557 = agg_isNull558;
/* 1689 */         double agg_value593 = agg_value594;
/* 1690 */         if (agg_isNull557) {
/* 1691 */           if (!agg_isNull331) {
/* 1692 */             agg_isNull557 = false;
/* 1693 */             agg_value593 = agg_value367;
/* 1694 */           }
/* 1695 */         }
/* 1696 */
/* 1697 */         boolean agg_isNull559 = inputadapter_isNull26;
/* 1698 */         double agg_value595 = -1.0;
/* 1699 */         if (!inputadapter_isNull26) {
/* 1700 */           agg_value595 = inputadapter_value26;
/* 1701 */         }
/* 1702 */         if (!agg_isNull559) {
/* 1703 */           agg_isNull556 = false; // resultCode could change nullability.
/* 1704 */           agg_value592 = agg_value593 + agg_value595;
/* 1705 */
/* 1706 */         }
/* 1707 */         boolean agg_isNull555 = agg_isNull556;
/* 1708 */         double agg_value591 = agg_value592;
/* 1709 */         if (agg_isNull555) {
/* 1710 */           boolean agg_isNull561 = agg_fastAggBuffer.isNullAt(30);
/* 1711 */           double agg_value597 = agg_isNull561 ? -1.0 : (agg_fastAggBuffer.getDouble(30));
/* 1712 */           if (!agg_isNull561) {
/* 1713 */             agg_isNull555 = false;
/* 1714 */             agg_value591 = agg_value597;
/* 1715 */           }
/* 1716 */         }
/* 1717 */         boolean agg_isNull563 = true;
/* 1718 */         double agg_value599 = -1.0;
/* 1719 */
/* 1720 */         boolean agg_isNull565 = agg_fastAggBuffer.isNullAt(31);
/* 1721 */         double agg_value601 = agg_isNull565 ? -1.0 : (agg_fastAggBuffer.getDouble(31));
/* 1722 */         boolean agg_isNull564 = agg_isNull565;
/* 1723 */         double agg_value600 = agg_value601;
/* 1724 */         if (agg_isNull564) {
/* 1725 */           if (!agg_isNull331) {
/* 1726 */             agg_isNull564 = false;
/* 1727 */             agg_value600 = agg_value367;
/* 1728 */           }
/* 1729 */         }
/* 1730 */
/* 1731 */         boolean agg_isNull566 = inputadapter_isNull27;
/* 1732 */         double agg_value602 = -1.0;
/* 1733 */         if (!inputadapter_isNull27) {
/* 1734 */           agg_value602 = inputadapter_value27;
/* 1735 */         }
/* 1736 */         if (!agg_isNull566) {
/* 1737 */           agg_isNull563 = false; // resultCode could change nullability.
/* 1738 */           agg_value599 = agg_value600 + agg_value602;
/* 1739 */
/* 1740 */         }
/* 1741 */         boolean agg_isNull562 = agg_isNull563;
/* 1742 */         double agg_value598 = agg_value599;
/* 1743 */         if (agg_isNull562) {
/* 1744 */           boolean agg_isNull568 = agg_fastAggBuffer.isNullAt(31);
/* 1745 */           double agg_value604 = agg_isNull568 ? -1.0 : (agg_fastAggBuffer.getDouble(31));
/* 1746 */           if (!agg_isNull568) {
/* 1747 */             agg_isNull562 = false;
/* 1748 */             agg_value598 = agg_value604;
/* 1749 */           }
/* 1750 */         }
/* 1751 */         boolean agg_isNull570 = true;
/* 1752 */         double agg_value606 = -1.0;
/* 1753 */
/* 1754 */         boolean agg_isNull572 = agg_fastAggBuffer.isNullAt(32);
/* 1755 */         double agg_value608 = agg_isNull572 ? -1.0 : (agg_fastAggBuffer.getDouble(32));
/* 1756 */         boolean agg_isNull571 = agg_isNull572;
/* 1757 */         double agg_value607 = agg_value608;
/* 1758 */         if (agg_isNull571) {
/* 1759 */           if (!agg_isNull331) {
/* 1760 */             agg_isNull571 = false;
/* 1761 */             agg_value607 = agg_value367;
/* 1762 */           }
/* 1763 */         }
/* 1764 */
/* 1765 */         boolean agg_isNull573 = inputadapter_isNull28;
/* 1766 */         double agg_value609 = -1.0;
/* 1767 */         if (!inputadapter_isNull28) {
/* 1768 */           agg_value609 = inputadapter_value28;
/* 1769 */         }
/* 1770 */         if (!agg_isNull573) {
/* 1771 */           agg_isNull570 = false; // resultCode could change nullability.
/* 1772 */           agg_value606 = agg_value607 + agg_value609;
/* 1773 */
/* 1774 */         }
/* 1775 */         boolean agg_isNull569 = agg_isNull570;
/* 1776 */         double agg_value605 = agg_value606;
/* 1777 */         if (agg_isNull569) {
/* 1778 */           boolean agg_isNull575 = agg_fastAggBuffer.isNullAt(32);
/* 1779 */           double agg_value611 = agg_isNull575 ? -1.0 : (agg_fastAggBuffer.getDouble(32));
/* 1780 */           if (!agg_isNull575) {
/* 1781 */             agg_isNull569 = false;
/* 1782 */             agg_value605 = agg_value611;
/* 1783 */           }
/* 1784 */         }
/* 1785 */         boolean agg_isNull577 = true;
/* 1786 */         double agg_value613 = -1.0;
/* 1787 */
/* 1788 */         boolean agg_isNull579 = agg_fastAggBuffer.isNullAt(33);
/* 1789 */         double agg_value615 = agg_isNull579 ? -1.0 : (agg_fastAggBuffer.getDouble(33));
/* 1790 */         boolean agg_isNull578 = agg_isNull579;
/* 1791 */         double agg_value614 = agg_value615;
/* 1792 */         if (agg_isNull578) {
/* 1793 */           if (!agg_isNull331) {
/* 1794 */             agg_isNull578 = false;
/* 1795 */             agg_value614 = agg_value367;
/* 1796 */           }
/* 1797 */         }
/* 1798 */
/* 1799 */         boolean agg_isNull580 = inputadapter_isNull29;
/* 1800 */         double agg_value616 = -1.0;
/* 1801 */         if (!inputadapter_isNull29) {
/* 1802 */           agg_value616 = inputadapter_value29;
/* 1803 */         }
/* 1804 */         if (!agg_isNull580) {
/* 1805 */           agg_isNull577 = false; // resultCode could change nullability.
/* 1806 */           agg_value613 = agg_value614 + agg_value616;
/* 1807 */
/* 1808 */         }
/* 1809 */         boolean agg_isNull576 = agg_isNull577;
/* 1810 */         double agg_value612 = agg_value613;
/* 1811 */         if (agg_isNull576) {
/* 1812 */           boolean agg_isNull582 = agg_fastAggBuffer.isNullAt(33);
/* 1813 */           double agg_value618 = agg_isNull582 ? -1.0 : (agg_fastAggBuffer.getDouble(33));
/* 1814 */           if (!agg_isNull582) {
/* 1815 */             agg_isNull576 = false;
/* 1816 */             agg_value612 = agg_value618;
/* 1817 */           }
/* 1818 */         }
/* 1819 */         boolean agg_isNull584 = true;
/* 1820 */         double agg_value620 = -1.0;
/* 1821 */
/* 1822 */         boolean agg_isNull586 = agg_fastAggBuffer.isNullAt(34);
/* 1823 */         double agg_value622 = agg_isNull586 ? -1.0 : (agg_fastAggBuffer.getDouble(34));
/* 1824 */         boolean agg_isNull585 = agg_isNull586;
/* 1825 */         double agg_value621 = agg_value622;
/* 1826 */         if (agg_isNull585) {
/* 1827 */           if (!agg_isNull331) {
/* 1828 */             agg_isNull585 = false;
/* 1829 */             agg_value621 = agg_value367;
/* 1830 */           }
/* 1831 */         }
/* 1832 */
/* 1833 */         boolean agg_isNull587 = inputadapter_isNull30;
/* 1834 */         double agg_value623 = -1.0;
/* 1835 */         if (!inputadapter_isNull30) {
/* 1836 */           agg_value623 = inputadapter_value30;
/* 1837 */         }
/* 1838 */         if (!agg_isNull587) {
/* 1839 */           agg_isNull584 = false; // resultCode could change nullability.
/* 1840 */           agg_value620 = agg_value621 + agg_value623;
/* 1841 */
/* 1842 */         }
/* 1843 */         boolean agg_isNull583 = agg_isNull584;
/* 1844 */         double agg_value619 = agg_value620;
/* 1845 */         if (agg_isNull583) {
/* 1846 */           boolean agg_isNull589 = agg_fastAggBuffer.isNullAt(34);
/* 1847 */           double agg_value625 = agg_isNull589 ? -1.0 : (agg_fastAggBuffer.getDouble(34));
/* 1848 */           if (!agg_isNull589) {
/* 1849 */             agg_isNull583 = false;
/* 1850 */             agg_value619 = agg_value625;
/* 1851 */           }
/* 1852 */         }
/* 1853 */         boolean agg_isNull591 = true;
/* 1854 */         double agg_value627 = -1.0;
/* 1855 */
/* 1856 */         boolean agg_isNull593 = agg_fastAggBuffer.isNullAt(35);
/* 1857 */         double agg_value629 = agg_isNull593 ? -1.0 : (agg_fastAggBuffer.getDouble(35));
/* 1858 */         boolean agg_isNull592 = agg_isNull593;
/* 1859 */         double agg_value628 = agg_value629;
/* 1860 */         if (agg_isNull592) {
/* 1861 */           if (!agg_isNull331) {
/* 1862 */             agg_isNull592 = false;
/* 1863 */             agg_value628 = agg_value367;
/* 1864 */           }
/* 1865 */         }
/* 1866 */
/* 1867 */         boolean agg_isNull594 = inputadapter_isNull31;
/* 1868 */         double agg_value630 = -1.0;
/* 1869 */         if (!inputadapter_isNull31) {
/* 1870 */           agg_value630 = inputadapter_value31;
/* 1871 */         }
/* 1872 */         if (!agg_isNull594) {
/* 1873 */           agg_isNull591 = false; // resultCode could change nullability.
/* 1874 */           agg_value627 = agg_value628 + agg_value630;
/* 1875 */
/* 1876 */         }
/* 1877 */         boolean agg_isNull590 = agg_isNull591;
/* 1878 */         double agg_value626 = agg_value627;
/* 1879 */         if (agg_isNull590) {
/* 1880 */           boolean agg_isNull596 = agg_fastAggBuffer.isNullAt(35);
/* 1881 */           double agg_value632 = agg_isNull596 ? -1.0 : (agg_fastAggBuffer.getDouble(35));
/* 1882 */           if (!agg_isNull596) {
/* 1883 */             agg_isNull590 = false;
/* 1884 */             agg_value626 = agg_value632;
/* 1885 */           }
/* 1886 */         }
/* 1887 */         // update fast row
/* 1888 */         if (!agg_isNull333) {
/* 1889 */           agg_fastAggBuffer.setDouble(0, agg_value369);
/* 1890 */         } else {
/* 1891 */           agg_fastAggBuffer.setNullAt(0);
/* 1892 */         }
/* 1893 */
/* 1894 */         if (!agg_isNull340) {
/* 1895 */           agg_fastAggBuffer.setDouble(1, agg_value376);
/* 1896 */         } else {
/* 1897 */           agg_fastAggBuffer.setNullAt(1);
/* 1898 */         }
/* 1899 */
/* 1900 */         if (!agg_isNull347) {
/* 1901 */           agg_fastAggBuffer.setDouble(2, agg_value383);
/* 1902 */         } else {
/* 1903 */           agg_fastAggBuffer.setNullAt(2);
/* 1904 */         }
/* 1905 */
/* 1906 */         if (!agg_isNull354) {
/* 1907 */           agg_fastAggBuffer.setDouble(3, agg_value390);
/* 1908 */         } else {
/* 1909 */           agg_fastAggBuffer.setNullAt(3);
/* 1910 */         }
/* 1911 */
/* 1912 */         if (!agg_isNull361) {
/* 1913 */           agg_fastAggBuffer.setDouble(4, agg_value397);
/* 1914 */         } else {
/* 1915 */           agg_fastAggBuffer.setNullAt(4);
/* 1916 */         }
/* 1917 */
/* 1918 */         if (!agg_isNull368) {
/* 1919 */           agg_fastAggBuffer.setDouble(5, agg_value404);
/* 1920 */         } else {
/* 1921 */           agg_fastAggBuffer.setNullAt(5);
/* 1922 */         }
/* 1923 */
/* 1924 */         if (!agg_isNull375) {
/* 1925 */           agg_fastAggBuffer.setDouble(6, agg_value411);
/* 1926 */         } else {
/* 1927 */           agg_fastAggBuffer.setNullAt(6);
/* 1928 */         }
/* 1929 */
/* 1930 */         if (!agg_isNull382) {
/* 1931 */           agg_fastAggBuffer.setDouble(7, agg_value418);
/* 1932 */         } else {
/* 1933 */           agg_fastAggBuffer.setNullAt(7);
/* 1934 */         }
/* 1935 */
/* 1936 */         if (!agg_isNull389) {
/* 1937 */           agg_fastAggBuffer.setDouble(8, agg_value425);
/* 1938 */         } else {
/* 1939 */           agg_fastAggBuffer.setNullAt(8);
/* 1940 */         }
/* 1941 */
/* 1942 */         if (!agg_isNull396) {
/* 1943 */           agg_fastAggBuffer.setDouble(9, agg_value432);
/* 1944 */         } else {
/* 1945 */           agg_fastAggBuffer.setNullAt(9);
/* 1946 */         }
/* 1947 */
/* 1948 */         if (!agg_isNull403) {
/* 1949 */           agg_fastAggBuffer.setDouble(10, agg_value439);
/* 1950 */         } else {
/* 1951 */           agg_fastAggBuffer.setNullAt(10);
/* 1952 */         }
/* 1953 */
/* 1954 */         if (!agg_isNull410) {
/* 1955 */           agg_fastAggBuffer.setDouble(11, agg_value446);
/* 1956 */         } else {
/* 1957 */           agg_fastAggBuffer.setNullAt(11);
/* 1958 */         }
/* 1959 */
/* 1960 */         if (!agg_isNull417) {
/* 1961 */           agg_fastAggBuffer.setDouble(12, agg_value453);
/* 1962 */         } else {
/* 1963 */           agg_fastAggBuffer.setNullAt(12);
/* 1964 */         }
/* 1965 */
/* 1966 */         if (!agg_isNull425) {
/* 1967 */           agg_fastAggBuffer.setDouble(13, agg_value461);
/* 1968 */         } else {
/* 1969 */           agg_fastAggBuffer.setNullAt(13);
/* 1970 */         }
/* 1971 */
/* 1972 */         if (!agg_isNull433) {
/* 1973 */           agg_fastAggBuffer.setDouble(14, agg_value469);
/* 1974 */         } else {
/* 1975 */           agg_fastAggBuffer.setNullAt(14);
/* 1976 */         }
/* 1977 */
/* 1978 */         if (!agg_isNull441) {
/* 1979 */           agg_fastAggBuffer.setDouble(15, agg_value477);
/* 1980 */         } else {
/* 1981 */           agg_fastAggBuffer.setNullAt(15);
/* 1982 */         }
/* 1983 */
/* 1984 */         if (!agg_isNull449) {
/* 1985 */           agg_fastAggBuffer.setDouble(16, agg_value485);
/* 1986 */         } else {
/* 1987 */           agg_fastAggBuffer.setNullAt(16);
/* 1988 */         }
/* 1989 */
/* 1990 */         if (!agg_isNull457) {
/* 1991 */           agg_fastAggBuffer.setDouble(17, agg_value493);
/* 1992 */         } else {
/* 1993 */           agg_fastAggBuffer.setNullAt(17);
/* 1994 */         }
/* 1995 */
/* 1996 */         if (!agg_isNull465) {
/* 1997 */           agg_fastAggBuffer.setDouble(18, agg_value501);
/* 1998 */         } else {
/* 1999 */           agg_fastAggBuffer.setNullAt(18);
/* 2000 */         }
/* 2001 */
/* 2002 */         if (!agg_isNull473) {
/* 2003 */           agg_fastAggBuffer.setDouble(19, agg_value509);
/* 2004 */         } else {
/* 2005 */           agg_fastAggBuffer.setNullAt(19);
/* 2006 */         }
/* 2007 */
/* 2008 */         if (!agg_isNull481) {
/* 2009 */           agg_fastAggBuffer.setDouble(20, agg_value517);
/* 2010 */         } else {
/* 2011 */           agg_fastAggBuffer.setNullAt(20);
/* 2012 */         }
/* 2013 */
/* 2014 */         if (!agg_isNull489) {
/* 2015 */           agg_fastAggBuffer.setDouble(21, agg_value525);
/* 2016 */         } else {
/* 2017 */           agg_fastAggBuffer.setNullAt(21);
/* 2018 */         }
/* 2019 */
/* 2020 */         if (!agg_isNull497) {
/* 2021 */           agg_fastAggBuffer.setDouble(22, agg_value533);
/* 2022 */         } else {
/* 2023 */           agg_fastAggBuffer.setNullAt(22);
/* 2024 */         }
/* 2025 */
/* 2026 */         if (!agg_isNull505) {
/* 2027 */           agg_fastAggBuffer.setDouble(23, agg_value541);
/* 2028 */         } else {
/* 2029 */           agg_fastAggBuffer.setNullAt(23);
/* 2030 */         }
/* 2031 */
/* 2032 */         if (!agg_isNull513) {
/* 2033 */           agg_fastAggBuffer.setDouble(24, agg_value549);
/* 2034 */         } else {
/* 2035 */           agg_fastAggBuffer.setNullAt(24);
/* 2036 */         }
/* 2037 */
/* 2038 */         if (!agg_isNull520) {
/* 2039 */           agg_fastAggBuffer.setDouble(25, agg_value556);
/* 2040 */         } else {
/* 2041 */           agg_fastAggBuffer.setNullAt(25);
/* 2042 */         }
/* 2043 */
/* 2044 */         if (!agg_isNull527) {
/* 2045 */           agg_fastAggBuffer.setDouble(26, agg_value563);
/* 2046 */         } else {
/* 2047 */           agg_fastAggBuffer.setNullAt(26);
/* 2048 */         }
/* 2049 */
/* 2050 */         if (!agg_isNull534) {
/* 2051 */           agg_fastAggBuffer.setDouble(27, agg_value570);
/* 2052 */         } else {
/* 2053 */           agg_fastAggBuffer.setNullAt(27);
/* 2054 */         }
/* 2055 */
/* 2056 */         if (!agg_isNull541) {
/* 2057 */           agg_fastAggBuffer.setDouble(28, agg_value577);
/* 2058 */         } else {
/* 2059 */           agg_fastAggBuffer.setNullAt(28);
/* 2060 */         }
/* 2061 */
/* 2062 */         if (!agg_isNull548) {
/* 2063 */           agg_fastAggBuffer.setDouble(29, agg_value584);
/* 2064 */         } else {
/* 2065 */           agg_fastAggBuffer.setNullAt(29);
/* 2066 */         }
/* 2067 */
/* 2068 */         if (!agg_isNull555) {
/* 2069 */           agg_fastAggBuffer.setDouble(30, agg_value591);
/* 2070 */         } else {
/* 2071 */           agg_fastAggBuffer.setNullAt(30);
/* 2072 */         }
/* 2073 */
/* 2074 */         if (!agg_isNull562) {
/* 2075 */           agg_fastAggBuffer.setDouble(31, agg_value598);
/* 2076 */         } else {
/* 2077 */           agg_fastAggBuffer.setNullAt(31);
/* 2078 */         }
/* 2079 */
/* 2080 */         if (!agg_isNull569) {
/* 2081 */           agg_fastAggBuffer.setDouble(32, agg_value605);
/* 2082 */         } else {
/* 2083 */           agg_fastAggBuffer.setNullAt(32);
/* 2084 */         }
/* 2085 */
/* 2086 */         if (!agg_isNull576) {
/* 2087 */           agg_fastAggBuffer.setDouble(33, agg_value612);
/* 2088 */         } else {
/* 2089 */           agg_fastAggBuffer.setNullAt(33);
/* 2090 */         }
/* 2091 */
/* 2092 */         if (!agg_isNull583) {
/* 2093 */           agg_fastAggBuffer.setDouble(34, agg_value619);
/* 2094 */         } else {
/* 2095 */           agg_fastAggBuffer.setNullAt(34);
/* 2096 */         }
/* 2097 */
/* 2098 */         if (!agg_isNull590) {
/* 2099 */           agg_fastAggBuffer.setDouble(35, agg_value626);
/* 2100 */         } else {
/* 2101 */           agg_fastAggBuffer.setNullAt(35);
/* 2102 */         }
/* 2103 */
/* 2104 */       } else {
/* 2105 */         // update unsafe row
/* 2106 */
/* 2107 */         // common sub-expressions
/* 2108 */         boolean agg_isNull61 = inputadapter_isNull1;
/* 2109 */         double agg_value97 = -1.0;
/* 2110 */         if (!inputadapter_isNull1) {
/* 2111 */           agg_value97 = (double) inputadapter_value1;
/* 2112 */         }
/* 2113 */         boolean agg_isNull63 = false;
/* 2114 */         double agg_value99 = -1.0;
/* 2115 */         if (!false) {
/* 2116 */           agg_value99 = (double) 0;
/* 2117 */         }
/* 2118 */         // evaluate aggregate function
/* 2119 */         boolean agg_isNull66 = true;
/* 2120 */         double agg_value102 = -1.0;
/* 2121 */
/* 2122 */         boolean agg_isNull68 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 2123 */         double agg_value104 = agg_isNull68 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 2124 */         boolean agg_isNull67 = agg_isNull68;
/* 2125 */         double agg_value103 = agg_value104;
/* 2126 */         if (agg_isNull67) {
/* 2127 */           if (!agg_isNull63) {
/* 2128 */             agg_isNull67 = false;
/* 2129 */             agg_value103 = agg_value99;
/* 2130 */           }
/* 2131 */         }
/* 2132 */
/* 2133 */         boolean agg_isNull69 = inputadapter_isNull8;
/* 2134 */         double agg_value105 = -1.0;
/* 2135 */         if (!inputadapter_isNull8) {
/* 2136 */           agg_value105 = inputadapter_value8;
/* 2137 */         }
/* 2138 */         if (!agg_isNull69) {
/* 2139 */           agg_isNull66 = false; // resultCode could change nullability.
/* 2140 */           agg_value102 = agg_value103 + agg_value105;
/* 2141 */
/* 2142 */         }
/* 2143 */         boolean agg_isNull65 = agg_isNull66;
/* 2144 */         double agg_value101 = agg_value102;
/* 2145 */         if (agg_isNull65) {
/* 2146 */           boolean agg_isNull71 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 2147 */           double agg_value107 = agg_isNull71 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 2148 */           if (!agg_isNull71) {
/* 2149 */             agg_isNull65 = false;
/* 2150 */             agg_value101 = agg_value107;
/* 2151 */           }
/* 2152 */         }
/* 2153 */         boolean agg_isNull73 = true;
/* 2154 */         double agg_value109 = -1.0;
/* 2155 */
/* 2156 */         boolean agg_isNull75 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 2157 */         double agg_value111 = agg_isNull75 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 2158 */         boolean agg_isNull74 = agg_isNull75;
/* 2159 */         double agg_value110 = agg_value111;
/* 2160 */         if (agg_isNull74) {
/* 2161 */           if (!agg_isNull63) {
/* 2162 */             agg_isNull74 = false;
/* 2163 */             agg_value110 = agg_value99;
/* 2164 */           }
/* 2165 */         }
/* 2166 */
/* 2167 */         boolean agg_isNull76 = inputadapter_isNull9;
/* 2168 */         double agg_value112 = -1.0;
/* 2169 */         if (!inputadapter_isNull9) {
/* 2170 */           agg_value112 = inputadapter_value9;
/* 2171 */         }
/* 2172 */         if (!agg_isNull76) {
/* 2173 */           agg_isNull73 = false; // resultCode could change nullability.
/* 2174 */           agg_value109 = agg_value110 + agg_value112;
/* 2175 */
/* 2176 */         }
/* 2177 */         boolean agg_isNull72 = agg_isNull73;
/* 2178 */         double agg_value108 = agg_value109;
/* 2179 */         if (agg_isNull72) {
/* 2180 */           boolean agg_isNull78 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 2181 */           double agg_value114 = agg_isNull78 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 2182 */           if (!agg_isNull78) {
/* 2183 */             agg_isNull72 = false;
/* 2184 */             agg_value108 = agg_value114;
/* 2185 */           }
/* 2186 */         }
/* 2187 */         boolean agg_isNull80 = true;
/* 2188 */         double agg_value116 = -1.0;
/* 2189 */
/* 2190 */         boolean agg_isNull82 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 2191 */         double agg_value118 = agg_isNull82 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 2192 */         boolean agg_isNull81 = agg_isNull82;
/* 2193 */         double agg_value117 = agg_value118;
/* 2194 */         if (agg_isNull81) {
/* 2195 */           if (!agg_isNull63) {
/* 2196 */             agg_isNull81 = false;
/* 2197 */             agg_value117 = agg_value99;
/* 2198 */           }
/* 2199 */         }
/* 2200 */
/* 2201 */         boolean agg_isNull83 = inputadapter_isNull10;
/* 2202 */         double agg_value119 = -1.0;
/* 2203 */         if (!inputadapter_isNull10) {
/* 2204 */           agg_value119 = inputadapter_value10;
/* 2205 */         }
/* 2206 */         if (!agg_isNull83) {
/* 2207 */           agg_isNull80 = false; // resultCode could change nullability.
/* 2208 */           agg_value116 = agg_value117 + agg_value119;
/* 2209 */
/* 2210 */         }
/* 2211 */         boolean agg_isNull79 = agg_isNull80;
/* 2212 */         double agg_value115 = agg_value116;
/* 2213 */         if (agg_isNull79) {
/* 2214 */           boolean agg_isNull85 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 2215 */           double agg_value121 = agg_isNull85 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 2216 */           if (!agg_isNull85) {
/* 2217 */             agg_isNull79 = false;
/* 2218 */             agg_value115 = agg_value121;
/* 2219 */           }
/* 2220 */         }
/* 2221 */         boolean agg_isNull87 = true;
/* 2222 */         double agg_value123 = -1.0;
/* 2223 */
/* 2224 */         boolean agg_isNull89 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 2225 */         double agg_value125 = agg_isNull89 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 2226 */         boolean agg_isNull88 = agg_isNull89;
/* 2227 */         double agg_value124 = agg_value125;
/* 2228 */         if (agg_isNull88) {
/* 2229 */           if (!agg_isNull63) {
/* 2230 */             agg_isNull88 = false;
/* 2231 */             agg_value124 = agg_value99;
/* 2232 */           }
/* 2233 */         }
/* 2234 */
/* 2235 */         boolean agg_isNull90 = inputadapter_isNull11;
/* 2236 */         double agg_value126 = -1.0;
/* 2237 */         if (!inputadapter_isNull11) {
/* 2238 */           agg_value126 = inputadapter_value11;
/* 2239 */         }
/* 2240 */         if (!agg_isNull90) {
/* 2241 */           agg_isNull87 = false; // resultCode could change nullability.
/* 2242 */           agg_value123 = agg_value124 + agg_value126;
/* 2243 */
/* 2244 */         }
/* 2245 */         boolean agg_isNull86 = agg_isNull87;
/* 2246 */         double agg_value122 = agg_value123;
/* 2247 */         if (agg_isNull86) {
/* 2248 */           boolean agg_isNull92 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 2249 */           double agg_value128 = agg_isNull92 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 2250 */           if (!agg_isNull92) {
/* 2251 */             agg_isNull86 = false;
/* 2252 */             agg_value122 = agg_value128;
/* 2253 */           }
/* 2254 */         }
/* 2255 */         boolean agg_isNull94 = true;
/* 2256 */         double agg_value130 = -1.0;
/* 2257 */
/* 2258 */         boolean agg_isNull96 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 2259 */         double agg_value132 = agg_isNull96 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 2260 */         boolean agg_isNull95 = agg_isNull96;
/* 2261 */         double agg_value131 = agg_value132;
/* 2262 */         if (agg_isNull95) {
/* 2263 */           if (!agg_isNull63) {
/* 2264 */             agg_isNull95 = false;
/* 2265 */             agg_value131 = agg_value99;
/* 2266 */           }
/* 2267 */         }
/* 2268 */
/* 2269 */         boolean agg_isNull97 = inputadapter_isNull12;
/* 2270 */         double agg_value133 = -1.0;
/* 2271 */         if (!inputadapter_isNull12) {
/* 2272 */           agg_value133 = inputadapter_value12;
/* 2273 */         }
/* 2274 */         if (!agg_isNull97) {
/* 2275 */           agg_isNull94 = false; // resultCode could change nullability.
/* 2276 */           agg_value130 = agg_value131 + agg_value133;
/* 2277 */
/* 2278 */         }
/* 2279 */         boolean agg_isNull93 = agg_isNull94;
/* 2280 */         double agg_value129 = agg_value130;
/* 2281 */         if (agg_isNull93) {
/* 2282 */           boolean agg_isNull99 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 2283 */           double agg_value135 = agg_isNull99 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 2284 */           if (!agg_isNull99) {
/* 2285 */             agg_isNull93 = false;
/* 2286 */             agg_value129 = agg_value135;
/* 2287 */           }
/* 2288 */         }
/* 2289 */         boolean agg_isNull101 = true;
/* 2290 */         double agg_value137 = -1.0;
/* 2291 */
/* 2292 */         boolean agg_isNull103 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 2293 */         double agg_value139 = agg_isNull103 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 2294 */         boolean agg_isNull102 = agg_isNull103;
/* 2295 */         double agg_value138 = agg_value139;
/* 2296 */         if (agg_isNull102) {
/* 2297 */           if (!agg_isNull63) {
/* 2298 */             agg_isNull102 = false;
/* 2299 */             agg_value138 = agg_value99;
/* 2300 */           }
/* 2301 */         }
/* 2302 */
/* 2303 */         boolean agg_isNull104 = inputadapter_isNull13;
/* 2304 */         double agg_value140 = -1.0;
/* 2305 */         if (!inputadapter_isNull13) {
/* 2306 */           agg_value140 = inputadapter_value13;
/* 2307 */         }
/* 2308 */         if (!agg_isNull104) {
/* 2309 */           agg_isNull101 = false; // resultCode could change nullability.
/* 2310 */           agg_value137 = agg_value138 + agg_value140;
/* 2311 */
/* 2312 */         }
/* 2313 */         boolean agg_isNull100 = agg_isNull101;
/* 2314 */         double agg_value136 = agg_value137;
/* 2315 */         if (agg_isNull100) {
/* 2316 */           boolean agg_isNull106 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 2317 */           double agg_value142 = agg_isNull106 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 2318 */           if (!agg_isNull106) {
/* 2319 */             agg_isNull100 = false;
/* 2320 */             agg_value136 = agg_value142;
/* 2321 */           }
/* 2322 */         }
/* 2323 */         boolean agg_isNull108 = true;
/* 2324 */         double agg_value144 = -1.0;
/* 2325 */
/* 2326 */         boolean agg_isNull110 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 2327 */         double agg_value146 = agg_isNull110 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 2328 */         boolean agg_isNull109 = agg_isNull110;
/* 2329 */         double agg_value145 = agg_value146;
/* 2330 */         if (agg_isNull109) {
/* 2331 */           if (!agg_isNull63) {
/* 2332 */             agg_isNull109 = false;
/* 2333 */             agg_value145 = agg_value99;
/* 2334 */           }
/* 2335 */         }
/* 2336 */
/* 2337 */         boolean agg_isNull111 = inputadapter_isNull14;
/* 2338 */         double agg_value147 = -1.0;
/* 2339 */         if (!inputadapter_isNull14) {
/* 2340 */           agg_value147 = inputadapter_value14;
/* 2341 */         }
/* 2342 */         if (!agg_isNull111) {
/* 2343 */           agg_isNull108 = false; // resultCode could change nullability.
/* 2344 */           agg_value144 = agg_value145 + agg_value147;
/* 2345 */
/* 2346 */         }
/* 2347 */         boolean agg_isNull107 = agg_isNull108;
/* 2348 */         double agg_value143 = agg_value144;
/* 2349 */         if (agg_isNull107) {
/* 2350 */           boolean agg_isNull113 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 2351 */           double agg_value149 = agg_isNull113 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 2352 */           if (!agg_isNull113) {
/* 2353 */             agg_isNull107 = false;
/* 2354 */             agg_value143 = agg_value149;
/* 2355 */           }
/* 2356 */         }
/* 2357 */         boolean agg_isNull115 = true;
/* 2358 */         double agg_value151 = -1.0;
/* 2359 */
/* 2360 */         boolean agg_isNull117 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 2361 */         double agg_value153 = agg_isNull117 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(7));
/* 2362 */         boolean agg_isNull116 = agg_isNull117;
/* 2363 */         double agg_value152 = agg_value153;
/* 2364 */         if (agg_isNull116) {
/* 2365 */           if (!agg_isNull63) {
/* 2366 */             agg_isNull116 = false;
/* 2367 */             agg_value152 = agg_value99;
/* 2368 */           }
/* 2369 */         }
/* 2370 */
/* 2371 */         boolean agg_isNull118 = inputadapter_isNull15;
/* 2372 */         double agg_value154 = -1.0;
/* 2373 */         if (!inputadapter_isNull15) {
/* 2374 */           agg_value154 = inputadapter_value15;
/* 2375 */         }
/* 2376 */         if (!agg_isNull118) {
/* 2377 */           agg_isNull115 = false; // resultCode could change nullability.
/* 2378 */           agg_value151 = agg_value152 + agg_value154;
/* 2379 */
/* 2380 */         }
/* 2381 */         boolean agg_isNull114 = agg_isNull115;
/* 2382 */         double agg_value150 = agg_value151;
/* 2383 */         if (agg_isNull114) {
/* 2384 */           boolean agg_isNull120 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 2385 */           double agg_value156 = agg_isNull120 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(7));
/* 2386 */           if (!agg_isNull120) {
/* 2387 */             agg_isNull114 = false;
/* 2388 */             agg_value150 = agg_value156;
/* 2389 */           }
/* 2390 */         }
/* 2391 */         boolean agg_isNull122 = true;
/* 2392 */         double agg_value158 = -1.0;
/* 2393 */
/* 2394 */         boolean agg_isNull124 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 2395 */         double agg_value160 = agg_isNull124 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(8));
/* 2396 */         boolean agg_isNull123 = agg_isNull124;
/* 2397 */         double agg_value159 = agg_value160;
/* 2398 */         if (agg_isNull123) {
/* 2399 */           if (!agg_isNull63) {
/* 2400 */             agg_isNull123 = false;
/* 2401 */             agg_value159 = agg_value99;
/* 2402 */           }
/* 2403 */         }
/* 2404 */
/* 2405 */         boolean agg_isNull125 = inputadapter_isNull16;
/* 2406 */         double agg_value161 = -1.0;
/* 2407 */         if (!inputadapter_isNull16) {
/* 2408 */           agg_value161 = inputadapter_value16;
/* 2409 */         }
/* 2410 */         if (!agg_isNull125) {
/* 2411 */           agg_isNull122 = false; // resultCode could change nullability.
/* 2412 */           agg_value158 = agg_value159 + agg_value161;
/* 2413 */
/* 2414 */         }
/* 2415 */         boolean agg_isNull121 = agg_isNull122;
/* 2416 */         double agg_value157 = agg_value158;
/* 2417 */         if (agg_isNull121) {
/* 2418 */           boolean agg_isNull127 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 2419 */           double agg_value163 = agg_isNull127 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(8));
/* 2420 */           if (!agg_isNull127) {
/* 2421 */             agg_isNull121 = false;
/* 2422 */             agg_value157 = agg_value163;
/* 2423 */           }
/* 2424 */         }
/* 2425 */         boolean agg_isNull129 = true;
/* 2426 */         double agg_value165 = -1.0;
/* 2427 */
/* 2428 */         boolean agg_isNull131 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 2429 */         double agg_value167 = agg_isNull131 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(9));
/* 2430 */         boolean agg_isNull130 = agg_isNull131;
/* 2431 */         double agg_value166 = agg_value167;
/* 2432 */         if (agg_isNull130) {
/* 2433 */           if (!agg_isNull63) {
/* 2434 */             agg_isNull130 = false;
/* 2435 */             agg_value166 = agg_value99;
/* 2436 */           }
/* 2437 */         }
/* 2438 */
/* 2439 */         boolean agg_isNull132 = inputadapter_isNull17;
/* 2440 */         double agg_value168 = -1.0;
/* 2441 */         if (!inputadapter_isNull17) {
/* 2442 */           agg_value168 = inputadapter_value17;
/* 2443 */         }
/* 2444 */         if (!agg_isNull132) {
/* 2445 */           agg_isNull129 = false; // resultCode could change nullability.
/* 2446 */           agg_value165 = agg_value166 + agg_value168;
/* 2447 */
/* 2448 */         }
/* 2449 */         boolean agg_isNull128 = agg_isNull129;
/* 2450 */         double agg_value164 = agg_value165;
/* 2451 */         if (agg_isNull128) {
/* 2452 */           boolean agg_isNull134 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 2453 */           double agg_value170 = agg_isNull134 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(9));
/* 2454 */           if (!agg_isNull134) {
/* 2455 */             agg_isNull128 = false;
/* 2456 */             agg_value164 = agg_value170;
/* 2457 */           }
/* 2458 */         }
/* 2459 */         boolean agg_isNull136 = true;
/* 2460 */         double agg_value172 = -1.0;
/* 2461 */
/* 2462 */         boolean agg_isNull138 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 2463 */         double agg_value174 = agg_isNull138 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(10));
/* 2464 */         boolean agg_isNull137 = agg_isNull138;
/* 2465 */         double agg_value173 = agg_value174;
/* 2466 */         if (agg_isNull137) {
/* 2467 */           if (!agg_isNull63) {
/* 2468 */             agg_isNull137 = false;
/* 2469 */             agg_value173 = agg_value99;
/* 2470 */           }
/* 2471 */         }
/* 2472 */
/* 2473 */         boolean agg_isNull139 = inputadapter_isNull18;
/* 2474 */         double agg_value175 = -1.0;
/* 2475 */         if (!inputadapter_isNull18) {
/* 2476 */           agg_value175 = inputadapter_value18;
/* 2477 */         }
/* 2478 */         if (!agg_isNull139) {
/* 2479 */           agg_isNull136 = false; // resultCode could change nullability.
/* 2480 */           agg_value172 = agg_value173 + agg_value175;
/* 2481 */
/* 2482 */         }
/* 2483 */         boolean agg_isNull135 = agg_isNull136;
/* 2484 */         double agg_value171 = agg_value172;
/* 2485 */         if (agg_isNull135) {
/* 2486 */           boolean agg_isNull141 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 2487 */           double agg_value177 = agg_isNull141 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(10));
/* 2488 */           if (!agg_isNull141) {
/* 2489 */             agg_isNull135 = false;
/* 2490 */             agg_value171 = agg_value177;
/* 2491 */           }
/* 2492 */         }
/* 2493 */         boolean agg_isNull143 = true;
/* 2494 */         double agg_value179 = -1.0;
/* 2495 */
/* 2496 */         boolean agg_isNull145 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 2497 */         double agg_value181 = agg_isNull145 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(11));
/* 2498 */         boolean agg_isNull144 = agg_isNull145;
/* 2499 */         double agg_value180 = agg_value181;
/* 2500 */         if (agg_isNull144) {
/* 2501 */           if (!agg_isNull63) {
/* 2502 */             agg_isNull144 = false;
/* 2503 */             agg_value180 = agg_value99;
/* 2504 */           }
/* 2505 */         }
/* 2506 */
/* 2507 */         boolean agg_isNull146 = inputadapter_isNull19;
/* 2508 */         double agg_value182 = -1.0;
/* 2509 */         if (!inputadapter_isNull19) {
/* 2510 */           agg_value182 = inputadapter_value19;
/* 2511 */         }
/* 2512 */         if (!agg_isNull146) {
/* 2513 */           agg_isNull143 = false; // resultCode could change nullability.
/* 2514 */           agg_value179 = agg_value180 + agg_value182;
/* 2515 */
/* 2516 */         }
/* 2517 */         boolean agg_isNull142 = agg_isNull143;
/* 2518 */         double agg_value178 = agg_value179;
/* 2519 */         if (agg_isNull142) {
/* 2520 */           boolean agg_isNull148 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 2521 */           double agg_value184 = agg_isNull148 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(11));
/* 2522 */           if (!agg_isNull148) {
/* 2523 */             agg_isNull142 = false;
/* 2524 */             agg_value178 = agg_value184;
/* 2525 */           }
/* 2526 */         }
/* 2527 */         boolean agg_isNull150 = true;
/* 2528 */         double agg_value186 = -1.0;
/* 2529 */
/* 2530 */         boolean agg_isNull152 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 2531 */         double agg_value188 = agg_isNull152 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(12));
/* 2532 */         boolean agg_isNull151 = agg_isNull152;
/* 2533 */         double agg_value187 = agg_value188;
/* 2534 */         if (agg_isNull151) {
/* 2535 */           if (!agg_isNull63) {
/* 2536 */             agg_isNull151 = false;
/* 2537 */             agg_value187 = agg_value99;
/* 2538 */           }
/* 2539 */         }
/* 2540 */
/* 2541 */         boolean agg_isNull154 = false;
/* 2542 */         double agg_value190 = -1.0;
/* 2543 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2544 */           agg_isNull154 = true;
/* 2545 */         } else {
/* 2546 */           if (inputadapter_isNull8) {
/* 2547 */             agg_isNull154 = true;
/* 2548 */           } else {
/* 2549 */             agg_value190 = (double)(inputadapter_value8 / agg_value97);
/* 2550 */           }
/* 2551 */         }
/* 2552 */         boolean agg_isNull153 = agg_isNull154;
/* 2553 */         double agg_value189 = -1.0;
/* 2554 */         if (!agg_isNull154) {
/* 2555 */           agg_value189 = agg_value190;
/* 2556 */         }
/* 2557 */         if (!agg_isNull153) {
/* 2558 */           agg_isNull150 = false; // resultCode could change nullability.
/* 2559 */           agg_value186 = agg_value187 + agg_value189;
/* 2560 */
/* 2561 */         }
/* 2562 */         boolean agg_isNull149 = agg_isNull150;
/* 2563 */         double agg_value185 = agg_value186;
/* 2564 */         if (agg_isNull149) {
/* 2565 */           boolean agg_isNull156 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 2566 */           double agg_value192 = agg_isNull156 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(12));
/* 2567 */           if (!agg_isNull156) {
/* 2568 */             agg_isNull149 = false;
/* 2569 */             agg_value185 = agg_value192;
/* 2570 */           }
/* 2571 */         }
/* 2572 */         boolean agg_isNull158 = true;
/* 2573 */         double agg_value194 = -1.0;
/* 2574 */
/* 2575 */         boolean agg_isNull160 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 2576 */         double agg_value196 = agg_isNull160 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(13));
/* 2577 */         boolean agg_isNull159 = agg_isNull160;
/* 2578 */         double agg_value195 = agg_value196;
/* 2579 */         if (agg_isNull159) {
/* 2580 */           if (!agg_isNull63) {
/* 2581 */             agg_isNull159 = false;
/* 2582 */             agg_value195 = agg_value99;
/* 2583 */           }
/* 2584 */         }
/* 2585 */
/* 2586 */         boolean agg_isNull162 = false;
/* 2587 */         double agg_value198 = -1.0;
/* 2588 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2589 */           agg_isNull162 = true;
/* 2590 */         } else {
/* 2591 */           if (inputadapter_isNull9) {
/* 2592 */             agg_isNull162 = true;
/* 2593 */           } else {
/* 2594 */             agg_value198 = (double)(inputadapter_value9 / agg_value97);
/* 2595 */           }
/* 2596 */         }
/* 2597 */         boolean agg_isNull161 = agg_isNull162;
/* 2598 */         double agg_value197 = -1.0;
/* 2599 */         if (!agg_isNull162) {
/* 2600 */           agg_value197 = agg_value198;
/* 2601 */         }
/* 2602 */         if (!agg_isNull161) {
/* 2603 */           agg_isNull158 = false; // resultCode could change nullability.
/* 2604 */           agg_value194 = agg_value195 + agg_value197;
/* 2605 */
/* 2606 */         }
/* 2607 */         boolean agg_isNull157 = agg_isNull158;
/* 2608 */         double agg_value193 = agg_value194;
/* 2609 */         if (agg_isNull157) {
/* 2610 */           boolean agg_isNull164 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 2611 */           double agg_value200 = agg_isNull164 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(13));
/* 2612 */           if (!agg_isNull164) {
/* 2613 */             agg_isNull157 = false;
/* 2614 */             agg_value193 = agg_value200;
/* 2615 */           }
/* 2616 */         }
/* 2617 */         boolean agg_isNull166 = true;
/* 2618 */         double agg_value202 = -1.0;
/* 2619 */
/* 2620 */         boolean agg_isNull168 = agg_unsafeRowAggBuffer.isNullAt(14);
/* 2621 */         double agg_value204 = agg_isNull168 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(14));
/* 2622 */         boolean agg_isNull167 = agg_isNull168;
/* 2623 */         double agg_value203 = agg_value204;
/* 2624 */         if (agg_isNull167) {
/* 2625 */           if (!agg_isNull63) {
/* 2626 */             agg_isNull167 = false;
/* 2627 */             agg_value203 = agg_value99;
/* 2628 */           }
/* 2629 */         }
/* 2630 */
/* 2631 */         boolean agg_isNull170 = false;
/* 2632 */         double agg_value206 = -1.0;
/* 2633 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2634 */           agg_isNull170 = true;
/* 2635 */         } else {
/* 2636 */           if (inputadapter_isNull10) {
/* 2637 */             agg_isNull170 = true;
/* 2638 */           } else {
/* 2639 */             agg_value206 = (double)(inputadapter_value10 / agg_value97);
/* 2640 */           }
/* 2641 */         }
/* 2642 */         boolean agg_isNull169 = agg_isNull170;
/* 2643 */         double agg_value205 = -1.0;
/* 2644 */         if (!agg_isNull170) {
/* 2645 */           agg_value205 = agg_value206;
/* 2646 */         }
/* 2647 */         if (!agg_isNull169) {
/* 2648 */           agg_isNull166 = false; // resultCode could change nullability.
/* 2649 */           agg_value202 = agg_value203 + agg_value205;
/* 2650 */
/* 2651 */         }
/* 2652 */         boolean agg_isNull165 = agg_isNull166;
/* 2653 */         double agg_value201 = agg_value202;
/* 2654 */         if (agg_isNull165) {
/* 2655 */           boolean agg_isNull172 = agg_unsafeRowAggBuffer.isNullAt(14);
/* 2656 */           double agg_value208 = agg_isNull172 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(14));
/* 2657 */           if (!agg_isNull172) {
/* 2658 */             agg_isNull165 = false;
/* 2659 */             agg_value201 = agg_value208;
/* 2660 */           }
/* 2661 */         }
/* 2662 */         boolean agg_isNull174 = true;
/* 2663 */         double agg_value210 = -1.0;
/* 2664 */
/* 2665 */         boolean agg_isNull176 = agg_unsafeRowAggBuffer.isNullAt(15);
/* 2666 */         double agg_value212 = agg_isNull176 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(15));
/* 2667 */         boolean agg_isNull175 = agg_isNull176;
/* 2668 */         double agg_value211 = agg_value212;
/* 2669 */         if (agg_isNull175) {
/* 2670 */           if (!agg_isNull63) {
/* 2671 */             agg_isNull175 = false;
/* 2672 */             agg_value211 = agg_value99;
/* 2673 */           }
/* 2674 */         }
/* 2675 */
/* 2676 */         boolean agg_isNull178 = false;
/* 2677 */         double agg_value214 = -1.0;
/* 2678 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2679 */           agg_isNull178 = true;
/* 2680 */         } else {
/* 2681 */           if (inputadapter_isNull11) {
/* 2682 */             agg_isNull178 = true;
/* 2683 */           } else {
/* 2684 */             agg_value214 = (double)(inputadapter_value11 / agg_value97);
/* 2685 */           }
/* 2686 */         }
/* 2687 */         boolean agg_isNull177 = agg_isNull178;
/* 2688 */         double agg_value213 = -1.0;
/* 2689 */         if (!agg_isNull178) {
/* 2690 */           agg_value213 = agg_value214;
/* 2691 */         }
/* 2692 */         if (!agg_isNull177) {
/* 2693 */           agg_isNull174 = false; // resultCode could change nullability.
/* 2694 */           agg_value210 = agg_value211 + agg_value213;
/* 2695 */
/* 2696 */         }
/* 2697 */         boolean agg_isNull173 = agg_isNull174;
/* 2698 */         double agg_value209 = agg_value210;
/* 2699 */         if (agg_isNull173) {
/* 2700 */           boolean agg_isNull180 = agg_unsafeRowAggBuffer.isNullAt(15);
/* 2701 */           double agg_value216 = agg_isNull180 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(15));
/* 2702 */           if (!agg_isNull180) {
/* 2703 */             agg_isNull173 = false;
/* 2704 */             agg_value209 = agg_value216;
/* 2705 */           }
/* 2706 */         }
/* 2707 */         boolean agg_isNull182 = true;
/* 2708 */         double agg_value218 = -1.0;
/* 2709 */
/* 2710 */         boolean agg_isNull184 = agg_unsafeRowAggBuffer.isNullAt(16);
/* 2711 */         double agg_value220 = agg_isNull184 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(16));
/* 2712 */         boolean agg_isNull183 = agg_isNull184;
/* 2713 */         double agg_value219 = agg_value220;
/* 2714 */         if (agg_isNull183) {
/* 2715 */           if (!agg_isNull63) {
/* 2716 */             agg_isNull183 = false;
/* 2717 */             agg_value219 = agg_value99;
/* 2718 */           }
/* 2719 */         }
/* 2720 */
/* 2721 */         boolean agg_isNull186 = false;
/* 2722 */         double agg_value222 = -1.0;
/* 2723 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2724 */           agg_isNull186 = true;
/* 2725 */         } else {
/* 2726 */           if (inputadapter_isNull12) {
/* 2727 */             agg_isNull186 = true;
/* 2728 */           } else {
/* 2729 */             agg_value222 = (double)(inputadapter_value12 / agg_value97);
/* 2730 */           }
/* 2731 */         }
/* 2732 */         boolean agg_isNull185 = agg_isNull186;
/* 2733 */         double agg_value221 = -1.0;
/* 2734 */         if (!agg_isNull186) {
/* 2735 */           agg_value221 = agg_value222;
/* 2736 */         }
/* 2737 */         if (!agg_isNull185) {
/* 2738 */           agg_isNull182 = false; // resultCode could change nullability.
/* 2739 */           agg_value218 = agg_value219 + agg_value221;
/* 2740 */
/* 2741 */         }
/* 2742 */         boolean agg_isNull181 = agg_isNull182;
/* 2743 */         double agg_value217 = agg_value218;
/* 2744 */         if (agg_isNull181) {
/* 2745 */           boolean agg_isNull188 = agg_unsafeRowAggBuffer.isNullAt(16);
/* 2746 */           double agg_value224 = agg_isNull188 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(16));
/* 2747 */           if (!agg_isNull188) {
/* 2748 */             agg_isNull181 = false;
/* 2749 */             agg_value217 = agg_value224;
/* 2750 */           }
/* 2751 */         }
/* 2752 */         boolean agg_isNull190 = true;
/* 2753 */         double agg_value226 = -1.0;
/* 2754 */
/* 2755 */         boolean agg_isNull192 = agg_unsafeRowAggBuffer.isNullAt(17);
/* 2756 */         double agg_value228 = agg_isNull192 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(17));
/* 2757 */         boolean agg_isNull191 = agg_isNull192;
/* 2758 */         double agg_value227 = agg_value228;
/* 2759 */         if (agg_isNull191) {
/* 2760 */           if (!agg_isNull63) {
/* 2761 */             agg_isNull191 = false;
/* 2762 */             agg_value227 = agg_value99;
/* 2763 */           }
/* 2764 */         }
/* 2765 */
/* 2766 */         boolean agg_isNull194 = false;
/* 2767 */         double agg_value230 = -1.0;
/* 2768 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2769 */           agg_isNull194 = true;
/* 2770 */         } else {
/* 2771 */           if (inputadapter_isNull13) {
/* 2772 */             agg_isNull194 = true;
/* 2773 */           } else {
/* 2774 */             agg_value230 = (double)(inputadapter_value13 / agg_value97);
/* 2775 */           }
/* 2776 */         }
/* 2777 */         boolean agg_isNull193 = agg_isNull194;
/* 2778 */         double agg_value229 = -1.0;
/* 2779 */         if (!agg_isNull194) {
/* 2780 */           agg_value229 = agg_value230;
/* 2781 */         }
/* 2782 */         if (!agg_isNull193) {
/* 2783 */           agg_isNull190 = false; // resultCode could change nullability.
/* 2784 */           agg_value226 = agg_value227 + agg_value229;
/* 2785 */
/* 2786 */         }
/* 2787 */         boolean agg_isNull189 = agg_isNull190;
/* 2788 */         double agg_value225 = agg_value226;
/* 2789 */         if (agg_isNull189) {
/* 2790 */           boolean agg_isNull196 = agg_unsafeRowAggBuffer.isNullAt(17);
/* 2791 */           double agg_value232 = agg_isNull196 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(17));
/* 2792 */           if (!agg_isNull196) {
/* 2793 */             agg_isNull189 = false;
/* 2794 */             agg_value225 = agg_value232;
/* 2795 */           }
/* 2796 */         }
/* 2797 */         boolean agg_isNull198 = true;
/* 2798 */         double agg_value234 = -1.0;
/* 2799 */
/* 2800 */         boolean agg_isNull200 = agg_unsafeRowAggBuffer.isNullAt(18);
/* 2801 */         double agg_value236 = agg_isNull200 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(18));
/* 2802 */         boolean agg_isNull199 = agg_isNull200;
/* 2803 */         double agg_value235 = agg_value236;
/* 2804 */         if (agg_isNull199) {
/* 2805 */           if (!agg_isNull63) {
/* 2806 */             agg_isNull199 = false;
/* 2807 */             agg_value235 = agg_value99;
/* 2808 */           }
/* 2809 */         }
/* 2810 */
/* 2811 */         boolean agg_isNull202 = false;
/* 2812 */         double agg_value238 = -1.0;
/* 2813 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2814 */           agg_isNull202 = true;
/* 2815 */         } else {
/* 2816 */           if (inputadapter_isNull14) {
/* 2817 */             agg_isNull202 = true;
/* 2818 */           } else {
/* 2819 */             agg_value238 = (double)(inputadapter_value14 / agg_value97);
/* 2820 */           }
/* 2821 */         }
/* 2822 */         boolean agg_isNull201 = agg_isNull202;
/* 2823 */         double agg_value237 = -1.0;
/* 2824 */         if (!agg_isNull202) {
/* 2825 */           agg_value237 = agg_value238;
/* 2826 */         }
/* 2827 */         if (!agg_isNull201) {
/* 2828 */           agg_isNull198 = false; // resultCode could change nullability.
/* 2829 */           agg_value234 = agg_value235 + agg_value237;
/* 2830 */
/* 2831 */         }
/* 2832 */         boolean agg_isNull197 = agg_isNull198;
/* 2833 */         double agg_value233 = agg_value234;
/* 2834 */         if (agg_isNull197) {
/* 2835 */           boolean agg_isNull204 = agg_unsafeRowAggBuffer.isNullAt(18);
/* 2836 */           double agg_value240 = agg_isNull204 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(18));
/* 2837 */           if (!agg_isNull204) {
/* 2838 */             agg_isNull197 = false;
/* 2839 */             agg_value233 = agg_value240;
/* 2840 */           }
/* 2841 */         }
/* 2842 */         boolean agg_isNull206 = true;
/* 2843 */         double agg_value242 = -1.0;
/* 2844 */
/* 2845 */         boolean agg_isNull208 = agg_unsafeRowAggBuffer.isNullAt(19);
/* 2846 */         double agg_value244 = agg_isNull208 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(19));
/* 2847 */         boolean agg_isNull207 = agg_isNull208;
/* 2848 */         double agg_value243 = agg_value244;
/* 2849 */         if (agg_isNull207) {
/* 2850 */           if (!agg_isNull63) {
/* 2851 */             agg_isNull207 = false;
/* 2852 */             agg_value243 = agg_value99;
/* 2853 */           }
/* 2854 */         }
/* 2855 */
/* 2856 */         boolean agg_isNull210 = false;
/* 2857 */         double agg_value246 = -1.0;
/* 2858 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2859 */           agg_isNull210 = true;
/* 2860 */         } else {
/* 2861 */           if (inputadapter_isNull15) {
/* 2862 */             agg_isNull210 = true;
/* 2863 */           } else {
/* 2864 */             agg_value246 = (double)(inputadapter_value15 / agg_value97);
/* 2865 */           }
/* 2866 */         }
/* 2867 */         boolean agg_isNull209 = agg_isNull210;
/* 2868 */         double agg_value245 = -1.0;
/* 2869 */         if (!agg_isNull210) {
/* 2870 */           agg_value245 = agg_value246;
/* 2871 */         }
/* 2872 */         if (!agg_isNull209) {
/* 2873 */           agg_isNull206 = false; // resultCode could change nullability.
/* 2874 */           agg_value242 = agg_value243 + agg_value245;
/* 2875 */
/* 2876 */         }
/* 2877 */         boolean agg_isNull205 = agg_isNull206;
/* 2878 */         double agg_value241 = agg_value242;
/* 2879 */         if (agg_isNull205) {
/* 2880 */           boolean agg_isNull212 = agg_unsafeRowAggBuffer.isNullAt(19);
/* 2881 */           double agg_value248 = agg_isNull212 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(19));
/* 2882 */           if (!agg_isNull212) {
/* 2883 */             agg_isNull205 = false;
/* 2884 */             agg_value241 = agg_value248;
/* 2885 */           }
/* 2886 */         }
/* 2887 */         boolean agg_isNull214 = true;
/* 2888 */         double agg_value250 = -1.0;
/* 2889 */
/* 2890 */         boolean agg_isNull216 = agg_unsafeRowAggBuffer.isNullAt(20);
/* 2891 */         double agg_value252 = agg_isNull216 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(20));
/* 2892 */         boolean agg_isNull215 = agg_isNull216;
/* 2893 */         double agg_value251 = agg_value252;
/* 2894 */         if (agg_isNull215) {
/* 2895 */           if (!agg_isNull63) {
/* 2896 */             agg_isNull215 = false;
/* 2897 */             agg_value251 = agg_value99;
/* 2898 */           }
/* 2899 */         }
/* 2900 */
/* 2901 */         boolean agg_isNull218 = false;
/* 2902 */         double agg_value254 = -1.0;
/* 2903 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2904 */           agg_isNull218 = true;
/* 2905 */         } else {
/* 2906 */           if (inputadapter_isNull16) {
/* 2907 */             agg_isNull218 = true;
/* 2908 */           } else {
/* 2909 */             agg_value254 = (double)(inputadapter_value16 / agg_value97);
/* 2910 */           }
/* 2911 */         }
/* 2912 */         boolean agg_isNull217 = agg_isNull218;
/* 2913 */         double agg_value253 = -1.0;
/* 2914 */         if (!agg_isNull218) {
/* 2915 */           agg_value253 = agg_value254;
/* 2916 */         }
/* 2917 */         if (!agg_isNull217) {
/* 2918 */           agg_isNull214 = false; // resultCode could change nullability.
/* 2919 */           agg_value250 = agg_value251 + agg_value253;
/* 2920 */
/* 2921 */         }
/* 2922 */         boolean agg_isNull213 = agg_isNull214;
/* 2923 */         double agg_value249 = agg_value250;
/* 2924 */         if (agg_isNull213) {
/* 2925 */           boolean agg_isNull220 = agg_unsafeRowAggBuffer.isNullAt(20);
/* 2926 */           double agg_value256 = agg_isNull220 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(20));
/* 2927 */           if (!agg_isNull220) {
/* 2928 */             agg_isNull213 = false;
/* 2929 */             agg_value249 = agg_value256;
/* 2930 */           }
/* 2931 */         }
/* 2932 */         boolean agg_isNull222 = true;
/* 2933 */         double agg_value258 = -1.0;
/* 2934 */
/* 2935 */         boolean agg_isNull224 = agg_unsafeRowAggBuffer.isNullAt(21);
/* 2936 */         double agg_value260 = agg_isNull224 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(21));
/* 2937 */         boolean agg_isNull223 = agg_isNull224;
/* 2938 */         double agg_value259 = agg_value260;
/* 2939 */         if (agg_isNull223) {
/* 2940 */           if (!agg_isNull63) {
/* 2941 */             agg_isNull223 = false;
/* 2942 */             agg_value259 = agg_value99;
/* 2943 */           }
/* 2944 */         }
/* 2945 */
/* 2946 */         boolean agg_isNull226 = false;
/* 2947 */         double agg_value262 = -1.0;
/* 2948 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2949 */           agg_isNull226 = true;
/* 2950 */         } else {
/* 2951 */           if (inputadapter_isNull17) {
/* 2952 */             agg_isNull226 = true;
/* 2953 */           } else {
/* 2954 */             agg_value262 = (double)(inputadapter_value17 / agg_value97);
/* 2955 */           }
/* 2956 */         }
/* 2957 */         boolean agg_isNull225 = agg_isNull226;
/* 2958 */         double agg_value261 = -1.0;
/* 2959 */         if (!agg_isNull226) {
/* 2960 */           agg_value261 = agg_value262;
/* 2961 */         }
/* 2962 */         if (!agg_isNull225) {
/* 2963 */           agg_isNull222 = false; // resultCode could change nullability.
/* 2964 */           agg_value258 = agg_value259 + agg_value261;
/* 2965 */
/* 2966 */         }
/* 2967 */         boolean agg_isNull221 = agg_isNull222;
/* 2968 */         double agg_value257 = agg_value258;
/* 2969 */         if (agg_isNull221) {
/* 2970 */           boolean agg_isNull228 = agg_unsafeRowAggBuffer.isNullAt(21);
/* 2971 */           double agg_value264 = agg_isNull228 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(21));
/* 2972 */           if (!agg_isNull228) {
/* 2973 */             agg_isNull221 = false;
/* 2974 */             agg_value257 = agg_value264;
/* 2975 */           }
/* 2976 */         }
/* 2977 */         boolean agg_isNull230 = true;
/* 2978 */         double agg_value266 = -1.0;
/* 2979 */
/* 2980 */         boolean agg_isNull232 = agg_unsafeRowAggBuffer.isNullAt(22);
/* 2981 */         double agg_value268 = agg_isNull232 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(22));
/* 2982 */         boolean agg_isNull231 = agg_isNull232;
/* 2983 */         double agg_value267 = agg_value268;
/* 2984 */         if (agg_isNull231) {
/* 2985 */           if (!agg_isNull63) {
/* 2986 */             agg_isNull231 = false;
/* 2987 */             agg_value267 = agg_value99;
/* 2988 */           }
/* 2989 */         }
/* 2990 */
/* 2991 */         boolean agg_isNull234 = false;
/* 2992 */         double agg_value270 = -1.0;
/* 2993 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2994 */           agg_isNull234 = true;
/* 2995 */         } else {
/* 2996 */           if (inputadapter_isNull18) {
/* 2997 */             agg_isNull234 = true;
/* 2998 */           } else {
/* 2999 */             agg_value270 = (double)(inputadapter_value18 / agg_value97);
/* 3000 */           }
/* 3001 */         }
/* 3002 */         boolean agg_isNull233 = agg_isNull234;
/* 3003 */         double agg_value269 = -1.0;
/* 3004 */         if (!agg_isNull234) {
/* 3005 */           agg_value269 = agg_value270;
/* 3006 */         }
/* 3007 */         if (!agg_isNull233) {
/* 3008 */           agg_isNull230 = false; // resultCode could change nullability.
/* 3009 */           agg_value266 = agg_value267 + agg_value269;
/* 3010 */
/* 3011 */         }
/* 3012 */         boolean agg_isNull229 = agg_isNull230;
/* 3013 */         double agg_value265 = agg_value266;
/* 3014 */         if (agg_isNull229) {
/* 3015 */           boolean agg_isNull236 = agg_unsafeRowAggBuffer.isNullAt(22);
/* 3016 */           double agg_value272 = agg_isNull236 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(22));
/* 3017 */           if (!agg_isNull236) {
/* 3018 */             agg_isNull229 = false;
/* 3019 */             agg_value265 = agg_value272;
/* 3020 */           }
/* 3021 */         }
/* 3022 */         boolean agg_isNull238 = true;
/* 3023 */         double agg_value274 = -1.0;
/* 3024 */
/* 3025 */         boolean agg_isNull240 = agg_unsafeRowAggBuffer.isNullAt(23);
/* 3026 */         double agg_value276 = agg_isNull240 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(23));
/* 3027 */         boolean agg_isNull239 = agg_isNull240;
/* 3028 */         double agg_value275 = agg_value276;
/* 3029 */         if (agg_isNull239) {
/* 3030 */           if (!agg_isNull63) {
/* 3031 */             agg_isNull239 = false;
/* 3032 */             agg_value275 = agg_value99;
/* 3033 */           }
/* 3034 */         }
/* 3035 */
/* 3036 */         boolean agg_isNull242 = false;
/* 3037 */         double agg_value278 = -1.0;
/* 3038 */         if (agg_isNull61 || agg_value97 == 0) {
/* 3039 */           agg_isNull242 = true;
/* 3040 */         } else {
/* 3041 */           if (inputadapter_isNull19) {
/* 3042 */             agg_isNull242 = true;
/* 3043 */           } else {
/* 3044 */             agg_value278 = (double)(inputadapter_value19 / agg_value97);
/* 3045 */           }
/* 3046 */         }
/* 3047 */         boolean agg_isNull241 = agg_isNull242;
/* 3048 */         double agg_value277 = -1.0;
/* 3049 */         if (!agg_isNull242) {
/* 3050 */           agg_value277 = agg_value278;
/* 3051 */         }
/* 3052 */         if (!agg_isNull241) {
/* 3053 */           agg_isNull238 = false; // resultCode could change nullability.
/* 3054 */           agg_value274 = agg_value275 + agg_value277;
/* 3055 */
/* 3056 */         }
/* 3057 */         boolean agg_isNull237 = agg_isNull238;
/* 3058 */         double agg_value273 = agg_value274;
/* 3059 */         if (agg_isNull237) {
/* 3060 */           boolean agg_isNull244 = agg_unsafeRowAggBuffer.isNullAt(23);
/* 3061 */           double agg_value280 = agg_isNull244 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(23));
/* 3062 */           if (!agg_isNull244) {
/* 3063 */             agg_isNull237 = false;
/* 3064 */             agg_value273 = agg_value280;
/* 3065 */           }
/* 3066 */         }
/* 3067 */         boolean agg_isNull246 = true;
/* 3068 */         double agg_value282 = -1.0;
/* 3069 */
/* 3070 */         boolean agg_isNull248 = agg_unsafeRowAggBuffer.isNullAt(24);
/* 3071 */         double agg_value284 = agg_isNull248 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(24));
/* 3072 */         boolean agg_isNull247 = agg_isNull248;
/* 3073 */         double agg_value283 = agg_value284;
/* 3074 */         if (agg_isNull247) {
/* 3075 */           if (!agg_isNull63) {
/* 3076 */             agg_isNull247 = false;
/* 3077 */             agg_value283 = agg_value99;
/* 3078 */           }
/* 3079 */         }
/* 3080 */
/* 3081 */         boolean agg_isNull249 = inputadapter_isNull20;
/* 3082 */         double agg_value285 = -1.0;
/* 3083 */         if (!inputadapter_isNull20) {
/* 3084 */           agg_value285 = inputadapter_value20;
/* 3085 */         }
/* 3086 */         if (!agg_isNull249) {
/* 3087 */           agg_isNull246 = false; // resultCode could change nullability.
/* 3088 */           agg_value282 = agg_value283 + agg_value285;
/* 3089 */
/* 3090 */         }
/* 3091 */         boolean agg_isNull245 = agg_isNull246;
/* 3092 */         double agg_value281 = agg_value282;
/* 3093 */         if (agg_isNull245) {
/* 3094 */           boolean agg_isNull251 = agg_unsafeRowAggBuffer.isNullAt(24);
/* 3095 */           double agg_value287 = agg_isNull251 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(24));
/* 3096 */           if (!agg_isNull251) {
/* 3097 */             agg_isNull245 = false;
/* 3098 */             agg_value281 = agg_value287;
/* 3099 */           }
/* 3100 */         }
/* 3101 */         boolean agg_isNull253 = true;
/* 3102 */         double agg_value289 = -1.0;
/* 3103 */
/* 3104 */         boolean agg_isNull255 = agg_unsafeRowAggBuffer.isNullAt(25);
/* 3105 */         double agg_value291 = agg_isNull255 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(25));
/* 3106 */         boolean agg_isNull254 = agg_isNull255;
/* 3107 */         double agg_value290 = agg_value291;
/* 3108 */         if (agg_isNull254) {
/* 3109 */           if (!agg_isNull63) {
/* 3110 */             agg_isNull254 = false;
/* 3111 */             agg_value290 = agg_value99;
/* 3112 */           }
/* 3113 */         }
/* 3114 */
/* 3115 */         boolean agg_isNull256 = inputadapter_isNull21;
/* 3116 */         double agg_value292 = -1.0;
/* 3117 */         if (!inputadapter_isNull21) {
/* 3118 */           agg_value292 = inputadapter_value21;
/* 3119 */         }
/* 3120 */         if (!agg_isNull256) {
/* 3121 */           agg_isNull253 = false; // resultCode could change nullability.
/* 3122 */           agg_value289 = agg_value290 + agg_value292;
/* 3123 */
/* 3124 */         }
/* 3125 */         boolean agg_isNull252 = agg_isNull253;
/* 3126 */         double agg_value288 = agg_value289;
/* 3127 */         if (agg_isNull252) {
/* 3128 */           boolean agg_isNull258 = agg_unsafeRowAggBuffer.isNullAt(25);
/* 3129 */           double agg_value294 = agg_isNull258 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(25));
/* 3130 */           if (!agg_isNull258) {
/* 3131 */             agg_isNull252 = false;
/* 3132 */             agg_value288 = agg_value294;
/* 3133 */           }
/* 3134 */         }
/* 3135 */         boolean agg_isNull260 = true;
/* 3136 */         double agg_value296 = -1.0;
/* 3137 */
/* 3138 */         boolean agg_isNull262 = agg_unsafeRowAggBuffer.isNullAt(26);
/* 3139 */         double agg_value298 = agg_isNull262 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(26));
/* 3140 */         boolean agg_isNull261 = agg_isNull262;
/* 3141 */         double agg_value297 = agg_value298;
/* 3142 */         if (agg_isNull261) {
/* 3143 */           if (!agg_isNull63) {
/* 3144 */             agg_isNull261 = false;
/* 3145 */             agg_value297 = agg_value99;
/* 3146 */           }
/* 3147 */         }
/* 3148 */
/* 3149 */         boolean agg_isNull263 = inputadapter_isNull22;
/* 3150 */         double agg_value299 = -1.0;
/* 3151 */         if (!inputadapter_isNull22) {
/* 3152 */           agg_value299 = inputadapter_value22;
/* 3153 */         }
/* 3154 */         if (!agg_isNull263) {
/* 3155 */           agg_isNull260 = false; // resultCode could change nullability.
/* 3156 */           agg_value296 = agg_value297 + agg_value299;
/* 3157 */
/* 3158 */         }
/* 3159 */         boolean agg_isNull259 = agg_isNull260;
/* 3160 */         double agg_value295 = agg_value296;
/* 3161 */         if (agg_isNull259) {
/* 3162 */           boolean agg_isNull265 = agg_unsafeRowAggBuffer.isNullAt(26);
/* 3163 */           double agg_value301 = agg_isNull265 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(26));
/* 3164 */           if (!agg_isNull265) {
/* 3165 */             agg_isNull259 = false;
/* 3166 */             agg_value295 = agg_value301;
/* 3167 */           }
/* 3168 */         }
/* 3169 */         boolean agg_isNull267 = true;
/* 3170 */         double agg_value303 = -1.0;
/* 3171 */
/* 3172 */         boolean agg_isNull269 = agg_unsafeRowAggBuffer.isNullAt(27);
/* 3173 */         double agg_value305 = agg_isNull269 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(27));
/* 3174 */         boolean agg_isNull268 = agg_isNull269;
/* 3175 */         double agg_value304 = agg_value305;
/* 3176 */         if (agg_isNull268) {
/* 3177 */           if (!agg_isNull63) {
/* 3178 */             agg_isNull268 = false;
/* 3179 */             agg_value304 = agg_value99;
/* 3180 */           }
/* 3181 */         }
/* 3182 */
/* 3183 */         boolean agg_isNull270 = inputadapter_isNull23;
/* 3184 */         double agg_value306 = -1.0;
/* 3185 */         if (!inputadapter_isNull23) {
/* 3186 */           agg_value306 = inputadapter_value23;
/* 3187 */         }
/* 3188 */         if (!agg_isNull270) {
/* 3189 */           agg_isNull267 = false; // resultCode could change nullability.
/* 3190 */           agg_value303 = agg_value304 + agg_value306;
/* 3191 */
/* 3192 */         }
/* 3193 */         boolean agg_isNull266 = agg_isNull267;
/* 3194 */         double agg_value302 = agg_value303;
/* 3195 */         if (agg_isNull266) {
/* 3196 */           boolean agg_isNull272 = agg_unsafeRowAggBuffer.isNullAt(27);
/* 3197 */           double agg_value308 = agg_isNull272 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(27));
/* 3198 */           if (!agg_isNull272) {
/* 3199 */             agg_isNull266 = false;
/* 3200 */             agg_value302 = agg_value308;
/* 3201 */           }
/* 3202 */         }
/* 3203 */         boolean agg_isNull274 = true;
/* 3204 */         double agg_value310 = -1.0;
/* 3205 */
/* 3206 */         boolean agg_isNull276 = agg_unsafeRowAggBuffer.isNullAt(28);
/* 3207 */         double agg_value312 = agg_isNull276 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(28));
/* 3208 */         boolean agg_isNull275 = agg_isNull276;
/* 3209 */         double agg_value311 = agg_value312;
/* 3210 */         if (agg_isNull275) {
/* 3211 */           if (!agg_isNull63) {
/* 3212 */             agg_isNull275 = false;
/* 3213 */             agg_value311 = agg_value99;
/* 3214 */           }
/* 3215 */         }
/* 3216 */
/* 3217 */         boolean agg_isNull277 = inputadapter_isNull24;
/* 3218 */         double agg_value313 = -1.0;
/* 3219 */         if (!inputadapter_isNull24) {
/* 3220 */           agg_value313 = inputadapter_value24;
/* 3221 */         }
/* 3222 */         if (!agg_isNull277) {
/* 3223 */           agg_isNull274 = false; // resultCode could change nullability.
/* 3224 */           agg_value310 = agg_value311 + agg_value313;
/* 3225 */
/* 3226 */         }
/* 3227 */         boolean agg_isNull273 = agg_isNull274;
/* 3228 */         double agg_value309 = agg_value310;
/* 3229 */         if (agg_isNull273) {
/* 3230 */           boolean agg_isNull279 = agg_unsafeRowAggBuffer.isNullAt(28);
/* 3231 */           double agg_value315 = agg_isNull279 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(28));
/* 3232 */           if (!agg_isNull279) {
/* 3233 */             agg_isNull273 = false;
/* 3234 */             agg_value309 = agg_value315;
/* 3235 */           }
/* 3236 */         }
/* 3237 */         boolean agg_isNull281 = true;
/* 3238 */         double agg_value317 = -1.0;
/* 3239 */
/* 3240 */         boolean agg_isNull283 = agg_unsafeRowAggBuffer.isNullAt(29);
/* 3241 */         double agg_value319 = agg_isNull283 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(29));
/* 3242 */         boolean agg_isNull282 = agg_isNull283;
/* 3243 */         double agg_value318 = agg_value319;
/* 3244 */         if (agg_isNull282) {
/* 3245 */           if (!agg_isNull63) {
/* 3246 */             agg_isNull282 = false;
/* 3247 */             agg_value318 = agg_value99;
/* 3248 */           }
/* 3249 */         }
/* 3250 */
/* 3251 */         boolean agg_isNull284 = inputadapter_isNull25;
/* 3252 */         double agg_value320 = -1.0;
/* 3253 */         if (!inputadapter_isNull25) {
/* 3254 */           agg_value320 = inputadapter_value25;
/* 3255 */         }
/* 3256 */         if (!agg_isNull284) {
/* 3257 */           agg_isNull281 = false; // resultCode could change nullability.
/* 3258 */           agg_value317 = agg_value318 + agg_value320;
/* 3259 */
/* 3260 */         }
/* 3261 */         boolean agg_isNull280 = agg_isNull281;
/* 3262 */         double agg_value316 = agg_value317;
/* 3263 */         if (agg_isNull280) {
/* 3264 */           boolean agg_isNull286 = agg_unsafeRowAggBuffer.isNullAt(29);
/* 3265 */           double agg_value322 = agg_isNull286 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(29));
/* 3266 */           if (!agg_isNull286) {
/* 3267 */             agg_isNull280 = false;
/* 3268 */             agg_value316 = agg_value322;
/* 3269 */           }
/* 3270 */         }
/* 3271 */         boolean agg_isNull288 = true;
/* 3272 */         double agg_value324 = -1.0;
/* 3273 */
/* 3274 */         boolean agg_isNull290 = agg_unsafeRowAggBuffer.isNullAt(30);
/* 3275 */         double agg_value326 = agg_isNull290 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(30));
/* 3276 */         boolean agg_isNull289 = agg_isNull290;
/* 3277 */         double agg_value325 = agg_value326;
/* 3278 */         if (agg_isNull289) {
/* 3279 */           if (!agg_isNull63) {
/* 3280 */             agg_isNull289 = false;
/* 3281 */             agg_value325 = agg_value99;
/* 3282 */           }
/* 3283 */         }
/* 3284 */
/* 3285 */         boolean agg_isNull291 = inputadapter_isNull26;
/* 3286 */         double agg_value327 = -1.0;
/* 3287 */         if (!inputadapter_isNull26) {
/* 3288 */           agg_value327 = inputadapter_value26;
/* 3289 */         }
/* 3290 */         if (!agg_isNull291) {
/* 3291 */           agg_isNull288 = false; // resultCode could change nullability.
/* 3292 */           agg_value324 = agg_value325 + agg_value327;
/* 3293 */
/* 3294 */         }
/* 3295 */         boolean agg_isNull287 = agg_isNull288;
/* 3296 */         double agg_value323 = agg_value324;
/* 3297 */         if (agg_isNull287) {
/* 3298 */           boolean agg_isNull293 = agg_unsafeRowAggBuffer.isNullAt(30);
/* 3299 */           double agg_value329 = agg_isNull293 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(30));
/* 3300 */           if (!agg_isNull293) {
/* 3301 */             agg_isNull287 = false;
/* 3302 */             agg_value323 = agg_value329;
/* 3303 */           }
/* 3304 */         }
/* 3305 */         boolean agg_isNull295 = true;
/* 3306 */         double agg_value331 = -1.0;
/* 3307 */
/* 3308 */         boolean agg_isNull297 = agg_unsafeRowAggBuffer.isNullAt(31);
/* 3309 */         double agg_value333 = agg_isNull297 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(31));
/* 3310 */         boolean agg_isNull296 = agg_isNull297;
/* 3311 */         double agg_value332 = agg_value333;
/* 3312 */         if (agg_isNull296) {
/* 3313 */           if (!agg_isNull63) {
/* 3314 */             agg_isNull296 = false;
/* 3315 */             agg_value332 = agg_value99;
/* 3316 */           }
/* 3317 */         }
/* 3318 */
/* 3319 */         boolean agg_isNull298 = inputadapter_isNull27;
/* 3320 */         double agg_value334 = -1.0;
/* 3321 */         if (!inputadapter_isNull27) {
/* 3322 */           agg_value334 = inputadapter_value27;
/* 3323 */         }
/* 3324 */         if (!agg_isNull298) {
/* 3325 */           agg_isNull295 = false; // resultCode could change nullability.
/* 3326 */           agg_value331 = agg_value332 + agg_value334;
/* 3327 */
/* 3328 */         }
/* 3329 */         boolean agg_isNull294 = agg_isNull295;
/* 3330 */         double agg_value330 = agg_value331;
/* 3331 */         if (agg_isNull294) {
/* 3332 */           boolean agg_isNull300 = agg_unsafeRowAggBuffer.isNullAt(31);
/* 3333 */           double agg_value336 = agg_isNull300 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(31));
/* 3334 */           if (!agg_isNull300) {
/* 3335 */             agg_isNull294 = false;
/* 3336 */             agg_value330 = agg_value336;
/* 3337 */           }
/* 3338 */         }
/* 3339 */         boolean agg_isNull302 = true;
/* 3340 */         double agg_value338 = -1.0;
/* 3341 */
/* 3342 */         boolean agg_isNull304 = agg_unsafeRowAggBuffer.isNullAt(32);
/* 3343 */         double agg_value340 = agg_isNull304 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(32));
/* 3344 */         boolean agg_isNull303 = agg_isNull304;
/* 3345 */         double agg_value339 = agg_value340;
/* 3346 */         if (agg_isNull303) {
/* 3347 */           if (!agg_isNull63) {
/* 3348 */             agg_isNull303 = false;
/* 3349 */             agg_value339 = agg_value99;
/* 3350 */           }
/* 3351 */         }
/* 3352 */
/* 3353 */         boolean agg_isNull305 = inputadapter_isNull28;
/* 3354 */         double agg_value341 = -1.0;
/* 3355 */         if (!inputadapter_isNull28) {
/* 3356 */           agg_value341 = inputadapter_value28;
/* 3357 */         }
/* 3358 */         if (!agg_isNull305) {
/* 3359 */           agg_isNull302 = false; // resultCode could change nullability.
/* 3360 */           agg_value338 = agg_value339 + agg_value341;
/* 3361 */
/* 3362 */         }
/* 3363 */         boolean agg_isNull301 = agg_isNull302;
/* 3364 */         double agg_value337 = agg_value338;
/* 3365 */         if (agg_isNull301) {
/* 3366 */           boolean agg_isNull307 = agg_unsafeRowAggBuffer.isNullAt(32);
/* 3367 */           double agg_value343 = agg_isNull307 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(32));
/* 3368 */           if (!agg_isNull307) {
/* 3369 */             agg_isNull301 = false;
/* 3370 */             agg_value337 = agg_value343;
/* 3371 */           }
/* 3372 */         }
/* 3373 */         boolean agg_isNull309 = true;
/* 3374 */         double agg_value345 = -1.0;
/* 3375 */
/* 3376 */         boolean agg_isNull311 = agg_unsafeRowAggBuffer.isNullAt(33);
/* 3377 */         double agg_value347 = agg_isNull311 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(33));
/* 3378 */         boolean agg_isNull310 = agg_isNull311;
/* 3379 */         double agg_value346 = agg_value347;
/* 3380 */         if (agg_isNull310) {
/* 3381 */           if (!agg_isNull63) {
/* 3382 */             agg_isNull310 = false;
/* 3383 */             agg_value346 = agg_value99;
/* 3384 */           }
/* 3385 */         }
/* 3386 */
/* 3387 */         boolean agg_isNull312 = inputadapter_isNull29;
/* 3388 */         double agg_value348 = -1.0;
/* 3389 */         if (!inputadapter_isNull29) {
/* 3390 */           agg_value348 = inputadapter_value29;
/* 3391 */         }
/* 3392 */         if (!agg_isNull312) {
/* 3393 */           agg_isNull309 = false; // resultCode could change nullability.
/* 3394 */           agg_value345 = agg_value346 + agg_value348;
/* 3395 */
/* 3396 */         }
/* 3397 */         boolean agg_isNull308 = agg_isNull309;
/* 3398 */         double agg_value344 = agg_value345;
/* 3399 */         if (agg_isNull308) {
/* 3400 */           boolean agg_isNull314 = agg_unsafeRowAggBuffer.isNullAt(33);
/* 3401 */           double agg_value350 = agg_isNull314 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(33));
/* 3402 */           if (!agg_isNull314) {
/* 3403 */             agg_isNull308 = false;
/* 3404 */             agg_value344 = agg_value350;
/* 3405 */           }
/* 3406 */         }
/* 3407 */         boolean agg_isNull316 = true;
/* 3408 */         double agg_value352 = -1.0;
/* 3409 */
/* 3410 */         boolean agg_isNull318 = agg_unsafeRowAggBuffer.isNullAt(34);
/* 3411 */         double agg_value354 = agg_isNull318 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(34));
/* 3412 */         boolean agg_isNull317 = agg_isNull318;
/* 3413 */         double agg_value353 = agg_value354;
/* 3414 */         if (agg_isNull317) {
/* 3415 */           if (!agg_isNull63) {
/* 3416 */             agg_isNull317 = false;
/* 3417 */             agg_value353 = agg_value99;
/* 3418 */           }
/* 3419 */         }
/* 3420 */
/* 3421 */         boolean agg_isNull319 = inputadapter_isNull30;
/* 3422 */         double agg_value355 = -1.0;
/* 3423 */         if (!inputadapter_isNull30) {
/* 3424 */           agg_value355 = inputadapter_value30;
/* 3425 */         }
/* 3426 */         if (!agg_isNull319) {
/* 3427 */           agg_isNull316 = false; // resultCode could change nullability.
/* 3428 */           agg_value352 = agg_value353 + agg_value355;
/* 3429 */
/* 3430 */         }
/* 3431 */         boolean agg_isNull315 = agg_isNull316;
/* 3432 */         double agg_value351 = agg_value352;
/* 3433 */         if (agg_isNull315) {
/* 3434 */           boolean agg_isNull321 = agg_unsafeRowAggBuffer.isNullAt(34);
/* 3435 */           double agg_value357 = agg_isNull321 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(34));
/* 3436 */           if (!agg_isNull321) {
/* 3437 */             agg_isNull315 = false;
/* 3438 */             agg_value351 = agg_value357;
/* 3439 */           }
/* 3440 */         }
/* 3441 */         boolean agg_isNull323 = true;
/* 3442 */         double agg_value359 = -1.0;
/* 3443 */
/* 3444 */         boolean agg_isNull325 = agg_unsafeRowAggBuffer.isNullAt(35);
/* 3445 */         double agg_value361 = agg_isNull325 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(35));
/* 3446 */         boolean agg_isNull324 = agg_isNull325;
/* 3447 */         double agg_value360 = agg_value361;
/* 3448 */         if (agg_isNull324) {
/* 3449 */           if (!agg_isNull63) {
/* 3450 */             agg_isNull324 = false;
/* 3451 */             agg_value360 = agg_value99;
/* 3452 */           }
/* 3453 */         }
/* 3454 */
/* 3455 */         boolean agg_isNull326 = inputadapter_isNull31;
/* 3456 */         double agg_value362 = -1.0;
/* 3457 */         if (!inputadapter_isNull31) {
/* 3458 */           agg_value362 = inputadapter_value31;
/* 3459 */         }
/* 3460 */         if (!agg_isNull326) {
/* 3461 */           agg_isNull323 = false; // resultCode could change nullability.
/* 3462 */           agg_value359 = agg_value360 + agg_value362;
/* 3463 */
/* 3464 */         }
/* 3465 */         boolean agg_isNull322 = agg_isNull323;
/* 3466 */         double agg_value358 = agg_value359;
/* 3467 */         if (agg_isNull322) {
/* 3468 */           boolean agg_isNull328 = agg_unsafeRowAggBuffer.isNullAt(35);
/* 3469 */           double agg_value364 = agg_isNull328 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(35));
/* 3470 */           if (!agg_isNull328) {
/* 3471 */             agg_isNull322 = false;
/* 3472 */             agg_value358 = agg_value364;
/* 3473 */           }
/* 3474 */         }
/* 3475 */         // update unsafe row buffer
/* 3476 */         if (!agg_isNull65) {
/* 3477 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value101);
/* 3478 */         } else {
/* 3479 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 3480 */         }
/* 3481 */
/* 3482 */         if (!agg_isNull72) {
/* 3483 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value108);
/* 3484 */         } else {
/* 3485 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 3486 */         }
/* 3487 */
/* 3488 */         if (!agg_isNull79) {
/* 3489 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value115);
/* 3490 */         } else {
/* 3491 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 3492 */         }
/* 3493 */
/* 3494 */         if (!agg_isNull86) {
/* 3495 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value122);
/* 3496 */         } else {
/* 3497 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 3498 */         }
/* 3499 */
/* 3500 */         if (!agg_isNull93) {
/* 3501 */           agg_unsafeRowAggBuffer.setDouble(4, agg_value129);
/* 3502 */         } else {
/* 3503 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 3504 */         }
/* 3505 */
/* 3506 */         if (!agg_isNull100) {
/* 3507 */           agg_unsafeRowAggBuffer.setDouble(5, agg_value136);
/* 3508 */         } else {
/* 3509 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 3510 */         }
/* 3511 */
/* 3512 */         if (!agg_isNull107) {
/* 3513 */           agg_unsafeRowAggBuffer.setDouble(6, agg_value143);
/* 3514 */         } else {
/* 3515 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 3516 */         }
/* 3517 */
/* 3518 */         if (!agg_isNull114) {
/* 3519 */           agg_unsafeRowAggBuffer.setDouble(7, agg_value150);
/* 3520 */         } else {
/* 3521 */           agg_unsafeRowAggBuffer.setNullAt(7);
/* 3522 */         }
/* 3523 */
/* 3524 */         if (!agg_isNull121) {
/* 3525 */           agg_unsafeRowAggBuffer.setDouble(8, agg_value157);
/* 3526 */         } else {
/* 3527 */           agg_unsafeRowAggBuffer.setNullAt(8);
/* 3528 */         }
/* 3529 */
/* 3530 */         if (!agg_isNull128) {
/* 3531 */           agg_unsafeRowAggBuffer.setDouble(9, agg_value164);
/* 3532 */         } else {
/* 3533 */           agg_unsafeRowAggBuffer.setNullAt(9);
/* 3534 */         }
/* 3535 */
/* 3536 */         if (!agg_isNull135) {
/* 3537 */           agg_unsafeRowAggBuffer.setDouble(10, agg_value171);
/* 3538 */         } else {
/* 3539 */           agg_unsafeRowAggBuffer.setNullAt(10);
/* 3540 */         }
/* 3541 */
/* 3542 */         if (!agg_isNull142) {
/* 3543 */           agg_unsafeRowAggBuffer.setDouble(11, agg_value178);
/* 3544 */         } else {
/* 3545 */           agg_unsafeRowAggBuffer.setNullAt(11);
/* 3546 */         }
/* 3547 */
/* 3548 */         if (!agg_isNull149) {
/* 3549 */           agg_unsafeRowAggBuffer.setDouble(12, agg_value185);
/* 3550 */         } else {
/* 3551 */           agg_unsafeRowAggBuffer.setNullAt(12);
/* 3552 */         }
/* 3553 */
/* 3554 */         if (!agg_isNull157) {
/* 3555 */           agg_unsafeRowAggBuffer.setDouble(13, agg_value193);
/* 3556 */         } else {
/* 3557 */           agg_unsafeRowAggBuffer.setNullAt(13);
/* 3558 */         }
/* 3559 */
/* 3560 */         if (!agg_isNull165) {
/* 3561 */           agg_unsafeRowAggBuffer.setDouble(14, agg_value201);
/* 3562 */         } else {
/* 3563 */           agg_unsafeRowAggBuffer.setNullAt(14);
/* 3564 */         }
/* 3565 */
/* 3566 */         if (!agg_isNull173) {
/* 3567 */           agg_unsafeRowAggBuffer.setDouble(15, agg_value209);
/* 3568 */         } else {
/* 3569 */           agg_unsafeRowAggBuffer.setNullAt(15);
/* 3570 */         }
/* 3571 */
/* 3572 */         if (!agg_isNull181) {
/* 3573 */           agg_unsafeRowAggBuffer.setDouble(16, agg_value217);
/* 3574 */         } else {
/* 3575 */           agg_unsafeRowAggBuffer.setNullAt(16);
/* 3576 */         }
/* 3577 */
/* 3578 */         if (!agg_isNull189) {
/* 3579 */           agg_unsafeRowAggBuffer.setDouble(17, agg_value225);
/* 3580 */         } else {
/* 3581 */           agg_unsafeRowAggBuffer.setNullAt(17);
/* 3582 */         }
/* 3583 */
/* 3584 */         if (!agg_isNull197) {
/* 3585 */           agg_unsafeRowAggBuffer.setDouble(18, agg_value233);
/* 3586 */         } else {
/* 3587 */           agg_unsafeRowAggBuffer.setNullAt(18);
/* 3588 */         }
/* 3589 */
/* 3590 */         if (!agg_isNull205) {
/* 3591 */           agg_unsafeRowAggBuffer.setDouble(19, agg_value241);
/* 3592 */         } else {
/* 3593 */           agg_unsafeRowAggBuffer.setNullAt(19);
/* 3594 */         }
/* 3595 */
/* 3596 */         if (!agg_isNull213) {
/* 3597 */           agg_unsafeRowAggBuffer.setDouble(20, agg_value249);
/* 3598 */         } else {
/* 3599 */           agg_unsafeRowAggBuffer.setNullAt(20);
/* 3600 */         }
/* 3601 */
/* 3602 */         if (!agg_isNull221) {
/* 3603 */           agg_unsafeRowAggBuffer.setDouble(21, agg_value257);
/* 3604 */         } else {
/* 3605 */           agg_unsafeRowAggBuffer.setNullAt(21);
/* 3606 */         }
/* 3607 */
/* 3608 */         if (!agg_isNull229) {
/* 3609 */           agg_unsafeRowAggBuffer.setDouble(22, agg_value265);
/* 3610 */         } else {
/* 3611 */           agg_unsafeRowAggBuffer.setNullAt(22);
/* 3612 */         }
/* 3613 */
/* 3614 */         if (!agg_isNull237) {
/* 3615 */           agg_unsafeRowAggBuffer.setDouble(23, agg_value273);
/* 3616 */         } else {
/* 3617 */           agg_unsafeRowAggBuffer.setNullAt(23);
/* 3618 */         }
/* 3619 */
/* 3620 */         if (!agg_isNull245) {
/* 3621 */           agg_unsafeRowAggBuffer.setDouble(24, agg_value281);
/* 3622 */         } else {
/* 3623 */           agg_unsafeRowAggBuffer.setNullAt(24);
/* 3624 */         }
/* 3625 */
/* 3626 */         if (!agg_isNull252) {
/* 3627 */           agg_unsafeRowAggBuffer.setDouble(25, agg_value288);
/* 3628 */         } else {
/* 3629 */           agg_unsafeRowAggBuffer.setNullAt(25);
/* 3630 */         }
/* 3631 */
/* 3632 */         if (!agg_isNull259) {
/* 3633 */           agg_unsafeRowAggBuffer.setDouble(26, agg_value295);
/* 3634 */         } else {
/* 3635 */           agg_unsafeRowAggBuffer.setNullAt(26);
/* 3636 */         }
/* 3637 */
/* 3638 */         if (!agg_isNull266) {
/* 3639 */           agg_unsafeRowAggBuffer.setDouble(27, agg_value302);
/* 3640 */         } else {
/* 3641 */           agg_unsafeRowAggBuffer.setNullAt(27);
/* 3642 */         }
/* 3643 */
/* 3644 */         if (!agg_isNull273) {
/* 3645 */           agg_unsafeRowAggBuffer.setDouble(28, agg_value309);
/* 3646 */         } else {
/* 3647 */           agg_unsafeRowAggBuffer.setNullAt(28);
/* 3648 */         }
/* 3649 */
/* 3650 */         if (!agg_isNull280) {
/* 3651 */           agg_unsafeRowAggBuffer.setDouble(29, agg_value316);
/* 3652 */         } else {
/* 3653 */           agg_unsafeRowAggBuffer.setNullAt(29);
/* 3654 */         }
/* 3655 */
/* 3656 */         if (!agg_isNull287) {
/* 3657 */           agg_unsafeRowAggBuffer.setDouble(30, agg_value323);
/* 3658 */         } else {
/* 3659 */           agg_unsafeRowAggBuffer.setNullAt(30);
/* 3660 */         }
/* 3661 */
/* 3662 */         if (!agg_isNull294) {
/* 3663 */           agg_unsafeRowAggBuffer.setDouble(31, agg_value330);
/* 3664 */         } else {
/* 3665 */           agg_unsafeRowAggBuffer.setNullAt(31);
/* 3666 */         }
/* 3667 */
/* 3668 */         if (!agg_isNull301) {
/* 3669 */           agg_unsafeRowAggBuffer.setDouble(32, agg_value337);
/* 3670 */         } else {
/* 3671 */           agg_unsafeRowAggBuffer.setNullAt(32);
/* 3672 */         }
/* 3673 */
/* 3674 */         if (!agg_isNull308) {
/* 3675 */           agg_unsafeRowAggBuffer.setDouble(33, agg_value344);
/* 3676 */         } else {
/* 3677 */           agg_unsafeRowAggBuffer.setNullAt(33);
/* 3678 */         }
/* 3679 */
/* 3680 */         if (!agg_isNull315) {
/* 3681 */           agg_unsafeRowAggBuffer.setDouble(34, agg_value351);
/* 3682 */         } else {
/* 3683 */           agg_unsafeRowAggBuffer.setNullAt(34);
/* 3684 */         }
/* 3685 */
/* 3686 */         if (!agg_isNull322) {
/* 3687 */           agg_unsafeRowAggBuffer.setDouble(35, agg_value358);
/* 3688 */         } else {
/* 3689 */           agg_unsafeRowAggBuffer.setNullAt(35);
/* 3690 */         }
/* 3691 */
/* 3692 */       }
/* 3693 */       if (shouldStop()) return;
/* 3694 */     }
/* 3695 */
/* 3696 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 3697 */
/* 3698 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 3699 */   }
/* 3700 */
/* 3701 */   protected void processNext() throws java.io.IOException {
/* 3702 */     if (!agg_initAgg) {
/* 3703 */       agg_initAgg = true;
/* 3704 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 3705 */       agg_doAggregateWithKeys();
/* 3706 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 3707 */     }
/* 3708 */
/* 3709 */     // output the result
/* 3710 */
/* 3711 */     while (agg_fastHashMapIter.next()) {
/* 3712 */       wholestagecodegen_numOutputRows.add(1);
/* 3713 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 3714 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 3715 */
/* 3716 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 3717 */
/* 3718 */       append(agg_resultRow);
/* 3719 */
/* 3720 */       if (shouldStop()) return;
/* 3721 */     }
/* 3722 */     agg_fastHashMap.close();
/* 3723 */
/* 3724 */     while (agg_mapIter.next()) {
/* 3725 */       wholestagecodegen_numOutputRows.add(1);
/* 3726 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 3727 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 3728 */
/* 3729 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 3730 */
/* 3731 */       append(agg_resultRow);
/* 3732 */
/* 3733 */       if (shouldStop()) return;
/* 3734 */     }
/* 3735 */
/* 3736 */     agg_mapIter.close();
/* 3737 */     if (agg_sorter == null) {
/* 3738 */       agg_hashMap.free();
/* 3739 */     }
/* 3740 */   }
/* 3741 */ }
