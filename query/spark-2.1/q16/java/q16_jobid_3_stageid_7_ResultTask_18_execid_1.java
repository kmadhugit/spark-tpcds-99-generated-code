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
/* 014 */   private long agg_bufValue2;
/* 015 */   private scala.collection.Iterator inputadapter_input;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 018 */   private UnsafeRow agg_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 021 */
/* 022 */   public GeneratedIterator(Object[] references) {
/* 023 */     this.references = references;
/* 024 */   }
/* 025 */
/* 026 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 027 */     partitionIndex = index;
/* 028 */     this.inputs = inputs;
/* 029 */     agg_initAgg = false;
/* 030 */
/* 031 */     inputadapter_input = inputs[0];
/* 032 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 033 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 034 */     agg_result = new UnsafeRow(3);
/* 035 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 036 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 037 */
/* 038 */   }
/* 039 */
/* 040 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 041 */     // initialize aggregation buffer
/* 042 */     final double agg_value = -1.0;
/* 043 */     agg_bufIsNull = true;
/* 044 */     agg_bufValue = agg_value;
/* 045 */     final double agg_value1 = -1.0;
/* 046 */     agg_bufIsNull1 = true;
/* 047 */     agg_bufValue1 = agg_value1;
/* 048 */     agg_bufIsNull2 = false;
/* 049 */     agg_bufValue2 = 0L;
/* 050 */
/* 051 */     while (inputadapter_input.hasNext()) {
/* 052 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 053 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 054 */       double inputadapter_value = inputadapter_isNull ? -1.0 : (inputadapter_row.getDouble(0));
/* 055 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 056 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 057 */       long inputadapter_value2 = inputadapter_row.getLong(2);
/* 058 */
/* 059 */       // do aggregate
/* 060 */       // common sub-expressions
/* 061 */       boolean agg_isNull9 = false;
/* 062 */       double agg_value9 = -1.0;
/* 063 */       if (!false) {
/* 064 */         agg_value9 = (double) 0;
/* 065 */       }
/* 066 */       // evaluate aggregate function
/* 067 */       boolean agg_isNull12 = true;
/* 068 */       double agg_value12 = -1.0;
/* 069 */
/* 070 */       boolean agg_isNull13 = agg_bufIsNull;
/* 071 */       double agg_value13 = agg_bufValue;
/* 072 */       if (agg_isNull13) {
/* 073 */         if (!agg_isNull9) {
/* 074 */           agg_isNull13 = false;
/* 075 */           agg_value13 = agg_value9;
/* 076 */         }
/* 077 */       }
/* 078 */
/* 079 */       if (!inputadapter_isNull) {
/* 080 */         agg_isNull12 = false; // resultCode could change nullability.
/* 081 */         agg_value12 = agg_value13 + inputadapter_value;
/* 082 */
/* 083 */       }
/* 084 */       boolean agg_isNull11 = agg_isNull12;
/* 085 */       double agg_value11 = agg_value12;
/* 086 */       if (agg_isNull11) {
/* 087 */         if (!agg_bufIsNull) {
/* 088 */           agg_isNull11 = false;
/* 089 */           agg_value11 = agg_bufValue;
/* 090 */         }
/* 091 */       }
/* 092 */       boolean agg_isNull18 = true;
/* 093 */       double agg_value18 = -1.0;
/* 094 */
/* 095 */       boolean agg_isNull19 = agg_bufIsNull1;
/* 096 */       double agg_value19 = agg_bufValue1;
/* 097 */       if (agg_isNull19) {
/* 098 */         if (!agg_isNull9) {
/* 099 */           agg_isNull19 = false;
/* 100 */           agg_value19 = agg_value9;
/* 101 */         }
/* 102 */       }
/* 103 */
/* 104 */       if (!inputadapter_isNull1) {
/* 105 */         agg_isNull18 = false; // resultCode could change nullability.
/* 106 */         agg_value18 = agg_value19 + inputadapter_value1;
/* 107 */
/* 108 */       }
/* 109 */       boolean agg_isNull17 = agg_isNull18;
/* 110 */       double agg_value17 = agg_value18;
/* 111 */       if (agg_isNull17) {
/* 112 */         if (!agg_bufIsNull1) {
/* 113 */           agg_isNull17 = false;
/* 114 */           agg_value17 = agg_bufValue1;
/* 115 */         }
/* 116 */       }
/* 117 */       boolean agg_isNull23 = false;
/* 118 */
/* 119 */       long agg_value23 = -1L;
/* 120 */       agg_value23 = agg_bufValue2 + inputadapter_value2;
/* 121 */       // update aggregation buffer
/* 122 */       agg_bufIsNull = agg_isNull11;
/* 123 */       agg_bufValue = agg_value11;
/* 124 */
/* 125 */       agg_bufIsNull1 = agg_isNull17;
/* 126 */       agg_bufValue1 = agg_value17;
/* 127 */
/* 128 */       agg_bufIsNull2 = false;
/* 129 */       agg_bufValue2 = agg_value23;
/* 130 */       if (shouldStop()) return;
/* 131 */     }
/* 132 */
/* 133 */   }
/* 134 */
/* 135 */   protected void processNext() throws java.io.IOException {
/* 136 */     while (!agg_initAgg) {
/* 137 */       agg_initAgg = true;
/* 138 */       long agg_beforeAgg = System.nanoTime();
/* 139 */       agg_doAggregateWithoutKey();
/* 140 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 141 */
/* 142 */       // output the result
/* 143 */
/* 144 */       agg_numOutputRows.add(1);
/* 145 */       agg_rowWriter.zeroOutNullBytes();
/* 146 */
/* 147 */       if (agg_bufIsNull2) {
/* 148 */         agg_rowWriter.setNullAt(0);
/* 149 */       } else {
/* 150 */         agg_rowWriter.write(0, agg_bufValue2);
/* 151 */       }
/* 152 */
/* 153 */       if (agg_bufIsNull) {
/* 154 */         agg_rowWriter.setNullAt(1);
/* 155 */       } else {
/* 156 */         agg_rowWriter.write(1, agg_bufValue);
/* 157 */       }
/* 158 */
/* 159 */       if (agg_bufIsNull1) {
/* 160 */         agg_rowWriter.setNullAt(2);
/* 161 */       } else {
/* 162 */         agg_rowWriter.write(2, agg_bufValue1);
/* 163 */       }
/* 164 */       append(agg_result);
/* 165 */     }
/* 166 */   }
/* 167 */ }
