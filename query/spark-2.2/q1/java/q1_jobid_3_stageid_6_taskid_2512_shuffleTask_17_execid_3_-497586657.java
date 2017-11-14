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
/* 012 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 013 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 014 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 015 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 017 */   private scala.collection.Iterator inputadapter_input;
/* 018 */   private UnsafeRow agg_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 021 */   private int agg_value6;
/* 022 */   private UnsafeRow agg_result1;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 026 */   private UnsafeRow filter_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 031 */
/* 032 */   public GeneratedIterator(Object[] references) {
/* 033 */     this.references = references;
/* 034 */   }
/* 035 */
/* 036 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 037 */     partitionIndex = index;
/* 038 */     this.inputs = inputs;
/* 039 */     wholestagecodegen_init_0();
/* 040 */     wholestagecodegen_init_1();
/* 041 */
/* 042 */   }
/* 043 */
/* 044 */   private void wholestagecodegen_init_0() {
/* 045 */     agg_initAgg = false;
/* 046 */
/* 047 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 048 */
/* 049 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 050 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 051 */     inputadapter_input = inputs[0];
/* 052 */     agg_result = new UnsafeRow(2);
/* 053 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 054 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 055 */
/* 056 */     agg_result1 = new UnsafeRow(3);
/* 057 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 058 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
/* 059 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 060 */     filter_result = new UnsafeRow(3);
/* 061 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 066 */     agg_hashMap = agg_plan.createHashMap();
/* 067 */
/* 068 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 069 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 070 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 071 */       long inputadapter_value = inputadapter_isNull ? -1L : (inputadapter_row.getLong(0));
/* 072 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 073 */       long inputadapter_value1 = inputadapter_isNull1 ? -1L : (inputadapter_row.getLong(1));
/* 074 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 075 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 076 */
/* 077 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 078 */
/* 079 */       UnsafeRow agg_fastAggBuffer = null;
/* 080 */
/* 081 */       if (agg_fastAggBuffer == null) {
/* 082 */         // generate grouping key
/* 083 */         agg_rowWriter.zeroOutNullBytes();
/* 084 */
/* 085 */         if (inputadapter_isNull) {
/* 086 */           agg_rowWriter.setNullAt(0);
/* 087 */         } else {
/* 088 */           agg_rowWriter.write(0, inputadapter_value);
/* 089 */         }
/* 090 */
/* 091 */         if (inputadapter_isNull1) {
/* 092 */           agg_rowWriter.setNullAt(1);
/* 093 */         } else {
/* 094 */           agg_rowWriter.write(1, inputadapter_value1);
/* 095 */         }
/* 096 */         agg_value6 = 42;
/* 097 */
/* 098 */         if (!inputadapter_isNull) {
/* 099 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(inputadapter_value, agg_value6);
/* 100 */         }
/* 101 */
/* 102 */         if (!inputadapter_isNull1) {
/* 103 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(inputadapter_value1, agg_value6);
/* 104 */         }
/* 105 */         if (true) {
/* 106 */           // try to get the buffer from hash map
/* 107 */           agg_unsafeRowAggBuffer =
/* 108 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 109 */         }
/* 110 */         if (agg_unsafeRowAggBuffer == null) {
/* 111 */           if (agg_sorter == null) {
/* 112 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 113 */           } else {
/* 114 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 115 */           }
/* 116 */
/* 117 */           // the hash map had be spilled, it should have enough memory now,
/* 118 */           // try  to allocate buffer again.
/* 119 */           agg_unsafeRowAggBuffer =
/* 120 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 121 */           if (agg_unsafeRowAggBuffer == null) {
/* 122 */             // failed to allocate the first page
/* 123 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 124 */           }
/* 125 */         }
/* 126 */       }
/* 127 */
/* 128 */       if (agg_fastAggBuffer != null) {
/* 129 */         // update fast row
/* 130 */
/* 131 */       } else {
/* 132 */         // update unsafe row
/* 133 */
/* 134 */         // common sub-expressions
/* 135 */
/* 136 */         // evaluate aggregate function
/* 137 */         boolean agg_isNull9 = true;
/* 138 */         double agg_value10 = -1.0;
/* 139 */
/* 140 */         boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 141 */         double agg_value12 = agg_isNull11 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 142 */         boolean agg_isNull10 = agg_isNull11;
/* 143 */         double agg_value11 = agg_value12;
/* 144 */         if (agg_isNull10) {
/* 145 */           boolean agg_isNull12 = false;
/* 146 */           double agg_value13 = -1.0;
/* 147 */           if (!false) {
/* 148 */             agg_value13 = (double) 0;
/* 149 */           }
/* 150 */           if (!agg_isNull12) {
/* 151 */             agg_isNull10 = false;
/* 152 */             agg_value11 = agg_value13;
/* 153 */           }
/* 154 */         }
/* 155 */
/* 156 */         if (!inputadapter_isNull2) {
/* 157 */           agg_isNull9 = false; // resultCode could change nullability.
/* 158 */           agg_value10 = agg_value11 + inputadapter_value2;
/* 159 */
/* 160 */         }
/* 161 */         boolean agg_isNull8 = agg_isNull9;
/* 162 */         double agg_value9 = agg_value10;
/* 163 */         if (agg_isNull8) {
/* 164 */           boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 165 */           double agg_value16 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 166 */           if (!agg_isNull15) {
/* 167 */             agg_isNull8 = false;
/* 168 */             agg_value9 = agg_value16;
/* 169 */           }
/* 170 */         }
/* 171 */         // update unsafe row buffer
/* 172 */         if (!agg_isNull8) {
/* 173 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 174 */         } else {
/* 175 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 176 */         }
/* 177 */
/* 178 */       }
/* 179 */       if (shouldStop()) return;
/* 180 */     }
/* 181 */
/* 182 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 183 */   }
/* 184 */
/* 185 */   private void wholestagecodegen_init_1() {
/* 186 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 187 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 188 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 189 */
/* 190 */   }
/* 191 */
/* 192 */   protected void processNext() throws java.io.IOException {
/* 193 */     if (!agg_initAgg) {
/* 194 */       agg_initAgg = true;
/* 195 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 196 */       agg_doAggregateWithKeys();
/* 197 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 198 */     }
/* 199 */
/* 200 */     // output the result
/* 201 */
/* 202 */     while (agg_mapIter.next()) {
/* 203 */       wholestagecodegen_numOutputRows.add(1);
/* 204 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 205 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 206 */
/* 207 */       boolean agg_isNull16 = agg_aggKey.isNullAt(0);
/* 208 */       long agg_value17 = agg_isNull16 ? -1L : (agg_aggKey.getLong(0));
/* 209 */       boolean agg_isNull17 = agg_aggKey.isNullAt(1);
/* 210 */       long agg_value18 = agg_isNull17 ? -1L : (agg_aggKey.getLong(1));
/* 211 */       boolean agg_isNull18 = agg_aggBuffer.isNullAt(0);
/* 212 */       double agg_value19 = agg_isNull18 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 213 */
/* 214 */       if (!(!(agg_isNull18))) continue;
/* 215 */
/* 216 */       filter_numOutputRows.add(1);
/* 217 */
/* 218 */       filter_rowWriter.zeroOutNullBytes();
/* 219 */
/* 220 */       if (agg_isNull16) {
/* 221 */         filter_rowWriter.setNullAt(0);
/* 222 */       } else {
/* 223 */         filter_rowWriter.write(0, agg_value17);
/* 224 */       }
/* 225 */
/* 226 */       if (agg_isNull17) {
/* 227 */         filter_rowWriter.setNullAt(1);
/* 228 */       } else {
/* 229 */         filter_rowWriter.write(1, agg_value18);
/* 230 */       }
/* 231 */
/* 232 */       filter_rowWriter.write(2, agg_value19);
/* 233 */       append(filter_result);
/* 234 */
/* 235 */       if (shouldStop()) return;
/* 236 */     }
/* 237 */
/* 238 */     agg_mapIter.close();
/* 239 */     if (agg_sorter == null) {
/* 240 */       agg_hashMap.free();
/* 241 */     }
/* 242 */   }
/* 243 */ }
