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
/* 013 */   private scala.collection.Iterator scan_input;
/* 014 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 015 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 016 */   private long scan_scanTime1;
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 018 */   private int scan_batchIdx;
/* 019 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 020 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 021 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 022 */   private UnsafeRow scan_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 026 */   private UnsafeRow filter_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 029 */   private UnsafeRow project_result;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 034 */   private UnsafeRow agg_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 037 */
/* 038 */   public GeneratedIterator(Object[] references) {
/* 039 */     this.references = references;
/* 040 */   }
/* 041 */
/* 042 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 043 */     partitionIndex = index;
/* 044 */     this.inputs = inputs;
/* 045 */     wholestagecodegen_init_0();
/* 046 */     wholestagecodegen_init_1();
/* 047 */
/* 048 */   }
/* 049 */
/* 050 */   private void wholestagecodegen_init_0() {
/* 051 */     agg_initAgg = false;
/* 052 */
/* 053 */     scan_input = inputs[0];
/* 054 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 055 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 056 */     scan_scanTime1 = 0;
/* 057 */     scan_batch = null;
/* 058 */     scan_batchIdx = 0;
/* 059 */     scan_colInstance0 = null;
/* 060 */     scan_colInstance1 = null;
/* 061 */     scan_colInstance2 = null;
/* 062 */     scan_result = new UnsafeRow(3);
/* 063 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 064 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 065 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 066 */     filter_result = new UnsafeRow(3);
/* 067 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 068 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 069 */     project_result = new UnsafeRow(1);
/* 070 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 071 */
/* 072 */   }
/* 073 */
/* 074 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 075 */     // initialize aggregation buffer
/* 076 */     boolean agg_isNull = false;
/* 077 */     double agg_value = -1.0;
/* 078 */     if (!false) {
/* 079 */       agg_value = (double) 0;
/* 080 */     }
/* 081 */     agg_bufIsNull = agg_isNull;
/* 082 */     agg_bufValue = agg_value;
/* 083 */     agg_bufIsNull1 = false;
/* 084 */     agg_bufValue1 = 0L;
/* 085 */
/* 086 */     if (scan_batch == null) {
/* 087 */       scan_nextBatch();
/* 088 */     }
/* 089 */     while (scan_batch != null) {
/* 090 */       int scan_numRows = scan_batch.numRows();
/* 091 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 092 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 093 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 094 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 095 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 096 */
/* 097 */         if (!(!(scan_isNull))) continue;
/* 098 */
/* 099 */         boolean filter_isNull2 = false;
/* 100 */
/* 101 */         boolean filter_value2 = false;
/* 102 */         filter_value2 = scan_value >= 41;
/* 103 */         if (!filter_value2) continue;
/* 104 */         boolean filter_isNull5 = false;
/* 105 */
/* 106 */         boolean filter_value5 = false;
/* 107 */         filter_value5 = scan_value <= 60;
/* 108 */         if (!filter_value5) continue;
/* 109 */
/* 110 */         filter_numOutputRows.add(1);
/* 111 */
/* 112 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 113 */         double scan_value1 = scan_isNull1 ? -1.0 : (scan_colInstance1.getDouble(scan_rowIdx));
/* 114 */
/* 115 */         // do aggregate
/* 116 */         // common sub-expressions
/* 117 */
/* 118 */         // evaluate aggregate function
/* 119 */         boolean agg_isNull3 = true;
/* 120 */         double agg_value3 = -1.0;
/* 121 */
/* 122 */         if (!agg_bufIsNull) {
/* 123 */           boolean agg_isNull5 = scan_isNull1;
/* 124 */           double agg_value5 = scan_value1;
/* 125 */           if (agg_isNull5) {
/* 126 */             boolean agg_isNull7 = false;
/* 127 */             double agg_value7 = -1.0;
/* 128 */             if (!false) {
/* 129 */               agg_value7 = (double) 0;
/* 130 */             }
/* 131 */             if (!agg_isNull7) {
/* 132 */               agg_isNull5 = false;
/* 133 */               agg_value5 = agg_value7;
/* 134 */             }
/* 135 */           }
/* 136 */
/* 137 */           agg_isNull3 = false; // resultCode could change nullability.
/* 138 */           agg_value3 = agg_bufValue + agg_value5;
/* 139 */
/* 140 */         }
/* 141 */         boolean agg_isNull9 = false;
/* 142 */         long agg_value9 = -1L;
/* 143 */         if (!false && scan_isNull1) {
/* 144 */           agg_isNull9 = agg_bufIsNull1;
/* 145 */           agg_value9 = agg_bufValue1;
/* 146 */         } else {
/* 147 */           boolean agg_isNull13 = true;
/* 148 */           long agg_value13 = -1L;
/* 149 */
/* 150 */           if (!agg_bufIsNull1) {
/* 151 */             agg_isNull13 = false; // resultCode could change nullability.
/* 152 */             agg_value13 = agg_bufValue1 + 1L;
/* 153 */
/* 154 */           }
/* 155 */           agg_isNull9 = agg_isNull13;
/* 156 */           agg_value9 = agg_value13;
/* 157 */         }
/* 158 */         // update aggregation buffer
/* 159 */         agg_bufIsNull = agg_isNull3;
/* 160 */         agg_bufValue = agg_value3;
/* 161 */
/* 162 */         agg_bufIsNull1 = agg_isNull9;
/* 163 */         agg_bufValue1 = agg_value9;
/* 164 */         // shouldStop check is eliminated
/* 165 */       }
/* 166 */       scan_batchIdx = scan_numRows;
/* 167 */       scan_batch = null;
/* 168 */       scan_nextBatch();
/* 169 */     }
/* 170 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 171 */     scan_scanTime1 = 0;
/* 172 */
/* 173 */   }
/* 174 */
/* 175 */   private void scan_nextBatch() throws java.io.IOException {
/* 176 */     long getBatchStart = System.nanoTime();
/* 177 */     if (scan_input.hasNext()) {
/* 178 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 179 */       scan_numOutputRows.add(scan_batch.numRows());
/* 180 */       scan_batchIdx = 0;
/* 181 */       scan_colInstance0 = scan_batch.column(0);
/* 182 */       scan_colInstance1 = scan_batch.column(1);
/* 183 */       scan_colInstance2 = scan_batch.column(2);
/* 184 */
/* 185 */     }
/* 186 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 187 */   }
/* 188 */
/* 189 */   private void wholestagecodegen_init_1() {
/* 190 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 191 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 192 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 193 */     agg_result = new UnsafeRow(2);
/* 194 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 195 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 196 */
/* 197 */   }
/* 198 */
/* 199 */   protected void processNext() throws java.io.IOException {
/* 200 */     while (!agg_initAgg) {
/* 201 */       agg_initAgg = true;
/* 202 */       long agg_beforeAgg = System.nanoTime();
/* 203 */       agg_doAggregateWithoutKey();
/* 204 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 205 */
/* 206 */       // output the result
/* 207 */
/* 208 */       agg_numOutputRows.add(1);
/* 209 */       agg_rowWriter.zeroOutNullBytes();
/* 210 */
/* 211 */       if (agg_bufIsNull) {
/* 212 */         agg_rowWriter.setNullAt(0);
/* 213 */       } else {
/* 214 */         agg_rowWriter.write(0, agg_bufValue);
/* 215 */       }
/* 216 */
/* 217 */       if (agg_bufIsNull1) {
/* 218 */         agg_rowWriter.setNullAt(1);
/* 219 */       } else {
/* 220 */         agg_rowWriter.write(1, agg_bufValue1);
/* 221 */       }
/* 222 */       append(agg_result);
/* 223 */     }
/* 224 */   }
/* 225 */ }
